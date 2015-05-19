/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappdao.interfaces;

import agh.musicapplication.mappdao.Crudable;
import agh.musicapplication.mappmodel.MPermission;
import agh.musicapplication.mappmodel.MReview;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ag
 */
@Repository
@Transactional
public interface MPermissionRepositoryInterface extends Crudable<MPermission>{
    public MPermission findPermissionByName(String name);
}
