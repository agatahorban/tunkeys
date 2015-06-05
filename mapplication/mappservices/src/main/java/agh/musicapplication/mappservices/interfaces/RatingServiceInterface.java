/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices.interfaces;

import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import javax.inject.Inject;

/**
 *
 * @author Agata
 */
public interface RatingServiceInterface {
    
    public boolean rateBand(MUser user, MBand band, int grade);
    public boolean rateAlbum(MUser muser, MAlbum a, int rate);
}
