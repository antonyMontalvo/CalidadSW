package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

public class ExhibitorDAO {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;

    public ExhibitorDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Exhibitor t) {
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
                    + "'" + t.getDni() + "'" + ",'" + t.getName() + "'" + ",'" + t.getLastname() + "'" + ",'"
                    + t.getNationality() + "'" + ",'" + t.getSpecialty() + "')";
            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia " + e.getMessage());
            return false;
        }
    }

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

}
