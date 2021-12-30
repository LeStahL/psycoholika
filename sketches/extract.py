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

path_string = 'm 106.43784,72.571426 v -2.11666 h 2.11666 v 2.11666 z m -6.30764,-2.158993 h 1.04774 v 1.05833 h 2.04258 V 67.32211 h -1.04775 v -1.05833 h -2.04257 z m -1.11125,1.111247 v -1.05833 h -1.047747 v -3.196157 h 1.047747 v -1.05833 h 1.05833 v -1.047746 h 3.19616 v 1.047746 h 1.05833 v 1.05833 h 1.04774 v 3.196157 h -1.04774 v 1.05833 h -1.05833 v 1.047746 h -3.19616 V 71.52368 Z m -8.456042,1.047746 v -1.100663 h 2.095494 V 67.32211 h -1.047747 v -1.111247 h 1.047747 v -1.047746 h 2.158993 v 6.307646 h 2.095493 v 1.100663 z m -8.466633,-2.158993 h 1.047747 v -1.047746 h 1.05833 V 68.31694 h 2.095493 v -1.047747 h 1.047747 V 66.26378 h -3.090324 v 1.05833 h -2.158993 v -1.111247 h 1.047747 v -1.047746 h 5.312816 v 1.047746 h 1.047747 v 2.158993 h -1.047747 v 1.047747 h -1.05833 v 1.047747 h -2.095493 v 1.005413 h 4.20157 v 1.100663 h -7.40831 z m -8.466633,2.158993 v -6.349979 h 3.20674 v 1.047746 h 0.99483 v -1.047746 h 2.158994 v 1.047746 h 1.047746 v 5.302233 h -2.158993 v -2.095493 h -0.99483 v 1.047747 h -1.100663 v -1.047747 h -0.99483 v 2.095493 z m -5.259886,-3.153823 v 2.05316 h 2.05316 v -2.05316 z m -2.14841,2.106077 v -2.14841 h 1.047747 v -1.05833 h 3.153823 v -0.99483 h -3.153823 v -1.100663 h 4.254486 v 1.047746 h 1.047747 v 4.254487 h -1.047747 v 1.047746 H 67.269093 V 71.52368 Z m -5.259888,-4.20157 v 2.05316 h 2.05316 v -2.05316 z m -1.100663,5.249316 V 71.52368 h -1.047747 v -4.254487 h 1.047747 v -1.047746 h 4.254486 v 1.047746 h 1.047747 v 3.20674 h -4.20157 v 0.99483 h 3.153823 v 1.100663 z m -6.360551,0 V 66.26378 h -2.095493 v -1.100663 h 6.34998 v 1.100663 h -2.095494 v 6.307646 z'

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
    
with open('team210.frag', 'wt') as f:
    f.write('const int npts6 = ' + str(4*len(path)) + ';\n')
    f.write('const float path6[npts6] = float[npts6](')
    
    for i in range(len(path)-1):
        line = path[i]
        f.write('{:.3f}'.format(line.start.real) + ',' + '{:.3f}'.format(line.start.imag) + ',')
        f.write('{:.3f}'.format(line.end.real) + ',' + '{:.3f}'.format(line.end.imag) + ',')
    line = path[-1]
    f.write('{:.3f}'.format(line.start.real) + ',' + '{:.3f}'.format(line.start.imag) + ',')
    f.write('{:.3f}'.format(line.end.real) + ',' + '{:.3f}'.format(line.end.imag))
    f.write(');\n')
    f.close()
