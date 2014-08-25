package org.jcrexplorer.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;

import org.springframework.stereotype.Component;

import org.jcrexplorer.dto.value.ValueUtils;

@Component
public class NodeResponseAssembler {

	public NodeResult assemble(Node node) throws Exception {
		if (node == null) {
			return null;
		}
		NodeResult result = new NodeResult();
		result.setName(node.getName());
		result.setPath(node.getPath());
		PropertyIterator properties = node.getProperties();
		Map<String, List<String>> propertyMap = new LinkedHashMap<String, List<String>>();
		while (properties.hasNext()) {
			Property property = properties.nextProperty();
			if (property.isMultiple()) {
				propertyMap.put(property.getName(),
						ValueUtils.convert(property.getValues()));
			} else {
				propertyMap.put(property.getName(),
						Arrays.asList(ValueUtils.convert(property.getValue())));
			}
		}
		result.setProperties(propertyMap);
		return result;
	}

	public List<NodeResult> assemble(List<Node> nodeList) throws Exception {
		if (nodeList == null) {
			return null;
		}
		List<NodeResult> resultList = new ArrayList<NodeResult>();

		for (Node node : nodeList) {
			resultList.add(assemble(node));
		}
		return resultList;
	}

}
