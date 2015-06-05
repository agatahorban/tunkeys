/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MSongRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserSongRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MSong;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserAlbum;
import agh.musicapplication.mappmodel.MUserBand;
import agh.musicapplication.mappmodel.MUserSong;
import agh.musicapplication.mappservices.interfaces.RatingServiceInterface;
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
    MUserAlbumRepositoryInterface uari;
    
    @Inject
    MUserSongRepositoryInterface usri;
    
    @Inject
    MBandRepositoryInterface bri;
    
    @Inject
    MAlbumRepositoryInterface ari;
    
    @Inject
    MSongRepositoryInterface sri;

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



    @Override
    public boolean rateAlbum(MUser muser, MAlbum a, int rank) {
        boolean rate;
        try {
            MUserAlbum museralbum = new MUserAlbum();
            museralbum.setAlbum(a);
            museralbum.setUser(muser);
            museralbum.setGrade(rank);
            uari.insert(museralbum);
            GradeCountingService.GradeHolder gh = gcs.countNewGrade(a.getNumberOfVotes(), a.getGrade(), rank);
            a.setGrade(gh.getGrade());
            a.setNumberOfVotes(gh.getCount());
            ari.update(a);
            rate = true;
        } catch (NullPointerException e) {
            rate = false;
        }
        return rate;
    }

    @Override
    public boolean rateSong(MUser muser, MSong s, int rate) {
         boolean r;
        try {
            MUserSong musersong = new MUserSong();
            musersong.setSong(s);
            musersong.setUser(muser);
            musersong.setGrade(rate);
            usri.insert(musersong);
            GradeCountingService.GradeHolder gh = gcs.countNewGrade(s.getNumberOfVotes(), s.getGrade(), rate);
            s.setGrade(gh.getGrade());
            s.setNumberOfVotes(gh.getCount());
            sri.update(s);
            r = true;
        } catch (NullPointerException e) {
            r = false;
        }
        return r;
    }
}
