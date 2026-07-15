# So sánh Waterfall và Scrum (Agile)

## Mục tiêu học tập

Sau bài này, người học có thể:

- Trình bày được đặc điểm và quy trình của Waterfall và Scrum.
- Giải thích được cách một dự án phần mềm vận hành theo từng mô hình.
- So sánh ưu điểm, hạn chế và phạm vi áp dụng của hai mô hình.
- Ghi nhớ các thuật ngữ quan trọng liên quan đến Waterfall, Agile và Scrum.

> **Lưu ý:** Agile là một tư duy và tập hợp các giá trị, nguyên tắc phát triển phần mềm linh hoạt. Scrum là một framework phổ biến giúp nhóm áp dụng tư duy Agile. Vì vậy, Scrum thuộc Agile nhưng Agile không chỉ có Scrum.

---

## 1. Nội dung

### 1.1. Waterfall Model

**Waterfall** (mô hình thác nước) là mô hình phát triển phần mềm theo trình tự tuyến tính. Dự án được chia thành các giai đoạn riêng biệt; nhóm thường hoàn thành và phê duyệt một giai đoạn trước khi chuyển sang giai đoạn tiếp theo.

```text
Requirements → Design → Implementation → Testing → Deployment → Maintenance
```

Các giai đoạn chính:

1. **Requirements Analysis – Phân tích yêu cầu:** xác định hệ thống cần làm gì.
2. **System Design – Thiết kế hệ thống:** xác định kiến trúc, cơ sở dữ liệu, giao diện và giải pháp kỹ thuật.
3. **Implementation – Lập trình:** chuyển thiết kế thành mã nguồn.
4. **Testing – Kiểm thử:** kiểm tra sản phẩm có đáp ứng yêu cầu hay không.
5. **Deployment – Triển khai:** đưa phần mềm vào môi trường sử dụng thực tế.
6. **Maintenance – Bảo trì:** sửa lỗi, hỗ trợ và nâng cấp hệ thống sau khi triển khai.

Đặc điểm nổi bật:

- Phạm vi, thời gian và chi phí thường được lên kế hoạch chi tiết từ đầu.
- Yêu cầu cần tương đối đầy đủ và ổn định.
- Tài liệu và hoạt động phê duyệt có vai trò quan trọng.
- Sản phẩm hoàn chỉnh thường được bàn giao vào cuối dự án.
- Thay đổi ở giai đoạn muộn có thể tốn nhiều thời gian và chi phí.

### 1.2. Scrum (Agile)

**Scrum** là một framework phát triển sản phẩm theo cách **lặp** và **tăng trưởng**. Công việc được chia thành các chu kỳ ngắn gọi là **Sprint**, thường kéo dài từ một đến bốn tuần. Sau mỗi Sprint, nhóm tạo ra một phần sản phẩm có giá trị và có thể sử dụng được.

```text
Product Backlog
       ↓
Sprint Planning
       ↓
Sprint: Analyze → Design → Code → Test
       ↓
Product Increment
       ↓
Review + Retrospective → Sprint tiếp theo
```

Ba trách nhiệm chính trong Scrum:

- **Product Owner:** tối đa hóa giá trị sản phẩm, quản lý và sắp xếp ưu tiên Product Backlog.
- **Scrum Master:** giúp nhóm hiểu và áp dụng Scrum, đồng thời hỗ trợ loại bỏ trở ngại.
- **Developers:** nhóm chuyên môn trực tiếp tạo ra Product Increment trong mỗi Sprint.

Các sự kiện chính:

1. **Sprint:** chu kỳ chứa toàn bộ công việc cần thiết để tạo ra Increment.
2. **Sprint Planning:** xác định Sprint Goal và lựa chọn công việc cho Sprint.
3. **Daily Scrum:** cuộc họp ngắn hằng ngày để Developers kiểm tra tiến độ và điều chỉnh kế hoạch.
4. **Sprint Review:** trình bày Increment, nhận phản hồi và điều chỉnh Product Backlog.
5. **Sprint Retrospective:** đánh giá cách làm việc và đề xuất cải tiến cho Sprint tiếp theo.

Các Scrum Artifacts:

- **Product Backlog:** danh sách công việc cần thiết cho sản phẩm.
- **Sprint Backlog:** Sprint Goal, các hạng mục được chọn và kế hoạch thực hiện.
- **Increment:** tổng các hạng mục đã hoàn thành, đáp ứng Definition of Done.

Đặc điểm nổi bật:

- Phần mềm được phát triển và bàn giao từng phần.
- Phản hồi của khách hàng và người dùng được thu thập thường xuyên.
- Nhóm có thể điều chỉnh ưu tiên khi nhu cầu thay đổi.
- Phân tích, thiết kế, lập trình và kiểm thử diễn ra trong mỗi Sprint.
- Nhóm cần giao tiếp tốt, minh bạch và có khả năng tự quản.

---

## 2. Giải thích bằng ví dụ

Giả sử một công ty muốn xây dựng website bán hàng gồm các chức năng:

- Đăng ký và đăng nhập.
- Xem, tìm kiếm sản phẩm.
- Giỏ hàng.
- Thanh toán trực tuyến.
- Theo dõi đơn hàng.

### 2.1. Nếu áp dụng Waterfall

Nhóm dự án sẽ cố gắng thu thập và đặc tả toàn bộ yêu cầu ngay từ đầu. Sau khi khách hàng phê duyệt tài liệu yêu cầu, nhóm mới chuyển sang thiết kế toàn bộ hệ thống, sau đó lập trình, kiểm thử và triển khai.

Khách hàng thường nhìn thấy sản phẩm hoàn chỉnh ở gần cuối dự án. Nếu lúc đó khách hàng muốn thay đổi quy trình thanh toán, nhóm có thể phải sửa tài liệu yêu cầu, thiết kế, mã nguồn và test case.

Waterfall phù hợp hơn khi:

- Yêu cầu rõ ràng và ít thay đổi.
- Công nghệ đã quen thuộc.
- Dự án cần tài liệu, phê duyệt hoặc truy vết nghiêm ngặt.
- Phạm vi và tiêu chí nghiệm thu có thể xác định sớm.

### 2.2. Nếu áp dụng Scrum

Nhóm sắp xếp yêu cầu theo mức độ ưu tiên trong Product Backlog và phát triển sản phẩm qua nhiều Sprint. Ví dụ:

- **Sprint 1:** đăng ký, đăng nhập và xem sản phẩm.
- **Sprint 2:** tìm kiếm sản phẩm và giỏ hàng.
- **Sprint 3:** thanh toán trực tuyến.
- **Sprint 4:** theo dõi đơn hàng và cải tiến theo phản hồi.

Sau mỗi Sprint, khách hàng có thể xem phần sản phẩm đã hoàn thành và đưa ra phản hồi. Product Owner sử dụng phản hồi đó để điều chỉnh thứ tự ưu tiên cho các Sprint tiếp theo.

Scrum phù hợp hơn khi:

- Yêu cầu chưa hoàn toàn rõ hoặc có khả năng thay đổi.
- Doanh nghiệp cần đưa sản phẩm ra thị trường sớm.
- Người dùng và khách hàng có thể phản hồi thường xuyên.
- Công việc có thể chia thành các phần nhỏ, có giá trị.

---

## 3. So sánh Waterfall và Scrum

### 3.1. Điểm giống nhau

- Đều hướng đến việc tạo ra phần mềm đáp ứng nhu cầu của khách hàng.
- Đều có các hoạt động phân tích, thiết kế, lập trình, kiểm thử và triển khai.
- Đều cần quản lý phạm vi, thời gian, chi phí, chất lượng và rủi ro.
- Đều cần sự phối hợp giữa các thành viên và bên liên quan.

### 3.2. Điểm khác nhau

| Tiêu chí | Waterfall | Scrum (Agile) |
|---|---|---|
| Cách tiếp cận | Tuần tự, theo từng giai đoạn | Lặp và tăng trưởng qua nhiều Sprint |
| Kế hoạch | Lập kế hoạch chi tiết từ đầu | Lập kế hoạch tổng thể và điều chỉnh theo từng Sprint |
| Yêu cầu | Cần rõ ràng, tương đối ổn định | Có thể được làm rõ và thay đổi dần |
| Phạm vi | Thường cố định sớm | Được sắp xếp lại theo giá trị và phản hồi |
| Bàn giao | Thường bàn giao sản phẩm ở cuối dự án | Bàn giao Increment sau mỗi Sprint |
| Phản hồi khách hàng | Tập trung nhiều ở đầu và cuối dự án | Thường xuyên sau từng Sprint |
| Kiểm thử | Có một giai đoạn kiểm thử riêng sau lập trình | Kiểm thử liên tục trong mỗi Sprint |
| Tài liệu | Thường chi tiết và cần phê duyệt | Tài liệu vừa đủ để hỗ trợ tạo ra giá trị |
| Quản lý thay đổi | Quy trình thay đổi thường chặt chẽ; thay đổi muộn tốn kém | Chủ động thích nghi thông qua Product Backlog |
| Đo lường tiến độ | Hoàn thành giai đoạn, tài liệu và mốc kế hoạch | Increment hoạt động được và Sprint Goal |
| Tổ chức nhóm | Thường chia theo chức năng và chịu sự điều phối của Project Manager | Nhóm đa chức năng, tự quản; không có vai trò Project Manager trong Scrum |
| Rủi ro | Một số rủi ro có thể được phát hiện muộn | Phản hồi sớm giúp phát hiện và xử lý rủi ro sớm hơn |
| Khả năng dự đoán | Cao hơn nếu yêu cầu ổn định | Linh hoạt hơn nhưng khó cố định toàn bộ phạm vi từ đầu |
| Phù hợp | Dự án ổn định, quy định chặt chẽ | Sản phẩm phức tạp, thị trường và yêu cầu thay đổi |

### 3.3. Ưu điểm và hạn chế

#### Waterfall

**Ưu điểm:**

- Quy trình và mốc bàn giao rõ ràng.
- Dễ theo dõi khi phạm vi ổn định.
- Tài liệu đầy đủ, thuận lợi cho kiểm toán, bàn giao và bảo trì.
- Phù hợp với dự án có yêu cầu pháp lý hoặc hợp đồng cố định.

**Hạn chế:**

- Khó thích nghi với thay đổi lớn.
- Khách hàng phải chờ lâu mới sử dụng được sản phẩm.
- Phản hồi và kiểm thử toàn hệ thống có thể xuất hiện muộn.
- Sai sót trong yêu cầu ban đầu có thể ảnh hưởng nhiều giai đoạn sau.

#### Scrum

**Ưu điểm:**

- Cung cấp giá trị sớm và thường xuyên.
- Thích nghi tốt với thay đổi.
- Nhận phản hồi sớm từ khách hàng và người dùng.
- Kiểm tra chất lượng và rủi ro liên tục qua từng Sprint.
- Khuyến khích giao tiếp, minh bạch và cải tiến liên tục.

**Hạn chế:**

- Khó cam kết chính xác toàn bộ phạm vi dài hạn khi yêu cầu còn biến động.
- Cần Product Owner tham gia và ra quyết định thường xuyên.
- Đòi hỏi nhóm có tính tự quản và hợp tác tốt.
- Product Backlog quản lý không tốt có thể khiến sản phẩm thiếu định hướng.

### 3.4. Cách lựa chọn

Không có mô hình nào luôn tốt hơn trong mọi trường hợp. Lựa chọn phụ thuộc vào đặc điểm của dự án.

Chọn **Waterfall** khi:

- Yêu cầu đã rõ ràng, ổn định và được phê duyệt.
- Thay đổi bị hạn chế bởi hợp đồng hoặc quy định.
- Cần tài liệu và khả năng truy vết chi tiết.
- Có thể dự đoán công nghệ, phạm vi và kết quả từ sớm.

Chọn **Scrum** khi:

- Sản phẩm phức tạp và yêu cầu có thể thay đổi.
- Cần phát hành tính năng quan trọng sớm.
- Có thể chia sản phẩm thành các Increment nhỏ có giá trị.
- Khách hàng, Product Owner và nhóm có thể cộng tác thường xuyên.

Trong thực tế, tổ chức cũng có thể sử dụng cách tiếp cận kết hợp. Tuy nhiên, việc kết hợp cần có mục đích rõ ràng, không nên chỉ đổi tên các giai đoạn Waterfall thành Sprint.

---

## 4. Keywords

### 4.1. Waterfall Keywords

| Keyword | Nghĩa |
|---|---|
| Sequential | Tuần tự |
| Linear process | Quy trình tuyến tính |
| Phase | Giai đoạn |
| Upfront planning | Lập kế hoạch chi tiết từ đầu |
| Fixed requirements | Yêu cầu cố định |
| Requirements Specification | Tài liệu đặc tả yêu cầu |
| Documentation | Tài liệu |
| Sign-off | Phê duyệt chính thức |
| Change Request | Yêu cầu thay đổi |
| Verification | Xác minh sản phẩm được xây dựng đúng theo đặc tả |
| Validation | Xác nhận sản phẩm đáp ứng đúng nhu cầu sử dụng |
| Predictability | Khả năng dự đoán |
| Change cost | Chi phí thay đổi |

### 4.2. Agile/Scrum Keywords

| Keyword | Nghĩa |
|---|---|
| Agile | Tư duy phát triển linh hoạt |
| Iterative | Phát triển lặp |
| Incremental | Phát triển tăng trưởng từng phần |
| Empiricism | Ra quyết định dựa trên quan sát và kinh nghiệm |
| Transparency | Minh bạch |
| Inspection | Kiểm tra |
| Adaptation | Thích nghi, điều chỉnh |
| Sprint | Chu kỳ phát triển ngắn, tối đa một tháng |
| Product Backlog | Danh sách công việc cần thiết cho sản phẩm |
| Sprint Backlog | Công việc và kế hoạch của Sprint hiện tại |
| Product Increment | Phần sản phẩm hoàn thành và có giá trị |
| Product Owner | Người chịu trách nhiệm tối đa hóa giá trị sản phẩm |
| Scrum Master | Người giúp nhóm áp dụng Scrum hiệu quả |
| Developers | Những người tạo ra Increment |
| Sprint Goal | Mục tiêu của Sprint |
| User Story | Cách mô tả ngắn một nhu cầu từ góc nhìn người dùng |
| Acceptance Criteria | Điều kiện để một yêu cầu được chấp nhận |
| Definition of Done | Tiêu chuẩn chung để xác định công việc đã hoàn thành |
| Daily Scrum | Sự kiện hằng ngày dành cho Developers |
| Sprint Review | Đánh giá kết quả Sprint và nhận phản hồi |
| Sprint Retrospective | Nhìn lại và cải tiến cách làm việc |
| Feedback | Phản hồi |
| Self-management | Khả năng tự quản của nhóm |

---

## Tổng kết

```text
Waterfall: Plan everything → Build → Test → Deliver
Scrum:      Plan a little → Build → Test → Get feedback → Improve → Repeat
```

- **Waterfall** ưu tiên kế hoạch, trình tự, tài liệu và khả năng dự đoán.
- **Scrum** ưu tiên giá trị, phản hồi, thích nghi và cải tiến liên tục.
- Waterfall phù hợp với yêu cầu ổn định; Scrum phù hợp với môi trường phức tạp và thường xuyên thay đổi.
- Việc lựa chọn cần dựa trên bối cảnh dự án, không chỉ dựa trên xu hướng.

> Cách nhớ ngắn gọn: **Waterfall lập kế hoạch toàn bộ rồi xây dựng; Scrum xây dựng từng phần, nhận phản hồi rồi tiếp tục cải tiến.**
