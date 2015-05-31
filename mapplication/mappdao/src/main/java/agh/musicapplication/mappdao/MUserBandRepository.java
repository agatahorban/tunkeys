package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserBand;
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
public class MUserBandRepository extends AbstractCrudRepository<MUserBand> implements Serializable, MUserBandRepositoryInterface {

    @Override
    public Long getCountOfMUserBand(MUser user) {
        Query query = getSession().createQuery( "select count(*) from MUserBand m where m.user=:user");
        query.setParameter("user", user);
        Long count = (Long) query.uniqueResult();
        return count;
    }

    @Override
    public Double getAvgBandRankOfSomeUser(MUser user) {
        Query query = getSession().createQuery( "select avg(m.grade) from MUserBand m where m.user=:user");
        query.setParameter("user", user);
        Double average = (Double) query.uniqueResult();
        return average;
    }

    @Override
    public Long getCountOfMUserBand(MUser user, MBand band) {
        Query query = getSession().createQuery( "select count(*) from MUserBand m where m.user=:user and m.band=:band");
        query.setParameter("user", user);
        query.setParameter("band", band);
        Long count = (Long) query.uniqueResult();
        return count;
    }
    
    @Override
    public MUserBand getMUserBand(MUser user, MBand band) {
        Query query = getSession().createQuery( "from MUserBand m where m.user=:user and m.band=:band");
        query.setParameter("user", user);
        query.setParameter("band", band);
        MUserBand b = (MUserBand) query.uniqueResult();
        return b;
    }

}
