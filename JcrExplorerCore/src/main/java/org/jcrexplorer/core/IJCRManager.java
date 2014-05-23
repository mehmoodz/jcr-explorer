package org.jcrexplorer.core;

import javax.jcr.Session;
import javax.jcr.Workspace;

public interface IJCRManager {
	public Session login(String username,String password);
	public Workspace workspace();
	public Session currentSession();
}
