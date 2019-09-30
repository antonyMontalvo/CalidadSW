package unmsm.edu.pe.calidadsw.dao;

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

/**
 * DAOFactory
 */
public class DAOFactory {

    private static DAOFactory daoFac;

    static {
        daoFac = new DAOFactory();
    }

    public static DAOFactory getInstance() {
        return daoFac;
    }

    public IAmbientDAO getAmbientDAO() {
        return new AmbientDAO();
    }

    public IAssistantDAO getAssistantDAO() {
        return new AssistantDAO();
    }

    public IClientDAO getClientDAO() {
        return new ClientDAO();
    }

    public IEventDAO getEventDAO() {
        return new EventDAO();
    }

    public IExhibitorDAO getExhibitorDAO() {
        return new ExhibitorDAO();
    }

    public IPresentationDAO getPresentationDAO() {
        return new PresentationDAO();
    }
}