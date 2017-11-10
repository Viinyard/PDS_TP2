// Generated from VSLParser.g by ANTLR 4.7

  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, PO=3, PF=4, FUNC_TYPE=5, VOID_TYPE=6, INT_TYPE=7, ADD=8, 
		SUB=9, MUL=10, SDIV=11, IDENT=12, TEXT=13, INTEGER=14;
	public static final int
		RULE_program = 0, RULE_fonction = 1, RULE_expression = 2, RULE_type = 3, 
		RULE_ident = 4, RULE_atome = 5;
	public static final String[] ruleNames = {
		"program", "fonction", "expression", "type", "ident", "atome"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'FUNC'", "'VOID'", "'INT'", "'+'", "'-'", 
		"'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "PO", "PF", "FUNC_TYPE", "VOID_TYPE", "INT_TYPE", 
		"ADD", "SUB", "MUL", "SDIV", "IDENT", "TEXT", "INTEGER"
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

	@Override
	public String getGrammarFileName() { return "VSLParser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ASD.Program out;
		public FonctionContext fonction;
		public TerminalNode EOF() { return getToken(VSLParser.EOF, 0); }
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);

		    List<ASD.Fonction> fonctions = new ArrayList<ASD.Fonction>();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC_TYPE) {
				{
				{
				setState(12);
				((ProgramContext)_localctx).fonction = fonction();
				 fonctions.add(((ProgramContext)_localctx).fonction.out); 
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			match(EOF);
			 ((ProgramContext)_localctx).out =  new ASD.Program(fonctions); 
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

	public static class FonctionContext extends ParserRuleContext {
		public ASD.Fonction out;
		public TypeContext type;
		public IdentContext ident;
		public TerminalNode FUNC_TYPE() { return getToken(VSLParser.FUNC_TYPE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public TerminalNode PF() { return getToken(VSLParser.PF, 0); }
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fonction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(FUNC_TYPE);
			setState(24);
			((FonctionContext)_localctx).type = type();
			setState(25);
			((FonctionContext)_localctx).ident = ident();
			setState(26);
			match(PO);
			setState(27);
			match(PF);

			      ((FonctionContext)_localctx).out =  new ASD.Fonction(((FonctionContext)_localctx).type.out, ((FonctionContext)_localctx).ident.out, Llvm.empty());
			    
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

	public static class ExpressionContext extends ParserRuleContext {
		public ASD.Expression out;
		public ExpressionContext l;
		public ExpressionContext expression;
		public AtomeContext c;
		public Token op;
		public ExpressionContext r;
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PF() { return getToken(VSLParser.PF, 0); }
		public AtomeContext atome() {
			return getRuleContext(AtomeContext.class,0);
		}
		public TerminalNode MUL() { return getToken(VSLParser.MUL, 0); }
		public TerminalNode SDIV() { return getToken(VSLParser.SDIV, 0); }
		public TerminalNode ADD() { return getToken(VSLParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(VSLParser.SUB, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PO:
				{
				setState(31);
				match(PO);
				setState(32);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(33);
				match(PF);

				      ((ExpressionContext)_localctx).out =  ((ExpressionContext)_localctx).expression.out;
				    
				}
				break;
			case INTEGER:
				{
				setState(36);
				((ExpressionContext)_localctx).c = atome();

				        ((ExpressionContext)_localctx).out =  ((ExpressionContext)_localctx).c.out;
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(51);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(41);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(42);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==SDIV) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(43);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(4);
						 
						                  switch(((ExpressionContext)_localctx).op.getType()) {
						                  case MUL :
						                    ((ExpressionContext)_localctx).out =  new ASD.MulExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out);
						                    break;
						                  case SDIV :
						                    ((ExpressionContext)_localctx).out =  new ASD.SignedDivExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out);
						                    break;
						                  }
						                
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(46);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(47);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(48);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(3);

						                  switch(((ExpressionContext)_localctx).op.getType()) {
						                  case ADD :
						                    ((ExpressionContext)_localctx).out =  new ASD.AddExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out);
						                    break;
						                  case SUB :
						                    ((ExpressionContext)_localctx).out =  new ASD.SubExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out);
						                    break;
						                  }
						                
						}
						break;
					}
					} 
				}
				setState(55);
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

	public static class TypeContext extends ParserRuleContext {
		public ASD.Type out;
		public TerminalNode INT_TYPE() { return getToken(VSLParser.INT_TYPE, 0); }
		public TerminalNode VOID_TYPE() { return getToken(VSLParser.VOID_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(INT_TYPE);

				      ((TypeContext)_localctx).out =  new ASD.IntType();
				    
				}
				break;
			case VOID_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(VOID_TYPE);

				      ((TypeContext)_localctx).out =  new ASD.VoidType();
				    
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

	public static class IdentContext extends ParserRuleContext {
		public ASD.ID out;
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			((IdentContext)_localctx).IDENT = match(IDENT);
			 ((IdentContext)_localctx).out =  new ASD.GlobalID(((IdentContext)_localctx).IDENT.getText()); 
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

	public static class AtomeContext extends ParserRuleContext {
		public ASD.Expression out;
		public Token INTEGER;
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public AtomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atome; }
	}

	public final AtomeContext atome() throws RecognitionException {
		AtomeContext _localctx = new AtomeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atome);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			((AtomeContext)_localctx).INTEGER = match(INTEGER);
			 ((AtomeContext)_localctx).out =  new ASD.IntegerExpression((((AtomeContext)_localctx).INTEGER!=null?Integer.valueOf(((AtomeContext)_localctx).INTEGER.getText()):0)); 
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
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20G\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4*\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\66\n"+
		"\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\2\3\6\b\2\4\6\b\n\f\2\4\3\2\f\r\3\2\n\13\2E\2\23\3\2\2\2\4\31\3\2\2\2"+
		"\6)\3\2\2\2\b>\3\2\2\2\n@\3\2\2\2\fC\3\2\2\2\16\17\5\4\3\2\17\20\b\2\1"+
		"\2\20\22\3\2\2\2\21\16\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2"+
		"\2\24\26\3\2\2\2\25\23\3\2\2\2\26\27\7\2\2\3\27\30\b\2\1\2\30\3\3\2\2"+
		"\2\31\32\7\7\2\2\32\33\5\b\5\2\33\34\5\n\6\2\34\35\7\5\2\2\35\36\7\6\2"+
		"\2\36\37\b\3\1\2\37\5\3\2\2\2 !\b\4\1\2!\"\7\5\2\2\"#\5\6\4\2#$\7\6\2"+
		"\2$%\b\4\1\2%*\3\2\2\2&\'\5\f\7\2\'(\b\4\1\2(*\3\2\2\2) \3\2\2\2)&\3\2"+
		"\2\2*\67\3\2\2\2+,\f\5\2\2,-\t\2\2\2-.\5\6\4\6./\b\4\1\2/\66\3\2\2\2\60"+
		"\61\f\4\2\2\61\62\t\3\2\2\62\63\5\6\4\5\63\64\b\4\1\2\64\66\3\2\2\2\65"+
		"+\3\2\2\2\65\60\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\7\3\2\2"+
		"\29\67\3\2\2\2:;\7\t\2\2;?\b\5\1\2<=\7\b\2\2=?\b\5\1\2>:\3\2\2\2><\3\2"+
		"\2\2?\t\3\2\2\2@A\7\16\2\2AB\b\6\1\2B\13\3\2\2\2CD\7\20\2\2DE\b\7\1\2"+
		"E\r\3\2\2\2\7\23)\65\67>";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}