/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MVocalistRepositoryInterface;
import agh.musicapplication.mappmodel.MGenre;
import agh.musicapplication.mappmodel.MVocalist;
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
@Named("createvocalist")
@Scope("request")
@Transactional
public class CreatingVocalistController {

    private MVocalist vocalist;

    @Inject
    MVocalistRepositoryInterface vri;

    private String selectedGenre;

    private Part file1;

    public CreatingVocalistController() {
        vocalist = new MVocalist();
    }
    public MVocalist getVocalist() {
        return vocalist;
    }

    public void setVocalist(MVocalist vocalist) {
        this.vocalist = vocalist;
    }

    public MVocalistRepositoryInterface getVri() {
        return vri;
    }

    public void setVri(MVocalistRepositoryInterface vri) {
        this.vri = vri;
    }

    public String getSelectedGenre() {
        return selectedGenre;
    }

    public void setSelectedGenre(String selectedGenre) {
        this.selectedGenre = selectedGenre;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String addVocalist() {
        vocalist.setGenre(getGenre(selectedGenre));
        try {
            String filepath =  PathHolder.PATH + getFilename(file1);
            file1.write(filepath);
            vocalist.setCover("img/" + getFilename(file1));
        } catch (IOException ex) {
            Logger.getLogger(DemoBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            vri.insert(vocalist);
        }
        
        return "/protected/addvocalistalbums.xhtml?faces-redirect=true&vocalname="+vocalist.getName();
    }

    public MGenre getGenre(String g) {
        switch (g) {
            case "Classic":
                return MGenre.CLASSIC;
            case "Country":
                return MGenre.COUNTRY;
            case "Hip-hop":
                return MGenre.HIPHOP;
            case "Metal":
                return MGenre.METAL;
            case "Pop":
                return MGenre.POP;
            case "Rock":
                return MGenre.ROCK;
        }
        return null;
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
    
    
}
