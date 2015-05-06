/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Agatka
 */
public class GradeCountingServiceTest {
    private GradeCountingService sut;
    
    public GradeCountingServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sut = new GradeCountingService();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of countNewGrade method, of class GradeCountingService.
     */
    @Test
    public void shouldReturnNewGradeEquals5() {
        Map<Integer, Double> map = sut.countNewGrade(2, 5.0,5);
        assertEquals(map.get(3),5.0,0.001);
    }
    
    @Test
    public void shouldReturnNewGradeEquals5BecauseThereWasNoEntries() {
        Map<Integer, Double> map = sut.countNewGrade(0,0,5);
        assertEquals(map.get(1),5.0,0.001);
    }
    
    @Test
    public void shouldReturnNewGradeEquals3AndOneThird() {
        Map<Integer, Double> map = sut.countNewGrade(2, 3.0,4);
        assertEquals(map.get(3),3.3333333,0.001);
    }
}
