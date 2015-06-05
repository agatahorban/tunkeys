/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.MUserBandRepository;
import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MSongRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserSongRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MSong;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.UserStatisticsService;
import agh.musicapplication.mappservices.interfaces.UserStatisticsServiceInterface;
import agh.musicapplication.mappview.cookies.CookieHelper;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agata
 */
@Named("existinguser")
@Scope("session")
@Transactional
public class UserController implements Serializable {

    private UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    private MUser muser;

    @Inject
    MUserRepositoryInterface uri;

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
    UserStatisticsServiceInterface userStatisticsService;
    
    @Inject
    CountController cc;

    private long vocalRated, bandRated;
    private double avgGrade;
    private int number;

    @PostConstruct
    public void initalizeMUser() {
        muser = uri.findUserByLogin(user.getUsername());
        vocalRated = userStatisticsService.getAmountOfVocalistsRatedByUser(muser);
        bandRated = userStatisticsService.getAmountOfBandsRatedByUser(muser);
        avgGrade = userStatisticsService.getAvgGradeOfSomeUser(muser);
        CookieHelper.setCookie("bandname", "", 10000000);
        number = 0;
    }

    public MUser getMuser() {
        return muser;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public MUserRepositoryInterface getUri() {
        return uri;
    }

    public void setUri(MUserRepositoryInterface uri) {
        this.uri = uri;
    }

    public UserStatisticsServiceInterface getUserStatisticsService() {
        return userStatisticsService;
    }

    public void setUserStatisticsService(UserStatisticsService UserStatisticsService) {
        this.userStatisticsService = UserStatisticsService;
    }

    public long getVocalRated() {
        return vocalRated;
    }

    public void setVocalRated(long vocalRated) {
        this.vocalRated = vocalRated;
    }

    public long getBandRated() {
        return bandRated;
    }

    public void setBandRated(long bandRated) {
        this.bandRated = bandRated;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(int avgGrade) {
        this.avgGrade = avgGrade;
    }

    public boolean ifBandNotRated(String band) {
        MBand b = bri.findBandByName(band);
        if (b == null) {
            return false;
        }
        return ubri.getCountOfMUserBand(muser, b).equals(0L);
    }

    public boolean ifAlbumNotRated(Long album) {
        MAlbum a = ari.find(album);
        if (a == null) {
            return false;
        }
        return uari.getCountOfMUserAlbum(muser, a).equals(0L);
    }

    public boolean ifSongNotRated(Long song) {
        MSong s = sri.find(song);
        if (s== null) {
            return false;
        }
        return usri.getCountOfMUserSong(muser, s).equals(0L);
    }

    public int getRate(long band) {
        if (bri.find(band) == null) {
            return 0;
        } else {
            return ubri.getMUserBand(muser, bri.find(band)).getGrade();
        }
    }

    public double getAlbumRate(long album) {
        if (ari.find(album) == null) {
            return 0;
        } else {
            return uari.getMUserAlbum(muser, ari.find(album)).getGrade();
        }
    }
}
