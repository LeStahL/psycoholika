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

path_string = 'm -100.08875,111.125 v -2.11666 h 2.116665 v 2.11666 z m -5.30221,0 v -4.20157 h -1.04775 v -1.10066 h 1.04775 v -1.05833 h 1.04775 v -1.04775 h 3.19615 v 1.10066 h -2.09549 v 1.00542 h 1.04775 v 1.10066 h -1.04775 v 4.20157 z m -6.30764,-5.24932 v 4.15924 h 2.05316 v -4.15924 z m -2.14841,7.36598 v -8.46664 h 5.30224 v 1.04775 h 1.04774 v 4.26507 h -1.04774 v 1.04774 h -3.15383 v 2.10608 z m -5.25988,-3.21732 h 2.05316 v -4.14866 h -2.05316 z m -1.10067,1.10066 v -1.04775 h -1.04774 v -4.25448 h 1.04774 v -1.04775 h 4.25449 v 1.04775 h 1.04775 v 4.25448 h -1.04775 v 1.04775 z m -5.30222,0 v -1.04775 h -1.04774 v -4.20157 h -1.04775 v -1.11124 h 1.04775 v -1.04775 h 2.14841 v 1.04775 h 1.04774 v 1.11124 h -1.04774 v 4.14866 h 2.09549 v 1.10066 z m -9.50379,0 v -6.34998 h 5.30224 v 1.04775 h 1.04774 v 5.30223 h -2.14841 v -5.24932 h -1.00541 v 1.04775 h -1.04775 v 4.20157 z m -3.19615,-7.36598 v -1.10066 h 2.13783 v 1.10066 z m 0,7.36598 v -5.2599 h -1.03716 v -1.10066 h 3.17499 v 6.36056 z m -6.29705,-5.24932 v 2.05316 h 2.05316 v -2.05316 z m -1.10067,5.24932 v -1.04775 h -1.04774 v -4.25448 h 1.04774 v -1.04775 h 4.25449 v 1.04775 h 1.04775 v 3.20674 h -4.20157 v 0.99483 h 3.15382 v 1.10066 z m -8.45604,0 v -6.34998 h 6.34998 v 1.10066 h -3.15382 v 1.04775 h -1.04775 v 4.20157 z m -5.25988,-5.24932 v 2.05316 h 2.05316 v -2.05316 z m -1.10066,5.24932 v -1.04775 h -1.04775 v -4.25448 h 1.04775 v -1.04775 h 4.25448 v 1.04775 h 1.04775 v 3.20674 h -4.20157 v 0.99483 h 3.15382 v 1.10066 z m -3.15382,-1.04775 v 1.04775 h -5.30223 v -7.40831 h 2.14841 v 1.04775 h 3.15382 v 1.05833 h 1.04775 v 4.25448 z m -3.15382,-0.0529 h 2.05316 v -4.14866 h -2.05316 z m -8.50896,1.10065 v -1.04775 h -1.04775 v -5.30223 h 2.14841 v 5.24932 h 1.00542 v -1.04775 h 1.04774 v -4.20157 h 2.14841 v 6.34998 z m -6.30764,-3.15382 v 2.05316 h 2.05316 v -2.05316 z m -2.14841,2.10607 v -2.14841 h 1.04775 v -1.05833 h 3.15382 v -0.99483 h -3.15382 v -1.10066 h 4.25449 v 1.04775 h 1.04774 v 4.25448 h -1.04774 v 1.04775 h -4.25449 v -1.04775 z m -7.4083,1.04775 v -6.34998 h 6.34998 v 1.10066 h -3.15382 v 1.04775 h -1.04775 v 4.20157 z m -7.40829,0 v -7.40831 h 2.14841 v 1.04775 h 3.15382 v 1.05833 h 1.04775 v 5.30223 h -2.14841 v -5.24932 h -1.00541 v 1.04775 h -1.04775 v 4.20157 z m -6.36055,0 v -1.04775 h -1.04775 v -4.25448 h 1.04775 v -1.04775 h 4.25448 v 1.04775 h 1.04775 v 1.10066 h -2.14841 v -1.04775 h -2.05316 v 4.14866 h 2.05316 v -1.04775 h 2.14841 v 1.10066 h -1.04775 v 1.04775 z m -8.45605,-1.04775 v -1.10066 h 2.14841 v 1.04775 h 2.05316 v -2.05316 h -3.15382 v -1.04775 h -1.04775 v -1.10066 h 1.04775 v -1.04775 h 4.25449 v 1.10066 h -3.15383 v 0.99483 h 3.15383 v 1.05833 h 1.04774 v 2.14841 h -1.04774 v 1.04775 h -4.25449 v -1.04775 z m -2.10606,0 v 1.04775 h -5.30223 v -7.40831 h 2.14841 v 1.04775 h 3.15382 v 1.05833 h 1.04775 v 4.25448 z m -3.15382,-0.0529 h 2.05316 v -4.14866 h -2.05316 z m -8.50896,1.10065 v -1.04775 h -1.04775 v -5.30223 h 2.14841 v 5.24932 h 1.00541 v -1.04775 h 1.04775 v -4.20157 h 2.14841 v 6.34998 z m -9.51438,0 v -7.40831 h 2.15899 v 3.15382 h 3.09032 v -3.15382 h 2.159 v 7.40831 h -2.159 v -3.15382 h -3.09032 v 3.15382 z'

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
    
with open('hubschraubereintopf.frag', 'wt') as f:
    f.write('const int npts5 = ' + str(4*len(path)) + ';\n')
    f.write('const float path5[npts5] = float[npts5](')
    
    for i in range(len(path)-1):
        line = path[i]
        f.write('{:.3f}'.format(line.start.real) + ',' + '{:.3f}'.format(line.start.imag) + ',')
        f.write('{:.3f}'.format(line.end.real) + ',' + '{:.3f}'.format(line.end.imag) + ',')
    line = path[-1]
    f.write('{:.3f}'.format(line.start.real) + ',' + '{:.3f}'.format(line.start.imag) + ',')
    f.write('{:.3f}'.format(line.end.real) + ',' + '{:.3f}'.format(line.end.imag))
    f.write(');\n')
    f.close()
