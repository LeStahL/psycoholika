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

path_string = 'm -124.4959,80.797615 v -2.822222 h 2.82222 v 2.822222 z m -4.26707,-9.821333 v -1.467555 h 2.85044 v 1.467555 z m 0,9.821333 v -7.013222 h -1.38289 v -1.467555 h 4.23333 v 8.480777 z m -7.05004,0 v -1.397 h -1.397 v -5.602111 h -1.397 v -1.481666 h 1.397 v -1.397 h 2.86456 v 1.397 h 1.397 v 1.481666 h -1.397 v 5.531556 h 2.794 v 1.467555 z m -8.46116,0 v -1.397 h -1.397 v -5.602111 h -1.397 v -1.481666 h 1.397 v -1.397 h 2.86456 v 1.397 h 1.397 v 1.481666 h -1.397 v 5.531556 h 2.794 v 1.467555 z m -9.7962,-6.999111 v 2.737556 h 2.73756 v -2.737556 z m -1.46755,6.999111 v -1.397 h -1.397 v -5.672666 h 1.397 v -1.397 h 5.67267 v 1.397 h 1.397 v 4.275666 h -5.60212 v 1.326445 h 4.20512 v 1.467555 z m -8.46115,0 v -5.602111 h -1.397 v -1.467555 h 1.397 v -1.411111 h 1.397 v -1.397 h 4.26155 v 1.467555 h -2.794 v 1.340556 h 1.397 v 1.467555 h -1.397 v 5.602111 z m -11.26376,0 v -8.466666 h 7.06967 v 1.397 h 1.397 v 7.069666 h -2.86456 v -6.999111 h -1.34055 v 1.397 h -1.397 v 5.602111 z m -7.0022,-1.467555 h 2.73756 v -5.531556 h -2.73756 z m -1.46755,1.467555 v -1.397 h -1.397 v -5.672666 h 1.397 v -1.397 h 5.67267 v 1.397 h 1.39699 v 5.672666 h -1.39699 v 1.397 z m -9.86675,0 v -1.397 h -1.397 v -5.672666 h 1.397 v -1.397 h 5.67266 v 1.397 h 1.397 v 1.467555 h -2.86455 v -1.397 h -2.73756 v 5.531556 h 2.73756 v -1.397 h 2.86455 v 1.467555 h -1.397 v 1.397 z m -9.86676,2.822222 v -1.467555 h 4.20511 v -1.340556 h -4.20511 v -1.397 h -1.397 v -7.083777 h 2.86456 v 7.013222 h 2.73755 v -7.013222 h 2.86456 v 9.891888 h -1.397 v 1.397 z m -11.26375,-4.219222 V 77.93306 h 2.86455 v 1.397 h 2.73756 v -2.737556 h -4.20511 v -1.397 h -1.397 v -1.467555 h 1.397 v -1.397 h 5.67266 v 1.467555 h -4.20511 v 1.326445 h 4.20511 v 1.411111 h 1.397 v 2.864555 h -1.397 v 1.397 h -5.67266 v -1.397 z m -8.42125,-7.013222 v 4.134556 h 4.12045 v -4.134556 z m -2.87866,8.410222 v -9.877777 h 8.48077 v 1.397 h 1.397 v 4.275666 h -1.397 v 1.397 h -5.60211 v 2.808111 z'

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
    
with open('psyconfetti.frag', 'wt') as f:
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
