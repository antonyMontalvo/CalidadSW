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
import unmsm.edu.pe.calidadsw.dao.design.IAssistantDAO;
import unmsm.edu.pe.calidadsw.dao.model.Assistant;
import unmsm.edu.pe.calidadsw.dao.model.Client;

public class AssistantDAO implements IAssistantDAO{// Client_has_Event
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("AssistantDAO");

    public AssistantDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public List<Client> consultaTodosParticipantesEvento(Integer id) {
        // Lista de asistentes a un determinado evento
        List<Client> assistants = new ArrayList<>();
        String sql = "{CALL sp_get_assistants_event(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                while (resultSet.next()) {
                    Client assistant = new Client();

                    assistant.setDni(resultSet.getString("dni"));
                    assistant.setName(resultSet.getString("name"));
                    assistant.setLastname(resultSet.getString("lastname"));
                    assistant.setBirthdate(resultSet.getDate("age"));
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

    @Override
    public boolean inscribirParticipanteEvento(Assistant assistant) {
        Boolean result = true;
        String sql = "{CALL sp_insert_assistant(?,?,?,?,?)}";

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
