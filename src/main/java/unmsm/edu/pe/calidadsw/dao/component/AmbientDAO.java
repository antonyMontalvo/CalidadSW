package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;

public class AmbientDAO {
    private JDBCDataAccessClass _jdbc;
    private Connection _connection;

    public AmbientDAO() {
        _jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Ambient t) {
        Statement statement = null;
        Boolean result = true;
        String query = "insert into ambient ("
                // + "id_trabajador"
                + "idambient" + ",name" + ",type" + ",floor" + ",capacity" + ",description) " + "values ("
                // + trabajador.getIdTrabajador()
                + "'" + t.getIdAmbient() + "'" + ",'" + t.getName() + "'" + ",'" + t.getType() + "'" + ",'"
                + t.getFloor() + "'" + ",'" + t.getCapacity() + "'" + ",'" + t.getDescription() + "')";

        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        
        try {
            _connection = _jdbc.getJdbcConnection();
            statement = _connection.createStatement();

            System.out.println("Ejecutando=" + query);
            statement.execute(query);
        } catch (SQLException e) {
            result = false;
            System.out.println("Error crear la sentencia " + e.getMessage());
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

            String query = "delete from ambient where idambient = " + id;

            System.out.println("Ejecutando=" + query);
            statement.execute(query);
        } catch (SQLException e) {
            result = false;
            System.out.println("Error crear la sentencia " + e.getMessage());
        } finally {
            _jdbc.closeJdbcConnection();
        }

        return result;
    }

    public List<Ambient> read() {
        List<Ambient> consultaAmbientes = new ArrayList<>();
        Statement statement = null;

        try {
            _connection = _jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + "idambient" + ",name" + ",type" + ",floor"
                    + ",capacity" + ",description" + " from ambient");

            while (resultSet.next()) {

                Ambient ambient = new Ambient();
                ambient.setIdAmbient(resultSet.getInt("idambient"));
                ambient.setName(resultSet.getString("name"));
                ambient.setType(resultSet.getString("type"));
                ambient.setFloor(resultSet.getString("floor"));
                ambient.setCapacity(resultSet.getInt("capacity"));
                ambient.setDescription(resultSet.getString("description"));

                consultaAmbientes.add(ambient);
            }
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        } finally {
            _jdbc.closeJdbcConnection();
        }

        return consultaAmbientes;
    }
}
