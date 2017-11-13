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
		WS=1, COMMENT=2, PO=3, PF=4, BO=5, BF=6, SEP=7, EQUAL=8, FUNC_TYPE=9, 
		PROTO_TYPE=10, VOID_TYPE=11, INT_TYPE=12, RETURN_STMNT=13, ADD=14, SUB=15, 
		MUL=16, SDIV=17, IDENT=18, TEXT=19, INTEGER=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LETTER", "DIGIT", "ASCII", "PO", "PF", "BO", "BF", "SEP", 
		"EQUAL", "FUNC_TYPE", "PROTO_TYPE", "VOID_TYPE", "INT_TYPE", "RETURN_STMNT", 
		"ADD", "SUB", "MUL", "SDIV", "IDENT", "TEXT", "INTEGER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'{'", "'}'", "','", "':='", "'FUNC'", 
		"'PROTO'", "'VOID'", "'INT'", "'RETURN'", "'+'", "'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "PO", "PF", "BO", "BF", "SEP", "EQUAL", "FUNC_TYPE", 
		"PROTO_TYPE", "VOID_TYPE", "INT_TYPE", "RETURN_STMNT", "ADD", "SUB", "MUL", 
		"SDIV", "IDENT", "TEXT", "INTEGER"
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
		case 21:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\7\26z\n\26\f\26\16\26}\13"+
		"\26\3\27\3\27\7\27\u0081\n\27\f\27\16\27\u0084\13\27\3\27\3\27\3\27\3"+
		"\30\6\30\u008a\n\30\r\30\16\30\u008b\2\2\31\3\3\5\4\7\2\t\2\13\2\r\5\17"+
		"\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24"+
		"-\25/\26\3\2\5\4\2\13\f\"\"\3\2\f\f\4\2\f\f$$\2\u008e\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\65\3\2\2\2\7@\3\2\2\2\tB\3\2\2\2\13D"+
		"\3\2\2\2\rF\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23L\3\2\2\2\25N\3\2\2\2\27"+
		"P\3\2\2\2\31S\3\2\2\2\33X\3\2\2\2\35^\3\2\2\2\37c\3\2\2\2!g\3\2\2\2#n"+
		"\3\2\2\2%p\3\2\2\2\'r\3\2\2\2)t\3\2\2\2+v\3\2\2\2-~\3\2\2\2/\u0089\3\2"+
		"\2\2\61\62\t\2\2\2\62\63\3\2\2\2\63\64\b\2\2\2\64\4\3\2\2\2\65\66\7\61"+
		"\2\2\66\67\7\61\2\2\67;\3\2\2\28:\n\3\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2"+
		"\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\b\3\2\2?\6\3\2\2\2@A\4c|\2A\b\3\2\2"+
		"\2BC\4\62;\2C\n\3\2\2\2DE\n\4\2\2E\f\3\2\2\2FG\7*\2\2G\16\3\2\2\2HI\7"+
		"+\2\2I\20\3\2\2\2JK\7}\2\2K\22\3\2\2\2LM\7\177\2\2M\24\3\2\2\2NO\7.\2"+
		"\2O\26\3\2\2\2PQ\7<\2\2QR\7?\2\2R\30\3\2\2\2ST\7H\2\2TU\7W\2\2UV\7P\2"+
		"\2VW\7E\2\2W\32\3\2\2\2XY\7R\2\2YZ\7T\2\2Z[\7Q\2\2[\\\7V\2\2\\]\7Q\2\2"+
		"]\34\3\2\2\2^_\7X\2\2_`\7Q\2\2`a\7K\2\2ab\7F\2\2b\36\3\2\2\2cd\7K\2\2"+
		"de\7P\2\2ef\7V\2\2f \3\2\2\2gh\7T\2\2hi\7G\2\2ij\7V\2\2jk\7W\2\2kl\7T"+
		"\2\2lm\7P\2\2m\"\3\2\2\2no\7-\2\2o$\3\2\2\2pq\7/\2\2q&\3\2\2\2rs\7,\2"+
		"\2s(\3\2\2\2tu\7\61\2\2u*\3\2\2\2v{\5\7\4\2wz\5\7\4\2xz\5\t\5\2yw\3\2"+
		"\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|,\3\2\2\2}{\3\2\2\2~\u0082"+
		"\7$\2\2\177\u0081\5\13\6\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0085\u0086\7$\2\2\u0086\u0087\b\27\3\2\u0087.\3\2\2\2\u0088\u008a"+
		"\5\t\5\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\60\3\2\2\2\b\2;y{\u0082\u008b\4\b\2\2\3\27\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}