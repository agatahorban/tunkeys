/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.MUserBandRepository;
import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.UserStatisticsService;
import agh.musicapplication.mappservices.interfaces.UserStatisticsServiceInterface;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agata
 */
@Named("existinguser")
@Scope("session")
@Transactional
public class UserController {

    private UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    private MUser muser;

    @Inject
    MUserRepositoryInterface uri;

    @Inject
    MUserBandRepositoryInterface ubri;

    @Inject
    MBandRepositoryInterface bri;

    @Inject
    UserStatisticsServiceInterface userStatisticsService;

    private long vocalRated, bandRated;
    private double avgGrade;

    @PostConstruct
    public void initalizeMUser() {
        muser = uri.findUserByLogin(user.getUsername());
        vocalRated = userStatisticsService.getAmountOfVocalistsRatedByUser(muser);
        bandRated = userStatisticsService.getAmountOfBandsRatedByUser(muser);
        avgGrade = userStatisticsService.getAvgGradeOfSomeUser(muser);
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

    public int getRate(long band) {
        if (bri.find(band) == null) {
            return 0;
        } else {
            return ubri.getMUserBand(muser, bri.find(band)).getGrade();
        }
    }
}
