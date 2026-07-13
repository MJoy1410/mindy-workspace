# Cách viết commit hiệu quả

> Một commit tốt không chỉ lưu code. Nó ghi lại một thay đổi có chủ đích để người khác có thể đọc, review, tìm lỗi và hoàn tác một cách an toàn.

## 1. Mục tiêu

Sau khi hoàn thành tài liệu này, bạn có thể:

- Chia công việc thành các commit nhỏ và có ý nghĩa.
- Viết commit message ngắn gọn nhưng đủ thông tin.
- Áp dụng cấu trúc Conventional Commits ở mức cơ bản.
- Giải thích được khi nào cần dùng subject, body và footer.
- Nhận biết và sửa các commit message mơ hồ.
- Kiểm tra nội dung trước khi tạo commit.

## 2. Commit hiệu quả là gì?

Một commit hiệu quả thường có ba đặc điểm:

1. **Atomic**: chỉ giải quyết một thay đổi logic.
2. **Rõ mục đích**: message cho biết thay đổi gì và vì sao thay đổi.
3. **An toàn**: code tại commit đó nên ở trạng thái hợp lệ, có thể review hoặc hoàn tác độc lập.

Ví dụ, khi thêm chức năng đăng nhập, không nên gom tất cả công việc sau vào một commit:

- Thêm API đăng nhập.
- Sửa màu của nút đăng ký.
- Đổi tên một số file không liên quan.
- Cập nhật thư viện.

Thay vào đó, có thể chia thành:

```text
feat(auth): add login endpoint
fix(register): correct submit button color
refactor(user): rename user repository files
build(deps): update authentication dependencies
```

Mỗi commit lúc này có một mục đích riêng. Reviewer dễ hiểu thay đổi hơn và có thể hoàn tác đúng phần gây lỗi.

## 3. Cấu trúc commit message

Một cấu trúc phổ biến là:

```text
<type>(<scope>): <subject>

<body>

<footer>
```

Trong đó:

- `type`: loại thay đổi.
- `scope`: khu vực bị ảnh hưởng, không bắt buộc.
- `subject`: mô tả ngắn thay đổi chính.
- `body`: giải thích chi tiết hoặc lý do, không bắt buộc.
- `footer`: issue, breaking change hoặc metadata khác, không bắt buộc.

Ví dụ đầy đủ:

```text
fix(payment): prevent duplicate transactions

Disable the payment button after the first submission because slow
network responses allowed users to send the same request multiple times.

Closes #128
```

Giải thích:

- `fix` cho biết đây là một bản sửa lỗi.
- `payment` xác định lỗi thuộc khu vực thanh toán.
- `prevent duplicate transactions` mô tả kết quả của thay đổi.
- Body giải thích nguyên nhân và cách xử lý.
- Footer liên kết commit với issue `#128`.

## 4. Chọn `type` phù hợp

Các loại thường dùng trong Conventional Commits:

| Type | Khi nào sử dụng | Ví dụ |
| --- | --- | --- |
| `feat` | Thêm khả năng hoặc hành vi mới cho người dùng | `feat(search): add product filters` |
| `fix` | Sửa một hành vi sai hoặc lỗi | `fix(cart): calculate discount correctly` |
| `docs` | Chỉ thay đổi tài liệu | `docs(api): add authentication examples` |
| `refactor` | Cải tổ code nhưng không thêm tính năng hay sửa hành vi | `refactor(auth): extract token validation` |
| `test` | Thêm hoặc sửa kiểm thử | `test(order): cover cancelled order flow` |
| `perf` | Cải thiện hiệu năng | `perf(image): cache generated thumbnails` |
| `style` | Chỉ sửa định dạng code, khoảng trắng hoặc dấu chấm phẩy | `style(user): apply formatter` |
| `build` | Thay đổi dependency hoặc hệ thống build | `build(deps): upgrade vite to version 7` |
| `ci` | Thay đổi pipeline CI/CD | `ci(github): run tests on pull requests` |
| `chore` | Công việc bảo trì không thuộc các nhóm trên | `chore(repo): update gitignore` |
| `revert` | Hoàn tác một commit trước đó | `revert: remove experimental cache` |

### Phân biệt `feat`, `fix` và `refactor`

```text
feat(auth): add password reset
```

Người dùng có thêm một khả năng mới, vì vậy dùng `feat`.

```text
fix(auth): reject expired reset tokens
```

Hệ thống trước đó xử lý sai token hết hạn, vì vậy dùng `fix`.

```text
refactor(auth): extract reset token validator
```

Code được tổ chức lại nhưng hành vi bên ngoài không đổi, vì vậy dùng `refactor`.

> Không cần cố ép mọi thay đổi vào `chore`. Hãy chọn type mô tả đúng tác động chính của commit.

## 5. Chọn `scope` phù hợp

`scope` cho biết phần nào của dự án bị ảnh hưởng. Nó nên ngắn, ổn định và quen thuộc với nhóm.

Ví dụ scope:

```text
auth
cart
payment
api
database
ui
docs
```

Ví dụ commit:

```text
feat(cart): support coupon codes
fix(api): return 404 for missing products
docs(readme): add local setup steps
```

Không nên dùng scope quá chi tiết:

```text
fix(src/modules/payment/services/stripe): handle timeout
```

Nên viết gọn hơn:

```text
fix(payment): handle Stripe timeout
```

Nếu thay đổi ảnh hưởng toàn dự án hoặc dự án chưa có quy ước scope, có thể bỏ scope:

```text
chore: initialize project structure
```

## 6. Viết subject rõ ràng

Subject là dòng đầu tiên và là phần xuất hiện trong `git log --oneline`. Vì vậy, người đọc phải hiểu thay đổi chính mà không cần mở code.

### 6.1. Bắt đầu bằng động từ cụ thể

Nên dùng:

```text
add
remove
prevent
validate
rename
update
handle
allow
```

Ví dụ tốt:

```text
feat(profile): allow users to upload avatars
fix(order): prevent checkout with an empty cart
refactor(api): extract error response builder
```

Ví dụ chưa tốt:

```text
update profile
fix bug
changes
work in progress
done
```

Các message chưa tốt không nói rõ phần nào thay đổi hoặc kết quả của thay đổi là gì.

### 6.2. Viết ngắn nhưng cụ thể

Subject nên dễ đọc, thường không dài quá khoảng 50–72 ký tự. Đây là hướng dẫn để giữ lịch sử gọn gàng, không phải giới hạn bắt buộc của Git.

Chưa tốt:

```text
fix: fix the issue where customers sometimes cannot complete payment
when using a card that requires additional authentication
```

Tốt hơn:

```text
fix(payment): handle cards requiring authentication
```

Chi tiết có thể chuyển xuống body.

### 6.3. Dùng một ngôn ngữ nhất quán

Nếu dự án quy ước viết tiếng Anh, hãy dùng tiếng Anh cho toàn bộ commit:

```text
feat(auth): add Google login
```

Nếu nhóm quy ước viết tiếng Việt, có thể dùng:

```text
feat(auth): thêm đăng nhập bằng Google
```

Cả hai cách đều hợp lệ. Điều quan trọng là không đổi ngôn ngữ tùy ý giữa các commit trong cùng dự án.

### 6.4. Tránh lặp lại thông tin

Chưa tốt:

```text
fix: fix payment bug
```

`fix` đã cho biết đây là sửa lỗi. Phần còn lại cần mô tả lỗi nào được sửa:

```text
fix(payment): prevent duplicate charges
```

## 7. Khi nào cần viết body?

Không phải commit nào cũng cần body. Một thay đổi đơn giản có thể chỉ cần subject:

```text
docs(readme): fix installation command
```

Nên thêm body khi:

- Lý do thay đổi không thể hiện rõ trong code.
- Có một quyết định kỹ thuật cần giải thích.
- Cần mô tả hành vi cũ và hành vi mới.
- Có giới hạn hoặc tác dụng phụ mà reviewer cần biết.

Ví dụ:

```text
fix(session): refresh tokens before they expire

Refresh the token five minutes before expiration. Waiting until the token
expires can interrupt requests that are already in progress.
```

Body nên giải thích **vì sao** và **tác động**. Không cần kể lại từng dòng code mà người đọc có thể thấy trong diff.

So sánh:

Chưa hữu ích:

```text
Change TOKEN_BUFFER from 0 to 300 and call refreshToken earlier.
```

Hữu ích hơn:

```text
Refresh tokens five minutes early to avoid interrupting active requests.
```

## 8. Khi nào cần footer?

Footer thường dùng để liên kết issue hoặc thông báo breaking change.

### 8.1. Liên kết issue

```text
fix(profile): preserve avatar after email update

Closes #245
```

Từ khóa đóng issue phụ thuộc vào nền tảng và quy ước của dự án. Ngoài `Closes`, nhóm có thể dùng `Fixes`, `Resolves` hoặc chỉ ghi `Refs` nếu commit không tự động đóng issue.

### 8.2. Breaking change

Breaking change là thay đổi khiến người đang dùng API hoặc tính năng cũ phải sửa code hay cấu hình.

Có thể thêm dấu `!` sau type hoặc scope:

```text
feat(api)!: require authentication for all endpoints
```

Với thay đổi phức tạp, giải thích trong footer:

```text
feat(api)!: rename customer identifier

Use customerId consistently in all public responses.

BREAKING CHANGE: the customer_id response field is now customerId.
```

## 9. Một commit chỉ nên chứa một thay đổi logic

### 9.1. Dấu hiệu commit đang quá lớn

- Message phải dùng nhiều từ `and` để mô tả.
- Commit vừa thêm tính năng, vừa sửa lỗi không liên quan.
- Diff chứa nhiều khu vực không liên quan.
- Reviewer khó đặt một tên ngắn cho commit.
- Không thể hoàn tác một phần mà không ảnh hưởng phần khác.

Ví dụ commit quá rộng:

```text
feat: add login and redesign header and update dependencies
```

Nên tách thành:

```text
feat(auth): add email login
style(header): update navigation layout
build(deps): update authentication packages
```

### 9.2. Không tách commit quá vụn

Atomic không có nghĩa là mỗi dòng code phải là một commit. Các thay đổi phụ thuộc trực tiếp để tạo nên một hành vi hoàn chỉnh nên nằm cùng nhau.

Ví dụ khi thêm validation email, các phần sau có thể thuộc cùng một commit:

- Hàm validation.
- Thông báo lỗi tương ứng.
- Test cho validation.

```text
feat(register): validate email addresses
```

Nếu tách hàm, message và test thành ba commit không chạy độc lập, lịch sử sẽ khó đọc hơn mà không đem lại lợi ích.

## 10. Quy trình tạo một commit tốt

### Bước 1: Kiểm tra trạng thái

```powershell
git status
```

Xác định file nào đã sửa, file nào mới và có file không liên quan hay không.

### Bước 2: Đọc thay đổi chưa stage

```powershell
git diff
```

Kiểm tra code debug, dữ liệu nhạy cảm, thay đổi vô tình hoặc format không liên quan.

### Bước 3: Stage đúng phần cần commit

Stage toàn bộ một file:

```powershell
git add src/auth/login.ts
```

Stage từng phần của file:

```powershell
git add -p
```

`git add -p` hữu ích khi một file chứa nhiều thay đổi logic. Git hiển thị từng đoạn diff để bạn chọn đưa đoạn đó vào staging area hay không.

### Bước 4: Kiểm tra nội dung đã stage

```powershell
git diff --staged
```

Đây là nội dung thực tế sẽ được lưu trong commit. Không nên chỉ dựa vào `git status`, vì lệnh đó chỉ liệt kê file chứ không cho biết chi tiết thay đổi.

### Bước 5: Chạy kiểm tra phù hợp

Tùy dự án, hãy chạy test, lint hoặc build. Mục tiêu là tránh lưu một commit làm hỏng hành vi đang hoạt động.

```powershell
npm test
npm run lint
npm run build
```

### Bước 6: Viết commit message

Với message ngắn:

```powershell
git commit -m "fix(cart): calculate totals after removing items"
```

Với message cần body, mở editor:

```powershell
git commit
```

Hoặc truyền subject và body bằng nhiều tùy chọn `-m`:

```powershell
git commit -m "fix(cart): recalculate totals after item removal" `
  -m "The previous total remained cached until the page was refreshed."
```

### Bước 7: Kiểm tra lại lịch sử

```powershell
git log -1 --stat
git show --stat HEAD
```

Nếu vừa commit xong và nhận ra message chưa đúng, có thể sửa commit cuối khi commit đó chưa được chia sẻ:

```powershell
git commit --amend
```

> Thận trọng khi amend một commit đã push và có người khác sử dụng, vì thao tác này thay đổi commit hash và viết lại lịch sử.

## 11. Ví dụ theo tình huống

### Tình huống 1: Thêm tính năng

Thay đổi: thêm chức năng lọc sản phẩm theo khoảng giá.

```text
feat(search): add price range filter
```

Giải thích:

- Dùng `feat` vì người dùng có khả năng mới.
- Dùng scope `search` vì thay đổi thuộc khu vực tìm kiếm.
- Subject mô tả chính xác bộ lọc được thêm.

### Tình huống 2: Sửa lỗi

Thay đổi: tổng tiền không cập nhật khi xóa sản phẩm khỏi giỏ hàng.

```text
fix(cart): recalculate total after item removal
```

Giải thích:

- Dùng `fix` vì hành vi hiện tại bị sai.
- Subject mô tả kết quả sau khi sửa, thay vì chỉ ghi `fix total bug`.

### Tình huống 3: Refactor

Thay đổi: tách logic xác thực token khỏi controller nhưng không đổi API.

```text
refactor(auth): extract token validation service
```

Giải thích:

- Không dùng `feat` vì người dùng không nhận được tính năng mới.
- Không dùng `fix` nếu hành vi cũ không có lỗi.
- Message cho biết thành phần nào được tách ra.

### Tình huống 4: Tối ưu hiệu năng

Thay đổi: cache thumbnail để tránh tạo lại ảnh trong mỗi request.

```text
perf(image): cache generated thumbnails

Reuse thumbnails for unchanged source images to reduce response time and
CPU usage on repeated requests.
```

Giải thích:

- Dùng `perf` vì mục đích chính là tăng hiệu năng.
- Body giải thích điều kiện sử dụng cache và lợi ích của thay đổi.

### Tình huống 5: Cập nhật tài liệu

Thay đổi: bổ sung hướng dẫn chạy dự án bằng Docker.

```text
docs(readme): add Docker setup instructions
```

Giải thích:

- Dùng `docs` vì không thay đổi code chạy của ứng dụng.
- Scope `readme` cho biết tài liệu nào được cập nhật.

### Tình huống 6: Thay đổi API không tương thích

```text
feat(api)!: replace page numbers with cursor pagination

Cursor pagination produces stable results when records are inserted while a
client is browsing the list.

BREAKING CHANGE: list endpoints no longer accept the page query parameter.
Use cursor and limit instead.
```

Giải thích:

- Dấu `!` cảnh báo thay đổi không tương thích.
- Body giải thích lý do chọn cursor pagination.
- Footer hướng dẫn người dùng API cần thay đổi gì.

## 12. So sánh message chưa tốt và message tốt

| Chưa tốt | Tốt hơn | Lý do |
| --- | --- | --- |
| `update code` | `refactor(order): extract price calculator` | Nói rõ phần nào và thay đổi gì |
| `fix bug` | `fix(login): reject expired reset tokens` | Xác định lỗi cụ thể |
| `changes` | `docs(readme): add Windows setup steps` | Cho biết loại và nội dung thay đổi |
| `WIP` | `feat(profile): add avatar upload form` | Mô tả một mốc hoàn chỉnh |
| `fix: fix validation` | `fix(register): trim email before validation` | Tránh lặp từ và nêu cách xử lý |
| `feature` | `feat(search): support filtering by category` | Nêu chính xác khả năng mới |
| `misc updates` | Tách thành nhiều commit | Không gom các thay đổi không liên quan |

## 13. Những lỗi thường gặp

### 13.1. Commit tất cả bằng `git add .` mà không kiểm tra

Lệnh này không sai, nhưng dễ đưa file debug, file cấu hình cá nhân hoặc thay đổi không liên quan vào commit.

Nên kiểm tra trước và sau khi stage:

```powershell
git status
git diff
git add .
git diff --staged
```

### 13.2. Mô tả thao tác thay vì mục đích

```text
change if statement
```

Message này chỉ kể thao tác trong code. Người đọc cần biết thay đổi giải quyết điều gì:

```text
fix(access): allow admins to view archived reports
```

### 13.3. Trộn format với thay đổi logic

Một commit vừa format hàng trăm dòng vừa sửa logic khiến reviewer khó nhìn thấy phần quan trọng. Nếu có thể, hãy tách:

```text
style(api): apply formatter
fix(api): return validation errors consistently
```

### 13.4. Commit code không chạy được

Một chuỗi commit lý tưởng nên có thể được checkout và kiểm tra ở từng mốc. Tránh commit mà file tham chiếu chưa tồn tại, build lỗi hoặc test đang hỏng, trừ khi nhóm có quy ước rõ ràng cho công việc tạm thời.

### 13.5. Viết message quá dài ở dòng đầu

Dòng đầu chỉ nên là bản tóm tắt. Đưa bối cảnh, nguyên nhân và đánh đổi xuống body để `git log --oneline` vẫn dễ đọc.

## 14. Mẫu commit có thể tái sử dụng

### Tính năng

```text
feat(<scope>): add <capability>
```

Ví dụ:

```text
feat(report): add CSV export
```

### Sửa lỗi

```text
fix(<scope>): prevent <incorrect behavior>
```

Ví dụ:

```text
fix(upload): prevent empty files from being submitted
```

### Refactor

```text
refactor(<scope>): extract <component>
```

Ví dụ:

```text
refactor(order): extract shipping fee calculator
```

### Tài liệu

```text
docs(<scope>): add <documentation>
```

Ví dụ:

```text
docs(api): add pagination examples
```

### Commit có giải thích

```text
<type>(<scope>): <subject>

<reason for the change>
<important behavior, limitation, or trade-off>

<issue reference or breaking change>
```

Mẫu chỉ là điểm bắt đầu. Message cuối cùng vẫn phải phản ánh chính xác thay đổi thực tế.

## 15. Checklist trước khi commit

Trước khi chạy `git commit`, hãy tự kiểm tra:

- [ ] Commit chỉ chứa một thay đổi logic.
- [ ] Không có file debug, secret hoặc thay đổi không liên quan.
- [ ] Đã đọc `git diff --staged`.
- [ ] Test, lint hoặc build phù hợp đã chạy thành công.
- [ ] `type` mô tả đúng loại thay đổi.
- [ ] `scope` ngắn gọn và đúng khu vực, nếu cần.
- [ ] Subject bắt đầu bằng động từ và nói rõ kết quả.
- [ ] Subject không dùng các từ mơ hồ như `update`, `changes`, `done` khi đứng một mình.
- [ ] Body giải thích lý do nếu thay đổi không hiển nhiên.
- [ ] Breaking change và issue liên quan đã được ghi rõ.
- [ ] Message tuân theo ngôn ngữ và quy ước chung của dự án.

## 16. Bài tập thực hành

### Bài 1: Cải thiện commit message

Viết lại các message sau:

```text
fix bug
update
changes to user
WIP
```

Đáp án tham khảo:

```text
fix(cart): preserve quantity after page refresh
docs(readme): update installation requirements
refactor(user): extract profile mapper
feat(profile): add avatar preview
```

### Bài 2: Chia một commit lớn

Giả sử diff hiện tại gồm:

- Thêm đăng nhập bằng Google.
- Sửa lỗi nút đăng xuất không hoạt động.
- Format toàn bộ thư mục `src`.
- Cập nhật hướng dẫn cấu hình OAuth.

Hãy chia thành:

```text
feat(auth): add Google login
fix(auth): clear session on logout
style(src): apply formatter
docs(auth): add OAuth configuration guide
```

### Bài 3: Viết body giải thích lý do

Tình huống: hệ thống chuyển từ gọi API ở mỗi lần gõ sang chờ 300 ms để giảm số request tìm kiếm.

```text
perf(search): debounce search requests

Wait 300 milliseconds after the last input before sending a request to reduce
unnecessary API calls while the user is typing.
```

## 17. Tóm tắt

Công thức ngắn gọn cho một commit hiệu quả:

```text
Một thay đổi logic
+ diff đã được kiểm tra
+ message mô tả rõ kết quả
+ lý do được giải thích khi cần
= lịch sử Git dễ hiểu và an toàn
```

Cấu trúc đề xuất:

```text
<type>(<scope>): <subject>
```

Ví dụ:

```text
feat(auth): add Google login
fix(cart): recalculate total after item removal
refactor(api): extract error response builder
docs(readme): add local setup instructions
test(order): cover cancelled order flow
```

Khi người khác chỉ đọc `git log --oneline` mà vẫn hiểu dự án đã thay đổi như thế nào, commit message đã hoàn thành tốt nhiệm vụ của nó.
