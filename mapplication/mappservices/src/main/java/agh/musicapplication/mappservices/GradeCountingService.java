/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices;

import agh.musicapplication.mappservices.interfaces.GradeCoutingServiceInterface;
import java.util.HashMap;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agatka
 */
@Service
@Transactional
public class GradeCountingService{

 
    public GradeHolder countNewGrade(int oldCount, double oldGrade, int newGrade) {
        GradeHolder holder = null;
        int c;
        double g;
        if (oldCount == 0) {
            holder = new GradeHolder(1, (double) newGrade);
        } else {
            double newValue = (oldGrade * oldCount + 1.0 * newGrade) / (double) (oldCount + 1.0);
            holder = new GradeHolder(oldCount+1, newValue);
        }
        return holder;
    }
    
    public class GradeHolder{
        private int count;
        private double grade;

        public GradeHolder(int count, double grade) {
            this.count = count;
            this.grade = grade;
        }

        
        public int getCount() {
            return count;
        }

        public double getGrade() {
            return grade;
        }
        
        
    }
}
