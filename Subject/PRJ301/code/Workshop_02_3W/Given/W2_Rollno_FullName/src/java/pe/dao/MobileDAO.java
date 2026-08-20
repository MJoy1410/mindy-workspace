package pe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.dto.MobileDTO;
import pe.utils.DbUtils;

public class MobileDAO {

    public List<MobileDTO> searchByName(String mobileName, String sortDirection)
            throws ClassNotFoundException, SQLException {
        List<MobileDTO> result = new ArrayList<>();

        String direction = "DESC".equalsIgnoreCase(sortDirection) ? "DESC" : "ASC";
        String sql = "SELECT mobileId, description, price, mobileName, "
                + "yearOfProduction, quantity, outOfStock "
                + "FROM dbo.Mobile "
                + "WHERE mobileName LIKE ? "
                + "ORDER BY price " + direction + ", mobileName ASC";

        try (Connection conn = DbUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + mobileName + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(new MobileDTO(
                            rs.getString("mobileId"),
                            rs.getString("description"),
                            getNullableDouble(rs, "price"),
                            rs.getString("mobileName"),
                            getNullableInt(rs, "yearOfProduction"),
                            getNullableInt(rs, "quantity"),
                            rs.getBoolean("outOfStock")
                    ));
                }
            }
        }
        return result;
    }

    private Integer getNullableInt(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return rs.wasNull() ? null : value;
    }

    private Double getNullableDouble(ResultSet rs, String columnName) throws SQLException {
        double value = rs.getDouble(columnName);
        return rs.wasNull() ? null : value;
    }
}
