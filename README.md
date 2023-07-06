# Redis

Link drive: https://docs.google.com/document/d/1pSP7Ld5igxDaYSvLPVsdvCzzB7vwaI9jUPe7N0L7nZI/edit?usp=sharing

Redis là 1 database phụ được cài trực tiếp trên server, để sử dụng redis cần cài và kết nối từ application:

1. Cài redis trên ubuntu: Terminal: sudo apt install redis-server

Kiểm tra đã cài đặt chưa: Terminal: redis-server --version

2. Demo sử dụng redis với springboot web application
Link github: 	https://github.com/thinhotwp1/Redis

Redis có thể lưu dưới dạng key-value, list, hash key, và khi lưu các giá trị này nên chuyển về dạng byte data để khi sử dụng sẽ nhanh hơn

Dưới đây là một ví dụ về byte array và cách nó có thể giúp tăng tốc độ xử lý trong Redis.
Giả sử bạn có một ứng dụng web lưu trữ thông tin người dùng trong Redis. Mỗi người dùng có một key duy nhất được tạo từ tên người dùng và ID của họ. Ví dụ, key có thể được tạo như sau: user:{userID}.
Khi sử dụng chuỗi (string) để lưu trữ key trong Redis, ví dụ user:123, Redis sẽ phải xử lý từng ký tự trong chuỗi khi thực hiện các phép so sánh, tìm kiếm và thao tác khác. Việc xử lý các ký tự Unicode hoặc UTF-8 có thể tốn thời gian và tài nguyên.
Tuy nhiên, nếu bạn sử dụng byte array để lưu trữ key, ví dụ user:123 được chuyển đổi thành một mảng byte như sau: [117, 115, 101, 114, 58, 49, 50, 51]. Khi Redis thực hiện các phép so sánh và tìm kiếm, nó có thể làm việc trực tiếp với các giá trị byte mà không cần xử lý các ký tự Unicode hoặc UTF-8. Việc này giúp tăng tốc độ xử lý.
1 2 3 ứng với 49 50 51 

Branch main sẽ xử lý bình thường, branch byte_array_value sẽ chuyển value thành byte_array để tăng tốc độ redis, khuyến nghị sử dụng 
