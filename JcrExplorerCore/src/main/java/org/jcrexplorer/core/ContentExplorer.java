package org.jcrexplorer.core;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.springframework.beans.factory.annotation.Autowired;

public class ContentExplorer implements IContentExplorer {

	@Autowired
	private JCRManager jcrManager;

	public List<Node> children(Node node) throws RepositoryException {
		// TODO Auto-generated method stub
		return Utils.getNodes(node.getNodes());
	}

	public List<Node> children(String path) throws RepositoryException {
		// TODO Auto-generated method stub
		Node currentNode = jcrManager.currentSession().getNode(path);
		if (currentNode == null) {
			return null;
		}
		return Utils.getNodes(currentNode.getNodes());
	}

	public Node getRoot() throws RepositoryException {
		// TODO Auto-generated method stub
		return jcrManager.currentSession().getRootNode();
	}

}
