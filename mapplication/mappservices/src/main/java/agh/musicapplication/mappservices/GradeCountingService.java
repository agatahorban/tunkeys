/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Scope;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agatka
 */
@Service
@Transactional
public class GradeCountingService {
    public Map<Integer,Double> countNewGrade(int oldCount, double oldGrade, int newGrade){
        Map<Integer, Double> map = new HashMap<>();
        double newValue = oldGrade * oldCount + 1.0 * newGrade;
        map.put(oldCount+1, newValue);
        return map;
    }
}