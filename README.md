# Product Management

Dự án **Product Management** là một hệ thống quản lý sản phẩm giúp bạn dễ dàng thêm, sửa, xoá và xem thông tin các sản phẩm. Dự án được xây dựng chủ yếu bằng Java (Spring Boot) và HTML, sử dụng Thymeleaf để render giao diện động phía server.

## 🛠 Công nghệ sử dụng

- **Java (Spring Boot)**: Xử lý logic nghiệp vụ, controller, service, repository.
- **Thymeleaf**: Template engine để xây dựng giao diện web động.
- **HTML**: Giao diện người dùng.
- (Có thể bổ sung: CSS/Bootstrap, H2/MySQL, ... nếu dự án có sử dụng)

## 🚀 Chức năng chính

- Thêm sản phẩm mới.
- Sửa thông tin sản phẩm.
- Xoá sản phẩm.
- Hiển thị danh sách sản phẩm.
- Tìm kiếm sản phẩm theo tên hoặc mã.

## 📁 Cấu trúc thư mục

```
.
├── src/
│   ├── main/
│   │   ├── java/                   # Mã nguồn Java: Controller, Service, Repository
│   │   └── resources/
│   │        ├── templates/         # File HTML Thymeleaf
│   │        └── application.properties
├── public/                         # (Nếu có) Tài nguyên tĩnh: CSS, JS, ảnh
├── README.md
└── ...
```

## ⚡️ Hướng dẫn cài đặt & chạy dự án

1. **Clone dự án về máy:**
    ```bash
    git clone https://github.com/BaoHuy-Dev/product-management.git
    ```
2. **Mở dự án bằng IDE Java (Eclipse/IntelliJ/VSCode).**
3. **Chạy file main (ví dụ: `ProductManagementApplication.java`).**
4. **Truy cập giao diện tại** [http://localhost:8080](http://localhost:8080) **sau khi chạy thành công.**

## 💡 Đóng góp

Mọi đóng góp cho dự án đều được hoan nghênh. Vui lòng tạo Pull Request hoặc Issue để thảo luận thêm.

## 📄 Giấy phép

Dự án này được phát hành theo giấy phép MIT. Xem thêm tại file [LICENSE](LICENSE).

---

> **Tác giả:** BaoHuy-Dev  
> Nếu bạn có bất kỳ câu hỏi nào, hãy mở Issue trên GitHub repo này.
