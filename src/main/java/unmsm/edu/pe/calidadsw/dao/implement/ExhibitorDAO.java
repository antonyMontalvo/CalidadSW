package unmsm.edu.pe.calidadsw.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.IGlobal;
import unmsm.edu.pe.calidadsw.dao.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.models.Exhibitor;

public class ExhibitorDAO implements IGlobal<List<Exhibitor>, Integer> {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;

    public ExhibitorDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(List<Exhibitor> t) {
        Statement statement = null;

        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            // INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`,
            // `apellido_paterno`,
            // `apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx',
            // 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into exhibitor ("
                    // + "id_trabajador"
                    + "dni" + ",name" + ",lastname" + ",nationality" + ",specialty) " + "values ("
                    // + trabajador.getIdTrabajador()
                    + "'" + t.get(0).getDni() + "'" + ",'" + t.get(0).getName() + "'" + ",'" + t.get(0).getLastname()
                    + "'" + ",'" + t.get(0).getNationality() + "'" + ",'" + t.get(0).getSpecialty() + "')";
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Exhibitor> read() {
        List<Exhibitor> consultaExhibitor = new ArrayList<>();
        Statement statement = null;

        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();

            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select " + "dni" + ",name" + ",lastname" + ",nationality" + ",specialty" + " from exhibitor");

            while (resultSet.next()) {

                Exhibitor exhibitor = new Exhibitor();
                exhibitor.setDni(resultSet.getInt("dni"));
                exhibitor.setName(resultSet.getString("name"));
                exhibitor.setLastname(resultSet.getString("lastname"));
                exhibitor.setNationality(resultSet.getString("nacionality"));
                exhibitor.setSpecialty(resultSet.getString("specialty"));

                consultaExhibitor.add(exhibitor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return consultaExhibitor;
    }

    @Override
    public List<Exhibitor> read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(List<Exhibitor> t) {
        // TODO Auto-generated method stub
        return false;
    }

}
