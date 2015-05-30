/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices.interfaces;

import agh.musicapplication.mappmodel.MUser;

/**
 *
 * @author Agata
 */
public interface UserStatisticsServiceInterface {
    public long getAmountOfBandsRatedByUser(MUser u);
    public long getAmountOfVocalistsRatedByUser(MUser u);
    public double getAvgGradeOfSomeUser(MUser u);
}
