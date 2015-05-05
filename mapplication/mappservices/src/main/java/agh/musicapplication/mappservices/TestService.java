/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.MReviewRepository;
import agh.musicapplication.mappmodel.MReview;
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
public class TestService implements Serializable {
    @Inject
    private MReviewRepository mrr;
    
    public void testMethod(MReview review){
        mrr.insert(review);
    }
}
