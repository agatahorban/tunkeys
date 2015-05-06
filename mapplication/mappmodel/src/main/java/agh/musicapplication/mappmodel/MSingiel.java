/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappmodel;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ag
 */
@Entity
@Table(name = "msingiel")
public class MSingiel extends MBasicEntity {
    
    @Column
    private String name;
    @Column
    private int grade;
    @Column(name = "number_of_votes")
    private int numberOfVotes;
    @Column
    private String cover;
    @OneToMany(mappedBy = "singiel")
    private List<MUserSingiel> mUserSingiels;
    @OneToMany(mappedBy = "singiel")
    private List<MSingielSong> mSingielSongs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<MUserSingiel> getmUserSingiels() {
        return mUserSingiels;
    }

    public void setmUserSingiels(List<MUserSingiel> mUserSingiels) {
        this.mUserSingiels = mUserSingiels;
    }

    public List<MSingielSong> getmSingielSongs() {
        return mSingielSongs;
    }

    public void setmSingielSongs(List<MSingielSong> mSingielSongs) {
        this.mSingielSongs = mSingielSongs;
    }
    
    
}
