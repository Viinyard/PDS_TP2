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
		WS=1, COMMENT=2, PO=3, PF=4, BO=5, BF=6, SEP=7, EQUAL=8, FUNC_TYPE=9, 
		PROTO_TYPE=10, VOID_TYPE=11, INT_TYPE=12, RETURN_STMNT=13, ADD=14, SUB=15, 
		MUL=16, SDIV=17, IDENT=18, TEXT=19, INTEGER=20;
	public static final int
		RULE_program = 0, RULE_fonction = 1, RULE_block = 2, RULE_statement = 3, 
		RULE_affectation = 4, RULE_localdeclaration = 5, RULE_expression = 6, 
		RULE_multExpr = 7, RULE_type = 8, RULE_ident = 9, RULE_atome = 10;
	public static final String[] ruleNames = {
		"program", "fonction", "block", "statement", "affectation", "localdeclaration", 
		"expression", "multExpr", "type", "ident", "atome"
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

		    List<ASD.Expression> listExpression = new ArrayList<ASD.Expression>();
		    SymbolTable table = new SymbolTable();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC_TYPE || _la==PROTO_TYPE) {
				{
				{
				setState(22);
				((ProgramContext)_localctx).fonction = fonction(table);
				 listExpression.add(((ProgramContext)_localctx).fonction.out); 
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			match(EOF);
			 ((ProgramContext)_localctx).out =  new ASD.Program(listExpression); 
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
		public SymbolTable table;
		public ASD.Expression out;
		public TypeContext type;
		public IdentContext ident;
		public BlockContext block;
		public TerminalNode FUNC_TYPE() { return getToken(VSLParser.FUNC_TYPE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public TerminalNode PF() { return getToken(VSLParser.PF, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode PROTO_TYPE() { return getToken(VSLParser.PROTO_TYPE, 0); }
		public FonctionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FonctionContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
	}

	public final FonctionContext fonction(SymbolTable table) throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState(), table);
		enterRule(_localctx, 2, RULE_fonction);

		    SymbolTable tableFunction = new SymbolTable(table);
		  
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(FUNC_TYPE);
				setState(34);
				((FonctionContext)_localctx).type = type();
				setState(35);
				((FonctionContext)_localctx).ident = ident();
				setState(36);
				match(PO);
				setState(37);
				match(PF);
				setState(38);
				((FonctionContext)_localctx).block = block(table);

				      table.add(new SymbolTable.FunctionSymbol(((FonctionContext)_localctx).type.out, ((FonctionContext)_localctx).ident.text, null, true));
				      ((FonctionContext)_localctx).out =  new ASD.Fonction(((FonctionContext)_localctx).type.out, ((FonctionContext)_localctx).ident.text, ((FonctionContext)_localctx).block.out);
				    
				}
				break;
			case PROTO_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(PROTO_TYPE);
				setState(42);
				((FonctionContext)_localctx).type = type();
				setState(43);
				((FonctionContext)_localctx).ident = ident();
				setState(44);
				match(PO);
				setState(45);
				match(PF);

				      table.add(new SymbolTable.FunctionSymbol(((FonctionContext)_localctx).type.out, ((FonctionContext)_localctx).ident.text, null, true));
				      ((FonctionContext)_localctx).out =  new ASD.ProtoFonction(((FonctionContext)_localctx).type.out, ((FonctionContext)_localctx).ident.text);
				    
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

	public static class BlockContext extends ParserRuleContext {
		public SymbolTable table;
		public List<ASD.Expression> out;
		public StatementContext statement;
		public TerminalNode BO() { return getToken(VSLParser.BO, 0); }
		public TerminalNode BF() { return getToken(VSLParser.BF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BlockContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block(SymbolTable table) throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState(), table);
		enterRule(_localctx, 4, RULE_block);

		    List<ASD.Expression> statements = new ArrayList<ASD.Expression>();
		    SymbolTable newTable = new SymbolTable(table);
		  
		int _la;
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BO:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(BO);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID_TYPE) | (1L << INT_TYPE) | (1L << RETURN_STMNT) | (1L << IDENT))) != 0)) {
					{
					{
					setState(51);
					((BlockContext)_localctx).statement = statement(newTable);

					      statements.addAll(((BlockContext)_localctx).statement.out);
					      
					    
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59);
				match(BF);
				 ((BlockContext)_localctx).out =  statements; 
				}
				break;
			case VOID_TYPE:
			case INT_TYPE:
			case RETURN_STMNT:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				((BlockContext)_localctx).statement = statement(newTable);

				      statements.addAll(((BlockContext)_localctx).statement.out);
				      ((BlockContext)_localctx).out =  statements;
				    
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

	public static class StatementContext extends ParserRuleContext {
		public SymbolTable table;
		public List<ASD.Expression> out;
		public ExpressionContext expression;
		public LocaldeclarationContext localdeclaration;
		public AffectationContext affectation;
		public TerminalNode RETURN_STMNT() { return getToken(VSLParser.RETURN_STMNT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocaldeclarationContext localdeclaration() {
			return getRuleContext(LocaldeclarationContext.class,0);
		}
		public AffectationContext affectation() {
			return getRuleContext(AffectationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement(SymbolTable table) throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState(), table);
		enterRule(_localctx, 6, RULE_statement);

		    List<ASD.Expression> expressions = new ArrayList<ASD.Expression>();
		  
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN_STMNT:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(RETURN_STMNT);
				setState(67);
				((StatementContext)_localctx).expression = expression(table);

				      expressions.add(new ASD.ReturnStatement(((StatementContext)_localctx).expression.out));
				      ((StatementContext)_localctx).out =  expressions;
				    
				}
				break;
			case VOID_TYPE:
			case INT_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				((StatementContext)_localctx).localdeclaration = localdeclaration(table);

				      expressions = ((StatementContext)_localctx).localdeclaration.out;
				      ((StatementContext)_localctx).out =  expressions;
				    
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				((StatementContext)_localctx).affectation = affectation(table);

				      expressions.add(((StatementContext)_localctx).affectation.out);
				      ((StatementContext)_localctx).out =  expressions;
				    
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

	public static class AffectationContext extends ParserRuleContext {
		public SymbolTable table;
		public ASD.Expression out;
		public IdentContext ident;
		public ExpressionContext expression;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(VSLParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AffectationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AffectationContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_affectation; }
	}

	public final AffectationContext affectation(SymbolTable table) throws RecognitionException {
		AffectationContext _localctx = new AffectationContext(_ctx, getState(), table);
		enterRule(_localctx, 8, RULE_affectation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			((AffectationContext)_localctx).ident = ident();
			setState(79);
			match(EQUAL);
			setState(80);
			((AffectationContext)_localctx).expression = expression(table);

			      SymbolTable.Symbol s = table.lookup(((AffectationContext)_localctx).ident.text);
			      if(s == null) { throw new IllegalArgumentException("Cannot fin symbol " + ((AffectationContext)_localctx).ident.text); }
			      if(s instanceof SymbolTable.VariableSymbol) {
			        ((AffectationContext)_localctx).out =  new ASD.Affectation(((SymbolTable.VariableSymbol) s).type, s.ident, ((AffectationContext)_localctx).expression.out);
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

	public static class LocaldeclarationContext extends ParserRuleContext {
		public SymbolTable table;
		public List<ASD.Expression> out;
		public TypeContext type;
		public IdentContext ident;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(VSLParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(VSLParser.SEP, i);
		}
		public LocaldeclarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LocaldeclarationContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_localdeclaration; }
	}

	public final LocaldeclarationContext localdeclaration(SymbolTable table) throws RecognitionException {
		LocaldeclarationContext _localctx = new LocaldeclarationContext(_ctx, getState(), table);
		enterRule(_localctx, 10, RULE_localdeclaration);

		    List<ASD.Expression> decls = new ArrayList<ASD.Expression>();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((LocaldeclarationContext)_localctx).type = type();
			setState(84);
			((LocaldeclarationContext)_localctx).ident = ident();
			 
			        table.add(new SymbolTable.VariableSymbol(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
			        decls.add(new ASD.Instanciation(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
			        
			      
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(86);
				match(SEP);
				setState(87);
				((LocaldeclarationContext)_localctx).ident = ident();
				 
				        table.add(new SymbolTable.VariableSymbol(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
				        decls.add(new ASD.Instanciation(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
				        
				      
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        ((LocaldeclarationContext)_localctx).out =  decls;
			      
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
		public SymbolTable table;
		public ASD.Expression out;
		public MultExprContext l;
		public Token op;
		public MultExprContext r;
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(VSLParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(VSLParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(VSLParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(VSLParser.SUB, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression(SymbolTable table) throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState(), table);
		enterRule(_localctx, 12, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			((ExpressionContext)_localctx).l = multExpr(table);
			((ExpressionContext)_localctx).out =  ((ExpressionContext)_localctx).l.out; 
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(99);
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
				setState(100);
				((ExpressionContext)_localctx).r = multExpr(table);

				        switch(((ExpressionContext)_localctx).op.getType()) {
				        case ADD :
				          ((ExpressionContext)_localctx).out =  new ASD.AddExpression(_localctx.out, ((ExpressionContext)_localctx).r.out);
				          break;
				        case SUB :
				          ((ExpressionContext)_localctx).out =  new ASD.SubExpression(_localctx.out, ((ExpressionContext)_localctx).r.out);
				          break;
				        }
				      
				}
				}
				setState(107);
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

	public static class MultExprContext extends ParserRuleContext {
		public SymbolTable table;
		public ASD.Expression out;
		public AtomeContext l;
		public Token op;
		public AtomeContext r;
		public List<AtomeContext> atome() {
			return getRuleContexts(AtomeContext.class);
		}
		public AtomeContext atome(int i) {
			return getRuleContext(AtomeContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(VSLParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(VSLParser.MUL, i);
		}
		public List<TerminalNode> SDIV() { return getTokens(VSLParser.SDIV); }
		public TerminalNode SDIV(int i) {
			return getToken(VSLParser.SDIV, i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MultExprContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	}

	public final MultExprContext multExpr(SymbolTable table) throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState(), table);
		enterRule(_localctx, 14, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			((MultExprContext)_localctx).l = atome(table);
			((MultExprContext)_localctx).out =  ((MultExprContext)_localctx).l.out; 
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==SDIV) {
				{
				{
				setState(110);
				((MultExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==SDIV) ) {
					((MultExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(111);
				((MultExprContext)_localctx).r = atome(table);
				 
				        switch(((MultExprContext)_localctx).op.getType()) {
				        case MUL :
				          ((MultExprContext)_localctx).out =  new ASD.MulExpression(_localctx.out, ((MultExprContext)_localctx).r.out);
				          break;
				        case SDIV :
				          ((MultExprContext)_localctx).out =  new ASD.SignedDivExpression(_localctx.out, ((MultExprContext)_localctx).r.out);
				          break;
				        }
				      
				}
				}
				setState(118);
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
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(INT_TYPE);

				      ((TypeContext)_localctx).out =  new ASD.IntType();
				    
				}
				break;
			case VOID_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
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
		public String text;
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			((IdentContext)_localctx).IDENT = match(IDENT);
			 ((IdentContext)_localctx).text =  ((IdentContext)_localctx).IDENT.getText(); 
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
		public SymbolTable table;
		public ASD.Expression out;
		public ExpressionContext l;
		public Token INTEGER;
		public Token TEXT;
		public IdentContext ident;
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public TerminalNode PF() { return getToken(VSLParser.PF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public TerminalNode TEXT() { return getToken(VSLParser.TEXT, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public AtomeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AtomeContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_atome; }
	}

	public final AtomeContext atome(SymbolTable table) throws RecognitionException {
		AtomeContext _localctx = new AtomeContext(_ctx, getState(), table);
		enterRule(_localctx, 20, RULE_atome);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PO:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(PO);
				setState(129);
				((AtomeContext)_localctx).l = expression(table);
				setState(130);
				match(PF);

				        ((AtomeContext)_localctx).out =  ((AtomeContext)_localctx).l.out;
				      
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((AtomeContext)_localctx).INTEGER = match(INTEGER);
				 ((AtomeContext)_localctx).out =  new ASD.IntegerExpression((((AtomeContext)_localctx).INTEGER!=null?Integer.valueOf(((AtomeContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				((AtomeContext)_localctx).TEXT = match(TEXT);
				 /*((AtomeContext)_localctx).out =  new ASD.StringExpression(((AtomeContext)_localctx).TEXT.getText());*/ 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(137);
				((AtomeContext)_localctx).ident = ident();

				        SymbolTable.Symbol s = table.lookup(((AtomeContext)_localctx).ident.text);
				        if(s == null) { throw new IllegalArgumentException("Cannot fin symbol "+((AtomeContext)_localctx).ident.text);}
				        if(s instanceof SymbolTable.VariableSymbol) {
				          ((AtomeContext)_localctx).out =  new ASD.Variable(((SymbolTable.VariableSymbol) s).type, s.ident);
				        }
				      
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u0091\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\63\n\3\3"+
		"\4\3\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7]\n\7\f\7\16\7`\13\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\7\bj\n\b\f\b\16\bm\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tu\n\t"+
		"\f\t\16\tx\13\t\3\n\3\n\3\n\3\n\5\n~\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008f\n\f\3\f\2\2\r\2\4\6\b\n\f"+
		"\16\20\22\24\26\2\4\3\2\20\21\3\2\22\23\2\u0092\2\35\3\2\2\2\4\62\3\2"+
		"\2\2\6B\3\2\2\2\bN\3\2\2\2\nP\3\2\2\2\fU\3\2\2\2\16c\3\2\2\2\20n\3\2\2"+
		"\2\22}\3\2\2\2\24\177\3\2\2\2\26\u008e\3\2\2\2\30\31\5\4\3\2\31\32\b\2"+
		"\1\2\32\34\3\2\2\2\33\30\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2"+
		"\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\2\2\3!\"\b\2\1\2\"\3\3\2\2\2#$\7\13"+
		"\2\2$%\5\22\n\2%&\5\24\13\2&\'\7\5\2\2\'(\7\6\2\2()\5\6\4\2)*\b\3\1\2"+
		"*\63\3\2\2\2+,\7\f\2\2,-\5\22\n\2-.\5\24\13\2./\7\5\2\2/\60\7\6\2\2\60"+
		"\61\b\3\1\2\61\63\3\2\2\2\62#\3\2\2\2\62+\3\2\2\2\63\5\3\2\2\2\64:\7\7"+
		"\2\2\65\66\5\b\5\2\66\67\b\4\1\2\679\3\2\2\28\65\3\2\2\29<\3\2\2\2:8\3"+
		"\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7\b\2\2>C\b\4\1\2?@\5\b\5\2@A\b"+
		"\4\1\2AC\3\2\2\2B\64\3\2\2\2B?\3\2\2\2C\7\3\2\2\2DE\7\17\2\2EF\5\16\b"+
		"\2FG\b\5\1\2GO\3\2\2\2HI\5\f\7\2IJ\b\5\1\2JO\3\2\2\2KL\5\n\6\2LM\b\5\1"+
		"\2MO\3\2\2\2ND\3\2\2\2NH\3\2\2\2NK\3\2\2\2O\t\3\2\2\2PQ\5\24\13\2QR\7"+
		"\n\2\2RS\5\16\b\2ST\b\6\1\2T\13\3\2\2\2UV\5\22\n\2VW\5\24\13\2W^\b\7\1"+
		"\2XY\7\t\2\2YZ\5\24\13\2Z[\b\7\1\2[]\3\2\2\2\\X\3\2\2\2]`\3\2\2\2^\\\3"+
		"\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\b\7\1\2b\r\3\2\2\2cd\5\20\t\2d"+
		"k\b\b\1\2ef\t\2\2\2fg\5\20\t\2gh\b\b\1\2hj\3\2\2\2ie\3\2\2\2jm\3\2\2\2"+
		"ki\3\2\2\2kl\3\2\2\2l\17\3\2\2\2mk\3\2\2\2no\5\26\f\2ov\b\t\1\2pq\t\3"+
		"\2\2qr\5\26\f\2rs\b\t\1\2su\3\2\2\2tp\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3"+
		"\2\2\2w\21\3\2\2\2xv\3\2\2\2yz\7\16\2\2z~\b\n\1\2{|\7\r\2\2|~\b\n\1\2"+
		"}y\3\2\2\2}{\3\2\2\2~\23\3\2\2\2\177\u0080\7\24\2\2\u0080\u0081\b\13\1"+
		"\2\u0081\25\3\2\2\2\u0082\u0083\7\5\2\2\u0083\u0084\5\16\b\2\u0084\u0085"+
		"\7\6\2\2\u0085\u0086\b\f\1\2\u0086\u008f\3\2\2\2\u0087\u0088\7\26\2\2"+
		"\u0088\u008f\b\f\1\2\u0089\u008a\7\25\2\2\u008a\u008f\b\f\1\2\u008b\u008c"+
		"\5\24\13\2\u008c\u008d\b\f\1\2\u008d\u008f\3\2\2\2\u008e\u0082\3\2\2\2"+
		"\u008e\u0087\3\2\2\2\u008e\u0089\3\2\2\2\u008e\u008b\3\2\2\2\u008f\27"+
		"\3\2\2\2\f\35\62:BN^kv}\u008e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}