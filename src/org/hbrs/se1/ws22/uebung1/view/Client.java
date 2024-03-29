package org.hbrs.se1.ws22.uebung1.view;
import org.hbrs.se1.ws22.uebung1.control.Translator;
import org.hbrs.se1.ws22.uebung1.control.Factory;

public class Client {


		/*
		 * Methode zur Ausgabe einer Zahl auf der Console (auch bezeichnet als CLI, Terminal)
		 */
		public void display( int aNumber ){
			// In dieser Methode soll die Methode translateNumber
			// mit dem übergegebenen Wert der Variable aNumber
			// aufgerufen werden.
			//
			// Strenge Implementierung gegen das Interface Translator gewuenscht! -> Variablen an Interfacetyp binden

			Translator translator = Factory.createTranslator();
			String result = translator.translateNumber(aNumber);

			System.out.println("Das Ergebnis der Berechnung: " +
					"[das Ergebnis an dieser Stelle]" + result);

		}
}





