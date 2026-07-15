# Functional Requirements và Non-Functional Requirements

## Mục tiêu học tập

Sau bài này, người học có thể:

- Giải thích được Functional Requirements và Non-Functional Requirements.
- Phân biệt được chức năng của hệ thống và thuộc tính chất lượng của hệ thống.
- Viết yêu cầu rõ ràng, cụ thể và có thể kiểm thử.
- Phân tích yêu cầu trong một bài toán phần mềm thực tế.

---

## Tổng quan về Software Requirements

Trong Software Engineering, **Software Requirements – yêu cầu phần mềm** mô tả những điều hệ thống cần đáp ứng. Yêu cầu phần mềm thường được chia thành hai nhóm chính:

- **Functional Requirements (FR):** hệ thống phải làm gì?
- **Non-Functional Requirements (NFR):** hệ thống phải hoạt động như thế nào và phải đạt mức chất lượng nào?

Ví dụ ngắn:

- **Functional:** Hệ thống phải cho phép khách hàng đăng nhập.
- **Non-functional:** Hệ thống phải xử lý 95% yêu cầu đăng nhập trong tối đa 2 giây.

---

# 1. Functional Requirements

## 1.1. Nội dung

**Functional Requirements – yêu cầu chức năng** mô tả chức năng, hành vi, quy trình nghiệp vụ hoặc dịch vụ mà hệ thống phải cung cấp.

Functional Requirements trả lời các câu hỏi:

- Người dùng có thể thực hiện hành động gì?
- Hệ thống tiếp nhận dữ liệu đầu vào nào?
- Hệ thống xử lý dữ liệu như thế nào?
- Hệ thống tạo ra kết quả gì?
- Hệ thống phản ứng như thế nào trong từng tình huống?
- Vai trò nào được phép sử dụng chức năng nào?

Cấu trúc xử lý cơ bản:

```text
Input → Processing → Output
```

Ví dụ với chức năng đăng nhập:

```text
Email và mật khẩu
        ↓
Hệ thống kiểm tra thông tin tài khoản
        ↓
Đăng nhập thành công hoặc thông báo lỗi
```

## 1.2. Phân loại Functional Requirements

| Phân loại | Mô tả | Ví dụ cụ thể |
|---|---|---|
| Quản lý người dùng | Quản lý tài khoản, thông tin và quyền hạn | Đăng ký, đăng nhập, cập nhật profile |
| Xử lý nghiệp vụ | Thực hiện các quy trình chính của hệ thống | Tạo đơn hàng, thanh toán, hủy đơn hàng |
| Quản lý dữ liệu | Thêm, xem, sửa, xóa và tìm kiếm dữ liệu | Thêm sản phẩm, tìm kiếm đơn hàng |
| Tương tác người dùng | Tiếp nhận hành động và trả kết quả | Form nhập liệu, menu, thông báo |
| Báo cáo và thống kê | Tổng hợp và trình bày dữ liệu | Báo cáo doanh thu, thống kê người dùng |
| Phân quyền | Kiểm soát chức năng theo vai trò | Admin được khóa tài khoản khách hàng |
| Tích hợp hệ thống | Trao đổi dữ liệu với hệ thống bên ngoài | Cổng thanh toán, email, vận chuyển |

## 1.3. Giải thích

Một Functional Requirement hoàn chỉnh nên xác định được:

1. **Actor:** ai thực hiện chức năng?
2. **Trigger:** sự kiện nào bắt đầu chức năng?
3. **Input:** dữ liệu đầu vào là gì?
4. **Processing:** hệ thống xử lý như thế nào?
5. **Output:** hệ thống trả về kết quả gì?
6. **Exception:** hệ thống xử lý trường hợp lỗi như thế nào?

### Yêu cầu chưa tốt

> Hệ thống có chức năng đăng nhập tốt.

Yêu cầu này mơ hồ vì từ “tốt” không cho biết hệ thống phải thực hiện hành vi nào và không thể kiểm thử chính xác.

### Yêu cầu tốt hơn

> Hệ thống phải cho phép người dùng đăng nhập bằng email và mật khẩu. Nếu thông tin hợp lệ, hệ thống tạo phiên đăng nhập và chuyển người dùng đến trang chủ. Nếu thông tin không hợp lệ, hệ thống hiển thị thông báo lỗi.

Mẫu viết Functional Requirement phổ biến:

```text
The system shall + hành động cụ thể.
```

Ví dụ:

> The system shall allow customers to search for products by name.

> Hệ thống phải cho phép khách hàng tìm kiếm sản phẩm theo tên.

## 1.4. Ví dụ phân tích: Hệ thống bán hàng online

### FR-01: Đăng nhập

**Yêu cầu:**

> Hệ thống phải cho phép khách hàng đăng nhập bằng email và mật khẩu.

**Phân tích:**

- Actor: khách hàng.
- Input: email và mật khẩu.
- Processing: kiểm tra tài khoản và mật khẩu.
- Output thành công: tạo phiên đăng nhập và chuyển đến trang chủ.
- Output thất bại: hiển thị thông báo lỗi.
- Ngoại lệ: tài khoản bị khóa hoặc chưa được kích hoạt.

**Acceptance Criteria:**

```gherkin
Given khách hàng có tài khoản hợp lệ
When khách hàng nhập đúng email và mật khẩu
Then hệ thống đăng nhập thành công
And chuyển khách hàng đến trang chủ
```

### FR-02: Thêm sản phẩm vào giỏ hàng

**Yêu cầu:**

> Hệ thống phải cho phép khách hàng thêm sản phẩm còn hàng vào giỏ hàng.

**Phân tích:**

- Actor: khách hàng.
- Điều kiện trước: sản phẩm đang được bán và còn hàng.
- Input: mã sản phẩm và số lượng.
- Processing: kiểm tra tồn kho và cập nhật giỏ hàng.
- Output: giỏ hàng hiển thị sản phẩm, số lượng và thành tiền.
- Ngoại lệ: số lượng yêu cầu lớn hơn số lượng tồn kho.

### FR-03: Đặt hàng

**Yêu cầu:**

> Hệ thống phải cho phép khách hàng tạo đơn hàng từ các sản phẩm trong giỏ hàng.

**Luồng chính:**

1. Khách hàng mở giỏ hàng.
2. Khách hàng chọn “Đặt hàng”.
3. Hệ thống yêu cầu địa chỉ nhận hàng.
4. Khách hàng chọn phương thức thanh toán.
5. Hệ thống kiểm tra tồn kho.
6. Hệ thống tính tổng tiền.
7. Hệ thống tạo đơn hàng.
8. Hệ thống gửi thông báo xác nhận.

**Luồng ngoại lệ:**

- Giỏ hàng trống.
- Sản phẩm đã hết hàng.
- Địa chỉ nhận hàng không hợp lệ.
- Thanh toán thất bại.

### FR-04: Quản lý sản phẩm

> Hệ thống phải cho phép Admin thêm, xem, cập nhật và ngừng bán sản phẩm.

Không nên xóa vĩnh viễn một sản phẩm nếu sản phẩm đó đã xuất hiện trong đơn hàng. Việc xóa có thể làm mất dữ liệu lịch sử. Một giải pháp phù hợp hơn là chuyển trạng thái sản phẩm thành **Inactive**.

---

# 2. Non-Functional Requirements

## 2.1. Nội dung

**Non-Functional Requirements – yêu cầu phi chức năng** mô tả thuộc tính chất lượng, giới hạn và tiêu chuẩn vận hành của hệ thống.

NFR không tập trung vào việc hệ thống cung cấp chức năng nào mà tập trung vào các câu hỏi:

- Chức năng phải chạy nhanh đến mức nào?
- Hệ thống phải an toàn như thế nào?
- Bao nhiêu người có thể sử dụng đồng thời?
- Hệ thống phải ổn định đến mức nào?
- Hệ thống có dễ sử dụng và bảo trì không?
- Khi xảy ra sự cố, hệ thống phải phục hồi trong bao lâu?

Một chức năng có thể hoạt động đúng nhưng sản phẩm vẫn thất bại nếu NFR không đạt. Ví dụ, hệ thống thanh toán xử lý đúng quy trình nhưng mỗi giao dịch mất hai phút. Functional Requirement đã được thực hiện, nhưng Performance Requirement không đạt.

## 2.2. Phân loại Non-Functional Requirements

| Loại yêu cầu | Mô tả | Ví dụ có thể đo lường |
|---|---|---|
| Performance | Tốc độ và khả năng xử lý | 95% request phản hồi trong 2 giây |
| Security | Bảo vệ dữ liệu và hệ thống | Tài khoản Admin phải sử dụng MFA |
| Reliability | Khả năng hoạt động chính xác, ổn định | Tỷ lệ giao dịch thành công ≥ 99,9% |
| Availability | Mức độ sẵn sàng của dịch vụ | Uptime mỗi tháng ≥ 99,9% |
| Usability | Mức độ dễ học và dễ sử dụng | 90% người dùng hoàn thành đặt hàng trong 3 phút |
| Scalability | Khả năng đáp ứng khi tải tăng | Hỗ trợ 10.000 người dùng đồng thời |
| Maintainability | Khả năng sửa chữa và nâng cấp | Độ bao phủ unit test ≥ 80% |
| Compatibility | Khả năng tương thích | Hỗ trợ hai phiên bản trình duyệt mới nhất |
| Accessibility | Khả năng tiếp cận | Giao diện đáp ứng WCAG 2.1 mức AA |
| Portability | Khả năng chuyển môi trường | Có thể triển khai hệ thống bằng container |
| Backup and Recovery | Sao lưu và phục hồi | RPO ≤ 15 phút, RTO ≤ 1 giờ |
| Compliance | Tuân thủ quy định và tiêu chuẩn | Dữ liệu được xử lý theo quy định áp dụng |

## 2.3. Giải thích các nhóm NFR

### A. Performance – Hiệu năng

Performance thể hiện tốc độ phản hồi và khả năng xử lý của hệ thống.

Các chỉ số phổ biến:

- **Response time:** thời gian phản hồi.
- **Throughput:** số request hoặc giao dịch được xử lý trong một đơn vị thời gian.
- **Concurrent users:** số người dùng đồng thời.
- **Resource utilization:** mức sử dụng CPU, RAM và ổ đĩa.

Yêu cầu chưa tốt:

> Website phải chạy nhanh.

Yêu cầu tốt hơn:

> Trong điều kiện 1.000 người dùng đồng thời, 95% yêu cầu xem sản phẩm phải được phản hồi trong tối đa 2 giây.

### B. Security – Bảo mật

Security bảo vệ tính bí mật, toàn vẹn và khả dụng của dữ liệu.

Nội dung thường gồm:

- **Authentication:** xác thực danh tính.
- **Authorization:** kiểm soát quyền truy cập.
- **Encryption:** mã hóa dữ liệu.
- **Audit logging:** ghi nhận hoạt động.
- **Session management:** quản lý phiên đăng nhập.

Ví dụ:

> Mật khẩu phải được lưu dưới dạng giá trị băm có salt, không được lưu dưới dạng văn bản thuần.

> Tài khoản Admin phải sử dụng xác thực đa yếu tố.

### C. Reliability và Availability

- **Reliability:** khả năng hệ thống hoạt động chính xác và ổn định trong một khoảng thời gian.
- **Availability:** khả năng hệ thống sẵn sàng phục vụ người dùng.

Ví dụ:

> Hệ thống phải đạt uptime tối thiểu 99,9% mỗi tháng, không tính thời gian bảo trì đã thông báo.

Uptime 99,9% tương đương thời gian ngừng hoạt động khoảng 43 phút mỗi tháng.

### D. Usability – Khả năng sử dụng

Usability đánh giá hệ thống có dễ học, dễ nhớ và dễ thao tác hay không.

Yêu cầu chưa tốt:

> Giao diện phải thân thiện.

Yêu cầu tốt hơn:

> Ít nhất 90% người dùng mới phải hoàn thành quy trình đặt hàng trong vòng 3 phút mà không cần hỗ trợ.

### E. Scalability – Khả năng mở rộng

Scalability là khả năng duy trì chất lượng khi số người dùng, dữ liệu hoặc lưu lượng tăng.

Hai hình thức phổ biến:

- **Vertical scaling:** tăng CPU và RAM cho máy chủ hiện tại.
- **Horizontal scaling:** bổ sung nhiều máy chủ.

Ví dụ:

> Hệ thống phải hỗ trợ tối thiểu 10.000 người dùng đồng thời mà vẫn đáp ứng yêu cầu về thời gian phản hồi.

### F. Maintainability – Khả năng bảo trì

Maintainability thể hiện mức độ dễ hiểu, sửa lỗi, kiểm thử và nâng cấp phần mềm.

Ví dụ:

- Các API public phải có tài liệu.
- Các module nghiệp vụ phải có unit test.
- Hệ thống phải ghi log đủ để xác định nguyên nhân giao dịch thất bại.
- Các thành phần nên có độ phụ thuộc thấp.

## 2.4. Cách viết NFR có thể kiểm thử

Một NFR tốt nên có cấu trúc:

```text
Đối tượng + Điều kiện + Chỉ số + Ngưỡng chấp nhận
```

Ví dụ:

> Trong giờ cao điểm với 2.000 người dùng đồng thời, 95% yêu cầu tìm kiếm sản phẩm phải được phản hồi trong tối đa 2 giây.

Phân tích:

- Đối tượng: chức năng tìm kiếm sản phẩm.
- Điều kiện: giờ cao điểm với 2.000 người dùng đồng thời.
- Chỉ số: response time.
- Ngưỡng chấp nhận: tối đa 2 giây với 95% yêu cầu.

Mẫu viết:

```text
Hệ thống phải đạt [chỉ số] ở mức [giá trị] trong điều kiện [bối cảnh].
```

---

# 3. Ví dụ tổng hợp để phân tích

## 3.1. Bài toán: Hệ thống ngân hàng trực tuyến

Ngân hàng muốn xây dựng hệ thống cho phép khách hàng:

- Đăng nhập.
- Xem số dư.
- Chuyển tiền.
- Xem lịch sử giao dịch.
- Nhận thông báo giao dịch.

## 3.2. Functional Requirements

### FR-01: Xem số dư

> Hệ thống phải cho phép khách hàng đã đăng nhập xem số dư khả dụng của từng tài khoản.

Đây là Functional Requirement vì nó mô tả một chức năng mà hệ thống phải cung cấp.

### FR-02: Chuyển tiền

> Hệ thống phải cho phép khách hàng chuyển tiền đến một tài khoản hợp lệ khi số dư khả dụng đủ.

Các quy tắc nghiệp vụ:

- Số tiền chuyển phải lớn hơn 0.
- Số dư khả dụng phải đủ.
- Tài khoản nhận phải hợp lệ.
- Giao dịch không được vượt hạn mức.
- Giao dịch thành công phải có mã tham chiếu.
- Giao dịch thất bại không được trừ tiền.

### FR-03: Gửi thông báo

> Sau khi chuyển tiền thành công, hệ thống phải gửi thông báo chứa mã giao dịch, số tiền và thời gian thực hiện cho khách hàng.

## 3.3. Non-Functional Requirements

### NFR-01: Hiệu năng

> Trong điều kiện 5.000 người dùng đồng thời, 95% yêu cầu xem số dư phải được phản hồi trong tối đa 2 giây.

### NFR-02: Bảo mật

> Tài khoản phải bị khóa tạm thời trong 15 phút sau năm lần đăng nhập thất bại liên tiếp.

### NFR-03: Độ tin cậy

> Mỗi yêu cầu chuyển tiền chỉ được ghi nhận một lần, kể cả khi khách hàng gửi lại yêu cầu do mất kết nối.

### NFR-04: Khả dụng

> Dịch vụ chuyển tiền phải đạt uptime tối thiểu 99,95% mỗi tháng, không tính thời gian bảo trì đã thông báo.

### NFR-05: Phục hồi

> Sau sự cố nghiêm trọng, hệ thống phải phục hồi dịch vụ trong tối đa 30 phút và không được mất quá 5 phút dữ liệu giao dịch.

## 3.4. Phân tích và phân loại

| Yêu cầu | Loại | Lý do |
|---|---|---|
| Khách hàng xem được số dư | Functional | Mô tả hệ thống làm gì |
| Kết quả số dư được trả về trong 2 giây | Non-functional | Mô tả tốc độ thực hiện |
| Khách hàng chuyển tiền | Functional | Mô tả chức năng nghiệp vụ |
| Giao dịch không bị thực hiện hai lần | Non-functional | Mô tả độ tin cậy |
| Hệ thống gửi thông báo | Functional | Mô tả hành vi của hệ thống |
| Dữ liệu được truyền qua kết nối mã hóa | Non-functional | Mô tả yêu cầu bảo mật |

Functional Requirements và Non-Functional Requirements thường liên kết với nhau:

```text
FR:  Hệ thống cho phép khách hàng chuyển tiền.
                         +
NFR: Giao dịch phải an toàn, chính xác và xử lý trong 3 giây.
```

Nếu chỉ có FR, nhóm biết cần xây dựng chức năng gì nhưng chưa biết mức chất lượng cần đạt. Nếu chỉ có NFR, nhóm biết tiêu chuẩn chất lượng nhưng chưa biết chính xác chức năng nào cần được xây dựng.

---

# 4. So sánh nhanh

| Tiêu chí | Functional Requirements | Non-Functional Requirements |
|---|---|---|
| Câu hỏi chính | Hệ thống làm gì? | Hệ thống hoạt động như thế nào? |
| Nội dung | Chức năng và quy trình nghiệp vụ | Thuộc tính chất lượng và giới hạn |
| Ví dụ | Đăng nhập, đặt hàng, thanh toán | Tốc độ, bảo mật, độ ổn định |
| Phạm vi | Thường gắn với một use case | Có thể ảnh hưởng toàn bộ hệ thống |
| Cách kiểm thử | Functional test, acceptance test | Performance, security, usability test |
| Khi không đạt | Thiếu hoặc sai chức năng | Chức năng đúng nhưng chất lượng không đạt |

---

# 5. Keywords

## Functional Requirements

- Actor
- Use Case
- Business Rule
- Input
- Processing
- Output
- Main Flow
- Alternative Flow
- Exception Flow
- Acceptance Criteria
- Validation
- CRUD: Create, Read, Update, Delete

## Non-Functional Requirements

- Performance
- Response Time
- Throughput
- Security
- Authentication
- Authorization
- Encryption
- Reliability
- Availability
- Uptime
- Usability
- Scalability
- Maintainability
- Compatibility
- Accessibility
- RTO: Recovery Time Objective
- RPO: Recovery Point Objective

---

# Tổng kết

```text
Functional Requirement     = WHAT
                             Hệ thống làm gì?

Non-Functional Requirement = HOW WELL
                             Hệ thống thực hiện tốt đến mức nào?
```

Ví dụ ghi nhớ:

- **FR:** Hệ thống cho phép người dùng đăng nhập.
- **NFR:** 95% yêu cầu đăng nhập phải được xử lý trong tối đa 2 giây.

> “Non-functional” không có nghĩa là “không quan trọng”. Trong các hệ thống ngân hàng, y tế hoặc hàng không, yêu cầu về bảo mật, độ tin cậy và an toàn có thể quan trọng hơn nhiều chức năng thông thường.
