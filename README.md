# psycoholika
Team210 Bullencoolen Release. PC-Demo shown at Discozelt Dauercamping 2021. 20k of code, 5m of music ;)

# Licenses
* The intro is Copyright (c) 2021, Alexander Kraus <nr4@z10.info> and licensed under GPLv3, see LICENSE.
* FindWindowsSDK is licensed under the Boost Software License - Version 1.0 - August 17th, 2003 and copyright Copyright Iowa State University 2012. See thirdparty/FindWindowsSDK/LICENSE_1_0.txt.
* glext.h is Copyright NVIDIA Corporation 2006 and has its License Details included in itself; see gfx/glext.h.
* tinymp3 is Copyright Gao Zhihan. Consider buying him a Coffee at <https://github.com/cpuimage/tinymp3>.

# Build Requirements and Instructions
* Download, install and add the binary dir to your system PATH for the following software:
    * Visual C++ Toolkit 2017 compiler (for example here: <https://my.visualstudio.com/Downloads?q=visual%20studio%202017&wt.mc_id=o~msft~vscom~older-downloads>). 
    * CMake (<https://cmake.org/download/>).
    * shader_minifier (<http://www.ctrl-alt-test.fr/dl/shader_minifier.exe>)
    * glslang-validator (<https://github.com/KhronosGroup/glslang/releases/tag/master-tot>)
* Create an out-of-source build directory, for example `[SOURCE_ROOT]/build`.
* Navigate to this directory
* For debug builds (fast) run `cmake [SOURCE_ROOT] -G"Visual Studio 15 2017" -DCMAKE_BUILD_TYPE=Debug`, for release builds (quite time-consuming), run `cmake [SOURCE_ROOT] -G"Visual Studio 15 2017" -DCMAKE_BUILD_TYPE=Release`
* Run `cmake --build . --config Release`
* Enjoy - And don't forget to have a beer with NR4/Team210 at any Demoparty you feel is appropriate :)

# Links
* Youtube: https://www.youtube.com/watch?v=DoZc_Wv1suI
* Demozoo: https://demozoo.org/productions/303797/
* Pouet: https://www.pouet.net/prod.php?which=90557
