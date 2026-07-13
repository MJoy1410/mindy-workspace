# Git Roadmap: From Zero to Proficiency

Lộ trình này dành cho người mới bắt đầu, học khoảng **60–90 phút mỗi ngày, 5 ngày mỗi tuần**. Mục tiêu là sử dụng Git tự tin trong dự án cá nhân và khi làm việc nhóm.

> **Git** là công cụ quản lý phiên bản trên máy. **GitHub/GitLab** là nền tảng lưu repository và cộng tác qua Internet.

## Tuần 1: Git cơ bản

### Kiến thức

- Repository, working directory, staging area và commit.
- Trạng thái untracked, modified, staged và committed.
- Quy trình lưu một thay đổi vào lịch sử Git.

### Lệnh cần học

```bash
git --version
git config
git init
git status
git add
git commit
git diff
git log
```

### Thực hành

- Tạo repository `git-learning`.
- Tạo và chỉnh sửa README.
- Tạo ít nhất 5 commit nhỏ.
- Kiểm tra thay đổi bằng `git status` và `git diff` trước mỗi commit.

## Tuần 2: Quản lý file và lịch sử

### Kiến thức

- Sử dụng `.gitignore`.
- Xóa và đổi tên file.
- Bỏ file khỏi staging area.
- Phục hồi thay đổi chưa commit.
- Sửa commit gần nhất.

### Lệnh cần học

```bash
git restore
git restore --staged
git rm
git mv
git commit --amend
git show
git log --oneline
```

### Thực hành

- Tạo `.gitignore` cho file cấu hình và thư mục build.
- Stage nhầm một file rồi đưa file đó ra khỏi staging area.
- Sửa nhầm nội dung rồi phục hồi.
- Thay đổi nội dung và message của commit cuối.

## Tuần 3: Branch và merge

### Kiến thức

- Branch và HEAD.
- Feature branch.
- Fast-forward merge và three-way merge.
- Xóa branch sau khi hoàn thành.

### Lệnh cần học

```bash
git branch
git switch
git switch -c
git merge
git branch -d
```

### Thực hành

- Tạo một project nhỏ.
- Phát triển mỗi tính năng trên một branch riêng.
- Merge ít nhất 3 feature branch vào `main`.

## Tuần 4: Merge conflict

### Kiến thức

- Nguyên nhân xảy ra conflict.
- Cách đọc conflict marker.
- Giải quyết và hoàn tất merge.
- Hủy merge khi cần thiết.

### Lệnh cần học

```bash
git merge
git status
git merge --abort
git log --graph --oneline --all
```

### Thực hành

- Tạo hai branch sửa cùng một dòng.
- Merge để chủ động tạo conflict.
- Giải quyết conflict bằng tay.
- Lặp lại cho đến khi có thể xử lý mà không làm mất nội dung.

## Tuần 5: Remote repository

### Kiến thức

- Local và remote repository.
- Remote `origin` và upstream branch.
- Clone, push, fetch và pull.
- Sự khác nhau giữa `fetch` và `pull`.

### Lệnh cần học

```bash
git clone
git remote -v
git remote add
git push
git push -u
git fetch
git pull
```

### Thực hành

- Tạo repository trên GitHub.
- Push project local lên GitHub.
- Clone repository sang thư mục khác.
- Đồng bộ thay đổi giữa hai bản local.

## Tuần 6: Pull Request và làm việc nhóm

### Kiến thức

- Feature branch workflow.
- Pull Request và code review.
- Draft PR, review comment và approval.
- Branch protection ở mức cơ bản.

### Quy trình

```text
Cập nhật main
→ tạo feature branch
→ code và commit
→ push branch
→ mở Pull Request
→ review và chỉnh sửa
→ merge
→ xóa branch
```

### Thực hành

- Tạo một Pull Request cho mỗi tính năng.
- Tự review thay đổi trước khi merge.
- Viết mô tả PR gồm mục tiêu, thay đổi và cách kiểm thử.

## Tuần 7: Commit chuyên nghiệp

### Kiến thức

- Mỗi commit chứa một thay đổi logic.
- Commit message rõ ràng.
- Conventional Commits cơ bản.
- Interactive staging.

### Lệnh cần học

```bash
git add -p
git diff
git diff --staged
git commit
```

### Ví dụ commit message

```text
feat: add user login
fix: prevent duplicate registration
docs: update installation guide
refactor: extract token validation
test: add login failure tests
```

## Tuần 8: Rebase

### Kiến thức

- Sự khác nhau giữa merge và rebase.
- Rebase feature branch lên `main`.
- Reorder, squash, reword và drop commit.
- Rủi ro khi sửa lịch sử đã chia sẻ.

### Lệnh cần học

```bash
git rebase main
git rebase -i
git rebase --continue
git rebase --abort
```

> Không rebase lịch sử của branch công khai khi chưa thống nhất với nhóm.

## Tuần 9: Undo và recovery

### Kiến thức

- Phân biệt restore, reset và revert.
- Các chế độ reset: soft, mixed và hard.
- Khôi phục commit bằng reflog.
- Tạm cất công việc bằng stash.
- Chuyển một commit sang branch khác.

### Lệnh cần học

```bash
git stash
git stash list
git stash pop
git revert
git reset
git reflog
git cherry-pick
```

### Chọn công cụ phù hợp

| Tình huống | Công cụ |
|---|---|
| Bỏ thay đổi chưa stage | `git restore` |
| Bỏ file khỏi staging | `git restore --staged` |
| Hoàn tác commit đã chia sẻ | `git revert` |
| Sửa lịch sử local | `git reset` hoặc `git rebase` |
| Tìm commit bị mất | `git reflog` |
| Mang commit sang branch khác | `git cherry-pick` |
| Tạm cất công việc | `git stash` |

> Chỉ dùng `git reset --hard` sau khi hiểu rõ dữ liệu nào sẽ bị mất.

## Tuần 10: Git nâng cao

### Kiến thức

- Tag và release.
- Detached HEAD.
- Tìm commit gây lỗi bằng bisect.
- Đọc lịch sử và nguồn gốc từng dòng code.
- Git hooks và chiến lược branch ở mức nhập môn.

### Lệnh cần học

```bash
git tag
git bisect
git blame
git log --graph
```

### Bài tập cuối khóa

1. Tạo project với branch `main`.
2. Tạo ít nhất 5 feature branch.
3. Mở Pull Request cho từng tính năng.
4. Chủ động tạo và xử lý conflict.
5. Dọn lịch sử bằng interactive rebase.
6. Dùng `git bisect` tìm một commit gây lỗi.
7. Revert một thay đổi đã merge.
8. Tạo tag `v1.0.0`.
9. Viết tài liệu workflow cho thành viên mới.

## Cách học mỗi ngày

- 15 phút đọc lý thuyết.
- 30–45 phút thực hành lệnh.
- 15 phút chủ động tạo lỗi và khắc phục.
- 10 phút ghi chú lại bằng ngôn ngữ của mình.

Nên dành khoảng **20% thời gian cho lý thuyết và 80% cho thực hành**.

## Tiêu chí thành thạo

Bạn đã sử dụng Git tốt trong công việc khi có thể:

- Giải thích working tree, staging area, commit, branch và HEAD.
- Chọn đúng giữa merge, rebase, reset, restore và revert.
- Xử lý merge/rebase conflict mà không làm mất code.
- Khôi phục commit bằng reflog.
- Viết commit nhỏ, rõ ràng và dễ review.
- Làm việc nhóm bằng branch và Pull Request.
- Đọc lịch sử để tìm nguyên nhân lỗi.
- Nhận biết và thận trọng với các lệnh có thể làm mất dữ liệu.

Sau 10 tuần, bạn có thể dùng Git vững trong công việc. Để thực sự thành thạo, hãy tiếp tục áp dụng vào dự án thật trong khoảng **3–6 tháng**.
