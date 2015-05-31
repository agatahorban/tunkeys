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
import java.util.List;
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

    private MBand band, band2;
    private MAlbum album, album2, album3, album4;

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

        band2 = new MBand();
        band2.setName("band2");
        mrr.insert(band2);

        MBand b = mrr.findBandByName("band");
        MBand b2 = mrr.findBandByName("band2");

        album = new MAlbum();
        album.setBand(b);
        album.setName("album");
        sut.insert(album);

        album2 = new MAlbum();
        album2.setBand(b);
        album2.setName("dalbum");
        sut.insert(album2);

        album3 = new MAlbum();
        album3.setBand(b);
        album3.setName("calbum");
        sut.insert(album3);

        album4 = new MAlbum();
        album4.setBand(b2);
        album4.setName("balbum");
        sut.insert(album4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldFindAlbumByName() {
        MAlbum a = sut.findAlbumByName("album");
        Assert.assertNotNull(a);
    }

    @Test
    public void shouldReturn3BandsSortedAphabetically() {
        List<MAlbum> list = sut.getAlbumsOfSomeBandSortedAlphabetically(band);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals("album", list.get(0).getName());
        Assert.assertEquals("calbum", list.get(1).getName());
        Assert.assertEquals("dalbum", list.get(2).getName());
    }

    @Test
    public void shouldReturn1Band() {
        List<MAlbum> list = sut.getAlbumsOfSomeBandSortedAlphabetically(band2);
        Assert.assertEquals(1, list.size());
    }
}
