package unmsm.edu.pe.calidadsw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.connection.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.models.Event;

public class EventDAO {
    private JDBCDataAccessClass con;
    private Connection _connection;
    
    public EventDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new JDBCDataAccessClass(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public List<Event> consultaTodosEventos() {

        List<Event> consultaEventos = new ArrayList<>();
        Statement statement = null;

        try {
            con.conectar();
            _connection = con.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + "idevent"
                    + ",title"
                    + ",description"
                    + ",date"
                    + ",state"
                    + ",idambient"
                    + ",dni"
                    + " from event");

            while (resultSet.next()) {

                Event event = new Event();
                event.setIdevent(resultSet.getInt("idevent"));
                event.setTitle(resultSet.getString("title"));
                event.setDescription(resultSet.getString("description"));
                event.setDate(resultSet.getString("date"));
                event.setState(resultSet.getString("state"));
                event.setIdambiente(resultSet.getInt("idambient"));
                event.setDni(resultSet.getInt("dni"));

                consultaEventos.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return consultaEventos;

    }

    public boolean registrarEvento(Event event) {
        //El idevent esta configurado como autoincrement en la DB 
        Statement statement = null;

        try {
            con.conectar();
            _connection = con.getJdbcConnection();
            statement = _connection.createStatement();
            //INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`, `apellido_paterno`, 
            //`apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx', 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into event ("
                    //+ "id_trabajador"
                    + "title"
                    + ",description"
                    + ",date"
                    + ",state"
                    + ",idambient"
                    + ",dni) "
                    + "values ("
                    //+ trabajador.getIdTrabajador()
                 
                    + "'" + event.getTitle() + "'"
                    + ",'" + event.getDescription() + "'"
                    + ",'" + String.valueOf(event.getDate()) + "'"
                    + ",'" + event.getState() + "'"
                    + ",'" + event.getIdambiente() + "'"
                    + ",'" + event.getDni() + "')";
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

    public boolean eliminarEvento(Integer id) {
        Statement statement = null;

        try {
            con.conectar();
            _connection = con.getJdbcConnection();
            statement = _connection.createStatement();

            String query = "delete from event where idevent = "+id;
                  
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
