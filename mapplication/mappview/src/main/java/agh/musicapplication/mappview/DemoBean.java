package agh.musicapplication.mappview;

import agh.musicapplication.mappmodel.MGenre;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import javax.servlet.http.Part;

/**
 *
 * @author Agata
 */

@Named("demobean")
@Scope("session")
public class DemoBean {

    private Part file1;
    
    public String favCoffee1;

    public String getFavCoffee1() {
        return favCoffee1;
    }

    public void setFavCoffee1(String favCoffee1) {
        this.favCoffee1 = favCoffee1;
    }
    
   
    public String upload() {
        try {
            file1.write("C:\\data\\"+getFilename(file1));
        } catch (IOException ex) {
            Logger.getLogger(DemoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
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
