package DataBase;

import java.sql.*;

public class DataUpdater {
	public static boolean addResident(String name, String email, String blockName, int residentCount, double area) {
	    String insertQuery = "INSERT INTO ResidentData (name, email, apartment_name, resident_count, apartment_area) VALUES (?, ?, ?, ?, ?)";
	    try (Connection conn = MySQLConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

	        pstmt.setString(1, name);
	        pstmt.setString(2, email);
	        pstmt.setString(3, blockName);
	        pstmt.setInt(4, residentCount);
	        pstmt.setDouble(5, area);
	        
	        int rowsInserted = pstmt.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("✅ Thêm thành công.");
	            return true;
	        } else {
	            System.out.println("❌ Thêm thất bại.");
	        }
	    } catch (SQLIntegrityConstraintViolationException e) {
	        System.out.println("Lỗi: Email hoặc tên căn hộ đã tồn tại.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public static void updateEmailByBlockName(String newEmail, String blockName) {
        String sql = "UPDATE ResidentData SET email = ? WHERE apartment_name = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newEmail);
            pstmt.setString(2, blockName);

            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "🔄 Đã cập nhật " + rows + " dòng." : "Không tìm thấy người dùng.");

        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật: " + e.getMessage());
        }
    }
	
	public static boolean deleteUserByBlockName(String blockName) {
	    String checkSql = "SELECT COUNT(*) FROM ResidentData WHERE apartment_name = ?";
	    String deleteSql = "DELETE FROM ResidentData WHERE apartment_name = ?";

	    try (Connection conn = MySQLConnection.getConnection();
	         PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

	        //Gán giá trị cho dấu ? trong câu lệnh kiểm tra
	        checkStmt.setString(1, blockName);

	        try (ResultSet rs = checkStmt.executeQuery()) {
	            if (rs.next() && rs.getInt(1) > 0) {
	                //Căn hộ tồn tại → tiến hành xóa
	                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
	                    deleteStmt.setString(1, blockName);  //Gán giá trị cho DELETE
	                    int rows = deleteStmt.executeUpdate();
	                    System.out.println("Đã xóa " + rows + " dòng.");
	                    return true;
	                }
	            } else {
	                System.out.println("Không tìm thấy căn hộ: " + blockName);
	                return false;
	            }
	        }

	    } catch (SQLException e) {
	        System.out.println("Lỗi khi xóa: " + e.getMessage());
	        return false;
	    }
	}
}
