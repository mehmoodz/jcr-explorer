package org.jcrexplorer.core;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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

	public List<Node> excute(String queryStr, String type)
			throws RepositoryException {
		// TODO Auto-generated method stub
		QueryManager queryManager = jcrManager.workspace().getQueryManager();
		Query query = queryManager.createQuery(queryStr, type);
		QueryResult result = query.execute();
		return Utils.getNodes(result.getNodes());
	}

	public void setJcrManager(JCRManager jcrManager) {
		this.jcrManager = jcrManager;
	}

}
