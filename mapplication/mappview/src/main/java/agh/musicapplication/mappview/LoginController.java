/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappview;

/**
 *
 * @author Agata
 */
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginController {
 
  @RequestMapping(value="/login", method = RequestMethod.GET)
  public String printUser(ModelMap model) {
 
      User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      String name = user.getUsername(); //get logged in username
 
      model.addAttribute("username", name);
      return "hello";
 
  }
  
}
