
grammar SynthGraph;
synth_file: synth_node* EOF;

synth_node: synth_node_type name=IDENTIFIER synth_parameter_assignment*;

synth_parameter_assignment: name=synth_parameter_name EQUALS value=synth_expression;

synth_node_type:
    atom=OSC
    | atom=LFO
    | atom=ENV
    | atom=BLOCK
    | atom=FILTER
    | atom=REVERB
    | atom=DIST
    | atom=MAIN
    | atom=DETUNE;

synth_expression: left=synth_expression operator=synth_operator right=synth_expression 
    | synth_value;

synth_value:
    atom=IDENTIFIER
    | atom=FLOAT
    | atom=INT
    | atom=STRING;

synth_operator:
    atom=PLUS 
    | atom=MINUS
    | atom=TIMES
    | atom=DIVBY;

synth_parameter_name:
    atom=FREQ
    | atom=PHASE
    | atom=SHAPE
    | atom=ATTACK
    | atom=DECAY
    | atom=SUSTAIN
    | atom=RELEASE;

OSC: 'osc';
LFO: 'lfo';
ENV: 'env';
BLOCK: 'block';
FILTER: 'filter';
REVERB: 'reverb';
DIST: 'dist';
DETUNE: 'detune';

FREQ: 'freq';
PHASE: 'phase';
SHAPE: 'shape';
ATTACK: 'attack';
DECAY: 'decay';
SUSTAIN: 'sustain';
RELEASE: 'release';
MAIN: 'main';

IDENTIFIER: (ALPHA | '_')+(ALPHA | '_' | DIGIT)*;
FLOAT: (DIGIT+ '.' DIGIT* | DIGIT* '.' DIGIT+) ('e' ('+' | '-' DIGIT+)? )?;
INT: DIGIT+;
COMMENT: '#' ~('\r' | '\n')* ('\r'? '\n')? -> skip;
NEWLINE: ('\r'? '\n') -> skip;
WHITESPACE: (' ' | '\r' | '\n' | '\t' | '\f')+ -> skip;
STRING: '"' ~('"')* '"';
DIGIT: ('0'..'9');
ALPHA: 'a'..'z' | 'A'..'Z';

PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVBY: '/';

EQUALS: '=';