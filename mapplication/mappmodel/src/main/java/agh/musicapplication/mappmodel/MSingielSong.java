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
@Table(name = "m_singiel_song")
public class MSingielSong extends MBasicEntity {
    
    @ManyToOne
    private MSingiel singiel;
    @ManyToOne
    private MSong song;

    public MSingiel getSingiel() {
        return singiel;
    }

    public void setSingiel(MSingiel singiel) {
        this.singiel = singiel;
    }

    public MSong getSong() {
        return song;
    }

    public void setSong(MSong song) {
        this.song = song;
    }
    
    
    
}
