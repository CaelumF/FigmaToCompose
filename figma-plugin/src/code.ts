// @ts-ignore
import get from '../node_modules/lodash/get'

figma.showUI(__html__, {width: 10 * 30, height: 16 * 30});

// Send initial selection
if (figma.currentPage.selection.length > 0) {
    figma.ui.postMessage({
            type: "newNodeSelection",
            selectionName: get(figma.currentPage, 'selection[0].name', null),
            rootSelectionCount: figma.currentPage.selection.length
        }
    )
}

function getAllProperties(obj: BaseNode) {
    let values = {
        children: Array
    }
    let objID = obj.id

    let allProps = []
        , curr = obj
    do {
        let props = Object.getOwnPropertyNames(curr)
        props.forEach(function (key) {
            if (allProps.indexOf(key) === -1)
                allProps.push(key)
            // debugger;
            try {
                values[key] = curr[key]
                curr.id = objID
            } catch (e) {
                if (e != "TypeError: id is read-only") {
                    console.log("Error: Not adding " + key)
                    console.log("error details " + e)
                    console.log(objID)
                }
            }
        })

        if ("children" in obj) {
            let childrenExpanded = []
            for (let child in obj.children) {
                let child1 = obj.children[child];
                if (typeof child1 !== "string") {
                    childrenExpanded.push(getAllProperties(child1));
                }
            }
            // @ts-ignore
            values.children = childrenExpanded
        }
    } while (curr = Object.getPrototypeOf(curr))
    return values
}

figma.on("selectionchange", () => {
    figma.ui.postMessage({
            type: "newNodeSelection",
            selectionName: get(figma.currentPage, 'selection[0].name', null),
            rootSelectionCount: figma.currentPage.selection.length
        }
    )
})

figma.ui.onmessage = msg => {
    if (msg.type == 'generate') {
        let allProps = getAllProperties(figma.currentPage.selection[0])
        figma.ui.postMessage({type: "post", data: JSON.stringify(allProps)})
        console.log("allProps:", allProps);
    }
    if(msg.type === "close") {
        figma.closePlugin()
    }
};
