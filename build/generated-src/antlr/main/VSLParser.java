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
		VOID_TYPE=10, INT_TYPE=11, RETURN_STMNT=12, ADD=13, SUB=14, MUL=15, SDIV=16, 
		IDENT=17, TEXT=18, INTEGER=19;
	public static final int
		RULE_program = 0, RULE_fonction = 1, RULE_block = 2, RULE_statement = 3, 
		RULE_localdeclaration = 4, RULE_expression = 5, RULE_multExpr = 6, RULE_type = 7, 
		RULE_ident = 8, RULE_atome = 9;
	public static final String[] ruleNames = {
		"program", "fonction", "block", "statement", "localdeclaration", "expression", 
		"multExpr", "type", "ident", "atome"
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
		    SymbolTable table = new SymbolTable();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC_TYPE) {
				{
				{
				setState(20);
				((ProgramContext)_localctx).fonction = fonction(table);
				 fonctions.add(((ProgramContext)_localctx).fonction.out); 
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
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
		public SymbolTable table;
		public ASD.Fonction out;
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
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(FUNC_TYPE);
			setState(32);
			((FonctionContext)_localctx).type = type();
			setState(33);
			((FonctionContext)_localctx).ident = ident();
			setState(34);
			match(PO);
			setState(35);
			match(PF);
			setState(36);
			((FonctionContext)_localctx).block = block(table);

			      table.add(new SymbolTable.FunctionSymbol(((FonctionContext)_localctx).type.out, ((FonctionContext)_localctx).ident.text, null, true));
			      ((FonctionContext)_localctx).out =  new ASD.Fonction(((FonctionContext)_localctx).type.out, new ASD.GlobalID(((FonctionContext)_localctx).ident.text), ((FonctionContext)_localctx).block.out);
			    
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
		  
		int _la;
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BO:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(BO);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID_TYPE) | (1L << INT_TYPE) | (1L << RETURN_STMNT))) != 0)) {
					{
					{
					setState(40);
					((BlockContext)_localctx).statement = statement(table);

					      statements.addAll(((BlockContext)_localctx).statement.out);
					      
					    
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48);
				match(BF);
				 ((BlockContext)_localctx).out =  statements; 
				}
				break;
			case VOID_TYPE:
			case INT_TYPE:
			case RETURN_STMNT:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				((BlockContext)_localctx).statement = statement(table);

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
		public TerminalNode RETURN_STMNT() { return getToken(VSLParser.RETURN_STMNT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocaldeclarationContext localdeclaration() {
			return getRuleContext(LocaldeclarationContext.class,0);
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
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN_STMNT:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(RETURN_STMNT);
				setState(56);
				((StatementContext)_localctx).expression = expression(table);

				      expressions.add(new ASD.ReturnStatement(((StatementContext)_localctx).expression.out));
				      ((StatementContext)_localctx).out =  expressions;
				    
				}
				break;
			case VOID_TYPE:
			case INT_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				((StatementContext)_localctx).localdeclaration = localdeclaration(table);

				      expressions = ((StatementContext)_localctx).localdeclaration.out;
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
		enterRule(_localctx, 8, RULE_localdeclaration);

		    List<ASD.Expression> decls = new ArrayList<ASD.Expression>();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			((LocaldeclarationContext)_localctx).type = type();
			setState(65);
			((LocaldeclarationContext)_localctx).ident = ident();
			 
			        table.add(new SymbolTable.VariableSymbol(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
			        decls.add(new ASD.Instanciation(new ASD.Variable(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text)));
			        
			      
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(67);
				match(SEP);
				setState(68);
				((LocaldeclarationContext)_localctx).ident = ident();
				 
				        table.add(new SymbolTable.VariableSymbol(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
				        decls.add(new ASD.Instanciation(new ASD.Variable(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text)));
				        
				      
				}
				}
				setState(75);
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
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			((ExpressionContext)_localctx).l = multExpr(table);
			((ExpressionContext)_localctx).out =  ((ExpressionContext)_localctx).l.out; 
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(80);
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
				setState(81);
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
				setState(88);
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
		enterRule(_localctx, 12, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			((MultExprContext)_localctx).l = atome(table);
			((MultExprContext)_localctx).out =  ((MultExprContext)_localctx).l.out; 
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==SDIV) {
				{
				{
				setState(91);
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
				setState(92);
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
				setState(99);
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
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(INT_TYPE);

				      ((TypeContext)_localctx).out =  new ASD.IntType();
				    
				}
				break;
			case VOID_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
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
		enterRule(_localctx, 16, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
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
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public TerminalNode PF() { return getToken(VSLParser.PF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public TerminalNode TEXT() { return getToken(VSLParser.TEXT, 0); }
		public AtomeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AtomeContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_atome; }
	}

	public final AtomeContext atome(SymbolTable table) throws RecognitionException {
		AtomeContext _localctx = new AtomeContext(_ctx, getState(), table);
		enterRule(_localctx, 18, RULE_atome);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PO:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(PO);
				setState(110);
				((AtomeContext)_localctx).l = expression(table);
				setState(111);
				match(PF);

				        ((AtomeContext)_localctx).out =  ((AtomeContext)_localctx).l.out;
				      
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				((AtomeContext)_localctx).INTEGER = match(INTEGER);
				 ((AtomeContext)_localctx).out =  new ASD.IntegerExpression((((AtomeContext)_localctx).INTEGER!=null?Integer.valueOf(((AtomeContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				((AtomeContext)_localctx).TEXT = match(TEXT);
				 /*((AtomeContext)_localctx).out =  new ASD.StringExpression(((AtomeContext)_localctx).TEXT.getText());*/ 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25{\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\48\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7W"+
		"\n\7\f\7\16\7Z\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bb\n\b\f\b\16\be\13\b\3"+
		"\t\3\t\3\t\3\t\5\tk\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13y\n\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\4\3\2\17\20"+
		"\3\2\21\22\2z\2\33\3\2\2\2\4!\3\2\2\2\6\67\3\2\2\2\b@\3\2\2\2\nB\3\2\2"+
		"\2\fP\3\2\2\2\16[\3\2\2\2\20j\3\2\2\2\22l\3\2\2\2\24x\3\2\2\2\26\27\5"+
		"\4\3\2\27\30\b\2\1\2\30\32\3\2\2\2\31\26\3\2\2\2\32\35\3\2\2\2\33\31\3"+
		"\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\37\7\2\2\3\37 \b\2"+
		"\1\2 \3\3\2\2\2!\"\7\13\2\2\"#\5\20\t\2#$\5\22\n\2$%\7\5\2\2%&\7\6\2\2"+
		"&\'\5\6\4\2\'(\b\3\1\2(\5\3\2\2\2)/\7\7\2\2*+\5\b\5\2+,\b\4\1\2,.\3\2"+
		"\2\2-*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2"+
		"\2\2\62\63\7\b\2\2\638\b\4\1\2\64\65\5\b\5\2\65\66\b\4\1\2\668\3\2\2\2"+
		"\67)\3\2\2\2\67\64\3\2\2\28\7\3\2\2\29:\7\16\2\2:;\5\f\7\2;<\b\5\1\2<"+
		"A\3\2\2\2=>\5\n\6\2>?\b\5\1\2?A\3\2\2\2@9\3\2\2\2@=\3\2\2\2A\t\3\2\2\2"+
		"BC\5\20\t\2CD\5\22\n\2DK\b\6\1\2EF\7\t\2\2FG\5\22\n\2GH\b\6\1\2HJ\3\2"+
		"\2\2IE\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\b\6"+
		"\1\2O\13\3\2\2\2PQ\5\16\b\2QX\b\7\1\2RS\t\2\2\2ST\5\16\b\2TU\b\7\1\2U"+
		"W\3\2\2\2VR\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\r\3\2\2\2ZX\3\2\2\2"+
		"[\\\5\24\13\2\\c\b\b\1\2]^\t\3\2\2^_\5\24\13\2_`\b\b\1\2`b\3\2\2\2a]\3"+
		"\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\17\3\2\2\2ec\3\2\2\2fg\7\r\2\2g"+
		"k\b\t\1\2hi\7\f\2\2ik\b\t\1\2jf\3\2\2\2jh\3\2\2\2k\21\3\2\2\2lm\7\23\2"+
		"\2mn\b\n\1\2n\23\3\2\2\2op\7\5\2\2pq\5\f\7\2qr\7\6\2\2rs\b\13\1\2sy\3"+
		"\2\2\2tu\7\25\2\2uy\b\13\1\2vw\7\24\2\2wy\b\13\1\2xo\3\2\2\2xt\3\2\2\2"+
		"xv\3\2\2\2y\25\3\2\2\2\13\33/\67@KXcjx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}