/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class RegisterInfomationSheetTest {
    
    public RegisterInfomationSheetTest() {
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
     * Test of setUsername method, of class RegisterInfomationSheet.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String u = "";
        RegisterInfomationSheet instance = new RegisterInfomationSheet();
        instance.setUsername(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class RegisterInfomationSheet.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        RegisterInfomationSheet instance = new RegisterInfomationSheet();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class RegisterInfomationSheet.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String p = "";
        RegisterInfomationSheet instance = new RegisterInfomationSheet();
        instance.setPassword(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class RegisterInfomationSheet.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        RegisterInfomationSheet instance = new RegisterInfomationSheet();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
