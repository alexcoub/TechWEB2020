/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import comptoirs.model.entity.Client;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Alex
 */
@SessionScoped
@Named("clientConnecte")
public class ClientConnecte extends Client implements Serializable {
    private Client clientC;
    

    public Client getClientC() {
        return clientC;
    }

    public void setClientC(Client clientC) {
        this.clientC = clientC;
    }
    
    public void login(Client c){
        setClientC(c);
    }
    public void logout(){
        setClientC(null);
    }
    
}
