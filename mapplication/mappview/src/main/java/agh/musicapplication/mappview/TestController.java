/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappmodel.MReview;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.TestService;
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

    @Inject
    private TestService ts;

    public TestController() {
        user = new MUser();
        user.setLogin("login");

    }

    public void addReview() {
        review = new MReview();
        review.setName("review");
        review.setDescripton("desc");
        ts.testMethod(review);
    }

    public MUser getUser() {
        return user;
    }

    public void setUser(MUser user) {
        this.user = user;
    }
}
