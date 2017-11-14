// Generated from VSLLexer.g by ANTLR 4.7

  package TP2;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, PO=3, PF=4, BO=5, BF=6, SEP=7, EQUAL=8, PRINT=9, READ=10, 
		NE=11, EQ=12, GT=13, LT=14, GTE=15, LTE=16, FUNC_TYPE=17, PROTO_TYPE=18, 
		VOID_TYPE=19, INT_TYPE=20, RETURN_STMNT=21, IF=22, THEN=23, ELSE=24, FI=25, 
		WHILE=26, DO=27, DONE=28, ADD=29, SUB=30, MUL=31, SDIV=32, IDENT=33, TEXT=34, 
		INTEGER=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LETTER", "DIGIT", "ASCII", "PO", "PF", "BO", "BF", "SEP", 
		"EQUAL", "PRINT", "READ", "NE", "EQ", "GT", "LT", "GTE", "LTE", "FUNC_TYPE", 
		"PROTO_TYPE", "VOID_TYPE", "INT_TYPE", "RETURN_STMNT", "IF", "THEN", "ELSE", 
		"FI", "WHILE", "DO", "DONE", "ADD", "SUB", "MUL", "SDIV", "IDENT", "TEXT", 
		"INTEGER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'{'", "'}'", "','", "':='", "'PRINT'", 
		"'READ'", null, "'='", "'>'", "'<'", "'>='", "'<='", "'FUNC'", "'PROTO'", 
		"'VOID'", "'INT'", "'RETURN'", "'IF'", "'THEN'", "'ELSE'", "'FI'", "'WHILE'", 
		"'DO'", "'DONE'", "'+'", "'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "PO", "PF", "BO", "BF", "SEP", "EQUAL", "PRINT", 
		"READ", "NE", "EQ", "GT", "LT", "GTE", "LTE", "FUNC_TYPE", "PROTO_TYPE", 
		"VOID_TYPE", "INT_TYPE", "RETURN_STMNT", "IF", "THEN", "ELSE", "FI", "WHILE", 
		"DO", "DONE", "ADD", "SUB", "MUL", "SDIV", "IDENT", "TEXT", "INTEGER"
	};
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


	public VSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "VSLLexer.g"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 36:
			TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 setText(getText().substring(1, getText().length() - 1)); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00e6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\7\3X\n\3\f\3\16\3[\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u0081\n\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3%\3%\3%\7%\u00d3\n%\f%\16%\u00d6\13%\3&\3&\7&\u00da\n&\f&\16&\u00dd"+
		"\13&\3&\3&\3&\3\'\6\'\u00e3\n\'\r\'\16\'\u00e4\2\2(\3\3\5\4\7\2\t\2\13"+
		"\2\r\5\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22"+
		")\23+\24-\25/\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#"+
		"K$M%\3\2\5\4\2\13\f\"\"\3\2\f\f\4\2\f\f$$\2\u00e8\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5S\3\2\2\2\7"+
		"^\3\2\2\2\t`\3\2\2\2\13b\3\2\2\2\rd\3\2\2\2\17f\3\2\2\2\21h\3\2\2\2\23"+
		"j\3\2\2\2\25l\3\2\2\2\27n\3\2\2\2\31q\3\2\2\2\33w\3\2\2\2\35\u0080\3\2"+
		"\2\2\37\u0082\3\2\2\2!\u0084\3\2\2\2#\u0086\3\2\2\2%\u0088\3\2\2\2\'\u008b"+
		"\3\2\2\2)\u008e\3\2\2\2+\u0093\3\2\2\2-\u0099\3\2\2\2/\u009e\3\2\2\2\61"+
		"\u00a2\3\2\2\2\63\u00a9\3\2\2\2\65\u00ac\3\2\2\2\67\u00b1\3\2\2\29\u00b6"+
		"\3\2\2\2;\u00b9\3\2\2\2=\u00bf\3\2\2\2?\u00c2\3\2\2\2A\u00c7\3\2\2\2C"+
		"\u00c9\3\2\2\2E\u00cb\3\2\2\2G\u00cd\3\2\2\2I\u00cf\3\2\2\2K\u00d7\3\2"+
		"\2\2M\u00e2\3\2\2\2OP\t\2\2\2PQ\3\2\2\2QR\b\2\2\2R\4\3\2\2\2ST\7\61\2"+
		"\2TU\7\61\2\2UY\3\2\2\2VX\n\3\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2"+
		"\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\b\3\2\2]\6\3\2\2\2^_\4c|\2_\b\3\2\2\2`a\4"+
		"\62;\2a\n\3\2\2\2bc\n\4\2\2c\f\3\2\2\2de\7*\2\2e\16\3\2\2\2fg\7+\2\2g"+
		"\20\3\2\2\2hi\7}\2\2i\22\3\2\2\2jk\7\177\2\2k\24\3\2\2\2lm\7.\2\2m\26"+
		"\3\2\2\2no\7<\2\2op\7?\2\2p\30\3\2\2\2qr\7R\2\2rs\7T\2\2st\7K\2\2tu\7"+
		"P\2\2uv\7V\2\2v\32\3\2\2\2wx\7T\2\2xy\7G\2\2yz\7C\2\2z{\7F\2\2{\34\3\2"+
		"\2\2|}\7#\2\2}\u0081\7?\2\2~\177\7>\2\2\177\u0081\7@\2\2\u0080|\3\2\2"+
		"\2\u0080~\3\2\2\2\u0081\36\3\2\2\2\u0082\u0083\7?\2\2\u0083 \3\2\2\2\u0084"+
		"\u0085\7@\2\2\u0085\"\3\2\2\2\u0086\u0087\7>\2\2\u0087$\3\2\2\2\u0088"+
		"\u0089\7@\2\2\u0089\u008a\7?\2\2\u008a&\3\2\2\2\u008b\u008c\7>\2\2\u008c"+
		"\u008d\7?\2\2\u008d(\3\2\2\2\u008e\u008f\7H\2\2\u008f\u0090\7W\2\2\u0090"+
		"\u0091\7P\2\2\u0091\u0092\7E\2\2\u0092*\3\2\2\2\u0093\u0094\7R\2\2\u0094"+
		"\u0095\7T\2\2\u0095\u0096\7Q\2\2\u0096\u0097\7V\2\2\u0097\u0098\7Q\2\2"+
		"\u0098,\3\2\2\2\u0099\u009a\7X\2\2\u009a\u009b\7Q\2\2\u009b\u009c\7K\2"+
		"\2\u009c\u009d\7F\2\2\u009d.\3\2\2\2\u009e\u009f\7K\2\2\u009f\u00a0\7"+
		"P\2\2\u00a0\u00a1\7V\2\2\u00a1\60\3\2\2\2\u00a2\u00a3\7T\2\2\u00a3\u00a4"+
		"\7G\2\2\u00a4\u00a5\7V\2\2\u00a5\u00a6\7W\2\2\u00a6\u00a7\7T\2\2\u00a7"+
		"\u00a8\7P\2\2\u00a8\62\3\2\2\2\u00a9\u00aa\7K\2\2\u00aa\u00ab\7H\2\2\u00ab"+
		"\64\3\2\2\2\u00ac\u00ad\7V\2\2\u00ad\u00ae\7J\2\2\u00ae\u00af\7G\2\2\u00af"+
		"\u00b0\7P\2\2\u00b0\66\3\2\2\2\u00b1\u00b2\7G\2\2\u00b2\u00b3\7N\2\2\u00b3"+
		"\u00b4\7U\2\2\u00b4\u00b5\7G\2\2\u00b58\3\2\2\2\u00b6\u00b7\7H\2\2\u00b7"+
		"\u00b8\7K\2\2\u00b8:\3\2\2\2\u00b9\u00ba\7Y\2\2\u00ba\u00bb\7J\2\2\u00bb"+
		"\u00bc\7K\2\2\u00bc\u00bd\7N\2\2\u00bd\u00be\7G\2\2\u00be<\3\2\2\2\u00bf"+
		"\u00c0\7F\2\2\u00c0\u00c1\7Q\2\2\u00c1>\3\2\2\2\u00c2\u00c3\7F\2\2\u00c3"+
		"\u00c4\7Q\2\2\u00c4\u00c5\7P\2\2\u00c5\u00c6\7G\2\2\u00c6@\3\2\2\2\u00c7"+
		"\u00c8\7-\2\2\u00c8B\3\2\2\2\u00c9\u00ca\7/\2\2\u00caD\3\2\2\2\u00cb\u00cc"+
		"\7,\2\2\u00ccF\3\2\2\2\u00cd\u00ce\7\61\2\2\u00ceH\3\2\2\2\u00cf\u00d4"+
		"\5\7\4\2\u00d0\u00d3\5\7\4\2\u00d1\u00d3\5\t\5\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5J\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00db\7$\2\2\u00d8\u00da"+
		"\5\13\6\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2"+
		"\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df"+
		"\7$\2\2\u00df\u00e0\b&\3\2\u00e0L\3\2\2\2\u00e1\u00e3\5\t\5\2\u00e2\u00e1"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"N\3\2\2\2\t\2Y\u0080\u00d2\u00d4\u00db\u00e4\4\b\2\2\3&\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}