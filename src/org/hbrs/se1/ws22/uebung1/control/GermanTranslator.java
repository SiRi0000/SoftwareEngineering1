package org.hbrs.se1.ws22.uebung1.control;

public class GermanTranslator implements Translator {

	public String date = "Okt/2022"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]
		try {
			String[] array = new String[10];
			array[0] ="eins";
			array[1] ="zwei";
			array[2] ="drei";
			array[3] ="vier";
			array[4] ="fünf";
			array[5] ="sechs";
			array[6] ="sieben";
			array[7] ="acht";
			array[8] ="neun";
			array[9] ="zehn";

			return array[number-1];
		} catch (IndexOutOfBoundsException e){
			return "Übersetzung der Zahl "+number+" nicht möglich " + "("+Translator.version+")";
		}catch (IllegalArgumentException e){
			return "Eingabe ungültig. Bitte einen Integer eingeben!";
		}
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Okt/2022))
	 * Das Datum sollte system-intern durch eine Control-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
