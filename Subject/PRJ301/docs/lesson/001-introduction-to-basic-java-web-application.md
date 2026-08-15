# Giới thiệu ứng dụng Java Web cơ bản

> Môn học: PRJ301 - Java Web Application  
> Tech stack sử dụng trong môn học: JDK 1.8, NetBeans 13, Apache Tomcat 9, Microsoft SQL Server.

## 1. Tổng quan bài học

Bài học giới thiệu những thành phần nền tảng để bắt đầu với một ứng dụng Java Web. Nội dung chính của slide gồm:

- Khái niệm cơ bản về **HTML**.
- Vai trò của **Web Browser**.
- Khái niệm **Servlet** và cách Servlet tham gia vào quá trình xử lý Request/Response.
- Cấu trúc của **HTTP Request** và **HTTP Response**.
- Các HTTP Method và HTTP Status Code cơ bản.
- Cấu trúc một Servlet đơn giản và vòng đời của Servlet.
- Cách đọc **Request Header**.
- Cách sử dụng **HTML Form** và lấy dữ liệu Form trong Servlet.
- Khái niệm **Web Application**.
- Cấu trúc thư mục của Java Web Application.
- File cấu hình triển khai **web.xml**.
- Đóng gói và triển khai ứng dụng dưới dạng **WAR file**.
- So sánh cơ bản giữa **GET** và **POST** theo nội dung của slide.

Slide cũng nêu các mục tiêu như thiết lập môi trường và tạo/build ứng dụng đầu tiên. Tuy nhiên, phần slide được cung cấp tập trung chủ yếu vào kiến thức nền tảng, cấu trúc Servlet và cách triển khai ứng dụng; không có hướng dẫn cài đặt NetBeans/Tomcat từng bước.

---

## 2. HTML cơ bản

### 2.1. HTML là gì?

**HTML** viết tắt của **HyperText Markup Language**.

HTML là ngôn ngữ dùng để mô tả cấu trúc và nội dung của một trang Web.

Điểm cần nhớ:

- HTML **không phải là ngôn ngữ lập trình**.
- HTML là một **Markup Language - ngôn ngữ đánh dấu**.
- Một ngôn ngữ đánh dấu sử dụng các **markup tag - thẻ đánh dấu**.
- HTML sử dụng các thẻ để mô tả nội dung của trang Web.

Hiểu đơn giản, HTML cho trình duyệt biết đâu là tiêu đề, đâu là đoạn văn, đâu là biểu mẫu nhập dữ liệu và các thành phần khác của trang Web.

---

### 2.2. HTML Tag

Các thẻ đánh dấu trong HTML thường được gọi là **HTML Tag**.

Ví dụ:

```html
<html>
```

Một HTML tag thường có các đặc điểm:

- Tên thẻ nằm bên trong dấu ngoặc nhọn `<` và `>`.
- Nhiều thẻ HTML xuất hiện theo cặp.
- Thẻ đầu tiên gọi là **Start Tag** hoặc **Opening Tag**.
- Thẻ thứ hai gọi là **End Tag** hoặc **Closing Tag**.

Ví dụ:

```html
<b>Nội dung</b>
```

Trong đó:

- `<b>` là thẻ mở.
- `</b>` là thẻ đóng.
- `Nội dung` là phần nằm giữa hai thẻ.

Slide cũng minh họa một thẻ có **attribute - thuộc tính**:

```html
<div class="main">content</div>
```

Trong ví dụ trên:

- `div` là tên thẻ.
- `class` là tên thuộc tính.
- `main` là giá trị của thuộc tính.
- `content` là nội dung của phần tử.

---

### 2.3. HTML Document và Web Page

Một **HTML Document** là tài liệu mô tả một trang Web.

HTML Document có thể chứa:

- Các HTML tag.
- Văn bản thông thường.

HTML Document cũng thường được gọi là **Web Page - trang Web**.

Có thể hình dung:

```text
HTML Document
      |
      v
Web Browser đọc và diễn giải HTML
      |
      v
Web Page hiển thị cho người dùng
```

---

### 2.4. Web Browser

**Web Browser - trình duyệt Web** là chương trình dùng để đọc tài liệu HTML và hiển thị tài liệu đó dưới dạng trang Web.

Một số trình duyệt được slide nhắc đến:

- Internet Explorer
- Microsoft Edge
- Google Chrome
- Safari
- Opera
- Firefox

Trình duyệt không hiển thị trực tiếp các HTML tag cho người dùng. Thay vào đó, trình duyệt sử dụng các tag để **interpret - diễn giải** nội dung và quyết định cách hiển thị trang.

Ví dụ, đoạn HTML:

```html
<h1>This is a heading</h1>
```

được trình duyệt hiểu là một tiêu đề cấp 1 và hiển thị nội dung `This is a heading` theo cách tương ứng.

---

### 2.5. Ví dụ cấu trúc một trang HTML

Slide minh họa một trang HTML cơ bản với phần `<head>` và `<body>`:

```html
<html>
<head>
    <title>Page title</title>
</head>
<body>
    <h1>This is a heading</h1>
    <p>This is a paragraph.</p>
    <p>This is another paragraph.</p>
</body>
</html>
```

Ý nghĩa chính:

- `<html>` bao toàn bộ tài liệu HTML.
- `<head>` chứa thông tin mô tả cho tài liệu.
- `<title>` xác định tiêu đề của trang.
- `<body>` chứa nội dung được hiển thị cho người dùng.
- `<h1>` tạo tiêu đề.
- `<p>` tạo đoạn văn.

---

## 3. Servlet

### 3.1. Servlet là gì?

**Servlet** là một chương trình Java nhỏ chạy trên Web Server và hỗ trợ xây dựng các trang Web động.

Servlet có nhiệm vụ chính:

- Nhận **Request - yêu cầu** từ Web Client.
- Xử lý yêu cầu.
- Tạo và gửi **Response - phản hồi** về Client.

Việc trao đổi này thường được thực hiện thông qua **HTTP - HyperText Transfer Protocol**.

Java Servlet được xây dựng nhằm cung cấp nội dung:

- **Dynamic - động**.
- Hướng đến người dùng.
- Có khả năng chạy trên môi trường Web Server hỗ trợ Servlet.

---

### 3.2. Client, Server, Request và Response

Sơ đồ trên slide mô tả luồng hoạt động cơ bản:

```text
Browser / Client
      |
      | HTTP Request
      v
Web Server
      |
      v
Servlet Container
      |
      v
Servlet
      |
      +------> Database
      |
      | HTTP Response
      v
Browser / Client
```

Các thành phần:

#### Client

**Client** là phía gửi yêu cầu đến Server. Trong ứng dụng Web, Client thường là trình duyệt.

#### Request

**Request** là yêu cầu mà Client gửi đến Server.

Ví dụ, Client có thể yêu cầu:

- Mở một trang Web.
- Gửi dữ liệu đăng nhập.
- Gửi dữ liệu từ Form.

#### Web Server

**Web Server** tiếp nhận HTTP Request và phối hợp với môi trường Servlet để xử lý yêu cầu.

#### Servlet Container

Slide đặt các Servlet bên trong **Servlet Container**. Container là môi trường quản lý và thực thi Servlet.

#### Servlet

Servlet nhận Request, thực hiện xử lý và tạo Response.

#### Database

Servlet có thể làm việc với Database khi cần đọc hoặc lưu dữ liệu.

#### Response

**Response** là dữ liệu Server gửi ngược về Client sau khi xử lý Request.

---

### 3.3. Kiến trúc cơ bản của Servlet Package

Slide sử dụng package:

```java
javax.servlet
```

Package này cung cấp các interface và class cần thiết để viết Servlet.

Sơ đồ kế thừa/quan hệ được trình bày theo hướng:

```text
Servlet
   ^
   |
GenericServlet
   ^
   |
HttpServlet
   ^
   |
MyServlet
```

Có thể hiểu theo cách viết Servlet HTTP phổ biến trong bài:

- Servlet API định nghĩa nền tảng chung cho Servlet.
- `GenericServlet` cung cấp triển khai Servlet ở mức tổng quát.
- `HttpServlet` được sử dụng cho Servlet hoạt động với HTTP.
- Servlet do lập trình viên viết, ví dụ `MyServlet`, kế thừa `HttpServlet`.

Trong tech stack của môn học với Tomcat 9, các ví dụ trong slide tiếp tục sử dụng namespace `javax.servlet`.

---

### 3.4. ServletRequest và ServletResponse

Khi một Servlet nhận lời gọi từ Client, slide nhấn mạnh hai object quan trọng:

#### ServletRequest

`ServletRequest` đóng gói thông tin giao tiếp **từ Client đến Server**.

Nó đại diện cho dữ liệu Request mà Client gửi lên.

#### ServletResponse

`ServletResponse` đóng gói thông tin giao tiếp **từ Servlet đến Client**.

Nó được sử dụng để tạo dữ liệu Response trả về.

---

## 4. HTTP Request

### 4.1. HTTP Request gồm những gì?

Theo slide, một HTTP Request gồm bốn phần chính:

1. **Request Method**
2. **Request URL**
3. **Header Fields**
4. **Body**

Có thể hình dung:

```text
HTTP Request
|-- Method
|-- URL
|-- Headers
`-- Body
```

---

### 4.2. Các HTTP Method trong HTTP/1.1

Slide giới thiệu các HTTP Method sau:

| Method | Ý nghĩa theo slide |
|---|---|
| `GET` | Lấy tài nguyên được xác định bởi Request URL. |
| `HEAD` | Trả về phần Header tương ứng với tài nguyên được xác định bởi Request URL. |
| `POST` | Gửi dữ liệu đến Web Server. |
| `PUT` | Lưu một tài nguyên tại Request URL. |
| `DELETE` | Xóa tài nguyên được xác định bởi Request URL. |
| `OPTIONS` | Trả về các HTTP Method mà Server hỗ trợ. |
| `TRACE` | Trả về các Header Field được gửi cùng TRACE Request. |

---

### 4.3. Ví dụ HTTP Request

Slide minh họa Request có dạng:

```http
GET /RegisterStudent.asp?user=jhon&pass=java HTTP/1.1
Host: guru99.com
User-Agent: Mozilla/5.0
Accept: text/xml,text/html,text/plain,image/jpeg
Accept-Language: en-us,en
Accept-Encoding: gzip,deflate
Accept-Charset: ISO-8859-1, utf-8
Keep-Alive: 300
Connection: keep-alive
```

Các phần chính có thể đọc như sau:

```text
GET
 |
 +-- HTTP Method

/RegisterStudent.asp
 |
 +-- Đường dẫn đến tài nguyên trên Web Server

?user=jhon&pass=java
 |
 +-- Parameters gửi đến Server

HTTP/1.1
 |
 +-- Phiên bản HTTP mà Client sử dụng
```

Các dòng bên dưới là **Request Header**.

---

### 4.4. Safe Method và Idempotent Method

Slide phân loại các method bằng hai khái niệm:

- **Safe**
- **Idempotent**

Theo sơ đồ trong slide:

- `GET`, `HEAD`, `OPTIONS`, `TRACE` thuộc nhóm **Safe** và đồng thời **Idempotent**.
- `PUT` và `DELETE` thuộc nhóm **Idempotent**, nhưng không nằm trong nhóm Safe.
- `POST` nằm ngoài cả nhóm Safe và Idempotent trong sơ đồ.

Có thể ghi nhớ theo hình sau:

```text
Safe + Idempotent
- GET
- HEAD
- OPTIONS
- TRACE

Idempotent nhưng không Safe
- PUT
- DELETE

Không Safe và không Idempotent theo sơ đồ
- POST
```

---

## 5. HTTP Response

### 5.1. HTTP Response gồm những gì?

Theo slide, một HTTP Response gồm:

1. **Result Code / Status Code**
2. **Header Fields**
3. **Body**

HTTP yêu cầu Status Code và các Header được gửi trước phần nội dung Body.

Dạng tổng quát:

```text
Status Line
Response Headers
Blank Line
Response Body
```

---

### 5.2. Một số HTTP Status Code thường gặp

Slide đưa ra các ví dụ:

| Status Code | Ý nghĩa |
|---|---|
| `404` | Tài nguyên được yêu cầu không tồn tại hoặc không khả dụng. |
| `401` | Request yêu cầu HTTP Authentication. |
| `500` | Có lỗi bên trong HTTP Server khiến Server không thể hoàn thành Request. |
| `503` | HTTP Server đang tạm thời quá tải và không thể xử lý Request. |

---

### 5.3. Năm nhóm HTTP Status Code

HTTP Response Status Code được chia thành năm nhóm. Chữ số đầu tiên xác định nhóm của Response.

| Nhóm | Tên | Ý nghĩa |
|---|---|---|
| `1xx` | Informational Response | Request đã được nhận và quá trình xử lý đang tiếp tục. |
| `2xx` | Successful | Request đã được nhận, hiểu và chấp nhận thành công. |
| `3xx` | Redirection | Cần thực hiện thêm hành động để hoàn tất Request. |
| `4xx` | Client Error | Request có lỗi từ phía Client hoặc không thể được thực hiện. |
| `5xx` | Server Error | Server không thể hoàn thành một Request có vẻ hợp lệ. |

---

### 5.4. Một số HTTP/1.1 Status Code trong slide

#### 101 Switching Protocols

Server đồng ý với Header yêu cầu nâng cấp giao thức và chuyển sang giao thức khác.

#### 200 OK

Request được xử lý bình thường.

Slide lưu ý rằng đây là trạng thái mặc định phổ biến đối với Servlet; nếu không thiết lập Status khác thì Response thường nhận trạng thái này.

#### 201 Created

Server đã tạo một tài nguyên/tài liệu mới. Header `Location` có thể chỉ ra URL của tài nguyên đó.

#### 202 Accepted

Request đã được chấp nhận để xử lý nhưng quá trình xử lý chưa hoàn tất.

#### 203 Non-Authoritative Information

Tài liệu được trả về bình thường nhưng một số Response Header có thể không hoàn toàn chính xác vì dữ liệu được lấy từ một bản sao.

---

### 5.5. Ví dụ HTTP Response

Slide minh họa Response có cấu trúc tương tự:

```http
HTTP/1.1 200 OK
Date: Mon, 01 Jun 2009 17:19:57 GMT
Server: Apache/2.0.63 (Unix) mod_ssl/2.0.63 ...
X-Powered-By: PHP/5.2.8
X-Pingback: http://moleseyhill.com/blog/xmlrpc.php
Keep-Alive: timeout=15, max=100
Connection: Keep-Alive
Transfer-Encoding: chunked
Content-Type: text/html; charset=UTF-8

2475
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML ...">
<html xmlns="http://www.w3.org/1999/xhtml" dir="...">
...
<title>Struggling for Competence</title>
```

Điểm quan trọng trong ví dụ:

- Dòng đầu là **Status Line**.
- Tiếp theo là các **Response Header**.
- Có một **Blank Line - dòng trống** phân tách Header và Body.
- Phần sau là **Content**, ở ví dụ này là HTML.

---

### 5.6. Cấu trúc Status Line

Slide mô tả Status Line bao gồm:

- Phiên bản HTTP.
- Một số nguyên được diễn giải là Status Code.
- Một thông điệp ngắn tương ứng với Status Code.

Ví dụ:

```http
HTTP/1.1 200 OK
```

Trong đó:

- `HTTP/1.1`: phiên bản HTTP.
- `200`: Status Code.
- `OK`: thông điệp trạng thái.

Slide cũng nhấn mạnh `Content-Type` là Header quan trọng vì nó xác định **MIME Type** của tài liệu được gửi trong Response.

Ví dụ:

```http
Content-Type: text/plain
```

---

## 6. Một Servlet đơn giản

### 6.1. Ví dụ FirstServlet

Slide đưa ra Servlet đầu tiên như sau. Phần dấu ngoặc kép được chuẩn hóa về ký tự `"` để đoạn code có thể đọc và biên dịch đúng trong Java, còn cấu trúc code được giữ nguyên theo slide.

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>First Servlet</h1>");
    }
}
```

Giải thích:

- `FirstServlet` kế thừa `HttpServlet`.
- `doGet(...)` được dùng để xử lý HTTP GET Request.
- `HttpServletRequest request` đại diện cho Request từ Client.
- `HttpServletResponse response` đại diện cho Response sẽ trả về Client.
- `response.getWriter()` lấy một `PrintWriter` để ghi nội dung Response.
- `out.println(...)` gửi HTML về Client.

Nội dung HTML Servlet trả về là:

```html
<h1>First Servlet</h1>
```

Slide chỉ ra vị trí demo theo cấu trúc thư mục:

```text
Demo\FirstServlet\WEB-INF\classes\FirstServlet.java
```

---

## 7. Vòng đời của Servlet

Slide mô tả **Servlet Life Cycle** với ba giai đoạn chính:

```text
Load Servlet
    |
    v
init
    |
    v
service
    |
    v
Handle Client Requests
    |
    v
destroy
    |
    v
Unload Servlet
```

### 7.1. init

`init` liên quan đến giai đoạn Servlet được nạp và khởi tạo trên Server.

### 7.2. service

`service` là giai đoạn Servlet tiếp nhận và xử lý các Request từ Client.

Trong sơ đồ, một Servlet có thể xử lý các Request đến từ nhiều Client trong giai đoạn này.

### 7.3. destroy

`destroy` được gọi khi Servlet chuẩn bị được gỡ khỏi Server hoặc kết thúc vòng đời.

Điểm cần nhớ:

```text
init -> service -> destroy
```

---

## 8. HttpServlet và các HTTP Method

`HttpServlet` hỗ trợ các method tương ứng với HTTP Request Method.

### 8.1. doGet

```java
doGet(...)
```

Được Server gọi thông qua `service` để Servlet xử lý GET Request.

### 8.2. doHead

```java
doHead(...)
```

Nhận và xử lý HTTP HEAD Request.

### 8.3. doPost

```java
doPost(...)
```

Được Server gọi để Servlet xử lý POST Request.

### 8.4. doPut

```java
doPut(...)
```

Được Server gọi thông qua `service` để xử lý PUT Request.

### 8.5. doDelete

```java
doDelete(...)
```

Được Server gọi thông qua `service` để xử lý DELETE Request.

### 8.6. doTrace

```java
doTrace(...)
```

Được Server gọi thông qua `service` để xử lý TRACE Request.

### 8.7. doOptions

```java
doOptions(...)
```

Được Server gọi thông qua `service` để xử lý OPTIONS Request.

Có thể ghi nhớ quan hệ:

```text
HTTP GET     -> doGet()
HTTP HEAD    -> doHead()
HTTP POST    -> doPost()
HTTP PUT     -> doPut()
HTTP DELETE  -> doDelete()
HTTP TRACE   -> doTrace()
HTTP OPTIONS -> doOptions()
```

---

## 9. Request Header

### 9.1. Request Header là gì?

Ngoài Method, URL và Body, Client còn có thể gửi nhiều Header trong HTTP Request.

Slide giới thiệu các Header sau:

| Header | Ý nghĩa theo slide |
|---|---|
| `Accept` | Các MIME Type mà Browser ưu tiên. |
| `Accept-Charset` | Bộ ký tự mà Browser mong muốn. |
| `Content-Length` | Với POST, cho biết lượng dữ liệu được gửi kèm. |
| `Connection` | Liên quan đến việc sử dụng kết nối duy trì, ví dụ Keep-Alive. |
| `Cookie` | Header chứa thông tin Cookie; slide nhấn mạnh đây là một Header quan trọng. |
| `Host` | Host và Port như được ghi trong URL ban đầu. |
| `If-Modified-Since` | Yêu cầu chỉ trả về tài liệu mới hơn thời điểm được chỉ định. |
| `Referer` | URL của trang chứa liên kết mà người dùng đã đi theo để đến trang hiện tại. |

---

### 9.2. Đọc toàn bộ Request Header trong Servlet

Slide sử dụng `request.getHeaderNames()` để lấy danh sách tên Header và `request.getHeader(...)` để đọc giá trị từng Header.

```java
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;

public class ShowRequestHeaders extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Enumeration headerNames = request.getHeaderNames();

        out.println("<TABLE>");
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.println("<TR><TD>" + headerName + "</TD>");
            out.println("<TD>" + request.getHeader(headerName) + "</TD></TR>");
        }
        out.println("</TABLE>");
    }
}
```

Luồng xử lý:

```text
request.getHeaderNames()
        |
        v
Lấy danh sách tên Header
        |
        v
Duyệt từng Header
        |
        v
request.getHeader(headerName)
        |
        v
In tên Header và giá trị ra bảng HTML
```

Slide chỉ ra file demo:

```text
Demo\FirstServlet\WEB-INF\classes\ShowRequestHeaders.java
```

---

## 10. HTML Form

### 10.1. Form là gì?

**Form** là một vùng trên trang HTML có thể chứa các **Form Element**.

Form Element cho phép người dùng nhập hoặc lựa chọn thông tin.

Slide đưa ra các ví dụ:

- Text field
- Textarea
- Drop-down menu
- Radio button
- Checkbox

---

### 10.2. Text Field

Ví dụ trong slide:

```html
<html>
<body>
<form>
First name: <input type="text" name="firstname" />
<br />
Last name: <input type="text" name="lastname" />
</form>
</body>
<html>
```

Khi hiển thị trên Browser, người dùng có hai ô nhập:

```text
First name: [             ]
Last name:  [             ]
```

Trong đó:

- `type="text"` tạo ô nhập văn bản.
- `name="firstname"` đặt tên cho dữ liệu của ô First name.
- `name="lastname"` đặt tên cho dữ liệu của ô Last name.

> Đoạn code trên được giữ theo nội dung slide, bao gồm cách slide ghi thẻ `<html>` ở dòng cuối.

---

### 10.3. Radio Button

Ví dụ trong slide:

```html
<html>
<body>
<form>
<input type="radio" name="sex" value="male" /> Male
<br />
<input type="radio" name="sex" value="female" /> Female
</form>
</body>
<html>
```

Kết quả hiển thị có dạng:

```text
( ) Male
( ) Female
```

Hai radio button sử dụng cùng:

```html
name="sex"
```

nhưng có các `value` khác nhau:

```text
male
female
```

> Đoạn code trên được giữ theo nội dung slide, bao gồm cách slide ghi thẻ `<html>` ở dòng cuối.

---

## 11. Form Action và Submit Button

### 11.1. Thuộc tính action

Khi người dùng nhấn nút **Submit**, nội dung của Form được gửi đến Server.

Thuộc tính `action` của Form xác định nơi nhận dữ liệu.

Ví dụ:

```html
<form action="/LoginServlet">
```

Trong trường hợp này, dữ liệu Form sẽ được gửi đến `/LoginServlet`.

---

### 11.2. Thuộc tính method

Slide sử dụng:

```html
method="post"
```

Do đó Form gửi dữ liệu bằng HTTP POST.

---

### 11.3. Ví dụ Form đăng nhập

```html
<html>
<body>
<form name="input" action="/LoginServlet" method="post">
<table>
<tr>
    <td>User name:</td><td><input type="text" name="user"/></td>
</tr>
<tr>
    <td>Password:</td><td><input type="password" name="pass"/></td>
</tr>
<tr>
    <td></td><td><input type="submit" value="Login"/></td>
</tr>
</table>
</form>
</body>
</html>
```

Các phần quan trọng:

```html
action="/LoginServlet"
```

Dữ liệu được gửi đến Servlet có đường dẫn `/LoginServlet`.

```html
method="post"
```

Dữ liệu được gửi bằng POST.

```html
name="user"
```

Tên parameter của ô User name là `user`.

```html
name="pass"
```

Tên parameter của ô Password là `pass`.

```html
<input type="submit" value="Login"/>
```

Tạo nút Submit có nội dung `Login`.

---

## 12. Nhận Form Data trong Servlet

Để lấy dữ liệu Form, slide sử dụng method:

```java
request.getParameter(...)
```

Method này thuộc `HttpServletRequest` và nhận tên của parameter làm đối số.

Ví dụ:

```java
public void doPost(HttpServletRequest request,
                   HttpServletResponse response)
        throws ServletException, IOException {

    //--- get form data
    String u = request.getParameter("user");
    String p = request.getParameter("pass");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<html><body>");
    out.println("<h1>You sent me:</h1>");
    out.println(u + "<br>" + p);
    out.println("</body></html>");
}
```

Liên hệ với Form:

```html
<input type="text" name="user"/>
<input type="password" name="pass"/>
```

Servlet lấy dữ liệu bằng đúng tên tương ứng:

```java
request.getParameter("user");
request.getParameter("pass");
```

Có thể hình dung luồng dữ liệu:

```text
HTML Form
   |
   | user=...
   | pass=...
   v
POST /LoginServlet
   |
   v
doPost(...)
   |
   +--> request.getParameter("user")
   |
   +--> request.getParameter("pass")
   |
   v
Tạo HTML Response
```

---

## 13. Web Application

### 13.1. Web Application là gì?

**Web Application** hoặc **Webapp** là ứng dụng được truy cập thông qua Web Browser trên một mạng như:

- Internet
- Intranet

Slide mô tả Web Application là một ứng dụng phần mềm được xây dựng bằng những công nghệ/ngôn ngữ mà môi trường Web hỗ trợ, ví dụ:

- HTML
- JavaScript
- Java

và sử dụng Web Browser để hiển thị và tương tác với ứng dụng.

---

### 13.2. Thin Client

Web Application phổ biến một phần vì Web Browser xuất hiện trên hầu hết máy người dùng và có thể đóng vai trò Client.

Slide gọi kiểu Client này là **Thin Client**.

Điểm chính cần nhớ: người dùng chủ yếu cần Browser để truy cập ứng dụng Web thay vì phải cài đặt một chương trình Client riêng cho từng ứng dụng.

---

## 14. Cấu trúc file và thư mục của Web Application

Một Web Application cần có cấu trúc file và thư mục rõ ràng để từng loại tài nguyên nằm đúng vị trí.

Slide nêu các loại nội dung có thể tồn tại trong Web Application:

- Static content
- JSP page
- Servlet class
- Deployment descriptor
- Tag library
- JAR file
- Java class file

Slide cũng nhắc đến việc bảo vệ resource file khỏi việc truy cập trực tiếp thông qua HTTP.

---

## 15. Các thư mục đặc biệt dưới Context Root

### 15.1. Context Root

**Context Root** là thư mục gốc của một Web Application trên Web Container.

Bên dưới Context Root có một số thư mục đặc biệt được slide nhấn mạnh.

---

### 15.2. /WEB-INF/classes

```text
/WEB-INF/classes
```

Dùng cho các Java class tồn tại dưới dạng file class riêng, không được đóng gói trong JAR.

Các class này có thể là:

- Servlet.
- Class hỗ trợ khác của ứng dụng.

---

### 15.3. /WEB-INF/lib

```text
/WEB-INF/lib
```

Dùng để chứa các file **JAR**.

JAR có thể chứa:

- Servlet của ứng dụng.
- Class hỗ trợ.
- Class hỗ trợ kết nối Database.
- Các thành phần Java khác cần cho ứng dụng.

---

### 15.4. /WEB-INF và web.xml

```text
/WEB-INF
```

là nơi chứa file rất quan trọng:

```text
web.xml
```

`web.xml` được gọi là **Deployment Descriptor**.

---

## 16. Deployment Descriptor - web.xml

### 16.1. Deployment Descriptor là gì?

Slide nhấn mạnh rằng Deployment Descriptor là một **XML file**.

Tên file là:

```text
web.xml
```

File này mô tả cấu hình triển khai của Web Application.

---

### 16.2. Cấu trúc tổng quát của web.xml

Sơ đồ trên slide liệt kê các element có thể xuất hiện bên trong `<web-app>`:

```text
<web-app>
|-- <description>
|-- <display-name>
|-- <icon>
|-- <distributable>
|-- <context-param>
|-- <filter>
|-- <filter-mapping>
|-- <listener>
|-- <servlet>
|-- <servlet-mapping>
|-- <session-config>
|-- <mime-mapping>
|-- <welcome-file-list>
|-- <error-page>
|-- <jsp-config>
|-- <security-constraint>
|-- <login-config>
`-- <security-role>
```

Trong bài này, phần được minh họa cụ thể nhất là cấu hình Servlet, Servlet Mapping và Welcome File.

---

### 16.3. Các subelement quan trọng của `<servlet>`

Slide minh họa cấu trúc của element `<servlet>` như sau:

```text
<servlet>
|-- <description>             0 hoặc nhiều
|-- <display-name>            0 hoặc nhiều
|-- <icon>                    0 hoặc nhiều
|   |-- <small-icon>          0 hoặc 1
|   `-- <large-icon>          0 hoặc 1
|-- <servlet-name>            bắt buộc
|-- <servlet-class> hoặc <jsp-file>
|                              một trong hai là bắt buộc
|-- <init-param>              0 hoặc nhiều
|   |-- <description>         0 hoặc 1
|   |-- <param-name>          bắt buộc
|   `-- <param-value>         bắt buộc
|-- <load-on-startup>         0 hoặc 1
|-- <run-as>                  0 hoặc 1
|   |-- <description>         0 hoặc nhiều
|   `-- <role-name>           bắt buộc
`-- <security-role-ref>       0 hoặc nhiều
    |-- <description>         0 hoặc nhiều
    |-- <role-name>           bắt buộc
    `-- <role-link>           0 hoặc 1
```

Sơ đồ này cho thấy `<servlet>` không chỉ chứa tên và class của Servlet mà còn có thể chứa các thông tin mô tả, parameter khởi tạo và cấu hình liên quan đến role.

---

### 16.4. Ví dụ web.xml đơn giản

Slide sử dụng ví dụ Deployment Descriptor sau:

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<web-app xmlns="http://java.sun.com/xml/ns/j2ee"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd" version="2.4">

 <display-name>Servlet 2.4 Examples</display-name>

 <description>
 Servlet 2.4 Examples.
 </description>

 <!-- Define servlets that are included in the example application -->
 <servlet>
     <servlet-name>FirstServlet</servlet-name>
     <servlet-class>FirstServlet</servlet-class>
 </servlet>

 <servlet-mapping>
     <servlet-name>FirstServlet</servlet-name>
     <url-pattern>/FirstServlet</url-pattern>
 </servlet-mapping>

</web-app>
```

Phần quan trọng:

```xml
<servlet>
    <servlet-name>FirstServlet</servlet-name>
    <servlet-class>FirstServlet</servlet-class>
</servlet>
```

khai báo Servlet.

Trong khi:

```xml
<servlet-mapping>
    <servlet-name>FirstServlet</servlet-name>
    <url-pattern>/FirstServlet</url-pattern>
</servlet-mapping>
```

ánh xạ URL `/FirstServlet` tới Servlet có tên `FirstServlet`.

Có thể hình dung:

```text
Client Request
/FirstServlet
      |
      v
<servlet-mapping>
      |
      v
FirstServlet
```

---

## 17. Welcome File

`<welcome-file-list>` xác định những file mà Web Application có thể sử dụng làm trang mặc định.

Ví dụ trong slide:

```xml
<welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>mainlibrary/catalog.jsp</welcome-file>
</welcome-file-list>
```

Danh sách này chứa lần lượt:

1. `index.html`
2. `index.jsp`
3. `mainlibrary/catalog.jsp`

---

## 18. Đóng gói Web Application

### 18.1. WAR và JAR

Slide nhấn mạnh:

> A WAR Is Not a JAR

Mặc dù WAR và JAR có thể được tạo theo cách tương tự và có định dạng file nền tảng tương tự nhau, chúng phục vụ mục đích khác nhau.

Quy ước phần mở rộng:

```text
.jar -> Java ARchive
.war -> Web Application ARchive
```

WAR được đóng gói nhằm giúp **Web Container** triển khai Web Application thuận tiện hơn.

---

### 18.2. WAR File trên Tomcat

Slide cho biết nhiều Web Container có cơ chế triển khai tự động.

Đối với Tomcat, có thư mục:

```text
webapps
```

Luồng triển khai được mô tả như sau:

```text
Ứng dụng được đóng gói thành .war
        |
        v
Đặt WAR vào thư mục webapps
        |
        v
Tomcat giải nén nội dung WAR
        |
        v
Tạo thư mục Context Root
        |
        v
Ứng dụng sẵn sàng được truy cập
```

Tên Context Root thường giống tên WAR nhưng bỏ phần mở rộng `.war`.

Ví dụ:

```text
FirstServlet.war
```

sẽ tương ứng với Context Root có tên:

```text
FirstServlet
```

Slide chỉ ra file demo:

```text
Demo\WarFile\FirstServlet.war
```

---

## 19. GET và POST

Slide kết thúc bằng bảng so sánh GET và POST.

### 19.1. So sánh theo nội dung slide

| GET | POST |
|---|---|
| Parameter còn xuất hiện trong Browser History. | Không được lưu như một phần của Browser History. |
| Có thể Bookmark. | Không thể Bookmark theo cách gửi dữ liệu POST. |
| Sử dụng URL Encoding. | Slide nêu Multipart Encoding cho Binary Data. |
| Dễ nhìn thấy các giá trị được gửi vì chúng xuất hiện trên URL. | Dữ liệu không hiển thị trực tiếp trên URL. |
| Slide ghi rằng chỉ sử dụng cho ASCII value. | Có thể sử dụng Binary Content. |
| Slide đánh giá là ít an toàn hơn. | Slide đánh giá là an toàn hơn GET. |
| Slide ghi giới hạn 2048 ký tự. | Slide ghi không có giới hạn tương ứng. |
| Có thể được Cache. | Slide ghi không thể Cache. |

### 19.2. Điểm cần hiểu từ bảng

Thông điệp chính của slide là:

- Với GET, dữ liệu thường được thể hiện trên URL nên người dùng dễ nhìn thấy parameter.
- Với POST, dữ liệu Form không được đặt trực tiếp vào URL như GET.
- GET và POST thường được sử dụng trong các tình huống khác nhau khi gửi Request từ Client đến Server.

> Lưu ý khi sử dụng tài liệu này để giảng dạy: bảng trên được ghi lại theo đúng nội dung slide. Một số câu trong bảng là cách diễn đạt đơn giản hóa của slide, vì vậy nên hiểu chúng trong phạm vi bài nhập môn thay vì xem là các quy tắc tuyệt đối cho mọi HTTP implementation.

---

## 20. Luồng tổng quát của một Java Web Application trong bài

Kết hợp các phần đã xuất hiện trong slide, có thể mô tả luồng cơ bản như sau:

```text
1. Người dùng mở Browser
            |
            v
2. Browser hiển thị HTML / HTML Form
            |
            v
3. Người dùng thực hiện hành động hoặc Submit Form
            |
            v
4. Browser tạo HTTP Request
            |
            v
5. Web Server / Servlet Container nhận Request
            |
            v
6. Request được chuyển tới Servlet phù hợp
            |
            v
7. Servlet đọc Request
   - Parameter
   - Header
   - các dữ liệu cần thiết
            |
            v
8. Servlet thực hiện xử lý
   - có thể làm việc với Database
            |
            v
9. Servlet tạo HTTP Response
            |
            v
10. Browser nhận Response
            |
            v
11. Browser render HTML thành Web Page
```

Đây chính là mối liên hệ giữa các khái niệm HTML, Browser, HTTP, Servlet, Form, Web Application và Deployment được giới thiệu xuyên suốt bài.

---

## Tổng kết

Sau bài học này, sinh viên cần ghi nhớ các nội dung chính sau:

- **HTML** là HyperText Markup Language, dùng các tag để mô tả trang Web.
- **Web Browser** đọc HTML Document và render thành Web Page.
- **Servlet** là chương trình Java chạy trong môi trường Web Server/Servlet Container để nhận Request và tạo Response.
- Giao tiếp Web trong bài chủ yếu dựa trên **HTTP**.
- Một HTTP Request gồm Method, URL, Header và Body.
- Các HTTP Method được giới thiệu gồm `GET`, `HEAD`, `POST`, `PUT`, `DELETE`, `OPTIONS`, `TRACE`.
- HTTP Response gồm Status Code, Header và Body.
- Status Code được chia thành các nhóm `1xx`, `2xx`, `3xx`, `4xx`, `5xx`.
- Servlet viết cho HTTP thường kế thừa `HttpServlet`.
- Vòng đời Servlet gồm ba giai đoạn chính: `init`, `service`, `destroy`.
- `HttpServletRequest` được sử dụng để đọc dữ liệu Request; `HttpServletResponse` được sử dụng để tạo Response.
- Dữ liệu HTML Form có thể được lấy trong Servlet bằng `request.getParameter(...)`.
- Java Web Application có cấu trúc thư mục đặc biệt, trong đó có `/WEB-INF/classes`, `/WEB-INF/lib` và `web.xml`.
- `web.xml` là Deployment Descriptor dùng để khai báo các thành phần triển khai như Servlet và URL Mapping.
- Web Application có thể được đóng gói thành **WAR file** và triển khai vào thư mục `webapps` của Tomcat.
- GET và POST có cách truyền dữ liệu khác nhau; slide nhấn mạnh việc GET đưa parameter lên URL trong khi POST không hiển thị parameter trực tiếp trên URL theo cách đó.
