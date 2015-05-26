/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import agh.musicapplication.mappservices.interfaces.RoundingServiceInterface;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agataa
 */
@Service
@Transactional
public class RoundingService implements RoundingServiceInterface {

    @Override
    public double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
