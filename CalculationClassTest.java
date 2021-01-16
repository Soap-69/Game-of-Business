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
public class CalculationClassTest {
    
    public CalculationClassTest() {
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
     * Test of setAction method, of class CalculationClass.
     */
    @Test
    public void testSetAction() {
        System.out.println("setAction");
        int action = 0;
        CalculationClass instance = new CalculationClass();
        instance.setAction(action);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAction method, of class CalculationClass.
     */
    @Test
    public void testGetAction() {
        System.out.println("getAction");
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.getAction();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Setter method, of class CalculationClass.
     */
    @Test
    public void testSetter() {
        System.out.println("Setter");
        String n = "";
        CalculationClass instance = new CalculationClass();
        instance.Setter(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LAUNCH method, of class CalculationClass.
     */
    @Test
    public void testLAUNCH() {
        System.out.println("LAUNCH");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.LAUNCH(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LaunchBonus method, of class CalculationClass.
     */
    @Test
    public void testLaunchBonus() {
        System.out.println("LaunchBonus");
        String n = "";
        CalculationClass instance = new CalculationClass();
        double expResult = 0.0;
        double result = instance.LaunchBonus(n);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AllTechCostReduction method, of class CalculationClass.
     */
    @Test
    public void testAllTechCostReduction() {
        System.out.println("AllTechCostReduction");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.AllTechCostReduction(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DataCostReduction method, of class CalculationClass.
     */
    @Test
    public void testDataCostReduction() {
        System.out.println("DataCostReduction");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.DataCostReduction(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SpentOnTechnology method, of class CalculationClass.
     */
    @Test
    public void testSpentOnTechnology() {
        System.out.println("SpentOnTechnology");
        String n = "";
        String action = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.SpentOnTechnology(n, action);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SpentOnMarketResearch method, of class CalculationClass.
     */
    @Test
    public void testSpentOnMarketResearch() {
        System.out.println("SpentOnMarketResearch");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.SpentOnMarketResearch(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CashBonusThisRound method, of class CalculationClass.
     */
    @Test
    public void testCashBonusThisRound() {
        System.out.println("CashBonusThisRound");
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.CashBonusThisRound();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of NetCashThisRound method, of class CalculationClass.
     */
    @Test
    public void testNetCashThisRound() {
        System.out.println("NetCashThisRound");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.NetCashThisRound(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PromotionUsersBonusThisRound method, of class CalculationClass.
     */
    @Test
    public void testPromotionUsersBonusThisRound() {
        System.out.println("PromotionUsersBonusThisRound");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.PromotionUsersBonusThisRound(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TechUserBonusThisRound method, of class CalculationClass.
     */
    @Test
    public void testTechUserBonusThisRound() {
        System.out.println("TechUserBonusThisRound");
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.TechUserBonusThisRound();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ComplexityPenalty method, of class CalculationClass.
     */
    @Test
    public void testComplexityPenalty() {
        System.out.println("ComplexityPenalty");
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.ComplexityPenalty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SumAO method, of class CalculationClass.
     */
    @Test
    public void testSumAO() {
        System.out.println("SumAO");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.SumAO(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CashEarnedThisRound method, of class CalculationClass.
     */
    @Test
    public void testCashEarnedThisRound() {
        System.out.println("CashEarnedThisRound");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.CashEarnedThisRound(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetW42 method, of class CalculationClass.
     */
    @Test
    public void testGetW42() {
        System.out.println("GetW42");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.GetW42(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of NewUsersThisRound method, of class CalculationClass.
     */
    @Test
    public void testNewUsersThisRound() {
        System.out.println("NewUsersThisRound");
        String n = "";
        CalculationClass instance = new CalculationClass();
        int expResult = 0;
        int result = instance.NewUsersThisRound(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAbleToPurchase method, of class CalculationClass.
     */
    @Test
    public void testIsAbleToPurchase() {
        System.out.println("isAbleToPurchase");
        String act = "";
        String n = "";
        CalculationClass instance = new CalculationClass();
        boolean expResult = false;
        boolean result = instance.isAbleToPurchase(act, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
