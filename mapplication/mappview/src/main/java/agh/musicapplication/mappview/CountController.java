/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Agata
 */
@Named("count")
@Scope("request")
public class CountController {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
}
