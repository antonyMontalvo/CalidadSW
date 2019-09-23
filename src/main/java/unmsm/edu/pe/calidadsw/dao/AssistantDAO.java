package unmsm.edu.pe.calidadsw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.connection.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.models.Assistant;

public class AssistantDAO {
    private JDBCDataAccessClass con;
    private Connection _connection;
    
    public AssistantDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new JDBCDataAccessClass(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Assistant> consultaTodosAsistentes() {

        List<Assistant> consultaAssistant = new ArrayList<>();
        Statement statement = null;

        try {
            con.conectar();
            _connection = con.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + "dni"
                    + ",name"
                    + ",lastname"
                    + ",age"
                    + ",telephone"
                    + ",mail"
                    + ",username"
                    + ",password"
                    + " from assistant");

            while (resultSet.next()) {

                Assistant assistant = new Assistant();
                assistant.setDni(resultSet.getInt("dni"));
                assistant.setName(resultSet.getString("name"));
                assistant.setLastname(resultSet.getString("lastname"));
                assistant.setAge(resultSet.getInt("age"));
                assistant.setTelephone(resultSet.getString("telephone"));
                assistant.setMail(resultSet.getString("mail"));
                assistant.setUsername(resultSet.getString("username"));
                assistant.setPassword(resultSet.getString("password"));
              
                consultaAssistant.add(assistant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return consultaAssistant;

    }

    //el id de trabajador se genera automaticamente
    public boolean registrarAsistente(Assistant assistant) {

        Statement statement = null;
        try {
            con.conectar();
            _connection = con.getJdbcConnection();
            statement = _connection.createStatement();
            //INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`, `apellido_paterno`, 
            //`apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx', 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into assistant ("
                    //+ "id_trabajador"
                    + "dni"
                    + ",name"
                    + ",lastname"
                    + ",age"
                    + ",telephone"
                    + ",mail "
                    + ",username "
                    + ",password) "
                    + "values ("
                    //+ trabajador.getIdTrabajador()
                    + "'" + assistant.getDni()+ "'"
                    + ",'" + assistant.getName() + "'"
                    + ",'" + assistant.getLastname() + "'"
                    + ",'" + assistant.getAge() + "'"
                    + ",'" + assistant.getTelephone() + "'"
                    + ",'" + assistant.getMail() + "'"
                    + ",'" + assistant.getUsername() + "'"
                    + ",'" + assistant.getPassword() + "')";
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
