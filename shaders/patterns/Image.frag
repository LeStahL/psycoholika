const float fsaa = 144.;

void mainImage( out vec4 fragColor, in vec2 fragCoord )
{
    vec2 uv = fragCoord/iResolution.xy,
        unit = 1./iResolution.xy;
        
    spb = 60./bpm;
    stepTime = mod(iTime+.5*spb, spb)-.5*spb;
    nbeats = (iTime-stepTime+.5*spb)/spb + smoothstep(-.2*spb, .2*spb, stepTime);
    
    // SSAA
    vec3 col = c.yyy;
    float bound = sqrt(fsaa)-1.;
    for(float i = -.5*bound; i<=.5*bound; i+=1.)
        for(float j=-.5*bound; j<=.5*bound; j+=1.)
            col += texture(iChannel0, uv+vec2(i,j)*2./max(bound, 1.)*unit).xyz;
    col /= fsaa;
    fragColor = vec4(col, 1.);
    
    
    //unit = 2./iResolution.xy;
    
//*
    // edge glow
    //unit *= 1.5;
    
    vec4 col11 = texture(iChannel0, uv - unit),
        col13 = texture(iChannel0, uv + unit*c.xz),
        col31 = texture(iChannel0, uv + unit*c.zx),
        col33 = texture(iChannel0, uv + unit),
        x = col33 -col11 -3.* texture(iChannel0, uv + unit*c.yz) -col13 + col31 + 3.*texture(iChannel0, uv + unit*c.yx),
        y = col33 -col11 -3.* texture(iChannel0, uv + unit*c.zy) -col31 + col13 + 3.*texture(iChannel0, uv + unit*c.xy);
    fragColor = vec4(col + 1.*(abs(y.rgb) + abs(x.rgb)).rgb,1.);
//*/  

    //fragColor = fragColor + fragColor*fragColor + fragColor*fragColor*fragColor;
    // Vignette
    //uv *=  1. - uv.yx;
    //fragColor *= pow(uv.x*uv.y * 15., .2);
    
    // Grain
        fragColor.rgb += .04*fract(sin(dot(uv+13.36, vec2(12.9898, 4.1414))) * 43758.5453)*c.xxx;
        fragColor.rgb = clamp(fragColor.rgb,0.,1.);
}