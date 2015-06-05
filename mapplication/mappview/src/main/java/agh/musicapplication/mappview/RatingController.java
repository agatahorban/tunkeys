/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MSongRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MGenre;
import agh.musicapplication.mappmodel.MSong;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.interfaces.RatingServiceInterface;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agata
 */

@Named("rate")
@Scope("request")
@Transactional
public class RatingController {
    @Inject
    RatingServiceInterface rsi;
    
    @Inject
    MUserRepositoryInterface uri;
    
    @Inject
    MBandRepositoryInterface bri;
    
    @Inject
    MAlbumRepositoryInterface ari;
    
    @Inject
    MSongRepositoryInterface sri;
    
    int bandid;
    
    private MUser muser;
    
    @PostConstruct
    public void init() {
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        muser = uri.findUserByLogin(user.getUsername());
    }
    
    public String rateBand(int rate, long band){
        MBand b = bri.find(band);
        rsi.rateBand(muser, b, rate);
        b.setGenre(MGenre.ROCK);
        bri.update(b);
        return "bands.xhtml";
    }
    
     public String rateAlbum(int rate, Long band){
        MAlbum a = ari.find(band);
        rsi.rateAlbum(muser, a, rate);
        ari.update(a);
        return "bands.xhtml";
    }
     
      public String rateSong(int rate, Long song){
        MSong s = sri.find(song);
        rsi.rateSong(muser, s, rate);
        sri.update(s);
        return "bands.xhtml";
    }
   
    public MBand findBand(String bandName){
        return bri.findBandByName(bandName);
    }

    public MBandRepositoryInterface getBri() {
        return bri;
    }

    public void setBri(MBandRepositoryInterface bri) {
        this.bri = bri;
    }
    
    
}
