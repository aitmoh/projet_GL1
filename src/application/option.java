package application;

public enum option {
	Medecin,Secretariat; // les options pour le combobox dans la premi�re fen�tre
	private option() {}
	
	public String value() {
		return name();
		}
	
	public static option fromvalue(String v) {
		return valueOf(v);
	}

}
