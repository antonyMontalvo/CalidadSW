package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.model.Assistant;

public class AssistantDAO {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;

    public AssistantDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Assistant t) {
        Statement statement = null;
        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            // INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`,
            // `apellido_paterno`,
            // `apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx',
            // 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into assistant ("
                    // + "id_trabajador"
                    + "dni" + ",name" + ",lastname" + ",age" + ",telephone" + ",mail " + ",username " + ",password) "
                    + "values ("
                    // + trabajador.getIdTrabajador()
                    + "'" + t.getDni() + "'" + ",'" + t.getName() + "'" + ",'" + t.getLastname() + "'" + ",'"
                    + t.getAge() + "'" + ",'" + t.getTelephone() + "'" + ",'" + t.getMail() + "'" + ",'"
                    + t.getUsername() + "'" + ",'" + t.getPassword() + "')";
            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
            return false;
        }
    }

    public List<Assistant> read() {
        List<Assistant> consultaAssistant = new ArrayList<>();
        Statement statement = null;

        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + "dni" + ",name" + ",lastname" + ",age"
                    + ",telephone" + ",mail" + ",username" + ",password" + " from assistant");

            while (resultSet.next()) {

                Assistant assistant = new Assistant();
                assistant.setDni(resultSet.getInt("dni"));
                assistant.setName(resultSet.getString("name"));
                assistant.setLastname(resultSet.getString("lastname"));
                assistant.setAge(resultSet.getInt("age"));
                assistant.setTelephone(resultSet.getString("telephone"));
                assistant.setMail(resultSet.getString("mail"));
                assistant.setUsername(resultSet.getString("username"));
                assistant.setPassword(resultSet.getString("password"));

                consultaAssistant.add(assistant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return consultaAssistant;
    }
}
