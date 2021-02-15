/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.UIBuilder;
import tn.esprit.MyApplication;

/**
 *
 * @author imedamri
 */
public class Form2 extends Form {
    
    private Label lb_nom, lb_prenom, lb_password, lb_date, lb_favs, lb_genre;
    
    Form2(String nom, String prenom, String dateNaissance, String pwd, String genre, String favs, Form previous){
        UIBuilder uib = new UIBuilder();
        Container cnt =  uib.createContainer(MyApplication.theme, "Form2");
        
        lb_nom = (Label) uib.findByName("nom", cnt);
        lb_prenom = (Label) uib.findByName("prenom", cnt);
        lb_password = (Label) uib.findByName("password", cnt);
        lb_genre = (Label) uib.findByName("genre", cnt);
        lb_date = (Label) uib.findByName("date", cnt);
        lb_favs = (Label) uib.findByName("favs", cnt);
        
        lb_nom.setText(lb_nom.getText() + " " + nom);
        lb_prenom.setText(lb_prenom.getText() + " " + prenom);
        lb_password.setText(lb_password.getText() + " " + pwd);
        lb_date.setText(lb_date.getText() + " " + dateNaissance);
        lb_genre.setText(lb_genre.getText() + " " + genre);
        lb_favs.setText(lb_favs.getText() + " " + favs);
        
        this.getToolbar().addCommandToLeftSideMenu("Back",null,(evt)->{
            previous.show();
            //previous.showBack();
        });
        this.getToolbar().addCommandToLeftSideMenu("Back2",null,(evt)->{
            previous.show();
            //previous.showBack();
        });
        this.getToolbar().addCommandToOverflowMenu("Revenir",null,(evt)->{
            previous.show();
            //previous.showBack();
        });
        this.getToolbar().addCommandToLeftBar("<-",null,(evt)->{
            previous.show();
            //previous.showBack();
        });
                
        this.add(cnt);
    }
    
}
