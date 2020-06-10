figma.showUI(__html__);

// Calls to "parent.postMessage" from within the HTML page will trigger this
// callback. The callback will be passed the "pluginMessage" property of the
//

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
};
