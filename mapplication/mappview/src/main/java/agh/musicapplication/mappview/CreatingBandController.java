/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ag
 */
@Named("createband")
@Scope("request")
@Transactional
public class CreatingBandController {
    private MBand newBand;
    
    @Inject
    MBandRepositoryInterface bri;
    
    public CreatingBandController(){
        newBand = new MBand();
    }
    
    public void addBand(){
        bri.insert(newBand);
    }

    public MBand getNewBand() {
        return newBand;
    }

    public void setNewBand(MBand newBand) {
        this.newBand = newBand;
    }
    
    
}
