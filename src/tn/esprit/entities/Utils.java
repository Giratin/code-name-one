/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author imedamri
 */
public class Utils {
    
    public static List<Serie> getList(){
        
        List<Serie> series = new ArrayList<>();
        
        series.add(new Serie(0, 100, "The 100", "Description 100", "100.png"));
        series.add(new Serie(1, 60, "Breaking Bad", "Description Breaking Bad", "breakingbad.jpg"));
        series.add(new Serie(2, 60, "Dark", "Description Dark", "dark.jpg"));
        series.add(new Serie(3, 60, "Game Of Thrones", "Description GOT", "got.jpg"));
        series.add(new Serie(4, 60, "Lucifer", "Description Lucifer", "lucifer.jpg"));
        series.add(new Serie(5, 60, "Mr. Robot", "Description Mr. Robot", "mrrobot.jpg"));
        series.add(new Serie(6, 60, "Stranger Things", "Description Stranger Things", "strangerthings.jpg"));
        series.add(new Serie(7, 60, "Travelers", "Description Travlers", "Travelers.png"));
        series.add(new Serie(8, 60, "Walking Dead", "Description Walking Dead", "walkingdead.png"));
        series.add(new Serie(9, 60, "The Witcher", "Description The Witcher", "witcher.jpg"));
        
        return series;
    }
    
}
