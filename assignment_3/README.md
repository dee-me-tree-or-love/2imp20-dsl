# Assignment 3: Project, Group 10

## Agriculture Irrigation Language (AIL)

This is the deliverable package for the AIL language.
AIL is a DSL implemented using Flex and Bison and is translated to executable Python code.

### Parser/Compiler

Using Flex and Bison allowed us to package together the *parsing* of the AIL code
and *generation/compilation* of the corresponding Python code.

Therefore, we refer to these two steps collectively, simply by saying *parsing*,
and to the entity that performs them - *parser*.

#### Parser executable -> Python distributions

The compiled executable can be found (after compilation) in `bin/parser.out`.

Each time this executable is ran on a AIL file, a new Python distribution code is
generated in `dist/` folder. For example, running `bin/parser.out < foo.ail`
will generate the following Python file `dist/<foo's module identifier>.py`.

### Directory structure

Directory of main interest are:

- `src/` - containing the Flex and Bison tokenizer and parser sources.
- `lib/` - additional code supporting the AIL parser (wellformedness checks + Python code generation).
- `bin/` - is created during compilation and contains all executables.
- `dist/` - is created during the run of the AIL parser executable, and contains the generated Python code.
- `docs/` - contains all AIL related documentation

## Development

### Supported Systems

Currently we have tested this to be working for MacOs and Ubuntu.

### Makefile

The [`Makefile`](./Makefile) contains a bunch of convenient
commands which will help in development and testing.

The [`Makefile`](./Makefile) also automatically detects the host OS
flavor to adjust its execution. May you encounter any problems, please
don't hesitate to contact.

#### Handy targets

Here is a list of most handy ones, but we encourage
to check out all targets to get a better idea.

- `make all` - compiles the Flex tokenizer and
    Bison parser, producing `bin/parser.out` executable

- `make run-tests` - runs the generated parser against all
    test files in [`./test/`](./test/) directory,
    producing a test log output file in a `./.tmp` directory.

- `make all-and-test` - runs `all` target followed by `run-tests`

- `make run-suite-test suite=<test file path>` - runs a test on
    a single specified test file

- `make run-integration-tests` - runs integration tests on all produced
    Python code in [`./dist`](./dist/) directory,
    producing a test log output file in a `./.tmp` directory.

- `make all-and-test-and-integration` - runs `all` target
    followed by `run-tests` and then `run-integration-tests`

- `make serve-docs` - serves the `./docs` folder
    documentation in a [`MkDocs`](https://www.mkdocs.org/) on localhost,
    the website is then accessible somewhere like `http://127.0.0.1:8000/`,
    but better to check the output generated in the terminal.

> NB:
>
> - To compile the code in *non-debug* mode, set the `PRODUCTION_BUILD=1`
>   environment variable, e.g. `export PRODUCTION_BUILD=1`.
> - `./.tmp` folder is created during the test runs automatically.
> - All external Python dependencies (see [`requirements.txt`](requirements.txt))
>   are installed automatically in a virtual environment, in a local `.venv` directory.
> - Python features were tested with python on `Python 3.9`

### Requirements

- `gcc` [install from here](https://gcc.gnu.org/install/)
- `flex` [installation instructions](https://www.oreilly.com/library/view/flex-bison/9780596805418/ch01.html)
- `bison` [installation instructions](https://www.oreilly.com/library/view/flex-bison/9780596805418/ch01.html)
- `Python 3.9+` [install from here](https://www.python.org/)
- `MkDocs` [install from here](https://www.mkdocs.org/)
