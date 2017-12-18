package sdc;

import java.lang.reflect.*;
import java.util.ArrayList;

public class Factory {

	private ArrayList<String> list;

	public Factory() {
		this.list = new ArrayList<String>();

		// add all types or operation here
		this.list.add("IntegerValue");
		this.list.add("RationnalValue");
		this.list.add("AffectValue");

		this.list.add("View");
		
		this.list.add("QuitSymbol");
		this.list.add("ClearSymbol");

		this.list.add("AddOperation");
		this.list.add("SubOperation");
		this.list.add("DivOperation");
		this.list.add("MulOperation");
		this.list.add("AbsOperation");
	
		this.list.add("EtLogique"); 
		this.list.add("OuLogique"); 
		this.list.add("NegLogique"); 
		
		this.list.add("SuperiorOperation"); 
		this.list.add("InferiorOperation");
		this.list.add("EqualityOperation");
		
		
	}

	public Symbol[] registered() throws InternalError {
		ArrayList<Symbol> s = new ArrayList<Symbol>();

		for (String objectName : this.list) {
			objectName = "sdc." + objectName;
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
