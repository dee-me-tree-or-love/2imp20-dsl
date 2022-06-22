# Base makefile for the flex/bison project
BUILD_DIR=./bin
LEXER_OUT=${BUILD_DIR}/lexer.out
PARSER_OUT=${BUILD_DIR}/parser.out

# Complete Bison + Flex parser compilation
parser: src/parser.y src/tokens.l
	@echo "📝 Compile bison sources..."
	bison -d src/parser.y -o ${BUILD_DIR}/parser.tab.c -v

	@echo "🔨 Compile flex sources..."
	flex -o ${BUILD_DIR}/lex.yy.c src/tokens.l

	@echo "👷 Compile and link parser..."
	cc  ${BUILD_DIR}/parser.tab.c \
		${BUILD_DIR}/lex.yy.c -ll \
		-o ${PARSER_OUT}


# Run the parser interactively
run-parser-interactive run-parser: ${PARSER_OUT}
	${PARSER_OUT}


# Clean build directory
cleanbin:
	@echo "🧹 Cleaning the build directory..."
	rm -rf ${BUILD_DIR}/*