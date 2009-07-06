
function _bridge_insertAnchor(newAnchorName) {
	var action, element;
	
	var inst = tinyMCE.getInstanceById('mce_editor_0');
	var anchor = tinyMCE.getParentElement(inst.getFocusElement(), "a", "name");
	var img = inst.getFocusElement();
	action = 'insert';

	if (anchor != null) {
		element = anchor;
		action = "update";
	}

	if (tinyMCE.getAttrib(img, "class") == "mceItemAnchor") {
		element = img;
		action = "update";
	}
	
	var name = newAnchorName;

	tinyMCE.execCommand("mceBeginUndoLevel");

	if (action == "update") {
		if (element.nodeName == "IMG")
			element.setAttribute("title", name);
		else
			element.setAttribute("name", name);
	} else {
		var rng = inst.getRng();

		if (rng.collapse)
			rng.collapse(false);

		name = name.replace(/&/g, '&amp;');
		name = name.replace(/\"/g, '&quot;');
		name = name.replace(/</g, '&lt;');
		name = name.replace(/>/g, '&gt;');

		// Fix for bug #1447335
		if (tinyMCE.isGecko)
			html = '<a id="mceNewAnchor" name="' + name + '"></a>';
		else
			html = '<a name="' + name + '"></a>';

		tinyMCE.execCommand("mceInsertContent", false, html);

		// Fix for bug #1447335 force cursor after the anchor element
		if (tinyMCE.isGecko) {
			e = inst.getDoc().getElementById('mceNewAnchor');

			if (e) {
				inst.selection.selectNode(e, true, false, false);
				e.removeAttribute('id');
			}
		}

		tinyMCE.handleVisualAid(inst.getBody(), true, inst.visualAid, inst);
	}
	tinyMCE.execCommand("mceEndUndoLevel");
	tinyMCE.triggerNodeChange();
}

function _bridgeInsertEditTable(_cellPadding, _cellSpacing, _border, _align, _class, _style, _id) {
	
	var inst = tinyMCE.getInstanceById('mce_editor_0');
	var elm = tinyMCE.getParentElement(inst.getFocusElement(), "table");
	var update = elm != null ? true : false;
	inst.getWin().focus();
	if (inst.selectionBookmark)
		inst.selection.moveToBookmark(inst.selectionBookmark);

	if (update) {
		inst.execCommand('mceBeginUndoLevel');
		//alert("TEST");
		tinyMCE.setAttrib(elm, 'cellPadding', _cellPadding, true);
		tinyMCE.setAttrib(elm, 'cellSpacing', _cellSpacing, true);
		tinyMCE.setAttrib(elm, 'border', _border, true);
		tinyMCE.setAttrib(elm, 'align', _align);
		tinyMCE.setAttrib(elm, 'class', _class);
		tinyMCE.setAttrib(elm, 'style', _style);
		//appendStyleAttributes(elm,_style);
		tinyMCE.setAttrib(elm, 'id', _id);
		
		// Remove these since they are not valid XHTML
		tinyMCE.setAttrib(elm, 'borderColor', '');
		tinyMCE.setAttrib(elm, 'bgColor', '');
		tinyMCE.setAttrib(elm, 'background', '');
		tinyMCE.setAttrib(elm, 'height', '');
		
		tinyMCE.handleVisualAid(elm, false, inst.visualAid, inst);

		// Fix for stange MSIE align bug
		elm.outerHTML = elm.outerHTML;

		tinyMCE.handleVisualAid(inst.getBody(), true, inst.visualAid, inst);
		tinyMCE.triggerNodeChange();
		inst.execCommand('mceEndUndoLevel');
		inst.repaint();
	} else {
		
		// Create new table
		var html = '<table';
		html += makeAttrib('id', _id);
		html += makeAttrib('border', _border);
		html += makeAttrib('cellpadding', _cellPadding);
		html += makeAttrib('cellspacing', _cellSpacing);
		html += makeAttrib('align', _align);
		html += makeAttrib('style', _style);
		html += makeAttrib('class', tinyMCE.getVisualAidClass(_class, _border == 0));
		
		html += '>';
	
		for (var y=0; y<2; y++) {
			html += "<tr>";
	
			for (var x=0; x<2; x++)
				html += '<td>&nbsp;</td>';
	
			html += "</tr>";
		}
	
		html += "</table>";
		
		inst.execCommand('mceBeginUndoLevel');
		inst.execCommand('mceInsertContent', false, html);
		tinyMCE.handleVisualAid(inst.getBody(), true, tinyMCE.settings['visual']);
		inst.execCommand('mceEndUndoLevel');
			
	}
	
} 

function appendStyleAttributes(node,styleString) {
	if (node != null && styleString != null){
		var style = node.style;
		var styles = styleString.split(";");
		var finalStyle;
		for (var i = 0; i < styles.length; i++) {
			var currStyle = styles[i].split(":");
			if (currStyle[0].indexOf("-") != -1) {
				finalStyle = replaceSlashs(currStyle[0]);
			}
			else {
				finalStyle = currStyle[0].toLowerCase();
			}
			try {
				style.setAttribute(trim(finalStyle),trim(currStyle[1]));
			}
			catch (e) {
				//alert("Error while appending style-attribute:\n " + 
				//+ "Name: " + trim(finalStyle) + "\n "+
				//+ "Value: " + trim(currStyle[1]));
				// Ausnahmefehler: Inkorrektes Style-Attribute.
			}
		}
	}
}

function makeAttrib(attrib, value) {
	
	if (typeof(value) == "undefined" || value == null) {
		value = "";

	}

	if (value == "")
		return "";

	// XML encode it
	value = value.replace(/&/g, '&amp;');
	value = value.replace(/\"/g, '&quot;');
	value = value.replace(/</g, '&lt;');
	value = value.replace(/>/g, '&gt;');

	return ' ' + attrib + '="' + value + '"';
}

function replaceSlashs(string) {
	var position = string.indexOf("-");
	var newWord = string;
	if (position > 0) {
		newWord = string.substring(0,position).toLowerCase();
		newWord = newWord.concat(string.substring(position + 1, position + 2).toUpperCase());
		newWord = newWord.concat(replaceSlashs(string.substring(position + 2, string.length)));
	}
	return newWord;
}

