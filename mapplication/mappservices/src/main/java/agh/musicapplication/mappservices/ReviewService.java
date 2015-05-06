/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.interfaces.MReviewRepositoryInterface;
import agh.musicapplication.mappmodel.MReview;
import agh.musicapplication.mappservices.interfaces.ReviewServiceInterface;
import java.io.Serializable;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author ag
 */
@Service
@Transactional
public class ReviewService implements Serializable, ReviewServiceInterface {
    @Inject
    private MReviewRepositoryInterface mrr;
    
    public void addNewReview(MReview review){
        mrr.insert(review);
    }
    
    public MReview setNewReviewDescription(long id, String desc){
        MReview r = mrr.find(id);
        r.setDescripton(desc);
        return r;
    }
}
