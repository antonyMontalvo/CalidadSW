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
    private JDBCDataAccessClass jdbc;
    private Connection _connection;

    public AmbientDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Ambient t) {
        Statement statement = null;
        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            // INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`,
            // `apellido_paterno`,
            // `apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx',
            // 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into ambient ("
                    // + "id_trabajador"
                    + "idambient" + ",name" + ",type" + ",floor" + ",capacity" + ",description) " + "values ("
                    // + trabajador.getIdTrabajador()
                    + "'" + t.getIdambient() + "'" + ",'" + t.getName() + "'" + ",'" + t.getType()
                    + "'" + ",'" + t.getFloor() + "'" + ",'" + t.getCapacity() + "'" + ",'"
                    + t.getDescription() + "')";
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

            String query = "delete from ambient where idambient = " + id;

            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
            return false;
        }
    }

    public List<Ambient> read() {
        List<Ambient> consultaAmbientes = new ArrayList<>();
        Statement statement = null;
        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + "idambient" + ",name" + ",type" + ",floor"
                    + ",capacity" + ",description" + " from ambient");

            while (resultSet.next()) {

                Ambient ambient = new Ambient();
                ambient.setIdambient(resultSet.getInt("idambient"));
                ambient.setName(resultSet.getString("name"));
                ambient.setType(resultSet.getString("type"));
                ambient.setFloor(resultSet.getString("floor"));
                ambient.setCapacity(resultSet.getInt("capacity"));
                ambient.setDescription(resultSet.getString("description"));

                consultaAmbientes.add(ambient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return consultaAmbientes;
    }
}
