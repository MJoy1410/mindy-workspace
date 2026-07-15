# Use Case và Use Case Diagram

## Mục tiêu bài học

Sau bài này, bạn có thể:

- Giải thích được Use Case, Actor và System Boundary.
- Phân biệt các quan hệ `association`, `<<include>>`, `<<extend>>` và generalization.
- Phân tích yêu cầu để tìm Actor và Use Case.
- Viết đặc tả Use Case và xây dựng Use Case Diagram.

---

## 1. Use Case là gì?

**Use Case** (ca sử dụng) mô tả chuỗi tương tác giữa một Actor và hệ thống nhằm đạt được một mục tiêu cụ thể.

Ví dụ trong hệ thống ATM:

- Khách hàng rút tiền.
- Khách hàng kiểm tra số dư.
- Nhân viên kỹ thuật bảo trì máy ATM.

Một Use Case cần trả lời được:

1. Ai thực hiện?
2. Người đó muốn đạt mục tiêu gì?
3. Hệ thống phản hồi như thế nào?
4. Trường hợp thành công là gì?
5. Có trường hợp thay thế hoặc lỗi nào?

> Use Case tập trung vào **mục tiêu của người dùng**, không tập trung vào giao diện, nút bấm hoặc cách lập trình.

## 2. Actor là gì?

**Actor** là một vai trò hoặc hệ thống bên ngoài có tương tác với hệ thống đang phân tích.

Actor có thể là:

- Người dùng: Khách hàng, Nhân viên, Quản trị viên.
- Hệ thống bên ngoài: Cổng thanh toán, dịch vụ gửi email.
- Thiết bị bên ngoài: Máy in, cảm biến.

Actor thể hiện **vai trò**, không phải một cá nhân cụ thể. Vì vậy, `Khách hàng` là Actor phù hợp, còn `Nguyễn Văn A` thường không phải Actor.

Một người có thể đóng nhiều vai trò. Ví dụ, một nhân viên của cửa hàng cũng có thể mua hàng với vai trò khách hàng.

## 3. System Boundary

**System Boundary** là đường biên xác định phạm vi hệ thống.

- Bên trong đường biên: các Use Case do hệ thống cung cấp.
- Bên ngoài đường biên: Actor và những hệ thống bên ngoài.

Ví dụ:

```text
Khách hàng  --->  [ Hệ thống bán hàng ]  --->  Cổng thanh toán
```

Trong ví dụ này, hệ thống bán hàng là đối tượng đang được phân tích. Khách hàng và cổng thanh toán nằm ngoài hệ thống.

---

## 4. Use Case Diagram là gì?

**Use Case Diagram** là sơ đồ UML thể hiện:

- Ai tương tác với hệ thống.
- Hệ thống cung cấp những chức năng nào.
- Quan hệ giữa Actor và Use Case.
- Quan hệ giữa các Use Case.

### 4.1. Ký hiệu cơ bản

| Thành phần | Ký hiệu | Ý nghĩa |
|---|---|---|
| Actor | Hình người | Vai trò hoặc hệ thống bên ngoài |
| Use Case | Hình ellipse | Mục tiêu/chức năng của Actor |
| Association | Đường nối | Actor tham gia Use Case |
| System Boundary | Hình chữ nhật | Phạm vi của hệ thống |

Tên Use Case nên bắt đầu bằng động từ, ví dụ:

- Đăng nhập
- Tìm kiếm sản phẩm
- Đặt hàng
- Thanh toán đơn hàng
- Quản lý tài khoản

Không nên đặt tên Use Case chỉ bằng danh từ như `Sản phẩm`, `Tài khoản` hoặc `Đơn hàng`.

---

## 5. Các quan hệ trong Use Case Diagram

### 5.1. Association

Association là đường nối giữa Actor và Use Case, cho biết Actor tham gia vào Use Case đó.

```text
Khách hàng ---------- (Đặt hàng)
```

Thông thường, association không cần mũi tên.

### 5.2. Quan hệ `<<include>>`

Use Case A `include` Use Case B khi A **luôn cần thực hiện B**.

```text
(Đặt hàng) ---- <<include>> ----> (Tính tổng tiền)
```

Mỗi lần đặt hàng, hệ thống đều phải tính tổng tiền. `include` thường được dùng để tách một phần xử lý bắt buộc hoặc dùng chung.

Ví dụ:

```text
(Thanh toán) ---- <<include>> ----> (Xác thực người dùng)
(Đổi mật khẩu) -- <<include>> ----> (Xác thực người dùng)
```

### 5.3. Quan hệ `<<extend>>`

Use Case B `extend` Use Case A khi B chỉ xảy ra trong một số điều kiện hoặc là chức năng tùy chọn.

```text
(Áp dụng mã giảm giá) ---- <<extend>> ----> (Đặt hàng)
```

Không phải khách hàng nào cũng sử dụng mã giảm giá. Use Case `Đặt hàng` vẫn hoàn chỉnh nếu không có Use Case mở rộng này.

Ví dụ khác:

- `In hóa đơn` mở rộng `Thanh toán` nếu khách hàng yêu cầu.
- `Xác thực OTP` mở rộng `Đăng nhập` nếu tài khoản bật xác thực hai lớp.

### 5.4. Generalization

Generalization (khái quát hóa/kế thừa) cho biết một Actor hoặc Use Case là dạng chuyên biệt của một Actor hoặc Use Case khác.

```text
                    Khách hàng
                   /          \
            Khách VIP      Khách thường
```

`Khách VIP` và `Khách thường` đều có các hành vi chung của `Khách hàng`, nhưng có thể có thêm hành vi riêng.

### 5.5. Phân biệt `include` và `extend`

| Tiêu chí | `include` | `extend` |
|---|---|---|
| Có bắt buộc không? | Có | Không |
| Khi nào xảy ra? | Luôn xảy ra | Chỉ khi có điều kiện |
| Mục đích | Tách xử lý bắt buộc/dùng chung | Bổ sung hành vi tùy chọn |
| Ví dụ | Đặt hàng → Tính tổng tiền | Áp dụng mã giảm giá → Đặt hàng |

Cách nhớ:

- `include` = **luôn bao gồm**.
- `extend` = **có thể mở rộng**.

---

## 6. Cách viết đặc tả Use Case

Một Use Case đầy đủ thường có các thành phần sau:

| Thành phần | Ý nghĩa |
|---|---|
| Use Case ID | Mã Use Case, ví dụ `UC01` |
| Tên Use Case | Tên chức năng |
| Mục tiêu | Actor muốn đạt được điều gì |
| Primary Actor | Actor chính |
| Secondary Actor | Actor hoặc hệ thống hỗ trợ |
| Preconditions | Điều kiện phải đúng trước khi thực hiện |
| Trigger | Sự kiện bắt đầu Use Case |
| Main Flow | Luồng xử lý thành công |
| Alternative Flow | Luồng xử lý thay thế |
| Exception Flow | Luồng lỗi |
| Postconditions | Trạng thái hệ thống sau khi kết thúc |

### Ví dụ: UC01 – Đăng nhập

- **Actor chính:** Người dùng
- **Mục tiêu:** Truy cập vào hệ thống.
- **Điều kiện trước:** Người dùng đã có tài khoản.
- **Sự kiện bắt đầu:** Người dùng chọn chức năng đăng nhập.
- **Điều kiện sau:** Người dùng đăng nhập thành công hoặc nhận thông báo lỗi.

#### Luồng chính

1. Người dùng mở trang đăng nhập.
2. Hệ thống hiển thị biểu mẫu đăng nhập.
3. Người dùng nhập email và mật khẩu.
4. Người dùng gửi thông tin đăng nhập.
5. Hệ thống kiểm tra thông tin.
6. Hệ thống xác nhận thông tin hợp lệ.
7. Hệ thống chuyển người dùng đến trang chính.

#### Luồng thay thế

- Tại bước 3, người dùng chọn `Quên mật khẩu`.
- Hệ thống chuyển sang quy trình khôi phục mật khẩu.

#### Luồng ngoại lệ

- Email hoặc mật khẩu không đúng: hệ thống thông báo lỗi.
- Tài khoản bị khóa: hệ thống từ chối đăng nhập.
- Thông tin bị bỏ trống: hệ thống yêu cầu nhập đầy đủ.

---

## 7. Quy trình phân tích Use Case

### Bước 1: Xác định hệ thống

Hỏi: **Hệ thống nào đang được xây dựng?**

Ví dụ: hệ thống bán hàng trực tuyến, hệ thống quản lý thư viện, hệ thống đặt vé xem phim.

### Bước 2: Xác định Actor

Tìm các vai trò hoặc hệ thống bên ngoài có tương tác với hệ thống.

Ví dụ với cửa hàng trực tuyến:

- Khách hàng
- Nhân viên
- Quản trị viên
- Cổng thanh toán
- Đơn vị vận chuyển

### Bước 3: Xác định mục tiêu của Actor

Không chỉ hỏi Actor làm gì, hãy hỏi: **Actor muốn đạt mục tiêu gì khi sử dụng hệ thống?**

| Actor | Mục tiêu |
|---|---|
| Khách hàng | Tìm sản phẩm, đặt hàng, thanh toán |
| Nhân viên | Xác nhận và xử lý đơn hàng |
| Quản trị viên | Quản lý sản phẩm và tài khoản |
| Cổng thanh toán | Xử lý giao dịch |

### Bước 4: Đặt tên Use Case

Tên Use Case nên theo cấu trúc:

```text
Động từ + đối tượng
```

Ví dụ tốt: `Đăng ký tài khoản`, `Thanh toán đơn hàng`, `Cập nhật sản phẩm`.

Ví dụ chưa tốt: `Tài khoản`, `Nút thanh toán`, `Màn hình đăng nhập`.

### Bước 5: Xác định quan hệ

- Chức năng bắt buộc và luôn xảy ra? → cân nhắc `include`.
- Chức năng tùy chọn hoặc chỉ xảy ra khi có điều kiện? → cân nhắc `extend`.
- Actor/Use Case là một loại chuyên biệt của Actor/Use Case khác? → cân nhắc generalization.

### Bước 6: Kiểm tra lại

- Mỗi Use Case có Actor tham gia không?
- Actor có thực sự nằm ngoài hệ thống không?
- Tên Use Case có thể hiện mục tiêu không?
- Có đưa chi tiết giao diện vào sơ đồ không?
- Có lạm dụng `include` hoặc `extend` không?

---

## 8. Ví dụ phân tích hệ thống ATM

### Actor

- Khách hàng
- Nhân viên kỹ thuật
- Hệ thống ngân hàng

### Use Case

Khách hàng:

- Xác thực tài khoản
- Rút tiền
- Gửi tiền
- Chuyển khoản
- Kiểm tra số dư
- Đổi mã PIN

Nhân viên kỹ thuật:

- Bảo trì ATM
- Nạp tiền vào ATM
- Kiểm tra trạng thái máy

Hệ thống ngân hàng:

- Kiểm tra thông tin tài khoản
- Cập nhật số dư
- Ghi nhận giao dịch

### Quan hệ tham khảo

```text
(Rút tiền) ---- <<include>> ----> (Xác thực tài khoản)
(Rút tiền) ---- <<include>> ----> (Kiểm tra số dư)
(In biên lai) - <<extend>> -----> (Rút tiền)
```

`In biên lai` là tùy chọn nên dùng `extend`.

Use Case Diagram không mô tả thứ tự `đưa thẻ → nhập PIN → chọn số tiền`. Thứ tự này nên được mô tả trong đặc tả Use Case, Activity Diagram hoặc Sequence Diagram.

---

## 9. Những lỗi thường gặp

### 9.1. Biến hệ thống đang phân tích thành Actor

Nếu đang phân tích `Hệ thống bán hàng`, không đặt chính hệ thống bán hàng làm Actor.

### 9.2. Luôn xem cơ sở dữ liệu là Actor

Database thường là thành phần bên trong hệ thống nên không phải Actor. Nó chỉ có thể là Actor nếu là một hệ thống dữ liệu độc lập nằm ngoài phạm vi đang phân tích.

### 9.3. Biến thao tác nhỏ thành Use Case

Các hành động như `Nhấn nút đăng nhập`, `Nhập tên`, `Chọn checkbox` hoặc `Hiển thị thông báo` thường chỉ là bước trong Use Case, không phải mục tiêu hoàn chỉnh.

### 9.4. Nhầm `include` và `extend`

- Bắt buộc → `include`.
- Tùy chọn hoặc có điều kiện → `extend`.

### 9.5. Dùng Use Case Diagram để mô tả thứ tự

Use Case Diagram không thể hiện rõ chức năng nào xảy ra trước hoặc sau. Hãy dùng Activity Diagram, Sequence Diagram hoặc đặc tả luồng Use Case khi cần mô tả quy trình.

---

## 10. Bài tập phân tích

### Bài 1: Hệ thống quản lý thư viện

Thư viện cho phép độc giả tìm kiếm sách, xem thông tin sách, mượn sách và trả sách. Độc giả phải có thẻ thư viện hợp lệ mới được mượn sách. Khi trả sách muộn, hệ thống tính tiền phạt. Thủ thư quản lý sách, lập phiếu mượn, nhận sách trả và thu tiền phạt. Quản trị viên quản lý tài khoản thủ thư.

Yêu cầu:

1. Xác định phạm vi hệ thống.
2. Xác định Actor.
3. Xác định Use Case của từng Actor.
4. Xác định quan hệ `include` và `extend`.
5. Viết đặc tả Use Case `Mượn sách`.
6. Vẽ Use Case Diagram.

Gợi ý:

- `Kiểm tra thẻ thư viện` có bắt buộc khi mượn sách không?
- `Thu tiền phạt` có xảy ra trong mọi lần trả sách không?
- Người trực tiếp lập phiếu mượn là độc giả hay thủ thư?

### Bài 2: Hệ thống bán hàng trực tuyến

Khách hàng có thể đăng ký tài khoản, đăng nhập, tìm kiếm sản phẩm, thêm sản phẩm vào giỏ hàng và đặt hàng. Khi đặt hàng, khách hàng nhập địa chỉ nhận hàng và chọn phương thức thanh toán. Khách hàng có thể nhập mã giảm giá nếu có. Thanh toán trực tuyến được xử lý bởi cổng thanh toán. Nhân viên xác nhận và giao đơn hàng. Quản trị viên quản lý sản phẩm, danh mục, tài khoản và chương trình khuyến mãi.

Yêu cầu:

1. Liệt kê Actor chính và Actor phụ.
2. Liệt kê Use Case.
3. Chỉ ra các Use Case bắt buộc và tùy chọn.
4. Xác định hệ thống bên ngoài.
5. Vẽ Use Case Diagram.
6. Viết đặc tả Use Case `Đặt hàng`.

Đưa các tình huống sau vào đặc tả:

- Giỏ hàng trống.
- Sản phẩm hết hàng.
- Mã giảm giá không hợp lệ.
- Thanh toán thất bại.
- Khách hàng nhập thiếu địa chỉ.

### Bài 3: Hệ thống đặt vé xem phim

Khách hàng xem danh sách phim, chọn rạp, chọn suất chiếu, chọn ghế và đặt vé. Khách hàng có thể thanh toán trực tuyến hoặc tại quầy. Nếu thanh toán trực tuyến thành công, hệ thống gửi vé điện tử qua email. Nhân viên rạp có thể bán vé tại quầy và kiểm tra vé. Quản trị viên quản lý phim, phòng chiếu, suất chiếu và giá vé.

Yêu cầu:

1. Xác định Actor và Use Case.
2. Phân tích xem `Chọn ghế` có phải phần bắt buộc của `Đặt vé` không.
3. Phân tích xem `Gửi vé qua email` dùng `include` hay `extend`.
4. Biểu diễn hai phương thức thanh toán.
5. Viết luồng chính và ít nhất ba luồng ngoại lệ của `Đặt vé`.

### Bài 4: Hệ thống đặt lịch khám bệnh

Bệnh nhân có thể đăng ký tài khoản, tìm bác sĩ, xem lịch trống và đặt lịch khám. Bệnh nhân có thể hủy hoặc đổi lịch trước giờ khám ít nhất 24 giờ. Bác sĩ xem lịch làm việc và cập nhật kết quả khám. Lễ tân xác nhận lịch, tiếp nhận bệnh nhân và thu phí. Hệ thống gửi SMS nhắc lịch trước giờ khám.

Yêu cầu:

1. Xác định Actor người dùng và các hệ thống bên ngoài.
2. Phân tích các quy tắc nghiệp vụ.
3. Liệt kê Use Case của từng Actor.
4. Viết đặc tả Use Case `Đổi lịch khám`.
5. Vẽ Use Case Diagram.

Gợi ý:

- Dịch vụ SMS có phải Actor không?
- Quy định `trước ít nhất 24 giờ` nên đặt ở đâu?
- `Xem lịch trống` và `Đặt lịch` có quan hệ gì?

---

## 11. Bài tập tìm lỗi

Xem mô hình sau:

```text
Actor:
- Khách hàng
- Database
- Hệ thống bán hàng

Use Case:
- Sản phẩm
- Nhấn nút mua
- Nhập địa chỉ
- Đặt hàng
- Thông báo thành công

Quan hệ:
- Đặt hàng <<extend>> Kiểm tra giỏ hàng
- Thanh toán <<include>> Áp dụng mã giảm giá
```

Hãy tìm ít nhất sáu vấn đề trong mô hình.

Gợi ý:

- Actor nào không hợp lý?
- Use Case nào không thể hiện mục tiêu?
- Chức năng nào chỉ là một bước nhỏ?
- Quan hệ nào bị sử dụng sai?
- `Kiểm tra giỏ hàng` có bắt buộc không?
- `Áp dụng mã giảm giá` có luôn xảy ra không?

---

## 12. Mẫu làm bài

```text
1. Tên hệ thống:
2. Phạm vi hệ thống:

3. Actor:
- Actor 1:
- Actor 2:
- Hệ thống bên ngoài:

4. Use Case:
- Actor 1:
  + Use Case A
  + Use Case B

- Actor 2:
  + Use Case C

5. Quan hệ:
- A <<include>> B vì...
- C <<extend>> A vì...
- Actor X kế thừa Actor Y vì...

6. Đặc tả Use Case:
- Use Case ID:
- Tên:
- Actor chính:
- Actor phụ:
- Mục tiêu:
- Điều kiện trước:
- Sự kiện bắt đầu:
- Luồng chính:
- Luồng thay thế:
- Luồng ngoại lệ:
- Điều kiện sau:
```

## 13. Thứ tự luyện tập đề xuất

1. Làm Bài 1: chỉ tìm Actor và Use Case.
2. Kiểm tra lại tên Use Case đã thể hiện mục tiêu chưa.
3. Bổ sung quan hệ `include` và `extend`, đồng thời giải thích lý do.
4. Viết đặc tả Use Case `Mượn sách`.
5. Cuối cùng mới vẽ Use Case Diagram.

Nguyên tắc quan trọng nhất: **bắt đầu từ mục tiêu của Actor, không bắt đầu từ màn hình hoặc nút bấm**.
