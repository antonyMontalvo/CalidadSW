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
import unmsm.edu.pe.calidadsw.dao.model.Client;
import unmsm.edu.pe.calidadsw.dao.model.Event;

public class AssistantDAO implements IAssistantDAO {
    /**
     * Client_has_Event
     */
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger(AssistantDAO.class.getName());

    public AssistantDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public List<Client> readAssistantsEvent(Event event) {
        /**
         * Lista de asistentes a un determinado evento
         */
        List<Client> assistants = new ArrayList<>();
        String sql = "{CALL sp_get_client_event(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, event.getIdEvent());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                while (resultSet.next()) {
                    Client assistant = new Client();

                    assistant.setDni(resultSet.getString("dni"));
                    assistant.setName(resultSet.getString("name"));
                    assistant.setLastname(resultSet.getString("lastname"));
                    assistant.setBirthdate(resultSet.getString("birthdate"));
                    assistant.setTelephone(resultSet.getString("telephone"));
                    assistant.setMail(resultSet.getString("mail"));
                    assistant.setUsername(resultSet.getString("username"));

                    assistants.add(assistant);
                }
                LOGGER.log(Level.INFO, "Event attendees.");

            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return assistants;
    }

}
