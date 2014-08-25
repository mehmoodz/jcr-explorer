package org.jcrexplorer.controller;

import java.util.List;

import org.jcrexplorer.core.ContentExplorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.jcrexplorer.dto.NodeResponseAssembler;
import org.jcrexplorer.dto.NodeResult;

@Controller
public class ContentExplorerController {

	@Autowired
	private ContentExplorer contentExplorer;
	@Autowired
	private NodeResponseAssembler responseAssembler;

	// Get root of the content tree
	@RequestMapping("/root")
	public @ResponseBody
	NodeResult root() throws Exception {
		return responseAssembler.assemble(contentExplorer.getRoot());
	}

	// Get children in the path
	@RequestMapping("/explore")
	public @ResponseBody
	List<NodeResult> explore(String path) throws Exception {
		if (path == null) {
			return null;
		}
		return responseAssembler.assemble(contentExplorer.children(path));
	}

	// Execute query
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody
	List<NodeResult> query(String queryStr, String type) throws Exception {
		if (queryStr == null) {
			return null;
		}
		return responseAssembler.assemble(contentExplorer
				.excute(queryStr, type));
	}

	public void setContentExplorer(ContentExplorer contentExplorer) {
		this.contentExplorer = contentExplorer;
	}

	public void setResponseAssembler(NodeResponseAssembler responseAssembler) {
		this.responseAssembler = responseAssembler;
	}
}
