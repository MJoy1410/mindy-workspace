# Question 6: AI in Coding

## A. English Answer

This answer applies role prompting, instructional prompting, explicit context, a verifiable review procedure, and a fixed output format. These elements reduce ambiguity and make the AI's response easier to check.

---

## Scenario A — `RegistrationService.java` (0.5 points)

### A1. AI Prompt for Code Review (0.2 points)

````text
Role: You are a senior Java/Spring Boot code reviewer.

Context: In a Course Registration System, this method should enroll a student only if the prerequisite is completed and a seat is available, then update the course state and save the registration.

Goal: Find the three logical or semantic bugs in this compiling method.

Code:
```java
public class RegistrationService {
    public boolean registerStudent(Student student, Course course) {
        // Check prerequisite
        if (course.getPrerequisite() != null &&
            !student.getCompletedCourses().contains(course.getPrerequisite())) {
            return true; // Bug 1
        }

        // Check available seats
        if (course.getEnrolled() >= course.getMaxSeats()) { // Bug 2
            return false;
        }

        // Enroll student and persist
        course.getRoster().add(student);
        registrationRepo.save(new Registration(student, course)); // Bug 3
        return true;
    }
}
```

Requirements: For each bug, give its location, type, explanation, and smallest safe fix. Check the missing-prerequisite, exactly-full, and successful-enrollment cases. If a marked line is already correct, state that clearly. Do not add unrelated issues.

Output: A numbered list titled Bug 1–3, followed by a short verification checklist.
````

Why this is an effective prompt:

- It gives the AI a relevant role and the CRS/Spring Boot context.
- It states the exact business rules and review goal.
- It includes the complete method being reviewed.
- It defines a numbered, verifiable output format.
- It asks the AI to expose assumptions and test boundary cases rather than merely produce an answer.

### A2. Identified Bugs (0.2 points)

| Bug | Location | Type | Why it is incorrect | Correct behavior |
|---|---|---|---|---|
| 1 | `return true;` in the failed-prerequisite branch | Wrong return value | A student who has not completed the prerequisite is reported as successfully registered, even though no enrollment is performed. | Return `false`. |
| 2 | Capacity comparison | Intended off-by-one boundary error | The normal faulty version would use `course.getEnrolled() > course.getMaxSeats()`. That allows registration when `getEnrolled() == getMaxSeats()`, producing one enrollment beyond capacity. | Reject when `getEnrolled() >= getMaxSeats()`. The supplied image already shows `>=`, so this particular line is already correct in the image. |
| 3 | Successful-enrollment block, before/around `registrationRepo.save(...)` | Missing state update | The method adds the student to the roster and stores a `Registration`, but it does not update the enrolled-count state later read by `getEnrolled()`. If that count is a stored field, subsequent calls can use a stale value and over-enroll the course. | Increment or synchronize the enrolled count before persisting. Ensure the update executes in the same transaction. |

#### Important source inconsistency

The image labels the following line as Bug 2:

```java
if (course.getEnrolled() >= course.getMaxSeats()) {
```

That comparison is already the correct boundary check: when the number enrolled equals the maximum, no seat remains. Therefore, the image does not contain an actual off-by-one error on that line. The likely intended faulty operator was `>` and its expected correction was `>=`.

Bug 3 also assumes that `getEnrolled()` returns a separately stored counter. If it is instead derived from `course.getRoster().size()`, no separate increment should be added. In that model, the reviewer should verify the JPA owning side and transaction mapping rather than maintain duplicate state.

### A3. Follow-up AI Prompt to Fix the Bugs (0.1 points)

````text
Role: Continue as the Java/Spring Boot reviewer.

Goal: Correct the three reviewed bugs in `registerStudent`.

Requirements: Keep the signature; return `false` for a missing prerequisite; reject when `enrolled >= maxSeats`; update the roster and stored enrolled count; save the registration; add an inline `// FIX n` comment to each fix; make no unrelated changes. Assume the course is managed in the current transaction.

Output: Return only the corrected method in one Java code block. Check the missing-prerequisite, full-course, and one-seat-left cases first.
````

#### Corrected method

```java
public boolean registerStudent(Student student, Course course) {
    // Check prerequisite
    if (course.getPrerequisite() != null &&
        !student.getCompletedCourses().contains(course.getPrerequisite())) {
        return false; // FIX 1: reject a student who has not completed the prerequisite
    }

    // Check available seats
    if (course.getEnrolled() >= course.getMaxSeats()) { // FIX 2: reject when the course is exactly full or over capacity
        return false;
    }

    // Enroll student and persist
    course.getRoster().add(student);
    course.setEnrolled(course.getEnrolled() + 1); // FIX 3: keep the enrolled count consistent with the roster
    registrationRepo.save(new Registration(student, course));
    return true;
}
```

The state mutation and database write should run in one transaction so that a persistence failure does not leave a partially completed registration.

---

## Scenario B — `GradeService.java` (0.5 points)

### B1. AI Prompt for Security and Logic Review (0.2 points)

````text
Role: You are a Java/Spring Boot, JPA, and application-security reviewer.

Context: In a Course Registration System, final grades may be published only after the grading period closes and every enrolled student has a grade. `courseId` may be user-controlled.

Goal: Find the two logical bugs and one security vulnerability in `publishGrades`.

Code:
```java
public class GradeService {
    private EntityManager em;

    public String publishGrades(String courseId) {
        // Fetch course from database
        Course course = (Course) em.createNativeQuery(
            "SELECT * FROM courses WHERE id = '" + courseId + "'" // Security bug
        ).getSingleResult();

        // Guard: grading period must be closed first
        if (!course.isGradingPeriodClosed()) { // Logical bug 1
            return "Grades published";
        }

        // Guard: all students must have a grade
        if (course.getGrades().size() == course.getRoster().size()) { // Logical bug 2
            return "Not all grades entered";
        }

        course.setGradesPublished(true);
        return "Grades published";
    }
}
```

Requirements: For each issue, give its location, type, cause, CRS impact, risk level (Low/Medium/High/Critical), and fix. Check the open-period, incomplete-grades, and all-grades-present cases. Explain the risk of concatenating `courseId` and recommend a parameterized JPA named query. Do not add style-only issues.

Output: A three-row Markdown table followed by a short verification checklist.
````

### B2. Identified Issues (0.2 points)

| Issue | Location | Type | Why it is incorrect / attack path | Impact in the CRS | Risk | Correct behavior |
|---|---|---|---|---|---|---|
| 1 | `"SELECT * FROM courses WHERE id = '" + courseId + "'"` | SQL injection caused by query-string concatenation | An attacker can supply SQL syntax as `courseId`, changing the meaning of the native query instead of selecting only the requested ID. | Unauthorized course access, disclosure or manipulation of academic data, and possible database compromise depending on DB permissions. | **Critical** | Use a parameterized JPA named query and bind `courseId` with `setParameter`. |
| 2 | `if (!course.isGradingPeriodClosed()) { return "Grades published"; }` | Wrong result/control flow | When the grading period is still open, the method returns a success message even though publication is forbidden and `setGradesPublished(true)` was never called. | Misleading audit/UI behavior and violation of the official grade-publication workflow. | **High** | Return a rejection message when the period is open; continue only when it is closed. |
| 3 | `if (grades.size() == roster.size()) { return "Not all grades entered"; }` | Reversed condition | Equality normally means every roster entry has a grade, yet the method rejects that valid case. When the sizes differ, it continues and publishes incomplete grades. | Some students' grades may be published while other grades are missing. | **High** | Reject when the sizes are unequal: `grades.size() != roster.size()`. |

Counting grades and roster entries is valid only if there can be at most one grade per enrolled student and every grade belongs to a roster member. A production implementation should preferably verify student identities, but that is outside the three issues requested by the question.

### B3. Follow-up AI Prompt to Fix the Issues (0.1 points)

````text
Role: Continue as the Java/JPA security reviewer.

Goal: Correct the three reviewed issues in `publishGrades`.

Requirements: Keep the signature; replace concatenated SQL with `Course.findById` and bind `:courseId`; reject an open grading period; reject when grade and roster sizes differ; publish only after both checks pass; add an inline `// FIX n` comment to each fix; make no unrelated changes. Assume the named query already exists.

Output: Return only the corrected method in one Java code block. Check the open-period, incomplete-grades, and valid-publication paths first.
````

#### Corrected method

```java
public String publishGrades(String courseId) {
    TypedQuery<Course> query = em.createNamedQuery("Course.findById", Course.class); // FIX 1: use predefined JPQL instead of concatenated native SQL
    query.setParameter("courseId", courseId); // FIX 1: bind user input safely
    Course course = query.getSingleResult();

    if (!course.isGradingPeriodClosed()) {
        return "Grading period is not closed"; // FIX 2: do not report or perform publication while grading is open
    }

    if (course.getGrades().size() != course.getRoster().size()) {
        return "Not all grades entered"; // FIX 3: reject only when one or more grades are missing
    }

    course.setGradesPublished(true);
    return "Grades published";
}
```

This method requires `jakarta.persistence.TypedQuery` (or `javax.persistence.TypedQuery` in older JPA versions). The named query can be declared on `Course` as follows:

```java
@NamedQuery(
    name = "Course.findById",
    query = "SELECT c FROM Course c WHERE c.id = :courseId"
)
```

---

## B. Giải thích ngắn bằng tiếng Việt

### Scenario A

1. **Bug 1 — sai giá trị trả về:** Sinh viên thiếu môn tiên quyết phải nhận `false`, không phải `true`.
2. **Bug 2 — lỗi biên dự kiến của đề:** Điều kiện đúng để từ chối lớp đã đầy là `enrolled >= maxSeats`. Ảnh đã ghi đúng toán tử `>=`, nên nhiều khả năng đề bị lỗi in và phiên bản sai ban đầu đáng lẽ là `>`.
3. **Bug 3 — thiếu cập nhật trạng thái:** Nếu `enrolled` là một trường đếm độc lập, sau khi thêm sinh viên vào roster phải tăng trường này; nếu không, lần kiểm tra sau dùng dữ liệu cũ và có thể cho đăng ký vượt chỉ tiêu.

### Scenario B

1. **Lỗ hổng Critical — SQL Injection:** Ghép trực tiếp `courseId` vào native SQL cho phép dữ liệu người dùng thay đổi câu truy vấn. Cần dùng named query và `setParameter`.
2. **Logical bug 1:** Khi kỳ nhập điểm chưa đóng, phương thức lại trả về `"Grades published"`. Phải từ chối công bố.
3. **Logical bug 2:** Điều kiện kiểm tra đủ điểm bị đảo. Hai kích thước bằng nhau là trường hợp hợp lệ; phải từ chối khi chúng **khác nhau** (`!=`).

---

## C. Keys & Tricks để làm dạng bài AI in Coding

### 1. Công thức prompt dễ lấy đủ điểm

Khi đề yêu cầu viết prompt cho AI review code, có thể nhớ công thức:

> **Role + Context + Goal + Code + Tasks + Output Format + Self-check**

| Thành phần | Key cần viết | Ví dụ ngắn |
|---|---|---|
| Role | Gán đúng chuyên môn cho AI | `You are a senior Java/Spring Boot and JPA code reviewer.` |
| Context | Nêu hệ thống và business rules | CRS chỉ cho đăng ký khi đủ prerequisite và còn chỗ. |
| Goal | Nói chính xác AI phải làm gì | Review logic, state consistency, persistence, and security. |
| Code | Đưa toàn bộ đoạn code cần review | Đặt code trong khối `java`, không chỉ mô tả bằng lời. |
| Tasks | Chia nhiệm vụ thành các bước kiểm chứng được | Xác định vị trí, loại lỗi, nguyên nhân, tác động và cách sửa. |
| Output Format | Quy định hình thức trả lời | Numbered list hoặc Markdown table; mỗi lỗi là một dòng. |
| Self-check | Yêu cầu kiểm tra các nhánh biên | Test thiếu prerequisite, vừa đầy chỗ, thiếu điểm và đủ điểm. |

#### Prompt skeleton có thể tái sử dụng

````text
Role: You are a senior [language/framework] code reviewer.

Context: This code belongs to [system]. The intended business rules are: [rules].

Goal: Review the following code for [logic/security/persistence] issues.

Input code:
```java
[paste the complete code here]
```

Tasks:
1. Identify exactly [number] issues.
2. For each issue, state its location, type, cause, impact, and fix.
3. Distinguish facts from assumptions.
4. Verify the important normal, failure, and boundary cases.

Output format:
Return a numbered list or table, then a short verification checklist.
````

### 2. Trick đọc code: đi theo Guard → State → Persistence → Result

Đừng đọc code một cách rời rạc. Với mỗi method, hãy kiểm tra theo thứ tự sau:

1. **Guard condition:** Điều kiện từ chối có đúng không?
2. **Boundary:** Toán tử `>`, `>=`, `<`, `<=`, `==`, `!=` có đúng tại giá trị biên không?
3. **State update:** Các thuộc tính liên quan có được cập nhật đồng bộ không?
4. **Persistence:** Đối tượng hoặc record cần lưu đã được lưu an toàn chưa?
5. **Return value/message:** Kết quả trả về có phản ánh đúng hành động thực tế không?

Ví dụ với đăng ký môn học:

```text
Prerequisite failed? → return false
Course exactly full? → return false
Registration accepted? → update roster/count → save record → return true
```

### 3. Trick tìm lỗi biên — thay số cụ thể vào điều kiện

Khi gặp điều kiện sức chứa, hãy thay số nhỏ để kiểm tra:

- `maxSeats = 30`, `enrolled = 29`: còn một chỗ, phải cho đăng ký.
- `maxSeats = 30`, `enrolled = 30`: đã đầy, phải từ chối.
- `maxSeats = 30`, `enrolled = 31`: trạng thái bất thường, vẫn phải từ chối.

Vì vậy điều kiện từ chối an toàn là:

```java
if (enrolled >= maxSeats) {
    return false;
}
```

**Bẫy trong ảnh đề:** dòng `>=` đã đúng. Nếu đề hỏi lỗi off-by-one thì nhiều khả năng bản gốc đáng lẽ dùng `>`. Không nên đổi `>=` thành `>` chỉ để cố tạo ra một lỗi.

### 4. Trick phát hiện điều kiện bị đảo

Hãy dịch điều kiện code thành một câu tiếng Việt rồi so sánh với thông báo trả về:

```java
grades.size() == roster.size()
```

Nghĩa là “số điểm bằng số sinh viên”, tức là trường hợp **đủ điểm**. Vì vậy trả về `"Not all grades entered"` tại đây là mâu thuẫn. Guard đúng phải là:

```java
if (grades.size() != roster.size()) {
    return "Not all grades entered";
}
```

### 5. Trick phát hiện return value sai

So sánh ba thứ trong cùng một nhánh:

> **Điều kiện → Hành động thực tế → Giá trị/thông báo trả về**

Nếu điều kiện nói “không đủ prerequisite”, không có thao tác đăng ký nào xảy ra nhưng method lại `return true`, thì giá trị trả về đang nói ngược với hành động thực tế.

Tương tự, khi grading period chưa đóng, trả về `"Grades published"` là sai vì cờ `gradesPublished` chưa được đặt thành `true` và business rule cũng không cho phép công bố.

### 6. Trick nhận diện SQL Injection

Các dấu hiệu cần khoanh ngay:

- Dữ liệu đầu vào như `courseId`, `username`, hoặc `keyword` được nối bằng dấu `+` vào SQL.
- Sử dụng `createNativeQuery(...)` với chuỗi được ghép động.
- Dữ liệu người dùng nằm trực tiếp giữa dấu nháy của câu query.

Mẫu nguy hiểm:

```java
"SELECT * FROM courses WHERE id = '" + courseId + "'"
```

Mẫu an toàn:

```java
TypedQuery<Course> query = em.createNamedQuery("Course.findById", Course.class);
query.setParameter("courseId", courseId);
```

**Key:** Không chỉ thay native SQL bằng JPQL. Nếu vẫn nối chuỗi bằng `+`, nguy cơ injection vẫn còn. Điểm quan trọng là phải dùng **parameter binding**.

### 7. Trick chấm risk level

| Risk level | Cách nhận biết nhanh |
|---|---|
| Low | Lỗi nhỏ, ít ảnh hưởng và khó bị khai thác. |
| Medium | Ảnh hưởng một chức năng hoặc một nhóm người dùng nhưng phạm vi còn hạn chế. |
| High | Vi phạm business rule quan trọng, làm sai dữ liệu hoặc ảnh hưởng nhiều sinh viên. |
| Critical | Có thể bị khai thác trực tiếp để truy cập/thay đổi dữ liệu nhạy cảm hoặc xâm phạm database. |

Trong Scenario B:

- SQL Injection: **Critical**.
- Công bố sai thời điểm hoặc công bố khi thiếu điểm: **High**.

### 8. Trick viết follow-up prompt sửa code

Follow-up prompt không cần lặp lại toàn bộ phần giải thích, nhưng phải khóa rõ kết quả mong muốn:

- Giữ nguyên method signature.
- Sửa đúng các lỗi đã tìm thấy.
- Không refactor ngoài phạm vi đề.
- Yêu cầu comment `// FIX 1`, `// FIX 2`, ... ngay tại dòng sửa.
- Yêu cầu chỉ trả về một khối code Java.
- Nêu API bắt buộc, ví dụ named query và `setParameter`.

Câu mẫu:

> Based on the review above, return the fully corrected Java method. Keep the existing signature, fix only the three identified issues, add an inline `// FIX n` comment to every correction, and return exactly one Java code block.

### 9. Các lỗi dễ mất điểm

- Chỉ viết “Find the bugs” mà không có context, goal, code và output format.
- Nêu tên lỗi nhưng không giải thích tại sao hành vi sai.
- Quên chỉ rõ vị trí hoặc code fragment của từng lỗi.
- Viết code sửa nhưng không có inline comment cho từng fix.
- Dùng `>` thay vì `>=` khi kiểm tra lớp đã đầy.
- Dùng `==` thay vì `!=` khi kiểm tra còn thiếu điểm.
- Chỉ đổi native SQL sang JPQL nhưng vẫn nối chuỗi đầu vào.
- Không ghi risk level cho Scenario B.
- Tự tạo thêm lỗi không có căn cứ thay vì ghi rõ assumption hoặc sự không nhất quán của đề.

### 10. Checklist 30 giây trước khi nộp

- [ ] Prompt có Role, Context, Goal, Code và Output Format.
- [ ] Scenario A đã nêu đủ ba bug theo rubric và giải thích điểm bất thường của Bug 2.
- [ ] Scenario B có đúng hai logical bugs và một security vulnerability.
- [ ] Mỗi lỗi có location, type, explanation, impact/fix; Scenario B có risk level.
- [ ] Code sửa dùng `>=` cho capacity và `!=` cho incomplete grades.
- [ ] Query sử dụng named query cùng `setParameter`.
- [ ] Mỗi sửa đổi có inline comment `// FIX n`.
- [ ] Không có nội dung ngoài phạm vi yêu cầu đề bài.

## Final Self-Check

- [x] Each review prompt includes the system context, a specific goal, the complete input code, constraints, and the expected output format.
- [x] Scenario A includes three intended bug entries, a follow-up fix prompt, corrected code, and a transparent note about the faulty Bug 2 statement in the image.
- [x] Scenario B identifies two logic bugs and one named security vulnerability with CRS impact and risk levels.
- [x] The corrected Scenario B method uses a parameterized JPA named query.
- [x] Every correction in both methods has an inline `FIX` comment.
