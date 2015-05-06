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
@Table(name = "mband")
public class MBand extends MBasicEntity {

    @OneToMany(mappedBy = "band")
    private List<MUserBand> mUserBands;
    
    @OneToMany(mappedBy = "band")
    private List<MAlbum> mAlbums;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int grade;
    
    @Column
    private String cover;

    @Column(name = "number_of_votes")
    private int numberOfVotes;

    public MBand() {
        mUserBands = new ArrayList<>();
        mAlbums = new ArrayList<>();
    }

    public List<MUserBand> getmUserBands() {
        return mUserBands;
    }

    public void setmUserBands(List<MUserBand> mUserBands) {
        this.mUserBands = mUserBands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<MAlbum> getmAlbums() {
        return mAlbums;
    }

    public void setmAlbums(List<MAlbum> mAlbums) {
        this.mAlbums = mAlbums;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    
    
}
