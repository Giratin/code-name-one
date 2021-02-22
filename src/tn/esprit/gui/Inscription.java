/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.db.Cursor;
import com.codename1.db.Row;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.Main;
import tn.esprit.entities.Personne;

/**
 *
 * @author imedamri
 */
public class Inscription extends Form {

    public Inscription() {
        setLayout(BoxLayout.y());
        setTitle("Inscription");

        TextField txNom = new TextField("", "Nom");
        TextField txPrenom = new TextField("", "Prénom");
        TextField txAge = new TextField("", "Age", 1, TextField.NUMERIC);

        Button valider = new Button("Créer");

        List<Personne> personnes = new ArrayList<>();

        valider.addActionListener((evt) -> {
            try {
                Main.db.execute("INSERT INTO personne (nom,prenom,age) VALUES ('" + txNom.getText() + "','" + txPrenom.getText() + "'," + txAge.getText() + ")");
                System.out.println("Inserted");
                Cursor cr = Main.db.executeQuery("SELECT * FROM personne");
                while (cr.next()) {
                    Row row = cr.getRow();
                    int id = row.getInteger(0);
                    String nom = row.getString(1);
                    String prenom = row.getString(2);
                    Double age = row.getDouble(3);

                    Personne p = new Personne(id, nom, prenom, age);
                    personnes.add(p);
//                    System.out.println(p);
                }

//                ppersonnes.forEach((p) -> {
//                });

                for (int i = 0; i < personnes.size(); i++) {
                    System.out.println(personnes.get(i));
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });

        this.addAll(txNom, txPrenom, txAge, valider);
    }

}
