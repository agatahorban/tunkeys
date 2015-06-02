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
@Table(name = "msong")
public class MSong extends MBasicEntity {
    
    @Column
    private String name;
    @Column
    private double grade;
    @Column(name = "number_of_votes")
    private int numberOfVotes;
    
    @Enumerated(EnumType.STRING)
    private MGenre genre;
    
    @OneToMany(mappedBy = "song")
    private List<MUserSong> mUserSongs;
    @OneToMany(mappedBy = "song")
    private List<MSingielSong> mSingielSongs;
    @OneToMany(mappedBy = "song")
    private List<MAlbumSong> mAlbumSongs;

    public MSong() {
        mUserSongs = new ArrayList<>();
        mSingielSongs = new ArrayList<>();
        mAlbumSongs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<MUserSong> getmUserSongs() {
        return mUserSongs;
    }

    public void setmUserSongs(List<MUserSong> mUserSongs) {
        this.mUserSongs = mUserSongs;
    }

    public List<MSingielSong> getmSingielSongs() {
        return mSingielSongs;
    }

    public void setmSingielSongs(List<MSingielSong> mSingielSongs) {
        this.mSingielSongs = mSingielSongs;
    }

    public List<MAlbumSong> getmAlbumSongs() {
        return mAlbumSongs;
    }

    public void setmAlbumSongs(List<MAlbumSong> mAlbumSongs) {
        this.mAlbumSongs = mAlbumSongs;
    }

    public MGenre getGenre() {
        return genre;
    }

    public void setGenre(MGenre genre) {
        this.genre = genre;
    }
    
    
}
