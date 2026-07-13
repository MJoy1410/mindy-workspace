# Waterfall Model

## 1. Tổng quan

**Waterfall Model** (mô hình thác nước) là một mô hình phát triển phần mềm theo trình tự tuyến tính. Dự án được chia thành các giai đoạn riêng biệt và thực hiện lần lượt từ trên xuống dưới, giống như nước chảy qua từng bậc thác.

Thông thường, một giai đoạn cần được hoàn thành, lập tài liệu, kiểm tra và phê duyệt trước khi nhóm dự án chuyển sang giai đoạn tiếp theo.

```text
Requirements Analysis
        ↓
System Design
        ↓
Implementation
        ↓
Testing
        ↓
Deployment
        ↓
Maintenance
```

Đầu ra của giai đoạn trước là đầu vào của giai đoạn sau. Ví dụ:

- Tài liệu yêu cầu là cơ sở để thiết kế hệ thống.
- Bản thiết kế là cơ sở để lập trình.
- Mã nguồn hoàn chỉnh là đối tượng của quá trình kiểm thử.
- Sản phẩm vượt qua kiểm thử mới được triển khai.

Waterfall vẫn có thể quay lại giai đoạn trước khi phát hiện sai sót. Tuy nhiên, việc thay đổi muộn thường khó khăn và tốn kém vì có thể phải sửa đồng thời yêu cầu, thiết kế, mã nguồn, kiểm thử và tài liệu.

---

## 2. Các giai đoạn chính

### 2.1. Requirements Analysis – Thu thập và phân tích yêu cầu

Nhóm dự án làm việc với khách hàng và người dùng để xác định phần mềm cần làm gì.

Các nội dung thường được phân tích:

- Mục tiêu và phạm vi dự án.
- Chức năng của hệ thống.
- Quy tắc nghiệp vụ.
- Yêu cầu phi chức năng như hiệu năng, bảo mật và độ tin cậy.
- Giới hạn về công nghệ, ngân sách và thời gian.
- Tiêu chí kiểm thử và nghiệm thu.

Đầu ra quan trọng của giai đoạn này thường là **Software Requirements Specification (SRS)** – tài liệu đặc tả yêu cầu phần mềm.

Một yêu cầu tốt cần:

- Rõ ràng và không mơ hồ.
- Đầy đủ và nhất quán.
- Có thể kiểm tra được.
- Có khả năng truy vết đến thiết kế và test case.

### 2.2. System Design – Thiết kế hệ thống

Nhóm kỹ thuật xác định cách xây dựng phần mềm để đáp ứng các yêu cầu đã được phê duyệt.

Hoạt động thiết kế có thể bao gồm:

- Thiết kế kiến trúc tổng thể.
- Thiết kế cơ sở dữ liệu.
- Phân chia module và trách nhiệm của từng module.
- Thiết kế giao diện người dùng.
- Thiết kế API và cách các thành phần giao tiếp.
- Lựa chọn công nghệ.
- Thiết kế bảo mật và phân quyền.

Có thể hiểu ngắn gọn:

- **Yêu cầu** mô tả hệ thống phải làm gì.
- **Thiết kế** mô tả hệ thống sẽ thực hiện điều đó như thế nào.

### 2.3. Implementation – Lập trình

Lập trình viên chuyển bản thiết kế thành mã nguồn hoạt động được.

Các công việc chính:

- Xây dựng từng module.
- Tạo cơ sở dữ liệu.
- Viết logic nghiệp vụ.
- Tích hợp các thành phần.
- Thực hiện unit test cho các đơn vị mã nguồn.
- Kiểm tra mã nguồn và cập nhật tài liệu kỹ thuật.

Trong Waterfall, việc lập trình thường chỉ bắt đầu sau khi thiết kế đã tương đối hoàn chỉnh và được phê duyệt.

### 2.4. Testing – Kiểm thử

Mục tiêu của kiểm thử là xác minh phần mềm có hoạt động đúng theo tài liệu yêu cầu hay không, đồng thời phát hiện lỗi trước khi triển khai.

Một số cấp độ kiểm thử phổ biến:

- **Unit Testing:** kiểm thử từng hàm, lớp hoặc module.
- **Integration Testing:** kiểm thử sự phối hợp giữa các module.
- **System Testing:** kiểm thử toàn bộ hệ thống.
- **Acceptance Testing:** khách hàng hoặc người dùng kiểm tra để nghiệm thu.
- **Regression Testing:** kiểm tra lại để bảo đảm việc sửa lỗi không làm hỏng chức năng cũ.

Nếu lỗi bắt nguồn từ yêu cầu hoặc thiết kế, nhóm có thể phải quay lại các giai đoạn trước và cập nhật tất cả sản phẩm liên quan.

### 2.5. Deployment – Triển khai

Sau khi hệ thống vượt qua kiểm thử và được chấp nhận, phần mềm được đưa vào môi trường thực tế.

Hoạt động triển khai có thể gồm:

- Cài đặt và cấu hình phần mềm.
- Thiết lập máy chủ và cơ sở dữ liệu.
- Chuyển đổi dữ liệu từ hệ thống cũ.
- Tạo tài khoản và phân quyền.
- Đào tạo người dùng.
- Bàn giao tài liệu vận hành và hướng dẫn sử dụng.

### 2.6. Maintenance – Vận hành và bảo trì

Phần mềm tiếp tục được hỗ trợ sau khi triển khai.

Bốn loại bảo trì thường gặp:

| Loại bảo trì | Mục đích |
|---|---|
| Corrective | Sửa lỗi được phát hiện khi vận hành |
| Adaptive | Điều chỉnh để phù hợp với môi trường hoặc nền tảng mới |
| Perfective | Cải thiện hiệu năng, tính năng hoặc trải nghiệm sử dụng |
| Preventive | Cải thiện mã nguồn để giảm rủi ro lỗi trong tương lai |

---

## 3. Đặc điểm nổi bật

- Quy trình phát triển tuyến tính và có thứ tự rõ ràng.
- Mỗi giai đoạn có mục tiêu, hoạt động và sản phẩm bàn giao cụ thể.
- Yêu cầu được xác định tương đối đầy đủ từ đầu.
- Tài liệu hóa chặt chẽ trong toàn bộ dự án.
- Tiến độ được theo dõi thông qua các mốc hoàn thành và phê duyệt.
- Khách hàng thường tham gia nhiều ở giai đoạn yêu cầu và nghiệm thu.
- Phiên bản hoàn chỉnh của phần mềm thường xuất hiện khá muộn.
- Thay đổi yêu cầu sau khi thiết kế hoặc lập trình đã bắt đầu thường tốn kém.
- Kiểm thử toàn hệ thống chủ yếu diễn ra sau giai đoạn lập trình.

---

## 4. Khi nào nên sử dụng?

Waterfall phù hợp khi:

- Yêu cầu rõ ràng, đầy đủ và ổn định.
- Khả năng thay đổi yêu cầu trong tương lai thấp.
- Công nghệ sử dụng đã quen thuộc và ít rủi ro.
- Phạm vi, ngân sách và thời hạn cần được xác định từ đầu.
- Dự án có quy trình phê duyệt chính thức.
- Hợp đồng quy định rõ sản phẩm và tiêu chí nghiệm thu.
- Dự án yêu cầu nhiều tài liệu hoặc khả năng truy vết cao.
- Quy trình nghiệp vụ đã ổn định và được hiểu rõ.

Ví dụ phù hợp:

- Số hóa một quy trình hành chính đã ổn định nhiều năm.
- Phát triển phần mềm theo đặc tả cố định trong hợp đồng.
- Chuyển một hệ thống cũ sang nền tảng mới nhưng giữ nguyên chức năng.
- Một số dự án thuộc môi trường được quản lý nghiêm ngặt và yêu cầu tài liệu đầy đủ.

Waterfall thường không phù hợp khi:

- Khách hàng chưa xác định rõ nhu cầu.
- Yêu cầu thay đổi thường xuyên.
- Sản phẩm cần thử nghiệm nhanh với người dùng hoặc thị trường.
- Công nghệ mới và có nhiều rủi ro kỹ thuật.
- Cần phát hành giá trị sớm theo từng chu kỳ ngắn.
- Phản hồi liên tục của người dùng có vai trò quyết định.

Trong những trường hợp trên, mô hình lặp hoặc Agile thường phù hợp hơn.

---

## 5. Ưu điểm và nhược điểm

| Ưu điểm | Nhược điểm |
|---|---|
| Quy trình đơn giản, dễ hiểu | Khó thích nghi khi yêu cầu thay đổi |
| Giai đoạn và trách nhiệm rõ ràng | Người dùng thấy phần mềm hoạt động khá muộn |
| Dễ lập kế hoạch khi yêu cầu ổn định | Sai yêu cầu ban đầu có thể gây hậu quả lớn |
| Dễ theo dõi tiến độ qua các mốc | Thay đổi muộn có chi phí cao |
| Tài liệu đầy đủ, thuận lợi cho bàn giao | Phản hồi thực tế đến chậm |
| Phù hợp với hợp đồng có phạm vi cố định | Rủi ro tích hợp có thể được phát hiện muộn |
| Có khả năng truy vết từ yêu cầu đến kiểm thử | Khách hàng ít tham gia trong giai đoạn xây dựng |
| Phù hợp với môi trường quản lý nghiêm ngặt | Có thể tạo ra sản phẩm đúng tài liệu nhưng chưa đúng nhu cầu thực tế |

### Chi phí thay đổi tăng theo thời gian

Giả sử hệ thống bị thiếu một trường dữ liệu:

- Nếu phát hiện khi phân tích yêu cầu: chỉ cần cập nhật SRS.
- Nếu phát hiện khi thiết kế: phải sửa SRS, cơ sở dữ liệu và giao diện.
- Nếu phát hiện khi lập trình: phải sửa thêm mã nguồn.
- Nếu phát hiện khi kiểm thử: phải cập nhật test case và kiểm thử hồi quy.
- Nếu phát hiện sau triển khai: có thể phải chuyển đổi dữ liệu và cập nhật hệ thống đang vận hành.

Vì vậy, hạn chế quan trọng của Waterfall không phải là hoàn toàn không thể thay đổi, mà là **thay đổi càng muộn thì càng tốn kém**.

---

## 6. Ví dụ: Hệ thống quản lý thư viện

### Bối cảnh

Một trường học muốn xây dựng hệ thống quản lý thư viện. Quy trình mượn sách đã ổn định, ngân sách cố định và nhà trường yêu cầu đầy đủ tài liệu bàn giao. Đây là một trường hợp có thể cân nhắc Waterfall.

### Giai đoạn 1: Phân tích yêu cầu

Nhà trường xác định các yêu cầu:

- Quản lý sách và từng bản sao của sách.
- Quản lý thông tin học sinh.
- Cho mượn và nhận trả sách.
- Mỗi học sinh được mượn tối đa ba cuốn.
- Thời hạn mượn là 14 ngày.
- Tiền phạt trả trễ là 5.000 đồng mỗi ngày cho mỗi cuốn.
- Thống kê sách đang được mượn.
- Chỉ thủ thư được cập nhật thông tin sách.

Nhóm dự án ghi các yêu cầu vào SRS và yêu cầu nhà trường phê duyệt.

### Giai đoạn 2: Thiết kế

Nhóm kỹ thuật thiết kế:

- Bảng `Book` lưu thông tin đầu sách.
- Bảng `BookCopy` quản lý từng bản sao.
- Bảng `Student` lưu thông tin học sinh.
- Bảng `Loan` lưu giao dịch mượn và trả.
- Màn hình tìm kiếm sách.
- Màn hình lập phiếu mượn.
- Màn hình nhận trả sách.
- Module tính tiền phạt.
- Chức năng đăng nhập và phân quyền.

Quy tắc tính tiền phạt:

```text
Nếu ngày trả thực tế > ngày phải trả:
    Số ngày trễ = ngày trả thực tế - ngày phải trả
    Tiền phạt = số ngày trễ × 5.000 đồng
```

### Giai đoạn 3: Lập trình

Lập trình viên xây dựng các module theo bản thiết kế:

1. Quản lý sách.
2. Quản lý học sinh.
3. Mượn và trả sách.
4. Tính tiền phạt.
5. Báo cáo và thống kê.
6. Đăng nhập và phân quyền.

### Giai đoạn 4: Kiểm thử

Nhóm kiểm thử xây dựng các trường hợp sau:

| Trường hợp kiểm thử | Kết quả mong đợi |
|---|---|
| Học sinh đang mượn hai cuốn và mượn thêm một cuốn | Được phép |
| Học sinh đã mượn ba cuốn và muốn mượn cuốn thứ tư | Bị từ chối |
| Học sinh trả sách đúng hạn | Không có tiền phạt |
| Học sinh trả một cuốn trễ hai ngày | Phạt 10.000 đồng |
| Người không phải thủ thư sửa thông tin sách | Hệ thống từ chối |

Sau khi kiểm thử hệ thống hoàn tất, nhà trường thực hiện acceptance testing dựa trên SRS.

### Giai đoạn 5: Triển khai

Nhóm dự án:

- Cài đặt hệ thống trên máy chủ của trường.
- Nhập danh mục sách và học sinh.
- Tạo tài khoản cho thủ thư.
- Đào tạo người dùng.
- Bàn giao tài liệu kỹ thuật và hướng dẫn sử dụng.

### Giai đoạn 6: Bảo trì

Sau khi hệ thống đi vào hoạt động, nhóm phát triển sửa lỗi và điều chỉnh khi môi trường vận hành thay đổi.

Giả sử sau khi lập trình xong, nhà trường yêu cầu thêm chức năng **đặt sách trực tuyến**. Yêu cầu này có thể ảnh hưởng đến:

- SRS.
- Thiết kế cơ sở dữ liệu.
- Giao diện.
- Phân quyền.
- Logic giữ và hủy đặt sách.
- Mã nguồn.
- Test case.
- Hướng dẫn sử dụng.

Đây là minh họa điển hình cho hạn chế của Waterfall: một yêu cầu xuất hiện muộn có thể buộc nhiều giai đoạn đã hoàn thành phải được xem xét lại.

---

## 7. Tóm tắt ghi nhớ

> **Waterfall = hoàn thành từng giai đoạn theo thứ tự, tài liệu rõ ràng, thay đổi muộn có chi phí cao.**

- Phù hợp nhất khi yêu cầu **rõ ràng và ổn định**.
- Quy trình chính: **Requirements → Design → Implementation → Testing → Deployment → Maintenance**.
- Điểm mạnh: dễ quản lý, dễ lập kế hoạch và có tài liệu đầy đủ.
- Điểm yếu: phản hồi muộn và khó thích nghi với thay đổi.
- Nếu dự án cần thử nghiệm và thay đổi liên tục, nên cân nhắc Agile hoặc mô hình lặp.

## 8. Câu hỏi tự kiểm tra

1. Vì sao Waterfall được gọi là mô hình phát triển tuyến tính?
2. Đầu ra chính của giai đoạn Requirements Analysis là gì?
3. Sự khác nhau giữa yêu cầu và thiết kế là gì?
4. Vì sao thay đổi yêu cầu muộn thường có chi phí cao?
5. Nêu hai trường hợp phù hợp và hai trường hợp không phù hợp với Waterfall.
6. Waterfall có hoàn toàn cấm quay lại giai đoạn trước hay không?
7. Trong ví dụ thư viện, yêu cầu đặt sách trực tuyến ảnh hưởng đến những thành phần nào?
