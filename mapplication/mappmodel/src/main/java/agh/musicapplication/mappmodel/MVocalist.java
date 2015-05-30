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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ag
 */
@Entity
@Table(name = "mvocalist")
public class MVocalist extends MBasicEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String artisticName;

    @Column(length = 2000)
    private String description;

    @Column
    private double grade;

    @Column
    private String cover;

    @Column(name = "number_of_votes")
    private int numberOfVotes;

    @OneToMany(mappedBy = "vocalist")
    private List<MUserVocalist> mUserVocalists;
    
    @OneToMany(mappedBy = "vocalist")
    private List<MAlbum> mAlbums;

    @Enumerated(EnumType.STRING)
    private MGenre genre;

    public MVocalist() {
        mUserVocalists = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getArtisticName() {
        return artisticName;
    }

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }

    public List<MUserVocalist> getmUserVocalists() {
        return mUserVocalists;
    }

    public void setmUserVocalists(List<MUserVocalist> mUserVocalists) {
        this.mUserVocalists = mUserVocalists;
    }

    public MGenre getGenre() {
        return genre;
    }

    public void setGenre(MGenre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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
    
    

}
