/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
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
public class MAlbumRepositoryTest {
    
    @Inject
    private MAlbumRepositoryInterface sut;
    
    @Inject
    private MBandRepositoryInterface mrr;
    
    private MBand band;
    private MAlbum album;
    
    public MAlbumRepositoryTest() {
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
        mrr.insert(band);
        MBand b = mrr.findBandByName("band");
        album = new MAlbum();
        album.setBand(b);
        album.setName("album");
        sut.insert(album);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAlbumByName method, of class MAlbumRepository.
     */
    @Test
    public void shouldFindAlbumByName() {
       MAlbum a = sut.findAlbumByName("album");
       Assert.assertNotNull(a);
    }
    
}
