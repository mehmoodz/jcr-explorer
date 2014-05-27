package org.jcrexplorer.core;

import javax.jcr.RepositoryException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ContentExplorerTest extends AbstractJCRExplorerTestCase{
	@Autowired
	private IContentExplorer contentExplorer;
	
	@Test
	public void testGetRoot() throws RepositoryException{
		Assert.assertNotNull( contentExplorer.getRoot());
	}
	@Test
	public void testChildren() throws RepositoryException{
		Assert.assertNotNull( contentExplorer.children(contentExplorer.getRoot()));
	}
	@Test
	public void testNodes() throws RepositoryException{
		Assert.assertNotNull( contentExplorer.children(contentExplorer.getRoot().getPath()));
	}
	
}
