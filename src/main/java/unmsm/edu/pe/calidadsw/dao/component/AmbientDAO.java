package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
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
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";

        try {
            _connection = _jdbc.getJdbcConnection();
            CallableStatement callableStatement = _connection.prepareCall(sql);

            callableStatement.setString(1, t.getName());
            callableStatement.setString(2, t.getType());
            callableStatement.setString(3, t.getFloor());
            callableStatement.setInt(4, t.getCapacity());
            callableStatement.setString(5, t.getDescription());

            ResultSet resulSet = callableStatement.executeQuery();

            if (resulSet.next()) {
                int response = resulSet.getInt("response");

                if (response == 0) {
                    result = false;
                }
            }
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
