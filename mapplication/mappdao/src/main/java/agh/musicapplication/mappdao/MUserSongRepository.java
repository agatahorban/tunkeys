package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MUserSongRepositoryInterface;
import agh.musicapplication.mappmodel.MSong;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserSong;
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
public class MUserSongRepository extends AbstractCrudRepository<MUserSong> implements Serializable, MUserSongRepositoryInterface {

    @Override
    public Long getCountOfMUserSong(MUser user, MSong song) {
        Query query = getSession().createQuery("select count(*) from MUserSong m where m.user=:user and m.song=:song");
        query.setParameter("user", user);
        query.setParameter("song", song);
        Long count = (Long) query.uniqueResult();
        return count;
    }

}
