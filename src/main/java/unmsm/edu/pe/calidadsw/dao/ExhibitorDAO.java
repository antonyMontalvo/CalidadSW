package unmsm.edu.pe.calidadsw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.connection.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.models.Exhibitor;

public class ExhibitorDAO {
    private JDBCDataAccessClass con;
    private Connection _connection;
    
    public ExhibitorDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new JDBCDataAccessClass(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public List<Exhibitor> consultaTodosExpositores() {

        List<Exhibitor> consultaExhibitor = new ArrayList<>();
        Statement statement = null;

        try {
            con.conectar();
            _connection = con.getJdbcConnection();

            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + "dni"
                    + ",name"
                    + ",lastname"
                    + ",nationality"
                    + ",specialty"
                    + " from exhibitor");

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
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return consultaExhibitor;

    }

    //el id de trabajador se genera automaticamente
    public boolean inscribirExpositor(Exhibitor exhibitor) {

        Statement statement = null;

        try {
            con.conectar();
            _connection = con.getJdbcConnection();
            statement = _connection.createStatement();
            //INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`, `apellido_paterno`, 
            //`apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx', 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into exhibitor ("
                    //+ "id_trabajador"
                    + "dni"
                    + ",name"
                    + ",lastname"
                    + ",nationality"
                    + ",specialty) "
                    + "values ("
                    //+ trabajador.getIdTrabajador()
                    + "'" + exhibitor.getDni()+ "'"
                    + ",'" + exhibitor.getName() + "'"
                    + ",'" + exhibitor.getLastname() + "'"
                    + ",'" + exhibitor.getNationality() + "'"
                    + ",'" + exhibitor.getSpecialty() + "')";
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
