package org.jcrexplorer.core;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Workspace;

public abstract class AbstractJCRManager  implements
		IJCRManager {

	protected Repository jcrRepository;

	protected Session session = null;

	public Session login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			SimpleCredentials credentials = new SimpleCredentials(username,
					password.toCharArray());
			this.session = jcrRepository.login(credentials);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.session;
	}

	public void setJcrRepository(Repository jcrRepository) {
		this.jcrRepository = jcrRepository;
	}

	public Workspace workspace() {
		// TODO Auto-generated method stub
		return this.session.getWorkspace();
	}

	public Session currentSession() throws RepositoryException {
		// TODO Auto-generated method stub
		return this.session;
	}
	
	
 

}
