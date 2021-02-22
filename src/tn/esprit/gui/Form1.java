/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.ui.ComboBox;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author imedamri
 */
public class Form1 extends Form {
    public Form1(){
        setLayout(new FlowLayout(CENTER,CENTER));
        setTitle("Teacher Eval");
        
        ComboBox<String> cb = new ComboBox<>();
        cb.addItem("Nader Rahman");
        cb.addItem("Sana Ben Fadhel");
        cb.addItem("Bassem Hatira");
        
        cb.addActionListener((evt) -> {
            Form f = new Form2(cb.getSelectedItem().toString(), this);
            f.show();
        });
        
       
        this.add(cb);                        
    }
}
