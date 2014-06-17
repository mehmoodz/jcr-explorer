var contextUrl = $(location).attr('href');
if (contextUrl.indexOf('.html') != -1) {
	contextUrl = contextUrl.substring(0, contextUrl.lastIndexOf('/') + 1);
}
var tree = null;
var executeBtn = Ladda.create(document.querySelector('#executeQuery'));

$(function() {
	$('#explorerNav').resizable();
	$('#page-wrapper').resizable();
	tree = $('#explorer');
	makeRequest(contextUrl + "/services/explore?path=/");
	tree.bind('tree.click', function(event) {
		$('#loading').show();
		var node = event.node;
		makeRequest(contextUrl + "/services/explore?path=" + node.id, node);
		$('.currentPage').html(node.id);

	});
});

function makeRequest(url, node) {

	$.getJSON(url, function(data) {
		if (!data) {
			return;
		}
		updateTree(transform(data), node);
		$('#loading').hide();
	});
}
function updateTree(data, parent_node) {

	if (tree.tree('getTree')) {
		tree.tree('loadData', data, parent_node);
	} else {
		initTree(data);
	}
	if (parent_node && parent_node.type == 'nt:folder') {
		tree.tree('openNode', parent_node);
	}
}
function initTree(data) {
	tree.tree({
		data : data
	});
}

function transform(data) {
	treeModel = [];
	if (data.length) {
		$.each(data, function(index, node) {
			if (node.name == 'jcr:content') {
				displayContent(node);
				return;
			}
			buildModel(treeModel, node);
		});
	} else { // if single node
		buildModel(treeModel, data);
	}
	return treeModel;
}

function displayContent(node) {
	if (node.properties && node.properties['jcr:data']) {
		$('#jcrContent').text(vkbeautify.xml(node.properties['jcr:data'][0]))
				.html();
		$('#nodeDetailsTab').tab('show');
	}
	$('pre code').each(function(i, e) {
		hljs.highlightBlock(e)
	});
}

function buildModel(treeModel, data) {
	if (data) {
		if (!data.name || data.name == '') {
			data.name = data.path;
		}
		if (!data.name) {
			return;
		}
		treeModel.push({
			label : data.name,
			id : data.path,
			type : (data.properties) ? data.properties['jcr:primaryType'][0]
					: ''
		});
	}
}

$('#executeQuery').click(
		function() {
			executeBtn.start();
			$.getJSON(contextUrl + "/services/query?queryStr="
					+ $('#queryTxt').val() + "&type="
					+ $('#jcrQueryType').val(), function(data) {
				$('#queryPanel').show();
				if (!data) {
					executeBtn.stop();
					return;
				}
				$('#queryStatus').html(
						'<div class="alert alert-success">' + data.length
								+ ' Result(s) Found!</div>');
				$('#queryResults').html('');
				updateResults(data);
				executeBtn.stop();
			});

		});

function updateResults(data) {
	if (data.length) {
		var i = 1;
		$.each(data, function(index, node) {
			$('#queryResults').append(
					'<tr><td>' + (i++) + '</td><td>' + node.name + '</td><td>'
							+ node.path + '</td></tr>');
		});

	}
}

// global vars
var winWidth = $(window).width();
var winHeight = $(window).height();

// set initial div height / width
$('#explorer').css({
	'height' : winHeight,
	'overflow' : 'auto'
});

$('#query').css({
	'height' : winHeight,
	'overflow' : 'auto'
});

// make sure div stays full width/height on resize
$(window).resize(function() {
	$('#explorer').css({
		'height' : winHeight,
		'overflow' : 'auto'
	});

	$('#query').css({
		'height' : winHeight,
		'overflow' : 'auto'
	});
});
