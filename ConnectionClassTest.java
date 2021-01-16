/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.util.Pair;
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
public class ConnectionClassTest {
    
    public ConnectionClassTest() {
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
     * Test of ConnectToDB method, of class ConnectionClass.
     */
    @Test
    public void testConnectToDB() {
        System.out.println("ConnectToDB");
        ConnectionClass instance = new ConnectionClass();
        instance.ConnectToDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IsConnected method, of class ConnectionClass.
     */
    @Test
    public void testIsConnected() {
        System.out.println("IsConnected");
        ConnectionClass instance = new ConnectionClass();
        boolean expResult = false;
        boolean result = instance.IsConnected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processSQLSelect method, of class ConnectionClass.
     */
    @Test
    public void testProcessSQLSelect() {
        System.out.println("processSQLSelect");
        String sqlCommand = "";
        ConnectionClass instance = new ConnectionClass();
        instance.processSQLSelect(sqlCommand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processInsertInto method, of class ConnectionClass.
     */
    @Test
    public void testProcessInsertInto() {
        System.out.println("processInsertInto");
        String sqlCommand = "";
        ConnectionClass instance = new ConnectionClass();
        instance.processInsertInto(sqlCommand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processUpdate method, of class ConnectionClass.
     */
    @Test
    public void testProcessUpdate() {
        System.out.println("processUpdate");
        String sqlCommand = "";
        ConnectionClass instance = new ConnectionClass();
        instance.processUpdate(sqlCommand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckingCardOwned method, of class ConnectionClass.
     */
    @Test
    public void testCheckingCardOwned() {
        System.out.println("CheckingCardOwned");
        String sqlCommand = "";
        String s = "";
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        int expResult = 0;
        int result = instance.CheckingCardOwned(sqlCommand, s, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of StoreNumbersOfCards method, of class ConnectionClass.
     */
    @Test
    public void testStoreNumbersOfCards() {
        System.out.println("StoreNumbersOfCards");
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        int[] expResult = null;
        int[] result = instance.StoreNumbersOfCards(n);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class ConnectionClass.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        ConnectionClass instance = new ConnectionClass();
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUserExsit method, of class ConnectionClass.
     */
    @Test
    public void testIsUserExsit() {
        System.out.println("isUserExsit");
        String sqlCommand = "";
        ConnectionClass instance = new ConnectionClass();
        boolean expResult = false;
        boolean result = instance.isUserExsit(sqlCommand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRound method, of class ConnectionClass.
     */
    @Test
    public void testSelectRound() {
        System.out.println("selectRound");
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        int expResult = 0;
        int result = instance.selectRound(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updataRound method, of class ConnectionClass.
     */
    @Test
    public void testUpdataRound() {
        System.out.println("updataRound");
        String n = "";
        int round = 0;
        ConnectionClass instance = new ConnectionClass();
        instance.updataRound(n, round);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLaunch method, of class ConnectionClass.
     */
    @Test
    public void testSetLaunch() {
        System.out.println("setLaunch");
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        instance.setLaunch(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoneyAndUsers method, of class ConnectionClass.
     */
    @Test
    public void testGetMoneyAndUsers() {
        System.out.println("getMoneyAndUsers");
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        Pair<Integer, Integer> expResult = null;
        Pair<Integer, Integer> result = instance.getMoneyAndUsers(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updataMoneyAndUser method, of class ConnectionClass.
     */
    @Test
    public void testUpdataMoneyAndUser() {
        System.out.println("updataMoneyAndUser");
        Pair<Integer, Integer> CandU = null;
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        instance.updataMoneyAndUser(CandU, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUsers method, of class ConnectionClass.
     */
    @Test
    public void testUpdateUsers() {
        System.out.println("updateUsers");
        int number = 0;
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        instance.updateUsers(number, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLaunchConditions method, of class ConnectionClass.
     */
    @Test
    public void testCheckLaunchConditions() {
        System.out.println("checkLaunchConditions");
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        int[] expResult = null;
        int[] result = instance.checkLaunchConditions(n);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLaunchNumber method, of class ConnectionClass.
     */
    @Test
    public void testReturnLaunchNumber() {
        System.out.println("returnLaunchNumber");
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        int expResult = 0;
        int result = instance.returnLaunchNumber(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createColumnAndSetToNumber method, of class ConnectionClass.
     */
    @Test
    public void testCreateColumnAndSetToNumber() {
        System.out.println("createColumnAndSetToNumber");
        String nameOfColumn = "";
        int defaultNumber = 0;
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        instance.createColumnAndSetToNumber(nameOfColumn, defaultNumber, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateGoViral method, of class ConnectionClass.
     */
    @Test
    public void testUpdateGoViral() {
        System.out.println("updateGoViral");
        int number = 0;
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        instance.updateGoViral(number, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePromotionBouns method, of class ConnectionClass.
     */
    @Test
    public void testUpdatePromotionBouns() {
        System.out.println("updatePromotionBouns");
        int sum = 0;
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        instance.updatePromotionBouns(sum, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLaunchBonus method, of class ConnectionClass.
     */
    @Test
    public void testUpdateLaunchBonus() {
        System.out.println("updateLaunchBonus");
        int num = 0;
        String n = "";
        ConnectionClass instance = new ConnectionClass();
        instance.updateLaunchBonus(num, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnBonus method, of class ConnectionClass.
     */
    @Test
    public void testReturnBonus() {
        System.out.println("returnBonus");
        String n = "";
        String column = "";
        ConnectionClass instance = new ConnectionClass();
        int expResult = 0;
        int result = instance.returnBonus(n, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
