// Generated from VSLParser.g by ANTLR 4.7

  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;
  import java.util.HashMap;

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
		WS=1, COMMENT=2, PO=3, PF=4, TO=5, TC=6, BO=7, BF=8, SEP=9, EQUAL=10, 
		PRINT=11, READ=12, NE=13, EQ=14, GT=15, LT=16, GTE=17, LTE=18, FUNC_TYPE=19, 
		PROTO_TYPE=20, VOID_TYPE=21, INT_TYPE=22, RETURN_STMNT=23, IF=24, THEN=25, 
		ELSE=26, FI=27, WHILE=28, DO=29, DONE=30, ADD=31, SUB=32, MUL=33, SDIV=34, 
		IDENT=35, TEXT=36, INTEGER=37;
	public static final int
		RULE_program = 0, RULE_fonction = 1, RULE_argsDecl = 2, RULE_argDecl = 3, 
		RULE_block = 4, RULE_innerBlock = 5, RULE_identExp = 6, RULE_statement = 7, 
		RULE_condition = 8, RULE_cond = 9, RULE_affectation = 10, RULE_localdeclaration = 11, 
		RULE_identVar = 12, RULE_expression = 13, RULE_multExpr = 14, RULE_type = 15, 
		RULE_ident = 16, RULE_args = 17, RULE_atome = 18;
	public static final String[] ruleNames = {
		"program", "fonction", "argsDecl", "argDecl", "block", "innerBlock", "identExp", 
		"statement", "condition", "cond", "affectation", "localdeclaration", "identVar", 
		"expression", "multExpr", "type", "ident", "args", "atome"
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC_TYPE || _la==PROTO_TYPE) {
				{
				{
				setState(38);
				((ProgramContext)_localctx).fonction = fonction(table);

				      listExpression.add(((ProgramContext)_localctx).fonction.out);
				    
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
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
		public ArgsDeclContext argsDecl;
		public BlockContext block;
		public TerminalNode FUNC_TYPE() { return getToken(VSLParser.FUNC_TYPE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public ArgsDeclContext argsDecl() {
			return getRuleContext(ArgsDeclContext.class,0);
		}
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

		    Utils.resettmp();
		    SymbolTable funcTable = new SymbolTable(table);
		    List<ASD.Expression> expinit = new ArrayList<ASD.Expression>();
		  
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(FUNC_TYPE);
				setState(50);
				((FonctionContext)_localctx).type = type();
				setState(51);
				((FonctionContext)_localctx).ident = ident();

				      SymbolTable.Symbol proto = funcTable.lookup(((FonctionContext)_localctx).ident.text);
				      if(proto != null && ((SymbolTable.FunctionSymbol) proto).defined) {
				        throw new RedefinitionException(((FonctionContext)_localctx).ident.text + " already defined !");
				      }
				    
				setState(53);
				match(PO);
				setState(54);
				((FonctionContext)_localctx).argsDecl = argsDecl(funcTable);
				setState(55);
				match(PF);

				      expinit.addAll(((FonctionContext)_localctx).argsDecl.initExpr);
				      ASD.Variable v = null;
				      if(!(((FonctionContext)_localctx).type.retType instanceof ASD.VoidType)) {
				        v = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(((FonctionContext)_localctx).type.retType), Utils.newtmp());
				        expinit.add(new ASD.Instanciation(v));
				        funcTable.add("RETURN", new SymbolTable.VariableSymbol(v));
				      }
				    
				setState(57);
				((FonctionContext)_localctx).block = block(funcTable);

				      ASD.Variable func = new ASD.Variable(ASD.Variable.global_scope, ((FonctionContext)_localctx).type.retType, ((FonctionContext)_localctx).ident.text);
				      SymbolTable.FunctionSymbol f = new SymbolTable.FunctionSymbol(func, ((FonctionContext)_localctx).argsDecl.argTable, true);
				      table.add(((FonctionContext)_localctx).ident.text, f );
				      if(proto != null && proto instanceof SymbolTable.FunctionSymbol) {
				        if(((SymbolTable.FunctionSymbol) proto).defined ) {
				          throw new IllegalArgumentException("Error: " + ((FonctionContext)_localctx).ident.text + " already defined !");
				        }
				        if(!f.equals(proto)) {
				          throw new IllegalArgumentException("Conflit type with " + ((FonctionContext)_localctx).ident.text);
				        }
				      }

				      expinit.addAll(((FonctionContext)_localctx).block.out);

				      if(v != null) {
				        ASD.Value retV = new ASD.Value(v);
				        expinit.add(retV);
				        expinit.add(new ASD.ReturnStatement(retV.getResult()));
				      }

				      ((FonctionContext)_localctx).out =  new ASD.Fonction(func, ((FonctionContext)_localctx).argsDecl.out, expinit);
				    
				}
				break;
			case PROTO_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(PROTO_TYPE);
				setState(61);
				((FonctionContext)_localctx).type = type();
				setState(62);
				((FonctionContext)_localctx).ident = ident();
				setState(63);
				match(PO);
				setState(64);
				((FonctionContext)_localctx).argsDecl = argsDecl(funcTable);
				setState(65);
				match(PF);

				      ASD.Variable func = new ASD.Variable(ASD.Variable.global_scope, ((FonctionContext)_localctx).type.retType, ((FonctionContext)_localctx).ident.text);
				      table.add(func.var_name, new SymbolTable.FunctionSymbol(func, ((FonctionContext)_localctx).argsDecl.argTable, false));
				      ((FonctionContext)_localctx).out =  new ASD.ProtoFonction(func);
				    
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

	public static class ArgsDeclContext extends ParserRuleContext {
		public SymbolTable table;
		public List<ASD.Variable> out;
		public List<ASD.Expression> initExpr;
		public SymbolTable argTable;
		public ArgDeclContext argDecl;
		public List<ArgDeclContext> argDecl() {
			return getRuleContexts(ArgDeclContext.class);
		}
		public ArgDeclContext argDecl(int i) {
			return getRuleContext(ArgDeclContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(VSLParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(VSLParser.SEP, i);
		}
		public ArgsDeclContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ArgsDeclContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_argsDecl; }
	}

	public final ArgsDeclContext argsDecl(SymbolTable table) throws RecognitionException {
		ArgsDeclContext _localctx = new ArgsDeclContext(_ctx, getState(), table);
		enterRule(_localctx, 4, RULE_argsDecl);

		    List<ASD.Variable> args = new ArrayList<ASD.Variable>(); // arguments, pour definition de la fonction
		    HashMap<String, ASD.Variable> hmPtr = new HashMap<String, ASD.Variable>(); // pour initialiser les variables au debut de la fonction
		    SymbolTable t = new SymbolTable(); // SymbolTable vierge, sans les variable globale, pour signature de la fonction
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID_TYPE) | (1L << INT_TYPE) | (1L << IDENT))) != 0)) {
				{
				setState(70);
				((ArgsDeclContext)_localctx).argDecl = argDecl();

				      ASD.Variable v = ((ArgsDeclContext)_localctx).argDecl.out;
				      hmPtr.put(((ArgsDeclContext)_localctx).argDecl.idText, ((ArgsDeclContext)_localctx).argDecl.out);
				      args.add(v);
				      t.add(((ArgsDeclContext)_localctx).argDecl.idText, new SymbolTable.VariableSymbol(v));
				    
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(72);
					match(SEP);
					setState(73);
					((ArgsDeclContext)_localctx).argDecl = argDecl();

					      v = ((ArgsDeclContext)_localctx).argDecl.out;
					      args.add(v);
					      hmPtr.put(((ArgsDeclContext)_localctx).argDecl.idText, ((ArgsDeclContext)_localctx).argDecl.out);
					      t.add(v.var_name, new SymbolTable.VariableSymbol(v));
					    
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
			_ctx.stop = _input.LT(-1);

			    List<ASD.Variable> toPtr = new ArrayList<ASD.Variable>();
			    List<ASD.Variable> val = new ArrayList<ASD.Variable>();
			    for(String k : hmPtr.keySet()) {
			      val.add(hmPtr.get(k));
			      ASD.Variable v = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(hmPtr.get(k).type), Utils.newtmp());
			      table.add(k, new SymbolTable.VariableSymbol(v));
			      toPtr.add(v);
			    }

			    List<ASD.Expression> init = new ArrayList<ASD.Expression>(); // pour initialiser les variables, a retourner apres traitement avec la hashmap

			    for(int i = 0; i < val.size(); i++) {
			      init.add(new ASD.Instanciation(toPtr.get(i)));
			    }

			    for(int i = 0; i < val.size(); i++) {
			      init.add(new ASD.Affectation(toPtr.get(i), val.get(i)));
			    }

			    ((ArgsDeclContext)_localctx).out =  args;
			    ((ArgsDeclContext)_localctx).argTable =  t;
			    ((ArgsDeclContext)_localctx).initExpr =  init;

			  
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

	public static class ArgDeclContext extends ParserRuleContext {
		public ASD.Variable out;
		public String idText;
		public IdentContext ident;
		public TypeContext type;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TO() { return getToken(VSLParser.TO, 0); }
		public TerminalNode TC() { return getToken(VSLParser.TC, 0); }
		public ArgDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argDecl; }
	}

	public final ArgDeclContext argDecl() throws RecognitionException {
		ArgDeclContext _localctx = new ArgDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_argDecl);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				((ArgDeclContext)_localctx).ident = ident();

				      System.err.println("no type specified, default : int");
				      ((ArgDeclContext)_localctx).out =  new ASD.Variable(ASD.Variable.local_scope, new ASD.IntType(), Utils.newtmp());
				      ((ArgDeclContext)_localctx).idText =  ((ArgDeclContext)_localctx).ident.text;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				((ArgDeclContext)_localctx).type = type();
				setState(87);
				((ArgDeclContext)_localctx).ident = ident();

				      ((ArgDeclContext)_localctx).out =  new ASD.Variable(ASD.Variable.local_scope, ((ArgDeclContext)_localctx).type.retType, Utils.newtmp());
				      ((ArgDeclContext)_localctx).idText =  ((ArgDeclContext)_localctx).ident.text;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				((ArgDeclContext)_localctx).ident = ident();
				setState(91);
				match(TO);
				setState(92);
				match(TC);

				      System.err.println("no type specified, default : int*");
				      ((ArgDeclContext)_localctx).out =  new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(new ASD.IntType()), Utils.newtmp());
				      ((ArgDeclContext)_localctx).idText =  ((ArgDeclContext)_localctx).ident.text;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				((ArgDeclContext)_localctx).type = type();
				setState(96);
				((ArgDeclContext)_localctx).ident = ident();
				setState(97);
				match(TO);
				setState(98);
				match(TC);

				      ((ArgDeclContext)_localctx).out =  new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(((ArgDeclContext)_localctx).type.retType), Utils.newtmp());
				      ((ArgDeclContext)_localctx).idText =  ((ArgDeclContext)_localctx).ident.text;
				    
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
		enterRule(_localctx, 8, RULE_block);

		    List<ASD.Expression> statements = new ArrayList<ASD.Expression>();
		    SymbolTable newTable = new SymbolTable(table);
		  
		int _la;
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(BO);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BO) | (1L << PRINT) | (1L << READ) | (1L << VOID_TYPE) | (1L << INT_TYPE) | (1L << RETURN_STMNT) | (1L << IF) | (1L << WHILE) | (1L << IDENT))) != 0)) {
					{
					{
					setState(104);
					((BlockContext)_localctx).statement = statement(newTable);

					      statements.addAll(((BlockContext)_localctx).statement.out);
					    
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(BF);
				 ((BlockContext)_localctx).out =  statements; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				((BlockContext)_localctx).statement = statement(newTable);

				      statements.addAll(((BlockContext)_localctx).statement.out);
				      ((BlockContext)_localctx).out =  statements;
				    
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

	public static class InnerBlockContext extends ParserRuleContext {
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
		public InnerBlockContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InnerBlockContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_innerBlock; }
	}

	public final InnerBlockContext innerBlock(SymbolTable table) throws RecognitionException {
		InnerBlockContext _localctx = new InnerBlockContext(_ctx, getState(), table);
		enterRule(_localctx, 10, RULE_innerBlock);

		    List<ASD.Expression> statements = new ArrayList<ASD.Expression>();
		    SymbolTable newTable = new SymbolTable(table);
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(BO);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BO) | (1L << PRINT) | (1L << READ) | (1L << VOID_TYPE) | (1L << INT_TYPE) | (1L << RETURN_STMNT) | (1L << IF) | (1L << WHILE) | (1L << IDENT))) != 0)) {
				{
				{
				setState(120);
				((InnerBlockContext)_localctx).statement = statement(newTable);

				      statements.addAll(((InnerBlockContext)_localctx).statement.out);
				    
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(BF);
			 ((InnerBlockContext)_localctx).out =  statements; 
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

	public static class IdentExpContext extends ParserRuleContext {
		public SymbolTable table;
		public ASD.Expression out;
		public IdentContext ident;
		public ExpressionContext expression;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode TO() { return getToken(VSLParser.TO, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TC() { return getToken(VSLParser.TC, 0); }
		public IdentExpContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IdentExpContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_identExp; }
	}

	public final IdentExpContext identExp(SymbolTable table) throws RecognitionException {
		IdentExpContext _localctx = new IdentExpContext(_ctx, getState(), table);
		enterRule(_localctx, 12, RULE_identExp);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				((IdentExpContext)_localctx).ident = ident();

				      SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup(((IdentExpContext)_localctx).ident.text);
				      if(s == null) { throw new SymbolException("Cannot find symbol " + ((IdentExpContext)_localctx).ident.text); }
				      ((IdentExpContext)_localctx).out =  s.variable;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				((IdentExpContext)_localctx).ident = ident();
				setState(135);
				match(TO);
				setState(136);
				((IdentExpContext)_localctx).expression = expression(table);
				setState(137);
				match(TC);

				      SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup(((IdentExpContext)_localctx).ident.text);
				      if(s == null) { throw new SymbolException("Cannot find symbol " + ((IdentExpContext)_localctx).ident.text); }
				      ((IdentExpContext)_localctx).out =  new ASD.ArrayElement(s.variable, ((IdentExpContext)_localctx).expression.out);
				    
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

	public static class StatementContext extends ParserRuleContext {
		public SymbolTable table;
		public List<ASD.Expression> out;
		public IdentContext ident;
		public ArgsContext args;
		public InnerBlockContext innerBlock;
		public ExpressionContext expression;
		public IdentExpContext identExp;
		public LocaldeclarationContext localdeclaration;
		public AffectationContext affectation;
		public ConditionContext condition;
		public BlockContext block;
		public BlockContext t;
		public BlockContext f;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode PF() { return getToken(VSLParser.PF, 0); }
		public InnerBlockContext innerBlock() {
			return getRuleContext(InnerBlockContext.class,0);
		}
		public TerminalNode RETURN_STMNT() { return getToken(VSLParser.RETURN_STMNT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(VSLParser.PRINT, 0); }
		public TerminalNode READ() { return getToken(VSLParser.READ, 0); }
		public List<IdentExpContext> identExp() {
			return getRuleContexts(IdentExpContext.class);
		}
		public IdentExpContext identExp(int i) {
			return getRuleContext(IdentExpContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(VSLParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(VSLParser.SEP, i);
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
		enterRule(_localctx, 14, RULE_statement);

		    List<ASD.Expression> expressions = new ArrayList<ASD.Expression>();
		  
		int _la;
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				((StatementContext)_localctx).ident = ident();
				setState(143);
				match(PO);
				setState(144);
				((StatementContext)_localctx).args = args(table);
				setState(145);
				match(PF);

				        SymbolTable.FunctionSymbol s = (SymbolTable.FunctionSymbol) table.lookup(((StatementContext)_localctx).ident.text);
				        if(s == null) { throw new SymbolException("Cannot find symbol " + ((StatementContext)_localctx).ident.text); }
				        expressions.add(new ASD.CallFonction(s.variable, ((StatementContext)_localctx).args.out));
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				((StatementContext)_localctx).innerBlock = innerBlock(table);

				      expressions.addAll(((StatementContext)_localctx).innerBlock.out);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(RETURN_STMNT);
				setState(152);
				((StatementContext)_localctx).expression = expression(table);

				      SymbolTable.Symbol s = table.lookup("RETURN");
				      if(s == null) { throw new IllegalExpressionException("Cannot return with the type void"); }
				      if(!s.variable.type.equals(((StatementContext)_localctx).expression.retType)) { throw new TypeException("illegal type exception : found " + ((StatementContext)_localctx).expression.retType + " need " + s.variable.type);}
				      expressions.add(new ASD.Affectation(s.variable, ((StatementContext)_localctx).expression.out));
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				match(PRINT);
				setState(156);
				((StatementContext)_localctx).args = args(table);

				      expressions.add(new ASD.PrintFunction(((StatementContext)_localctx).args.out));
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				match(READ);
				 ArrayList<ASD.Expression> idents = new ArrayList<ASD.Expression>(); 
				setState(161);
				((StatementContext)_localctx).identExp = identExp(table);

				        idents.add(((StatementContext)_localctx).identExp.out);
				      
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(163);
					match(SEP);
					setState(164);
					((StatementContext)_localctx).identExp = identExp(table);

					          idents.add(((StatementContext)_localctx).identExp.out);
					        
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}

				        expressions.add(new ASD.ReadFunction(idents));
				      
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				((StatementContext)_localctx).localdeclaration = localdeclaration(table);

				      expressions = ((StatementContext)_localctx).localdeclaration.out;
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				((StatementContext)_localctx).affectation = affectation(table);

				      expressions.addAll(((StatementContext)_localctx).affectation.out);
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(180);
				match(IF);
				setState(181);
				((StatementContext)_localctx).condition = condition(table);
				setState(182);
				match(THEN);
				setState(183);
				((StatementContext)_localctx).block = block(table);
				setState(184);
				match(FI);

				      expressions.add(new ASD.If(((StatementContext)_localctx).condition.out, ((StatementContext)_localctx).block.out));
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(187);
				match(IF);
				setState(188);
				((StatementContext)_localctx).condition = condition(table);
				setState(189);
				match(THEN);
				setState(190);
				((StatementContext)_localctx).t = block(table);
				setState(191);
				match(ELSE);
				setState(192);
				((StatementContext)_localctx).f = block(table);
				setState(193);
				match(FI);

				      expressions.add(new ASD.IfElse(((StatementContext)_localctx).condition.out, ((StatementContext)_localctx).t.out, ((StatementContext)_localctx).f.out));
				      //((StatementContext)_localctx).out =  expressions;
				    
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(196);
				match(WHILE);
				setState(197);
				((StatementContext)_localctx).condition = condition(table);
				setState(198);
				match(DO);
				setState(199);
				((StatementContext)_localctx).block = block(table);
				setState(200);
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
		public ExpressionContext expression;
		public ExpressionContext l;
		public CondContext cond;
		public ExpressionContext r;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
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
		enterRule(_localctx, 16, RULE_condition);
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				((ConditionContext)_localctx).expression = expression(table);

				      ((ConditionContext)_localctx).out =  new ASD.BooleanExpression(((ConditionContext)_localctx).expression.out);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				((ConditionContext)_localctx).l = expression(table);
				setState(209);
				((ConditionContext)_localctx).cond = cond();
				setState(210);
				((ConditionContext)_localctx).r = expression(table);

				      ((ConditionContext)_localctx).out =  new ASD.Condition(((ConditionContext)_localctx).l.out, ((ConditionContext)_localctx).cond.out, ((ConditionContext)_localctx).r.out);
				    
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

	public static class CondContext extends ParserRuleContext {
		public ASD.Cond out;
		public TerminalNode NE() { return getToken(VSLParser.NE, 0); }
		public TerminalNode EQ() { return getToken(VSLParser.EQ, 0); }
		public TerminalNode GT() { return getToken(VSLParser.GT, 0); }
		public TerminalNode LT() { return getToken(VSLParser.LT, 0); }
		public TerminalNode GTE() { return getToken(VSLParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(VSLParser.LTE, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cond);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NE:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(NE);
				 ((CondContext)_localctx).out =  new ASD.DifferentCond(); 
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				match(EQ);
				 ((CondContext)_localctx).out =  new ASD.EqualCond(); 
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(GT);
				 ((CondContext)_localctx).out =  new ASD.GreaterThanCond(); 
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				match(LT);
				 ((CondContext)_localctx).out =  new ASD.LessThanCond(); 
				}
				break;
			case GTE:
				enterOuterAlt(_localctx, 5);
				{
				setState(223);
				match(GTE);
				 ((CondContext)_localctx).out =  new ASD.GreaterThanOrEqualCond(); 
				}
				break;
			case LTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(225);
				match(LTE);
				 ((CondContext)_localctx).out =  new ASD.LessThanOrEqualCond(); 
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
		public List<ASD.Expression> out;
		public IdentContext ident;
		public ExpressionContext expression;
		public ExpressionContext i;
		public ExpressionContext v;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(VSLParser.EQUAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TO() { return getToken(VSLParser.TO, 0); }
		public TerminalNode TC() { return getToken(VSLParser.TC, 0); }
		public AffectationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AffectationContext(ParserRuleContext parent, int invokingState, SymbolTable table) {
			super(parent, invokingState);
			this.table = table;
		}
		@Override public int getRuleIndex() { return RULE_affectation; }
	}

	public final AffectationContext affectation(SymbolTable table) throws RecognitionException {
		AffectationContext _localctx = new AffectationContext(_ctx, getState(), table);
		enterRule(_localctx, 20, RULE_affectation);

		    List<ASD.Expression> retExprs = new ArrayList<ASD.Expression>();
		  
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				((AffectationContext)_localctx).ident = ident();
				setState(230);
				match(EQUAL);
				setState(231);
				((AffectationContext)_localctx).expression = expression(table);

				      SymbolTable.Symbol s = table.lookup(((AffectationContext)_localctx).ident.text);
				      if(s == null) { throw new SymbolException("Cannot find symbol " + ((AffectationContext)_localctx).ident.text); }
				      if(!s.variable.type.equals(((AffectationContext)_localctx).expression.retType)) {
				         throw new TypeException("illegal type exception : found " + ((AffectationContext)_localctx).expression.retType + " need " + s.variable.type);
				      }
				      retExprs.add(new ASD.Affectation(s.variable, ((AffectationContext)_localctx).expression.out));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				((AffectationContext)_localctx).ident = ident();
				setState(235);
				match(TO);
				setState(236);
				((AffectationContext)_localctx).i = expression(table);
				setState(237);
				match(TC);

				      SymbolTable.Symbol s = table.lookup(((AffectationContext)_localctx).ident.text);
				      if(s == null) { throw new SymbolException("Cannot find symbol " + ((AffectationContext)_localctx).ident.text); }
				      ASD.ArrayElement arElem = new ASD.ArrayElement(s.variable, ((AffectationContext)_localctx).i.out);
				      retExprs.add(arElem);
				    
				setState(239);
				match(EQUAL);
				setState(240);
				((AffectationContext)_localctx).v = expression(table);

				      retExprs.add(new ASD.Affectation(arElem.getResult(), ((AffectationContext)_localctx).v.out));

				      if(!s.variable.type.equals(((AffectationContext)_localctx).v.retType)) {
				         throw new TypeException("illegal type exception : found " + ((AffectationContext)_localctx).v.retType + " need " + s.variable.type);
				      }
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);

			    ((AffectationContext)_localctx).out =  retExprs;
			  
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
		public IdentVarContext identVar;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentVarContext> identVar() {
			return getRuleContexts(IdentVarContext.class);
		}
		public IdentVarContext identVar(int i) {
			return getRuleContext(IdentVarContext.class,i);
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
		enterRule(_localctx, 22, RULE_localdeclaration);

		    List<ASD.Expression> decls = new ArrayList<ASD.Expression>();

		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			((LocaldeclarationContext)_localctx).type = type();
			setState(246);
			((LocaldeclarationContext)_localctx).identVar = identVar(table, new ASD.PointerType(((LocaldeclarationContext)_localctx).type.retType));

			        decls.add(((LocaldeclarationContext)_localctx).identVar.out);
			      
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(248);
				match(SEP);
				setState(249);
				((LocaldeclarationContext)_localctx).identVar = identVar(table, new ASD.PointerType(((LocaldeclarationContext)_localctx).type.retType));

				        decls.add(((LocaldeclarationContext)_localctx).identVar.out);
				      
				}
				}
				setState(256);
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

	public static class IdentVarContext extends ParserRuleContext {
		public SymbolTable table;
		public ASD.Type t;
		public ASD.Expression out;
		public String text;
		public IdentContext ident;
		public Token INTEGER;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode TO() { return getToken(VSLParser.TO, 0); }
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public TerminalNode TC() { return getToken(VSLParser.TC, 0); }
		public IdentVarContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IdentVarContext(ParserRuleContext parent, int invokingState, SymbolTable table, ASD.Type t) {
			super(parent, invokingState);
			this.table = table;
			this.t = t;
		}
		@Override public int getRuleIndex() { return RULE_identVar; }
	}

	public final IdentVarContext identVar(SymbolTable table,ASD.Type t) throws RecognitionException {
		IdentVarContext _localctx = new IdentVarContext(_ctx, getState(), table, t);
		enterRule(_localctx, 24, RULE_identVar);
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				((IdentVarContext)_localctx).ident = ident();

				      ASD.Variable var = new ASD.Variable(ASD.Variable.local_scope, _localctx.t, Utils.newtmp());
				      table.add(((IdentVarContext)_localctx).ident.text, new SymbolTable.VariableSymbol(var));
				      ((IdentVarContext)_localctx).text =  ((IdentVarContext)_localctx).ident.text;
				      ((IdentVarContext)_localctx).out =  new ASD.Instanciation(var);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				((IdentVarContext)_localctx).ident = ident();
				setState(263);
				match(TO);
				setState(264);
				((IdentVarContext)_localctx).INTEGER = match(INTEGER);
				setState(265);
				match(TC);

				      ASD.Variable array = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(new ASD.ArrayType(_localctx.t, (((IdentVarContext)_localctx).INTEGER!=null?Integer.valueOf(((IdentVarContext)_localctx).INTEGER.getText()):0) + "")), Utils.newtmp());
				      ((IdentVarContext)_localctx).out =  new ASD.Instanciation(array);
				      table.add(((IdentVarContext)_localctx).ident.text, new SymbolTable.VariableSymbol(array));
				    
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

	public static class ExpressionContext extends ParserRuleContext {
		public SymbolTable table;
		public ASD.Expression out;
		public ASD.Type retType;
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
		enterRule(_localctx, 26, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			((ExpressionContext)_localctx).l = multExpr(table);
			((ExpressionContext)_localctx).out =  ((ExpressionContext)_localctx).l.out; 
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(272);
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
				setState(273);
				((ExpressionContext)_localctx).r = multExpr(table);

				        ((ExpressionContext)_localctx).retType =  ((ExpressionContext)_localctx).l.retType;
				        ASD.Variable result = new ASD.Variable(ASD.Variable.local_scope, _localctx.retType, Utils.newtmp());
				        switch(((ExpressionContext)_localctx).op.getType()) {
				        case ADD :
				          ((ExpressionContext)_localctx).out =  new ASD.AddExpression(result, _localctx.out, ((ExpressionContext)_localctx).r.out);
				          break;
				        case SUB :
				          ((ExpressionContext)_localctx).out =  new ASD.SubExpression(result, _localctx.out, ((ExpressionContext)_localctx).r.out);
				          break;
				        }
				      
				}
				}
				setState(280);
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
		public ASD.Type retType;
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
		enterRule(_localctx, 28, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			((MultExprContext)_localctx).l = atome(table);

			        ((MultExprContext)_localctx).out =  ((MultExprContext)_localctx).l.out; ((MultExprContext)_localctx).retType =  ((MultExprContext)_localctx).l.retType;
			      
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==SDIV) {
				{
				{
				setState(283);
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
				setState(284);
				((MultExprContext)_localctx).r = atome(table);

				        ASD.Variable result = new ASD.Variable(ASD.Variable.local_scope, _localctx.retType, Utils.newtmp());
				        switch(((MultExprContext)_localctx).op.getType()) {
				        case MUL :
				          ((MultExprContext)_localctx).out =  new ASD.MulExpression(result, _localctx.out, ((MultExprContext)_localctx).r.out);
				          break;
				        case SDIV :
				          ((MultExprContext)_localctx).out =  new ASD.SignedDivExpression(result, _localctx.out, ((MultExprContext)_localctx).r.out);
				          break;
				        }
				      
				}
				}
				setState(291);
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
		public ASD.Type retType;
		public TerminalNode INT_TYPE() { return getToken(VSLParser.INT_TYPE, 0); }
		public TerminalNode VOID_TYPE() { return getToken(VSLParser.VOID_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		try {
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(INT_TYPE);

				      ((TypeContext)_localctx).retType =  new ASD.IntType();
				    
				}
				break;
			case VOID_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(VOID_TYPE);

				      ((TypeContext)_localctx).retType =  new ASD.VoidType();
				    
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
		enterRule(_localctx, 32, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
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
		enterRule(_localctx, 34, RULE_args);

		    ArrayList<ASD.Expression> exprs = new ArrayList<ASD.Expression>();
		    SymbolTable t = new SymbolTable();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(301);
				((ArgsContext)_localctx).expression = expression(table);

				      exprs.add(((ArgsContext)_localctx).expression.out);
				    
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(303);
					match(SEP);
					setState(304);
					((ArgsContext)_localctx).p = ((ArgsContext)_localctx).expression = expression(table);

					      exprs.add(((ArgsContext)_localctx).p.out);
					    
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}

			      ((ArgsContext)_localctx).out =  exprs;
			      ((ArgsContext)_localctx).arguments =  t;
			    
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
		public ASD.Type retType;
		public ExpressionContext expression;
		public IdentContext ident;
		public ArgsContext args;
		public Token INTEGER;
		public Token TEXT;
		public TerminalNode PO() { return getToken(VSLParser.PO, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PF() { return getToken(VSLParser.PF, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode TO() { return getToken(VSLParser.TO, 0); }
		public TerminalNode TC() { return getToken(VSLParser.TC, 0); }
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
		enterRule(_localctx, 36, RULE_atome);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				match(PO);
				setState(317);
				((AtomeContext)_localctx).expression = expression(table);
				setState(318);
				match(PF);

				        ((AtomeContext)_localctx).out =  ((AtomeContext)_localctx).expression.out;
				        ((AtomeContext)_localctx).retType =  ((AtomeContext)_localctx).expression.retType;
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				((AtomeContext)_localctx).ident = ident();

				          SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup(((AtomeContext)_localctx).ident.text);
				          if(s == null) { throw new SymbolException("Cannot find symbol " + ((AtomeContext)_localctx).ident.text); }
				          if(((ASD.PointerType) s.variable.type).type instanceof ASD.ArrayType) {
				            ASD.ArrayElement ptr = new ASD.ArrayElement(s.variable, new ASD.IntegerExpression(0));
				            ((AtomeContext)_localctx).out =  ptr;
				            ((AtomeContext)_localctx).retType =  ptr.getResult().type;
				          } else {
				            ASD.Value v = new ASD.Value(s.variable);
				            ((AtomeContext)_localctx).out =  v;
				            ((AtomeContext)_localctx).retType =  v.getResult().type;
				          }
				      
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(324);
				((AtomeContext)_localctx).ident = ident();
				setState(325);
				match(TO);
				setState(326);
				((AtomeContext)_localctx).expression = expression(table);
				setState(327);
				match(TC);

				        SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup(((AtomeContext)_localctx).ident.text);
				        if(s == null) { throw new SymbolException("Cannot find symbol " + ((AtomeContext)_localctx).ident.text); }
				        ASD.ArrayElement ptr = new ASD.ArrayElement(s.variable, ((AtomeContext)_localctx).expression.out);
				        if(ptr.getResult().type instanceof ASD.PointerType) {
				          ASD.ArrayValue v = new ASD.ArrayValue(ptr);
				          ((AtomeContext)_localctx).out =  v;
				          ((AtomeContext)_localctx).retType =  v.getResult().type;
				        } else {
				          ((AtomeContext)_localctx).out =  ptr;
				          ((AtomeContext)_localctx).retType =  ptr.getResult().type;
				        }
				      
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(330);
				((AtomeContext)_localctx).ident = ident();
				setState(331);
				match(PO);
				setState(332);
				((AtomeContext)_localctx).args = args(table);
				setState(333);
				match(PF);

				        SymbolTable.FunctionSymbol s = (SymbolTable.FunctionSymbol) table.lookup(((AtomeContext)_localctx).ident.text);
				        if(s == null) { throw new SymbolException("Cannot find symbol " + ((AtomeContext)_localctx).ident.text); }
				        ASD.CallFonction r = new ASD.CallFonction(s.variable, ((AtomeContext)_localctx).args.out);
				        ((AtomeContext)_localctx).retType =  r.getResult().type;
				        ((AtomeContext)_localctx).out =  r;
				      
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(336);
				((AtomeContext)_localctx).INTEGER = match(INTEGER);

				        ((AtomeContext)_localctx).retType =  new ASD.IntType();
				        ((AtomeContext)_localctx).out =  new ASD.IntegerExpression((((AtomeContext)_localctx).INTEGER!=null?Integer.valueOf(((AtomeContext)_localctx).INTEGER.getText()):0));
				      
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(338);
				((AtomeContext)_localctx).TEXT = match(TEXT);

				        ((AtomeContext)_localctx).retType =  new ASD.CharType();
				        ((AtomeContext)_localctx).out =  new ASD.StringConstant(((AtomeContext)_localctx).TEXT.getText());
				      
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0159\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3G\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4O\n\4\f\4\16\4R\13\4\5\4T\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5h\n\5\3\6\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6x\n\6\3\7\3\7\3\7\3\7\7\7~\n\7\f\7\16\7\u0081\13\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u008f\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\7\t\u00aa\n\t\f\t\16\t\u00ad\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ce\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u00d8\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00e6\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00f6\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ff\n\r\f\r\16"+
		"\r\u0102\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u010f\n\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0117\n\17\f\17\16\17\u011a"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0122\n\20\f\20\16\20\u0125"+
		"\13\20\3\21\3\21\3\21\3\21\5\21\u012b\n\21\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\7\23\u0136\n\23\f\23\16\23\u0139\13\23\5\23\u013b\n"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0157"+
		"\n\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\4\3\2"+
		"!\"\3\2#$\2\u016d\2-\3\2\2\2\4F\3\2\2\2\6S\3\2\2\2\bg\3\2\2\2\nw\3\2\2"+
		"\2\fy\3\2\2\2\16\u008e\3\2\2\2\20\u00cd\3\2\2\2\22\u00d7\3\2\2\2\24\u00e5"+
		"\3\2\2\2\26\u00f5\3\2\2\2\30\u00f7\3\2\2\2\32\u010e\3\2\2\2\34\u0110\3"+
		"\2\2\2\36\u011b\3\2\2\2 \u012a\3\2\2\2\"\u012c\3\2\2\2$\u013a\3\2\2\2"+
		"&\u0156\3\2\2\2()\5\4\3\2)*\b\2\1\2*,\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3"+
		"\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\2\2\3\61\62\b\2\1\2\62"+
		"\3\3\2\2\2\63\64\7\25\2\2\64\65\5 \21\2\65\66\5\"\22\2\66\67\b\3\1\2\67"+
		"8\7\5\2\289\5\6\4\29:\7\6\2\2:;\b\3\1\2;<\5\n\6\2<=\b\3\1\2=G\3\2\2\2"+
		">?\7\26\2\2?@\5 \21\2@A\5\"\22\2AB\7\5\2\2BC\5\6\4\2CD\7\6\2\2DE\b\3\1"+
		"\2EG\3\2\2\2F\63\3\2\2\2F>\3\2\2\2G\5\3\2\2\2HI\5\b\5\2IP\b\4\1\2JK\7"+
		"\13\2\2KL\5\b\5\2LM\b\4\1\2MO\3\2\2\2NJ\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ"+
		"\3\2\2\2QT\3\2\2\2RP\3\2\2\2SH\3\2\2\2ST\3\2\2\2T\7\3\2\2\2UV\5\"\22\2"+
		"VW\b\5\1\2Wh\3\2\2\2XY\5 \21\2YZ\5\"\22\2Z[\b\5\1\2[h\3\2\2\2\\]\5\"\22"+
		"\2]^\7\7\2\2^_\7\b\2\2_`\b\5\1\2`h\3\2\2\2ab\5 \21\2bc\5\"\22\2cd\7\7"+
		"\2\2de\7\b\2\2ef\b\5\1\2fh\3\2\2\2gU\3\2\2\2gX\3\2\2\2g\\\3\2\2\2ga\3"+
		"\2\2\2h\t\3\2\2\2io\7\t\2\2jk\5\20\t\2kl\b\6\1\2ln\3\2\2\2mj\3\2\2\2n"+
		"q\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\n\2\2sx\b\6\1\2"+
		"tu\5\20\t\2uv\b\6\1\2vx\3\2\2\2wi\3\2\2\2wt\3\2\2\2x\13\3\2\2\2y\177\7"+
		"\t\2\2z{\5\20\t\2{|\b\7\1\2|~\3\2\2\2}z\3\2\2\2~\u0081\3\2\2\2\177}\3"+
		"\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083"+
		"\7\n\2\2\u0083\u0084\b\7\1\2\u0084\r\3\2\2\2\u0085\u0086\5\"\22\2\u0086"+
		"\u0087\b\b\1\2\u0087\u008f\3\2\2\2\u0088\u0089\5\"\22\2\u0089\u008a\7"+
		"\7\2\2\u008a\u008b\5\34\17\2\u008b\u008c\7\b\2\2\u008c\u008d\b\b\1\2\u008d"+
		"\u008f\3\2\2\2\u008e\u0085\3\2\2\2\u008e\u0088\3\2\2\2\u008f\17\3\2\2"+
		"\2\u0090\u0091\5\"\22\2\u0091\u0092\7\5\2\2\u0092\u0093\5$\23\2\u0093"+
		"\u0094\7\6\2\2\u0094\u0095\b\t\1\2\u0095\u00ce\3\2\2\2\u0096\u0097\5\f"+
		"\7\2\u0097\u0098\b\t\1\2\u0098\u00ce\3\2\2\2\u0099\u009a\7\31\2\2\u009a"+
		"\u009b\5\34\17\2\u009b\u009c\b\t\1\2\u009c\u00ce\3\2\2\2\u009d\u009e\7"+
		"\r\2\2\u009e\u009f\5$\23\2\u009f\u00a0\b\t\1\2\u00a0\u00ce\3\2\2\2\u00a1"+
		"\u00a2\7\16\2\2\u00a2\u00a3\b\t\1\2\u00a3\u00a4\5\16\b\2\u00a4\u00ab\b"+
		"\t\1\2\u00a5\u00a6\7\13\2\2\u00a6\u00a7\5\16\b\2\u00a7\u00a8\b\t\1\2\u00a8"+
		"\u00aa\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00af\b\t\1\2\u00af\u00ce\3\2\2\2\u00b0\u00b1\5\30\r\2\u00b1\u00b2\b"+
		"\t\1\2\u00b2\u00ce\3\2\2\2\u00b3\u00b4\5\26\f\2\u00b4\u00b5\b\t\1\2\u00b5"+
		"\u00ce\3\2\2\2\u00b6\u00b7\7\32\2\2\u00b7\u00b8\5\22\n\2\u00b8\u00b9\7"+
		"\33\2\2\u00b9\u00ba\5\n\6\2\u00ba\u00bb\7\35\2\2\u00bb\u00bc\b\t\1\2\u00bc"+
		"\u00ce\3\2\2\2\u00bd\u00be\7\32\2\2\u00be\u00bf\5\22\n\2\u00bf\u00c0\7"+
		"\33\2\2\u00c0\u00c1\5\n\6\2\u00c1\u00c2\7\34\2\2\u00c2\u00c3\5\n\6\2\u00c3"+
		"\u00c4\7\35\2\2\u00c4\u00c5\b\t\1\2\u00c5\u00ce\3\2\2\2\u00c6\u00c7\7"+
		"\36\2\2\u00c7\u00c8\5\22\n\2\u00c8\u00c9\7\37\2\2\u00c9\u00ca\5\n\6\2"+
		"\u00ca\u00cb\7 \2\2\u00cb\u00cc\b\t\1\2\u00cc\u00ce\3\2\2\2\u00cd\u0090"+
		"\3\2\2\2\u00cd\u0096\3\2\2\2\u00cd\u0099\3\2\2\2\u00cd\u009d\3\2\2\2\u00cd"+
		"\u00a1\3\2\2\2\u00cd\u00b0\3\2\2\2\u00cd\u00b3\3\2\2\2\u00cd\u00b6\3\2"+
		"\2\2\u00cd\u00bd\3\2\2\2\u00cd\u00c6\3\2\2\2\u00ce\21\3\2\2\2\u00cf\u00d0"+
		"\5\34\17\2\u00d0\u00d1\b\n\1\2\u00d1\u00d8\3\2\2\2\u00d2\u00d3\5\34\17"+
		"\2\u00d3\u00d4\5\24\13\2\u00d4\u00d5\5\34\17\2\u00d5\u00d6\b\n\1\2\u00d6"+
		"\u00d8\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d8\23\3\2\2"+
		"\2\u00d9\u00da\7\17\2\2\u00da\u00e6\b\13\1\2\u00db\u00dc\7\20\2\2\u00dc"+
		"\u00e6\b\13\1\2\u00dd\u00de\7\21\2\2\u00de\u00e6\b\13\1\2\u00df\u00e0"+
		"\7\22\2\2\u00e0\u00e6\b\13\1\2\u00e1\u00e2\7\23\2\2\u00e2\u00e6\b\13\1"+
		"\2\u00e3\u00e4\7\24\2\2\u00e4\u00e6\b\13\1\2\u00e5\u00d9\3\2\2\2\u00e5"+
		"\u00db\3\2\2\2\u00e5\u00dd\3\2\2\2\u00e5\u00df\3\2\2\2\u00e5\u00e1\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e6\25\3\2\2\2\u00e7\u00e8\5\"\22\2\u00e8\u00e9"+
		"\7\f\2\2\u00e9\u00ea\5\34\17\2\u00ea\u00eb\b\f\1\2\u00eb\u00f6\3\2\2\2"+
		"\u00ec\u00ed\5\"\22\2\u00ed\u00ee\7\7\2\2\u00ee\u00ef\5\34\17\2\u00ef"+
		"\u00f0\7\b\2\2\u00f0\u00f1\b\f\1\2\u00f1\u00f2\7\f\2\2\u00f2\u00f3\5\34"+
		"\17\2\u00f3\u00f4\b\f\1\2\u00f4\u00f6\3\2\2\2\u00f5\u00e7\3\2\2\2\u00f5"+
		"\u00ec\3\2\2\2\u00f6\27\3\2\2\2\u00f7\u00f8\5 \21\2\u00f8\u00f9\5\32\16"+
		"\2\u00f9\u0100\b\r\1\2\u00fa\u00fb\7\13\2\2\u00fb\u00fc\5\32\16\2\u00fc"+
		"\u00fd\b\r\1\2\u00fd\u00ff\3\2\2\2\u00fe\u00fa\3\2\2\2\u00ff\u0102\3\2"+
		"\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0104\b\r\1\2\u0104\31\3\2\2\2\u0105\u0106\5\"\22"+
		"\2\u0106\u0107\b\16\1\2\u0107\u010f\3\2\2\2\u0108\u0109\5\"\22\2\u0109"+
		"\u010a\7\7\2\2\u010a\u010b\7\'\2\2\u010b\u010c\7\b\2\2\u010c\u010d\b\16"+
		"\1\2\u010d\u010f\3\2\2\2\u010e\u0105\3\2\2\2\u010e\u0108\3\2\2\2\u010f"+
		"\33\3\2\2\2\u0110\u0111\5\36\20\2\u0111\u0118\b\17\1\2\u0112\u0113\t\2"+
		"\2\2\u0113\u0114\5\36\20\2\u0114\u0115\b\17\1\2\u0115\u0117\3\2\2\2\u0116"+
		"\u0112\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119\35\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\5&\24\2\u011c\u0123"+
		"\b\20\1\2\u011d\u011e\t\3\2\2\u011e\u011f\5&\24\2\u011f\u0120\b\20\1\2"+
		"\u0120\u0122\3\2\2\2\u0121\u011d\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\37\3\2\2\2\u0125\u0123\3\2\2\2\u0126"+
		"\u0127\7\30\2\2\u0127\u012b\b\21\1\2\u0128\u0129\7\27\2\2\u0129\u012b"+
		"\b\21\1\2\u012a\u0126\3\2\2\2\u012a\u0128\3\2\2\2\u012b!\3\2\2\2\u012c"+
		"\u012d\7%\2\2\u012d\u012e\b\22\1\2\u012e#\3\2\2\2\u012f\u0130\5\34\17"+
		"\2\u0130\u0137\b\23\1\2\u0131\u0132\7\13\2\2\u0132\u0133\5\34\17\2\u0133"+
		"\u0134\b\23\1\2\u0134\u0136\3\2\2\2\u0135\u0131\3\2\2\2\u0136\u0139\3"+
		"\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013b\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u013a\u012f\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013d\b\23\1\2\u013d%\3\2\2\2\u013e\u013f\7\5\2\2\u013f\u0140"+
		"\5\34\17\2\u0140\u0141\7\6\2\2\u0141\u0142\b\24\1\2\u0142\u0157\3\2\2"+
		"\2\u0143\u0144\5\"\22\2\u0144\u0145\b\24\1\2\u0145\u0157\3\2\2\2\u0146"+
		"\u0147\5\"\22\2\u0147\u0148\7\7\2\2\u0148\u0149\5\34\17\2\u0149\u014a"+
		"\7\b\2\2\u014a\u014b\b\24\1\2\u014b\u0157\3\2\2\2\u014c\u014d\5\"\22\2"+
		"\u014d\u014e\7\5\2\2\u014e\u014f\5$\23\2\u014f\u0150\7\6\2\2\u0150\u0151"+
		"\b\24\1\2\u0151\u0157\3\2\2\2\u0152\u0153\7\'\2\2\u0153\u0157\b\24\1\2"+
		"\u0154\u0155\7&\2\2\u0155\u0157\b\24\1\2\u0156\u013e\3\2\2\2\u0156\u0143"+
		"\3\2\2\2\u0156\u0146\3\2\2\2\u0156\u014c\3\2\2\2\u0156\u0152\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0157\'\3\2\2\2\30-FPSgow\177\u008e\u00ab\u00cd\u00d7\u00e5"+
		"\u00f5\u0100\u010e\u0118\u0123\u012a\u0137\u013a\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}