import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class newuserdb {
    private Connection connection;

    public newuserdb(Connection connection) {
        this.connection = connection;
    }

    public void insertMedico(String nombre, String especialidad, String password) {
        String query = "INSERT INTO Medico (Nombre, Especialidad, password) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, especialidad);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
}
