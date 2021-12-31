/* Psycoholika
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
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

int frame = 0;
int screenshot(char *fileName)
{    
    static unsigned char header[54] = {
    0x42, 0x4D, 0x36, 0x00, 0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x36, 0x00, 0x00, 0x00, 0x28, 0x00,
    0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x18, 0x00, 0x00, 0x00,
    0x00, 0x00, 0x00, 0x00, 0x03, 0x00, 0xC4, 0x0E, 0x00, 0x00, 0xC4, 0x0E, 0x00, 0x00, 0x00, 0x00,
    0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    unsigned char *pixels = (unsigned char *) malloc(WIDTH * HEIGHT * 3);
    ((unsigned __int16 *) header)[ 9] = WIDTH;
    ((unsigned __int16 *) header)[11] = HEIGHT;

    glReadPixels(0,0,WIDTH,HEIGHT,GL_RGB,GL_UNSIGNED_BYTE,pixels);

    unsigned char temp;
    for (unsigned int i = 0; i < WIDTH * HEIGHT * 3; i += 3)
    {
        temp = pixels[i];
        pixels[i] = pixels[i + 2];
        pixels[i + 2] = temp;
    }

    HANDLE FileHandle;
    unsigned long Size;

    if (fileName == NULL)
    {
        char file[256];
        do 
        {
            char buf[100];
            SYSTEMTIME st;
            GetLocalTime(&st);
            sprintf(buf, "%.8d", frame);
//             printf("buf: %s\n", buf);
            sprintf(file,"Screenshot%s.bmp",buf);
//             printf("file: %s\n", file);
            FileHandle = CreateFile(file,GENERIC_WRITE,0,NULL,CREATE_NEW,FILE_ATTRIBUTE_NORMAL,NULL);
        } while (FileHandle == INVALID_HANDLE_VALUE);
    } 
    else 
    {
        FileHandle = CreateFile(fileName,GENERIC_WRITE,0,NULL,CREATE_ALWAYS,FILE_ATTRIBUTE_NORMAL,NULL);
        if (FileHandle == INVALID_HANDLE_VALUE) return 0;
    }

    WriteFile(FileHandle,header,sizeof(header),&Size,NULL);
    WriteFile(FileHandle,pixels,WIDTH * HEIGHT * 3,&Size,NULL);

    CloseHandle(FileHandle);

    free(pixels);

	++frame;

    return 1;
}

#define MINIMP3_ONLY_MP3
#define MINIMP3_IMPLEMENTATION
#define MINIMP3_FLOAT_OUTPUT
#include <minimp3.h>
#include <minimp3_ex.h>

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

	HWAVEOUT hWaveOut;

	mp3dec_ex_t dec;
	mp3dec_ex_open(&dec, "msx.mp3", MP3D_SEEK_TO_SAMPLE);
	float *lpSoundBuffer = (float*)malloc(dec.samples*sizeof(float));

	WAVEFORMATEX WaveFMT =
	{
		WAVE_FORMAT_IEEE_FLOAT,	
		2, // channels
		44100, // samples per sec
		44100*sizeof(float)*2, // bytes per sec
		sizeof(float)*2, // block alignment;
		sizeof(float)*8, // bits per sample
		0 // extension not needed
	};

	WAVEHDR WaveHDR = 
	{
		(LPSTR)lpSoundBuffer, 
		dec.samples*sizeof(float),			// MAX_SAMPLES*sizeof(float)*2(stereo)
		0, 
		0, 
		0, 
		0, 
		0, 
		0
	};

    mp3dec_ex_read(&dec, (mp3d_sample_t *)lpSoundBuffer, dec.samples);

	waveOutOpen(&hWaveOut, WAVE_MAPPER, &WaveFMT, NULL, 0, CALLBACK_NULL);
	waveOutPrepareHeader(hWaveOut, &WaveHDR, sizeof(WaveHDR));
	waveOutWrite(hWaveOut, &WaveHDR, sizeof(WaveHDR));

	float t = 0.;

	do 
	{
		waveOutGetPosition(hWaveOut, &MMTime, sizeof(MMTIME));

		((PFNGLUNIFORM1FPROC)wglGetProcAddress("glUniform1f"))(0, t);

		// Passes
		((PFNGLBINDFRAMEBUFFERPROC)wglGetProcAddress("glBindFramebuffer"))(GL_FRAMEBUFFER, firstPassFramebuffer);
		((PFNGLUNIFORM1IPROC)wglGetProcAddress("glUniform1i"))(1, 0);
		
		glRectf(-1, -1, 1, 1);

		((PFNGLBINDFRAMEBUFFERPROC)wglGetProcAddress("glBindFramebuffer"))(GL_FRAMEBUFFER, 0);
		((PFNGLUNIFORM1IPROC)wglGetProcAddress("glUniform1i"))(1, 1);
		
		glRectf(-1, -1, 1, 1);
	
		SwapBuffers(hDC);

		MSG msg = {0};
		while (PeekMessageA(&msg, NULL, 0, 0, PM_REMOVE))
		{
			if(msg.message == WM_KEYDOWN && msg.wParam == VK_ESCAPE)
			{
				ExitProcess(0);
			}
			
			DispatchMessageA(&msg);
		}

		screenshot(nullptr);

		t += 1./60.;

	} while (
		t * 44100. < dec.samples/2
	);
	
	ExitProcess(0);
}}
