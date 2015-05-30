/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserBand;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Agata
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
@Transactional
public class MUserBandRepositoryTest {
    
    @Inject
    private MUserBandRepositoryInterface sut;
    
    @Inject
    private MUserRepositoryInterface uri;
    
    @Inject
    private MBandRepositoryInterface bri;
    
    private MUser user;
    private MBand band1,band2,band3;
    
    public MUserBandRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new MUser();
        user.setLogin("login1");
        uri.insert(user);
        
        band1 = new MBand();
        band1.setName("b1");
        bri.insert(band1);
        
        band2 = new MBand();
        band2.setName("b1");
        bri.insert(band2);
        
        band3 = new MBand();
        band3.setName("b1");
        bri.insert(band3);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCountOfMUserBand method, of class MUserBandRepository.
     */
    @Test
    public void shouldReturn1BecauseThereWas1Rate() {
       MUserBand userband = new MUserBand();
       userband.setBand(band1);
       userband.setUser(user);
       userband.setGrade(3);
       sut.insert(userband);
       Long l = 1L;
       assertEquals(l,sut.getCountOfMUserBand(user));
    }
    
    @Test
    public void shouldReturn3BecauseThereWas3Rates() {
       MUserBand userband = new MUserBand();
       userband.setBand(band1);
       userband.setUser(user);
       userband.setGrade(3);
       sut.insert(userband);
       
       MUserBand userband2 = new MUserBand();
       userband2.setBand(band2);
       userband2.setUser(user);
       userband2.setGrade(3);
       sut.insert(userband2);
       
       MUserBand userband3 = new MUserBand();
       userband3.setBand(band3);
       userband3.setUser(user);
       userband3.setGrade(3);
       sut.insert(userband3);
       
       
       Long l = 3L;
       assertEquals(l,sut.getCountOfMUserBand(user));
    }
    
     @Test
    public void shouldReturn0BecauseThereWas0Rates() {
       Long l = 0L;
       assertEquals(l,sut.getCountOfMUserBand(user));
    }
    
}
