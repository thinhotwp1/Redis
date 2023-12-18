# Redis
Redis là 1 database phụ được cài trực tiếp trên server, dữ liệu được lưu ở RAM, để sử dụng redis cần cài và kết nối từ application:

1. Cài redis trên ubuntu: 
Terminal: sudo apt install redis-server

Kiểm tra đã cài đặt chưa: 
Terminal: redis-server --version

Ở đây chỉ thực hiện lưu data với redis ở ứng dụng Back-end, không truy cập trực tiếp vào Redis để xem dữ liệu, vì key được lưu dưới dạng byte nên có vào cũng không xem được dữ liệu.
