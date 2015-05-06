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
@Table(name = "m_user_singiel")
public class MUserSingiel extends MBasicEntity {
    
    @Column
    private int grade;
    @ManyToOne
    private MUser user;
    @ManyToOne
    private MSingiel singiel;

    public MUserSingiel() {
    }

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

    public MSingiel getSingiel() {
        return singiel;
    }

    public void setSingiel(MSingiel singiel) {
        this.singiel = singiel;
    }
}
