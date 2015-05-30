/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MAlbumSongRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MSongRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MAlbumSong;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MGenre;
import agh.musicapplication.mappmodel.MSong;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.hibernate.TransientObjectException;
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
public class MAlbumSongRepositoryTest {
    
    @Inject
    private MAlbumSongRepositoryInterface sut;
    
    @Inject
    private MAlbumRepositoryInterface ari;
    
    @Inject
    private MSongRepositoryInterface sri;
    
    @Inject
    private MBandRepositoryInterface bri;
    
    private MBand band;
    
    private MAlbum album;
    
    private MSong song1,song2;
    
    public MAlbumSongRepositoryTest() {
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
        band.setName("name1");
        band.setDescription("b");
        band.setGenre(MGenre.ROCK);
        bri.insert(band);
        
        album = new MAlbum();
        album.setBand(band);
        album.setName("album1");
        album.setGenre(MGenre.ROCK);
        album.setBand(band);
        ari.insert(album);
        
        song1 = new MSong();
        song1.setName("song1");
        
        song2 = new MSong();
        song2.setName("song2");
        
        List<MSong> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        
        for (MSong song : songs) {
            if (song != null) {
                song.setGenre(MGenre.ROCK);
                sri.insert(song);
            }
        }
        for (MSong song : songs) {
            if (song != null) {
                MAlbumSong mAlbumSong = new MAlbumSong();
                mAlbumSong.setAlbum(album);
                mAlbumSong.setSong(song);
                sut.insert(mAlbumSong);
            }
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void shouldBeNotNullBecauseEntityMAlbumSongExists() {
        assertNotNull(sut.getMAlbumSongWithSomeAlbumNameAndSongName(album, song1));
    }
    
    @Test(expected = TransientObjectException.class)
    public void shouldBeTransientExceptionBecauseEntityMAlbumSongDoesnExist() {
        assertNull(sut.getMAlbumSongWithSomeAlbumNameAndSongName(new MAlbum(), song1));
    }
    
    @Test
    public void shouldBeEqualsBecauseSongEntityIsInDatabase() {
        assertEquals("song1",sut.getMAlbumSongWithSomeAlbumNameAndSongName(album, song1).getSong().getName());
    }
    
   
}
