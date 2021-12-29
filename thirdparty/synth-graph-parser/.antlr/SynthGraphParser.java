// Generated from c:\Demo\4krap\thirdparty\synth-graph-parser\SynthGraph.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SynthGraphParser extends Parser {
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
	public static final int
		RULE_synth_file = 0, RULE_synth_node = 1, RULE_synth_parameter_assignment = 2, 
		RULE_synth_node_type = 3, RULE_synth_expression = 4, RULE_synth_value = 5, 
		RULE_synth_operator = 6, RULE_synth_parameter_name = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"synth_file", "synth_node", "synth_parameter_assignment", "synth_node_type", 
			"synth_expression", "synth_value", "synth_operator", "synth_parameter_name"
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

	@Override
	public String getGrammarFileName() { return "SynthGraph.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SynthGraphParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Synth_fileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SynthGraphParser.EOF, 0); }
		public List<Synth_nodeContext> synth_node() {
			return getRuleContexts(Synth_nodeContext.class);
		}
		public Synth_nodeContext synth_node(int i) {
			return getRuleContext(Synth_nodeContext.class,i);
		}
		public Synth_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_file; }
	}

	public final Synth_fileContext synth_file() throws RecognitionException {
		Synth_fileContext _localctx = new Synth_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_synth_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OSC) | (1L << LFO) | (1L << ENV) | (1L << BLOCK) | (1L << FILTER) | (1L << REVERB) | (1L << DIST) | (1L << DETUNE) | (1L << MAIN))) != 0)) {
				{
				{
				setState(16);
				synth_node();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Synth_nodeContext extends ParserRuleContext {
		public Token name;
		public Synth_node_typeContext synth_node_type() {
			return getRuleContext(Synth_node_typeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SynthGraphParser.IDENTIFIER, 0); }
		public List<Synth_parameter_assignmentContext> synth_parameter_assignment() {
			return getRuleContexts(Synth_parameter_assignmentContext.class);
		}
		public Synth_parameter_assignmentContext synth_parameter_assignment(int i) {
			return getRuleContext(Synth_parameter_assignmentContext.class,i);
		}
		public Synth_nodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_node; }
	}

	public final Synth_nodeContext synth_node() throws RecognitionException {
		Synth_nodeContext _localctx = new Synth_nodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_synth_node);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			synth_node_type();
			setState(25);
			((Synth_nodeContext)_localctx).name = match(IDENTIFIER);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FREQ) | (1L << PHASE) | (1L << SHAPE) | (1L << ATTACK) | (1L << DECAY) | (1L << SUSTAIN) | (1L << RELEASE))) != 0)) {
				{
				{
				setState(26);
				synth_parameter_assignment();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Synth_parameter_assignmentContext extends ParserRuleContext {
		public Synth_parameter_nameContext name;
		public Synth_expressionContext value;
		public TerminalNode EQUALS() { return getToken(SynthGraphParser.EQUALS, 0); }
		public Synth_parameter_nameContext synth_parameter_name() {
			return getRuleContext(Synth_parameter_nameContext.class,0);
		}
		public Synth_expressionContext synth_expression() {
			return getRuleContext(Synth_expressionContext.class,0);
		}
		public Synth_parameter_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_parameter_assignment; }
	}

	public final Synth_parameter_assignmentContext synth_parameter_assignment() throws RecognitionException {
		Synth_parameter_assignmentContext _localctx = new Synth_parameter_assignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_synth_parameter_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((Synth_parameter_assignmentContext)_localctx).name = synth_parameter_name();
			setState(33);
			match(EQUALS);
			setState(34);
			((Synth_parameter_assignmentContext)_localctx).value = synth_expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Synth_node_typeContext extends ParserRuleContext {
		public Token atom;
		public TerminalNode OSC() { return getToken(SynthGraphParser.OSC, 0); }
		public TerminalNode LFO() { return getToken(SynthGraphParser.LFO, 0); }
		public TerminalNode ENV() { return getToken(SynthGraphParser.ENV, 0); }
		public TerminalNode BLOCK() { return getToken(SynthGraphParser.BLOCK, 0); }
		public TerminalNode FILTER() { return getToken(SynthGraphParser.FILTER, 0); }
		public TerminalNode REVERB() { return getToken(SynthGraphParser.REVERB, 0); }
		public TerminalNode DIST() { return getToken(SynthGraphParser.DIST, 0); }
		public TerminalNode MAIN() { return getToken(SynthGraphParser.MAIN, 0); }
		public TerminalNode DETUNE() { return getToken(SynthGraphParser.DETUNE, 0); }
		public Synth_node_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_node_type; }
	}

	public final Synth_node_typeContext synth_node_type() throws RecognitionException {
		Synth_node_typeContext _localctx = new Synth_node_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_synth_node_type);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OSC:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				((Synth_node_typeContext)_localctx).atom = match(OSC);
				}
				break;
			case LFO:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				((Synth_node_typeContext)_localctx).atom = match(LFO);
				}
				break;
			case ENV:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				((Synth_node_typeContext)_localctx).atom = match(ENV);
				}
				break;
			case BLOCK:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				((Synth_node_typeContext)_localctx).atom = match(BLOCK);
				}
				break;
			case FILTER:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				((Synth_node_typeContext)_localctx).atom = match(FILTER);
				}
				break;
			case REVERB:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				((Synth_node_typeContext)_localctx).atom = match(REVERB);
				}
				break;
			case DIST:
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				((Synth_node_typeContext)_localctx).atom = match(DIST);
				}
				break;
			case MAIN:
				enterOuterAlt(_localctx, 8);
				{
				setState(43);
				((Synth_node_typeContext)_localctx).atom = match(MAIN);
				}
				break;
			case DETUNE:
				enterOuterAlt(_localctx, 9);
				{
				setState(44);
				((Synth_node_typeContext)_localctx).atom = match(DETUNE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Synth_expressionContext extends ParserRuleContext {
		public Synth_expressionContext left;
		public Synth_operatorContext operator;
		public Synth_expressionContext right;
		public Synth_valueContext synth_value() {
			return getRuleContext(Synth_valueContext.class,0);
		}
		public List<Synth_expressionContext> synth_expression() {
			return getRuleContexts(Synth_expressionContext.class);
		}
		public Synth_expressionContext synth_expression(int i) {
			return getRuleContext(Synth_expressionContext.class,i);
		}
		public Synth_operatorContext synth_operator() {
			return getRuleContext(Synth_operatorContext.class,0);
		}
		public Synth_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_expression; }
	}

	public final Synth_expressionContext synth_expression() throws RecognitionException {
		return synth_expression(0);
	}

	private Synth_expressionContext synth_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Synth_expressionContext _localctx = new Synth_expressionContext(_ctx, _parentState);
		Synth_expressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_synth_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(48);
			synth_value();
			}
			_ctx.stop = _input.LT(-1);
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Synth_expressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_synth_expression);
					setState(50);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(51);
					((Synth_expressionContext)_localctx).operator = synth_operator();
					setState(52);
					((Synth_expressionContext)_localctx).right = synth_expression(3);
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Synth_valueContext extends ParserRuleContext {
		public Token atom;
		public TerminalNode IDENTIFIER() { return getToken(SynthGraphParser.IDENTIFIER, 0); }
		public TerminalNode FLOAT() { return getToken(SynthGraphParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(SynthGraphParser.INT, 0); }
		public TerminalNode STRING() { return getToken(SynthGraphParser.STRING, 0); }
		public Synth_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_value; }
	}

	public final Synth_valueContext synth_value() throws RecognitionException {
		Synth_valueContext _localctx = new Synth_valueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_synth_value);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				((Synth_valueContext)_localctx).atom = match(IDENTIFIER);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((Synth_valueContext)_localctx).atom = match(FLOAT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				((Synth_valueContext)_localctx).atom = match(INT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				((Synth_valueContext)_localctx).atom = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Synth_operatorContext extends ParserRuleContext {
		public Token atom;
		public TerminalNode PLUS() { return getToken(SynthGraphParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SynthGraphParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(SynthGraphParser.TIMES, 0); }
		public TerminalNode DIVBY() { return getToken(SynthGraphParser.DIVBY, 0); }
		public Synth_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_operator; }
	}

	public final Synth_operatorContext synth_operator() throws RecognitionException {
		Synth_operatorContext _localctx = new Synth_operatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_synth_operator);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((Synth_operatorContext)_localctx).atom = match(PLUS);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				((Synth_operatorContext)_localctx).atom = match(MINUS);
				}
				break;
			case TIMES:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				((Synth_operatorContext)_localctx).atom = match(TIMES);
				}
				break;
			case DIVBY:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				((Synth_operatorContext)_localctx).atom = match(DIVBY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Synth_parameter_nameContext extends ParserRuleContext {
		public Token atom;
		public TerminalNode FREQ() { return getToken(SynthGraphParser.FREQ, 0); }
		public TerminalNode PHASE() { return getToken(SynthGraphParser.PHASE, 0); }
		public TerminalNode SHAPE() { return getToken(SynthGraphParser.SHAPE, 0); }
		public TerminalNode ATTACK() { return getToken(SynthGraphParser.ATTACK, 0); }
		public TerminalNode DECAY() { return getToken(SynthGraphParser.DECAY, 0); }
		public TerminalNode SUSTAIN() { return getToken(SynthGraphParser.SUSTAIN, 0); }
		public TerminalNode RELEASE() { return getToken(SynthGraphParser.RELEASE, 0); }
		public Synth_parameter_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_parameter_name; }
	}

	public final Synth_parameter_nameContext synth_parameter_name() throws RecognitionException {
		Synth_parameter_nameContext _localctx = new Synth_parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_synth_parameter_name);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FREQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((Synth_parameter_nameContext)_localctx).atom = match(FREQ);
				}
				break;
			case PHASE:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				((Synth_parameter_nameContext)_localctx).atom = match(PHASE);
				}
				break;
			case SHAPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				((Synth_parameter_nameContext)_localctx).atom = match(SHAPE);
				}
				break;
			case ATTACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				((Synth_parameter_nameContext)_localctx).atom = match(ATTACK);
				}
				break;
			case DECAY:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				((Synth_parameter_nameContext)_localctx).atom = match(DECAY);
				}
				break;
			case SUSTAIN:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				((Synth_parameter_nameContext)_localctx).atom = match(SUSTAIN);
				}
				break;
			case RELEASE:
				enterOuterAlt(_localctx, 7);
				{
				setState(77);
				((Synth_parameter_nameContext)_localctx).atom = match(RELEASE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return synth_expression_sempred((Synth_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean synth_expression_sempred(Synth_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 S\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2\16"+
		"\2\27\13\2\3\2\3\2\3\3\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\7\3\7\3\7\3\7\5\7B\n\7\3\b\3\b\3\b"+
		"\3\b\5\bH\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tQ\n\t\3\t\2\3\n\n\2\4\6\b"+
		"\n\f\16\20\2\2\2a\2\25\3\2\2\2\4\32\3\2\2\2\6\"\3\2\2\2\b/\3\2\2\2\n\61"+
		"\3\2\2\2\fA\3\2\2\2\16G\3\2\2\2\20P\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2"+
		"\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2"+
		"\2\30\31\7\2\2\3\31\3\3\2\2\2\32\33\5\b\5\2\33\37\7\23\2\2\34\36\5\6\4"+
		"\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \5\3\2\2\2!\37"+
		"\3\2\2\2\"#\5\20\t\2#$\7 \2\2$%\5\n\6\2%\7\3\2\2\2&\60\7\3\2\2\'\60\7"+
		"\4\2\2(\60\7\5\2\2)\60\7\6\2\2*\60\7\7\2\2+\60\7\b\2\2,\60\7\t\2\2-\60"+
		"\7\22\2\2.\60\7\n\2\2/&\3\2\2\2/\'\3\2\2\2/(\3\2\2\2/)\3\2\2\2/*\3\2\2"+
		"\2/+\3\2\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\t\3\2\2\2\61\62\b\6\1\2"+
		"\62\63\5\f\7\2\63:\3\2\2\2\64\65\f\4\2\2\65\66\5\16\b\2\66\67\5\n\6\5"+
		"\679\3\2\2\28\64\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\13\3\2\2\2<:\3"+
		"\2\2\2=B\7\23\2\2>B\7\24\2\2?B\7\25\2\2@B\7\31\2\2A=\3\2\2\2A>\3\2\2\2"+
		"A?\3\2\2\2A@\3\2\2\2B\r\3\2\2\2CH\7\34\2\2DH\7\35\2\2EH\7\36\2\2FH\7\37"+
		"\2\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\17\3\2\2\2IQ\7\13\2\2JQ"+
		"\7\f\2\2KQ\7\r\2\2LQ\7\16\2\2MQ\7\17\2\2NQ\7\20\2\2OQ\7\21\2\2PI\3\2\2"+
		"\2PJ\3\2\2\2PK\3\2\2\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2Q\21\3\2"+
		"\2\2\t\25\37/:AGP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}