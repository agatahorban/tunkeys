/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import agh.musicapplication.mappmodel.MBasicEntity;
import agh.musicapplication.mappservices.interfaces.ListSplittingServiceInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agata
 */
public class ListSplittingService implements ListSplittingServiceInterface {

    @Override
    public List<List<MBasicEntity>> splitList(List<MBasicEntity> oldList, int number) {
        List<List<MBasicEntity>> newList = new ArrayList<>();
        if (oldList.size() <= number) {
            newList.add(oldList);
            return newList;
        } else {
            int amount = oldList.size() % number;
            int k = 0;
            for (int i = 0; i < amount; i++) {
                List<MBasicEntity> shortList = new ArrayList<>();
                for (int j = 0; j < number; j++) {
                    if (k < oldList.size()) {
                        shortList.add(oldList.get(k));
                        k++;
                    }
                }
                newList.add(shortList);
            }
        }
        return newList;
    }

}
