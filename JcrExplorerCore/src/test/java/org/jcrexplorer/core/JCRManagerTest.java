package org.jcrexplorer.core;

import javax.jcr.RepositoryException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for JCR Manager
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class JCRManagerTest {

	@Autowired
	private JCRManager jcrManager;

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
