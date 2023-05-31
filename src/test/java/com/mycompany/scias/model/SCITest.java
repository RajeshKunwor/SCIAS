/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.scias.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;


/**
 *
 * @author rajesh
 */
//this is test class for SCI class
public class SCITest {
    static SCI instance;
    public SCITest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
        instance = new SCI();
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
     * Test of getId method, of class SCI.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 1;
        instance.setId(1);
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    

   
    /**
     * Test of getE method, of class SCI.
     */
    @Test
    public void testGetE() {
        System.out.println("getE");
        instance.setE(0);
        float expResult = 0.0F;
        float result = instance.getE();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    /**
     * Test of getI method, of class SCI.
     */
    @Test
    public void testGetI() {
        System.out.println("getI");
        instance.setI(0);
        float expResult = 0.0F;
        float result = instance.getI();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
    /**
     * Test of getM method, of class SCI.
     */
    @Test
    public void testGetM() {
        System.out.println("getM");
        instance.setM(0);
        float expResult = 0.0F;
        float result = instance.getM();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    

   

  
     /**
     * Test of getR method, of class SCI.
     */
    @Test
    public void testGetR() {
        System.out.println("getR");
        instance.setR("perdevice");
        String expResult = "perdevice";
        String result = instance.getR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    

    
    
    
}
