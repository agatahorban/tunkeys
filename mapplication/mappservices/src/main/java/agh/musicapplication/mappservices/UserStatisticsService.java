package agh.musicapplication.mappservices;

import agh.musicapplication.mappdao.interfaces.MUserBandRepositoryInterface;
import agh.musicapplication.mappdao.interfaces.MUserVocalistRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import agh.musicapplication.mappservices.interfaces.RoundingServiceInterface;
import agh.musicapplication.mappservices.interfaces.UserStatisticsServiceInterface;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agata
 */
@Service
@Transactional
public class UserStatisticsService implements UserStatisticsServiceInterface {

    @Inject
    RoundingServiceInterface roundingService;

    @Inject
    MUserBandRepositoryInterface userBandRepository;

    @Inject
    MUserVocalistRepositoryInterface userVocalistRepository;

    @Override
    public long getAmountOfBandsRatedByUser(MUser u) {
        return userBandRepository.getCountOfMUserBand(u);
    }

    @Override
    public long getAmountOfVocalistsRatedByUser(MUser u) {
        return userVocalistRepository.getCountOfMUserVocalist(u);
    }

    @Override
    public double getAvgGradeOfSomeUser(MUser u) {
        double bandrank = 0.0, vocalrank = 0.0;
        if (userBandRepository.getAvgBandRankOfSomeUser(u) != null) {
            bandrank = userBandRepository.getAvgBandRankOfSomeUser(u);
        }
        if (userVocalistRepository.getAvgVocalistRankOfSomeUser(u) != null) {
            vocalrank = userVocalistRepository.getAvgVocalistRankOfSomeUser(u);
        }
        double sum = bandrank + vocalrank;
        return roundingService.round(sum, 2);
    }

}
