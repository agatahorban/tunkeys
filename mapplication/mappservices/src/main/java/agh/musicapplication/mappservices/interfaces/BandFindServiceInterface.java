/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappservices.interfaces;

import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import java.util.List;

/**
 *
 * @author ag
 */
public interface BandFindServiceInterface {
    public List<MBand> findLatelyRatedBands(MUser user, int howMany);
    
}
