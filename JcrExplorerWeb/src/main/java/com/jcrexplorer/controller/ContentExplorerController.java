package com.jcrexplorer.controller;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.jcrexplorer.core.ContentExplorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentExplorerController {

	@Autowired
	private ContentExplorer contentExplorer;

	// Get root of the content tree
	@RequestMapping("/root")
	public @ResponseBody
	Node root() throws RepositoryException {
		return contentExplorer.getRoot();
	}

	// Get children in the path
	@RequestMapping("/explore/{path}")
	public @ResponseBody
	List<Node> explore(@PathVariable String path) throws RepositoryException {
		if (path == null) {
			return null;
		}
		return contentExplorer.children(path);
	}

	// Execute query
	@RequestMapping(value = "/explore", method = RequestMethod.GET)
	public @ResponseBody
	List<Node> query(String queryStr, String type) throws RepositoryException {
		if (queryStr == null) {
			return null;
		}
		return contentExplorer.excute(queryStr, type);
	}
}
