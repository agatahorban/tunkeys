/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MUserVocalistRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserVocalist;
import java.io.Serializable;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agata
 */
@Repository
@Transactional
public class MUserVocalistRepository extends AbstractCrudRepository<MUserVocalist> implements Serializable, MUserVocalistRepositoryInterface {

    @Override
    public Long getCountOfMUserVocalist(MUser user) {
        Query query = getSession().createQuery( "select count(*) from MUserVocalist m where m.user=:user");
        query.setParameter("user", user);
        Long count = (Long) query.uniqueResult();
        return count;
    }

    @Override
    public Double getAvgVocalistRankOfSomeUser(MUser user) {
        Query query = getSession().createQuery( "select avg(m.grade) from MUserVocalist m where m.user=:user");
        query.setParameter("user", user);
        Double average = (Double) query.uniqueResult();
        return average;
    }

}
