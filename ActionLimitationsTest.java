/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ming
 */
public class ActionLimitationsTest {
    
    public ActionLimitationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of processRequest method, of class ActionLimitations.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ActionLimitations instance = new ActionLimitations();
        instance.processRequest(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doGet method, of class ActionLimitations.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ActionLimitations instance = new ActionLimitations();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class ActionLimitations.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ActionLimitations instance = new ActionLimitations();
        instance.doPost(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServletInfo method, of class ActionLimitations.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        ActionLimitations instance = new ActionLimitations();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endRoundUpdate method, of class ActionLimitations.
     */
    @Test
    public void testEndRoundUpdate() throws Exception {
        System.out.println("endRoundUpdate");
        HttpServletResponse response = null;
        HttpServletRequest request = null;
        String report = "";
        ActionLimitations instance = new ActionLimitations();
        instance.endRoundUpdate(response, request, report);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkToLaunch method, of class ActionLimitations.
     */
    @Test
    public void testCheckToLaunch() throws Exception {
        System.out.println("checkToLaunch");
        HttpServletResponse response = null;
        HttpServletRequest request = null;
        ActionLimitations instance = new ActionLimitations();
        instance.checkToLaunch(response, request);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMR method, of class ActionLimitations.
     */
    @Test
    public void testDisplayMR() throws Exception {
        System.out.println("displayMR");
        HttpServletResponse response = null;
        ActionLimitations instance = new ActionLimitations();
        instance.displayMR(response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DisplayPromotion method, of class ActionLimitations.
     */
    @Test
    public void testDisplayPromotion() throws Exception {
        System.out.println("DisplayPromotion");
        HttpServletResponse response = null;
        HttpServletRequest request = null;
        ActionLimitations instance = new ActionLimitations();
        instance.DisplayPromotion(response, request);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTDAction method, of class ActionLimitations.
     */
    @Test
    public void testDisplayTDAction() throws Exception {
        System.out.println("displayTDAction");
        HttpServletResponse response = null;
        ActionLimitations instance = new ActionLimitations();
        instance.displayTDAction(response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
