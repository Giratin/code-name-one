package tn.esprit;

import com.codename1.components.ImageViewer;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.UIBuilder;
import tn.esprit.gui.Form1;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename
 * One</a> for the purpose of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    public static Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if (err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }

//        UIBuilder uib = new UIBuilder();
//        UIBuilder.registerCustomComponent("ImageViewer", ImageViewer.class);
//        Form home = (Form) uib.createContainer(theme, "GUI 1");
//        home.show();

          Form f = new Form1();
          
          f.show();


            
/*
          Form f = new Form("Hello Android", BoxLayout.y());
          
          Container cnt1 = new Container(BoxLayout.x());
          Container cnt2 = new Container(BoxLayout.xCenter());
          
          ImageViewer head = new ImageViewer(theme.getImage("head.png"));
          ImageViewer leftHand = new ImageViewer(theme.getImage("hand.png"));
          ImageViewer body = new ImageViewer(theme.getImage("body.png"));
          ImageViewer rightHand = new ImageViewer(theme.getImage("hand.png"));
          ImageViewer leftLeg = new ImageViewer(theme.getImage("leg.png"));
          ImageViewer rightLeg = new ImageViewer(theme.getImage("leg.png"));

          cnt1.addAll(leftHand, body, rightHand);
          cnt2.addAll(leftLeg, rightLeg);
          
          f.addAll(head,cnt1, cnt2);
          
          f.show();
        */  
//        Form hi = new Form("Hi World", BoxLayout.y());
//        hi.add(new Label("Hi World"));
//        hi.show();
    }

    public void stop() {
        current = getCurrentForm();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = getCurrentForm();
        }
    }

    public void destroy() {
    }

}
