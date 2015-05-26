/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MGenre;
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
