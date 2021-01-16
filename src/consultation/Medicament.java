package consultation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medicament {
	private StringProperty medicament;
	private StringProperty dosage;
	private StringProperty Dur�e ;
	
	public Medicament(String medicament, String dosage, String nombre) {
		super();
		this.medicament =  new SimpleStringProperty(medicament);
		this.dosage = new SimpleStringProperty(dosage);
		this.Dur�e = new SimpleStringProperty(nombre);
	
	}
	public String getMedicament() {
		return medicament.get();
	}
	public String getDosage() {
		return dosage.get();
	}
	public String getnombre() {
		return Dur�e.get();
	}
	public void setMedicament(String medicament) {
		 this.medicament.set(medicament);
	}
	public void setNombre(String Nombre) {
		this.Dur�e.set(Nombre);
	}
	public void setDosage(String dosage) {
		this.dosage.set(dosage);
	}
	public StringProperty medicamentProperty() {
		return this.medicament;
	}
	
	public StringProperty DosageProperty() {
		return this.dosage;
	}
	public StringProperty nombreProperty() {
		return this.Dur�e;
	}
	
	
	
	
	
}
