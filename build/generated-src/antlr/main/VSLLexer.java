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
		VOID_TYPE=10, INT_TYPE=11, RETURN_STMNT=12, ADD=13, SUB=14, MUL=15, SDIV=16, 
		IDENT=17, TEXT=18, INTEGER=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LETTER", "DIGIT", "ASCII", "PO", "PF", "BO", "BF", "SEP", 
		"EQUAL", "FUNC_TYPE", "VOID_TYPE", "INT_TYPE", "RETURN_STMNT", "ADD", 
		"SUB", "MUL", "SDIV", "IDENT", "TEXT", "INTEGER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'{'", "'}'", "','", "'='", "'FUNC'", 
		"'VOID'", "'INT'", "'RETURN'", "'+'", "'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "PO", "PF", "BO", "BF", "SEP", "EQUAL", "FUNC_TYPE", 
		"VOID_TYPE", "INT_TYPE", "RETURN_STMNT", "ADD", "SUB", "MUL", "SDIV", 
		"IDENT", "TEXT", "INTEGER"
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
		case 20:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0084\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25"+
		"\7\25q\n\25\f\25\16\25t\13\25\3\26\3\26\7\26x\n\26\f\26\16\26{\13\26\3"+
		"\26\3\26\3\26\3\27\6\27\u0081\n\27\r\27\16\27\u0082\2\2\30\3\3\5\4\7\2"+
		"\t\2\13\2\r\5\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%"+
		"\21\'\22)\23+\24-\25\3\2\5\4\2\13\f\"\"\3\2\f\f\4\2\f\f$$\2\u0085\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\63\3\2\2\2\7>\3\2\2\2\t@\3\2\2\2\13"+
		"B\3\2\2\2\rD\3\2\2\2\17F\3\2\2\2\21H\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27"+
		"N\3\2\2\2\31P\3\2\2\2\33U\3\2\2\2\35Z\3\2\2\2\37^\3\2\2\2!e\3\2\2\2#g"+
		"\3\2\2\2%i\3\2\2\2\'k\3\2\2\2)m\3\2\2\2+u\3\2\2\2-\u0080\3\2\2\2/\60\t"+
		"\2\2\2\60\61\3\2\2\2\61\62\b\2\2\2\62\4\3\2\2\2\63\64\7\61\2\2\64\65\7"+
		"\61\2\2\659\3\2\2\2\668\n\3\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:"+
		"\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\b\3\2\2=\6\3\2\2\2>?\4c|\2?\b\3\2\2\2@"+
		"A\4\62;\2A\n\3\2\2\2BC\n\4\2\2C\f\3\2\2\2DE\7*\2\2E\16\3\2\2\2FG\7+\2"+
		"\2G\20\3\2\2\2HI\7}\2\2I\22\3\2\2\2JK\7\177\2\2K\24\3\2\2\2LM\7.\2\2M"+
		"\26\3\2\2\2NO\7?\2\2O\30\3\2\2\2PQ\7H\2\2QR\7W\2\2RS\7P\2\2ST\7E\2\2T"+
		"\32\3\2\2\2UV\7X\2\2VW\7Q\2\2WX\7K\2\2XY\7F\2\2Y\34\3\2\2\2Z[\7K\2\2["+
		"\\\7P\2\2\\]\7V\2\2]\36\3\2\2\2^_\7T\2\2_`\7G\2\2`a\7V\2\2ab\7W\2\2bc"+
		"\7T\2\2cd\7P\2\2d \3\2\2\2ef\7-\2\2f\"\3\2\2\2gh\7/\2\2h$\3\2\2\2ij\7"+
		",\2\2j&\3\2\2\2kl\7\61\2\2l(\3\2\2\2mr\5\7\4\2nq\5\7\4\2oq\5\t\5\2pn\3"+
		"\2\2\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s*\3\2\2\2tr\3\2\2\2uy\7"+
		"$\2\2vx\5\13\6\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3"+
		"\2\2\2|}\7$\2\2}~\b\26\3\2~,\3\2\2\2\177\u0081\5\t\5\2\u0080\177\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083."+
		"\3\2\2\2\b\29pry\u0082\4\b\2\2\3\26\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}