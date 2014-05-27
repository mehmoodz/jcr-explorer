package org.jcrexplorer.core;

import javax.jcr.RepositoryException;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Unit test for JCR Manager
 */

public class JCRManagerTest extends AbstractJCRExplorerTestCase{

	@Autowired
	private IJCRManager jcrManager;

	@org.junit.Test
	public void testLogin() throws RepositoryException {
		Assert.assertNotNull(jcrManager.login("admin", "admin"));
	}
	
	@org.junit.Test
	public void testSession() throws RepositoryException {
		Assert.assertNotNull(jcrManager.currentSession());
	}

	@org.junit.Test
	public void testWorkspace() throws RepositoryException {
		Assert.assertNotNull(jcrManager.workspace());
	}

}
