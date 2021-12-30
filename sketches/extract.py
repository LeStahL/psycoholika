# Hardcyber - PC-64k-Intro by Team210 at Deadline 2k19
# Copyright (C) 2019  Alexander Kraus <nr4@z10.info>
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

from svgpathtools import Path, Line
from svgpathtools import parse_path

path_string = 'm -29.784832,58.208332 v -2.11666 h 2.11666 v 2.11666 z m -4.254471,0 v -1.047747 h -1.047746 v -4.20157 h -1.047747 v -1.111246 h 1.047747 v -1.047747 h 2.148409 v 1.047747 h 1.047747 v 1.111246 h -1.047747 v 4.148654 h 2.095494 v 1.100663 z m -7.397711,0 v -4.20157 h -1.047746 v -1.100663 h 1.047746 v -1.05833 h 1.047747 v -1.047747 h 3.196157 v 1.100663 h -2.095494 v 1.005414 h 1.047747 v 1.100663 h -1.047747 v 4.20157 z m -6.307635,-3.153823 v 2.05316 h 2.05316 v -2.05316 z m -2.14841,2.106076 v -2.148409 h 1.047747 v -1.05833 h 3.153823 v -0.994831 h -3.153823 v -1.100663 h 4.254486 v 1.047747 h 1.047747 v 4.254486 h -1.047747 v 1.047747 h -4.254486 v -1.047747 z m -7.408298,0 v -1.100663 h 2.14841 v 1.047747 h 2.05316 v -2.05316 h -3.153824 v -1.047747 h -1.047746 v -1.100663 h 1.047746 v -1.047747 h 4.254487 v 1.100663 h -3.153823 v 0.994831 h 3.153823 v 1.05833 h 1.047747 v 2.148409 h -1.047747 v 1.047747 h -4.254487 v -1.047747 z m -3.196151,1.047747 v -6.307647 h -1.037164 v -1.100663 h 3.17499 v 7.40831 z m -6.297052,-5.249317 v 2.053161 h 2.05316 v -2.053161 z m -1.100664,5.249317 v -1.047747 h -1.047746 v -4.254486 h 1.047746 v -1.047747 h 4.254487 v 1.047747 h 1.047747 v 3.20674 h -4.20157 v 0.99483 h 3.153823 v 1.100663 z m -6.307633,-1.09008 h 2.05316 v -4.159237 h -2.05316 z m -1.100663,3.20674 v -1.100663 h 3.153823 v -1.005414 h -3.153823 v -1.047746 h -1.047747 v -4.26507 h 1.047747 v -1.047747 h 5.302233 v 7.418893 h -1.047747 v 1.047747 z m -8.456044,-2.11666 v -6.34998 h 6.349979 v 1.100663 h -3.153823 v 1.047747 h -1.047747 v 4.20157 z m -6.307639,-1.100663 h 3.090323 v -5.206984 h -3.090323 z m -1.111247,1.100663 v -1.047747 h -1.047746 v -5.312816 h 1.047746 v -1.047747 h 5.312817 v 1.047747 h 1.047746 v 5.312816 h -1.047746 v 1.047747 z'

path = parse_path(path_string)

# find dimensions
xmax = -1.e9
xmin = 1.e9
ymax = -1.e9
ymin = 1.e9
for line in path:
    xmax = max(xmax, line.start.real)
    xmax = max(xmax, line.end.real)
    
    xmin = min(xmin, line.start.real)
    xmin = min(xmin, line.end.real)
    
    ymax = max(ymax, line.start.imag)
    ymax = max(ymax, line.end.imag)
    
    ymin = min(ymin, line.start.imag)
    ymin = min(ymin, line.end.imag)

# rescale path
for i in range(len(path)):
    path[i].start -= complex(xmin,ymin)
    path[i].start = complex(path[i].start.real/abs(xmax-xmin), path[i].start.imag/abs(ymax-ymin)/100.*29.)
    path[i].start -= complex(.5,.5*29./100.)
    path[i].start = complex(path[i].start.real,-path[i].start.imag)
    
    path[i].end -= complex(xmin,ymin)
    path[i].end = complex(path[i].end.real/abs(xmax-xmin), path[i].end.imag/abs(ymax-ymin)/100.*29.)
    path[i].end -= complex(.5,.5*29./100.)
    path[i].end = complex(path[i].end.real,-path[i].end.imag)

# sort path
#newpath = [ path[0] ]
#del path[0]
#while len(path) > 1:
    #print(len(path))
    #for j in range(len(path)-1):
        #print(j,"/",len(path))
        #if abs(newpath[-1].end - path[j].start)<5.e-1:
            #newpath += [ path[j] ]
            #del path[j]
            #break
#path = newpath
    
with open('orgelsaft.frag', 'wt') as f:
    f.write('const int npts3 = ' + str(4*len(path)) + ';\n')
    f.write('const float path3[npts3] = float[npts3](')
    
    for i in range(len(path)-1):
        line = path[i]
        f.write('{:.3f}'.format(line.start.real) + ',' + '{:.3f}'.format(line.start.imag) + ',')
        f.write('{:.3f}'.format(line.end.real) + ',' + '{:.3f}'.format(line.end.imag) + ',')
    line = path[-1]
    f.write('{:.3f}'.format(line.start.real) + ',' + '{:.3f}'.format(line.start.imag) + ',')
    f.write('{:.3f}'.format(line.end.real) + ',' + '{:.3f}'.format(line.end.imag))
    f.write(');\n')
    f.close()
