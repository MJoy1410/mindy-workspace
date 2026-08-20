package pe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.dto.UserDTO;
import pe.utils.DbUtils;

public class UserDAO {

    private static final String LOGIN_SQL
            = "SELECT [user], fullName, [role], inUse "
            + "FROM dbo.[User] WHERE [user] = ? AND [password] = ?";

    public UserDTO checkLogin(String username, String password)
            throws ClassNotFoundException, SQLException {
        try (Connection conn = DbUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(LOGIN_SQL)) {
            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new UserDTO(
                            rs.getString("user"),
                            rs.getString("fullName"),
                            getNullableInt(rs, "role"),
                            rs.getBoolean("inUse")
                    );
                }
            }
        }
        return null;
    }

    private Integer getNullableInt(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return rs.wasNull() ? null : value;
    }
}
