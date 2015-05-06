/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.interfaces.MReviewRepositoryInterface;
import agh.musicapplication.mappmodel.MReview;
import agh.musicapplication.mappservices.interfaces.ReviewServiceInterface;
import static org.assertj.core.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author ag
 */
@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {
    
    @InjectMocks
    private ReviewServiceInterface sut = new ReviewService();
    
    @Mock
    private MReviewRepositoryInterface mrr;
    
    public ReviewServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void shouldFindOneReviewById() {
        //given
            MReview review = new MReview();
            review.setName("review");
            review.setDescripton("desc");
            when(mrr.find(any(Long.class))).thenReturn(review);
        //when
            MReview newReview = sut.setNewReviewDescription(1, "newdesc");
        //then
             assertThat(newReview.getDescripton())
                .isEqualTo("newdesc");
    }
    
}
