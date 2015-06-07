/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.interfaces.BandFindServiceInterface;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author ag
 */
@Service
@Transactional
public class BandFindService implements BandFindServiceInterface {

    @Inject
    MUserBandRepositoryInterface ubri;

    @Override
    public List<MBand> findLatelyRatedBands(MUser user, int howMany) {
        List<MBand> allBands = ubri.getAllRatedBandsOfSomeUser(user);
        List<MBand> reversed = Lists.reverse(allBands);
        List<MBand> newList;
        if (reversed.size() >= 10) {
            newList = reversed.subList(0, 9);
        }
        else {
            newList = reversed.subList(0, reversed.size());
        }
        return newList;
    }

}
