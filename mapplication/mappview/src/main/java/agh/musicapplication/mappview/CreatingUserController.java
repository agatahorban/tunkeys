/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ag
 */

@Named("createuser")
@Scope("request")
@Transactional
public class CreatingUserController {
    private MUser user;
    
    @Inject
    MUserRepositoryInterface uri;

    public CreatingUserController() {
        user = new MUser();
    }
    
     public void addUser(){
        uri.insert(user);
    }

    public MUser getUser() {
        return user;
    }

    public void setUser(MUser user) {
        this.user = user;
    }
     
     
}
