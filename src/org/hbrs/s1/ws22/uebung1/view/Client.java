package org.hbrs.s1.ws22.uebung1.view;
import org.hbrs.s1.ws22.uebung1.control.Translator;
import org.hbrs.s1.ws22.uebung1.control.Creater;

public class Client {

		/*
		 * Methode zur Ausgabe einer Zahl auf der Console (auch bezeichnet als CLI, Terminal)
		 */
		public void display( int aNumber ){
			// In dieser Methode soll die Methode translateNumber
			// mit dem übergegebenen Wert der Variable aNumber
			// aufgerufen werden.
			//
			// Strenge Implementierung gegen das Interface Translator gewuenscht!

			Translator translator = Creater.createTranslator();
			translator.translateNumber(aNumber);

			System.out.println("Das Ergebnis der Berechnung: " +
					"[das Ergebnis an dieser Stelle]"  );

		}
}





