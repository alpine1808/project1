package config;

public class TableConfig {
	private static final String create_SQL = """
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
	
	
}
