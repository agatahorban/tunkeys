/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappservices.interfaces;

import agh.musicapplication.mappservices.GradeCountingService;

/**
 *
 * @author Agata
 */
public interface GradeCoutingServiceInterface {
    public GradeCountingService.GradeHolder countNewGrade(int oldCount, double oldGrade, int newGrade);
}
