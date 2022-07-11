# AIL demo video

<!--
- Video where you show :

  1. the language definition (both syntax and semantics)
   
  2. the creation of a program/model for this language
   
  3. the transformation to source code
   
  4. and the compilation
   
  5. and execution of the generated code.
-->

## What is AIL?

`AIL` stands for `A`griculture `I`rrigation `L`anguage.

### Why AIL?

- IOT
- Smart farming
- Sensor automation

![irrigation](./video_script_figures/irrigation.gif)

---

## Directory structure

<!-- ![folders](./video_script_figures/root-directory.png) -->

<!--
<a href="https://www.flaticon.com/free-icons/directory" title="directory icons">
Directory icons created by Freepik - Flaticon
</a>
-->

- `src/`
- `lib/`
- `bin/`
- `dist/`
- `docs/`

---

## Language Definition

### Syntax & Semantics

See [`src/parser.y`](../src/parser.y) and [`src/tokens.l`](../src/tokens.l) and [`lib/symbol_table.h`](../lib/symbol_table.h).

### Docs

See [`docs/ail/concrete_syntax/index.md`](../docs/ail/concrete_syntax/index.md).

---

## Developing AIL programs

![operdoezer](./video_script_figures/operdoezer.jpg)

### Happy flow

```plaintext
Module : { VIDEO_DEMO }

Plants : {
    Potato <<
        water_use : 5,
        min_temp  : 20,
        max_water : 100,
        breed : "Opperdoezer Ronde",
    >>
}

Actions : {
    notify <<%src, people>> (
        people @> {p | !send_message : {p, "regular update", %src}};
    )
}
```

To run it:

```bash
make all-and-suite-test suite=test/video_demo.ail
```

### Semantic errors

```plaintext
Plants : {
    Potato <<
        water_use : 5,
        water_use : 5,
        min_temp  : 20,
        max_water : 100,
        breed : "Opperdoezer Ronde",
    >>,
    Potato <<
        water_use : 5,
        min_temp  : 20,
        max_water : 100,
        breed : "Papa pastusa",
    >>
}
```

To run it capturing errors:

```bash
make all-and-suite-test suite=test/video_demo.ail | grep Error.
```

---

## AIL -> Python

See [`lib/python_skeleton.h`](../lib/python_skeleton.h).

### Transformation

Let's run it again.

```bash
make all-and-suite-test suite=test/video_demo.ail
```

And then inspect the generated output at [`dist/video_demo.py`](../dist/video_demo.py).

### Execution

```bash
python3 ./dist/video_demo.py
```

---

## Development flow

Inspect the [`Makefile`](../Makefile).

---

## Takeaway

### Positive sides

- Flex/Bison is a robust tool for DSL development
- Using your own IDE of choice is great
- It is very fast

### Not so positive sides

- `C` development is not easy, and high-level languages help
    > Unless you are [Brian Kernighan](https://youtu.be/xnCgoEyz31M?t=129) although even he agrees.
- A lot of "basic" features are DIY

---

## Thanks

![thanks](./video_script_figures/it-crowd-thank-you.gif)

---
<!-- 
## Demo the semantic error checking

```
$ make run-suite-test suite=test/well-formedness_check.ail | grep Error
```
-->
