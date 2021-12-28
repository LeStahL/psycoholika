const int npts = 664;
const float path[npts] = float[npts](0.474,-0.145,0.474,-0.062,0.474,-0.062,0.500,-0.062,0.500,-0.062,0.500,-0.145,0.500,-0.145,0.474,-0.145,0.385,-0.145,0.385,0.104,0.385,0.104,0.449,0.104,0.449,0.104,0.449,0.063,0.449,0.063,0.462,0.063,0.462,0.063,0.462,-0.145,0.462,-0.145,0.436,-0.145,0.436,-0.145,0.436,0.060,0.436,0.060,0.423,0.060,0.423,0.060,0.423,0.019,0.423,0.019,0.411,0.019,0.411,0.019,0.411,-0.145,0.411,-0.145,0.385,-0.145,0.321,0.060,0.321,-0.020,0.321,-0.020,0.346,-0.020,0.346,-0.020,0.346,0.060,0.346,0.060,0.321,0.060,0.308,-0.145,0.308,-0.104,0.308,-0.104,0.295,-0.104,0.295,-0.104,0.295,0.063,0.295,0.063,0.308,0.063,0.308,0.063,0.308,0.104,0.308,0.104,0.359,0.104,0.359,0.104,0.359,0.063,0.359,0.063,0.372,0.063,0.372,0.063,0.372,-0.063,0.372,-0.063,0.321,-0.063,0.321,-0.063,0.321,-0.102,0.321,-0.102,0.359,-0.102,0.359,-0.102,0.359,-0.145,0.359,-0.145,0.308,-0.145,0.256,-0.145,0.256,0.102,0.256,0.102,0.244,0.102,0.244,0.102,0.244,0.145,0.244,0.145,0.282,0.145,0.282,0.145,0.282,-0.145,0.282,-0.145,0.256,-0.145,0.180,-0.102,0.205,-0.102,0.205,-0.102,0.205,0.060,0.205,0.060,0.180,0.060,0.180,0.060,0.180,-0.102,0.167,-0.145,0.167,-0.104,0.167,-0.104,0.154,-0.104,0.154,-0.104,0.154,0.063,0.154,0.063,0.167,0.063,0.167,0.063,0.167,0.104,0.167,0.104,0.218,0.104,0.218,0.104,0.218,0.063,0.218,0.063,0.231,0.063,0.231,0.063,0.231,-0.104,0.231,-0.104,0.218,-0.104,0.218,-0.104,0.218,-0.145,0.218,-0.145,0.167,-0.145,0.090,-0.102,0.115,-0.102,0.115,-0.102,0.115,0.060,0.115,0.060,0.090,0.060,0.090,0.060,0.090,-0.102,0.077,-0.145,0.077,-0.104,0.077,-0.104,0.064,-0.104,0.064,-0.104,0.064,0.063,0.064,0.063,0.077,0.063,0.077,0.063,0.077,0.104,0.077,0.104,0.128,0.104,0.128,0.104,0.128,0.063,0.128,0.063,0.141,0.063,0.141,0.063,0.141,-0.104,0.141,-0.104,0.128,-0.104,0.128,-0.104,0.128,-0.145,0.128,-0.145,0.077,-0.145,-0.013,-0.145,-0.013,-0.104,-0.013,-0.104,-0.026,-0.104,-0.026,-0.104,-0.026,0.063,-0.026,0.063,-0.013,0.063,-0.013,0.063,-0.013,0.104,-0.013,0.104,0.039,0.104,0.039,0.104,0.039,0.063,0.039,0.063,0.051,0.063,0.051,0.063,0.051,0.019,0.051,0.019,0.025,0.019,0.025,0.019,0.025,0.060,0.025,0.060,0.000,0.060,0.000,0.060,0.000,-0.102,0.000,-0.102,0.025,-0.102,0.025,-0.102,0.025,-0.061,0.025,-0.061,0.051,-0.061,0.051,-0.061,0.051,-0.104,0.051,-0.104,0.039,-0.104,0.039,-0.104,0.039,-0.145,0.039,-0.145,-0.013,-0.145,-0.115,-0.145,-0.115,0.104,-0.115,0.104,-0.051,0.104,-0.051,0.104,-0.051,0.063,-0.051,0.063,-0.038,0.063,-0.038,0.063,-0.038,-0.145,-0.038,-0.145,-0.064,-0.145,-0.064,-0.145,-0.064,0.060,-0.064,0.060,-0.077,0.060,-0.077,0.060,-0.077,0.019,-0.077,0.019,-0.089,0.019,-0.089,0.019,-0.089,-0.145,-0.089,-0.145,-0.115,-0.145,-0.179,0.060,-0.179,-0.020,-0.179,-0.020,-0.154,-0.020,-0.154,-0.020,-0.154,0.060,-0.154,0.060,-0.179,0.060,-0.192,-0.145,-0.192,-0.104,-0.192,-0.104,-0.205,-0.104,-0.205,-0.104,-0.205,0.063,-0.205,0.063,-0.192,0.063,-0.192,0.063,-0.192,0.104,-0.192,0.104,-0.141,0.104,-0.141,0.104,-0.141,0.063,-0.141,0.063,-0.128,0.063,-0.128,0.063,-0.128,-0.063,-0.128,-0.063,-0.179,-0.063,-0.179,-0.063,-0.179,-0.102,-0.179,-0.102,-0.141,-0.102,-0.141,-0.102,-0.141,-0.145,-0.141,-0.145,-0.192,-0.145,-0.244,-0.145,-0.244,0.102,-0.244,0.102,-0.256,0.102,-0.256,0.102,-0.256,0.145,-0.256,0.145,-0.218,0.145,-0.218,0.145,-0.218,-0.145,-0.218,-0.145,-0.244,-0.145,-0.295,-0.145,-0.295,0.102,-0.295,0.102,-0.308,0.102,-0.308,0.102,-0.308,0.145,-0.308,0.145,-0.269,0.145,-0.269,0.145,-0.269,-0.145,-0.269,-0.145,-0.295,-0.145,-0.385,-0.145,-0.385,-0.104,-0.385,-0.104,-0.397,-0.104,-0.397,-0.104,-0.397,0.104,-0.397,0.104,-0.371,0.104,-0.371,0.104,-0.371,-0.102,-0.371,-0.102,-0.359,-0.102,-0.359,-0.102,-0.359,-0.061,-0.359,-0.061,-0.347,-0.061,-0.347,-0.061,-0.347,0.104,-0.347,0.104,-0.321,0.104,-0.321,0.104,-0.321,-0.145,-0.321,-0.145,-0.385,-0.145,-0.474,0.102,-0.474,0.022,-0.474,0.022,-0.436,0.022,-0.436,0.022,-0.436,0.102,-0.436,0.102,-0.474,0.102,-0.423,-0.104,-0.423,-0.145,-0.423,-0.145,-0.500,-0.145,-0.500,-0.145,-0.500,0.145,-0.500,0.145,-0.423,0.145,-0.423,0.145,-0.423,0.104,-0.423,0.104,-0.410,0.104,-0.410,0.104,-0.410,0.019,-0.410,0.019,-0.436,0.019,-0.436,0.019,-0.436,-0.019,-0.436,-0.019,-0.410,-0.019,-0.410,-0.019,-0.410,-0.104,-0.410,-0.104,-0.423,-0.104,-0.474,-0.102,-0.436,-0.102,-0.436,-0.102,-0.436,-0.022,-0.436,-0.022,-0.474,-0.022,-0.474,-0.022,-0.474,-0.102);
