### Figma design to Jetpack Compose converter (FDJCC)
Easily convert [Figma](https://www.figma.com/) designs directly to [Jetpack Compose](https://developer.android.com/jetpack/compose) code. (Not affiliated with either of them)

This project contains a plugin that sends the selected Figma json to locahost:9020, and a kotlin backend that converts this json
to Jetpack Compose and sets the clipboard to it 

# Use cases

Often times designs contain non-repeated distances, colours and proportions. Replicating these designs can be very tedious, and discrepancies in design and implementation can lead to "split realities".

Primarily, this is to cut out taking measurements, reduce design-implementation back and fourth and save time/energy even when the designer and implementer are the same person

# Features / mappings 


| Figma feature   |      Jetpack Compose feature      |  Note | Missing / to-do
|----------|:-------------:|:------:|------:|
| Frame | Constraint Layout | Supports start, end, scale, stretch, start-end (maintain margins dp), center | auto remove redundant constraints
| Nested nodes | Composables with nested calls to them  | This is a nice solution for updating implementation to design|
| Group |    Box   |   |
| Text        | Text |    Supports solid colours, font size vertical and horizontal text align | Font family, bold, italic, advanced Figma features
| Auto layout |  Row/Column |    |
| Vectors | VectorPainter  |  Creates a vector painter looking at a drawable with the svg export name on nodes with svg exports   | Automation for importing svgs from figma
| Rectangle | Box  |  Includes generic "style mods" (bg, shadow, )  |
| Shadow fill |  Elevation  |  Does not work well for non-rectangles or where shadow is applied to parent of many children | Other shapes, find solution for shadows on parents
| Corner Radius |  .clip(CornerRadiusShape) | |
| Gradient fill |   | |
|  |   | |
|  |   | |

# Usage:

The backend server accepts Figma's json on a post to `/` on port 9020.

Within the FigmaPlugin directory lies the code to a plugin that can be imported on Windows or Mac. In Figma client app (not web), go to
Plugins -> Development > New Plugin and select the manifest.json

For **Linux**, unfortunately for now a shared clipboard from a VM or a host running [Barrier](https://github.com/debauchee/barrier) is needed to "conveniently" use,
 until Figma supports developing / running unpublished plugins on Linux )

# TODO:
See Issues
