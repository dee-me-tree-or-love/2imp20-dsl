## Assignment 2 



#### Directory structure

##### metamodeling

- The `metamodelHCL` directory includes the metamodel we designed for `HCL` language. The metamodel can be found in `metamodelHCL/model` , the root class is `Model`. 

##### model transformation

- The QVTo transformation project directory is `hcl2graph` , the transformation code is located in `hcl2graph/transforms`. 

- The input `xmi` instance of `HCL` is located in `metamodelHCL/model`, which called `demoModelHCL.xmi` .

- The target `Graph` model is in `nl.tue.dsldesign.graph.metamodel` directory.

- The ouput result `xmi` file is located in `hcl2graph/transforms` , which called `resultGraphModel.xmi` .

  

#### Requirements Implementation

- We implement all transformation requirements.

##### about sharing oval nodes

- According to the assignment requirements, the `SpeedProperty` of the Processing components is represented by a box node, whereas all the rest (the `L1CacheProperty` and `CoresProperty`) are represented by an oval node. Likewise, the `DiagonalProperty` of `Display` components is also represented by a box, whereas the `ResolutionProperty` is represented by an oval.

- We chose not sharing `oval` nodes in our transformation, which means we have several same `oval` property nodes like `32 KiB` and `5k` . And for `box` property nodes, we set them unique.



#### Transformation Example

- Below is a view of the result `xmi` file of our transformed HCL model instance.
![graph (1)](https://user-images.githubusercontent.com/32551030/174314359-b6039196-fa0f-4dc2-be36-ffbfeb0cbe6f.svg)











