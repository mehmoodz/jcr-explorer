package org.jcrexplorer.core;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

public class JCRManager extends AbstractJCRManager {

	public JCRManager(Repository repository,String username, String password) {
		// TODO Auto-generated constructor stub
		this.jcrRepository=repository;
		super.login(username, password);
	}

	@Override
	public Session currentSession() throws RepositoryException {
		// TODO Auto-generated method stub
		return super.session;
	}

}
