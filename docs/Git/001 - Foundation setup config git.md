# Foundation: cài đặt và cấu hình Git trên Windows

> Tài liệu nhập môn dành cho Windows 10/11, sử dụng PowerShell, Git và GitHub.

## 1. Git và GitHub khác nhau như thế nào?

- **Git** là công cụ quản lý phiên bản chạy trên máy tính. Có thể cài đặt, tạo repository và commit mà không cần tài khoản hoặc Internet.
- **GitHub** là dịch vụ lưu trữ repository trên Internet. Chỉ cần tài khoản khi muốn đẩy mã nguồn lên GitHub, sao lưu hoặc cộng tác với người khác.
- `user.name` và `user.email` trong Git là thông tin tác giả của commit, không phải tài khoản hay mật khẩu đăng nhập GitHub.

## 2. Cài Git trên Windows

### 2.1. Cài bằng Winget

Mở **PowerShell** hoặc **Windows Terminal**, sau đó chạy:

```powershell
winget install --id Git.Git -e --source winget
```

Giải thích:

| Thành phần | Ý nghĩa |
| --- | --- |
| `winget` | Trình quản lý phần mềm của Windows |
| `install` | Yêu cầu cài phần mềm |
| `--id Git.Git` | Chọn gói Git chính xác |
| `-e` | Khớp chính xác mã gói, tránh chọn nhầm |
| `--source winget` | Sử dụng kho phần mềm Winget |

Đóng rồi mở lại PowerShell để Windows cập nhật `PATH`, sau đó kiểm tra:

```powershell
git --version
```

Ví dụ kết quả:

```text
git version 2.x.x.windows.x
```

Nếu nhận được thông báo `git is not recognized`, hãy mở cửa sổ PowerShell mới. Nếu vẫn lỗi, khởi động lại Windows hoặc cài lại Git.

### 2.2. Cập nhật Git

```powershell
winget upgrade --id Git.Git -e
```

### 2.3. Gỡ Git

```powershell
winget uninstall --id Git.Git -e
```

Gỡ chương trình Git không tự động xóa các thư mục dự án hoặc lịch sử `.git` nằm trong dự án.

## 3. Cấu hình Git lần đầu

### 3.1. Đặt tên tác giả

```powershell
git config --global user.name "Nguyen Van An"
```

- `git config`: đọc hoặc thay đổi cấu hình Git.
- `--global`: áp dụng cho tất cả repository của người dùng Windows hiện tại.
- `user.name`: tên tác giả được ghi vào các commit mới.
- Tên này không bắt buộc giống username GitHub.

Kiểm tra:

```powershell
git config --global user.name
```

### 3.2. Đặt email tác giả

```powershell
git config --global user.email "nguyenvanan@example.com"
```

Email này được ghi vào commit, không phải mật khẩu đăng nhập. Nếu chưa có tài khoản GitHub, nên dùng email mà sau này bạn sẽ thêm và xác minh trên GitHub để các commit có thể được liên kết với tài khoản.

Kiểm tra:

```powershell
git config --global user.email
```

> **Quyền riêng tư:** email trong commit có thể xuất hiện công khai. Sau khi tạo tài khoản GitHub, có thể bật chế độ giữ email riêng tư, sao chép địa chỉ `noreply` tại **Settings → Emails**, rồi thay giá trị `user.email`. Thay đổi này chỉ tác động tới commit mới.

### 3.3. Đặt tên nhánh mặc định

```powershell
git config --global init.defaultBranch main
```

Khi chạy `git init`, nhánh đầu tiên của repository mới sẽ có tên `main`. Lệnh này không tự đổi tên các nhánh đã tồn tại.

### 3.4. Cấu hình xuống dòng trên Windows

```powershell
git config --global core.autocrlf true
```

Windows thường dùng `CRLF`, còn Git và Linux thường dùng `LF`. Giá trị `true` giúp Git chuyển đổi kiểu xuống dòng khi lấy file về và khi tạo commit, hạn chế thay đổi không cần thiết.

Đây là cấu hình phù hợp với nhiều dự án Windows nhưng không phải bắt buộc. Nếu dự án có `.gitattributes`, quy tắc của dự án nên được ưu tiên.

### 3.5. Đặt VS Code làm trình soạn thảo

Trước tiên kiểm tra VS Code có sử dụng được từ terminal không:

```powershell
code --version
```

Nếu có, chạy:

```powershell
git config --global core.editor "code --wait"
```

- `code`: mở Visual Studio Code.
- `--wait`: yêu cầu Git chờ cho đến khi đóng file đang chỉnh sửa.

### 3.6. Cấu hình khuyến nghị hoàn chỉnh

Thay tên và email ví dụ bằng thông tin của bạn:

```powershell
git config --global user.name "Nguyen Van An"
git config --global user.email "nguyenvanan@example.com"
git config --global init.defaultBranch main
git config --global core.autocrlf true
git config --global core.editor "code --wait"
```

## 4. Kiểm tra cấu hình

Xem cấu hình toàn cục:

```powershell
git config --global --list
```

Xem tất cả cấu hình và file nguồn của từng giá trị:

```powershell
git config --list --show-origin
```

Git có ba phạm vi cấu hình chính:

| Phạm vi | Cách đặt | Phạm vi ảnh hưởng |
| --- | --- | --- |
| System | `git config --system ...` | Mọi người dùng trên máy; thường cần quyền quản trị |
| Global | `git config --global ...` | Người dùng Windows hiện tại |
| Local | `git config ...` | Repository hiện tại |

Cấu hình `local` có thể ghi đè `global`, còn `global` có thể ghi đè `system`.

Xem file cấu hình global bằng trình soạn thảo đã thiết lập:

```powershell
git config --global --edit
```

## 5. Sửa hoặc gỡ cấu hình khi nhập sai

### 5.1. Sửa giá trị

Chạy lại lệnh với giá trị đúng:

```powershell
git config --global user.name "Ten Dung"
git config --global user.email "email-dung@example.com"
```

### 5.2. Gỡ một giá trị global

```powershell
git config --global --unset user.name
git config --global --unset user.email
git config --global --unset init.defaultBranch
git config --global --unset core.autocrlf
git config --global --unset core.editor
```

Chỉ chạy dòng tương ứng với cấu hình cần gỡ.

Nếu một khóa vô tình xuất hiện nhiều lần, gỡ tất cả giá trị của khóa đó:

```powershell
git config --global --unset-all user.email
```

Sau đó đặt lại một lần bằng giá trị đúng.

### 5.3. Sửa hoặc gỡ cấu hình riêng của một repository

Di chuyển vào thư mục repository rồi chạy lệnh không có `--global`:

```powershell
cd "C:\duong-dan\den\du-an"
git config user.email "email-rieng@example.com"
git config --unset user.email
```

### 5.4. Kiểm tra giá trị thực tế và nguồn cấu hình

```powershell
git config user.name
git config user.email
git config --show-origin user.email
```

Lệnh cuối giúp phát hiện một giá trị `local` đang ghi đè giá trị `global`.

## 6. Tạo repository Git đầu tiên trên máy

```powershell
mkdir du-an-moi
cd du-an-moi
git init
"# Du an moi" | Set-Content README.md
git status
git add README.md
git commit -m "Khoi tao du an"
git log --oneline
```

Giải thích:

| Lệnh | Ý nghĩa |
| --- | --- |
| `mkdir du-an-moi` | Tạo thư mục dự án |
| `cd du-an-moi` | Di chuyển vào thư mục dự án |
| `git init` | Khởi tạo repository Git cục bộ |
| `git status` | Xem trạng thái file |
| `git add README.md` | Đưa file vào vùng chuẩn bị commit (staging area) |
| `git commit -m "..."` | Tạo một mốc lịch sử có thông điệp |
| `git log --oneline` | Xem lịch sử commit dạng ngắn |

### Hoàn tác thao tác cơ bản

Bỏ file khỏi staging nhưng giữ nội dung file:

```powershell
git restore --staged README.md
```

Hoàn tác commit gần nhất nhưng vẫn giữ thay đổi trong staging:

```powershell
git reset --soft HEAD~1
```

Nếu commit đã được đẩy lên repository dùng chung, nên tạo commit đảo ngược thay vì viết lại lịch sử:

```powershell
git revert <commit-id>
```

## 7. Tạo tài khoản GitHub mới

Không có lệnh Git tiêu chuẩn để tạo tài khoản GitHub. Thực hiện trong trình duyệt:

1. Truy cập [GitHub](https://github.com/) và chọn **Sign up**.
2. Nhập email, mật khẩu mạnh và username.
3. Xác minh email theo thư GitHub gửi đến.
4. Vào **Settings → Password and authentication** để bật xác thực hai lớp (2FA).
5. Lưu recovery codes trong trình quản lý mật khẩu hoặc một vị trí an toàn, tách biệt với máy tính đang sử dụng.
6. Vào **Settings → Emails** và kiểm tra email muốn dùng cho commit.

Không chia sẻ mật khẩu, mã 2FA, recovery code, personal access token hoặc private SSH key cho người khác; cũng không commit chúng vào repository.

## 8. Đăng nhập GitHub từ dòng lệnh

GitHub CLI là công cụ riêng, không phải Git. Cài bằng:

```powershell
winget install --id GitHub.cli -e --source winget
```

Mở PowerShell mới rồi kiểm tra:

```powershell
gh --version
```

Đăng nhập:

```powershell
gh auth login
```

Với người mới, có thể chọn lần lượt:

1. `GitHub.com`
2. `HTTPS`
3. Đăng nhập bằng trình duyệt

Kiểm tra trạng thái đăng nhập:

```powershell
gh auth status
```

Đăng xuất nếu đăng nhập nhầm tài khoản:

```powershell
gh auth logout
```

GitHub không còn hỗ trợ dùng mật khẩu tài khoản cho thao tác Git qua HTTPS. GitHub CLI, Git Credential Manager, personal access token hoặc SSH là các phương thức phù hợp.

## 9. Đưa repository lên GitHub

### Cách 1: Tạo repository bằng website

1. Trên GitHub, chọn **New repository**.
2. Nhập tên repository.
3. Nếu dự án cục bộ đã có `README.md`, không cần yêu cầu GitHub tạo thêm README.
4. Sao chép URL HTTPS, ví dụ `https://github.com/USERNAME/REPOSITORY.git`.
5. Trong thư mục dự án, chạy:

```powershell
git remote add origin https://github.com/USERNAME/REPOSITORY.git
git remote -v
git push -u origin main
```

- `remote add origin`: đặt tên `origin` cho địa chỉ repository từ xa.
- `push`: đưa commit cục bộ lên GitHub.
- `-u origin main`: liên kết nhánh `main` cục bộ với `origin/main`; những lần sau thường chỉ cần `git push`.

### Cách 2: Tạo repository bằng GitHub CLI

Sau khi chạy `gh auth login`, đứng trong thư mục dự án và dùng:

```powershell
gh repo create ten-repository --private --source=. --remote=origin --push
```

Thay `--private` bằng `--public` nếu chắc chắn nội dung có thể công khai.

## 10. Sửa kết nối GitHub khi nhập sai

Xem các remote hiện tại:

```powershell
git remote -v
```

Sửa URL của `origin`:

```powershell
git remote set-url origin https://github.com/USERNAME/REPOSITORY.git
```

Gỡ remote sai mà không xóa file hoặc commit cục bộ:

```powershell
git remote remove origin
```

Sau đó có thể thêm lại:

```powershell
git remote add origin https://github.com/USERNAME/REPOSITORY.git
```

Đổi tên nhánh hiện tại thành `main`:

```powershell
git branch -M main
```

## 11. Gỡ `git init` nếu khởi tạo nhầm thư mục

> **Cảnh báo:** thao tác dưới đây xóa toàn bộ lịch sử Git cục bộ của thư mục hiện tại. File dự án vẫn còn, nhưng commit, branch, tag và cấu hình repository sẽ mất. Không thực hiện nếu chưa chắc chắn.

Kiểm tra kỹ vị trí trước:

```powershell
Get-Location
git status
```

Nếu đúng là repository vừa tạo nhầm và không có lịch sử cần giữ:

```powershell
Remove-Item -LiteralPath .git -Recurse -Force
```

Không chạy lệnh này ở repository đang làm việc hoặc khi cần giữ lịch sử commit.

## 12. Checklist sau khi thiết lập

```powershell
git --version
git config --global user.name
git config --global user.email
git config --global init.defaultBranch
git config --global core.autocrlf
git config --list --show-origin
gh auth status
```

`gh auth status` chỉ cần chạy sau khi đã cài GitHub CLI và đăng nhập GitHub.

## 13. Tài liệu chính thức

- [Cài Git for Windows](https://git-scm.com/install/windows)
- [Git: First-Time Setup](https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup.html)
- [Git config reference](https://git-scm.com/docs/git-config)
- [Tạo tài khoản GitHub](https://docs.github.com/en/get-started/start-your-journey/creating-an-account-on-github)
- [Thiết lập Git với GitHub](https://docs.github.com/en/get-started/git-basics/set-up-git)
- [Xác thực với GitHub](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/about-authentication-to-github)
- [Xác thực hai lớp GitHub](https://docs.github.com/en/authentication/securing-your-account-with-two-factor-authentication-2fa/about-two-factor-authentication)
- [Cấu hình email commit](https://docs.github.com/en/account-and-profile/how-tos/email-preferences/setting-your-commit-email-address)
