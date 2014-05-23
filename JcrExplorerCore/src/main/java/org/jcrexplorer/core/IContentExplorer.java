package org.jcrexplorer.core;

import javax.jcr.Node;

public interface IContentExplorer {
	public Node getRoot();
	public Node childNode(Node node);
	public Node childNode(String nodeName);
	 
}
