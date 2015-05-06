/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
    
    private MBand currentBand;
    private String bandName;

    public BandController() {
    }
    
    @PostConstruct
    public void init() {
        bandName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("bandname");
        currentBand = bri.findBandByName(bandName);
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

    public String goToBandCreating(){
        return "/protected/createband.xhtml";
    }

 
    
    
}
