/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappservices.interfaces.RoundingServiceInterface;
import agh.musicapplication.mappview.cookies.CookieHelper;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author horbana
 */
public class AlbumController {
    @Inject
    MAlbumRepositoryInterface ari;
    
    @Inject
    RoundingServiceInterface rsi;
    
    private MAlbum currentAlbum;
    private Long albumId;

    @PostConstruct
    public void init() {
        albumId = Long.parseLong(CookieHelper.getCookie("albumid").getValue());
        currentAlbum = ari.find(albumId);
    }
    
    public double getAlbumMark(){
        return rsi.round(currentAlbum.getGrade(), 2);
    }

    public MAlbum getCurrentAlbum() {
        return currentAlbum;
    }

    public void setCurrentAlbum(MAlbum currentAlbum) {
        this.currentAlbum = currentAlbum;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
    
    
    
}
