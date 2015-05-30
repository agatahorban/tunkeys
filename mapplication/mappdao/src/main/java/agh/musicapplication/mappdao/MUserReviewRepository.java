/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MUserReviewRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserReview;
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
public class MUserReviewRepository extends AbstractCrudRepository<MUserReview> implements Serializable, MUserReviewRepositoryInterface {

    @Override
    public Long getCountOfMUserReview(MUser user) {
        Query query = getSession().createQuery( "select count(*) from MUserReview m where m.user=:user");
        query.setParameter("user", user);
        Long count = (Long) query.uniqueResult();
        return count;
    }
    
}
