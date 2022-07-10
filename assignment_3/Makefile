# Base makefile for the flex/bison project
BUILD_DIR=./bin
DIST_DIR=./dist
LEXER_OUT=${BUILD_DIR}/lexer.out
PARSER_OUT=${BUILD_DIR}/parser.out
TMP_DIR=./.tmp

# Extra dependencies
LIB_DIR=./lib
INCLUDES=-I${LIB_DIR}
EXTRA_INCLUDES=
# FIXME: remove, CHICKEN was not used in the end
# CHICKEN_DIST_DIR=./chicken-5.3.0
# EXTRA_INCLUDES=-I${CHICKEN_DIST_DIR}

# Build behavior between linux and mac
UNAME := $(shell uname)

ifeq ($(UNAME), Linux)
	LEX_FLAG=
endif
ifeq ($(UNAME), Darwin)
	LEX_FLAG=-ll
endif

# NB: the fixed test output file is used in CI/CD.
ifeq ($(TEST_RUNNER_FIXED_ID), 1)
	TEST_OUTPUT=${TMP_DIR}/test-run-fixed.log
else
	TEST_OUTPUT=${TMP_DIR}/test-run-latest.log
endif

# NB: flag to build non-debug version
ifeq ($(PRODUCTION_BUILD), 1)
	DEBUG_FLAG=
else
	DEBUG_FLAG=--debug
endif

##############################################
# Parser development
##############################################

# FIXME: remove, eventually dealt without CHICKEN
# CHICKEN language libraries
# FIXME: without having chicken installed, it fails
# ${CHICKEN_DIST_DIR}/chicken.h: chicken-5.3.0.tar.gz
# 	@echo "🥚 Getting CHICKEN ready..."
# 	@[ -f ${CHICKEN_DIST_DIR}/chicken.h ] \
# 		&& echo "🐣 CHICKEN headers exist." \
# 		|| tar -xvf chicken-5.3.0.tar.gz
# 	@echo "🐥 CHICKEN is ready."

# Build the Flex tokenizer
tokenizer: src/tokens.l
	@mkdir -p ./bin
	@echo "🤸 Compiling flex sources..."
	flex ${DEBUG_FLAG} -o ${BUILD_DIR}/lex.yy.c src/tokens.l

# Build the parser
parser: src/parser.y
	@mkdir -p ./bin
	@echo "🦬  Compiling bison sources..."
	bison ${DEBUG_FLAG} -d src/parser.y -o ${BUILD_DIR}/parser.tab.c -v

# Complete Bison + Flex compilation
all: tokenizer parser
	@echo "👷 Compile and link parser..."
	cc	\
		${BUILD_DIR}/parser.tab.c \
		${BUILD_DIR}/lex.yy.c \
		${LEX_FLAG} \
		${INCLUDES} \
		${EXTRA_INCLUDES} \
		-o ${PARSER_OUT}

# Run the parser interactively
run-parser-interactive run-parser: ${PARSER_OUT}
	${PARSER_OUT}

# Run the test files against the parser
run-tests: ${PARSER_OUT} clean-dist
	@mkdir -p ${TMP_DIR}
	@echo "🎢 Brace yourself, running all tests now!"
	@ls	test \
		| xargs -I[] \
			sh -c \
				"echo '\n💡 Running []' ; cat test/[] | ${PARSER_OUT} || echo ❌ TEST FAILED: []" \
		2>&1 | tee ${TEST_OUTPUT}
	@grep -q "❌ TEST FAILED" ${TEST_OUTPUT} \
		&& echo "❌ SOME TESTS FAILED. Quitting." && exit 1 \
		|| echo "✅ ALL TESTS PASSED"

# Run a single test file against the parser
run-suite-test: ${PARSER_OUT} clean-dist
	@echo "🕵️ Check if 'suite' argument is defined."
	@echo "💡 Make sure to call this target like 'make <target> suite=<your file path>'."
	@test ${suite}
	@mkdir -p ${TMP_DIR}
	@echo "🛫 Brace yourself, running the test now!"
	@echo '💡 Running ${suite}'
	@((cat ${suite} | ${PARSER_OUT} && echo ✅ Test passed ) || echo ❌ TEST FAILED) \
		2>&1 | tee ${TMP_DIR}/test_manual.log

# Handy command to build and test at once
all-and-test: all run-tests
	@echo "👌 Done."

# Handy command to build and run a single test suite at once
all-and-suite-test: all run-suite-test
	@echo "👌 Done."

# Clean build directory
.PHONY: clean-bin
clean-bin:
	@echo "🧹 Cleaning the build directory..."
	rm -rf ${BUILD_DIR}/*

# Clean extras
.PHONY: clean-extras
clean-extras:
	@echo "🧹 Cleaning all the extras..."
	rm -rf ${CHICKEN_DIST_DIR}

# Clean all local tmp files
.PHONY: clean-tmp
clean-tmp:
	@echo "🧹 Cleaning all the local tmp files..."
	rm -rf ${TMP_DIR}/*

# Clean all produced python files
.PHONY: clean-dist
clean-dist:
	@echo "🧹 Cleaning all the produced python files..."
	rm -rf ${DIST_DIR}/*

# Clean everything unnecessary
.PHONY: clean-all
clean-all: clean-bin clean-extras clean-tmp clean-dist
	@echo "✨ Done."


##############################################
# Extra utilities
##############################################

# Virtualenv availability target
.venv: .venv/touchfile

# Virtualenv setup target
.venv/touchfile: requirements.txt
	@[ -f ${.venv}/bin/activate ] \
		&& echo "🦄 virtualenv exists." \
		|| python3 -m venv .venv
	. ./.venv/bin/activate; pip install mkdocs
	touch ./.venv/touchfile

# Serve local documentation website
.PHONY: serve-docs
serve-docs: mkdocs.yml .venv
	@echo "💡 Make sure you have 'mkdocs' installed."
	@echo "> See https://www.mkdocs.org/getting-started/ for more info"
	. ./.venv/bin/activate; mkdocs serve

# Build the docs site html pages
build-docs: mkdocs.yml .venv
	@echo "💡 Make sure you have 'mkdocs' installed."
	@echo "> See https://www.mkdocs.org/getting-started/ for more info"
	. ./.venv/bin/activate; mkdocs build

# Clean .venv
.PHONY: clean-venv
clean-venv:
	@echo "🧹 Cleaning the local virtual environment..."
	rm -rf ./.venv