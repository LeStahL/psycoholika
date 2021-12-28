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

path_string = 'm -266.37305,100.82743 v -2.116659 h 2.11666 v 2.116659 z m -5.25989,-3.153823 v 2.053161 h 2.05316 v -2.053161 z m -2.14841,2.106077 v -2.14841 h 1.04775 v -1.05833 h 3.15382 v -0.99483 h -3.15382 v -1.100663 h 4.25448 v 1.047747 h 1.04775 v 4.254486 h -1.04775 v 1.047746 h -4.25448 v -1.047746 z m -7.40829,1.047746 v -7.408309 h 2.14841 v 4.20157 h 1.00541 v -1.047747 h 1.04775 v -2.106076 h 2.14841 v 2.158993 h -1.04775 v 1.047746 h -1.04775 v 0.994831 h 1.04775 v 1.05833 h 1.04775 v 1.100662 h -2.14841 v -1.047746 h -1.04775 v -1.05833 h -1.00541 v 2.106076 z m -3.19616,-7.365976 v -1.100663 h 2.13783 v 1.100663 z m 0,7.365976 v -5.259899 h -1.03716 v -1.100663 h 3.17499 v 6.360562 z m -4.23331,0 v -6.307646 h -1.03717 v -1.100663 h 3.17499 v 7.408309 z m -6.29706,-1.100662 h 2.05316 v -4.148654 h -2.05316 z m -1.10066,1.100662 v -1.047746 h -1.04775 v -4.254486 h 1.04775 v -1.047747 h 4.25449 v 1.047747 h 1.04774 v 4.254486 h -1.04774 v 1.047746 z m -8.45604,0 v -7.408309 h 2.14841 v 1.047747 h 3.15382 v 1.05833 h 1.04775 v 5.302232 h -2.14841 v -5.249316 h -1.00541 v 1.047747 h -1.04775 v 4.201569 z m -5.25989,-1.100662 h 2.05316 v -4.148654 h -2.05316 z m -1.10066,1.100662 v -1.047746 h -1.04775 v -4.254486 h 1.04775 v -1.047747 h 4.25448 v 1.047747 h 1.04775 v 4.254486 h -1.04775 v 1.047746 z m -7.4083,0 v -1.047746 h -1.04775 v -4.254486 h 1.04775 v -1.047747 h 4.25449 v 1.047747 h 1.04774 v 1.100663 h -2.14841 v -1.047747 h -2.05316 v 4.148654 h 2.05316 v -1.047747 h 2.14841 v 1.100663 h -1.04774 v 1.047746 z m -7.4083,2.11666 v -1.10066 h 3.15383 v -1.00542 h -3.15383 v -1.047743 h -1.04774 v -5.312816 h 2.14841 v 5.2599 h 2.05316 v -5.2599 h 2.14841 v 7.418889 h -1.04775 v 1.04775 z m -8.45604,-3.164406 v -1.100663 h 2.14841 v 1.047747 h 2.05316 v -2.053161 h -3.15382 v -1.047746 h -1.04775 v -1.100663 h 1.04775 v -1.047747 h 4.25448 v 1.100663 h -3.15382 v 0.99483 h 3.15382 v 1.05833 h 1.04775 v 2.14841 h -1.04775 v 1.047746 h -4.25448 v -1.047746 z m -6.30764,-5.2599 v 3.100907 h 3.09032 v -3.100907 z m -2.15899,6.307646 v -7.408309 h 6.36056 v 1.047747 h 1.04775 v 3.206739 h -1.04775 v 1.047747 h -4.20157 v 2.106076 z'

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
    
with open('psycoholika.frag', 'wt') as f:
    f.write('const int npts1 = ' + str(4*len(path)) + ';\n')
    f.write('const float path1[npts1] = float[npts1](')
    
    for i in range(len(path)-1):
        line = path[i]
        f.write('{:.3f}'.format(line.start.real) + ',' + '{:.3f}'.format(line.start.imag) + ',')
        f.write('{:.3f}'.format(line.end.real) + ',' + '{:.3f}'.format(line.end.imag) + ',')
    line = path[-1]
    f.write('{:.3f}'.format(line.start.real) + ',' + '{:.3f}'.format(line.start.imag) + ',')
    f.write('{:.3f}'.format(line.end.real) + ',' + '{:.3f}'.format(line.end.imag))
    f.write(');\n')
    f.close()
