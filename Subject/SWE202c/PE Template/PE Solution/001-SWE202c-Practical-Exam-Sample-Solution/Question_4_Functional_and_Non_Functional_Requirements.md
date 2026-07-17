# Question 4: Functional and Non-Functional Requirements

## A. English Version

### 1. Functional Requirements

Functional requirements describe **what the CRS must do**, including its functions, business rules, user interactions, and system behaviours.

| ID | Actor | Functional Requirement | Acceptance Criteria |
|---|---|---|---|
| FR-01 | Student | The system shall allow students to browse and search the catalogue of courses available in the current semester. | A student can view courses and search or filter them by course code, course name, lecturer, or programme. |
| FR-02 | Student | The system shall check whether a student has completed all prerequisites before accepting a registration request. | Registration is accepted only when all prerequisites are satisfied; otherwise, the system displays the missing prerequisites. |
| FR-03 | Student | The system shall allow eligible students to submit course-registration requests while the registration window is open. | A valid request is stored successfully, and the student receives a confirmation containing the course and request status. |
| FR-04 | Student | The system shall allow students to track the status of each registration request. | The student can view an up-to-date status such as Pending, Approved, Enrolled, Waitlisted, or Rejected. |
| FR-05 | Student | The system shall allow a student to join an electronic waitlist when a course quota has been reached. | An eligible student is added to the end of the waitlist, and their current waitlist position is displayed. |
| FR-06 | System | When a registered student drops a full course, the system shall process the first eligible student on its waitlist. | The first eligible student is automatically enrolled, removed from the waitlist, and notified of the enrolment. |
| FR-07 | Lecturer | The system shall allow lecturers to view the roster of students enrolled in their assigned courses. | A lecturer can access rosters only for courses assigned to them, and each roster displays the currently enrolled students. |
| FR-08 | Lecturer | The system shall allow lecturers to record and update midterm and final grades. | Valid grades are saved for the selected student and course; invalid or incomplete values are rejected with an error message. |
| FR-09 | Lecturer | The system shall allow lecturers to release grades after the grading period closes. | Students cannot see unreleased grades; after release, the relevant students can view their grades. |
| FR-10 | Academic Staff | The system shall allow Academic Staff to define timetables, set course quotas, and publish courses. | Published courses display the approved schedule and quota in the student course catalogue. |
| FR-11 | Academic Staff | The system shall allow authorized staff to open and close the registration window. | Students can submit requests only between the configured opening and closing times. |
| FR-12 | Academic Staff | The system shall allow authorized staff to review and approve or reject exceptional registration cases. | The decision, responsible staff member, time, and reason are recorded, and the student is notified. |
| FR-13 | Academic Staff | The system shall generate enrolment and grade-distribution reports. | Authorized staff can generate reports using selected semester, course, or programme criteria. |
| FR-14 | System Administrator | The system shall allow System Administrators to create, update, disable, and assign roles to user accounts. | Account and role changes are saved and applied to the user's subsequent access. |
| FR-15 | System Administrator | The system shall allow System Administrators to configure system parameters and manage scheduled backups. | Authorized administrators can define parameters and backup schedules and view the result of each backup operation. |

### 2. Non-Functional Requirements

Non-functional requirements describe **how well the CRS must operate**, including its performance, security, availability, accessibility, compatibility, and scalability.

| Category | NFR Description | Acceptance Criterion |
|---|---|---|
| Performance – Capacity | The CRS shall support at least 1,000 simultaneous users during peak registration periods. | A load test with 1,000 concurrent active users completes without system failure or rejected requests caused by insufficient capacity. |
| Performance – Response time | Pages shall respond within three seconds during peak registration periods. | Under a load of 1,000 concurrent users, each tested page has a response time below three seconds. |
| Security – Communication | All communication containing user, student, registration, or grade data shall be encrypted using TLS 1.2 or higher. | Security testing confirms that all external connections use TLS 1.2 or above and that older protocols and unencrypted HTTP connections are rejected or redirected. |
| Security – Authorization | Access shall be controlled using RBAC so that users see only the functions and data permitted for their roles. | Authorization tests confirm that Students, Lecturers, Academic Staff, and System Administrators cannot access unauthorized pages, functions, or records. |
| Availability | The CRS shall be available for 99.5% of the time during the semester. | Monitoring records demonstrate at least 99.5% availability during each semester, excluding formally approved planned maintenance where applicable. |
| Maintainability/Operations | Planned maintenance shall be conducted outside the registration window. | Deployment and maintenance logs show that no planned maintenance causing service interruption occurs while registration is open. |
| Compatibility | The interface shall be accessible through desktop and mobile web browsers. | All critical workflows pass tests on the university's approved current desktop and mobile browser matrix. |
| Accessibility | The CRS interface shall conform to WCAG 2.1 Level AA. | Automated tests and manual accessibility audits report no unresolved WCAG 2.1 Level A or AA violations in critical workflows. |
| Scalability | The architecture shall support horizontal scaling as the number of students increases. | An additional application-server instance can be added without application-code changes, and requests are successfully distributed across available instances. |

---

## B. Bản tiếng Việt

### 1. Yêu cầu chức năng – Functional Requirements

Yêu cầu chức năng mô tả **CRS phải làm gì**, bao gồm chức năng, quy tắc nghiệp vụ, tương tác của người dùng và hành vi tự động của hệ thống.

| ID | Tác nhân | Mô tả yêu cầu chức năng | Tiêu chí chấp nhận |
|---|---|---|---|
| FR-01 | Sinh viên | Hệ thống phải cho phép sinh viên xem và tìm kiếm danh mục môn học được mở trong học kỳ hiện tại. | Sinh viên có thể xem và tìm kiếm hoặc lọc theo mã môn, tên môn, giảng viên hoặc chương trình học. |
| FR-02 | Sinh viên | Hệ thống phải kiểm tra các môn tiên quyết trước khi chấp nhận yêu cầu đăng ký. | Yêu cầu chỉ được chấp nhận khi sinh viên hoàn thành tất cả môn tiên quyết; nếu không, hệ thống hiển thị các môn còn thiếu. |
| FR-03 | Sinh viên | Hệ thống phải cho phép sinh viên đủ điều kiện gửi yêu cầu đăng ký trong thời gian đăng ký. | Yêu cầu hợp lệ được lưu và sinh viên nhận được xác nhận gồm môn học và trạng thái yêu cầu. |
| FR-04 | Sinh viên | Hệ thống phải cho phép sinh viên theo dõi trạng thái của từng yêu cầu đăng ký. | Sinh viên xem được trạng thái mới nhất như Pending, Approved, Enrolled, Waitlisted hoặc Rejected. |
| FR-05 | Sinh viên | Hệ thống phải cho phép sinh viên tham gia danh sách chờ khi môn học đã đủ chỉ tiêu. | Sinh viên đủ điều kiện được thêm vào cuối danh sách và xem được vị trí hiện tại của mình. |
| FR-06 | Hệ thống | Khi một sinh viên rút khỏi môn đã đầy, hệ thống phải xử lý sinh viên đủ điều kiện đầu tiên trong danh sách chờ. | Sinh viên đủ điều kiện đầu tiên được tự động ghi danh, xóa khỏi danh sách chờ và nhận thông báo. |
| FR-07 | Giảng viên | Hệ thống phải cho phép giảng viên xem danh sách sinh viên của các lớp mình phụ trách. | Giảng viên chỉ truy cập được các lớp được phân công và danh sách hiển thị đúng sinh viên hiện đang theo học. |
| FR-08 | Giảng viên | Hệ thống phải cho phép giảng viên nhập và cập nhật điểm giữa kỳ và cuối kỳ. | Điểm hợp lệ được lưu cho đúng sinh viên và môn học; dữ liệu không hợp lệ bị từ chối kèm thông báo lỗi. |
| FR-09 | Giảng viên | Hệ thống phải cho phép giảng viên công bố điểm sau khi kỳ chấm điểm kết thúc. | Sinh viên không xem được điểm chưa công bố; sau khi công bố, sinh viên liên quan có thể xem điểm. |
| FR-10 | Nhân viên học vụ | Hệ thống phải cho phép thiết lập thời khóa biểu, chỉ tiêu và công bố môn học. | Môn được công bố xuất hiện trong danh mục với lịch học và chỉ tiêu đã được phê duyệt. |
| FR-11 | Nhân viên học vụ | Hệ thống phải cho phép mở và đóng kỳ đăng ký. | Sinh viên chỉ gửi được yêu cầu trong khoảng thời gian mở và đóng đã cấu hình. |
| FR-12 | Nhân viên học vụ | Hệ thống phải hỗ trợ phê duyệt hoặc từ chối các trường hợp đăng ký ngoại lệ. | Quyết định, người xử lý, thời gian và lý do được lưu; sinh viên nhận được thông báo kết quả. |
| FR-13 | Nhân viên học vụ | Hệ thống phải tạo báo cáo ghi danh và phân bố điểm. | Nhân viên được cấp quyền có thể tạo báo cáo theo học kỳ, môn học hoặc chương trình. |
| FR-14 | Quản trị viên | Hệ thống phải hỗ trợ tạo, cập nhật, vô hiệu hóa tài khoản và gán vai trò. | Thay đổi tài khoản và vai trò được lưu và áp dụng cho các lần truy cập tiếp theo. |
| FR-15 | Quản trị viên | Hệ thống phải cho phép cấu hình tham số và quản lý lịch sao lưu. | Quản trị viên được cấp quyền có thể thiết lập tham số, lịch sao lưu và xem kết quả từng lần sao lưu. |

### 2. Yêu cầu phi chức năng – Non-Functional Requirements

Yêu cầu phi chức năng mô tả **CRS phải hoạt động tốt như thế nào**, chẳng hạn hiệu năng, bảo mật, tính sẵn sàng, khả năng truy cập và khả năng mở rộng.

| Phân loại | Mô tả NFR | Tiêu chí chấp nhận |
|---|---|---|
| Hiệu năng – Sức tải | CRS phải hỗ trợ ít nhất 1.000 người dùng đồng thời trong thời gian đăng ký cao điểm. | Kiểm thử tải với 1.000 người dùng hoạt động đồng thời hoàn thành mà không làm hệ thống ngừng hoạt động hoặc từ chối yêu cầu do thiếu năng lực xử lý. |
| Hiệu năng – Thời gian phản hồi | Các trang phải phản hồi dưới ba giây trong thời gian cao điểm. | Khi có 1.000 người dùng đồng thời, mỗi trang được kiểm thử có thời gian phản hồi dưới ba giây. |
| Bảo mật – Truyền dữ liệu | Mọi giao tiếp chứa dữ liệu người dùng, đăng ký hoặc điểm phải sử dụng TLS 1.2 trở lên. | Kiểm thử xác nhận mọi kết nối bên ngoài sử dụng tối thiểu TLS 1.2; giao thức cũ và HTTP không mã hóa bị từ chối hoặc chuyển hướng. |
| Bảo mật – Phân quyền | Hệ thống phải sử dụng RBAC để người dùng chỉ thấy chức năng và dữ liệu phù hợp với vai trò. | Kiểm thử xác nhận bốn vai trò không thể truy cập trang, chức năng hoặc hồ sơ ngoài quyền hạn. |
| Tính sẵn sàng | CRS phải đạt availability 99,5% trong học kỳ. | Dữ liệu giám sát cho thấy hệ thống đạt tối thiểu 99,5% availability trong từng học kỳ, không tính thời gian bảo trì được phê duyệt nếu có. |
| Bảo trì/Vận hành | Bảo trì theo kế hoạch phải được thực hiện ngoài thời gian đăng ký. | Nhật ký triển khai cho thấy không có bảo trì theo kế hoạch gây gián đoạn dịch vụ khi kỳ đăng ký đang mở. |
| Tính tương thích | Giao diện phải hoạt động trên trình duyệt máy tính và thiết bị di động. | Tất cả quy trình quan trọng vượt qua kiểm thử trên danh sách trình duyệt desktop và mobile hiện hành được trường phê duyệt. |
| Khả năng truy cập | Giao diện phải tuân thủ WCAG 2.1 Level AA. | Kiểm thử tự động và đánh giá thủ công không phát hiện lỗi WCAG 2.1 mức A hoặc AA chưa được khắc phục trong các quy trình quan trọng. |
| Khả năng mở rộng | Kiến trúc phải hỗ trợ horizontal scaling khi số lượng sinh viên tăng. | Có thể bổ sung application-server instance mà không sửa mã ứng dụng và yêu cầu được phân phối thành công giữa các instance. |

## Keywords dùng để nhận biết FR và NFR

### Functional Requirements

`browse`, `check eligibility`, `submit`, `track`, `join`, `automatically notifies and enrolls`, `review`, `record`, `release`, `defining`, `setting`, `approving`, `generating`, `manages`, `configures`, `oversees`.

### Non-Functional Requirements

`1,000 simultaneous users`, `under 3 seconds`, `TLS 1.2 or higher`, `RBAC`, `99.5%`, `outside the registration window`, `desktop and mobile browsers`, `WCAG 2.1 Level AA`, `horizontal scaling`.
