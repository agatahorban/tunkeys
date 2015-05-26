/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agata
 */

@Named("existinguser")
@Scope("request")
@Transactional
public class UserController {
    private UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    private MUser muser;
    
    @Inject
    MUserRepositoryInterface uri;
    
    @PostConstruct
    public void initalizeMUser(){
        muser = uri.findUserByLogin(user.getUsername());
    }
    
    public MUser getMuser() {
        return muser;
    }
}
