/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MGenre;
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
@Named("createband")
@Scope("request")
@Transactional
public class CreatingBandController {

    private MBand newBand;

    private String selectedGenre;

    private Part file1;

    @Inject
    MBandRepositoryInterface bri;

    public CreatingBandController() {
        newBand = new MBand();
    }

    public String addBand() {
        newBand.setGenre(getGenre(selectedGenre));
        try {
            String filepath = "C:\\Users\\Agatka\\Desktop\\apkaMuzyczna\\tunkeys\\mapplication\\mappview\\src\\main\\webapp\\resources\\img\\" + getFilename(file1);
            file1.write(filepath);
            newBand.setCover("img/"+getFilename(file1));
        } catch (IOException ex) {
            Logger.getLogger(DemoBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bri.insert(newBand);
        }
        return "bands";
    }

    public MBand getNewBand() {
        return newBand;
    }

    public void setNewBand(MBand newBand) {
        this.newBand = newBand;
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

    public String getSelectedGenre() {
        return selectedGenre;
    }

    public void setSelectedGenre(String selectedGenre) {
        this.selectedGenre = selectedGenre;
    }

    public MBandRepositoryInterface getBri() {
        return bri;
    }

    public void setBri(MBandRepositoryInterface bri) {
        this.bri = bri;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
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
