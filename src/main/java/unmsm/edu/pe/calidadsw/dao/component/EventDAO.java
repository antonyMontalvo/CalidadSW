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
    private JDBCDataAccessClass _jdbc;
    private Connection _connection;

    public EventDAO() {
        _jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Event t) {
        Statement statement = null;
        Boolean result = true;

        try {
            _connection = _jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            // INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`,
            // `apellido_paterno`,
            // `apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx',
            // 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into event ("
                    // + "id_trabajador"
                    + "title" + ",description" + ",date" + ",state" + ",idambient" + ",dni) " + "values ("
                    // + trabajador.getIdTrabajador()

                    + "'" + t.getTitle() + "'" + ",'" + t.getDescription() + "'" + ",'" + String.valueOf(t.getDate())
                    + "'" + ",'" + t.getState() + "'" + ",'" + t.getIdAmbient() + "'" + ",'" + t.getDni() + "')";
            System.out.println("Ejecutando=" + query);
            statement.execute(query);

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
            result = false;
        } finally {
            _jdbc.closeJdbcConnection();
        }

        return result;
    }

    public boolean delete(Integer id) {
        Statement statement = null;
        Boolean result = true;

        try {
            _connection = _jdbc.getJdbcConnection();
            statement = _connection.createStatement();

            String query = "delete from event where idevent = " + id;

            System.out.println("Ejecutando=" + query);
            statement.execute(query);

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
            result = false;
        } finally {
            _jdbc.closeJdbcConnection();
        }

        return result;
    }

    public List<Event> read() {
        List<Event> consultaEventos = new ArrayList<>();
        Statement statement = null;

        try {
            _connection = _jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + "idevent" + ",title" + ",description" + ",date"
                    + ",state" + ",idambient" + ",dni" + " from event");

            while (resultSet.next()) {

                Event event = new Event();
                event.setIdEvent(resultSet.getInt("idevent"));
                event.setTitle(resultSet.getString("title"));
                event.setDescription(resultSet.getString("description"));
                event.setDate(resultSet.getString("date"));
                event.setState(resultSet.getString("state"));
                event.setIdAmbient(resultSet.getInt("idambient"));
                event.setDni(resultSet.getInt("dni"));

                consultaEventos.add(event);
            }
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        } finally {
            _jdbc.closeJdbcConnection();
        }

        return consultaEventos;
    }
}
