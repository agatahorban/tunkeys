/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao.interfaces;

import agh.musicapplication.mappdao.Crudable;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MAlbumSong;
import agh.musicapplication.mappmodel.MSong;

/**
 *
 * @author Agata
 */
public interface MAlbumSongRepositoryInterface extends Crudable<MAlbumSong> {
    public MAlbumSong getMAlbumSongWithSomeAlbumNameAndSongName(MAlbum a, MSong s);
}
