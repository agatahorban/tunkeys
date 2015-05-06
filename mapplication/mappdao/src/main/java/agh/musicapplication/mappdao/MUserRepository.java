/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import java.io.Serializable;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agatka
 */
@Repository
@Transactional
public class MUserRepository extends AbstractCrudRepository<MUser> implements Serializable,MUserRepositoryInterface {

    @Override
    public MUser findUserByLogin(String login) {
        Query query = getSession().createQuery("from MUser where login = :login");
        query.setParameter("login", login);
        return (MUser) query.uniqueResult();
    }
}
