/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappmodel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Agatka
 */
@Entity
@Table(name = "mreview")
public class MReview extends MBasicEntity {

    @OneToMany(mappedBy = "review")
    private List<MUserReview> mUserReviews;

    @Column
    private String name;
    @Column
    private String descripton;
    @Column
    private double grade;

    @Column(name = "number_of_votes")
    private int numberOfVotes;

    public MReview() {
        mUserReviews = new ArrayList<>();
    }

    public List<MUserReview> getmUserReviews() {
        return mUserReviews;
    }

    public void setmUserReviews(List<MUserReview> mUserReviews) {
        this.mUserReviews = mUserReviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

}
