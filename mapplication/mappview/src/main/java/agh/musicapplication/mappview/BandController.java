/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappservices.interfaces.RoundingServiceInterface;
import agh.musicapplication.mappview.cookies.CookieHelper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author ag
 */
@Named("band")
@Scope("request")
public class BandController {

    @Inject
    MBandRepositoryInterface bri;

    @Inject
    MAlbumRepositoryInterface ari;

    @Inject
    RoundingServiceInterface rsi;

    private MBand currentBand;
    private String bandName;
    private int howMany;

    private List<MAlbum> albumsSorted;

    public BandController() {
    }

    @PostConstruct
    public void init() {
        if(CookieHelper.getCookie("bandname").getValue()!=null)
            bandName = CookieHelper.getCookie("bandname").getValue();
        else
            bandName = "";
        if (bri.findBandByName(bandName) != null) {
            currentBand = bri.findBandByName(bandName);
            albumsSorted = ari.getAlbumsOfSomeBandSortedAlphabetically(currentBand);
        } else {
            currentBand = new MBand();
            albumsSorted = new ArrayList<>();
        }
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public MBand getCurrentBand() {
        return currentBand;
    }

    public void setCurrentBand(MBand currentBand) {
        this.currentBand = currentBand;
    }

    public String goToBandCreating() {
        return "/protected/createband.xhtml";
    }

    public double getBandMark() {
        return rsi.round(currentBand.getGrade(), 2);

    }

    public String goToAlbum(MAlbum a) {
        String id = Long.toString(a.getId());
        CookieHelper.setCookie("albumid", Long.toString(a.getId()), 1000000);
        return "bands";
    }

    public MBandRepositoryInterface getBri() {
        return bri;
    }

    public void setBri(MBandRepositoryInterface bri) {
        this.bri = bri;
    }

    public RoundingServiceInterface getRsi() {
        return rsi;
    }

    public void setRsi(RoundingServiceInterface rsi) {
        this.rsi = rsi;
    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public List<MAlbum> getAlbumsSorted() {
        return albumsSorted;
    }

    public void setAlbumsSorted(List<MAlbum> albumsSorted) {
        this.albumsSorted = albumsSorted;
    }
}
