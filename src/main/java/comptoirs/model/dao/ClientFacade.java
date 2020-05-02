/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Client;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alex
 */

public class ClientFacade extends AbstractFacade<Client> implements Serializable{

	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ClientFacade() {
		super(Client.class);
	}

    public ClientFacade(EntityManager em, Class<Client> entityClass) {
        super(entityClass);
        this.em = em;
    }
        private String userName = null;
        private String userMdp=null;

    public EntityManager getEm() {
        return em;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMdp() {
        return userMdp;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserMdp(String userMdp) {
        this.userMdp = userMdp;
    }
        public void login(String name,String mdp) {
        this.userName = name;
        this.userMdp=mdp;
    }

    public void logout() {
        this.userName = null;
        this.userMdp=null;
    }

    public boolean isConnected() {
        return userName != null;
	
	
    }
}
