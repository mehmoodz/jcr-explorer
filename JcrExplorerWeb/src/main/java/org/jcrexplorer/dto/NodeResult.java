package org.jcrexplorer.dto;

import java.util.List;
import java.util.Map;

public class NodeResult {

	private String name;
	private String path;
	private Map<String, List<String>> properties;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, List<String>> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, List<String>> properties) {
		this.properties = properties;
	}
 


}
