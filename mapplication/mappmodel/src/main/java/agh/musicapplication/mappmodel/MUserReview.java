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
 * @author Agatka
 */
@Entity
@Table(name = "m_user_review")
public class MUserReview extends MBasicEntity {

    @Column
    private int grade;

    @ManyToOne
    private MUser user;

    @ManyToOne
    private MReview review;

    public MUserReview() {
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

    public MReview getReview() {
        return review;
    }

    public void setReview(MReview review) {
        this.review = review;
    }
    
    
}
