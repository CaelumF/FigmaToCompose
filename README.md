# Designs to Jetpack Compose converter
Easily convert [Figma](https://www.figma.com/) designs directly to [Jetpack Compose](https://developer.android.com/jetpack/compose) code. (Not affiliated with either of them)

This project contains a plugin that sends the selected Figma json to localhost:9020, and a kotlin backend that converts this json
to Jetpack Compose and sets the clipboard to it

See a video and lacking css at the [github io page](https://caelumf.github.io/FigmaToCompose/)

## Version compatibility
This works surprisingly well even when several versions outdated with the latest JetPack Compose. A few modifiers may be deprecated, but you can use
Android Studio to automatically replace them.

The latest Compose version I personally have used it with is:
Jetpack Compose: rc-02

# Usage:
With the [plugin](https://www.figma.com/community/plugin/856651176156241740/Figma-to-Compose) installed, start the server by cloning this repo, cd-ing into it and running:

(currently seems to depend on JVM 8)

For Linux or Mac OSX
`./gradlew run --args="-config=application.conf"`

For Windows, in the terminal with WSL installed
`wsl`

`bash`

`dos2unix gradlew`

`./gradlew run --args="-config=application.conf"`


When using the plugin with a Windows plugin, disable copy to clipboard or else it will crash from being unable to find an X11 server's clipboard to access, and
if it can it's probably not very useful

This requires a JDK installed, if you're doing Android dev it probably already is :)

Now you can open the plugin window in Figma, select a node, and click "Genarate" to get the Jetpack Compose code to display it!

# Use cases
Often times designs contain non-repeated distances, colours and proportions. Replicating these designs can be very tedious, and discrepancies in design and implementation can lead to "split realities".

Primarily, this is to cut out taking measurements, reduce design-implementation back and fourth and save time/energy even when the designer and implementer are the same person

# Features / mappings

|    feature    | Jetpack Compose feature               | Note                                                                                              | Missing / to-do                                    |
|:-------------:|---------------------------------------|---------------------------------------------------------------------------------------------------|----------------------------------------------------|
| Frame         | Constraint Layout                     | Supports start, end, scale, stretch, start-end (maintain margins dp), center                      | auto remove redundant constraints                  |
| Nested nodes  | Composables with nested calls to them | This is a nice solution for updating implementation to design                                     |                                                    |
| Group         | Box                                   | !Recommend using the dropdown to convert to a Frame and restart plugin as workaround for figma bug| Pass parent group's constraints to group's children|
| Text          | Text                                  | Supports solid colours, font size vertical and horizontal text align                              | Font family, bold, italic, advanced Figma features |
| Auto layout   | Row/Column                            |                                                                                                   |                                                    |
| Vectors       | Image(vectorResource(...))            | Creates a vector painter looking at a drawable with the svg export name on nodes with svg exports | Automation for importing svgs from figma           |
| Rectangle     | Box                                   | Includes generic "style mods" (bg, shadow, )                                                      |                                                    |
| Shadow fill   | shadow                            | Does not work well for non-rectangles or where shadow is applied to parent of many children       | Other shapes, find solution for shadows on parents     |
| Corner Radius | .clip(CornerRadiusShape)              |                                                                                                   |                                                    |
| Gradient fill | background(HorizontalGradient(...)|  Only currently supports horizontal gradients                                                     |                                                    |

# Development

The backend server accepts Figma's json on a post to `/` on port 9020. Port configurable from application.conf

## Figma plugin development
###### For Linux

 Unfortunately for now a shared clipboard from a Windows or Mac VM or a host running [Barrier](https://github.com/debauchee/barrier) is needed to "conveniently" use local changes,
 until Figma supports developing / running unpublished plugins on Linux

###### Mac or Windows
Within the FigmaPlugin directory lies the code to a plugin that can be imported on Windows or Mac. In Figma client app (not web), go to
Plugins -> Development > New Plugin and select the manifest.json


# Troubleshooting

## ArrayIndexOutOfBounds error in rendering
Check that there are no recursive composables, and make that no Figma components
have the same name.

# TODO:
See Issues
