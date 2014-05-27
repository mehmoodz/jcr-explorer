package org.jcrexplorer.core;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;

public class Utils {
	public static List<Node> getNodes(NodeIterator iterator) {
		if (iterator == null) {
			return null;
		}
		List<Node> nodeList = new ArrayList<Node>();
		while (iterator.hasNext()) {
			nodeList.add(iterator.nextNode());
		}
		return nodeList;
	}
}
