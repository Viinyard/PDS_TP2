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
		WS=1, COMMENT=2, PO=3, PF=4, TO=5, TC=6, BO=7, BF=8, SEP=9, EQUAL=10, 
		PRINT=11, READ=12, NE=13, EQ=14, GT=15, LT=16, GTE=17, LTE=18, FUNC_TYPE=19, 
		PROTO_TYPE=20, VOID_TYPE=21, INT_TYPE=22, RETURN_STMNT=23, IF=24, THEN=25, 
		ELSE=26, FI=27, WHILE=28, DO=29, DONE=30, ADD=31, SUB=32, MUL=33, SDIV=34, 
		IDENT=35, TEXT=36, INTEGER=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LETTER", "DIGIT", "ASCII", "PO", "PF", "TO", "TC", "BO", 
		"BF", "SEP", "EQUAL", "PRINT", "READ", "NE", "EQ", "GT", "LT", "GTE", 
		"LTE", "FUNC_TYPE", "PROTO_TYPE", "VOID_TYPE", "INT_TYPE", "RETURN_STMNT", 
		"IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", "ADD", "SUB", "MUL", 
		"SDIV", "IDENT", "TEXT", "INTEGER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", "','", "':='", 
		"'PRINT'", "'READ'", null, "'='", "'>'", "'<'", "'>='", "'<='", "'FUNC'", 
		"'PROTO'", "'VOID'", "'INT'", "'RETURN'", "'IF'", "'THEN'", "'ELSE'", 
		"'FI'", "'WHILE'", "'DO'", "'DONE'", "'+'", "'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "PO", "PF", "TO", "TC", "BO", "BF", "SEP", "EQUAL", 
		"PRINT", "READ", "NE", "EQ", "GT", "LT", "GTE", "LTE", "FUNC_TYPE", "PROTO_TYPE", 
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
		case 38:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u00ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\7\3\\\n\3\f\3\16\3_\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\5\21\u0089\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\7\'\u00db\n\'\f\'\16\'\u00de\13"+
		"\'\3(\3(\7(\u00e2\n(\f(\16(\u00e5\13(\3(\3(\3(\3)\6)\u00eb\n)\r)\16)\u00ec"+
		"\2\2*\3\3\5\4\7\2\t\2\13\2\r\5\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35"+
		"\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\329\33"+
		";\34=\35?\36A\37C E!G\"I#K$M%O&Q\'\3\2\5\4\2\13\f\"\"\3\2\f\f\4\2\f\f"+
		"$$\2\u00f0\2\3\3\2\2\2\2\5\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5W\3\2\2\2\7b\3\2\2\2\td\3\2"+
		"\2\2\13f\3\2\2\2\rh\3\2\2\2\17j\3\2\2\2\21l\3\2\2\2\23n\3\2\2\2\25p\3"+
		"\2\2\2\27r\3\2\2\2\31t\3\2\2\2\33v\3\2\2\2\35y\3\2\2\2\37\177\3\2\2\2"+
		"!\u0088\3\2\2\2#\u008a\3\2\2\2%\u008c\3\2\2\2\'\u008e\3\2\2\2)\u0090\3"+
		"\2\2\2+\u0093\3\2\2\2-\u0096\3\2\2\2/\u009b\3\2\2\2\61\u00a1\3\2\2\2\63"+
		"\u00a6\3\2\2\2\65\u00aa\3\2\2\2\67\u00b1\3\2\2\29\u00b4\3\2\2\2;\u00b9"+
		"\3\2\2\2=\u00be\3\2\2\2?\u00c1\3\2\2\2A\u00c7\3\2\2\2C\u00ca\3\2\2\2E"+
		"\u00cf\3\2\2\2G\u00d1\3\2\2\2I\u00d3\3\2\2\2K\u00d5\3\2\2\2M\u00d7\3\2"+
		"\2\2O\u00df\3\2\2\2Q\u00ea\3\2\2\2ST\t\2\2\2TU\3\2\2\2UV\b\2\2\2V\4\3"+
		"\2\2\2WX\7\61\2\2XY\7\61\2\2Y]\3\2\2\2Z\\\n\3\2\2[Z\3\2\2\2\\_\3\2\2\2"+
		"][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\b\3\2\2a\6\3\2\2\2bc\4c|\2"+
		"c\b\3\2\2\2de\4\62;\2e\n\3\2\2\2fg\n\4\2\2g\f\3\2\2\2hi\7*\2\2i\16\3\2"+
		"\2\2jk\7+\2\2k\20\3\2\2\2lm\7]\2\2m\22\3\2\2\2no\7_\2\2o\24\3\2\2\2pq"+
		"\7}\2\2q\26\3\2\2\2rs\7\177\2\2s\30\3\2\2\2tu\7.\2\2u\32\3\2\2\2vw\7<"+
		"\2\2wx\7?\2\2x\34\3\2\2\2yz\7R\2\2z{\7T\2\2{|\7K\2\2|}\7P\2\2}~\7V\2\2"+
		"~\36\3\2\2\2\177\u0080\7T\2\2\u0080\u0081\7G\2\2\u0081\u0082\7C\2\2\u0082"+
		"\u0083\7F\2\2\u0083 \3\2\2\2\u0084\u0085\7#\2\2\u0085\u0089\7?\2\2\u0086"+
		"\u0087\7>\2\2\u0087\u0089\7@\2\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2"+
		"\2\u0089\"\3\2\2\2\u008a\u008b\7?\2\2\u008b$\3\2\2\2\u008c\u008d\7@\2"+
		"\2\u008d&\3\2\2\2\u008e\u008f\7>\2\2\u008f(\3\2\2\2\u0090\u0091\7@\2\2"+
		"\u0091\u0092\7?\2\2\u0092*\3\2\2\2\u0093\u0094\7>\2\2\u0094\u0095\7?\2"+
		"\2\u0095,\3\2\2\2\u0096\u0097\7H\2\2\u0097\u0098\7W\2\2\u0098\u0099\7"+
		"P\2\2\u0099\u009a\7E\2\2\u009a.\3\2\2\2\u009b\u009c\7R\2\2\u009c\u009d"+
		"\7T\2\2\u009d\u009e\7Q\2\2\u009e\u009f\7V\2\2\u009f\u00a0\7Q\2\2\u00a0"+
		"\60\3\2\2\2\u00a1\u00a2\7X\2\2\u00a2\u00a3\7Q\2\2\u00a3\u00a4\7K\2\2\u00a4"+
		"\u00a5\7F\2\2\u00a5\62\3\2\2\2\u00a6\u00a7\7K\2\2\u00a7\u00a8\7P\2\2\u00a8"+
		"\u00a9\7V\2\2\u00a9\64\3\2\2\2\u00aa\u00ab\7T\2\2\u00ab\u00ac\7G\2\2\u00ac"+
		"\u00ad\7V\2\2\u00ad\u00ae\7W\2\2\u00ae\u00af\7T\2\2\u00af\u00b0\7P\2\2"+
		"\u00b0\66\3\2\2\2\u00b1\u00b2\7K\2\2\u00b2\u00b3\7H\2\2\u00b38\3\2\2\2"+
		"\u00b4\u00b5\7V\2\2\u00b5\u00b6\7J\2\2\u00b6\u00b7\7G\2\2\u00b7\u00b8"+
		"\7P\2\2\u00b8:\3\2\2\2\u00b9\u00ba\7G\2\2\u00ba\u00bb\7N\2\2\u00bb\u00bc"+
		"\7U\2\2\u00bc\u00bd\7G\2\2\u00bd<\3\2\2\2\u00be\u00bf\7H\2\2\u00bf\u00c0"+
		"\7K\2\2\u00c0>\3\2\2\2\u00c1\u00c2\7Y\2\2\u00c2\u00c3\7J\2\2\u00c3\u00c4"+
		"\7K\2\2\u00c4\u00c5\7N\2\2\u00c5\u00c6\7G\2\2\u00c6@\3\2\2\2\u00c7\u00c8"+
		"\7F\2\2\u00c8\u00c9\7Q\2\2\u00c9B\3\2\2\2\u00ca\u00cb\7F\2\2\u00cb\u00cc"+
		"\7Q\2\2\u00cc\u00cd\7P\2\2\u00cd\u00ce\7G\2\2\u00ceD\3\2\2\2\u00cf\u00d0"+
		"\7-\2\2\u00d0F\3\2\2\2\u00d1\u00d2\7/\2\2\u00d2H\3\2\2\2\u00d3\u00d4\7"+
		",\2\2\u00d4J\3\2\2\2\u00d5\u00d6\7\61\2\2\u00d6L\3\2\2\2\u00d7\u00dc\5"+
		"\7\4\2\u00d8\u00db\5\7\4\2\u00d9\u00db\5\t\5\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00ddN\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e3\7$\2\2\u00e0\u00e2"+
		"\5\13\6\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2"+
		"\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7"+
		"\7$\2\2\u00e7\u00e8\b(\3\2\u00e8P\3\2\2\2\u00e9\u00eb\5\t\5\2\u00ea\u00e9"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"R\3\2\2\2\t\2]\u0088\u00da\u00dc\u00e3\u00ec\4\b\2\2\3(\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}