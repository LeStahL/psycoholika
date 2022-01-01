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
 
void mainImage(out vec4 fragColor, in vec2 fragCoord)
{
    stepTime = mod(iTime+.5*spb, spb)-.5*spb;
    nbeats = (iTime-stepTime+.5*spb)/spb + smoothstep(-.1*spb, .1*spb, stepTime);
    scale = smoothstep(-.3*spb, 0., stepTime)*smoothstep(.3*spb, 0., stepTime);
    hardBeats = round((iTime-stepTime)/spb);
    
    vec2 uv = gl_FragCoord.xy/iResolution.xy,
        unit = 1./iResolution.xy;
    ivec2 index = ivec2(gl_FragCoord.xy);
    
    vec2 uv1 = (gl_FragCoord.xy-.5*iResolution.xy)/iResolution.y;
    
    // SSAA
    vec3 col = c.yyy;
    float bound = sqrt(fsaa)-1.;
    for(float i = -.5*bound; i<=.5*bound; i+=1.)
        for(float j=-.5*bound; j<=.5*bound; j+=1.)
            col += texture(iChannel0, uv+vec2(i,j)*2./max(bound, 1.)*unit).xyz;
    col /= fsaa;
    fragColor = vec4(col, 1.);

    vec4 col11 = texture(iChannel0, uv - unit),
        col13 = texture(iChannel0, uv + unit*c.xz),
        col31 = texture(iChannel0, uv + unit*c.zx),
        col33 = texture(iChannel0, uv + unit),
        x = col33 -col11 -3.* texture(iChannel0, uv + unit*c.yz) -col13 + col31 + 3.*texture(iChannel0, uv + unit*c.yx),
        y = col33 -col11 -3.* texture(iChannel0, uv + unit*c.zy) -col31 + col13 + 3.*texture(iChannel0, uv + unit*c.xy);
    fragColor = vec4(col + 1.*(abs(y.rgb) + abs(x.rgb)).rgb,1.);

    // Grain
    fragColor.rgb += .04*fract(sin(dot(uv+13.36, vec2(12.9898, 4.1414))) * 43758.5453)*c.xxx;
    fragColor.rgb = clamp(fragColor.rgb,0.,1.);
}
