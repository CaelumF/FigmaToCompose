<script>
    import {GlobalCSS} from 'figma-plugin-ds-svelte';
    import {Button, Input, Label, SelectMenu, Textarea} from 'figma-plugin-ds-svelte';
    import {Checkbox} from 'figma-plugin-ds-svelte';
    import {OnboardingTip} from 'figma-plugin-ds-svelte';

    let serverAddress = "localhost:9081"
    let copyToClipboard = true;
    let separateComposablesForComponents = true;
    let currentSelected = null;
    let generatedOutput = null
    $: disabled = currentSelected == null

    function generate() {
        parent.postMessage({
            pluginMessage: {
                'type': 'generate',
                'serverAddress': serverAddress,
                'copyToClipboard': copyToClipboard,
                'separateComposablesForComponents': separateComposablesForComponents,
                'currentSelected': currentSelected
            }
        }, '*');``
    }

    function close() {
        parent.postMessage({pluginMessage: {'type': 'close'}}, '*')
    }

    function testConnection() {
        parent.postMessage({pluginMessage: {'type': 'testConnection'}}, '*')
    }

    onmessage = (event) => {
        if (event.type === "newNodeSelection") {
            currentSelected = event.selection
        }
        if(event.type === "post") {
            let request = new XMLHttpRequest()
            // This link has random lorem ipsum text
            request.open('POST', serverAddress)
            request.responseType = 'text'
            request.onload = () => {
                // window.parent.postMessage({pluginMessage: request.response}, '*')
                console.log("We got " + request.response)
                generatedOutput = request.response;
            };
            request.send(event.data.pluginMessage.data)
        }
    }
</script>


<div class="p-xxsmall">

    <h4>Jetpack to Compose</h4>
    <p class="px">Requires <a href="https://github.com/CaelumF/FigmaToCompose">server</a> to be running on your machine</p>
    <hr  class="mt-xsmall" style="border-bottom: none;">

    <label for="server">Server address</label>
    <div class="flex column ml-xxsmall">
        <Input id="server" bind:value={serverAddress} borders="true"/>
        <Button variant="secondary" on:click={testConnection}>Test connection</Button>
    </div>

    <hr class="mt-xsmall" style="border-bottom: none;">
    <label>Options</label>

    <div class="flex column">
        <Checkbox bind:checked={copyToClipboard}>Copy to clipboard</Checkbox>
        <Checkbox bind:checked={separateComposablesForComponents}>
            Separate Composable for each Component
        </Checkbox>
    </div>
    <hr  class="mt-xsmall" style="border-bottom: none;">

    <Textarea placeholder="Will output here" bind:value={generatedOutput}/>
    <div class="flex row-reverse">
        {#if disabled}
             Select a node to start
        {:else}
            Ready!
        {/if}
    </div>

    <div class="buttons flex justify-content-between ">
        <Button on:click={close} variant="secondary" class="mr-xsmall">Close</Button>
        <Button on:click={generate} bind:disabled={disabled}>Generate</Button>
    </div>

</div>


<style>

    /* Add additional global or scoped styles here */

</style>
