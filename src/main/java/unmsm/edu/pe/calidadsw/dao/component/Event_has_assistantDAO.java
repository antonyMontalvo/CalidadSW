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
import unmsm.edu.pe.calidadsw.dao.model.Event_has_assistant;

public class Event_has_assistantDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("Event_has_assistantDAO");

    public Event_has_assistantDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public List<Assistant> consultaTodosParticipantesEvento(Integer id) {
        // Lista de asistentes a un determinado evento
        List<Assistant> assistants = new ArrayList<>();
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // ResultSet resultSet = statement.executeQuery("select " + " a.dni" + ",a.name"
        // + ",a.lastname" + ",a.age"
        // + ",a.telephone" + ",a.mail" + ",a.username" + ",a.password"
        // + " from assistant a inner join event_has_assistant e on a.dni = e.dni where
        // e.idevent = " + id
        // + ";");

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

    public boolean inscribirParticipanteEvento(Event_has_assistant event_has_assistant) {
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // String query = "insert into event_has_assistant ("
        // // + "id_trabajador"
        // + "idevent" + ",dni) " + "values ("
        // // + trabajador.getIdTrabajador()
        // + "'" + event_has_assistant.getIdEvent() + "'" + ",'" +
        // event_has_assistant.getDni() + "')";

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

}
