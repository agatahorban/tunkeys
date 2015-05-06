/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
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
public class MBandRepository extends AbstractCrudRepository<MBand> implements Serializable,MBandRepositoryInterface{

    @Override
    public MBand findBandByName(String band) {
        Query query = getSession().createQuery("from MBand where name = :band");
        query.setParameter("band", band);
        return (MBand) query.uniqueResult();
    }

    
    
}
