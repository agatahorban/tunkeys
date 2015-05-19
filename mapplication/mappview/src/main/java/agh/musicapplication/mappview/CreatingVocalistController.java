/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MVocalistRepositoryInterface;
import agh.musicapplication.mappmodel.MVocalist;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ag
 */
@Named("createvocalist")
@Scope("request")
@Transactional
public class CreatingVocalistController {

    private MVocalist vocalist;

    @Inject
    MVocalistRepositoryInterface vri;
    
    public CreatingVocalistController(){
       vocalist = new MVocalist();
    }
    
    public void addVocalist(){
        vri.insert(vocalist);
    }

    public MVocalist getVocalist() {
        return vocalist;
    }

    public void setVocalist(MVocalist vocalist) {
        this.vocalist = vocalist;
    }
    
}
