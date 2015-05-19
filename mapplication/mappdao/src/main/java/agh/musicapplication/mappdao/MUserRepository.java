/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MPermissionRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MPermission;
import agh.musicapplication.mappmodel.MUser;
import java.io.Serializable;
import javax.inject.Inject;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ag
 */
@Repository
@Transactional
public class MUserRepository extends AbstractCrudRepository<MUser> implements Serializable,MUserRepositoryInterface {

    private static final String MAIN_ROLE = "logged";
    @Inject
    private MPermissionRepositoryInterface pri;
     
    @Override
    public MUser findUserByLogin(String login) {
        Query query = getSession().createQuery("from MUser where login = :login");
        query.setParameter("login", login);
        return (MUser) query.uniqueResult();
    }
    
    @Override
    public void insert(MUser entity){
        super.insert(entity);
        MPermission role = pri.findPermissionByName(MAIN_ROLE);
        if (role != null) {
            entity.getRoles().add(role);
            update(entity);
        }
    }
}
