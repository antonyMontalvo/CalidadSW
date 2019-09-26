package unmsm.edu.pe.calidadsw.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.IGlobal;
import unmsm.edu.pe.calidadsw.dao.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.models.Assistant;

public class AssistantDAO implements IGlobal<List<Assistant>, Integer> {
    private JDBCDataAccessClass jdbc;
    private Connection _connection;

    public AssistantDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(List<Assistant> t) {
        Statement statement = null;
        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            // INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`,
            // `apellido_paterno`,
            // `apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx',
            // 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into assistant ("
                    // + "id_trabajador"
                    + "dni" + ",name" + ",lastname" + ",age" + ",telephone" + ",mail " + ",username " + ",password) "
                    + "values ("
                    // + trabajador.getIdTrabajador()
                    + "'" + t.get(0).getDni() + "'" + ",'" + t.get(0).getName() + "'" + ",'" + t.get(0).getLastname()
                    + "'" + ",'" + t.get(0).getAge() + "'" + ",'" + t.get(0).getTelephone() + "'" + ",'"
                    + t.get(0).getMail() + "'" + ",'" + t.get(0).getUsername() + "'" + ",'" + t.get(0).getPassword()
                    + "')";
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
    public List<Assistant> read() {
        List<Assistant> consultaAssistant = new ArrayList<>();
        Statement statement = null;

        try {
            jdbc.conectar();
            _connection = jdbc.getJdbcConnection();
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + "dni" + ",name" + ",lastname" + ",age"
                    + ",telephone" + ",mail" + ",username" + ",password" + " from assistant");

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
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return consultaAssistant;
    }

    @Override
    public List<Assistant> read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(List<Assistant> t) {
        // TODO Auto-generated method stub
        return false;
    }

}
