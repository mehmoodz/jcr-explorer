package org.jcrexplorer.core;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface IContentExplorer {
	public List<Node> children(Node node) throws RepositoryException;
	public List<Node> children(String path) throws RepositoryException;
	public Node getRoot() throws RepositoryException;
}
