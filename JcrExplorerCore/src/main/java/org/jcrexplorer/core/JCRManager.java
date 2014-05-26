package org.jcrexplorer.core;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

public class JCRManager extends AbstractJCRManager{
	
	 @Override
	public Session currentSession() throws RepositoryException {
		// TODO Auto-generated method stub
		return super.session;
	}
	 
	
}
