/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Assistant;
import unmsm.edu.pe.calidadsw.dao.model.Client;
import unmsm.edu.pe.calidadsw.dao.model.Event;

/**
 *
 * @author Usuario
 */
public interface IAssistantDAO {

    /**
     * 
     * @param event
     * @return
     */
    public abstract List<Client> readAssistantsEvent(Event event);

    /**
     * 
     * @param assistant
     * @return
     */
    public abstract boolean registerParticipant(Assistant assistant);
}
