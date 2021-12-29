cmake_minimum_required(VERSION 3.15)

project(synth-graph-parser LANGUAGES NONE)

find_package(Java REQUIRED)

set(ANTLR "${CMAKE_CURRENT_BINARY_DIR}/antlr.jar")
if(NOT EXISTS ${ANTLR})
    file(DOWNLOAD "https://www.antlr.org/download/antlr-4.9.2-complete.jar" ${ANTLR} SHOW_PROGRESS)
endif()

add_custom_target(python-parser ALL COMMAND ${Java_JAVA_EXECUTABLE} -jar ${ANTLR} -Dlanguage=Python3 ${PROJECT_SOURCE_DIR}/SynthGraph.g4 -visitor COMMENT "Generating Python3 parser...")
