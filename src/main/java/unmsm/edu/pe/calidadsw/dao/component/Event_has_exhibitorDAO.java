package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.model.Event_has_exhibitor;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

public class Event_has_exhibitorDAO {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;
    
    public Event_has_exhibitorDAO() {
        jdbc = new JDBCDataAccessClass();
    }
    
    public List<Exhibitor> consultaTodosExpositoresEvento(Integer id) {
        //Lista de asistentes a un determinado evento
        List<Exhibitor> consultaExpositores = new ArrayList<>();

        Statement statement = null;
        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + " a.dni"
                    + ",a.name"
                    + ",a.lastname"
                    + ",a.nationality"
                    + ",a.specialty"
                    + " from exhibitor a inner join event_has_assistant e on a.dni = e.dni where e.idevent = "+id+";");

            while (resultSet.next()) {

                Exhibitor exhibitor = new Exhibitor();
                exhibitor.setDni(resultSet.getInt("dni"));
                exhibitor.setName(resultSet.getString("name"));
                exhibitor.setLastname(resultSet.getString("lastname"));
                exhibitor.setNationality(resultSet.getString("nationality"));
                exhibitor.setSpecialty(resultSet.getString("specialty"));

                consultaExpositores.add(exhibitor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return consultaExpositores;

    }
    
    public boolean inscribirExpositorEvento(Event_has_exhibitor event_has_exhibitor) {

        Statement statement = null;
        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();

            statement = _connection.createStatement();
            //INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`, `apellido_paterno`, 
            //`apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx', 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into event_has_exhibitor ("
                    //+ "id_trabajador"
                    + "idevent"
                    + ",dni) "
                    + "values ("
                    //+ trabajador.getIdTrabajador()
                    + "'" + event_has_exhibitor.getIdevent()+ "'"
                    + ",'" + event_has_exhibitor.getDni() + "')";
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
