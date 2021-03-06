/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao.interfaces;

import agh.musicapplication.mappdao.Crudable;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserAlbum;

/**
 *
 * @author horbana
 */
public interface MUserAlbumRepositoryInterface extends Crudable<MUserAlbum>{
    public Long getCountOfMUserAlbum(MUser user, MAlbum album);
    public MUserAlbum getMUserAlbum(MUser user, MAlbum band);
}
