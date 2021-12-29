; Music converted from verkruppelt.xrns 2021-12-01 20:14:49

%define MUSIC_LENGTH 960
%define TOTAL_SAMPLES 5177344
%define MAX_TOTAL_INSTRUMENT_SAMPLES 6356992

%define SAMPLES_PER_TICK 4410
%define TICKS_PER_SECOND 10.000000000

%define NUM_TRACKS_WITH_REVERB 0
%define NUM_TRACKS_WITHOUT_REVERB 6


	section iparam data align=4

_InstrumentParams:
.i00:
	; 00|kick
	dd	24,1,47,47,0x00000000,0x3F800000,0x3F800000,0x3F800000,0x00000000,0x42F00000,0x41FA50F0,0x3BBF183B,0xBDE27D02,0x3BCCB479,0x3BE314E7,0x44000000,65536,0xB8C6247D,0x7F800000,0x46800000
.i01:
	; 01|snare
	dd	62,44,5,33,0x3EBD70F0,0x3DB8520F,0x3D961EF0,0xBDE83B88,0x42317C22,0x41ABA464,0x42B199DF,0x3F4ABBC7,0xBDAE7450,0x39F683C2,0x39F683C2,0x3FC3CD59,65536,0xB8B97DB6,0x3E6832A8,0x46800000
.i02:
	; 02|bass
	dd	24,6,32,65,0x3CF5C280,0x3F7851EC,0x3F5C292C,0xBF187CBC,0x3E5B0C69,0x41EC7999,0xC185173E,0x00000000,0xBC014328,0xB9BD551C,0xB9BD551C,0x3FB8BA32,1179648,0xB8582804,0x39BE3773,0x46800000
.i03:
	; 03|lead
	dd	74,15,9,47,0x3E428EC0,0x3F4F5C50,0x3F7AE18A,0xBEE6650C,0x3E929594,0xC2C4CCC5,0x42366700,0x3DC75747,0xBD133219,0x3A1CB63C,0x3A1CB63C,0x40163D88,131072,0xB9BC2BB9,0x3B86D1EE,0x46800000
.i04:
	; 04|arp
	dd	16,10,22,36,0x3F7AE148,0x3CA3D70A,0x3F800000,0xBDCCCC40,0x3E303CEF,0xC1ACCC43,0x42F00000,0x3F0D261F,0xBEA83256,0x3D0B51DA,0x3C8EA9D6,0x3F1B6BBC,196608,0xB914A000,0x3C9E7651,0x46800000
.i05:
	; 05|pad
	dd	61,25,37,34,0x3E051E34,0x3F5EB873,0x3F70A41C,0xBFC66624,0x3D5318AE,0x420666C7,0x42F00000,0x3CB3D385,0xBD4F788C,0x398EA8BF,0x3AAF391A,0x4186782B,196608,0xB8C38D84,0x38B64CCC,0x46800000



	section itones data align=1

_InstrumentTones:
.i00:
	; 00|kick
	db	4,-128
.i01:
	; 01|snare
	db	41,-128
.i02:
	; 02|bass
	db	20,2,2,-128
.i03:
	; 03|lead
	db	31,3,2,3,2,2,3,2,2,1,4,3,2,2,1,-128
.i04:
	; 04|arp
	db	20,2,2,3,2,2,1,2,2,2,1,2,2,1,2,2,2,1,2,2,3,2,2,1,2,2,3,2,2,1,2,2,-124
.i05:
	; 05|pad
	db	24,10,2,7,3,2,3,2,2,3,2,2,1,2,2,3,-125


	section trdata data align=1

_TrackData:
.t_kick_1:
	; kick, column 1
	db	1,0,1,-128
.t_snare_1:
	; snare, column 1
	db	1,0,1,-128
.t_bass_1:
	; bass, column 1
	db	0,0,1,1,1,1,1,-128
.t_lead_1:
	; lead, column 1
	db	0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-128
.t_arp_1:
	; arp, column 1
	db	0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-128
.t_arp_2:
	; arp, column 2
	db	0,3,1,1,1,4,1,1,1,1,1,2,1,2,1,2,1,1,1,8,1,3,1,1,1,1,1,-128
.t_arp_3:
	; arp, column 3
	db	0,13,1,6,1,5,1,1,1,1,1,-128
.t_arp_4:
	; arp, column 4
	db	0,27,1,1,1,1,1,2,1,-128
.t_arp_5:
	; arp, column 5
	db	32,20,1,-128
.t_pad_1:
	; pad, column 1
	db	0,0,1,1,1,2,1,4,1,6,1,1,1,1,1,-128
.t_pad_2:
	; pad, column 2
	db	0,2,1,2,1,1,1,2,1,3,1,1,1,1,1,1,1,-128
.t_pad_3:
	; pad, column 3
	db	0,2,1,2,1,2,1,3,1,3,1,1,1,1,1,-128
.t_pad_4:
	; pad, column 4
	db	0,4,1,4,1,2,1,1,1,1,1,2,1,-128

	section notelen data align=1

_NoteLengths:
	; kick, column 1
L_kick_1:
	; Position 0, pattern 0
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 1, pattern 1
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 2, pattern 2
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 3, pattern 3
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,8
	; Position 4, pattern 4
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 5, pattern 5
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 6, pattern 6
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 7, pattern 7
	db	4,4,4,4,4,4,4,4,4,4,4,4,2,2,2,2,2,2,1,1,1,1
	; Position 8, pattern 8
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 9, pattern 9
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 10, pattern 10
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 11, pattern 11
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,8
	; Position 12, pattern 12
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	; Position 13, pattern 13
	db	4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
	db	0

	; snare, column 1
L_snare_1:
	db	-1,248
	; Position 3, pattern 3
	db	1,1,1,1,1,1,1,5
	; Position 4, pattern 4
	db	8,8,8,8,8,8,8,8
	; Position 5, pattern 5
	db	8,8,8,8,8,8,8,8
	; Position 6, pattern 6
	db	8,8,8,8,8,8,8,8
	; Position 7, pattern 7
	db	8,8,8,8,8,4,2,2,1,2,1,1,1,1,1,1,1,1,1
	; Position 8, pattern 8
	db	-1,248
	; Position 11, pattern 11
	db	1,1,1,1,1,1,1,5
	; Position 12, pattern 12
	db	8,8,8,8,8,8,8,8
	; Position 13, pattern 13
	db	8,8,8,8,8,8,8
	db	0

	; bass, column 1
L_bass_1:
	; Position 0, pattern 0
	db	32,28,4
	; Position 1, pattern 1
	db	32,28,4
	; Position 2, pattern 2
	db	32,28,4
	; Position 3, pattern 3
	db	32,28,4
	; Position 4, pattern 4
	db	32,28,4
	; Position 5, pattern 5
	db	32,28,4
	; Position 6, pattern 6
	db	32,28,4
	; Position 7, pattern 7
	db	32,28,-2,4
	; Position 12, pattern 12
	db	32,28,4
	; Position 13, pattern 13
	db	32,28,4
	; Position 14, pattern 14
	db	0

	; lead, column 1
L_lead_1:
	db	-1,128
	; Position 2, pattern 2
	db	16,8,8,8,8,16
	; Position 3, pattern 3
	db	16,8,8,16,16
	; Position 4, pattern 4
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 5, pattern 5
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 6, pattern 6
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 7, pattern 7
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 8, pattern 8
	db	16,8,8,8,8,16
	; Position 9, pattern 9
	db	16,8,8,16,16
	; Position 10, pattern 10
	db	16,8,8,8,8,16
	; Position 11, pattern 11
	db	16,8,8,16,16
	; Position 12, pattern 12
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 13, pattern 13
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 14, pattern 14
	db	16
	db	0

	; arp, column 1
L_arp_1:
	; Position 0, pattern 0
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 1, pattern 1
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 2, pattern 2
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 3, pattern 3
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 4, pattern 4
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 5, pattern 5
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 6, pattern 6
	db	2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4
	; Position 7, pattern 7
	db	2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
	; Position 8, pattern 8
	db	-1,128
	; Position 10, pattern 10
	db	2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4
	; Position 11, pattern 11
	db	2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
	; Position 12, pattern 12
	db	16,8,8,32
	; Position 13, pattern 13
	db	32,32
	; Position 14, pattern 14
	db	0

	; arp, column 2
L_arp_2:
	db	-3,194
	; Position 11, pattern 11
	db	2,2,2,2,2,6,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,6,2,2,2,2,2
	; Position 12, pattern 12
	db	32,32
	; Position 13, pattern 13
	db	16,16,16,16
	; Position 14, pattern 14
	db	16
	db	0

	; arp, column 3
L_arp_3:
	db	-4,0
	; Position 12, pattern 12
	db	32,8,8,16
	; Position 13, pattern 13
	db	32,16,16
	; Position 14, pattern 14
	db	0

	; arp, column 4
L_arp_4:
	db	-4,64
	; Position 13, pattern 13
	db	16,8,8,16
	db	0

	; arp, column 5
L_arp_5:
	db	-4,96
	; Position 13, pattern 13
	db	0

	; pad, column 1
L_pad_1:
	db	-3,0
	; Position 8, pattern 8
	db	32,8,8,16
	; Position 9, pattern 9
	db	32,32
	; Position 10, pattern 10
	db	32,8,8,16
	; Position 11, pattern 11
	db	32,32
	; Position 12, pattern 12
	db	32,8,8,16
	; Position 13, pattern 13
	db	32,32
	; Position 14, pattern 14
	db	16
	db	0

	; pad, column 2
L_pad_2:
	db	-3,0
	; Position 8, pattern 8
	db	16,8,8,32
	; Position 9, pattern 9
	db	32,16,16
	; Position 10, pattern 10
	db	16,8,8,32
	; Position 11, pattern 11
	db	32,16,16
	; Position 12, pattern 12
	db	16,8,8,32
	; Position 13, pattern 13
	db	32,16,16
	; Position 14, pattern 14
	db	16
	db	0

	; pad, column 3
L_pad_3:
	db	-3,0
	; Position 8, pattern 8
	db	32,32
	; Position 9, pattern 9
	db	16,16,16,16
	; Position 10, pattern 10
	db	32,32
	; Position 11, pattern 11
	db	16,16,16,16
	; Position 12, pattern 12
	db	32,32
	; Position 13, pattern 13
	db	16,16,16,16
	; Position 14, pattern 14
	db	16
	db	0

	; pad, column 4
L_pad_4:
	db	-3,64
	; Position 9, pattern 9
	db	16,8,8,16,80
	; Position 11, pattern 11
	db	16,8,8,16,80
	; Position 13, pattern 13
	db	16,8,8,32
	; Position 14, pattern 14
	db	0


	section notesamp data align=1

_NoteSamples:
	; kick, column 1
S_kick_1:
	; Position 0, pattern 0
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 1, pattern 1
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 2, pattern 2
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 3, pattern 3
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 4, pattern 4
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 5, pattern 5
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 6, pattern 6
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 7, pattern 7
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 8, pattern 8
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 9, pattern 9
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 10, pattern 10
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 11, pattern 11
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 12, pattern 12
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 13, pattern 13
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1

	; snare, column 1
S_snare_1:
	db	0
	; Position 3, pattern 3
	db	1,1,1,1,1,1,1,1
	; Position 4, pattern 4
	db	1,1,1,1,1,1,1,1
	; Position 5, pattern 5
	db	1,1,1,1,1,1,1,1
	; Position 6, pattern 6
	db	1,1,1,1,1,1,1,1
	; Position 7, pattern 7
	db	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	; Position 8, pattern 8
	db	1
	; Position 11, pattern 11
	db	1,1,1,1,1,1,1,1
	; Position 12, pattern 12
	db	1,1,1,1,1,1,1,1
	; Position 13, pattern 13
	db	1,1,1,1,1,1,1,1

	; bass, column 1
S_bass_1:
	; Position 0, pattern 0
	db	3,1,2
	; Position 1, pattern 1
	db	3,1,2
	; Position 2, pattern 2
	db	3,1,2
	; Position 3, pattern 3
	db	3,1,2
	; Position 4, pattern 4
	db	3,1,2
	; Position 5, pattern 5
	db	3,1,2
	; Position 6, pattern 6
	db	3,1,2
	; Position 7, pattern 7
	db	3,1,2
	; Position 12, pattern 12
	db	3,1,2
	; Position 13, pattern 13
	db	3,1,2
	; Position 14, pattern 14
	db	0

	; lead, column 1
S_lead_1:
	db	0
	; Position 2, pattern 2
	db	3,4,5,6,7,5
	; Position 3, pattern 3
	db	6,8,9,10,9
	; Position 4, pattern 4
	db	9,8,5,2,1,9,4,8,11,14,11,10,9,6,4,1,14,12,10,11,9,6,4,13,14,12,11,10,9,11,4,1,6,12,10,15,9,8,6,3,14,12,11,10,9,8,6,3,0,12,11,10,9,8,6,3,14,12,11,10,9,8,6,3
	; Position 5, pattern 5
	db	9,8,5,2,1,9,4,8,11,14,11,10,9,6,4,1,14,12,10,11,9,6,4,13,14,12,11,10,9,11,4,1,6,12,10,15,9,8,6,3,14,12,11,10,9,8,6,3,0,12,11,10,9,8,6,3,14,12,11,10,9,8,6,3
	; Position 6, pattern 6
	db	9,8,5,2,1,9,4,8,11,14,11,10,9,6,4,1,14,12,10,11,9,6,4,13,14,12,11,10,9,11,4,1,6,12,10,15,9,8,6,3,14,12,11,10,9,8,6,3,0,12,11,10,9,8,6,3,14,12,11,10,9,8,6,3
	; Position 7, pattern 7
	db	9,8,5,2,1,9,4,8,11,14,11,10,9,6,4,1,14,12,10,11,9,6,4,13,14,12,11,10,9,11,4,1,6,12,10,15,9,8,6,3,14,12,11,10,9,8,6,3,0,12,11,10,9,8,6,3,14,12,11,10,9,8,6,3
	; Position 8, pattern 8
	db	3,4,5,6,7,5
	; Position 9, pattern 9
	db	6,8,9,10,9
	; Position 10, pattern 10
	db	3,4,5,6,7,5
	; Position 11, pattern 11
	db	6,8,9,10,9
	; Position 12, pattern 12
	db	9,8,5,2,1,9,4,8,11,14,11,10,9,6,4,1,14,12,10,11,9,6,4,13,14,12,11,10,9,11,4,1,6,12,10,15,9,8,6,3,14,12,11,10,9,8,6,3,0,12,11,10,9,8,6,3,14,12,11,10,9,8,6,3
	; Position 13, pattern 13
	db	9,8,5,2,1,9,4,8,11,14,11,10,9,6,4,1,14,12,10,11,9,6,4,13,14,12,11,10,9,11,4,1,6,12,10,15,9,8,6,3,14,12,11,10,9,8,6,3,0,12,11,10,9,8,6,3,14,12,11,10,9,8,6,3
	; Position 14, pattern 14
	db	8,0

	; arp, column 1
S_arp_1:
	; Position 0, pattern 0
	db	3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,1,4,7,10,3,13,15,6,1,4,7,9,10,13,15,17,1,4,7,10,11,13,1,17,6,4,1,11,2,5,9,13
	; Position 1, pattern 1
	db	3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,1,4,7,10,3,13,15,6,1,4,7,9,10,13,15,17,1,4,7,10,11,13,1,17,6,4,1,11,2,5,9,13
	; Position 2, pattern 2
	db	3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,1,4,7,10,3,13,15,6,1,4,7,9,10,13,15,17,1,4,7,10,11,13,1,17,6,4,1,11,2,5,9,13
	; Position 3, pattern 3
	db	3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,1,4,7,10,3,13,15,6,1,4,7,9,10,13,15,17,1,4,7,10,11,13,1,17,6,4,1,11,2,5,9,13
	; Position 4, pattern 4
	db	9,13,16,17,18,20,21,23,9,13,16,17,18,20,21,9,13,16,17,18,20,21,23,9,13,16,17,18,20,21,7,11,14,17,9,20,21,13,7,11,14,16,17,20,21,23,7,11,14,17,18,20,7,23,13,11,7,18,8,12,16,20
	; Position 5, pattern 5
	db	3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,1,4,7,10,3,13,15,6,1,4,7,9,10,13,15,17,1,4,7,10,11,13,1,17,6,4,1,11,2,5,9,13
	; Position 6, pattern 6
	db	3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,3,6,9,10,11,13,15,17,3,6,9,10,11,13,15
	; Position 7, pattern 7
	db	1,4,7,10,3,13,15,6,1,4,7,9,10,13,15,17,1,4,7,10,11,13,1,17,6,4,1,11,2,5,9,13
	; Position 8, pattern 8
	db	0
	; Position 10, pattern 10
	db	3,6,9,10,11,13,15,17,3,6,9,10,11,13,15,3,6,9,10,11,13,15,17,3,6,9,10,11,13,15
	; Position 11, pattern 11
	db	1,0,7,0,3,0,15,6,1,0,7,0,10,0,15,0,1,0,7,0,11,0,1,0,6,4,1,0,2,0,9,0
	; Position 12, pattern 12
	db	22,24,25,19
	; Position 13, pattern 13
	db	16,15
	; Position 14, pattern 14
	db	0

	; arp, column 2
S_arp_2:
	db	0
	; Position 11, pattern 11
	db	1,0,4,0,6,0,1,0,3,0,6,0,8,0,1,0,4,0,6,0,8,0,5,0,2,0,6
	; Position 12, pattern 12
	db	9,7
	; Position 13, pattern 13
	db	10,13,12,11
	; Position 14, pattern 14
	db	3,0

	; arp, column 3
S_arp_3:
	db	0
	; Position 12, pattern 12
	db	1,4,5,3
	; Position 13, pattern 13
	db	2,0,5
	; Position 14, pattern 14
	db	0

	; arp, column 4
S_arp_4:
	db	0
	; Position 13, pattern 13
	db	3,1,2,4,0

	; arp, column 5
S_arp_5:
	db	0
	; Position 13, pattern 13
	db	1

	; pad, column 1
S_pad_1:
	db	0
	; Position 8, pattern 8
	db	3,6,7,5
	; Position 9, pattern 9
	db	3,2
	; Position 10, pattern 10
	db	3,6,7,5
	; Position 11, pattern 11
	db	3,2
	; Position 12, pattern 12
	db	3,4,7,5
	; Position 13, pattern 13
	db	3,2
	; Position 14, pattern 14
	db	1,0

	; pad, column 2
S_pad_2:
	db	0
	; Position 8, pattern 8
	db	5,7,8,4
	; Position 9, pattern 9
	db	1,0,6
	; Position 10, pattern 10
	db	5,7,8,4
	; Position 11, pattern 11
	db	1,7,6
	; Position 12, pattern 12
	db	5,7,8,2
	; Position 13, pattern 13
	db	1,7,6
	; Position 14, pattern 14
	db	3,0

	; pad, column 3
S_pad_3:
	db	0
	; Position 8, pattern 8
	db	3,2
	; Position 9, pattern 9
	db	0,6,5,4
	; Position 10, pattern 10
	db	3,2
	; Position 11, pattern 11
	db	5,6,7,4
	; Position 12, pattern 12
	db	3,7
	; Position 13, pattern 13
	db	5,6,7,4
	; Position 14, pattern 14
	db	1,0

	; pad, column 4
S_pad_4:
	db	0
	; Position 9, pattern 9
	db	5,3,0,6,0
	; Position 11, pattern 11
	db	2,3,4,1,0
	; Position 13, pattern 13
	db	2,3,4,1
	; Position 14, pattern 14
	db	0

