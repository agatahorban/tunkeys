/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices.msecurity;

import agh.musicapplication.mappmodel.MUser;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Agatka
 */
public class UserDetailsImpl implements UserDetails{

    private MUser muser;

    public UserDetailsImpl(MUser muser) {
        this.muser = muser;
    }

    public MUser getMuser() {
        return muser;
    }
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.addAll(muser.getRoles());
        return authorities;
    }

    @Override
    public String getPassword() {
        return muser.getPassword();
    }

    @Override
    public String getUsername() {
        return muser.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
