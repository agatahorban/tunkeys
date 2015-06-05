package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MAlbumRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MAlbumSongRepositoryInterface;
import agh.musicapplication.mappmodel.MAlbum;
import agh.musicapplication.mappmodel.MAlbumSong;
import agh.musicapplication.mappmodel.MBand;
import agh.musicapplication.mappmodel.MSong;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agata
 */
@Repository
@Transactional
public class MAlbumSongRepository extends AbstractCrudRepository<MAlbumSong> implements Serializable,MAlbumSongRepositoryInterface {
    @Override
    public MAlbumSong getMAlbumSongWithSomeAlbumNameAndSongName(MAlbum a, MSong s){
        Query query = getSession().createQuery("from MAlbumSong where album = :album and song = :song");
        query.setParameter("album", a);
        query.setParameter("song", s);
        return (MAlbumSong) query.uniqueResult();
    }

    @Override
    public List<MSong> getAllSongsOfSomeAlbum(MAlbum album) {
        Query query = getSession().createQuery("select m.song from MAlbumSong m where m.album = :album");
        query.setParameter("album", album);
        return (List<MSong>) query.list();
    }
}
