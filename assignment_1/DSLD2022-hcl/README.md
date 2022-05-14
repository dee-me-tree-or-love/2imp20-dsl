<!--
 * @Author: rocs
 * @Date: 2022-05-14 15:59:26
 * @LastEditors: rocs
 * @LastEditTime: 2022-05-14 18:22:36
 * @Description: add info
-->
# DSL Design 2022 - Assignment 1
A skeleton for a Rascal project implementing a Hardware Configuration Language
## Introduction
HCL is a language for defining computing hardware resources (to order from a vendor), which allows users to define hardware resources by defining instances, and each instance has different properties. 

## Supported Syntax
- Variable types `boolean`, `integer`, `real`, and `string`
- Computer Resource that has a label and contains a list of components: `"<type|computer> <string|computerName>"`
- Three kind of Components that and their defined variables
- processing:`"<type|processing> <string|processingName>" {<type|cores> <integer|coresNum>, <type|speed> <clockSpeed|speedNum>}`
- storage:
- display:
### Example:
```
computer my_computer {
    storage my_storage {
        storage: SSD of 512 GiB
    },
    processing my_CPU {
        cores: 4,
        speed: 2 Ghz,
        L1: 64 KiB
        L2: 4 MiB
        L3: 15 MiB
    },
    display my_display {
        diagonal: 30 inch,
        type: 5k
    },
    my_display,
    my_storage
}
```
