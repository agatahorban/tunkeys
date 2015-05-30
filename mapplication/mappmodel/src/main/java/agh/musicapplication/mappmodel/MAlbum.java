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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ag
 */
@Entity
@Table(name = "malbum")
public class MAlbum extends MBasicEntity {
    
    @Column
    private String name;
    
    @Column
    private int grade;
    
    @Column
    private String cover;
    
    @Column(name = "number_of_votes")
    private int numberOfVotes;
    
    @Enumerated(EnumType.STRING)
    private MGenre genre;
    
    @ManyToOne
    private MBand band;
    
    @ManyToOne
    private MVocalist vocalist;
    
    @OneToMany(mappedBy = "album")
    private List<MUserAlbum> mUserAlbums;
    
    @OneToMany(mappedBy = "album")
    private List<MAlbumSong> mAlbumSongs;

    public MAlbum() {
        mUserAlbums = new ArrayList<>();
        mAlbumSongs = new ArrayList<>();
    }

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

    public MBand getBand() {
        return band;
    }

    public void setBand(MBand band) {
        this.band = band;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<MUserAlbum> getmUserAlbums() {
        return mUserAlbums;
    }

    public void setmUserAlbums(List<MUserAlbum> mUserAlbums) {
        this.mUserAlbums = mUserAlbums;
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

    public MVocalist getVocalist() {
        return vocalist;
    }

    public void setVocalist(MVocalist vocalist) {
        this.vocalist = vocalist;
    }

}
