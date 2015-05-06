/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappdao.interfaces;

import agh.musicapplication.mappdao.Crudable;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;

/**
 *
 * @author ag
 */
public interface MBandRepositoryInterface extends Crudable<MBand>{
     public MBand findBandByName(String band);
}
