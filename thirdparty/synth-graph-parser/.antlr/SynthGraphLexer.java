// Generated from c:\Demo\4krap\thirdparty\synth-graph-parser\SynthGraph.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SynthGraphLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OSC=1, LFO=2, ENV=3, BLOCK=4, FILTER=5, REVERB=6, DIST=7, DETUNE=8, FREQ=9, 
		PHASE=10, SHAPE=11, ATTACK=12, DECAY=13, SUSTAIN=14, RELEASE=15, MAIN=16, 
		IDENTIFIER=17, FLOAT=18, INT=19, COMMENT=20, NEWLINE=21, WHITESPACE=22, 
		STRING=23, DIGIT=24, ALPHA=25, PLUS=26, MINUS=27, TIMES=28, DIVBY=29, 
		EQUALS=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OSC", "LFO", "ENV", "BLOCK", "FILTER", "REVERB", "DIST", "DETUNE", "FREQ", 
			"PHASE", "SHAPE", "ATTACK", "DECAY", "SUSTAIN", "RELEASE", "MAIN", "IDENTIFIER", 
			"FLOAT", "INT", "COMMENT", "NEWLINE", "WHITESPACE", "STRING", "DIGIT", 
			"ALPHA", "PLUS", "MINUS", "TIMES", "DIVBY", "EQUALS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'osc'", "'lfo'", "'env'", "'block'", "'filter'", "'reverb'", "'dist'", 
			"'detune'", "'freq'", "'phase'", "'shape'", "'attack'", "'decay'", "'sustain'", 
			"'release'", "'main'", null, null, null, null, null, null, null, null, 
			null, "'+'", "'-'", "'*'", "'/'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OSC", "LFO", "ENV", "BLOCK", "FILTER", "REVERB", "DIST", "DETUNE", 
			"FREQ", "PHASE", "SHAPE", "ATTACK", "DECAY", "SUSTAIN", "RELEASE", "MAIN", 
			"IDENTIFIER", "FLOAT", "INT", "COMMENT", "NEWLINE", "WHITESPACE", "STRING", 
			"DIGIT", "ALPHA", "PLUS", "MINUS", "TIMES", "DIVBY", "EQUALS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SynthGraphLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SynthGraph.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u010b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\6\22\u00a1"+
		"\n\22\r\22\16\22\u00a2\3\22\3\22\3\22\7\22\u00a8\n\22\f\22\16\22\u00ab"+
		"\13\22\3\23\6\23\u00ae\n\23\r\23\16\23\u00af\3\23\3\23\7\23\u00b4\n\23"+
		"\f\23\16\23\u00b7\13\23\3\23\7\23\u00ba\n\23\f\23\16\23\u00bd\13\23\3"+
		"\23\3\23\6\23\u00c1\n\23\r\23\16\23\u00c2\5\23\u00c5\n\23\3\23\3\23\3"+
		"\23\3\23\6\23\u00cb\n\23\r\23\16\23\u00cc\5\23\u00cf\n\23\5\23\u00d1\n"+
		"\23\3\24\6\24\u00d4\n\24\r\24\16\24\u00d5\3\25\3\25\7\25\u00da\n\25\f"+
		"\25\16\25\u00dd\13\25\3\25\5\25\u00e0\n\25\3\25\5\25\u00e3\n\25\3\25\3"+
		"\25\3\26\5\26\u00e8\n\26\3\26\3\26\3\26\3\26\3\27\6\27\u00ef\n\27\r\27"+
		"\16\27\u00f0\3\27\3\27\3\30\3\30\7\30\u00f7\n\30\f\30\16\30\u00fa\13\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= \3\2\6\4\2\f\f\17\17\5\2\13\f\16\17\"\"\3\2$$\4\2C"+
		"\\c|\2\u011f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5C\3\2\2\2\7G\3\2\2\2\tK\3\2\2"+
		"\2\13Q\3\2\2\2\rX\3\2\2\2\17_\3\2\2\2\21d\3\2\2\2\23k\3\2\2\2\25p\3\2"+
		"\2\2\27v\3\2\2\2\31|\3\2\2\2\33\u0083\3\2\2\2\35\u0089\3\2\2\2\37\u0091"+
		"\3\2\2\2!\u0099\3\2\2\2#\u00a0\3\2\2\2%\u00c4\3\2\2\2\'\u00d3\3\2\2\2"+
		")\u00d7\3\2\2\2+\u00e7\3\2\2\2-\u00ee\3\2\2\2/\u00f4\3\2\2\2\61\u00fd"+
		"\3\2\2\2\63\u00ff\3\2\2\2\65\u0101\3\2\2\2\67\u0103\3\2\2\29\u0105\3\2"+
		"\2\2;\u0107\3\2\2\2=\u0109\3\2\2\2?@\7q\2\2@A\7u\2\2AB\7e\2\2B\4\3\2\2"+
		"\2CD\7n\2\2DE\7h\2\2EF\7q\2\2F\6\3\2\2\2GH\7g\2\2HI\7p\2\2IJ\7x\2\2J\b"+
		"\3\2\2\2KL\7d\2\2LM\7n\2\2MN\7q\2\2NO\7e\2\2OP\7m\2\2P\n\3\2\2\2QR\7h"+
		"\2\2RS\7k\2\2ST\7n\2\2TU\7v\2\2UV\7g\2\2VW\7t\2\2W\f\3\2\2\2XY\7t\2\2"+
		"YZ\7g\2\2Z[\7x\2\2[\\\7g\2\2\\]\7t\2\2]^\7d\2\2^\16\3\2\2\2_`\7f\2\2`"+
		"a\7k\2\2ab\7u\2\2bc\7v\2\2c\20\3\2\2\2de\7f\2\2ef\7g\2\2fg\7v\2\2gh\7"+
		"w\2\2hi\7p\2\2ij\7g\2\2j\22\3\2\2\2kl\7h\2\2lm\7t\2\2mn\7g\2\2no\7s\2"+
		"\2o\24\3\2\2\2pq\7r\2\2qr\7j\2\2rs\7c\2\2st\7u\2\2tu\7g\2\2u\26\3\2\2"+
		"\2vw\7u\2\2wx\7j\2\2xy\7c\2\2yz\7r\2\2z{\7g\2\2{\30\3\2\2\2|}\7c\2\2}"+
		"~\7v\2\2~\177\7v\2\2\177\u0080\7c\2\2\u0080\u0081\7e\2\2\u0081\u0082\7"+
		"m\2\2\u0082\32\3\2\2\2\u0083\u0084\7f\2\2\u0084\u0085\7g\2\2\u0085\u0086"+
		"\7e\2\2\u0086\u0087\7c\2\2\u0087\u0088\7{\2\2\u0088\34\3\2\2\2\u0089\u008a"+
		"\7u\2\2\u008a\u008b\7w\2\2\u008b\u008c\7u\2\2\u008c\u008d\7v\2\2\u008d"+
		"\u008e\7c\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090\36\3\2\2\2\u0091"+
		"\u0092\7t\2\2\u0092\u0093\7g\2\2\u0093\u0094\7n\2\2\u0094\u0095\7g\2\2"+
		"\u0095\u0096\7c\2\2\u0096\u0097\7u\2\2\u0097\u0098\7g\2\2\u0098 \3\2\2"+
		"\2\u0099\u009a\7o\2\2\u009a\u009b\7c\2\2\u009b\u009c\7k\2\2\u009c\u009d"+
		"\7p\2\2\u009d\"\3\2\2\2\u009e\u00a1\5\63\32\2\u009f\u00a1\7a\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a9\3\2\2\2\u00a4\u00a8\5\63\32\2\u00a5"+
		"\u00a8\7a\2\2\u00a6\u00a8\5\61\31\2\u00a7\u00a4\3\2\2\2\u00a7\u00a5\3"+
		"\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa$\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\5\61\31"+
		"\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b5\7\60\2\2\u00b2\u00b4\5\61\31"+
		"\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00c5\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\5\61\31\2"+
		"\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\7\60\2\2"+
		"\u00bf\u00c1\5\61\31\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00ad\3\2\2\2\u00c4"+
		"\u00bb\3\2\2\2\u00c5\u00d0\3\2\2\2\u00c6\u00ce\7g\2\2\u00c7\u00cf\7-\2"+
		"\2\u00c8\u00ca\7/\2\2\u00c9\u00cb\5\61\31\2\u00ca\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2"+
		"\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00c8\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d1\3\2\2\2\u00d0\u00c6\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1&\3\2\2\2"+
		"\u00d2\u00d4\5\61\31\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6(\3\2\2\2\u00d7\u00db\7%\2\2\u00d8\u00da"+
		"\n\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00e2\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\7\17"+
		"\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e3\7\f\2\2\u00e2\u00df\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\u00e5\b\25\2\2\u00e5*\3\2\2\2\u00e6\u00e8\7\17\2\2\u00e7\u00e6"+
		"\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7\f\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ec\b\26\2\2\u00ec,\3\2\2\2\u00ed\u00ef\t\3\2\2"+
		"\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b\27\2\2\u00f3.\3\2\2\2\u00f4"+
		"\u00f8\7$\2\2\u00f5\u00f7\n\4\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fb\u00fc\7$\2\2\u00fc\60\3\2\2\2\u00fd\u00fe\4\62;\2"+
		"\u00fe\62\3\2\2\2\u00ff\u0100\t\5\2\2\u0100\64\3\2\2\2\u0101\u0102\7-"+
		"\2\2\u0102\66\3\2\2\2\u0103\u0104\7/\2\2\u01048\3\2\2\2\u0105\u0106\7"+
		",\2\2\u0106:\3\2\2\2\u0107\u0108\7\61\2\2\u0108<\3\2\2\2\u0109\u010a\7"+
		"?\2\2\u010a>\3\2\2\2\26\2\u00a0\u00a2\u00a7\u00a9\u00af\u00b5\u00bb\u00c2"+
		"\u00c4\u00cc\u00ce\u00d0\u00d5\u00db\u00df\u00e2\u00e7\u00f0\u00f8\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}