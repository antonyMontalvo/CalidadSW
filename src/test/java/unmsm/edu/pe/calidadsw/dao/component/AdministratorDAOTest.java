/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unmsm.edu.pe.calidadsw.dao.DAOFactory;
import unmsm.edu.pe.calidadsw.dao.design.IAdministratorDAO;
import unmsm.edu.pe.calidadsw.dao.model.Administrator;

/**
 *
 * @author Antony
 */
public class AdministratorDAOTest {

    static IAdministratorDAO ambientDAO = DAOFactory.getInstance().getAdministratorDAO();

    public AdministratorDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of readLogin method, of class AdministratorDAO.
     */
    @Test
    public void testReadLogin() {
        System.out.println("readLogin");

        String user = "adminP";
        Administrator result = ambientDAO.readLogin(user);

        assertEquals(result, result);
    }

}
