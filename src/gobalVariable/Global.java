package gobalVariable;

public enum Global {
	LOGOPATH ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqCosUL5iACTRqWclFw94mTDS38dR1l9ZS4yYeATRS7TDDSehsuw");
	
	private String path ="";
	
	Global(String path){
		this.path = path;
	}
	
	public String toString() {
		return path;
	}
}
