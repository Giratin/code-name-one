/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import tn.esprit.Main;

/**
 *
 * @author imedamri
 */
public class Form2 extends Form {

    public Form2(String name, Form previous) {
        
        this.getToolbar().addCommandToLeftBar("Back", null, evt -> {
            previous.showBack();
        });
        
        this.setLayout(new BorderLayout());
        
        String imageName = "";
        
        if(name.toLowerCase().contains("bassem")){
            imageName = "bassem.jpg";
        }else if (name.toLowerCase().contains("sana")){
            imageName = "sana.jpg";
        }else{
            imageName = "nader.jpg";
        }
        
        
        ImageViewer img = new ImageViewer(Main.theme.getImage(imageName));
        
        Label noteLb = new Label("Note : 0");
        Slider sd = new Slider();
        
        sd.setMaxValue(10);
        sd.setMinValue(0);
        sd.setEditable(true);
        
        Container cnt = new Container(BoxLayout.y());
        
        
        sd.addDataChangedListener((type, index) -> {
            noteLb.setText("Note : " + sd.getProgress() );
        });
        
        
        Button valider = new Button("Valider");
        
        valider.addActionListener((evt) -> {
            Dialog.show("Confirmation", "Vous avez attribué un note de " + sd.getProgress() + " à M/Mme " + name , "OK", null);
        });
        
        
        cnt.addAll(noteLb, sd);
        this.add(BorderLayout.NORTH, img);
        this.add(BorderLayout.CENTER, cnt);
        this.add(BorderLayout.SOUTH, valider);
        
        
        
    }
    
}
