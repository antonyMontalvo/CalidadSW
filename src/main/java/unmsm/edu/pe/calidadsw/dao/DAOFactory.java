package unmsm.edu.pe.calidadsw.dao;

import unmsm.edu.pe.calidadsw.dao.component.AdministratorDAO;
import unmsm.edu.pe.calidadsw.dao.design.IAmbientDAO;
import unmsm.edu.pe.calidadsw.dao.design.IAssistantDAO;
import unmsm.edu.pe.calidadsw.dao.design.IClientDAO;
import unmsm.edu.pe.calidadsw.dao.design.IEventDAO;
import unmsm.edu.pe.calidadsw.dao.design.IExhibitorDAO;
import unmsm.edu.pe.calidadsw.dao.design.IPresentationDAO;
import unmsm.edu.pe.calidadsw.dao.component.AmbientDAO;
import unmsm.edu.pe.calidadsw.dao.component.AssistantDAO;
import unmsm.edu.pe.calidadsw.dao.component.ClientDAO;
import unmsm.edu.pe.calidadsw.dao.component.EventDAO;
import unmsm.edu.pe.calidadsw.dao.component.ExhibitorDAO;
import unmsm.edu.pe.calidadsw.dao.component.PresentationDAO;
import unmsm.edu.pe.calidadsw.dao.design.IAdministratorDAO;

/**
 * DAOFactory
 */
public class DAOFactory {

    private static DAOFactory daoFac;

    static {
        daoFac = new DAOFactory();
    }

    /**
     * 
     * @return
     */
    public static DAOFactory getInstance() {
        return daoFac;
    }

    /**
     * 
     * @return
     */
    public IAmbientDAO getAmbientDAO() {
        return new AmbientDAO();
    }

    /**
     * 
     * @return
     */
    public IAssistantDAO getAssistantDAO() {
        return new AssistantDAO();
    }

    /**
     * 
     * @return
     */
    public IClientDAO getClientDAO() {
        return new ClientDAO();
    }

    /**
     * 
     * @return
     */
    public IEventDAO getEventDAO() {
        return new EventDAO();
    }

    /**
     * 
     * @return
     */
    public IExhibitorDAO getExhibitorDAO() {
        return new ExhibitorDAO();
    }

    /**
     * 
     * @return
     */
    public IPresentationDAO getPresentationDAO() {
        return new PresentationDAO();
    }

    /**
     * 
     * @return
     */
    public IAdministratorDAO getAdministratorDAO() {
        return new AdministratorDAO();
    }
}