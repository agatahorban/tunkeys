/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappservices.interfaces;

import agh.musicapplication.mappmodel.MReview;

/**
 *
 * @author ag
 */
public interface ReviewServiceInterface {
     void addNewReview(MReview review);
     MReview setNewReviewDescription(long id, String desc);
}
