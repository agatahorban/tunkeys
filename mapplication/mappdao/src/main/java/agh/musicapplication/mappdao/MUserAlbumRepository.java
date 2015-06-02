package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MUserAlbumRepositoryInterface;
import agh.musicapplication.mappmodel.MUserAlbum;
import java.io.Serializable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author horbana
 */
@Repository
@Transactional
public class MUserAlbumRepository extends AbstractCrudRepository<MUserAlbum> implements Serializable, MUserAlbumRepositoryInterface{
    
}
