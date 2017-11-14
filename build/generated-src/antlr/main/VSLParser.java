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
		WS=1, COMMENT=2, PO=3, PF=4, BO=5, BF=6, SEP=7, EQUAL=8, PRINT=9, READ=10, 
		NE=11, EQ=12, GT=13, LT=14, GTE=15, LTE=16, FUNC_TYPE=17, PROTO_TYPE=18, 
		VOID_TYPE=19, INT_TYPE=20, RETURN_STMNT=21, IF=22, THEN=23, ELSE=24, FI=25, 
		WHILE=26, DO=27, DONE=28, ADD=29, SUB=30, MUL=31, SDIV=32, IDENT=33, TEXT=34, 
		INTEGER=35;
	public static final int
		RULE_program = 0, RULE_fonction = 1, RULE_block = 2, RULE_statement = 3, 
		RULE_condition = 4, RULE_operand = 5, RULE_affectation = 6, RULE_localdeclaration = 7, 
		RULE_expression = 8, RULE_multExpr = 9, RULE_type = 10, RULE_ident = 11, 
		RULE_args = 12, RULE_atome = 13;
	public static final String[] ruleNames = {
		"program", "fonction", "block", "statement", "condition", "operand", "affectation", 
		"localdeclaration", "expression", "multExpr", "type", "ident", "args", 
		"atome"
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC_TYPE || _la==PROTO_TYPE) {
				{
				{
				setState(28);
				((ProgramContext)_localctx).fonction = fonction(table);
				 listExpression.add(((ProgramContext)_localctx).fonction.out); 
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(FUNC_TYPE);
				setState(40);
				((FonctionContext)_localctx).type = type();
				setState(41);
				((FonctionContext)_localctx).ident = ident();
				setState(42);
				match(PO);
				setState(43);
				match(PF);
				setState(44);
				((FonctionContext)_localctx).block = block(table);

				      table.add(new SymbolTable.FunctionSymbol(((FonctionContext)_localctx).type.out, ((FonctionContext)_localctx).ident.text, null, true));
				      ((FonctionContext)_localctx).out =  new ASD.Fonction(((FonctionContext)_localctx).type.out, ((FonctionContext)_localctx).ident.text, ((FonctionContext)_localctx).block.out);
				    
				}
				break;
			case PROTO_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(PROTO_TYPE);
				setState(48);
				((FonctionContext)_localctx).type = type();
				setState(49);
				((FonctionContext)_localctx).ident = ident();
				setState(50);
				match(PO);
				setState(51);
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
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BO:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(BO);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << VOID_TYPE) | (1L << INT_TYPE) | (1L << RETURN_STMNT) | (1L << IF) | (1L << WHILE) | (1L << IDENT))) != 0)) {
					{
					{
					setState(57);
					((BlockContext)_localctx).statement = statement(newTable);

					      statements.addAll(((BlockContext)_localctx).statement.out);
					      
					    
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(BF);
				 ((BlockContext)_localctx).out =  statements; 
				}
				break;
			case PRINT:
			case VOID_TYPE:
			case INT_TYPE:
			case RETURN_STMNT:
			case IF:
			case WHILE:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
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
		public ArgsContext args;
		public LocaldeclarationContext localdeclaration;
		public AffectationContext affectation;
		public ConditionContext condition;
		public BlockContext block;
		public BlockContext t;
		public BlockContext f;
		public TerminalNode RETURN_STMNT() { return getToken(VSLParser.RETURN_STMNT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(VSLParser.PRINT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public LocaldeclarationContext localdeclaration() {
			return getRuleContext(LocaldeclarationContext.class,0);
		}
		public AffectationContext affectation() {
			return getRuleContext(AffectationContext.class,0);
		}
		public TerminalNode IF() { return getToken(VSLParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(VSLParser.THEN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode FI() { return getToken(VSLParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(VSLParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(VSLParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(VSLParser.DO, 0); }
		public TerminalNode DONE() { return getToken(VSLParser.DONE, 0); }
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
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(RETURN_STMNT);
				setState(73);
				((StatementContext)_localctx).expression = expression(table);

				      expressions.add(new ASD.ReturnStatement(((StatementContext)_localctx).expression.out));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(PRINT);
				setState(77);
				((StatementContext)_localctx).args = args(table);

				      expressions.add(new ASD.PrintFunction(((StatementContext)_localctx).args.out));
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				((StatementContext)_localctx).localdeclaration = localdeclaration(table);

				      expressions = ((StatementContext)_localctx).localdeclaration.out;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				((StatementContext)_localctx).affectation = affectation(table);

				      expressions.add(((StatementContext)_localctx).affectation.out);
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				match(IF);
				setState(87);
				((StatementContext)_localctx).condition = condition(table);
				setState(88);
				match(THEN);
				setState(89);
				((StatementContext)_localctx).block = block(table);
				setState(90);
				match(FI);

				      expressions.add(new ASD.If(((StatementContext)_localctx).condition.out, ((StatementContext)_localctx).block.out));
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				match(IF);
				setState(94);
				((StatementContext)_localctx).condition = condition(table);
				setState(95);
				match(THEN);
				setState(96);
				((StatementContext)_localctx).t = block(table);
				setState(97);
				match(ELSE);
				setState(98);
				((StatementContext)_localctx).f = block(table);
				setState(99);
				match(FI);

				      expressions.add(new ASD.IfElse(((StatementContext)_localctx).condition.out, ((StatementContext)_localctx).t.out, ((StatementContext)_localctx).f.out));
				      //((StatementContext)_localctx).out =  expressions;
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(102);
				match(WHILE);
				setState(103);
				((StatementContext)_localctx).condition = condition(table);
				setState(104);
				match(DO);
				setState(105);
				((StatementContext)_localctx).block = block(table);
				setState(106);
				match(DONE);

				      expressions.add(new ASD.While(((StatementContext)_localctx).condition.out, ((StatementContext)_localctx).block.out));
				      //((StatementContext)_localctx).out =  expressions;
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);

			    ((StatementContext)_localctx).out =  expressions;
			  
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

	public static class ConditionContext extends ParserRuleContext {
		public SymbolTable table;
		public ASD.Expression out;
		public ExpressionContext l;
		public ExpressionContext expression;
		public OperandContext operand;
		public ExpressionContext r;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ConditionContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition(SymbolTable table) throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState(), table);
		enterRule(_localctx, 8, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			((ConditionContext)_localctx).l = ((ConditionContext)_localctx).expression = expression(table);
			 
			        ((ConditionContext)_localctx).out =  new ASD.Booleen(((ConditionContext)_localctx).expression.out); 
			      
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NE) | (1L << EQ) | (1L << GT) | (1L << LT) | (1L << GTE) | (1L << LTE))) != 0)) {
				{
				setState(113);
				((ConditionContext)_localctx).operand = operand();
				setState(114);
				((ConditionContext)_localctx).r = ((ConditionContext)_localctx).expression = expression(table);
				 
				        ((ConditionContext)_localctx).out =  new ASD.Condition(((ConditionContext)_localctx).l.out, ((ConditionContext)_localctx).operand.out, ((ConditionContext)_localctx).r.out); 
				      
				}
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

	public static class OperandContext extends ParserRuleContext {
		public ASD.Operand out;
		public TerminalNode NE() { return getToken(VSLParser.NE, 0); }
		public TerminalNode EQ() { return getToken(VSLParser.EQ, 0); }
		public TerminalNode GT() { return getToken(VSLParser.GT, 0); }
		public TerminalNode LT() { return getToken(VSLParser.LT, 0); }
		public TerminalNode GTE() { return getToken(VSLParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(VSLParser.LTE, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operand);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NE:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(NE);
				 ((OperandContext)_localctx).out =  new ASD.DifferentOperand(); 
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(EQ);
				 ((OperandContext)_localctx).out =  new ASD.EqualOperand(); 
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(GT);
				 ((OperandContext)_localctx).out =  new ASD.GreaterThanOperand(); 
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				match(LT);
				 ((OperandContext)_localctx).out =  new ASD.LessThanOperand(); 
				}
				break;
			case GTE:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				match(GTE);
				 ((OperandContext)_localctx).out =  new ASD.GreaterThanOrEqualOperand(); 
				}
				break;
			case LTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				match(LTE);
				 ((OperandContext)_localctx).out =  new ASD.LessThanOrEqualOperand(); 
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
		enterRule(_localctx, 12, RULE_affectation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((AffectationContext)_localctx).ident = ident();
			setState(134);
			match(EQUAL);
			setState(135);
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
		enterRule(_localctx, 14, RULE_localdeclaration);

		    List<ASD.Expression> decls = new ArrayList<ASD.Expression>();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((LocaldeclarationContext)_localctx).type = type();
			setState(139);
			((LocaldeclarationContext)_localctx).ident = ident();
			 
			        table.add(new SymbolTable.VariableSymbol(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
			        decls.add(new ASD.Instanciation(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
			        
			      
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(141);
				match(SEP);
				setState(142);
				((LocaldeclarationContext)_localctx).ident = ident();
				 
				        table.add(new SymbolTable.VariableSymbol(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
				        decls.add(new ASD.Instanciation(((LocaldeclarationContext)_localctx).type.out, ((LocaldeclarationContext)_localctx).ident.text));
				        
				      
				}
				}
				setState(149);
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
		enterRule(_localctx, 16, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((ExpressionContext)_localctx).l = multExpr(table);
			((ExpressionContext)_localctx).out =  ((ExpressionContext)_localctx).l.out; 
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(154);
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
				setState(155);
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
				setState(162);
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
		enterRule(_localctx, 18, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			((MultExprContext)_localctx).l = atome(table);
			((MultExprContext)_localctx).out =  ((MultExprContext)_localctx).l.out; 
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==SDIV) {
				{
				{
				setState(165);
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
				setState(166);
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
				setState(173);
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
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(INT_TYPE);

				      ((TypeContext)_localctx).out =  new ASD.IntType();
				    
				}
				break;
			case VOID_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
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
		enterRule(_localctx, 22, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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

	public static class ArgsContext extends ParserRuleContext {
		public SymbolTable table;
		public SymbolTable arguments;
		public List<ASD.Expression> out;
		public ExpressionContext expression;
		public ExpressionContext p;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(VSLParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(VSLParser.SEP, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ArgsContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args(SymbolTable table) throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState(), table);
		enterRule(_localctx, 24, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			((ArgsContext)_localctx).expression = expression(table);

			      ((ArgsContext)_localctx).out =  new ArrayList<ASD.Expression>();
			      _localctx.out.add(((ArgsContext)_localctx).expression.out);
			    
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(185);
				match(SEP);
				setState(186);
				((ArgsContext)_localctx).p = ((ArgsContext)_localctx).expression = expression(table);

				      _localctx.out.add(((ArgsContext)_localctx).p.out);
				    
				}
				}
				setState(193);
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

	public static class AtomeContext extends ParserRuleContext {
		public SymbolTable table;
		public ASD.Expression out;
		public ExpressionContext l;
		public IdentContext ident;
		public ArgsContext args;
		public Token INTEGER;
		public Token TEXT;
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public TerminalNode PF() { return getToken(VSLParser.PF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
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
		enterRule(_localctx, 26, RULE_atome);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(PO);
				setState(195);
				((AtomeContext)_localctx).l = expression(table);
				setState(196);
				match(PF);

				        ((AtomeContext)_localctx).out =  ((AtomeContext)_localctx).l.out;
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				((AtomeContext)_localctx).ident = ident();
				setState(200);
				match(PO);
				setState(201);
				((AtomeContext)_localctx).args = args(table);
				setState(202);
				match(PF);

				        SymbolTable.FunctionSymbol s = (SymbolTable.FunctionSymbol) table.lookup(((AtomeContext)_localctx).ident.text);
				        if(s == null) { throw new IllegalArgumentException("Cannot find symbol " + ((AtomeContext)_localctx).ident.text); }
				        SymbolTable.FunctionSymbol f = new SymbolTable.FunctionSymbol(s.returnType, ((AtomeContext)_localctx).ident.text, ((AtomeContext)_localctx).args.arguments, s.defined);
				        if(!s.equals(f)) { throw new IllegalArgumentException("Cannot find function with these args for function : " + ((AtomeContext)_localctx).ident.text);}
				        
				        ((AtomeContext)_localctx).out =  new ASD.CallFonction(s.returnType, ((AtomeContext)_localctx).ident.text, ((AtomeContext)_localctx).args.out);
				      
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				((AtomeContext)_localctx).INTEGER = match(INTEGER);
				 ((AtomeContext)_localctx).out =  new ASD.IntegerExpression((((AtomeContext)_localctx).INTEGER!=null?Integer.valueOf(((AtomeContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				((AtomeContext)_localctx).TEXT = match(TEXT);
				 ((AtomeContext)_localctx).out =  new ASD.StringExpression(((AtomeContext)_localctx).TEXT.getText()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				((AtomeContext)_localctx).ident = ident();

				        SymbolTable.Symbol s = table.lookup(((AtomeContext)_localctx).ident.text);
				        if(s == null) { throw new IllegalArgumentException("Cannot find symbol " + ((AtomeContext)_localctx).ident.text); }
				        if(s instanceof SymbolTable.VariableSymbol) {
				          ((AtomeContext)_localctx).out =  new ASD.Variable(((SymbolTable.VariableSymbol) s).type, s.ident);
				        }
				      
				}
				break;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2"+
		"%\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\39\n\3\3\4\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5p\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6x\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0086\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0094\n\t\f\t\16\t\u0097\13"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00a1\n\n\f\n\16\n\u00a4\13\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ac\n\13\f\13\16\13\u00af\13\13\3"+
		"\f\3\f\3\f\3\f\5\f\u00b5\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u00c0\n\16\f\16\16\16\u00c3\13\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d7"+
		"\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\4\3\2\37 \3\2"+
		"!\"\2\u00e3\2#\3\2\2\2\48\3\2\2\2\6H\3\2\2\2\bo\3\2\2\2\nq\3\2\2\2\f\u0085"+
		"\3\2\2\2\16\u0087\3\2\2\2\20\u008c\3\2\2\2\22\u009a\3\2\2\2\24\u00a5\3"+
		"\2\2\2\26\u00b4\3\2\2\2\30\u00b6\3\2\2\2\32\u00b9\3\2\2\2\34\u00d6\3\2"+
		"\2\2\36\37\5\4\3\2\37 \b\2\1\2 \"\3\2\2\2!\36\3\2\2\2\"%\3\2\2\2#!\3\2"+
		"\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\2\2\3\'(\b\2\1\2(\3\3\2\2\2)*"+
		"\7\23\2\2*+\5\26\f\2+,\5\30\r\2,-\7\5\2\2-.\7\6\2\2./\5\6\4\2/\60\b\3"+
		"\1\2\609\3\2\2\2\61\62\7\24\2\2\62\63\5\26\f\2\63\64\5\30\r\2\64\65\7"+
		"\5\2\2\65\66\7\6\2\2\66\67\b\3\1\2\679\3\2\2\28)\3\2\2\28\61\3\2\2\29"+
		"\5\3\2\2\2:@\7\7\2\2;<\5\b\5\2<=\b\4\1\2=?\3\2\2\2>;\3\2\2\2?B\3\2\2\2"+
		"@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7\b\2\2DI\b\4\1\2EF\5\b\5\2"+
		"FG\b\4\1\2GI\3\2\2\2H:\3\2\2\2HE\3\2\2\2I\7\3\2\2\2JK\7\27\2\2KL\5\22"+
		"\n\2LM\b\5\1\2Mp\3\2\2\2NO\7\13\2\2OP\5\32\16\2PQ\b\5\1\2Qp\3\2\2\2RS"+
		"\5\20\t\2ST\b\5\1\2Tp\3\2\2\2UV\5\16\b\2VW\b\5\1\2Wp\3\2\2\2XY\7\30\2"+
		"\2YZ\5\n\6\2Z[\7\31\2\2[\\\5\6\4\2\\]\7\33\2\2]^\b\5\1\2^p\3\2\2\2_`\7"+
		"\30\2\2`a\5\n\6\2ab\7\31\2\2bc\5\6\4\2cd\7\32\2\2de\5\6\4\2ef\7\33\2\2"+
		"fg\b\5\1\2gp\3\2\2\2hi\7\34\2\2ij\5\n\6\2jk\7\35\2\2kl\5\6\4\2lm\7\36"+
		"\2\2mn\b\5\1\2np\3\2\2\2oJ\3\2\2\2oN\3\2\2\2oR\3\2\2\2oU\3\2\2\2oX\3\2"+
		"\2\2o_\3\2\2\2oh\3\2\2\2p\t\3\2\2\2qr\5\22\n\2rw\b\6\1\2st\5\f\7\2tu\5"+
		"\22\n\2uv\b\6\1\2vx\3\2\2\2ws\3\2\2\2wx\3\2\2\2x\13\3\2\2\2yz\7\r\2\2"+
		"z\u0086\b\7\1\2{|\7\16\2\2|\u0086\b\7\1\2}~\7\17\2\2~\u0086\b\7\1\2\177"+
		"\u0080\7\20\2\2\u0080\u0086\b\7\1\2\u0081\u0082\7\21\2\2\u0082\u0086\b"+
		"\7\1\2\u0083\u0084\7\22\2\2\u0084\u0086\b\7\1\2\u0085y\3\2\2\2\u0085{"+
		"\3\2\2\2\u0085}\3\2\2\2\u0085\177\3\2\2\2\u0085\u0081\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\r\3\2\2\2\u0087\u0088\5\30\r\2\u0088\u0089\7\n\2\2\u0089"+
		"\u008a\5\22\n\2\u008a\u008b\b\b\1\2\u008b\17\3\2\2\2\u008c\u008d\5\26"+
		"\f\2\u008d\u008e\5\30\r\2\u008e\u0095\b\t\1\2\u008f\u0090\7\t\2\2\u0090"+
		"\u0091\5\30\r\2\u0091\u0092\b\t\1\2\u0092\u0094\3\2\2\2\u0093\u008f\3"+
		"\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\b\t\1\2\u0099\21\3\2\2"+
		"\2\u009a\u009b\5\24\13\2\u009b\u00a2\b\n\1\2\u009c\u009d\t\2\2\2\u009d"+
		"\u009e\5\24\13\2\u009e\u009f\b\n\1\2\u009f\u00a1\3\2\2\2\u00a0\u009c\3"+
		"\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\23\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\5\34\17\2\u00a6\u00ad\b\13"+
		"\1\2\u00a7\u00a8\t\3\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00aa\b\13\1\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\25\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1"+
		"\7\26\2\2\u00b1\u00b5\b\f\1\2\u00b2\u00b3\7\25\2\2\u00b3\u00b5\b\f\1\2"+
		"\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\27\3\2\2\2\u00b6\u00b7"+
		"\7#\2\2\u00b7\u00b8\b\r\1\2\u00b8\31\3\2\2\2\u00b9\u00ba\5\22\n\2\u00ba"+
		"\u00c1\b\16\1\2\u00bb\u00bc\7\t\2\2\u00bc\u00bd\5\22\n\2\u00bd\u00be\b"+
		"\16\1\2\u00be\u00c0\3\2\2\2\u00bf\u00bb\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\33\3\2\2\2\u00c3\u00c1\3\2\2"+
		"\2\u00c4\u00c5\7\5\2\2\u00c5\u00c6\5\22\n\2\u00c6\u00c7\7\6\2\2\u00c7"+
		"\u00c8\b\17\1\2\u00c8\u00d7\3\2\2\2\u00c9\u00ca\5\30\r\2\u00ca\u00cb\7"+
		"\5\2\2\u00cb\u00cc\5\32\16\2\u00cc\u00cd\7\6\2\2\u00cd\u00ce\b\17\1\2"+
		"\u00ce\u00d7\3\2\2\2\u00cf\u00d0\7%\2\2\u00d0\u00d7\b\17\1\2\u00d1\u00d2"+
		"\7$\2\2\u00d2\u00d7\b\17\1\2\u00d3\u00d4\5\30\r\2\u00d4\u00d5\b\17\1\2"+
		"\u00d5\u00d7\3\2\2\2\u00d6\u00c4\3\2\2\2\u00d6\u00c9\3\2\2\2\u00d6\u00cf"+
		"\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d7\35\3\2\2\2\17#"+
		"8@How\u0085\u0095\u00a2\u00ad\u00b4\u00c1\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}