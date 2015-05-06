/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices.msecurity;

import agh.musicapplication.mappdao.MUserRepository;
import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agatka
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

    @Inject
    MUserRepositoryInterface mur;
    
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MUser user = mur.findUserByLogin(login);
         if (user == null) {
            logger.warn("No such user: " + login);
            throw new UsernameNotFoundException("No such user: " + login);
        } else if (user.getRoles().isEmpty()) {
            logger.warn("User " + login + " has no authorities");
            throw new UsernameNotFoundException("User " + login + " has no authorities");
        }
        
        return new UserDetailsImpl(user);
    }
    
}
