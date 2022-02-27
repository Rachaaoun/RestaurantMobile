/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.restaurant.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.restaurant.entities.User;
import com.esprit.restaurant.services.UserService;

/**
 *
 * @author raoun
 */
public class AddUser extends BaseForm {
    
     Form current;
     
     
    public AddUser(Resources res) {
       
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter user");
        getContentPane().setScrollVisible(false);

        tb.addSearchCommand(e -> {
        });

       
       
      

        TextField nom = new TextField("", "nom");
        nom.setUIID("TextFieldBlack");
        addStringValue("nom", nom);

        TextField prenom = new TextField("", "prenom");
        prenom.setUIID("TextFieldBlack");
        addStringValue("prenom", prenom);

        TextField cin = new TextField("", "cin");
        cin.setUIID("TextFieldBlack");
        addStringValue("cin", cin);
        
        
        TextField password = new TextField("", "password");
        password.setUIID("TextFieldBlack");
        addStringValue("password", password);
        
        
        TextField email = new TextField("", "email");
        email.setUIID("TextFieldBlack");
        addStringValue("email", email);
        
        TextField photo = new TextField("", "photo");
        photo.setUIID("TextFieldBlack");
        addStringValue("photo", photo);

        Button btnAjouter = new Button("Ajouter");
        addStringValue("", btnAjouter);

        SpanLabel t = new SpanLabel();

        btnAjouter.addActionListener((e)
                -> {
            
            

            try {
                if (email.getText() == "" || nom.getText() == ""
                        || prenom.getText() == "") {

                    Dialog.show("Veuillez verifier les données", "", "Annuler", "OK");
                } else {
                    InfiniteProgress ip = new InfiniteProgress();;
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    User u = new User(String.valueOf(nom.getText()),String.valueOf(prenom.getText()),String.valueOf(password.getText()).toString(),String.valueOf(email.getText()).toString(),String.valueOf(cin.getText()).toString(),String.valueOf(photo.getText()).toString());
                 
                    UserService.getInstance().addUser(u);

                    iDialog.dispose();
                    refreshTheme();

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        

    }

        private void addStringValue(String s, Component v) {

        add(BorderLayout.west(new Label(s, "PaddedLabel")).add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }

    public  com.codename1.ui.Component create_Custom() {
        //return your own custom component from this method
        return new com.codename1.ui.Label("Custom Component");
    }

}
