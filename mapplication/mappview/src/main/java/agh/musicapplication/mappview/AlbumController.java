/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MAlbumSongRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MSong;
import agh.musicapplication.mappservices.interfaces.RoundingServiceInterface;
import agh.musicapplication.mappview.cookies.CookieHelper;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author horbana
 */
@Named("album")
@Scope("request")
public class AlbumController {
    @Inject
    MAlbumRepositoryInterface ari;
    
    @Inject
    RoundingServiceInterface rsi;
    
    @Inject
    MAlbumSongRepositoryInterface asri;
    
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
    
    public List<MSong> albumSongs(){
        return asri.getAllSongsOfSomeAlbum(currentAlbum);
    }
    
    public String setDivId(Long id, int number){
        StringBuilder sb = new StringBuilder();
        sb.append("star_");
        sb.append("song_");
        sb.append(Long.toString(id));
        sb.append("_");
        sb.append(Integer.toString(number));
        CookieHelper.setCookie("sdiv"+number, sb.toString(), 1000000000);
        return sb.toString();
    }
    
}
