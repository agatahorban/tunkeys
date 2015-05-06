/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class MBandRepositoryTest {
    
    @Inject
    private MBandRepositoryInterface sut;
    
    private MBand band;
    
    public MBandRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        band = new MBand();
        band.setName("band");
        band.setDescription("desc");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findBandByName method, of class MBandRepository.
     */
    @Test
    public void shouldFindBandByName() {
       sut.insert(band);
       MBand b = sut.findBandByName("band");
       Assert.assertNotNull(b);
    }
    
}
