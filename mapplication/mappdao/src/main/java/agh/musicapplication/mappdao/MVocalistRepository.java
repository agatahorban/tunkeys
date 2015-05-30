/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MVocalistRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MVocalist;
import java.io.Serializable;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ag
 */
@Repository
@Transactional
public class MVocalistRepository extends AbstractCrudRepository<MVocalist> implements Serializable,MVocalistRepositoryInterface {

    @Override
    public MVocalist findVocalistByName(String vocalistArtisticName) {
        Query query = getSession().createQuery("from MVocalist where artisticName = :vocalistArtisticName");
        query.setParameter("vocalistArtisticName", vocalistArtisticName);
        return (MVocalist) query.uniqueResult();
    }
    
}
