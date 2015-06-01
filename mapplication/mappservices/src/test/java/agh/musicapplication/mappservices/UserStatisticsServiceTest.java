/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserVocalistRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.interfaces.RoundingServiceInterface;
import agh.musicapplication.mappservices.interfaces.UserStatisticsServiceInterface;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Agata
 */
@RunWith(MockitoJUnitRunner.class)
public class UserStatisticsServiceTest {

    @InjectMocks
    private UserStatisticsServiceInterface sut = new UserStatisticsService();

    @Mock
    private MUserBandRepositoryInterface userBandRepository;

    @Mock
    private MUserVocalistRepositoryInterface userVocalistRepository;

    public UserStatisticsServiceTest() {
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
    public void shouldReturn0Comma75Grade() {
        when(userBandRepository.getAvgBandRankOfSomeUser(any(MUser.class))).thenReturn(4.5);
        when(userVocalistRepository.getAvgVocalistRankOfSomeUser(any(MUser.class))).thenReturn(5.0);

        when(userBandRepository.getCountOfMUserBand(any(MUser.class))).thenReturn(2L);
        when(userVocalistRepository.getCountOfMUserVocalist(any(MUser.class))).thenReturn(2L);

        double result = sut.getAvgGradeOfSomeUser(new MUser());
        assertEquals(4.75, result, 0.000001);
    }

    @Test
    public void shouldReturn3Comma33Grade() {
        when(userBandRepository.getAvgBandRankOfSomeUser(any(MUser.class))).thenReturn(4.0);
        when(userVocalistRepository.getAvgVocalistRankOfSomeUser(any(MUser.class))).thenReturn(3.0);

        when(userBandRepository.getCountOfMUserBand(any(MUser.class))).thenReturn(1L);
        when(userVocalistRepository.getCountOfMUserVocalist(any(MUser.class))).thenReturn(2L);

        double result = sut.getAvgGradeOfSomeUser(new MUser());
        assertEquals(3.33, result, 0.000001);
    }

    @Test
    public void shouldReturn0BecauseNoRates() {
        when(userBandRepository.getAvgBandRankOfSomeUser(any(MUser.class))).thenReturn(0.0);
        when(userVocalistRepository.getAvgVocalistRankOfSomeUser(any(MUser.class))).thenReturn(0.0);

        when(userBandRepository.getCountOfMUserBand(any(MUser.class))).thenReturn(0L);
        when(userVocalistRepository.getCountOfMUserVocalist(any(MUser.class))).thenReturn(0L);

        double result = sut.getAvgGradeOfSomeUser(new MUser());
        assertEquals(0, result, 0.000001);
    }

    @Test
    public void shouldReturnOnlyVocalistsRates() {
        when(userBandRepository.getAvgBandRankOfSomeUser(any(MUser.class))).thenReturn(0.0);
        when(userVocalistRepository.getAvgVocalistRankOfSomeUser(any(MUser.class))).thenReturn(4.25);

        when(userBandRepository.getCountOfMUserBand(any(MUser.class))).thenReturn(0L);
        when(userVocalistRepository.getCountOfMUserVocalist(any(MUser.class))).thenReturn(4L);

        double result = sut.getAvgGradeOfSomeUser(new MUser());
        assertEquals(4.25, result, 0.000001);
    }
    
    @Test
    public void shouldReturnOnlyBandsRates() {
        when(userBandRepository.getAvgBandRankOfSomeUser(any(MUser.class))).thenReturn(3.25);
        when(userVocalistRepository.getAvgVocalistRankOfSomeUser(any(MUser.class))).thenReturn(0.0);

        when(userBandRepository.getCountOfMUserBand(any(MUser.class))).thenReturn(2L);
        when(userVocalistRepository.getCountOfMUserVocalist(any(MUser.class))).thenReturn(0L);

        double result = sut.getAvgGradeOfSomeUser(new MUser());
        assertEquals(3.25, result, 0.000001);
    }
}
