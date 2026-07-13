# Git Basics: Repository, Staging và Commit

> Tài liệu Tuần 1 dành cho người mới học Git trên Windows, sử dụng PowerShell.

## 1. Mục tiêu học tập

Sau khi hoàn thành bài này, bạn có thể:

- Giải thích repository, working directory, staging area và commit.
- Nhận biết các trạng thái `untracked`, `modified`, `staged` và `committed`.
- Tạo một Git repository cục bộ.
- Kiểm tra thay đổi trước khi lưu vào lịch sử.
- Thực hiện đúng quy trình `status → diff → add → diff --staged → commit`.
- Đọc lịch sử bằng `git log`.
- Tạo ít nhất 5 commit nhỏ, rõ ràng và có ý nghĩa.

## 2. Mô hình hoạt động của Git

Git quản lý thay đổi qua ba khu vực chính:

```text
Working directory          Staging area             Repository
(Nơi chỉnh sửa file)       (Chuẩn bị commit)        (Lịch sử Git)

    modified    --git add-->    staged    --git commit--> committed
```

### 2.1. Repository

Repository là thư mục dự án được Git quản lý. Khi chạy:

```powershell
git init
```

Git tạo thư mục ẩn `.git`. Thư mục này chứa lịch sử commit, branch, cấu hình cục bộ và dữ liệu nội bộ của repository.

> Không tự ý sửa hoặc xóa `.git`. Xóa thư mục này đồng nghĩa với việc xóa lịch sử Git cục bộ của dự án.

### 2.2. Working directory

Working directory, còn gọi là working tree, là các file bạn đang nhìn thấy và trực tiếp chỉnh sửa. Ví dụ:

```text
git-learning/
└── README.md
```

Khi sửa `README.md`, nội dung mới trước tiên chỉ nằm trong working directory.

### 2.3. Staging area

Staging area là khu vực chuẩn bị cho commit tiếp theo. Lệnh sau đưa phiên bản hiện tại của file vào staging area:

```powershell
git add README.md
```

`git add` không lưu thay đổi vào lịch sử. Nó chỉ lựa chọn nội dung sẽ xuất hiện trong commit tiếp theo.

Nếu tiếp tục sửa file sau khi chạy `git add`, phần sửa mới không tự động được stage. Bạn cần kiểm tra và chạy `git add` lại nếu muốn đưa phần đó vào cùng commit.

### 2.4. Commit

Commit là một mốc lịch sử chứa ảnh chụp của nội dung đã được stage tại một thời điểm.

```powershell
git commit -m "docs: add project introduction"
```

Mỗi commit có:

- Commit hash: mã định danh duy nhất.
- Tác giả và email.
- Thời gian tạo.
- Commit message.
- Nội dung thay đổi.
- Liên kết đến commit trước đó.

## 3. Các trạng thái của file

### 3.1. Untracked

File mới tồn tại trong working directory nhưng Git chưa theo dõi.

```text
?? README.md
```

Đưa file vào staging area:

```powershell
git add README.md
```

### 3.2. Modified

File đã được Git theo dõi, sau đó được chỉnh sửa nhưng thay đổi mới chưa được stage.

```text
 M README.md
```

### 3.3. Staged

Thay đổi đã nằm trong staging area và sẵn sàng được commit.

```text
M  README.md
```

### 3.4. Committed

Thay đổi đã được lưu vào lịch sử repository. Khi không có thay đổi mới, Git thông báo:

```text
nothing to commit, working tree clean
```

### 3.5. Staged và modified cùng lúc

Nếu stage một file rồi tiếp tục sửa file đó, file có cả thay đổi staged và chưa staged:

```text
MM README.md
```

Hai chữ `M` đại diện cho hai nhóm thay đổi khác nhau:

- Chữ `M` bên trái: thay đổi đã được stage.
- Chữ `M` bên phải: thay đổi mới vẫn ở working directory.

## 4. Các lệnh cần học

### 4.1. `git --version`

Kiểm tra Git đã được cài đặt và xem phiên bản:

```powershell
git --version
```

Ví dụ kết quả:

```text
git version 2.x.x.windows.x
```

### 4.2. `git config`

Xem toàn bộ cấu hình và nguồn của từng giá trị:

```powershell
git config --list --show-origin
```

Xem tên và email tác giả:

```powershell
git config --global user.name
git config --global user.email
```

Thiết lập nếu chưa có:

```powershell
git config --global user.name "Ten Cua Ban"
git config --global user.email "email@example.com"
git config --global init.defaultBranch main
```

`--global` áp dụng cho người dùng hiện tại trên máy. Nếu bỏ `--global`, cấu hình được ghi cho repository hiện tại và có thể ghi đè cấu hình global.

### 4.3. `git init`

Khởi tạo Git repository trong thư mục hiện tại:

```powershell
git init
```

Thông thường chỉ chạy một lần khi bắt đầu repository.

### 4.4. `git status`

Xem trạng thái chi tiết:

```powershell
git status
```

Xem dạng ngắn:

```powershell
git status --short
```

Một số ký hiệu thường gặp:

| Ký hiệu | Ý nghĩa |
| --- | --- |
| `?? file` | File chưa được Git theo dõi |
| ` M file` | File đã sửa nhưng chưa stage |
| `M  file` | Thay đổi đã được stage |
| `MM file` | Có cả thay đổi staged và chưa staged |
| `A  file` | File mới đã được stage |

### 4.5. `git add`

Stage một file cụ thể:

```powershell
git add README.md
```

Stage nhiều file cụ thể:

```powershell
git add README.md notes.md
```

Stage mọi thay đổi trong thư mục hiện tại:

```powershell
git add .
```

Khi mới học, nên ưu tiên thêm từng file để biết chính xác nội dung nào chuẩn bị được commit.

### 4.6. `git diff`

Xem thay đổi chưa được stage:

```powershell
git diff
```

Xem thay đổi đã được stage, tức nội dung sắp được commit:

```powershell
git diff --staged
```

Xem thay đổi chưa stage của một file cụ thể:

```powershell
git diff README.md
```

Sau khi chạy `git add`, `git diff` có thể không hiển thị gì vì thay đổi đã chuyển sang staging area. Khi đó cần dùng `git diff --staged`.

> `git diff` mặc định không hiển thị nội dung của file untracked. Hãy dùng `git status` để phát hiện file mới.

### 4.7. `git commit`

Tạo commit từ nội dung đang nằm trong staging area:

```powershell
git commit -m "docs: add learning objectives"
```

Commit message tốt nên:

- Ngắn gọn và cụ thể.
- Nói rõ mục đích của thay đổi.
- Bắt đầu bằng động từ như `add`, `update`, `fix`, `remove`.
- Chỉ mô tả một thay đổi logic.

Ví dụ tốt:

```text
docs: add installation instructions
fix: correct README command example
```

Ví dụ chưa tốt:

```text
update
fix stuff
changes
```

### 4.8. `git log`

Xem lịch sử đầy đủ:

```powershell
git log
```

Xem dạng ngắn gọn:

```powershell
git log --oneline
```

Xem lịch sử dạng đồ thị:

```powershell
git log --oneline --graph --decorate --all
```

Nếu Git mở lịch sử trong trình phân trang, nhấn `q` để thoát.

## 5. Quy trình lưu một thay đổi vào lịch sử

Quy trình chuẩn trước mỗi commit:

```powershell
git status
git diff
git add README.md
git status
git diff --staged
git commit -m "docs: describe the change"
git status
git log --oneline
```

Ý nghĩa từng bước:

1. `git status`: phát hiện file mới, file đã sửa và trạng thái staging.
2. `git diff`: đọc thay đổi chưa được stage.
3. `git add`: lựa chọn nội dung cho commit.
4. `git status`: xác nhận đúng file đã được stage.
5. `git diff --staged`: duyệt chính xác nội dung sắp commit.
6. `git commit`: lưu nội dung staged vào lịch sử.
7. `git status`: kiểm tra còn thay đổi nào chưa xử lý không.
8. `git log --oneline`: xác nhận commit mới xuất hiện trong lịch sử.

Trước khi commit, hãy tự hỏi:

1. Tôi đã thay đổi những file nào?
2. Nội dung staged có đúng mục đích của commit không?
3. Commit message có mô tả rõ thay đổi không?

## 6. Thực hành: tạo repository `git-learning`

### 6.1. Khởi tạo dự án

Mở PowerShell và chạy:

```powershell
cd "D:\Software Learning\Git"
New-Item -ItemType Directory -Name "git-learning"
cd "git-learning"
git init
git status
```

Nếu Git chưa được cấu hình để dùng `main`, đổi tên nhánh hiện tại:

```powershell
git branch -M main
```

### 6.2. Commit 1: tạo README

Tạo file:

```powershell
New-Item -ItemType File -Name "README.md"
```

Thêm nội dung:

```markdown
# Git Learning
```

Kiểm tra, stage và commit:

```powershell
git status
git diff
git add README.md
git status
git diff --staged
git commit -m "docs: add initial README"
git status
```

### 6.3. Commit 2: thêm mô tả

Thêm vào `README.md`:

```markdown
Repository này được sử dụng để thực hành Git cơ bản.
```

Thực hiện vòng lặp:

```powershell
git status
git diff
git add README.md
git diff --staged
git commit -m "docs: add repository description"
git status
```

### 6.4. Commit 3: thêm mục tiêu

Thêm vào `README.md`:

```markdown
## Mục tiêu

- Hiểu working directory và staging area.
- Biết cách tạo một commit.
- Biết cách kiểm tra lịch sử Git.
```

Kiểm tra và commit:

```powershell
git status
git diff
git add README.md
git diff --staged
git commit -m "docs: add learning objectives"
git status
```

### 6.5. Commit 4: thêm quy trình làm việc

Thêm vào `README.md`:

```markdown
## Quy trình làm việc

1. Chỉnh sửa file.
2. Kiểm tra bằng `git status` và `git diff`.
3. Stage thay đổi bằng `git add`.
4. Kiểm tra bằng `git diff --staged`.
5. Tạo commit bằng `git commit`.
```

Kiểm tra và commit:

```powershell
git status
git diff
git add README.md
git diff --staged
git commit -m "docs: document basic Git workflow"
git status
```

### 6.6. Commit 5: thêm danh sách lệnh

Thêm vào `README.md`:

````markdown
## Các lệnh đã học

```bash
git status
git add
git commit
git diff
git log
```
````

Kiểm tra và commit:

```powershell
git status
git diff
git add README.md
git diff --staged
git commit -m "docs: add learned Git commands"
git status
git log --oneline
```

Kết quả cuối cùng của `git status` cần là:

```text
nothing to commit, working tree clean
```

Lịch sử sẽ tương tự:

```text
e52a891 docs: add learned Git commands
ab82911 docs: document basic Git workflow
c92d534 docs: add learning objectives
95fcb38 docs: add repository description
153afe0 docs: add initial README
```

Commit hash trên mỗi repository sẽ khác nhau.

## 7. Bài tập quan sát trạng thái `MM`

Sau khi hoàn thành 5 commit, thêm một dòng vào `README.md`:

```markdown
Tôi đang học cách quan sát trạng thái của Git.
```

Kiểm tra:

```powershell
git status --short
```

Kết quả:

```text
 M README.md
```

Stage thay đổi và kiểm tra lại:

```powershell
git add README.md
git status --short
```

Kết quả:

```text
M  README.md
```

Tiếp tục sửa file và thêm:

```markdown
Tôi tiếp tục sửa file sau khi đã stage.
```

Kiểm tra:

```powershell
git status --short
```

Kết quả:

```text
MM README.md
```

So sánh hai nhóm thay đổi:

```powershell
git diff
git diff --staged
```

Nếu muốn đưa cả hai phần vào cùng commit:

```powershell
git add README.md
git diff --staged
git commit -m "docs: add Git status experiment"
```

## 8. Lỗi thường gặp

### `git diff` không hiển thị gì sau `git add`

Thay đổi đã được stage. Kiểm tra bằng:

```powershell
git diff --staged
```

### `git diff` không hiển thị file mới

File mới đang ở trạng thái untracked. Kiểm tra bằng:

```powershell
git status
```

### Commit báo thiếu tên hoặc email

Cấu hình thông tin tác giả:

```powershell
git config --global user.name "Ten Cua Ban"
git config --global user.email "email@example.com"
```

### Commit nhầm quá nhiều thay đổi

Nguyên nhân phổ biến là dùng `git add .` mà không kiểm tra. Hãy tạo thói quen dùng:

```powershell
git status
git diff --staged
```

### Đứng sai thư mục repository

Kiểm tra vị trí hiện tại và trạng thái Git:

```powershell
Get-Location
git status
```

Nếu nhận thông báo `not a git repository`, hãy di chuyển vào đúng thư mục chứa `.git`.

## 9. Nguyên tắc tạo commit tốt

- Mỗi commit giải quyết một mục đích logic.
- Commit nhỏ nhưng phải hoàn chỉnh và dễ hiểu.
- Không trộn sửa lỗi, đổi định dạng và thêm tính năng không liên quan trong một commit.
- Luôn đọc `git diff --staged` trước khi commit.
- Không commit mật khẩu, token, private key hoặc dữ liệu bí mật.
- Commit message cần nói được thay đổi gì và đủ rõ để đọc lại sau nhiều tháng.

## 10. Checklist hoàn thành Tuần 1

- [ ] Git hoạt động và `git --version` trả về phiên bản.
- [ ] `user.name` và `user.email` đã được cấu hình.
- [ ] Repository `git-learning` đã được khởi tạo.
- [ ] Repository có file `README.md`.
- [ ] Có ít nhất 5 commit nhỏ.
- [ ] `git log --oneline` hiển thị đủ các commit.
- [ ] `git status` báo working tree sạch sau khi hoàn thành.
- [ ] Phân biệt được repository, working directory và staging area.
- [ ] Phân biệt được untracked, modified, staged và committed.
- [ ] Giải thích được sự khác nhau giữa `git diff` và `git diff --staged`.
- [ ] Thực hiện được quy trình `status → diff → add → diff --staged → commit`.

## 11. Bảng ghi nhớ nhanh

| Mục đích | Lệnh |
| --- | --- |
| Kiểm tra phiên bản Git | `git --version` |
| Xem cấu hình | `git config --list --show-origin` |
| Khởi tạo repository | `git init` |
| Xem trạng thái | `git status` |
| Xem trạng thái ngắn | `git status --short` |
| Xem thay đổi chưa stage | `git diff` |
| Stage một file | `git add <file>` |
| Xem thay đổi đã stage | `git diff --staged` |
| Tạo commit | `git commit -m "message"` |
| Xem lịch sử ngắn | `git log --oneline` |

Quy trình cần ghi nhớ:

```text
Chỉnh sửa → status → diff → add → diff --staged → commit → log
```
