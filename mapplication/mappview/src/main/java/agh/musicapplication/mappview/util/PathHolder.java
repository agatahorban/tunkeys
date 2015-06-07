/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappview.util;

import javax.servlet.http.Part;

/**
 *
 * @author ag
 */
public class PathHolder {
    public static final String PATH = "C:\\Users\\Agatka\\Desktop\\apkaMuzyczna\\tunkeys\\mapplication\\mappview\\src\\main\\webapp\\resources\\img\\";

 public static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
}
