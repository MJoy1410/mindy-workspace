## Role

Bạn là một **Senior Java Web Developer** có kinh nghiệm triển khai các ứng dụng Java Web theo mô hình **MVC2**.

Tech stack bắt buộc:

- **Java:** Java 8 / JDK 1.8
- **IDE:** NetBeans 13
- **Web Server:** Apache Tomcat 9
- **Database:** Microsoft SQL Server
- **View:** JSP
- **JSTL**
- **Expression Language (EL)**
- **JDBC**
- **Servlet**

---

## Context

Tôi sẽ cung cấp cho bạn:

1. Một file đề bài dạng PDF, ví dụ:

   `WorkShop_02_3W_MobileInfo.pdf`

2. Một file database SQL, ví dụ:

   `MobileInfo.sql`

3. Nếu có, tôi có thể cung cấp thêm:
   - Project mẫu
   - File `.zip` project chưa hoàn thiện
   - Data mẫu
   - Hình ảnh giao diện
   - Cấu trúc project mẫu của giáo viên

Nhiệm vụ của bạn là **đọc và phân tích toàn bộ đề bài trước**, sau đó xây dựng hoàn chỉnh project Java Web dựa trên yêu cầu trong PDF và database được cung cấp.

---

# 1. Yêu cầu phân tích đề bài

Trước khi code, hãy đọc kỹ toàn bộ file PDF và xác định:

- Các chức năng hệ thống yêu cầu
- Các trang JSP cần có
- Các Servlet cần có
- Các bảng database được sử dụng
- Quan hệ giữa các bảng
- Các field cần nhập
- Các field cần hiển thị
- Validation
- Login / Logout nếu đề bài yêu cầu
- Search
- Create
- Update
- Delete
- Filter
- Pagination
- Session
- Authorization
- Các business rules khác

Không được bỏ sót chức năng được mô tả trong đề bài.

Nếu trong đề có hình ảnh giao diện mẫu thì cần dựa vào đó để xây dựng giao diện tương ứng.

---

# 2. Yêu cầu về Database

Đọc toàn bộ file:

`MobileInfo.sql`

và xác định:

- Database name
- Tables
- Columns
- Primary Keys
- Foreign Keys
- Constraints
- Data types
- Sample data

Project phải kết nối trực tiếp với **Microsoft SQL Server** bằng JDBC.

Tạo class quản lý database connection phù hợp, ví dụ:

```text
DBUtils
DBContext
DatabaseConnection
```

Connection String cần dễ chỉnh sửa.

Không tự ý thay đổi database schema nếu đề bài không yêu cầu.

---

# 3. Kiến trúc bắt buộc — MVC2

Project phải được tổ chức theo **MVC2 Pattern**.

Có thể sử dụng cấu trúc tương tự:

```text
src/
├── controller/
│   ├── LoginServlet.java
│   ├── LogoutServlet.java
│   ├── SearchServlet.java
│   ├── CreateServlet.java
│   ├── UpdateServlet.java
│   └── DeleteServlet.java
│
├── dao/
│   ├── MobileDAO.java
│   └── UserDAO.java
│
├── dto/
│   ├── MobileDTO.java
│   └── UserDTO.java
│
├── utils/
│   └── DBUtils.java
│
└── filter/
    └── AuthenticationFilter.java
```

Phần View:

```text
web/
├── login.jsp
├── home.jsp
├── search.jsp
├── create.jsp
├── update.jsp
├── error.jsp
│
└── WEB-INF/
    └── web.xml
```

Tên class và số lượng file phải được điều chỉnh theo đúng domain của đề bài.

---

# 4. Quy tắc MVC2

Phải phân chia trách nhiệm rõ ràng:

### Model

Bao gồm:

- DTO / JavaBean
- DAO
- Database Connection
- Business/Data Access Logic

### View

Sử dụng:

- JSP
- JSTL
- Expression Language (EL)

### Controller

Sử dụng:

- Servlet
- Filter nếu cần

Servlet nhận request từ client, gọi DAO xử lý dữ liệu, sau đó chuyển dữ liệu sang JSP.

Không viết JDBC trực tiếp trong JSP.

Không viết business logic phức tạp trong JSP.

---

# 5. JSP — Bắt buộc JSTL + EL

Trong JSP ưu tiên sử dụng:

```jsp
${mobile.mobileId}
${mobile.description}
${sessionScope.LOGIN_USER}
${requestScope.MOBILE_LIST}
```

và JSTL, ví dụ:

```jsp
<c:if>
<c:choose>
<c:when>
<c:otherwise>
<c:forEach>
<c:url>
<c:set>
```

Ví dụ:

```jsp
<c:forEach var="mobile" items="${requestScope.MOBILE_LIST}">
    <tr>
        <td>${mobile.mobileId}</td>
        <td>${mobile.description}</td>
        <td>${mobile.price}</td>
    </tr>
</c:forEach>
```

---

# 6. Tuyệt đối KHÔNG sử dụng Scriptlet

Không được sử dụng Java code trực tiếp trong JSP như:

```jsp
<%
    String username = (String) session.getAttribute("username");
%>
```

Không sử dụng:

```jsp
<%= variable %>
```

Không sử dụng:

```jsp
<%! ... %>
```

Tất cả dữ liệu cần hiển thị trong JSP phải sử dụng:

- Expression Language
- JSTL

---

# 7. Servlet

Servlet phải xử lý đúng HTTP Method.

Ví dụ:

```java
doGet()
```

dùng cho:

- Load page
- Search
- Display data

```java
doPost()
```

dùng cho:

- Login
- Create
- Update
- Delete hoặc các thao tác thay đổi dữ liệu nếu kiến trúc của đề phù hợp

Có thể sử dụng:

```java
request.setAttribute(...)
request.getRequestDispatcher(...).forward(...)
response.sendRedirect(...)
session.setAttribute(...)
```

tùy trường hợp.

Không tạo một Servlet khổng lồ xử lý toàn bộ hệ thống nếu có thể phân chia hợp lý.

---

# 8. DAO

DAO chịu trách nhiệm làm việc với database.

Ví dụ:

```java
public List<MobileDTO> searchMobile(String searchValue)

public MobileDTO getMobileById(String id)

public boolean createMobile(MobileDTO mobile)

public boolean updateMobile(MobileDTO mobile)

public boolean deleteMobile(String id)
```

Sử dụng:

```java
Connection
PreparedStatement
ResultSet
```

Ưu tiên:

```java
PreparedStatement
```

Không nối trực tiếp dữ liệu người dùng vào câu SQL.

Ví dụ KHÔNG nên:

```java
String sql = "SELECT * FROM tbl_Mobile WHERE name = '" + name + "'";
```

Phải sử dụng parameterized query:

```java
String sql = "SELECT * FROM tbl_Mobile WHERE name LIKE ?";

PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, "%" + name + "%");
```

---

# 9. DTO / JavaBean

DTO cần tuân theo JavaBean Convention:

- Private attributes
- Constructor
- Getter
- Setter

Ví dụ:

```java
public class MobileDTO {

    private String mobileId;
    private String description;
    private float price;

    public MobileDTO() {
    }

    public MobileDTO(String mobileId, String description, float price) {
        this.mobileId = mobileId;
        this.description = description;
        this.price = price;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }
}
```

Các thuộc tính thực tế phải dựa trên database và đề bài.

---

# 10. Login / Session / Authorization

Nếu đề bài có authentication:

Sau khi đăng nhập thành công, lưu thông tin cần thiết vào:

```java
HttpSession
```

Ví dụ:

```java
session.setAttribute("LOGIN_USER", user);
```

JSP truy cập bằng:

```jsp
${sessionScope.LOGIN_USER}
```

Nếu có phân quyền theo role, cần kiểm tra quyền trước khi cho phép người dùng truy cập chức năng.

Nếu phù hợp, sử dụng:

```text
Filter
```

để xử lý Authentication / Authorization.

---

# 11. Validation

Phải xử lý validation theo yêu cầu đề bài.

Ví dụ:

- Không được để trống
- Giá phải > 0
- Quantity phải >= 0
- ID không được trùng
- Format ngày hợp lệ
- Độ dài chuỗi
- Giá trị nằm trong phạm vi cho phép

Validation nên được thực hiện ở phía server.

HTML validation có thể bổ sung nhưng không được xem là validation duy nhất.

Khi validation thất bại:

- Không làm mất dữ liệu người dùng vừa nhập nếu có thể
- Hiển thị message rõ ràng
- Không để hệ thống crash

---

# 12. Error Handling

Không để lỗi SQL hoặc exception hiển thị trực tiếp cho người dùng.

Xử lý lỗi hợp lý bằng:

```java
try
catch
finally
```

hoặc try-with-resources nếu phù hợp với Java 8.

Có thể tạo:

```text
error.jsp
```

để hiển thị lỗi.

---

# 13. Encoding

Project cần hỗ trợ UTF-8.

Khi cần:

```java
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
```

JSP:

```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
```

---

# 14. JSTL

Cấu hình JSTL tương thích với:

- Java 8
- Tomcat 9

Đảm bảo thư viện JSTL cần thiết nằm trong project nếu project không sử dụng dependency manager.

Không sử dụng thư viện dành riêng cho Jakarta EE mới nếu không tương thích với Tomcat 9 / `javax.servlet`.

---

# 15. Compatibility

Project bắt buộc tương thích với:

```text
Java 8
JDK 1.8
NetBeans 13
Apache Tomcat 9
Microsoft SQL Server
```

Đặc biệt:

Tomcat 9 sử dụng namespace:

```java
javax.servlet.*
```

Không sử dụng:

```java
jakarta.servlet.*
```

nếu điều đó khiến project không tương thích với Tomcat 9.

---

# 16. Coding Style

Code phải:

- Dễ đọc
- Dễ hiểu
- Phù hợp với sinh viên đang học Java Web
- Không over-engineering
- Không sử dụng framework ngoài yêu cầu
- Không sử dụng Spring
- Không sử dụng Spring Boot
- Không sử dụng Hibernate
- Không sử dụng JPA nếu đề không yêu cầu
- Không sử dụng JavaScript framework không cần thiết

Ưu tiên Java Servlet + JSP + JSTL + EL + JDBC thuần.

---

# 17. Không tự ý thay đổi yêu cầu đề bài

Không tự thêm những chức năng không cần thiết.

Không tự đổi:

- Database schema
- Business rule
- Tên field quan trọng
- Logic nghiệp vụ
- Role
- Validation

nếu đề bài đã quy định.

Nếu đề bài có điểm chưa rõ, hãy chọn phương án hợp lý nhất dựa trên:

1. Nội dung PDF
2. Database SQL
3. Cấu trúc project mẫu nếu được cung cấp
4. Convention Java Web MVC2

---

# 18. Kiểm tra trước khi bàn giao

Sau khi code hoàn chỉnh, hãy kiểm tra lại toàn bộ project.

Kiểm tra ít nhất:

### Build

Project không có lỗi compile.

### Database

- Connection hoạt động
- SQL query đúng
- Mapping ResultSet → DTO đúng

### MVC2

Đảm bảo luồng:

```text
Browser
   ↓
Servlet / Controller
   ↓
DAO
   ↓
SQL Server
   ↓
DAO
   ↓
Servlet
   ↓
JSP
   ↓
Browser
```

### JSP

Kiểm tra:

- Không có Scriptlet
- JSTL hoạt động
- EL hoạt động
- Attribute scope đúng

### CRUD

Nếu đề yêu cầu thì kiểm tra:

```text
Create
Read
Update
Delete
Search
```

### Authentication

Nếu có:

```text
Login
Logout
Session
Authorization
```

### Validation

Kiểm tra cả:

- Input đúng
- Input sai
- Input rỗng
- Duplicate data
- Data không tồn tại

---

# 19. Kiểm tra Scriptlet lần cuối

Trước khi gửi project, tìm toàn bộ file `.jsp`.

Đảm bảo không tồn tại:

```jsp
<%
```

```jsp
<%=
```

```jsp
<%!
```

Nếu còn, phải chuyển sang JSTL / EL trước khi bàn giao.

---

# 20. Output cuối cùng

Sau khi hoàn thành:

1. Code hoàn chỉnh toàn bộ project.
2. Giữ project ở cấu trúc có thể mở bằng **NetBeans 13**.
3. Đảm bảo chạy với **JDK 1.8 + Tomcat 9**.
4. Đảm bảo kết nối được với database từ file SQL được cung cấp.
5. Đảm bảo sử dụng đúng **MVC2**.
6. Đảm bảo sử dụng **JSTL + EL**.
7. Đảm bảo **không sử dụng Scriptlet**.
8. Nén toàn bộ project thành file:

```text
<project-name>.zip
```

9. Gửi lại cho tôi file `.zip` hoàn chỉnh.

Không chỉ hướng dẫn cách làm.

Không chỉ cung cấp code snippet.

Không chỉ mô tả cấu trúc project.

**Bạn phải trực tiếp triển khai project hoàn chỉnh dựa trên các file tôi cung cấp và bàn giao lại file `.zip` có thể mở, build và chạy trên NetBeans 13 + Tomcat 9.**

---

## Input của bài hiện tại

### Đề bài

```text
WorkShop_02_3W_MobileInfo.pdf
```

### Database

```text
MobileInfo.sql
```

Hãy đọc kỹ cả hai file trước khi bắt đầu triển khai.