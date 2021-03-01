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
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.util.List;
import tn.esprit.Main;
import tn.esprit.entities.Serie;
import tn.esprit.entities.Utils;

/**
 *
 * @author imedamri
 */
public class ListSerieForm extends Form {

    public ListSerieForm() {
        setTitle("Liste des séries");
        setLayout(BoxLayout.y());

        List<Serie> series = Utils.getList();
        for (int i = 0; i < series.size(); i++) {
            System.out.println(series.get(i));
            add(addSerieHolder(series.get(i)));
        }

    }

    public Container addSerieHolder(Serie serie) {

        try {
            Container holder = new Container(BoxLayout.x());
            Container details = new Container(BoxLayout.y());
            Container titleDuree = new Container(BoxLayout.x());

            ImageViewer image = new ImageViewer(Main.theme.getImage(serie.getImage()).scaled(250, 350));
            Label lbTitle = new Label(serie.getTitle());

            // String duree = serie.getDuree()+ "";
            // String duree = String.valueOf(serie.getDuree());
            Label lbDuration = new Label(String.valueOf(serie.getDuree()));
            Label lbDescription = new Label(serie.getDescription());

            //Button lbDescription = new Button("CLICK ME");
            //lbDescription.addActionListener((evt) -> {
            //    Dialog.show(serie.getTitle() , serie.getDescription(), "OK", null);
            //});
            
            lbTitle.addPointerReleasedListener((evt) -> {
                Dialog.show(serie.getTitle() , serie.getDescription(), "OK", null);
            });
            
            titleDuree.addAll(lbTitle, lbDuration);
            details.addAll(titleDuree, lbDescription);
            holder.addAll(image, details);

            holder.setLeadComponent(lbTitle); 
            
            return holder;

        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            return new Container(BoxLayout.x());
        }

    }

}
