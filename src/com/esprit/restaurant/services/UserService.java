/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.restaurant.services;

import com.codename1.io.CharArrayReader;
import com.esprit.restaurant.entities.User;
import java.util.ArrayList;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.restaurant.utils.Statics;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author raoun
 */
public class UserService {
   
    
    public ArrayList<User> users;
    public static UserService instance = null;
    private ConnectionRequest req;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;

    }

    public UserService() {
        req = new ConnectionRequest();
    }
    
    public ArrayList<User> parseTasks(String jsonText){
        try {
            users=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
     
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return users;
    }
    
    
    
    public void addUser(User u) {
        String url = Statics.BASE_URL + "/user/ajouter/utilisateur?nom=" + u.getNom() + "&prenom=" + u.getPrenom() + "&cin=" + u.getCin()+ "&email=" + u.getEmail()+ "&password=" + u.getPassword()+ "&photo=" +u.getPhoto();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data==" + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

    }
    
        public ArrayList<User> getAllUsers(){
        String url = Statics.BASE_URL+"/user/utilisateur/list";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }
    
}
