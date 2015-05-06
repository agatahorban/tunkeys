/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappmodel.MReview;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.ReviewService;
import agh.musicapplication.mappservices.interfaces.ReviewServiceInterface;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Agatka
 */
@Named("test")
@Scope("session")
public class TestController implements Serializable {

    private MUser user;
    private MReview review;
    private String bandName;

    @Inject
    private ReviewServiceInterface ts;

    public TestController() {
        user = new MUser();
        user.setLogin("login");

    }

    public void addReview() {
        review = new MReview();
        review.setName("review");
        review.setDescripton("desc");
        ts.addNewReview(review);
    }
    
    public String goToBand(){
        return "/protected/band.xhtml?faces-redirect=true&bandname="+bandName;
    }

    public MUser getUser() {
        return user;
    }

    public void setUser(MUser user) {
        this.user = user;
    }

    public MReview getReview() {
        return review;
    }

    public void setReview(MReview review) {
        this.review = review;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public ReviewServiceInterface getTs() {
        return ts;
    }

    public void setTs(ReviewService ts) {
        this.ts = ts;
    }
    
    
}
