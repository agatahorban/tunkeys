/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MPermissionRepositoryInterface;
import agh.musicapplication.mappmodel.MPermission;
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
public class MPermissionRepository extends AbstractCrudRepository<MPermission> implements Serializable, MPermissionRepositoryInterface {

    @Override
    public MPermission findPermissionByName(String name) {
        Query query = getSession().createQuery("from MPermission where name = :name");
        query.setParameter("name", name);
        return (MPermission) query.uniqueResult();
    }
}
