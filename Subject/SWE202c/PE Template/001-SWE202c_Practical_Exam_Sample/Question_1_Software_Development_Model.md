# Question 1: Software Development Model

## A. English version — approximately 550 words

### 1.1 Most appropriate SDLC model: Agile–Incremental Model

The most appropriate software development model for the Course Registration System (CRS) is the **Agile–Incremental model**, preferably implemented using Scrum. In this model, the system is divided into smaller functional increments and developed through short iterations or sprints. Each increment produces a working part of the CRS that stakeholders can review and evaluate.

**Requirements are not fully known and stable at the outset.** Although the case study identifies the main users and high-level functions, many detailed requirements remain unclear. For example, the university still needs to define prerequisite exceptions, waitlist priorities, notification rules, report formats, grading policies, and approval workflows. These requirements may also change after students, lecturers, and administrators use early versions of the system. Agile is suitable because it allows the product backlog to be refined throughout development.

**Iterative delivery and regular stakeholder feedback are important.** The CRS serves four stakeholder groups with different needs: Students, Lecturers, Academic Staff, and System Administrators. Development can be divided into increments such as course browsing and registration, prerequisite checking, waitlist management, timetable and quota administration, grading, reporting, RBAC, and backup management. At the end of every sprint, stakeholders can review a working increment and provide feedback. This helps the team detect misunderstood requirements early and improves usability before the registration window opens.

**The CRS contains significant technical risks.** It must support at least 1,000 simultaneous users while maintaining a response time below three seconds. It must also provide TLS 1.2 or higher, RBAC, 99.5% availability, WCAG 2.1 Level AA accessibility, and horizontal scaling. These requirements involve performance, security, accessibility, and infrastructure risks. Agile allows the team to address them early through security reviews, load testing, accessibility testing, architectural prototypes, and continuous integration instead of postponing testing until the end.

**Team size and project duration are not stated in the case study.** A reasonable assumption is that a cross-functional, medium-sized team will include developers, testers, a UX designer, a security or DevOps specialist, and university representatives. Scrum works well when this team is organized into a small team or several coordinated teams. The system should also be delivered before a future semester, so short, time-boxed sprints provide visible progress and allow high-priority features to be completed first.

The university may have a formal change-control process because academic policies and student records are sensitive. Agile does not mean uncontrolled change. Proposed changes should be recorded in the product backlog, assessed for value, risk, cost, and compliance, and approved by the Product Owner or a university change-control board. Changes should normally enter a future sprint without disrupting the current sprint.

### 1.2 Alternative model: Waterfall

**Selected alternative: Waterfall Model**

Waterfall may be chosen because a university often has formal approval procedures, fixed budgets, procurement documentation, academic regulations, and a semester deadline. It provides sequential phases—requirements, design, implementation, testing, deployment, and maintenance—with formal sign-off at each stage.

**Advantages of Waterfall**

- It produces comprehensive documentation and clear milestones, which support university governance, auditing, procurement, training, and maintenance.
- Its formal approval process offers strong control over scope, budget, responsibilities, and regulatory requirements.

**Disadvantages of Waterfall**

- It assumes requirements can be defined early and remain stable, but detailed CRS workflows may change after stakeholder feedback.
- Working software and full system testing arrive late, so usability, security, concurrency, and performance problems may be expensive to correct.

**Advantages of Agile–Incremental**

- Frequent demonstrations allow all four user groups to validate features and improve the requirements continuously.
- Early increments and continuous testing reduce technical risks and may deliver important functions before the entire CRS is completed.

**Disadvantages of Agile–Incremental**

- It requires regular participation from university stakeholders, which may be difficult during teaching and administrative periods.
- Without disciplined backlog management and change control, continuous requests may cause scope creep, coordination problems, and uncertain cost.

Overall, Agile–Incremental is more appropriate because the CRS combines evolving workflows, multiple stakeholders, and high technical risk. Waterfall is valuable for governance and documentation, but it is less flexible when requirements change.

---

# Câu 1: Mô hình phát triển phần mềm

## B. Bản tiếng Việt — khoảng 550 từ

### 1.1 Mô hình SDLC phù hợp nhất: Agile–Incremental

Mô hình phù hợp nhất cho Hệ thống Đăng ký Học phần (CRS) là **Agile–Incremental**, ưu tiên triển khai theo Scrum. Với mô hình này, hệ thống được chia thành các phần chức năng nhỏ và phát triển qua những vòng lặp ngắn, còn gọi là sprint. Mỗi increment tạo ra một phần mềm hoạt động được để các bên liên quan kiểm tra và đánh giá.

**Các yêu cầu chưa hoàn toàn đầy đủ và ổn định ngay từ đầu.** Case study đã nêu các nhóm người dùng và chức năng chính, nhưng nhiều quy tắc chi tiết vẫn chưa được xác định. Ví dụ gồm cách xử lý ngoại lệ về môn tiên quyết, mức độ ưu tiên trong danh sách chờ, quy tắc gửi thông báo, định dạng báo cáo, chính sách công bố điểm và quy trình phê duyệt. Những yêu cầu này có thể thay đổi khi sinh viên, giảng viên và nhân viên học vụ trải nghiệm phiên bản đầu tiên. Agile phù hợp vì product backlog có thể liên tục được bổ sung và điều chỉnh.

**Dự án cần phát hành lặp và nhận phản hồi thường xuyên.** CRS phục vụ bốn nhóm người dùng: Sinh viên, Giảng viên, Nhân viên học vụ và Quản trị viên hệ thống. Dự án có thể chia thành các increment như tra cứu và đăng ký môn học, kiểm tra môn tiên quyết, quản lý danh sách chờ, thiết lập thời khóa biểu và chỉ tiêu, nhập điểm, báo cáo, RBAC và sao lưu. Sau mỗi sprint, các bên liên quan có thể đánh giá sản phẩm hoạt động được và đưa ra phản hồi. Nhờ đó, nhóm phát hiện sớm các yêu cầu bị hiểu sai và cải thiện khả năng sử dụng trước khi kỳ đăng ký bắt đầu.

**CRS có nhiều rủi ro kỹ thuật đáng kể.** Hệ thống phải phục vụ ít nhất 1.000 người dùng đồng thời và phản hồi dưới ba giây. Hệ thống còn phải đáp ứng TLS 1.2 trở lên, RBAC, availability 99,5%, WCAG 2.1 Level AA và horizontal scaling. Đây là các rủi ro liên quan đến hiệu năng, bảo mật, khả năng truy cập và kiến trúc. Agile cho phép xử lý chúng sớm thông qua prototype kiến trúc, kiểm thử tải, kiểm thử bảo mật, kiểm thử accessibility và tích hợp liên tục.

**Case study không cung cấp quy mô nhóm và thời gian dự án.** Có thể giả định dự án sử dụng một nhóm liên chức năng cỡ vừa, gồm lập trình viên, kiểm thử viên, UX designer, chuyên viên DevOps hoặc bảo mật và đại diện trường. Scrum phù hợp nếu nhân sự được tổ chức thành một nhóm nhỏ hoặc một số nhóm phối hợp. Vì hệ thống cần sẵn sàng trước một học kỳ tương lai, các sprint có thời hạn cố định giúp thể hiện tiến độ và ưu tiên chức năng quan trọng.

Trường đại học có thể áp dụng quy trình kiểm soát thay đổi chính thức. Agile không có nghĩa là thay đổi tùy ý. Mọi thay đổi phải được ghi vào backlog, đánh giá giá trị, rủi ro, chi phí và tính tuân thủ, sau đó được Product Owner hoặc hội đồng kiểm soát thay đổi phê duyệt. Thay đổi thường được đưa vào sprint tiếp theo.

### 1.2 Mô hình thay thế: Waterfall

**Mô hình được chọn: Waterfall**

Waterfall có thể được chọn vì trường đại học thường có ngân sách cố định, quy định học vụ, hồ sơ đấu thầu, thủ tục phê duyệt chính thức và thời hạn theo học kỳ. Mô hình này gồm các giai đoạn tuần tự và có phê duyệt sau từng giai đoạn.

**Ưu điểm của Waterfall**

- Tạo tài liệu đầy đủ và các mốc rõ ràng, thuận lợi cho quản trị, kiểm toán, đào tạo và bảo trì.
- Giúp kiểm soát chặt chẽ phạm vi, ngân sách, trách nhiệm và các yêu cầu tuân thủ.

**Nhược điểm của Waterfall**

- Giả định yêu cầu được xác định sớm và ổn định, trong khi quy trình chi tiết của CRS có thể thay đổi sau phản hồi.
- Phần mềm và kiểm thử tổng thể xuất hiện muộn, khiến lỗi usability, bảo mật hoặc hiệu năng trở nên tốn kém để sửa.

**Ưu điểm của Agile–Incremental**

- Các buổi trình diễn thường xuyên giúp bốn nhóm người dùng xác nhận chức năng và hoàn thiện yêu cầu.
- Bàn giao và kiểm thử sớm giúp giảm rủi ro kỹ thuật, đồng thời cung cấp chức năng ưu tiên trước khi toàn hệ thống hoàn tất.

**Nhược điểm của Agile–Incremental**

- Cần sự tham gia thường xuyên của các bên liên quan, nhưng họ có thể bận giảng dạy hoặc công việc hành chính.
- Nếu backlog và thay đổi không được quản lý tốt, dự án có thể bị scope creep, khó phối hợp và khó dự đoán chi phí.

Nhìn chung, Agile–Incremental phù hợp hơn vì CRS có yêu cầu thay đổi, nhiều stakeholder và rủi ro kỹ thuật cao. Waterfall mạnh về tài liệu và quản trị nhưng kém linh hoạt hơn.

## Keywords trong case study giúp xác định đáp án

| Keyword/chi tiết | Ý nghĩa đối với lựa chọn SDLC |
|---|---|
| “four main groups of users” | Nhiều stakeholder → cần phản hồi thường xuyên |
| “expected to” | Chủ yếu là yêu cầu cấp cao, chưa phải đặc tả hoàn chỉnh |
| “exceptional cases” | Quy tắc nghiệp vụ phức tạp và có thể thay đổi |
| “automatically notifies and enrolls” | Workflow tự động cần thử nghiệm qua nhiều increment |
| “1,000 simultaneous users” | Rủi ro hiệu năng → cần load testing sớm |
| “under 3 seconds” | Yêu cầu hiệu năng có thể đo lường |
| “TLS 1.2 or higher” | Rủi ro và yêu cầu bảo mật |
| “RBAC” | Cần kiểm thử quyền của bốn vai trò |
| “99.5%” | Yêu cầu availability và vận hành |
| “WCAG 2.1 Level AA” | Cần kiểm thử accessibility lặp lại |
| “desktop and mobile browsers” | Cần stakeholder review và compatibility testing |
| “horizontal scaling” | Rủi ro kiến trúc cần prototype sớm |
| “planned maintenance outside the registration window” | Deadline và deployment bị ràng buộc theo học kỳ |
| “paper-based”, “error-prone”, “slow” | Cần phát hành sớm để cải thiện quy trình hiện tại |
