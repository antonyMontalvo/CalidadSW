package unmsm.edu.pe.calidadsw.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.IGlobal;
import unmsm.edu.pe.calidadsw.dao.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.models.Event;

public class EventDAO implements IGlobal<List<Event>, Integer> {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;

    public EventDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(List<Event> t) {
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

                    + "'" + t.get(0).getTitle() + "'" + ",'" + t.get(0).getDescription() + "'" + ",'"
                    + String.valueOf(t.get(0).getDate()) + "'" + ",'" + t.get(0).getState() + "'" + ",'"
                    + t.get(0).getIdambiente() + "'" + ",'" + t.get(0).getDni() + "')";
            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
            return false;
        }
    }

    @Override
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

    @Override
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

    @Override
    public List<Event> read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(List<Event> t) {
        // TODO Auto-generated method stub
        return false;
    }

}
