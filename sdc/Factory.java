package sdc;

import java.lang.reflect.*;
import java.util.ArrayList;

import Exception.InternalError;
import Symbol.Symbol; 

public class Factory {

	private ArrayList<String> list;

	public Factory() {
		this.list = new ArrayList<String>();

		// add all types or operation here
		this.list.add("Value.IntegerValue");
		this.list.add("Value.RationnalValue");
		this.list.add("Value.AffectValue");
		this.list.add("Value.BooleanValue");
		
		this.list.add("Symbol.ViewSymbol");
		this.list.add("Symbol.QuitSymbol");
		this.list.add("Symbol.ClearSymbol");
		this.list.add("Symbol.IfSymbol");
		this.list.add("Symbol.ElseSymbol");
		this.list.add("Symbol.EndifSymbol");		
		
		this.list.add("Operation.AddOperation");
		this.list.add("Operation.SubOperation");
		this.list.add("Operation.DivOperation");
		this.list.add("Operation.MulOperation");
		this.list.add("Operation.AbsOperation");
		this.list.add("Operation.EtLogique"); 
		this.list.add("Operation.OuLogique"); 
		this.list.add("Operation.NegLogique"); 
		this.list.add("Operation.SuperiorOperation"); 
		this.list.add("Operation.InferiorOperation");
		this.list.add("Operation.EqualityOperation");
		
		
	}

	public Symbol[] registered() throws InternalError {
		ArrayList<Symbol> s = new ArrayList<Symbol>();

		for (String objectName : this.list) {
			s.add(this.createInstance(objectName));
		}

		return s.toArray(new Symbol[this.list.size()]);
	}

	private Symbol createInstance(String className) throws InternalError {
		try {
			Class<?> cl = Class.forName(className);
			Constructor<?> co = cl.getConstructor();
			return (Symbol) co.newInstance();
		} catch (Exception e) {
			e.printStackTrace();

			throw new InternalError();
		}
	}

}
