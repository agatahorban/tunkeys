/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices.interfaces;

import agh.musicapplication.mappmodel.MBasicEntity;
import java.util.List;

/**
 *
 * @author Agata
 */
public interface ListSplittingServiceInterface {
    public List<List<MBasicEntity>> splitList(List<MBasicEntity> oldList, int number);
}
