/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.restaurant.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import com.esprit.restaurant.entities.User;
import com.esprit.restaurant.services.UserService;
import java.util.ArrayList;

/**
 * GUI builder created Container
 *
 * @author raoun
 */
public class ListUser extends BaseForm {

    
  
       ArrayList<User> list = UserService.getInstance().getAllUsers();
            Resources res;

    public ListUser(Resources res) {

    
        setTitle("List users");

        SpanLabel sp = new SpanLabel();
        sp.setText(UserService.getInstance().getAllUsers().toString());
        add(sp);
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    
        
       
        
      
    }
////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.components.SpanLabel gui_sp = new com.codename1.components.SpanLabel();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("ListUser");
        gui_sp.setPreferredSizeStr("63.150467mm 26.283295mm");
        gui_sp.setText("Span Label");
                gui_sp.setInlineStylesTheme(resourceObjectInstance);
        gui_sp.setName("sp");
        addComponent(gui_sp);
        ((com.codename1.ui.layouts.LayeredLayout)gui_sp.getParent().getLayout()).setInsets(gui_sp, "16.923077% 40.677967% auto auto").setReferenceComponents(gui_sp, "-1 -1 -1 -1").setReferencePositions(gui_sp, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
