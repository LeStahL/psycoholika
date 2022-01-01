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
 
float rt = 1.,
    rta = 1.,
    ms = 1.;
vec3 scene(vec3 x)
{
    vec3 sdf;
    if(iTime < 0.);
    else if(iTime < times[0]) // Team210 logo
    {
        // Box210 inside striped box
        RR = rot3(.4*iTime*vec3(1.1,1.3,1.7));
        vec3 y = RR * x;
        sdf = add(vec3(5.,  dbox210(y, 1.2-.5*hash11(hardBeats+1.32)), 0.), vec3(1., -dbox3(x, 1.1*c.xxx+1.*c.xyy), 0.));
    }
    else if(iTime < times[1]) // Greetings
    {
        sdf = vec3(1., -dbox3(x, 1.1*c.xxx+1.*c.xyy), 0.);
        float bbx = dbox3(x, vec3(.7,.1,.11));
        if(bbx < 1.e-2)
        {
            float d = mod(floor(hardBeats/2.), 2.) == 0. ? dbullencoolen(vec2(1.1,2.4)*(x.xy-.01*c.yx)) + .005:dpsycoholika(vec2(1.1,1.7)*x.xy) + .005;
            sdf = add(sdf, vec3(5., zextrude(x.z, d, .1), 0.));
            sdf = add(sdf, vec3(6., zextrude(x.z, d - .01, .05), 0.));
        }
        else sdf = add(sdf, vec3(6., bbx, 0.));
    }
    else if(iTime < times[2]) // Nippelball with tentacles = corona, fck covid text?
    {
        x.xy -= vec2(.4,-.2);

        float bbx = length(x)-.5,
            cc = .2;
        
        sdf = vec3(1., -dbox3(x, 1.1*c.xxx+1.*c.xyy), 0.);
        
        if(bbx<1.e-2)
        {
            RR = rot3(.4*iTime*vec3(1.1,1.3,1.7));
            x = RR * x;
            vec3 a;
            vec2 ai;
            ms = .32-.1*hash11(hardBeats+.112);
            float d = length(x)-ms;
            vec3 y = x;
            for(int i=0; i<4; ++i)
            {
                mat3 RRa = rot3(2.*pi*(2.*hash31(float(i+23))-1.));
                y = RRa * y;
                ai = inverseSF(normalize(y), 40., a);
                y -= a*ms*(1.+.05*cc);
                ms *= cc;
                float da = length(y)-ms;
                d = min(d, da);
                rt = da<1.e-4?float(i)+13.:rt;
            }
            sdf = add(sdf, vec3(8.,  d, 0.));
        }
        else sdf = add(sdf, vec3(8., bbx, 0.));
    }
    else if(iTime < times[3]) // Metaballs in cube
    {
        x.xy -= vec2(.4,-.2);

        float bbx = length(x)-.5;

        sdf = vec3(1., -dbox3(x, 1.1*c.xxx+1.*c.xyy), 0.);
        if(bbx < 1.e-2)
        {
            float d = 1.;
            for(int i=0; i<18; ++i)
            {
                RR = rot3(2.*(-.4+.8*hash31(4.*float(i+55)))*iTime*vec3(1.1,1.3,1.7));
                float da = length(RR*x-.15+.3*hash31(4.*float(i+2))) - .01-.1*hash11(4.*float(i+23));
                d = blendPolynomial2(d, da, .05);
            }
            sdf = add(sdf, vec3(9., d, 0.));
        }
        else sdf = add(sdf, vec3(7., bbx, 0.));
    }
    else if(iTime < times[4]) // ribbons
    {
        x.xy -= vec2(.4,-.2);

        sdf = vec3(1., -dbox3(x, 1.1*c.xxx+1.*c.xyy), 0.);

        // Ribbonz
        vec3 xs = c.yxy*x - .1*vec3(cos(3.*x.y-iTime), 0., sin(3.*x.y-iTime));
        vec3 ns = vec3(cos(3.*x.y-iTime), 0., sin(3.*x.y-iTime));
        mat3 m = ortho(ns),
            mt = transpose(m);
        vec3 y = mt * (x - xs);
        y.x = abs(y.x)-.1;
        y.z = abs(y.z)-.2;
        sdf = add(sdf, vec3(9., dbox3(y, vec3(.003, .1, .1)), 0.));

        // Spherez
        float zs = .5;
        vec3 z = vec3(x.x-xs.x, mod(x.y-.3*iTime, zs)-.5*zs, x.z-xs.z);
        float zj = x.y-.3*iTime-z.y;
        sdf = add(sdf, vec3( 10., length(z+xs.xyz*c.xyx-(.4*hash31(zj+12.35)-.2)*c.xyx)-(.3+.2*hash11(zj))*zs, 0.));
    }
    else if(iTime < times[5]) // Polytopes
    {
        x.xy -= vec2(.4,-.2);
        float bbx = length(x)-.5;

        sdf = vec3(1., -dbox3(x, 1.1*c.xxx+1.*c.xyy), 0.);

        if(bbx<1.e-2)
        {
            for(int i=0; i<3; ++i)
            {
                RR = rot3((-1.+2.*hash31(2.+float(i)))*2.*pi+iTime*.3);
                ms = .5+.5*hash11(float(i+6));
                
                float d = fHedron(RR*x-(-.1+.4*hash31(float(4*i+3))), 6,16, .2*ms, true);
                sdf = add(sdf, vec3(9., d, 0.));
                sdf = add(sdf, vec3(4., fHedron(RR*x-(-.1+.4*hash31(float(4*i+3))), 0,6, .1825*ms, true), 0.));

                rt = d<1.e-3?4.*float(i)+13.:rt;
            }
        }
    }
    else if(iTime < times[6]) // sanduhr shit
    {
        float bbx = length(x)-.5;

        sdf = vec3(1., -dbox3(x, 1.1*c.xxx+1.*c.xyy), 0.);

        if(bbx<1.e-2)
        {
            RR = rot3(c.xxx*2.*pi+iTime*.3);
            sdf = vec3(1., -dbox3(x, 1.1*c.xxx+1.*c.xyy), 0.);

            float i = floor(2.*(.5+.5*lfnoise(.5*nbeats*c.xx))),
                d,
                rm = .3,
                nr = 7.;
            
            for(float r = rm/nr; r <= rm; r += rm/nr)
            {
                vec3 y = rot3(lfnoise((nbeats+r+1335.)*c.xx)*r/rm*pi*c.xxy)*RR*x;
                
                if(lfnoise(.5*nbeats*c.xx+13.23)<0.)
                {
                    if(i<1.)
                        d = dbox3_wireframe(y, .6*r*c.xxx, mix(.05,.1,.5+.5*lfnoise(.5*nbeats*c.xx-13.))*r);
                    else
                        d = dtetrahedron_wireframe(y, .9*r, mix(.025,.05,.5+.5*lfnoise(.5*nbeats*c.xx+13.))*r);
                }
                else
                {
                    if(i<1.)
                        d = dstar(y.xy, .5*r,1.*r, 7.);
                    else if(i<2.)
                        d = (length(y.xy)-.5*r-.5*r*abs(cos(4.*atan(y.y,y.x))))/2.;
                    else
                        d = length(y.xy)-r;

                    d = abs(d)-mix(.075,.475,scale)*rm/nr;
                    d = zextrude(y.z, d, mix(.05,.75,.5+.5*lfnoise(.5*nbeats*c.xx-13.3))*rm/nr);

                }

                if(d-.001 < 1.e-3) rt = r;

                sdf = add(sdf, vec3(12., d-.001, 0.));
            }
        }
        else sdf = add(sdf, vec3(0., bbx, 0.));
    }
    else // Eye Tunnel
    {
        // Tube
        float d = -zextrude(x.z,length(x.xy)-rt*(1.+.2*sin(x.z)), 1.e3);
        sdf = vec3(0., d, 0.);
        
        // Back plane
        sdf = add(sdf, vec3(1., x.z+3., 0.));

        if(iTime > times[7])
        {
            float sa = smoothstep(0.,1.,x.z);
            x.xy -= sa*.3*vec2(lfnoise(x.zz*.3 + .2*iTime), lfnoise(x.zz*.3+.2*iTime+13.));
    
            float bbx = length(x.xy)-.3;
            if(bbx < 1.e-2)
            {
                float zs = 2.;
                float z = mod(x.z - .4*iTime, zs) - .5*zs,
                    zj = x.z - .4*iTime - z;

                float k = 4.+round(8.*hash11(abs(zj))), 
                    r = .1+.1*(.5+.5*lfnoise(vec2(nbeats, zj))),
                    rs = .025+.015*(.5+.5*lfnoise(vec2(nbeats,zj)+2.132));
                float p = atan(x.y,x.x);
                vec3 er = vec3(cos(p), sin(p), 0.),
                    ez = c.yyx,
                    ep = vec3(-sin(p), cos(p), 0.);
                vec3 xs = r*er + .5*ez + rs*er*cos(k*p-iTime) + rs*ez*sin(k*p-iTime),
                    ns = r*ep + rs*vec3(-sin(p)*cos(k*p-iTime)-k*cos(p)*sin(k*p-iTime), cos(p)*cos(k*p-iTime)-k*sin(p)*sin(k*p-iTime), 0.) + rs*ez*k*cos(k*p-iTime);
                mat3 m = ortho(normalize(ns)),
                    mt = transpose(m);
                d = length(mt * (vec3(x.xy, z)-xs))-rs;
                sdf = add(sdf, vec3(10., d, 0.));

                xs = r*er + .5*ez;
                ns = r*ep;
                m = ortho(normalize(ns));
                mt = transpose(m);
                d = length(mt * (vec3(x.xy, z)-xs))-rs;
                sdf = add(sdf, vec3(9., d, 0.));
            }
        }
    }
    
    return sdf;
}

vec3 palette(float scale)
{
    scale = abs(scale);
    const int N = 4;
    vec3 colors[N] = vec3[N](
        vec3(0.91,0.44,0.32),
        vec3(0.91,0.77,0.42),
        vec3(0.16,0.62,0.56),
        vec3(0.15,0.27,0.33)
    );
    float i = floor(scale),
        ip1 = mod(i + 1., float(N));
    return mix(colors[int(i)], colors[int(ip1)], fract(scale));
}

float sm(in float d)
{
    return smoothstep(1.5/iResolution.y, -1.5/iResolution.y, d);
}

vec3 pattern_horizontal_lines(vec2 uv)
{
    float ps = .5,
        dy = mod(uv.y-.4*iTime, ps)-.5*ps,
        d = abs(dy)-.05;
    return mix(c.yyy, c.xxx, sm(d));
}

vec3 pattern_vertical_lines(vec2 uv)
{
    float ps = .5,
        dx = mod(uv.x-.4*iTime, ps)-.5*ps,
        d = abs(dx)-.05;
    return mix(c.yyy, c.xxx, sm(d));
}

vec3 pattern_circles(vec2 uv)
{
    float ps = .5,
        r = length(uv),
        dr = mod(r-.4*iTime, ps)-.5*ps,
        d = abs(dr)-.05;
    return mix(c.yyy, c.xxx, sm(d));
}

vec3 pattern_hexagon(vec2 uv)
{
    uv -= .1*iTime;
    float ys = pi/15.;
    vec4 v = hexCoords(uv/ys)*ys;
    
    return mix(c.yyy, c.xxx, sm(dregularpolygon(mat2(cos(pi/6.), sin(pi/6.), -sin(pi/6.), cos(pi/6.))*v.xy, 1.4*ys*clamp(.4+lfnoise(4.*(mod(v.zw,2.*pi)+13.+.3*iTime)),.1,1.), 6.)));
}

vec3 pattern_truchet_hex_standard(vec2 uv)
{
    uv -= .1*iTime;
    float ys = pi/15.;
    vec4 v = hexCoords(uv/ys)*ys;
    v.z = mod(v.z,2.*pi);
    
    vec2 r = hash22(1.e1*(v.zw+13.));
    
    float phi = -pi/6.+ 2.*pi/3.*floor(r.y*2.99),
        d;
    mat2 rp = mat2(cos(phi), sin(phi), -sin(phi), cos(phi)),
        ra = mat2(cos(pi/6.), sin(pi/6.), -sin(pi/6.), cos(pi/6.)),
        rat = transpose(ra);
    if(r.x <= .7)
    {
        vec2 dt1 = dtspline2(rp*v.xy, .5*ys*c.yz, .01*c.yy, .5*ys*c.yx),
            dt2 = dtspline2(rp*v.xy, .5*ys*rat*rat*c.yz, .01*c.yy, .5*ys*ra*ra*c.yx),
            dt3 = dtspline2(rp*v.xy, .5*ys*ra*ra*ra*ra*c.yz, .01*c.yy, .5*ys*ra*ra*c.yz);
        d = min(min(dt1.x,dt2.x),dt3.x)-.01;
    }
    else if(r.x <= .9)
    {
        vec2 dt1 = dtspline2(v.xy, .5*ys*rat*c.yz, .01*c.yy, .5*ys*ra*c.yz),
            dt2 = dtspline2(v.xy, .5*ys*rat*c.yx, .01*c.yy, .5*ys*rat*rat*rat*c.yx),
            dt3 = dtspline2(v.xy, .5*ys*ra*ra*ra*c.yx, .01*c.yy, .5*ys*ra*c.yx);
        d = min(min(dt1.x,dt2.x),dt3.x)-.01;
    }
    else
    {
        vec2 dt1 = dtline2(rp*v.xy, .5*ys*c.yz, .5*ys*c.yx),
            dt2 = dtline2(rp*v.xy, .5*ra*ra*ys*c.yz, .5*ys*ra*ra*c.yx),
            dt3 = dtline2(rp*v.xy, .5*rat*rat*ys*c.yz, .5*ys*rat*rat*c.yx);
        d = min(min(dt1.x,dt2.x),dt3.x)-.01;
    }
    
    return mix(c.yyy, c.xxx, sm(d));
}

vec3 pattern_truchet_hex_edgy(vec2 uv)
{
    uv -= .1*iTime;
    float ys = pi/14.;
    vec4 v = hexCoords(uv/ys)*ys;
    v.z = mod(v.z,2.*pi);
    
    vec2 r = hash22(1.e1*(v.zw+13.));
    float phi = -pi/6.+ 2.*pi/3.*floor(r.y*2.99), 
        rs = .2*ys;
    mat2 rp = mat2(cos(phi), sin(phi), -sin(phi), cos(phi)),
        ra = mat2(cos(pi/6.), sin(pi/6.), -sin(pi/6.), cos(pi/6.)),
        rat = transpose(ra);

    vec2 dt1 = dtline2_unclamped(rp*v.xy, .5*ys*c.yz, .5*ys*c.yx),
        dt2 = dtline2_unclamped(rp*v.xy, .5*ys*rat*rat*c.yz, .5*ys*ra*ra*c.yx),
        dt3 = dtline2_unclamped(rp*v.xy, .5*ys*ra*ra*ra*ra*c.yz, .5*ys*ra*ra*c.yz);
    float d = min(min(dt1.x-rs,dt2.x-rs*cos(pi/3.)),dt3.x-rs*cos(pi/3.));
    return mix(c.yyy, c.xxx, sm(-d));
}

vec2 as;
bool ray(inout vec3 col, out vec3 x, inout float d, vec3 dir, out vec3 s, vec3 o, vec3 l, out vec3 n, int num)
{
    for(int i=0; i<num; ++i)
    {
        x = o + d * dir;
        s = scene(x);
        
        if(s.y < 1.e-4)
        {
            // Blinn-Phong Illumination
            float dx = 5.e-5;
            n = normalize(vec3(
                scene(x+dx*c.xyy).y, 
                scene(x+dx*c.yxy).y, 
                scene(x+dx*c.yyx).y
            )-s.y);
            
            vec3 ads = vec3(.5,.4,.3);
            float smoothness = .1;
            float r0 = .9;

            if(s.x == 0.) // Tube
            {
                float r = hash11(hardBeats+13.),
                    rp1 = hash11(hardBeats+1.+13.);
                vec2 uv = vec2(rt * atan(x.y,x.x), x.z);
                if(r < .33)
                    col = pattern_truchet_hex_edgy(uv);
                else if(r < .66)
                    col = pattern_truchet_hex_standard(uv);
                else
                    col = pattern_hexagon(uv);

                vec3 c1;
                if(rp1 < .33)
                    c1 = pattern_truchet_hex_edgy(uv);
                else if(rp1 < .66)
                    c1 = pattern_truchet_hex_standard(uv);
                else
                    c1 = pattern_hexagon(uv);

                col = mix(col, c1, smoothstep(0., .5*spb, iTime-hardBeats*spb+.5));

                r0 = .1;
                ads = vec3(.4,.2, .1);
            }
            else if(s.x == 1.) // Back plane
            {
                float s = hash11(hardBeats);
                if(s < .33)
                    col = pattern_horizontal_lines(x.xy);
                else if(s < .66)
                    col = pattern_vertical_lines(x.xy);
                else
                    col = pattern_circles(x.xy);
                col = mix(col, .5*col, hash11(hardBeats+ .31));
                r0 = .1;
                ads = vec3(.8,.4, .1);
            }
            else if(s.x == 2.) // Front plane
            {
                vec2 uv = x.xy;
                col = pattern_vertical_lines(uv);
                r0 = .1;
                ads = vec3(.8,.4, .1);
            }
            else if(s.x == 3.) // Polyhedra color part
            {
                col = mix(vec3(.1,.6,.05), .2*c.xxx, hash11(rt));
                r0 = .1;
                ads = vec3(.8,.4, .1);
            }
            else if(s.x == 4.) // Polyhedra white part
            {
                col = .2*c.xxx;
                r0 = .1;
                ads = vec3(.8,.4, .1);
            }
            else if(s.x == 5.) // Logo210
            {
                ads = vec3(.4,.4,.1);
                r0 = .1;
                vec3 y = RR * x;
                col = mix(vec3(.9,.3,.1), .2*c.xxx, sm(-dbox3(1.2*y, .25*(1.1-.5*hash11(hardBeats+1.32))*c.xxx)/1.2));
            }
            else if(s.x == 6.) // Bullencoolen
            {
                ads = vec3(.4,.4,.1);
                r0 = .1;
                col = mix(c.xxx, .2*c.xxx, sm(abs(x.z)-.045));
            }
            else if(s.x == 7.) // Metaballs
            {
                ads = vec3(.4,.4,.1);
                r0 = .1;
                col = mix(c.xxx, .2*c.xxx, .5+.5*lfnoise(5.*x.xy));
            }
            else if(s.x == 8.) // Nippelball
            {
                ads = vec3(.4,.4,.1);
                r0 = .1;
                col = mix(vec3(.9,.5,.3), .2*c.xxx, hash31(rt));
            }
            else if(s.x == 9.) // Ribbons
            {
                ads = vec3(.4,.4,.1);
                r0 = .1;
                col = vec3(.9,.5,.3);
            }
            else if(s.x == 10.) // Spherez
            {
                ads = vec3(.4,.4,.1);
                r0 = .1;
                col = .2*c.xxx;
            }
            else if(s.x == 11.)
            {
                ads = vec3(.4,.4,.1);
                r0 = .1;
                col = mix(vec3(.2,.9,.3), .2*c.xxx, step(.5,hash11(rta)));
            }
            else if(s.x == 12.)
            {
                ads = vec3(.4,.4,.1);
                r0 = .1;
                col = mix(vec3(.5,.9,.3), .2*c.xxx, hash11(rt));
            }
            
            // Schlick
            ads.z += r0 + (1. - r0) * pow(clamp((1. - dot(n, -dir)), 0., 1.), 5.) * smoothness;

            col = ads.x * col
                + ads.y * col * max(dot(normalize(l-x),n),0.)
                + ads.z * col * pow(max(dot(reflect(normalize(l-x),n),dir),0.),2.);
                    
            if(s.x == -1.) col = c.yyy;
                    
            return true;
        }

        d += s.y<5.e-1?min(s.y,6.e-3):min(s.y,1.e-2);
    }
    return false;
}

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
    
    vec3 
        o = c.yyx;

    o += .3*vec3(lfnoise(c.xx*.3 + .2*iTime), lfnoise(c.xx*.3 + .2*iTime + 13.),0.);

    vec3 t = c.yyy,
        col = c.yyy,
        c1,
        x,
        x1,
        n,
        r = c.xyy,
        dir = normalize(t + uv1.x * r + uv1.y * cross(r,normalize(t-o))-o),
        l = .03*c.zyx,
        s,
        s1;
    float d0 = 0.,
        d;
    
    // Material ray
    if(ray(col, x, d0, dir, s, o, l, n, 1350))
    {
        // Ambient occlusion
        float d = 1.e-2,
            ao = 1.,
            am = 150.;
        
        for(float i=0.; i<=am; i+=1.)
        {
            d += .01;
            ao *= 1.-max(0.,(d-scene(x + d*n).y)/d/am);
        }
        
        col *= ao;
    }
    
    // Text
    vec2 z = uv1.xy - vec2(-.4,.3);
    
    if(iTime < times[1]);
    else if(iTime < times[2])
    {
        float bbx = dbox2(z, vec2(2.28, .1));
        col = mix(col, mix(col, c.xxx, .5), sm(bbx));
        col = mix(col, c.yyy, sm(dfuckcovid(3.*vec2(.8,1.3)*z)));
    }
    else if(iTime < times[3])
    {
        float bbx = dbox2(z, vec2(2.28, .1));
        col = mix(col, mix(col, c.xxx, .5), sm(bbx));
        col = mix(col, c.yyy, sm(dorgelsaft(vec2(2.5, 3.)*z)));
    }
    else if(iTime < times[4]);
    else if(iTime < times[5])
    {
        float bbx = dbox2(z, vec2(2.28, .1));
        col = mix(col, mix(col, c.xxx, .5), sm(bbx));
        col = mix(col, c.yyy, sm(dhubschraubereintopf(3.*vec2(.5,1.2)*(z-.2*c.xy))));
    }
    
    col = hsv2rgb(rgb2hsv(col)*vec3(lfnoise(2.*nbeats*c.xx),1.,1.));
    col = mix(col, 1.5*col, scale);

    // Fade from and to black
    col *= smoothstep(0., 1., iTime) * smoothstep(130., 128., iTime); 

    // scene transitions
    for(int i=0; i<ntimes; ++i)
    {
        col *= smoothstep(0., -.5, iTime-times[i]) + smoothstep(0., .5, iTime-times[i]);
    }
    
    fragColor = mix(texture(iChannel0, uv), vec4(clamp(col,0.,1.),1.), .5);
}
