var start = "START";
var end = "END";
var TinyMCE_EclipseBasePlugin = {
	
	/**
	 * Returns information about the plugin as a name/value array.
	 * The current keys are longname, author, authorurl, infourl and version.
	 *
	 * @returns Name/value array containing information about the plugin.
	 * @type Array 
	 */
	getInfo : function() {
		return {
			longname : 'Tom Seidel - Spirit Link GmbH',
			author : 'tmseidel',
			authorurl : 'http://www.richclient2.eu',
			infourl : 'http://www.richclient2.eu/richtml4eclipse',
			version : "1.0"
		};
	},

	/**
	 * Gets executed when a TinyMCE editor instance is initialized.
	 *
	 * @param {TinyMCE_Control} Initialized TinyMCE editor control instance. 
	 */
	initInstance : function(inst) {
	},

	/**
	 * Returns the HTML code for a specific control or empty string if this plugin doesn't have that control.
	 * A control can be a button, select list or any other HTML item to present in the TinyMCE user interface.
	 * The variable {$editor_id} will be replaced with the current editor instance id and {$pluginurl} will be replaced
	 * with the URL of the plugin. Language variables such as {$lang_somekey} will also be replaced with contents from
	 * the language packs.
	 *
	 * @param {string} cn Editor control/button name to get HTML for.
	 * @return HTML code for a specific control or empty string.
	 * @type string
	 */
	getControlHTML : function(cn) {},


	/**
	 * Executes a specific command, this function handles plugin commands.
	 *
	 * @param {string} editor_id TinyMCE editor instance id that issued the command.
	 * @param {HTMLElement} element Body or root element for the editor instance.
	 * @param {string} command Command name to be executed.
	 * @param {string} user_interface True/false if a user interface should be presented.
	 * @param {mixed} value Custom value argument, can be anything.
	 * @return true/false if the command was executed by this plugin or not.
	 * @type
	 */
	execCommand : function(editor_id, element, command, user_interface, value) {
		
		
	},

	/**
	 * Gets called ones the cursor/selection in a TinyMCE instance changes. This is useful to enable/disable
	 * button controls depending on where the user are and what they have selected. This method gets executed
	 * alot and should be as performance tuned as possible.
	 *
	 * @param {string} editor_id TinyMCE editor instance id that was changed.
	 * @param {HTMLNode} node Current node location, where the cursor is in the DOM tree.
	 * @param {int} undo_index The current undo index, if this is -1 custom undo/redo is disabled.
	 * @param {int} undo_levels The current undo levels, if this is -1 custom undo/redo is disabled.
	 * @param {boolean} visual_aid Is visual aids enabled/disabled ex: dotted lines on tables.
	 * @param {boolean} any_selection Is there any selection at all or is there only a cursor.
	 */
	handleNodeChange : function(editor_id, node, undo_index, undo_levels, visual_aid, any_selection, setup_content) {
		var alignNode, breakOut, classNode;

		function selectByValue(select_elm, value, first_index) {
			first_index = typeof(first_index) == "undefined" ? false : true;

			if (select_elm) {
				for (var i=0; i<select_elm.options.length; i++) {
					var ov = "" + select_elm.options[i].value;

					if (first_index && ov.toLowerCase().indexOf(value.toLowerCase()) == 0) {
						select_elm.selectedIndex = i;
						return true;
					}

					if (ov == value) {
						select_elm.selectedIndex = i;
						return true;
					}
				}
			}

			return false;
		};

		function getAttrib(elm, name) {
			return elm.getAttribute(name) ? elm.getAttribute(name) : "";
		};

		// No node provided
		if (node == null)
			return;

		// Update path
		var pathElm = document.getElementById(editor_id + "_path");
		var inst = tinyMCE.getInstanceById(editor_id);
		var doc = inst.getDoc();
		TinyMCE_AdvancedTheme._hideMenus(editor_id);

		if (pathElm) {
			// Get node path
			var parentNode = node;
			var path = new Array();
			
			while (parentNode != null) {
				if (parentNode.nodeName.toUpperCase() == "BODY") {
					break;
				}

				// Only append element nodes to path
				if (parentNode.nodeType == 1 && tinyMCE.getAttrib(parentNode, "class").indexOf('mceItemHidden') == -1) {
					path[path.length] = parentNode;
				}

				parentNode = parentNode.parentNode;
			}

			// Setup HTML
			var html = "";
			for (var i=path.length-1; i>=0; i--) {
				var nodeName = path[i].nodeName.toLowerCase();
				var nodeData = "";

				if (nodeName.indexOf("html:") == 0)
					nodeName = nodeName.substring(5);

				if (nodeName == "b") {
					nodeName = "strong";
				}

				if (nodeName == "i") {
					nodeName = "em";
				}

				if (nodeName == "span") {
					var cn = tinyMCE.getAttrib(path[i], "class");
					if (cn != "" && cn.indexOf('mceItem') == -1)
						nodeData += "class: " + cn + " ";

					var st = tinyMCE.getAttrib(path[i], "style");
					if (st != "") {
						st = tinyMCE.serializeStyle(tinyMCE.parseStyle(st));
						nodeData += "style: " + st + " ";
					}
				}

				if (nodeName == "font") {
					if (tinyMCE.getParam("convert_fonts_to_spans"))
						nodeName = "span";

					var face = tinyMCE.getAttrib(path[i], "face");
					if (face != "")
						nodeData += "font: " + face + " ";

					var size = tinyMCE.getAttrib(path[i], "size");
					if (size != "")
						nodeData += "size: " + size + " ";

					var color = tinyMCE.getAttrib(path[i], "color");
					if (color != "")
						nodeData += "color: " + color + " ";
				}

				if (getAttrib(path[i], 'id') != "") {
					nodeData += "id: " + path[i].getAttribute('id') + " ";
				}

				var className = tinyMCE.getVisualAidClass(tinyMCE.getAttrib(path[i], "class"), false);
				if (className != "" && className.indexOf('mceItem') == -1)
					nodeData += "class: " + className + " ";

				if (getAttrib(path[i], 'src') != "") {
					var src = tinyMCE.getAttrib(path[i], "mce_src");

					if (src == "")
						 src = tinyMCE.getAttrib(path[i], "src");

					nodeData += "src: " + src + " ";
				}

				if (path[i].nodeName == 'A' && getAttrib(path[i], 'href') != "") {
					var href = tinyMCE.getAttrib(path[i], "mce_href");

					if (href == "")
						 href = tinyMCE.getAttrib(path[i], "href");

					nodeData += "href: " + href + " ";
				}

				className = tinyMCE.getAttrib(path[i], "class");
				if ((nodeName == "img" || nodeName == "span") && className.indexOf('mceItem') != -1) {
					nodeName = className.replace(/mceItem([a-z]+)/gi, '$1').toLowerCase();
					nodeData = path[i].getAttribute('title');
				}

				if (nodeName == "a" && (anchor = tinyMCE.getAttrib(path[i], "name")) != "") {
					nodeName = "a";
					nodeName += "#" + anchor;
					nodeData = "";
				}

				if (getAttrib(path[i], 'name').indexOf("mce_") != 0) {
					var className = tinyMCE.getVisualAidClass(tinyMCE.getAttrib(path[i], "class"), false);
					if (className != "" && className.indexOf('mceItem') == -1) {
						nodeName += "." + className;
					}
				}

				var cmd = 'tinyMCE.execInstanceCommand(\'' + editor_id + '\',\'mceSelectNodeDepth\',false,\'' + i + '\');';
				html += '<a title="' + nodeData + '" href="javascript:' + cmd + '" onclick="' + cmd + 'return false;" onmousedown="return false;" target="_self" class="mcePathItem">' + nodeName + '</a>';

				if (i > 0) {
					html += " &raquo; ";
				}
			}

			pathElm.innerHTML = '<a href="#" accesskey="x"></a>' + tinyMCE.getLang('lang_theme_path') + ": " + html + '&#160;';
		}

		// Reset old states
		window.status = "0:" + start;
		window.status = "command:resetAll";
		
		
		var selection;
		if (tinyMCE.isMSIE) {
			selection = inst.getRng();
        }
        else {
            selection = inst.getSel();
        }	
		window.status = "31:" + start;
		window.status = "value:" + selection.text;

		if (node.nodeName == "A" && tinyMCE.getAttrib(node, "class").indexOf('mceItemAnchor') != -1) {
			window.status="1:" + start
			window.status="name:" + tinyMCE.getAttrib(node,"name");
		}

		// Get link
		var anchorLink = tinyMCE.getParentElement(node, "a", "href");

		if (anchorLink || any_selection) {
		
			window.status = "2:" + start;
			if (anchorLink) {
				window.status = "status:selected";
				window.status = "href:" + tinyMCE.getAttrib(anchorLink,"href");
				window.status = "target:" + tinyMCE.getAttrib(anchorLink,"target");
				window.status = "title:" + tinyMCE.getAttrib(anchorLink,"title");
				window.status = "class:" + tinyMCE.getAttrib(anchorLink,"class");
			} else {
				window.status="status:normal";
			}
			window.status = "3:" + start;
			anchorLink ? window.status = "status:selected" : window.status="status:normal";

		}

		// Handle visual aid
		window.status = "4:" + start;
		visual_aid ? window.status="status:selected" : window.status="status:normal";
		if (undo_levels != -1) {
			window.status = "5:" + start;
			window.status="status:disabled";
			window.status = "6:" + start;
			window.status="status:disabled";
		}

		// Within li, blockquote
			window.status="7:" + start;
		if (tinyMCE.getParentElement(node, "li,blockquote")) {
			window.status="status:normal";
		} else {
			window.status="status:disabled";
		}

		// Has redo levels
		if (undo_index != -1 && (undo_index < undo_levels-1 && undo_levels > 0)) {
			window.status="6:" + start;
			window.status="status:normal";
		}

		// Has undo levels
		if (undo_index != -1 && (undo_index > 0 && undo_levels > 0)) {			
			window.status="5:" + start;
			window.status="status:normal";
		}

		// Select class in select box
		var selectElm = document.getElementById(editor_id + "_styleSelect");
		
		if (selectElm) {
			TinyMCE_AdvancedTheme._setupCSSClasses(editor_id);

			classNode = node;
			breakOut = false;
			var index = 0;

			do {
				if (classNode && classNode.className) {
					for (var i=0; i<selectElm.options.length; i++) {
						if (selectElm.options[i].value == classNode.className) {
							index = i;
							breakOut = true;
							break;
						}
					}
				}
			} while (!breakOut && classNode != null && (classNode = classNode.parentNode) != null);

			selectElm.selectedIndex = index;
		}

		// Select formatblock
		
			var elm = tinyMCE.getParentElement(node, "p,div,h1,h2,h3,h4,h5,h6,pre,address");
			window.status="22:" + start;
			if (elm) {
				window.status="status:normal";
				window.status="value:" + elm.nodeName.toLowerCase();
			} else {
				window.status="status:undefined";
			}

		// Select fontselect
			window.status="23:" + start;
			if (!tinyMCE.isSafari && !(tinyMCE.isMSIE && !tinyMCE.isOpera)) {
				var face = inst.queryCommandValue('FontName');
				if (face == null || face == "") {
					window.status="value:undefined";
				} else {
					window.status="value:" + face;
				}
				
			} else {
				var elm = tinyMCE.getParentElement(node, "font", "face");

				if (elm) {
					var family = tinyMCE.getAttrib(elm, "face");

					if (family == '')
						family = '' + elm.style.fontFamily;

					if (family == null || family == "") {
						window.status="value:undefined";
					} else {
						window.status="value:" + family;
					}
						
				} else
					window.status="value:undefined";
			}
			window.status="25:" + start;
			var elm = tinyMCE.getParentElement(node, "font", "color");
			if (elm) {
				var color = tinyMCE.getAttrib(elm, "color");

				if (color == '')
					color = '' + elm.style.color;

				if (color == null || color == "") {
					window.status="value:undefined";
				} else {
					window.status="value:" + color;
				}
					
			} else
				window.status="value:undefined";
				
			window.status="26:" + start;
			elm = tinyMCE.getParentElement(node, "font");
			if (elm) {
				var backcolor = tinyMCE.getAttrib(elm, "backcolor");

				if (backcolor == '')
					backcolor = '' + elm.style.backgroundColor;

				if (backcolor == null || backcolor == "") {
					window.status="value:undefined";
				} else {
					window.status="value:" + backcolor;
				}
					
			} else
				window.status="value:undefined";
		

		// Select fontsize
			window.status="24:" + start;
			if (!tinyMCE.isSafari && !tinyMCE.isOpera) {
				var size = inst.queryCommandValue('FontSize');
				if (size == null || size == "") {
					window.status="value:undefined";
				} else {
					window.status="value:" + size;
				}
			} else {
				var elm = tinyMCE.getParentElement(node, "font", "size");
				if (elm) {
					var size = tinyMCE.getAttrib(elm, "size");

					if (size == '') {
						var sizes = new Array('', '8px', '10px', '12px', '14px', '18px', '24px', '36px');

						size = '' + elm.style.fontSize;

						for (var i=0; i<sizes.length; i++) {
							if (('' + sizes[i]) == size) {
								size = i;
								break;
							}
						}
					}
					if (size == 0) {
						window.status="value:undefined";
					} else {
						window.status="value:" + size;
					}
				} else {
					window.status="value:undefined";
				}
			}
		

		// Handle align attributes
		alignNode = node;
		breakOut = false;
		do {
			if (!alignNode.getAttribute || !alignNode.getAttribute('align'))
				continue;

			switch (alignNode.getAttribute('align').toLowerCase()) {
				case "left":
					window.status="8:" + start;
					window.status="status:selected";
					breakOut = true;
				break;

				case "right":
					window.status="9:" + start;
					window.status="status:selected";
					breakOut = true;
				break;

				case "middle":
				case "center":
					window.status="10:" + start;
					window.status="status:selected";
					breakOut = true;
				break;

				case "justify":
					window.status="11:" + start;
					window.status="status:selected";
					breakOut = true;
				break;
			}
		} while (!breakOut && (alignNode = alignNode.parentNode) != null);
			
		// Div justification
		
		var div = tinyMCE.getParentElement(node, "div");
		
		if (div && div.style.textAlign == "center"){
			window.status="10:" + start;
			window.status="status:selected";
		}
		// Do special text
		if (!setup_content) {
			// , "JustifyLeft", "_justifyleft", "JustifyCenter", "justifycenter", "JustifyRight", "justifyright", "JustifyFull", "justifyfull", "InsertUnorderedList", "bullist", "InsertOrderedList", "numlist", "InsertUnorderedList", "bullist", "Outdent", "outdent", "Indent", "indent", "subscript", "sub"
			var ar = new Array("Bold", "12", "Italic", "13", "Strikethrough", "14", "superscript", "15", "subscript", "16");
			for (var i=0; i<ar.length; i+=2) {
				if (inst.queryCommandState(ar[i])) { 
					window.status= ar[i+1] + ":" + start;
					window.status= "status:selected";
				}
			}

			if (inst.queryCommandState("Underline") && (node.parentNode == null || node.nodeName.toUpperCase() != "A")) {
					window.status="17:" + start;
					window.status="status:selected";
			}
		}

		// Handle elements
		
		do {
			switch (node.nodeName.toUpperCase()) {
				case "UL":
					window.status="18:" + start;
					window.status="status:selected";
				break;

				case "OL":
					window.status="19:" + start;
					window.status="status:selected";
				break;

				case "HR":
					window.status="20:" + start;
					window.status="status:selected";
				break;

				case "IMG":
				if (getAttrib(node, 'name').indexOf('mce_') != 0 && tinyMCE.getAttrib(node, 'class').indexOf('mceItem') == -1) {
					window.status="21:" + start;
					window.status="status:selected";
					window.status="src:" + tinyMCE.getAttrib(node,'src');
					window.status="width:" + tinyMCE.getAttrib(node,'width');
					window.status="height:" + tinyMCE.getAttrib(node,'height');
					window.status="border:" + tinyMCE.getAttrib(node,'border');
					window.status="alt:" + tinyMCE.getAttrib(node,'alt');
					window.status="align:" + tinyMCE.getAttrib(node,'align');
					window.status="hspace:" + tinyMCE.getAttrib(node,'hspace');
					window.status="vspace:" + tinyMCE.getAttrib(node,'vspace');
				}
				break;
			}
			window.status="0:eof";
		} while ((node = node.parentNode) != null);
	},

	/**
	 * Gets called when a TinyMCE editor instance gets filled with content on startup.
	 *
	 * @param {string} editor_id TinyMCE editor instance id that was filled with content.
	 * @param {HTMLElement} body HTML body element of editor instance.
	 * @param {HTMLDocument} doc HTML document instance.
	 */
	setupContent : function(editor_id, body, doc) {
	},

	/**
	 * Gets called when the contents of a TinyMCE area is modified, in other words when a undo level is
	 * added.
	 *
	 * @param {TinyMCE_Control} inst TinyMCE editor area control instance that got modified.
	 */
	onChange : function(inst) {
	},

	/**
	 * Gets called when TinyMCE handles events such as keydown, mousedown etc. TinyMCE
	 * doesn't listen on all types of events so custom event handling may be required for
	 * some purposes.
	 *
	 * @param {Event} e HTML editor event reference.
	 * @return true - pass to next handler in chain, false - stop chain execution
	 * @type boolean
	 */
	handleEvent : function(e) {
		return true;
	},

	/**
	 * Gets called when HTML contents is inserted or retrived from a TinyMCE editor instance.
	 * The type parameter contains what type of event that was performed and what format the content is in.
	 * Possible valuses for type is get_from_editor, insert_to_editor, get_from_editor_dom, insert_to_editor_dom.
	 *
	 * @param {string} type Cleanup event type.
	 * @param {mixed} content Editor contents that gets inserted/extracted can be a string or DOM element.
	 * @param {TinyMCE_Control} inst TinyMCE editor instance control that performes the cleanup.
	 * @return New content or the input content depending on action.
	 * @type string
	 */
	cleanup : function(type, content, inst) {
		return content;
	}

};

// Adds the plugin class to the list of available TinyMCE plugins
tinyMCE.addPlugin("eclipsebase", TinyMCE_EclipseBasePlugin);