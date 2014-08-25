package org.jcrexplorer.core;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentExplorer implements IContentExplorer {
	Logger logger = LoggerFactory.getLogger(ContentExplorer.class);
	@Autowired
	private JCRManager jcrManager;

	public List<Node> children(Node node) throws RepositoryException {
		// TODO Auto-generated method stub
		logger.debug("Childrent of Node:"+node);
		return Utils.getNodes(node.getNodes());
	}

	public List<Node> children(String path) throws RepositoryException {
		logger.debug("Childrent of Node:"+path);
		// TODO Auto-generated method stub
		Node currentNode = jcrManager.currentSession().getNode(path);
		if (currentNode == null) {
			return null;
		}
		return Utils.getNodes(currentNode.getNodes());
	}

	public Node getRoot() throws RepositoryException {
		// TODO Auto-generated method stub
		logger.debug("Get Root Node");
		return jcrManager.currentSession().getRootNode();
	}

	public List<Node> excute(String queryStr, String type)
			throws RepositoryException {
		logger.debug("Query:"+queryStr);
		QueryManager queryManager = jcrManager.workspace().getQueryManager();
		Query query = queryManager.createQuery(queryStr, type);
		QueryResult result = query.execute();
		return Utils.getNodes(result.getNodes());
	}

	public void setJcrManager(JCRManager jcrManager) {
		this.jcrManager = jcrManager;
	}

}
