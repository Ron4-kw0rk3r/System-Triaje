import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userverifydb {
    private Connection connection;

    public userverifydb(Connection connection) {
        this.connection = connection;
    }

    public boolean verifyCredentials(String usuario, String contrasena) {
        String query = "SELECT COUNT(*) FROM Medico WHERE Nombre = ? AND Especialidad = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
