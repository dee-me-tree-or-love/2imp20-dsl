## Assignment 2 



#### Directory structure

##### metamodeling

- The `metamodelHCL` directory includes the metamodel we designed for `HCL` language. The metamodel can be found in `metamodelHCL/model` , the root class is `Model`. 

##### modeltransfermation

- The QVTo transformation project directory is `hcl2graph` , the transformation code is located in `hcl2graph/transforms`. 

- The input `xmi` instance of `HCL` is located in `metamodelHCL/model`, which called `demoModelHCL.xmi` .

- The target `Graph` model is in `nl.tue.dsldesign.graph.metamodel` directory.

- The ouput result `xmi` file is located in `hcl2graph/transforms` , which called `resultGraphModel.xmi` .

  

#### Requirements Implementation

- We implement all transformation requirements.

##### about sharing oval nodes

- We chose not sharing `oval` nodes in our transformation, which means we have several same `oval` property nodes like `32 KiB` and `5k` . And for `box` property nodes, we set them unique.



#### Transformation Example

- Below is a view of the result `xmi` of our transformed HCL model instance.

![graph](/Users/rocs/Downloads/graph.svg)









