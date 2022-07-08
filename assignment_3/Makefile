# Base makefile for the flex/bison project
BUILD_DIR=./bin
LEXER_OUT=${BUILD_DIR}/lexer.out
PARSER_OUT=${BUILD_DIR}/parser.out
TMP_DIR=./.tmp

# Extra dependencies
CHICKEN_DIST_DIR=./chicken-5.3.0
INCLUDES=-I./chicken-5.3.0 -lchicken

ifeq ($(CI_RUN), 1)
	TEST_OUTPUT=${TMP_DIR}/test-run-ci.log
else
	TEST_OUTPUT=${TMP_DIR}/test-run-`date +%s`.log
endif

##############################################
# Parser development
##############################################

# CHICKEN language libraries
# FIXME: without having chicken installed, it fails
${CHICKEN_DIST_DIR}/chicken.h: chicken-5.3.0.tar.gz
	@echo "🥚 Getting CHICKEN ready..."
	@[ -f ${CHICKEN_DIST_DIR}/chicken.h ] \
		&& echo "🐣 CHICKEN headers exist." \
		|| tar -xvf chicken-5.3.0.tar.gz
	@echo "🐥 CHICKEN is ready."

# Build the Flex tokenizer
tokenizer: src/tokens.l
	@mkdir -p ./bin
	@echo "🤸 Compiling flex sources..."
	flex --debug -o ${BUILD_DIR}/lex.yy.c src/tokens.l

# Build the parser
parser: src/parser.y
	@mkdir -p ./bin
	@echo "🦬  Compiling bison sources..."
	bison --debug -t -d src/parser.y -o ${BUILD_DIR}/parser.tab.c -v

# Complete Bison + Flex compilation
all: chicken-5.3.0/chicken.h tokenizer parser
	@echo "👷 Compile and link parser..."
	cc	\
		${BUILD_DIR}/parser.tab.c \
		${BUILD_DIR}/lex.yy.c -ll \
		-I./lib \
		-o ${PARSER_OUT}

# Run the parser interactively
run-parser-interactive run-parser: ${PARSER_OUT}
	${PARSER_OUT}

# Run the test files against the parser
run-tests: ${PARSER_OUT}
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

# Handy command to build and test at once
all-and-test: all run-tests
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

# Clean everything unnecessary
.PHONY: clean-all
clean-all: clean-bin clean-extras clean-tmp
	@echo "✨ Done."


##############################################
# Extra utilities
##############################################

# Serve local documentation website
.PHONY: serve-docs
serve-docs: mkdocs.yml
	@echo "💡 Make sure you have `mkdocs` installed."
	@echo "> See https://www.mkdocs.org/getting-started/ for more info"
	mkdocs serve

# Build the docs site html pages
build-docs: mkdocs.yml
	@echo "💡 Make sure you have `mkdocs` installed."
	@echo "> See https://www.mkdocs.org/getting-started/ for more info"
	mkdocs build