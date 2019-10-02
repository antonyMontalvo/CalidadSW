
import java.util.List;
import unmsm.edu.pe.calidadsw.dao.DAOFactory;
import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.design.IAmbientDAO;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class test {
    public static void main(String[] args) {
        
        JDBCDataAccessClass db = new JDBCDataAccessClass();
        db.getJdbcConnection();
        
        IAmbientDAO ambientDAO = DAOFactory.getInstance().getAmbientDAO();
        List<Ambient> list = ambientDAO.read();
        
        for (Ambient a: list) {
            System.out.println(a.getDescription() + " ooo");
        }
        
    }
}
