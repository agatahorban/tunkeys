/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappmodel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ag
 */
@Entity
@Table(name = "m_album_song")
public class MAlbumSong extends MBasicEntity {
    
    @ManyToOne
    private MAlbum album;
    @ManyToOne
    private MSong song;

    public MAlbum getAlbum() {
        return album;
    }

    public void setAlbum(MAlbum album) {
        this.album = album;
    }

    public MSong getSong() {
        return song;
    }

    public void setSong(MSong song) {
        this.song = song;
    }
    
    
}
