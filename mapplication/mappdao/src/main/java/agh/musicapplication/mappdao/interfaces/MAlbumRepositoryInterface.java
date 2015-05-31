/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao.interfaces;

import agh.musicapplication.mappdao.Crudable;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MBand;
import java.util.List;

/**
 *
 * @author Agatka
 */
public interface MAlbumRepositoryInterface extends Crudable<MAlbum> {
      public MAlbum findAlbumByName(String album);
      public List<MAlbum> getAlbumsOfSomeBandSortedAlphabetically(MBand band);
}
