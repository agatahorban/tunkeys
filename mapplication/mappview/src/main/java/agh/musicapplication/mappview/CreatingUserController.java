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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ag
 */
@Named("createuser")
@Scope("request")
@Transactional
public class CreatingUserController {

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
            Logger.getLogger(CreatingUserController.class.getName()).log(Level.SEVERE, "Zapisalem sciezke" + filepath);
            file1.write(filepath);
            Logger.getLogger(CreatingUserController.class.getName()).log(Level.SEVERE, "Wrzucilem sciekze do pliku");
            user.setAvatar("img/" + PathHolder.getFilename(file1));
            Logger.getLogger(CreatingUserController.class.getName()).log(Level.SEVERE, "Ustawilem avatar");
        } catch (IOException ex) {
            Logger.getLogger(DemoBean.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            uri.insert(user);
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

}
