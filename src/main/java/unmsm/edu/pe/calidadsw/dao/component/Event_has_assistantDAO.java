package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.model.Assistant;
import unmsm.edu.pe.calidadsw.dao.model.Event_has_assistant;

public class Event_has_assistantDAO {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;
    
    public Event_has_assistantDAO() {
        jdbc = new JDBCDataAccessClass();
    }
    
    public List<Assistant> consultaTodosParticipantesEvento(Integer id) {
        //Lista de asistentes a un determinado evento
        List<Assistant> consultaAsistentes = new ArrayList<>();

        Statement statement = null;
        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + " a.dni"
                    + ",a.name"
                    + ",a.lastname"
                    + ",a.age"
                    + ",a.telephone"
                    + ",a.mail"
                    + ",a.username"
                    + ",a.password"
                    + " from assistant a inner join event_has_assistant e on a.dni = e.dni where e.idevent = "+id+";");

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

                consultaAsistentes.add(assistant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return consultaAsistentes;

    }
    
    public boolean inscribirParticipanteEvento(Event_has_assistant event_has_assistant) {

        Statement statement = null;
        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            //INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`, `apellido_paterno`, 
            //`apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx', 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into event_has_assistant ("
                    //+ "id_trabajador"
                    + "idevent"
                    + ",dni) "
                    + "values ("
                    //+ trabajador.getIdTrabajador()
                    + "'" + event_has_assistant.getIdevent()+ "'"
                    + ",'" + event_has_assistant.getDni() + "')";
            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
            return false;
        }

    }

}
