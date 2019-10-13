/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.design;

import unmsm.edu.pe.calidadsw.dao.model.Administrator;

/**
 *
 * @author Usuario
 */
public interface IAdministratorDAO {

    /**
     * 
     * @param user
     * @return
     */
    public abstract Administrator readLogin(String user);

}
