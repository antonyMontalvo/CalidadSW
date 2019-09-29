package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.model.Event;

public class EventDAO {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;

    public EventDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Event t) {
        Statement statement = null;

        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            // INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`,
            // `apellido_paterno`,
            // `apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx',
            // 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into event ("
                    // + "id_trabajador"
                    + "title" + ",description" + ",date" + ",state" + ",idambient" + ",dni) " + "values ("
                    // + trabajador.getIdTrabajador()

                    + "'" + t.getTitle() + "'" + ",'" + t.getDescription() + "'" + ",'"
                    + String.valueOf(t.getDate()) + "'" + ",'" + t.getState() + "'" + ",'"
                    + t.getIdambiente() + "'" + ",'" + t.getDni() + "')";
            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
            return false;
        }
    }

    public boolean delete(Integer id) {
        Statement statement = null;

        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();

            String query = "delete from event where idevent = " + id;

            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
            return false;
        }
    }

    public List<Event> read() {
        List<Event> consultaEventos = new ArrayList<>();
        Statement statement = null;

        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + "idevent" + ",title" + ",description" + ",date"
                    + ",state" + ",idambient" + ",dni" + " from event");

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
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return consultaEventos;
    }
}
