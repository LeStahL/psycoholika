# Psycoholika
# Copyright (C) 2021 Alexander Kraus <nr4@z10.info>
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
#

cmake_minimum_required(VERSION 3.8)

project(aldi)

set(CMAKE_MODULE_PATH "${PROJECT_SOURCE_DIR}/thirdparty/FindWindowsSDK")

# Find required tools
find_program(MINIFIER NAMES shader_minifier.exe HINTS ${CMAKE_CURRENT_BINARY_DIR})
find_program(VALIDATOR NAMES glslangValidator.exe)
find_package(OpenGL REQUIRED COMPONENTS OpenGL)
find_package(WindowsSDK REQUIRED)
get_windowssdk_include_dirs(${WINDOWSSDK_LATEST_DIR} WINDOWS_INCLUDE)
get_filename_component(STDC_INCLUDE "${CMAKE_C_COMPILER}" DIRECTORY)
set(STDC_INCLUDE "${STDC_INCLUDE}/../../../include")

# Source lists
set(CHECK_GFX_SOURCES
    gfx/gfx.frag
)
set(MINIFY_GFX_SOURCES
    gfx/gfx.frag
)
set(INTRO_SOURCES
    intro.cpp
)

# Build commands
add_custom_target(intro.obj ALL SOURCES ${INTRO_SOURCES} COMMAND ${CMAKE_CXX_COMPILER} "${PROJECT_SOURCE_DIR}/intro.cpp" /I"${PROJECT_SOURCE_DIR}/thirdparty/minimp3" /I\"${STDC_INCLUDE}\" /I"${CMAKE_CURRENT_BINARY_DIR}" /I"${PROJECT_SOURCE_DIR}/4klang" /I"${PROJECT_SOURCE_DIR}/gfx" /I"${PROJECT_SOURCE_DIR}/oidos" /DWIN32 /c /Gy /O1 /fp:fast /GR- /GS- /MT /Fo"intro.obj" ${MUSIC_DEFINE} COMMENT "Compiling intro.cpp..." DEPENDS gfx.h)

add_custom_target(validate-gfx ALL SOURCES ${CHECK_GFX_SOURCES} COMMAND ${VALIDATOR} ${PROJECT_SOURCE_DIR}/gfx/gfx.frag COMMENT "Validating gfx.frag...")
add_custom_target(gfx.h ALL SOURCES ${MINIFY_GFX_SOURCES} COMMAND ${MINIFIER} ${PROJECT_SOURCE_DIR}/gfx/gfx.frag -o gfx.h COMMENT "Minifying gfx.frag..." DEPENDS validate-gfx)

add_custom_target(${PROJECT_NAME}-${CMAKE_BUILD_TYPE}.exe ALL SOURCES COMMAND ${CMAKE_LINKER} /ENTRY:demo intro.obj /SUBSYSTEM:Windows vcruntime.lib opengl32.lib User32.lib Winmm.lib Kernel32.lib Gdi32.lib ucrt.lib /out:"${PROJECT_NAME}-${CMAKE_BUILD_TYPE}.exe" COMMENT "Linking ${PROJECT_NAME}-${CMAKE_BUILD_TYPE}.exe" DEPENDS intro.obj)
