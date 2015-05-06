/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappdao.interfaces;

import agh.musicapplication.mappdao.Crudable;
import agh.musicapplication.mappmodel.MUser;

/**
 *
 * @author Agatka
 */
public interface MUserRepositoryInterface extends Crudable<MUser>{
    MUser findUserByLogin(String login);
}
