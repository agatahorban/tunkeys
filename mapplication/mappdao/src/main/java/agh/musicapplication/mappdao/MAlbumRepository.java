/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import java.io.Serializable;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agatka
 */
@Repository
@Transactional
public class MAlbumRepository extends AbstractCrudRepository<MAlbum> implements Serializable,MAlbumRepositoryInterface {
        
    @Override
    public MAlbum findAlbumByName(String album) {
        Query query = getSession().createQuery("from MAlbum where name = :album");
        query.setParameter("album", album);
        return (MAlbum) query.uniqueResult();
    }

}
