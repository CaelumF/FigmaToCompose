// This plugin will open a modal to prompt the user to enter a number, and
// it will then create that many rectangles on the screen.

// This file holds the main code for the plugins. It has access to the *document*.
// You can access browser APIs in the <script> tag inside "ui.html" which has a
// full browser enviroment (see documentation).

// This shows the HTML page in "ui.html".
figma.showUI(__html__, {width: 10 * 30, height: 16 * 30 });

// Calls to "parent.postMessage" from within the HTML page will trigger this
// callback. The callback will be passed the "pluginMessage" property of the
// posted message.

function getAllProperties(obj: BaseNode) {
	let values = {
		children: Array
	}
	let objID = obj.id

	let allProps = []
		, curr = obj
	do {
		var props = Object.getOwnPropertyNames(curr)
		props.forEach(function (key) {
			if (allProps.indexOf(key) === -1)
				allProps.push(key)
			// debugger;
			try {
				values[key] = curr[key]
				curr.id = objID
			} catch (e) {
				console.log("Not adding " + key)
				console.log("error details " + e)
				console.log(objID)
			}
		})

		if("children" in obj) {
			let childrenExpanded = []
			for(let child in obj.children) {
				let child1 = obj.children[child];
				if(typeof child1 !== "string") {
					childrenExpanded.push(getAllProperties(child1));
				}
			}
			// @ts-ignore
			values.children = childrenExpanded
		}
	} while (curr = Object.getPrototypeOf(curr))
	return values
}

figma.ui.onmessage = msg => {
	if (msg.type == 'Convert to Compose') {
		let allProps = getAllProperties(figma.currentPage.selection[0])
		figma.ui.postMessage({type: "network", data: JSON.stringify(allProps)})
		console.log("allProps:", allProps);
		figma.closePlugin();
	}

	// Make sure to close the plugin when you're done. Otherwise the plugin will
	// keep running, which shows the cancel button at the bottom of the screen.
	// figma.closePlugin();
};
