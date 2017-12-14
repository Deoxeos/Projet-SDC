package sdc;

public class AffectValue extends Value {

	private String value;

	public AffectValue() {
		this.value = ""; 
	}
	
	public AffectValue(String s) {
		this.value = s; 
	}
	
	@Override
	public boolean parse(String s)  {
		if (s.equals("=>")) {
			this.value = s;

			return true;
		}
		else {
			try {
				throw new SymbolNotFoundException("Error constructor.");
			} catch (SymbolNotFoundException e) {
				return false; 
			} 
		}
		
	}

	public String toString() {
		return this.value;
	}

}
