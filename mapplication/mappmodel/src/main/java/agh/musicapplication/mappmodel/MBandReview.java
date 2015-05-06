/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappmodel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ag
 */
@Entity
@Table(name = "m_band_review")
public class MBandReview extends MBasicEntity {
    
    private MReview review;
    
    private MBand band;

    public MBandReview() {
    }

    public MReview getReview() {
        return review;
    }

    public void setReview(MReview review) {
        this.review = review;
    }

    public MBand getBand() {
        return band;
    }

    public void setBand(MBand band) {
        this.band = band;
    }
}
