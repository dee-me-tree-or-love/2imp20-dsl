# Base makefile for the flex/bison project
BUILD_DIR=./bin

lexer:
	flex -o ${BUILD_DIR}/lex.yy.c $(src) # generates the lex.yy.c file
	cc ${BUILD_DIR}/lex.yy.c -ll -o ${BUILD_DIR}/lexer.out

run-lexer-interactive run-lexer: ${BUILD_DIR}/lexer.out
	${BUILD_DIR}/lexer.out

cleanup:
	rm -rf ${BUILD_DIR}/**/*