/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappdao.interfaces;

import agh.musicapplication.mappdao.Crudable;
import agh.musicapplication.mappmodel.MVocalist;

/**
 *
 * @author ag
 */
public interface MVocalistRepositoryInterface  extends Crudable<MVocalist>{
     public MVocalist findVocalistByName(String vocalistArtisticName);
}
