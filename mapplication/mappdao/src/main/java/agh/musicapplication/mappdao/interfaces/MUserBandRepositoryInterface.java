/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao.interfaces;

import agh.musicapplication.mappdao.Crudable;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserBand;
import java.util.List;

/**
 *
 * @author Agata
 */
public interface MUserBandRepositoryInterface extends Crudable<MUserBand> {
    public Long getCountOfMUserBand(MUser user); 
    public Long getCountOfMUserBand(MUser user, MBand band);
    public Double getAvgBandRankOfSomeUser(MUser user);
    public MUserBand getMUserBand(MUser user, MBand band);
    public List<MBand> getAllRatedBandsOfSomeUser(MUser user);
}
