/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.interfaces.RatingServiceInterface;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Agatka
 */
@RunWith(MockitoJUnitRunner.class)
public class RatingServiceTest {
    
    @InjectMocks
    private RatingServiceInterface sut = new RatingService();
    
    @Mock
    private MUserBandRepositoryInterface ubri;
    @Mock
    MBandRepositoryInterface bri;
    
    public RatingServiceTest() {
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
     * Test of rateBand method, of class RatingService.
     */
    @Test
    public void shouldReturnTrueBecauseNoNull() {
        System.out.println("rateBand");
        MUser user = new MUser();
        MBand band = new MBand();
        ((RatingService) sut).setGcs(new GradeCountingService());
        int grade = 3;
        assertTrue(sut.rateBand(user, band, grade));

    }
    
    @Test
    public void shouldReturnFalseBecauseBandIsNull(){
        System.out.println("rateBand");
        MUser user = new MUser();
        MBand band = null;
        ((RatingService) sut).setGcs(new GradeCountingService());
        int grade = 3;
        assertFalse(sut.rateBand(user, band, grade));

    }
    
}
