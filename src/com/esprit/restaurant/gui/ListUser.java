/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.restaurant.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import com.esprit.restaurant.entities.User;
import com.esprit.restaurant.services.UserService;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 * GUI builder created Form
 *
 * @author raoun
 */
public class ListUser extends BaseForm {

    private Resources theme;
    Form current;
        public ListUser(Resources res) {
        setTitle("List users");
 ArrayList<User> list =UserService.getInstance().getAllUsers();
        for(int i =0;i<list.size();i++){
        SpanLabel sp = new SpanLabel();
        
        sp.setText("User numero  "+ i +":  Cin :" + list.get(i).getCin()+ "Nom:" + list.get(i).getNom());
        add(sp);}
        
        Button btnAddUser = new Button("Add User");
          btnAddUser.addActionListener(e-> new AddUser(theme).show());
          add(btnAddUser);
    }
 

////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ListUser");
        setName("ListUser");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
