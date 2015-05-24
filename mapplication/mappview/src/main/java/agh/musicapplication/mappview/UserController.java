/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agata
 */

@Named("existinguser")
@Scope("request")
@Transactional
public class UserController {
    
}
