package unmsm.edu.pe.calidadsw.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.IGlobal;
import unmsm.edu.pe.calidadsw.dao.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.models.Ambient;

public class AmbientDAO implements IGlobal<List<Ambient>, Integer> {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;

    public AmbientDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(List<Ambient> t) {
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
                    + "'" + t.get(0).getIdambient() + "'" + ",'" + t.get(0).getName() + "'" + ",'" + t.get(0).getType()
                    + "'" + ",'" + t.get(0).getFloor() + "'" + ",'" + t.get(0).getCapacity() + "'" + ",'"
                    + t.get(0).getDescription() + "')";
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

    @Override
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

    @Override
    public List<Ambient> read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(List<Ambient> t) {
        // TODO Auto-generated method stub
        return false;
    }
}
