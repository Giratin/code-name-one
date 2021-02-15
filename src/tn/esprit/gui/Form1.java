/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.components.OnOffSwitch;
import com.codename1.components.Switch;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author imedamri
 */
public class Form1 extends Form {
    
    public Form1(){
        this.setLayout(BoxLayout.y());
        this.setTitle("Inscription");
        
        TextField tf_Nom = new TextField("","Last Name");
        TextField tf_Prenom = new TextField("","First Name");
        TextField tf_Pwd = new TextField("","Password", 1 ,TextField.PASSWORD);
        
        Picker dateNaissance = new Picker();
        
        Label lb1 = new Label("Genre");
        //OnOffSwitch gender = new OnOffSwitch();
        Switch gender = new Switch();
        
        Container cnt1 = new Container(BoxLayout.x());
        cnt1.addAll(lb1,gender);
        
        
        CheckBox cb1 = new CheckBox("Foot");
        CheckBox cb2 = new CheckBox("Lecture");
        CheckBox cb3 = new CheckBox("Natation");
        CheckBox cb4 = new CheckBox("Tenis");
        
        Button validate = new Button("Valider");
        
        validate.addActionListener((evt) -> {
            String nom = tf_Nom.getText();
            String prenom = tf_Prenom.getText();
            String password = tf_Pwd.getText();
            String genre = "";
            String dateDeNaissance = dateNaissance.getText();
            
            if (gender.isOn()){
                genre = "Femme";
            }else{
                genre = "Homme";
            }
            
            String hobbies = "";
            if(cb1.isSelected()){
                hobbies += cb1.getText()+"\n";
            }
            if(cb2.isSelected()){
                hobbies += cb2.getText()+"\n";
            }
            if(cb3.isSelected()){
                hobbies += cb3.getText()+"\n";
            }
            if(cb4.isSelected()){
                hobbies += cb4.getText()+"\n";
            }
            
            Form2 f = new Form2(nom, prenom, dateDeNaissance, password, genre, hobbies, this);
            f.show();
         
        });
        
        this.addAll(tf_Nom, tf_Prenom, tf_Pwd, dateNaissance, cnt1, cb1, cb2, cb3, cb4, validate);
    }
    
}
