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
public class MVocalist extends MBasicEntity{
    @Column
    private String name;
    
    @Column
    private String surname;
    
    @Column
    private String artisticName;
    
    @OneToMany(mappedBy = "vocalist")
    private List<MUserVocalist> mUserVocalists;
    
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
    
    
}
