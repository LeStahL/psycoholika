/* Abstraction-Confusion
 * Copyright (C) 2021  Alexander Kraus <nr4@z10.info>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

#define WIDTH 1920
#define HEIGHT 1080

#define WIN32_LEAN_AND_MEAN
#define WIN32_EXTRA_LEAN
#include <Windows.h>
#include "mmsystem.h"
#include "mmreg.h"
#include <Shlwapi.h>
#include <gl/GL.h>
#include "glext.h"

#ifdef BUILD_OIDOS
#include "oidos.h"
#else
#include "4klang.h"

SAMPLE_TYPE	lpSoundBuffer[MAX_SAMPLES*2];  
HWAVEOUT	hWaveOut;

#pragma data_seg(".wavefmt")
WAVEFORMATEX WaveFMT =
{
#ifdef FLOAT_32BIT	
	WAVE_FORMAT_IEEE_FLOAT,
#else
	WAVE_FORMAT_PCM,
#endif		
    2, // channels
    SAMPLE_RATE, // samples per sec
    SAMPLE_RATE*sizeof(SAMPLE_TYPE)*2, // bytes per sec
    sizeof(SAMPLE_TYPE)*2, // block alignment;
    sizeof(SAMPLE_TYPE)*8, // bits per sample
    0 // extension not needed
};

#pragma data_seg(".wavehdr")
WAVEHDR WaveHDR = 
{
	(LPSTR)lpSoundBuffer, 
	MAX_SAMPLES*sizeof(SAMPLE_TYPE)*2,			// MAX_SAMPLES*sizeof(float)*2(stereo)
	0, 
	0, 
	0, 
	0, 
	0, 
	0
};

#pragma code_seg(".initsnd")
void  InitSound()
{
#ifdef USE_SOUND_THREAD
	// thx to xTr1m/blu-flame for providing a smarter and smaller way to create the thread :)
	CreateThread(0, 0, (LPTHREAD_START_ROUTINE)_4klang_render, lpSoundBuffer, 0, 0);
#else
	_4klang_render(lpSoundBuffer);
#endif
	waveOutOpen			( &hWaveOut, WAVE_MAPPER, &WaveFMT, NULL, 0, CALLBACK_NULL );
	waveOutPrepareHeader( hWaveOut, &WaveHDR, sizeof(WaveHDR) );
	waveOutWrite		( hWaveOut, &WaveHDR, sizeof(WaveHDR) );	
}
#endif

MMTIME MMTime = 
{ 
	TIME_SAMPLES,
	0
};


extern "C" 
{
	int _fltused = 1;
}

typedef GLuint (APIENTRYP PFNGLCREATESHADERPROGRAMVPROC) (GLenum type, GLsizei count, const GLchar *const*strings);

typedef struct {
	BYTE dmDeviceName[CCHDEVICENAME];
	WORD dmSpecVersion;
	WORD dmDriverVersion;
	WORD dmSize;
	WORD dmDriverExtra;
	DWORD dmFields;
	union {
		struct {
			short dmOrientation;
			short dmPaperSize;
			short dmPaperLength;
			short dmPaperWidth;
			short dmScale;
			short dmCopies;
			short dmDefaultSource;
			short dmPrintQuality;
		};
	
		struct {
			POINTL dmPosition;
			DWORD dmDisplayOrientation;
			DWORD dmDisplayFixedOutput;
		};
	};

	short dmColor;
	short dmDuplex;
	short dmYResolution;
	short dmTTOption;
	short dmCollate;
	BYTE dmFormName[CCHFORMNAME];
	WORD dmLogPixels;
	DWORD dmBitsPerPel;
	DWORD dmPelsWidth;
	DWORD dmPelsHeight;
	union {
		DWORD dmDisplayFlags;
		DWORD dmNup;
	};

	DWORD dmDisplayFrequency;
} HGDEVMODE;

#pragma data_seg("devmode")
static HGDEVMODE devmode = {
	{0}, 0, 0, sizeof(HGDEVMODE), 0, DM_PELSWIDTH | DM_PELSHEIGHT,
	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, {0}, 0, 0, WIDTH, HEIGHT, 0, 0
};

#pragma data_seg("pfd")
static const PIXELFORMATDESCRIPTOR pfd = {
	sizeof(PIXELFORMATDESCRIPTOR), 1,
	PFD_DRAW_TO_WINDOW|PFD_SUPPORT_OPENGL|PFD_DOUBLEBUFFER,
	PFD_TYPE_RGBA, 32, 0, 0, 0, 0, 0, 0, 8, 0,
	0, 0, 0, 0, 0, 32, 0, 0, PFD_MAIN_PLANE, 0, 0, 0, 0
};

#pragma data_seg("glsl0")
#include "gfx.h"

#pragma code_seg("mainloop")
void __declspec(naked) __stdcall demo(void) {{
	__asm mov ebp, esp
	__asm sub esp, __LOCAL_SIZE
	
#ifdef BUILD_OIDOS
	Oidos_FillRandomData();
	Oidos_GenerateMusic();
#endif
	
	ChangeDisplaySettingsA((DEVMODEA*)&devmode, CDS_FULLSCREEN);
	HWND hWnd = CreateWindowExA(0, (char*)0xc019, 0, WS_POPUP|WS_VISIBLE|WS_MAXIMIZE, 0, 0, 0, 0, 0, 0, 0, 0);
	ShowCursor(0);

	HDC hDC = GetDC(hWnd);
	SetPixelFormat(hDC, ChoosePixelFormat(hDC, &pfd), &pfd);
	wglMakeCurrent(hDC, wglCreateContext(hDC));
	GLint program = ((PFNGLCREATESHADERPROGRAMVPROC)wglGetProcAddress("glCreateShaderProgramv"))(GL_FRAGMENT_SHADER, 1, &gfx_frag);
	((PFNGLUSEPROGRAMPROC)wglGetProcAddress("glUseProgram"))(program);

	GLuint firstPassFramebuffer,
		firstPassTexture = 0;

	glGenTextures(1, &firstPassTexture);
	((PFNGLGENFRAMEBUFFERSPROC)wglGetProcAddress("glGenFramebuffers"))(1, &firstPassFramebuffer);
	glDrawBuffer(GL_COLOR_ATTACHMENT0);

	((PFNGLACTIVETEXTUREPROC)wglGetProcAddress("glActiveTexture"))(GL_TEXTURE0);
	glBindTexture(GL_TEXTURE_2D, firstPassTexture);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
	glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA32F, WIDTH, HEIGHT, 0, GL_RGBA, GL_FLOAT, 0);

	((PFNGLBINDFRAMEBUFFERPROC)wglGetProcAddress("glBindFramebuffer"))(GL_FRAMEBUFFER, firstPassFramebuffer);
	((PFNGLFRAMEBUFFERTEXTURE2DPROC)wglGetProcAddress("glFramebufferTexture2D"))(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, firstPassTexture, 0);
	((PFNGLUNIFORM1IPROC)wglGetProcAddress("glUniform1i"))(2, 0);


#ifdef BUILD_OIDOS
	float sample;
	Oidos_StartMusic();
#else
	InitSound();
#endif

	do 
	{

#ifdef BUILD_OIDOS
		sample = Oidos_GetPosition();

		((PFNGLUNIFORM1FPROC)wglGetProcAddress("glUniform1f"))(0, sample/(float)Oidos_TicksPerSecond);		
#else
		waveOutGetPosition(hWaveOut, &MMTime, sizeof(MMTIME));

		((PFNGLUNIFORM1FPROC)wglGetProcAddress("glUniform1f"))(0, (float)MMTime.u.sample / (float)SAMPLE_RATE);
#endif

		// Passes
		((PFNGLBINDFRAMEBUFFERPROC)wglGetProcAddress("glBindFramebuffer"))(GL_FRAMEBUFFER, firstPassFramebuffer);
		((PFNGLUNIFORM1IPROC)wglGetProcAddress("glUniform1i"))(1, 0);
		
		glRectf(-1, -1, 1, 1);
		// glFlush();

		((PFNGLBINDFRAMEBUFFERPROC)wglGetProcAddress("glBindFramebuffer"))(GL_FRAMEBUFFER, 0);
		((PFNGLUNIFORM1IPROC)wglGetProcAddress("glUniform1i"))(1, 1);
		
		glRectf(-1, -1, 1, 1);
		// glFlush();
	
		SwapBuffers(hDC);

		MSG msg = {0};
		while (PeekMessageA(&msg, NULL, 0, 0, PM_REMOVE))
		{
			if(msg.message == WM_KEYDOWN)
			{
				ExitProcess(0);
			}
			
			// TranslateMessage(&msg);
			DispatchMessageA(&msg);
		}
	} while (
#ifdef BUILD_OIDOS
		sample < Oidos_MusicLength
#else 
		MMTime.u.sample < MAX_SAMPLES
#endif
	);
	
	ExitProcess(0);
}}
