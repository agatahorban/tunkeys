/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ag
 */
@Entity
@Table(name = "m_user_album")
public class MUserAlbum extends MBasicEntity {
    
    @Column
    private int grade;
    
    @ManyToOne
    private MUser user;
    
    @ManyToOne
    private MAlbum album;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public MUser getUser() {
        return user;
    }

    public void setUser(MUser user) {
        this.user = user;
    }

    public MAlbum getAlbum() {
        return album;
    }

    public void setAlbum(MAlbum album) {
        this.album = album;
    }
    
    
}
