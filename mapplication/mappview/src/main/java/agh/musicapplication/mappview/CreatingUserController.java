/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappview.util.PathHolder;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ag
 */
@Named("createuser")
@Scope("request")
public class CreatingUserController {
    
    private static final Logger logger = LoggerFactory.getLogger(CreatingUserController.class);

    private MUser user;

    private Part file1;

    @Inject
    MUserRepositoryInterface uri;

    public CreatingUserController() {
        user = new MUser();
    }

    public String addUser() {
        try {

            String filepath = PathHolder.PATH + PathHolder.getFilename(file1);
            logger.info("Zapisalem sciezke" + filepath);
            file1.write(filepath);
            logger.info("Wrzucilem sciekze do pliku");
            user.setAvatar("img/" + PathHolder.getFilename(file1));
            logger.info("Ustawilem avatar");
        } catch (IOException ex) {
            logger.info("dupa blada");

        } finally {
            logger.info("Finnaly block mutha");
            uri.insert(user);
            logger.info("there shoud be my user in database");
        }
        return "login";
    }

    public MUser getUser() {
        return user;
    }

    public void setUser(MUser user) {
        this.user = user;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String test(){
        return "login";
    }
}
