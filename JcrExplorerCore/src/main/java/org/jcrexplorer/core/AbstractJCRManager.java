package org.jcrexplorer.core;

import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Workspace;
import javax.naming.InitialContext;

import org.springframework.dao.support.DaoSupport;

public abstract class AbstractJCRManager  implements IJCRManager {
	
	protected String repoPath;
	
	protected Session session=null;
	public Session login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			InitialContext context = new InitialContext();
			Repository repository = (Repository) context.lookup(repoPath);
			SimpleCredentials credentials = new SimpleCredentials(username,
					password.toCharArray());
			this.session = repository.login(credentials);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.session;
	}

	public Workspace workspace() {
		// TODO Auto-generated method stub
		return null;
	}

	public Session currentSession() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setRepoPath(String repoPath) {
		this.repoPath = repoPath;
	}


}
