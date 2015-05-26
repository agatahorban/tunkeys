/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserBand;
import agh.musicapplication.mappservices.interfaces.RatingServiceInterface;
import java.util.Map;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agata
 */
@Service
@Transactional
public class RatingService implements RatingServiceInterface {

    @Inject
    MUserBandRepositoryInterface ubri;

    @Inject
    MBandRepositoryInterface bri;

    @Inject
    GradeCountingService gcs;

    /**
     *
     * @param user
     * @param band
     * @param grade
     * @return
     */
    @Override
    public boolean rateBand(MUser user, MBand band, int grade) {
        boolean rate;
        try {
            MUserBand muserband = new MUserBand();
            muserband.setBand(band);
            muserband.setUser(user);
            muserband.setGrade(grade);
            ubri.insert(muserband);
            GradeCountingService.GradeHolder gh = gcs.countNewGrade(band.getNumberOfVotes(), band.getGrade(), grade);
            band.setGrade(gh.getGrade());
            band.setNumberOfVotes(gh.getCount());
            bri.update(band);
            rate = true;
        } catch (NullPointerException e) {
            rate = false;
        }
        return rate;
    }

    public GradeCountingService getGcs() {
        return gcs;
    }

    public void setGcs(GradeCountingService gcs) {
        this.gcs = gcs;
    }

    
}
