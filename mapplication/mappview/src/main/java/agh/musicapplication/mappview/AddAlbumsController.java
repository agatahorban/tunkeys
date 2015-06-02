/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MAlbumSongRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MSongRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MAlbumSong;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MGenre;
import agh.musicapplication.mappmodel.MSong;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agata
 */
@Named("addalbums")
@Scope("request")
@Transactional
public class AddAlbumsController {

    private MBand currentBand;
    private MAlbum album;
    private int amountOfAlbums;
    private List<MSong> songs;
    private String selectedGenre;
    private Part f1;

    private String bandname;

    private MSong song01;
    private MSong song02;
    private MSong song03;
    private MSong song04;
    private MSong song05;
    private MSong song06;
    private MSong song07;
    private MSong song08;
    private MSong song09;
    private MSong song10;
    private MSong song11;
    private MSong song12;
    private MSong song13;
    private MSong song14;
    private MSong song15;
    private MSong song16;
    private MSong song17;
    private MSong song18;
    private MSong song19;
    private MSong song20;

    @Inject
    MBandRepositoryInterface bri;

    @Inject
    MAlbumRepositoryInterface ari;

    @Inject
    MSongRepositoryInterface sri;

    @Inject
    MAlbumSongRepositoryInterface asri;

    public AddAlbumsController() {
    }

    @PostConstruct
    public void init() {
        String bandName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("bandname");
        currentBand = bri.findBandByName(bandName);
        if (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("howmany") != null) {
            amountOfAlbums = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("howmany"));
        } else {
            amountOfAlbums = 0;
            album = new MAlbum();
            songs = new ArrayList<>();
            selectedGenre = "";

            album = new MAlbum();
            songs = new ArrayList<>();
            selectedGenre = "";

            song01 = new MSong();
            song02 = new MSong();
            song03 = new MSong();
            song04 = new MSong();
            song05 = new MSong();
            song06 = new MSong();
            song07 = new MSong();
            song08 = new MSong();
            song09 = new MSong();
            song10 = new MSong();
            song11 = new MSong();
            song12 = new MSong();
            song13 = new MSong();
            song14 = new MSong();
            song15 = new MSong();
            song16 = new MSong();
            song17 = new MSong();
            song18 = new MSong();
            song19 = new MSong();
            song20 = new MSong();

            songs.add(song01);
            songs.add(song02);
            songs.add(song03);
            songs.add(song04);
            songs.add(song05);
            songs.add(song06);
            songs.add(song07);
            songs.add(song08);
            songs.add(song09);
            songs.add(song10);
            songs.add(song11);
            songs.add(song12);
            songs.add(song13);
            songs.add(song14);
            songs.add(song15);
            songs.add(song16);
            songs.add(song17);
            songs.add(song18);
            songs.add(song19);
            songs.add(song20);

        }
    }

    public String addAlbums(Long bnd, int amount) {
        Logger.getAnonymousLogger().log(Level.WARNING, "Wszedlem do add albums!!!!!!!!!!!!!");
        currentBand = bri.find(bnd);
        Logger.getAnonymousLogger().log(Level.WARNING, "Album name" + currentBand.getName());
        Logger.getAnonymousLogger().log(Level.WARNING, currentBand.getName());
        album.setBand(currentBand);
        album.setGenre(getGenre(selectedGenre));
        try {
            String filepath = "C:\\Users\\horbana\\Desktop\\apkaMuzyczna\\tunkeys\\mapplication\\mappview\\src\\main\\webapp\\resources\\img\\" + getFilename(f1);
            f1.write(filepath);
            album.setCover("img/" + getFilename(f1));
        } catch (IOException ex) {
            Logger.getLogger(DemoBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ari.insert(album);
        }
        for (MSong song : songs) {
            if (!song.getName().equals("")) {
                song.setGenre(getGenre(selectedGenre));
                sri.insert(song);
            }
        }
        for (MSong song : songs) {
            if (!song.getName().equals("")) {
                MAlbumSong mAlbumSong = new MAlbumSong();
                mAlbumSong.setAlbum(album);
                mAlbumSong.setSong(song);
                asri.insert(mAlbumSong);
            }
        }

        return "bands";
    }
    
     public String addNext(Long bnd, int amount) {
        Logger.getAnonymousLogger().log(Level.WARNING, "Wszedlem do add albums!!!!!!!!!!!!!");
        currentBand = bri.find(bnd);
        Logger.getAnonymousLogger().log(Level.WARNING, "Album name" + currentBand.getName());
        Logger.getAnonymousLogger().log(Level.WARNING, currentBand.getName());
        album.setBand(currentBand);
        album.setGenre(getGenre(selectedGenre));
        try {
            String filepath = "C:\\Users\\horbana\\Desktop\\apkaMuzyczna\\tunkeys\\mapplication\\mappview\\src\\main\\webapp\\resources\\img\\" + getFilename(f1);
            f1.write(filepath);
            album.setCover("img/" + getFilename(f1));
        } catch (IOException ex) {
            Logger.getLogger(DemoBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ari.insert(album);
        }
        for (MSong song : songs) {
            if (!song.getName().equals("")) {
                song.setGenre(getGenre(selectedGenre));
                sri.insert(song);
            }
        }
        for (MSong song : songs) {
            if (!song.getName().equals("")) {
                MAlbumSong mAlbumSong = new MAlbumSong();
                mAlbumSong.setAlbum(album);
                mAlbumSong.setSong(song);
                asri.insert(mAlbumSong);
            }
        }

        return "addalbums";
    }

    public MGenre getGenre(String g) {
        switch (g) {
            case "Classic":
                return MGenre.CLASSIC;
            case "Country":
                return MGenre.COUNTRY;
            case "Hip-hop":
                return MGenre.HIPHOP;
            case "Metal":
                return MGenre.METAL;
            case "Pop":
                return MGenre.POP;
            case "Rock":
                return MGenre.ROCK;
        }
        return null;
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }

    public Part getF1() {
        return f1;
    }

    public void setF1(Part f1) {
        this.f1 = f1;
    }

    public MBand getCurrentBand() {
        return currentBand;
    }

    public void setCurrentBand(MBand currentBand) {
        this.currentBand = currentBand;
    }

    public MAlbum getAlbum() {
        return album;
    }

    public void setAlbum(MAlbum album) {
        this.album = album;
    }

    public int getAmountOfAlbums() {
        return amountOfAlbums;
    }

    public void setAmountOfAlbums(int amountOfAlbums) {
        this.amountOfAlbums = amountOfAlbums;
    }

    public List<MSong> getSongs() {
        return songs;
    }

    public void setSongs(List<MSong> songs) {
        this.songs = songs;
    }

    public String getSelectedGenre() {
        return selectedGenre;
    }

    public void setSelectedGenre(String selectedGenre) {
        this.selectedGenre = selectedGenre;
    }

    public MSong getSong01() {
        return song01;
    }

    public void setSong01(MSong song01) {
        this.song01 = song01;
    }

    public MSong getSong02() {
        return song02;
    }

    public void setSong02(MSong song02) {
        this.song02 = song02;
    }

    public MSong getSong03() {
        return song03;
    }

    public void setSong03(MSong song03) {
        this.song03 = song03;
    }

    public MSong getSong04() {
        return song04;
    }

    public void setSong04(MSong song04) {
        this.song04 = song04;
    }

    public MSong getSong05() {
        return song05;
    }

    public void setSong05(MSong song05) {
        this.song05 = song05;
    }

    public MSong getSong06() {
        return song06;
    }

    public void setSong06(MSong song06) {
        this.song06 = song06;
    }

    public MSong getSong07() {
        return song07;
    }

    public void setSong07(MSong song07) {
        this.song07 = song07;
    }

    public MSong getSong08() {
        return song08;
    }

    public void setSong08(MSong song08) {
        this.song08 = song08;
    }

    public MSong getSong09() {
        return song09;
    }

    public void setSong09(MSong song09) {
        this.song09 = song09;
    }

    public MSong getSong10() {
        return song10;
    }

    public void setSong10(MSong song10) {
        this.song10 = song10;
    }

    public MSong getSong11() {
        return song11;
    }

    public void setSong11(MSong song11) {
        this.song11 = song11;
    }

    public MSong getSong12() {
        return song12;
    }

    public void setSong12(MSong song12) {
        this.song12 = song12;
    }

    public MSong getSong13() {
        return song13;
    }

    public void setSong13(MSong song13) {
        this.song13 = song13;
    }

    public MSong getSong14() {
        return song14;
    }

    public void setSong14(MSong song14) {
        this.song14 = song14;
    }

    public MSong getSong15() {
        return song15;
    }

    public void setSong15(MSong song15) {
        this.song15 = song15;
    }

    public MSong getSong16() {
        return song16;
    }

    public void setSong16(MSong song16) {
        this.song16 = song16;
    }

    public MSong getSong17() {
        return song17;
    }

    public void setSong17(MSong song17) {
        this.song17 = song17;
    }

    public MSong getSong18() {
        return song18;
    }

    public void setSong18(MSong song18) {
        this.song18 = song18;
    }

    public MSong getSong19() {
        return song19;
    }

    public void setSong19(MSong song19) {
        this.song19 = song19;
    }

    public MSong getSong20() {
        return song20;
    }

    public void setSong20(MSong song20) {
        this.song20 = song20;
    }

    public MBandRepositoryInterface getBri() {
        return bri;
    }

    public void setBri(MBandRepositoryInterface bri) {
        this.bri = bri;
    }

    public MAlbumRepositoryInterface getAri() {
        return ari;
    }

    public void setAri(MAlbumRepositoryInterface ari) {
        this.ari = ari;
    }

    public MSongRepositoryInterface getSri() {
        return sri;
    }

    public void setSri(MSongRepositoryInterface sri) {
        this.sri = sri;
    }

    public MAlbumSongRepositoryInterface getAsri() {
        return asri;
    }

    public void setAsri(MAlbumSongRepositoryInterface asri) {
        this.asri = asri;
    }

}
