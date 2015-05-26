/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices.interfaces;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Agata
 */
public interface RoundingServiceInterface {
    public double round(double value, int places);
}
