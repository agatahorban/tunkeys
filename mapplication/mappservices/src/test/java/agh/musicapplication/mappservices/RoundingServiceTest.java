package agh.musicapplication.mappservices;

import agh.musicapplication.mappservices.interfaces.RoundingServiceInterface;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Agata
 */

public class RoundingServiceTest {
   
    @Inject
    private RoundingServiceInterface sut;
    
    public RoundingServiceTest() {
       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         sut = new RoundingService();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void shouldReturn2Comma22WhenRounding() {
       assertEquals(2.22,sut.round(2.22222, 2),0.001);
    }
    
    
    @Test
    public void shouldReturn2Comma23WhenRounding() {
       assertEquals(2.23,sut.round(2.22555, 2),0.001);
    }
    
    @Test
    public void shouldReturn1Comma34WhenRounding() {
       assertEquals(1.33,sut.round(1.333333333333, 2),0.001);
    }
}
