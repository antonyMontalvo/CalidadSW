
import java.util.List;
import unmsm.edu.pe.calidadsw.dao.DAOFactory;
import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.design.IAdministratorDAO;
import unmsm.edu.pe.calidadsw.dao.design.IAmbientDAO;
import unmsm.edu.pe.calidadsw.dao.design.IEventDAO;
import unmsm.edu.pe.calidadsw.dao.model.Administrator;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;
import unmsm.edu.pe.calidadsw.dao.model.Event;

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
        
        IEventDAO eventDAO = DAOFactory.getInstance().getEventDAO();
        List<Event> events = eventDAO.read();
        
        for(Event e: events){
            System.out.println(e.getDescription() + "!!!");
        }
        
        String name = "adminP";
        IAdministratorDAO adminDAO = DAOFactory.getInstance().getAdministratorDAO();
        Administrator admin = adminDAO.readLogin(name);
        
        System.out.println(admin.getName() + " funciono!");
        
        Event e = new Event();
        
        e.setTitle("Numb");
        e.setDescription("ola");
        e.setDate("1997-11-11");
        e.setState("creado");

        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(1);
        e.setAdministrator(administrator);

        int idEvent = eventDAO.createBasic(e);
        
        System.out.println(idEvent + "BUUE");
        
    }
}
