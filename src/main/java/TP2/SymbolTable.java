package TP2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

	public static abstract class Symbol {
		ASD.Variable variable;

		public Symbol(ASD.Variable variable) {
			this.variable = variable;
		}
	}

	public static class VariableSymbol extends Symbol {

		VariableSymbol(ASD.Variable variable) {
			super(variable);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			if (!(obj instanceof VariableSymbol))
				return false;
			VariableSymbol o = (VariableSymbol) obj;
			return this.variable.equals(o.variable);
		}
		
		public String toString() {
			return this.variable.toString();
		}
	}

	public static class FunctionSymbol extends Symbol {
		
		SymbolTable arguments;
		boolean defined;
		
		FunctionSymbol(ASD.Variable variable, SymbolTable arguments, boolean defined) {
			super(variable);
			this.arguments = arguments;
			this.defined = defined;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == null) return false;
		      if(obj == this) return true;
		      if(!(obj instanceof FunctionSymbol)) return false;
		      FunctionSymbol o = (FunctionSymbol) obj;
		      return o.variable.equals(super.variable) &&
		        o.arguments.equals(this.arguments);
		}
		
		public String toString() {
			StringBuilder ret = new StringBuilder(this.variable + "\n");
			for(String s : this.arguments.table.keySet()) {
				ret.append(".." + s + " > " + this.arguments.table.get(s) + "\n");
			}
			
			return ret.toString();
		}
	}

	private Map<String, Symbol> table;
	private SymbolTable parent;

	public SymbolTable() {
		this.table = new HashMap<String, Symbol>();
		this.parent = null;
	}

	public SymbolTable(SymbolTable parent) {
		this.table = new HashMap<String, Symbol>();
		this.parent = parent;
	}

	public boolean add(String ident, Symbol sym) {
		Symbol res = this.table.get(ident);
		if (res != null) {
			return false;
		}

		this.table.put(ident, sym);
		return true;
	}

	public boolean remove(String ident) {
		return this.table.remove(ident) != null;
	}

	public Symbol lookup(String ident) {
		Symbol res = this.table.get(ident);

		if ((res == null) && (this.parent != null)) {
			return this.parent.lookup(ident);
		}

		return res;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder("to > ");
		for (String s : this.table.keySet()) {
			ret.append(s + ", ");
		}

		if (this.parent != null) {
			ret.append("\n" + 1 + "tp > " + this.parent.toString());
		}

		return ret.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof SymbolTable))
			return false;
		SymbolTable o = (SymbolTable) obj;
		
		List<ASD.Type> tt = new ArrayList<ASD.Type>();
		List<ASD.Type> to = new ArrayList<ASD.Type>();
		for(String s : this.table.keySet()) {
			tt.add(this.table.get(s).variable.type);
		}
		for(String s : o.table.keySet()) {
			to.add(o.table.get(s).variable.type);
		}
		if(!tt.equals(to)) {
			return false;
		}
		return 
				 ((o.parent == null && this.parent == null) || o.parent.equals(this.parent));
	}
}