package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MUserAlbumRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappmodel.MUserAlbum;
import java.io.Serializable;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author horbana
 */
@Repository
@Transactional
public class MUserAlbumRepository extends AbstractCrudRepository<MUserAlbum> implements Serializable, MUserAlbumRepositoryInterface {

    @Override
    public Long getCountOfMUserAlbum(MUser user, MAlbum album) {
        Query query = getSession().createQuery("select count(*) from MUserAlbum m where m.user=:user and m.album=:album");
        query.setParameter("user", user);
        query.setParameter("album", album);
        Long count = (Long) query.uniqueResult();
        return count;
    }

    @Override
    public MUserAlbum getMUserAlbum(MUser user, MAlbum album) {
        Query query = getSession().createQuery("from MUserAlbum m where m.user=:user and m.album=:album");
        query.setParameter("user", user);
        query.setParameter("album", album);
        MUserAlbum a = (MUserAlbum) query.uniqueResult();
        return a;
    }
}
