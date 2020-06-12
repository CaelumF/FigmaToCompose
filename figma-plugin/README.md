# Figsvelte
A boilerplate for creating Figma plugins using Svelte.

This starter project has everything you need to start developing a Figma plugin usign Svelte. Your JS, CSS, SVG and image assets can be bundled on build. The package will take care of compiling your typescript + app on save during development, and also minify on build.


Additionally, this package comes preconfigured with [Figma Plugin DS Svelte](https://github.com/thomas-lowry/figma-plugin-ds-svelte) where you have access to a large range of components and icons that match the Figma UI, to get you up and running quickly. Note: installing this boilerplate will install the component library as a dependency.

Only what you import/use will be included in the final build for small bundle size.


## To get started
```bash
npx degit thomas-lowry/figsvelte figma-plugin
cd figma-plugin
npm install
```
_Note that you will need to have [Node.js](https://nodejs.org/) installed._


## Development
During development, watch your project for changes with the following command.

```bash
npm run dev
```
Start building your plugin UI in `'src/Plugin.svelte'`.


## Build
When ready to package up your final Figma Plugin:
```bash
npm run build
```


## Useful info
To include an external CSS file:
```javascript
import styles from './styles.css';
```

To include an SVG:
```javascript
import SvgName from './image.svg';

//use in your markup
{@html SvgName}
```
_For more info on using the Icon component system with SVGs from [Figma Plugin DS Svelte](https://github.com/thomas-lowry/figma-plugin-ds-svelte), refer to the repo._
