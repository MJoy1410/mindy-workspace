# AI Prompting Fundamentals

## 1. Tổng quan về Prompt Engineering

**Prompt Engineering** là quá trình thiết kế chỉ dẫn đầu vào để giúp mô hình AI hiểu đúng nhiệm vụ và tạo ra kết quả phù hợp với mục tiêu của người dùng.

Một prompt tốt không nhất thiết phải dài, nhưng cần cung cấp đủ thông tin về:

- Nhiệm vụ AI phải thực hiện.
- Bối cảnh của nhiệm vụ.
- Đối tượng sẽ sử dụng kết quả.
- Các yêu cầu và giới hạn cần tuân thủ.
- Định dạng đầu ra mong muốn.
- Tiêu chí dùng để đánh giá kết quả.

Năm kỹ thuật phổ biến gồm:

1. Zero-Shot Prompting.
2. Few-Shot Prompting.
3. System Prompt hoặc Role Prompt.
4. Chain-of-Thought và lập luận có cấu trúc.
5. Instructional Prompting.

Các kỹ thuật này không hoàn toàn tách biệt. Trong thực tế, một prompt hiệu quả thường kết hợp nhiều kỹ thuật cùng lúc.

---

## 2. Zero-Shot Prompting

### 2.1. Khái niệm

**Zero-Shot Prompting** là cách yêu cầu AI thực hiện nhiệm vụ mà không cung cấp bất kỳ ví dụ mẫu nào. AI phải dựa vào kiến thức và khả năng hiểu ngôn ngữ đã được huấn luyện để tự xác định cách làm.

### 2.2. Ví dụ đơn giản

> Viết một bài thơ 4 câu về mùa xuân.

Trong trường hợp này, AI tự quyết định cấu trúc, hình ảnh, từ ngữ và giọng điệu của bài thơ.

### 2.3. Ví dụ phân loại cảm xúc

> Phân loại phản hồi sau của khách hàng thành một trong ba nhóm: Tích cực, Trung lập hoặc Tiêu cực.  
> Phản hồi: “Sản phẩm khá tốt nhưng thời gian giao hàng quá lâu.”

Kết quả có thể là:

> Trung lập

Đây vẫn là Zero-Shot vì prompt không cung cấp ví dụ phân loại trước đó.

### 2.4. Khi nào nên sử dụng?

Zero-Shot phù hợp khi:

- Nhiệm vụ phổ biến và dễ hiểu.
- Không cần AI bắt chước một phong cách quá cụ thể.
- Muốn thử nhanh khả năng của AI.
- Kết quả không bắt buộc phải tuân theo một mẫu phức tạp.

### 2.5. Ưu điểm

- Ngắn gọn và nhanh chóng.
- Không mất thời gian chuẩn bị ví dụ.
- Phù hợp với các yêu cầu đơn giản.

### 2.6. Hạn chế

- AI có thể hiểu khác ý người dùng.
- Định dạng đầu ra có thể không ổn định.
- Khó kiểm soát văn phong hoặc tiêu chuẩn phân loại.

### 2.7. Cách cải thiện

Prompt chưa rõ ràng:

> Viết một bài giới thiệu sản phẩm.

Prompt tốt hơn:

> Viết một đoạn giới thiệu khoảng 120 từ cho bình giữ nhiệt dành cho nhân viên văn phòng. Nhấn mạnh khả năng giữ nóng 8 giờ, thiết kế tối giản và dễ vệ sinh. Sử dụng giọng văn thân thiện, hiện đại.

Prompt thứ hai vẫn là Zero-Shot vì không có ví dụ mẫu, nhưng nó đồng thời áp dụng Instructional Prompting để giảm sự mơ hồ.

---

## 3. Few-Shot Prompting

### 3.1. Khái niệm

**Few-Shot Prompting** là kỹ thuật cung cấp một hoặc vài ví dụ trước khi yêu cầu AI xử lý trường hợp mới. Các ví dụ giúp AI nhận ra quy luật, cách phân loại, định dạng hoặc văn phong mong muốn.

- **One-Shot:** Cung cấp một ví dụ.
- **Few-Shot:** Thường cung cấp từ hai ví dụ trở lên.

### 3.2. Ví dụ phân loại cảm xúc

> Hãy phân loại phản hồi thành: Tích cực, Trung lập hoặc Tiêu cực.  
>  
> Ví dụ 1:  
> Phản hồi: “Nhân viên hỗ trợ rất nhiệt tình.”  
> Kết quả: Tích cực  
>  
> Ví dụ 2:  
> Phản hồi: “Sản phẩm dùng được, không có gì nổi bật.”  
> Kết quả: Trung lập  
>  
> Ví dụ 3:  
> Phản hồi: “Ứng dụng liên tục bị lỗi và không thể đăng nhập.”  
> Kết quả: Tiêu cực  
>  
> Bây giờ hãy phân loại:  
> Phản hồi: “Chất lượng tốt nhưng giao hàng chậm.”  
> Kết quả:

AI có khả năng trả lời:

> Trung lập

### 3.3. Ví dụ bắt chước văn phong

> Hãy viết tiêu đề quảng cáo theo phong cách ngắn gọn, có nhịp điệu.  
>  
> Ví dụ:  
> Sản phẩm: Cà phê hòa tan  
> Tiêu đề: “Tỉnh táo tức thì, sẵn sàng bứt phá.”  
>  
> Sản phẩm: Giày chạy bộ  
> Tiêu đề: “Nhẹ từng bước, mạnh từng kilomet.”  
>  
> Sản phẩm cần viết: Bình giữ nhiệt  
> Tiêu đề:

Kết quả có thể là:

> “Nóng lâu hơn, năng lượng dài hơn.”

### 3.4. Ví dụ về nhãn có ý nghĩa riêng

Giả sử doanh nghiệp quy định:

- `P1`: Cần xử lý trong 15 phút.
- `P2`: Cần xử lý trong 4 giờ.
- `P3`: Có thể xử lý trong 24 giờ.

Nếu chỉ yêu cầu AI phân loại thành `P1`, `P2` hoặc `P3`, AI khó biết chính xác tiêu chuẩn nội bộ. Có thể sử dụng Few-Shot như sau:

> Ví dụ 1:  
> Yêu cầu: “Toàn bộ hệ thống thanh toán đang ngừng hoạt động.”  
> Mức độ: P1  
>  
> Ví dụ 2:  
> Yêu cầu: “Một khách hàng không nhận được email xác nhận.”  
> Mức độ: P2  
>  
> Ví dụ 3:  
> Yêu cầu: “Cần sửa màu của một biểu tượng trong trang quản trị.”  
> Mức độ: P3  
>  
> Yêu cầu mới: “Tất cả người dùng đều không thể đăng nhập.”  
> Mức độ:

Kết quả hợp lý là `P1`.

### 3.5. Khi nào nên sử dụng?

Few-Shot đặc biệt hữu ích khi:

- Cần kết quả theo đúng một định dạng.
- Muốn AI bắt chước văn phong thương hiệu.
- Các nhãn phân loại có ý nghĩa riêng.
- Nhiệm vụ có quy tắc khó diễn đạt hoàn toàn bằng lời.
- Kết quả Zero-Shot chưa ổn định.

### 3.6. Lưu ý quan trọng

Ví dụ mẫu cần:

- Chính xác và nhất quán.
- Đại diện cho nhiều trường hợp khác nhau.
- Có cùng định dạng với kết quả mong muốn.
- Không mâu thuẫn với phần hướng dẫn.

AI có thể học cả lỗi có trong ví dụ. Nếu các ví dụ thiếu nhất quán, kết quả thường cũng sẽ thiếu nhất quán.

---

## 4. System Prompt và Role Prompt

### 4.1. Khái niệm

**System Prompt** là phần hướng dẫn ở cấp cao, dùng để xác định vai trò, mục tiêu, nguyên tắc và giới hạn hành vi của AI trong suốt cuộc hội thoại.

Trong một số giao diện, người dùng thông thường không trực tiếp thiết lập được System Prompt. Khi đó, người dùng vẫn có thể đặt vai trò trong lời nhắn của mình, nhưng về kỹ thuật đó là một **Role Prompt**, không nhất thiết là System Prompt thực sự.

### 4.2. Ví dụ System Prompt cho trợ lý Marketing

> Bạn là chuyên gia Content Marketing có 10 năm kinh nghiệm trong ngành thương mại điện tử.  
>  
> Nhiệm vụ của bạn là phân tích nội dung quảng cáo và đề xuất cách cải thiện tỷ lệ chuyển đổi. Luôn:  
>  
> - Xác định khách hàng mục tiêu.  
> - Đánh giá tiêu đề, lợi ích và lời kêu gọi hành động.  
> - Trình bày nhận xét thẳng thắn nhưng mang tính xây dựng.  
> - Không tự tạo ra số liệu hoặc dẫn chứng không được cung cấp.  
> - Trả lời bằng tiếng Việt.

Sau đó, người dùng có thể gửi:

> Hãy đánh giá nội dung quảng cáo sau:  
> “Mua khóa học của chúng tôi ngay hôm nay để trở nên thành công.”

AI sẽ đánh giá nội dung theo vai trò và các nguyên tắc đã được thiết lập.

### 4.3. So sánh hai cách viết

Prompt chung chung:

> Hãy đánh giá quảng cáo này.

Prompt có định hình vai trò:

> Đóng vai chuyên gia quảng cáo Facebook trong lĩnh vực giáo dục trực tuyến. Hãy đánh giá quảng cáo này theo ba tiêu chí: mức độ thu hút, tính cụ thể của lợi ích và sức mạnh của lời kêu gọi hành động.

Cách thứ hai giúp AI biết cần nhìn vấn đề từ góc độ nào và phải sử dụng tiêu chí gì.

### 4.4. Khi nào nên sử dụng?

System Prompt phù hợp khi:

- Xây dựng chatbot hoặc trợ lý chuyên biệt.
- Muốn duy trì hành vi nhất quán qua nhiều lượt trò chuyện.
- Cần quy định giọng điệu và nguyên tắc an toàn.
- Cần xác định AI được làm gì và không được làm gì.
- Có nhiều loại yêu cầu nhưng cùng phục vụ một mục tiêu chung.

### 4.5. Hạn chế của việc “đóng vai”

Chỉ thêm câu “Bạn là chuyên gia” không tự động làm câu trả lời chính xác hơn. Một vai trò tốt cần đi kèm:

- Phạm vi chuyên môn.
- Mục tiêu cụ thể.
- Tiêu chí đánh giá.
- Dữ liệu được phép sử dụng.
- Cách xử lý khi thiếu thông tin.
- Định dạng đầu ra.

Ví dụ yếu:

> Bạn là chuyên gia tài chính. Hãy phân tích công ty này.

Ví dụ tốt hơn:

> Bạn là chuyên viên phân tích tài chính doanh nghiệp. Dựa duy nhất trên báo cáo được cung cấp, hãy đánh giá tăng trưởng doanh thu, biên lợi nhuận, dòng tiền và mức nợ. Nếu thiếu dữ liệu, ghi rõ “Chưa đủ dữ liệu”; không tự ước tính.

---

## 5. Chain-of-Thought và lập luận có cấu trúc

### 5.1. Khái niệm

**Chain-of-Thought** thường được hiểu là kỹ thuật khuyến khích AI thực hiện các bước suy luận trung gian trước khi đưa ra đáp án. Nó có thể hữu ích với các nhiệm vụ nhiều bước như toán học, logic, lập kế hoạch hoặc phân tích nguyên nhân.

Tuy nhiên, trong thực tế không nên phụ thuộc vào yêu cầu AI tiết lộ toàn bộ suy nghĩ nội bộ. Cách tốt hơn là yêu cầu:

- Lời giải có thể kiểm chứng.
- Các giả định quan trọng.
- Công thức và phép tính trung gian.
- Giải thích ngắn gọn cho kết luận.
- Bước tự kiểm tra kết quả.

Mục tiêu là nhận được lý do hữu ích để kiểm tra đáp án, không phải toàn bộ suy nghĩ nội bộ của mô hình.

### 5.2. Ví dụ chưa tối ưu

> Hãy suy nghĩ từng bước và cho tôi biết toàn bộ quá trình suy nghĩ của bạn.

### 5.3. Ví dụ tốt hơn

> Giải bài toán sau. Trình bày các công thức, phép tính trung gian và kiểm tra lại kết quả trước khi đưa ra đáp án cuối cùng.

### 5.4. Ví dụ toán học

> Một cửa hàng giảm giá sản phẩm 20%, sau đó giảm thêm 10% trên giá đã giảm. Giá ban đầu là 1.000.000 đồng.  
>  
> Hãy:  
> 1. Tính giá sau lần giảm thứ nhất.  
> 2. Tính số tiền giảm ở lần thứ hai.  
> 3. Tính giá cuối cùng.  
> 4. Cho biết tổng tỷ lệ giảm thực tế.  
> 5. Trình bày phép tính ngắn gọn.

Kết quả:

> Giá sau lần giảm thứ nhất:  
> `1.000.000 × 80% = 800.000 đồng`  
>  
> Lần giảm thứ hai:  
> `800.000 × 10% = 80.000 đồng`  
>  
> Giá cuối cùng:  
> `800.000 − 80.000 = 720.000 đồng`  
>  
> Tổng tỷ lệ giảm thực tế:  
> `(1.000.000 − 720.000) / 1.000.000 = 28%`  
>  
> Đáp án: 720.000 đồng, tương đương giảm tổng cộng 28%.

Hai lần giảm 20% và 10% không tạo thành mức giảm 30%, vì lần giảm thứ hai được tính trên mức giá đã giảm.

### 5.5. Ví dụ phân tích kinh doanh

> Doanh thu website giảm 25% trong tháng này. Hãy phân tích theo cấu trúc:  
>  
> 1. Liệt kê tối đa 5 giả thuyết.  
> 2. Với mỗi giả thuyết, nêu dữ liệu cần kiểm tra.  
> 3. Xếp hạng giả thuyết theo mức độ ưu tiên.  
> 4. Đề xuất kế hoạch kiểm tra trong 48 giờ.  
> 5. Phân biệt rõ dữ kiện, giả định và kết luận.

Đây là cách yêu cầu lập luận có cấu trúc và có thể kiểm chứng.

### 5.6. Khi nào nên sử dụng?

- Bài toán có nhiều bước.
- Phân tích nguyên nhân.
- Lập kế hoạch hoặc ra quyết định.
- Cần kiểm tra công thức và phép tính.
- Muốn giảm nguy cơ AI nhảy ngay đến kết luận.

### 5.7. Lưu ý

Giải thích dài không đồng nghĩa với giải thích đúng. Nên yêu cầu AI:

- Nêu rõ giả định.
- Kiểm tra lại kết quả.
- Chỉ ra dữ liệu còn thiếu.
- Phân biệt dữ kiện và suy đoán.
- Sử dụng nguồn đáng tin cậy khi cần thông tin cập nhật.

---

## 6. Instructional Prompting

### 6.1. Khái niệm

**Instructional Prompting** tập trung vào việc mô tả chính xác AI phải làm gì, làm như thế nào và trả kết quả theo định dạng nào.

Một Instructional Prompt tốt thường trả lời sáu câu hỏi:

1. Nhiệm vụ là gì?
2. Dữ liệu đầu vào là gì?
3. Đối tượng đọc là ai?
4. Có những ràng buộc nào?
5. Đầu ra phải có định dạng gì?
6. Tiêu chí thành công là gì?

### 6.2. So sánh prompt mơ hồ và prompt rõ ràng

Prompt chưa rõ ràng:

> Viết bài về trí tuệ nhân tạo.

Prompt này không quy định độc giả, mục tiêu, độ dài hoặc giọng văn.

Prompt Instructional rõ ràng:

> Viết một bài giải thích về trí tuệ nhân tạo dành cho học sinh lớp 9.  
>  
> Yêu cầu:  
>  
> - Độ dài từ 500 đến 600 từ.  
> - Giọng văn thân thiện, dễ hiểu.  
> - Không sử dụng công thức toán học.  
> - Giải thích ba khái niệm: AI, Machine Learning và Generative AI.  
> - Đưa ra hai ví dụ gần gũi trong đời sống.  
> - Nêu một lợi ích và một rủi ro.  
> - Kết thúc bằng ba câu hỏi thảo luận.  
> - Sử dụng tiêu đề và các đề mục ngắn.

Prompt này làm giảm đáng kể sự mơ hồ và giúp kết quả ổn định hơn.

### 6.3. Ví dụ yêu cầu đầu ra JSON

> Trích xuất thông tin từ nội dung bên dưới và trả về JSON hợp lệ theo cấu trúc:
>
> ```json
> {
>   "customer_name": "string hoặc null",
>   "product": "string hoặc null",
>   "quantity": "number hoặc null",
>   "delivery_date": "YYYY-MM-DD hoặc null"
> }
> ```
>
> Quy tắc:  
>  
> - Không thêm trường mới.  
> - Không suy đoán dữ liệu còn thiếu.  
> - Không viết nội dung ngoài JSON.  
>  
> Nội dung:  
> “Chị Lan muốn đặt 3 máy lọc không khí, giao vào ngày 20/08/2026.”

Dạng prompt này đặc biệt hữu ích khi tích hợp AI vào phần mềm hoặc quy trình tự động hóa.

---

## 7. Bảng so sánh các kỹ thuật

| Kỹ thuật | Mục đích chính | Có ví dụ mẫu? | Điểm mạnh |
|---|---|---:|---|
| Zero-Shot | Yêu cầu AI làm ngay | Không | Nhanh và đơn giản |
| Few-Shot | Dạy AI bằng ví dụ | Có | Ổn định định dạng và văn phong |
| System Prompt | Định hình hành vi tổng thể | Không bắt buộc | Nhất quán qua nhiều lượt |
| Chain-of-Thought | Hỗ trợ nhiệm vụ nhiều bước | Không bắt buộc | Tăng khả năng kiểm tra lập luận |
| Instructional | Quy định chính xác cách thực hiện | Không bắt buộc | Giảm mơ hồ, dễ kiểm soát đầu ra |

---

## 8. Ví dụ kết hợp nhiều kỹ thuật

Giả sử cần yêu cầu AI viết nội dung quảng cáo Facebook:

> **Vai trò:**  
> Bạn là chuyên gia viết quảng cáo cho các thương hiệu mỹ phẩm tại Việt Nam. Bạn ưu tiên nội dung trung thực, không đưa ra tuyên bố y tế chưa được chứng minh.  
>  
> **Nhiệm vụ:**  
> Viết ba phiên bản quảng cáo Facebook cho serum dưỡng ẩm dành cho phụ nữ từ 25–35 tuổi.  
>  
> **Thông tin sản phẩm:**  
>  
> - Thành phần chính: Hyaluronic Acid.  
> - Công dụng được phép đề cập: hỗ trợ cấp ẩm và làm da mềm mại.  
> - Giá: 390.000 đồng.  
> - Ưu đãi: miễn phí vận chuyển trong tuần này.  
>  
> **Ví dụ văn phong:**  
> “Một bước dưỡng đơn giản, một ngày dài vẫn rạng rỡ. Khám phá làn da mềm mại với công thức cấp ẩm nhẹ nhàng.”  
>  
> **Yêu cầu:**  
>  
> - Mỗi phiên bản từ 80–100 từ.  
> - Giọng văn tinh tế, gần gũi.  
> - Có tiêu đề, nội dung chính và lời kêu gọi hành động.  
> - Không sử dụng các từ “điều trị”, “chữa khỏi” hoặc “hiệu quả 100%”.  
> - Mỗi phiên bản sử dụng một góc tiếp cận khác nhau.  
>  
> **Trước khi trả lời:**  
> Xác định ngắn gọn ba góc tiếp cận sẽ sử dụng. Sau đó viết quảng cáo và cuối cùng kiểm tra từng phiên bản theo các ràng buộc trên.

Các kỹ thuật được sử dụng trong prompt trên:

- **System/Role:** “Bạn là chuyên gia viết quảng cáo...”
- **Few-Shot:** Cung cấp ví dụ văn phong.
- **Instructional:** Quy định độ dài, cấu trúc và từ ngữ bị cấm.
- **Lập luận có cấu trúc:** Yêu cầu xác định góc tiếp cận và tự kiểm tra.
- Prompt này không còn là Zero-Shot thuần túy vì đã cung cấp ví dụ.

---

## 9. Công thức prompt thực dụng

Có thể sử dụng mẫu sau cho hầu hết công việc:

> **Vai trò:** Bạn là [vai trò hoặc chuyên môn].  
>  
> **Mục tiêu:** Hãy [nhiệm vụ cần thực hiện].  
>  
> **Bối cảnh:** [Thông tin cần thiết để hiểu vấn đề].  
>  
> **Dữ liệu đầu vào:** [Nội dung cần xử lý].  
>  
> **Đối tượng:** Kết quả dành cho [người đọc hoặc người dùng].  
>  
> **Yêu cầu:**  
>  
> - [Độ dài].  
> - [Giọng văn].  
> - [Nội dung bắt buộc].  
> - [Nội dung không được làm].  
> - [Tiêu chí đánh giá].  
>  
> **Ví dụ:** [Một hoặc vài ví dụ nếu cần].  
>  
> **Định dạng đầu ra:** [Bảng, JSON, danh sách, bài viết...].  
>  
> **Kiểm tra:** Nêu các giả định quan trọng, kiểm tra kết quả theo yêu cầu và ghi rõ nếu thiếu dữ liệu.

---

## 10. Checklist trước khi gửi prompt

Trước khi gửi một prompt quan trọng, hãy kiểm tra:

- [ ] Nhiệm vụ đã được mô tả rõ ràng chưa?
- [ ] AI đã có đủ bối cảnh chưa?
- [ ] Đối tượng đọc kết quả là ai?
- [ ] Có cần cung cấp ví dụ mẫu không?
- [ ] Định dạng đầu ra đã được quy định chưa?
- [ ] Độ dài và giọng văn đã được xác định chưa?
- [ ] Có nội dung nào AI không được làm hoặc không được suy đoán không?
- [ ] Có yêu cầu nêu giả định hoặc kiểm tra kết quả không?
- [ ] Các ví dụ có chính xác và nhất quán không?
- [ ] Nếu thông tin có thể thay đổi, AI có được yêu cầu kiểm tra nguồn cập nhật không?

## 11. Kết luận

Không có một kỹ thuật prompting duy nhất phù hợp với mọi nhiệm vụ:

- Dùng **Zero-Shot** khi nhiệm vụ đơn giản và phổ biến.
- Dùng **Few-Shot** khi cần AI bắt chước ví dụ hoặc tuân theo quy luật riêng.
- Dùng **System Prompt/Role Prompt** khi cần xác định vai trò và duy trì hành vi nhất quán.
- Dùng **lập luận có cấu trúc** khi nhiệm vụ gồm nhiều bước và cần kiểm chứng kết quả.
- Dùng **Instructional Prompting** để quy định rõ nhiệm vụ, giới hạn và định dạng đầu ra.

Nguyên tắc quan trọng nhất: prompt hiệu quả không nhất thiết phải dài, nhưng phải chứa đúng thông tin giúp AI hiểu **nhiệm vụ, bối cảnh, giới hạn và hình dạng của kết quả mong muốn**.
