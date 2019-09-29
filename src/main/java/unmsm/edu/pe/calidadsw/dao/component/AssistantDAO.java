package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.model.Assistant;

public class AssistantDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("AssistantDAO");

    public AssistantDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Assistant t) {
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // String query = "insert into assistant ("
        // // + "id_trabajador"
        // + "dni" + ",name" + ",lastname" + ",age" + ",telephone" + ",mail " +
        // ",username " + ",password) "
        // + "values ("
        // // + trabajador.getIdTrabajador()
        // + "'" + t.getDni() + "'" + ",'" + t.getName() + "'" + ",'" + t.getLastname()
        // + "'" + ",'"
        // + t.getAge() + "'" + ",'" + t.getTelephone() + "'" + ",'" + t.getMail() + "'"
        // + ",'"
        // + t.getUsername() + "'" + ",'" + t.getPassword() + "')";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure create.");
                    }
                }
            }
        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return result;
    }

    public List<Assistant> read() {
        List<Assistant> assistants = new ArrayList<>();
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // ResultSet resultSet = statement.executeQuery("select " + "dni" + ",name" +
        // ",lastname" + ",age"
        // + ",telephone" + ",mail" + ",username" + ",password" + " from assistant");

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            try (ResultSet resultSet = callableStatement.executeQuery();) {

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

                    assistants.add(assistant);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return assistants;
    }
}
