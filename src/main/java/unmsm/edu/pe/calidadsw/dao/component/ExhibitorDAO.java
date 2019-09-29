package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

public class ExhibitorDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("ExhibitorDAO");

    public ExhibitorDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Exhibitor t) {
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";

        // String query = "insert into exhibitor ("
        // // + "id_trabajador"
        // + "dni" + ",name" + ",lastname" + ",nationality" + ",specialty) " + "values
        // ("
        // // + trabajador.getIdTrabajador()
        // + "'" + t.getDni() + "'" + ",'" + t.getName() + "'" + ",'" + t.getLastname()
        // + "'" + ",'"
        // + t.getNationality() + "'" + ",'" + t.getSpecialty() + "')";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure create.");
                    }
                }
            }
        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return result;
    }

    public List<Exhibitor> read() {
        List<Exhibitor> exhibitors = new ArrayList<>();
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // ResultSet resultSet = statement.executeQuery(
        // "select " + "dni" + ",name" + ",lastname" + ",nationality" + ",specialty" + "
        // from exhibitor");

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                while (resultSet.next()) {
                    Exhibitor exhibitor = new Exhibitor();

                    exhibitor.setDni(resultSet.getInt("dni"));
                    exhibitor.setName(resultSet.getString("name"));
                    exhibitor.setLastname(resultSet.getString("lastname"));
                    exhibitor.setNationality(resultSet.getString("nacionality"));
                    exhibitor.setSpecialty(resultSet.getString("specialty"));

                    exhibitors.add(exhibitor);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return exhibitors;
    }

}
