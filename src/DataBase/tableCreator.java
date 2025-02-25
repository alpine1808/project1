package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class tableCreator {
	public static void createUsersTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS ResidentData (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL UNIQUE,
                apartment_name VARCHAR(20) NOT NULL UNIQUE COMMENT 'Tên căn hộ: ',
                resident_count INT NOT NULL COMMENT 'Nhân khẩu: ',
                apartment_area DECIMAL(10,2) NOT NULL COMMENT 'Diện tích căn hộ (m²)',
                motorbike_count INT NOT NULL DEFAULT 0 COMMENT 'Số lượng xe máy: ',
                car_count INT NOT NULL DEFAULT 0 COMMENT 'Số lượng ô tô: ',
                water_fee DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT 'Phí nước (VNĐ)',
                parking_fee DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT 'Phí gửi xe (VNĐ)',
                electricity_fee DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT 'Tiền điện (VNĐ)'
            );
        """;

        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Bảng 'ResidentData' đã được tạo hoặc đã tồn tại.");

        } catch (SQLException e) {
            System.out.println("Lỗi khi tạo bảng: " + e.getMessage());
        }
    }
}
