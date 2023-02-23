package org.hbrs.se1.ws22.uebung10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyPrettyRectangleTest {

	private MyPrettyRectangle left;
	private MyPrettyRectangle middle;
	private MyPrettyRectangle right;
	private MyPrettyRectangle somewhere;

	/*
	 * Set-Up Methode ("BeforeEach"), die fuer alle Test-Methoden die Rechtecke gemaeß der Skizze definiert.
	 * Wird vor jeder Test-Methode ausgefuehrt.
	 *
	 */
	//
	@BeforeEach
	public void setUp() throws Exception {
		//
		//     +-----------+   +---+
		//     |         r |   | s |
		// +---+---+---+   |   |   |
		// | l |   | m |   |   |   |
		// |   |   +---+   |   |   |
		// |   |       |   |   |   |
		// +---+-------+   |   +---+
		//     |           |
		//     +-----------+
		//
		// Annahme: 1 Einheit = 1cm
		// MyPrettyRectangle-Konstruktor: MyPrettyRectangle(x1,y1,x2,y2)
		// x1,y1: Punkt links unten
		// x2,y2: Punkt rechts oben

		left = new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0); // l
		middle = new MyPrettyRectangle(2.0, 2.0, 3.0, 3.0); // m
		right = new MyPrettyRectangle(1.0, 0.0, 4.0, 4.0);  // r
		somewhere = new MyPrettyRectangle(5.0, 1.0, 6.0, 4.0); // s

	}

	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche prueft, ob ein Rechteck
	 * ein anderes Rechteck vollstaendig enthaelt. Bitte geben Sie einen vollständigen Test an!
	 * (Ergebnis: boolean Wert)
	 *
	 */
	@Test
	public void testContains() {
		// Erste Tests, um die Korrektheit der Methode contains() zu ueberpruefen
        assertTrue(  right.contains(middle) );
        assertTrue(  right.contains(right) );

        // Weitere hinzufügen für einen vollständigen Test
		assertTrue(  left.contains(middle) );
		assertTrue(  left.contains(left) );

		assertTrue(  somewhere.contains(somewhere) );


		//Negative Tests
		assertFalse(  left.contains(right) );
		assertFalse(  left.contains(somewhere) );
		assertFalse(  left.contains(right) );

		assertFalse(  middle.contains(right) );
		assertFalse(  middle.contains(somewhere) );
		assertFalse(  middle.contains(left));

		assertFalse(  right.contains(somewhere) );
		assertFalse(  right.contains(left) );

		assertFalse(  somewhere.contains(left) );
		assertFalse(  somewhere.contains(middle) );
		assertFalse(  somewhere.contains(right) );




	}

	/*
	 * Methode zum Testen einer Methode der Kasse MyPrettyRectangle, welche den Mittelpunkt eines Rechtecks berechnet
	 * (Ergebnis: ein Punkt in einem Koordinatensystem)
	 *
	 */
	@Test
	public void testGetCenter(){
		// Erster Test, um die Korrektheit der Methode getCenter() zu ueberpruefen
		//assertEquals( new MyPoint(1.5, 2.0), left.getCenter() ); // Falsch, da die Methode getCenter() einen neuen Punkt erzeugt

		// Hier sollten sie die weiteren Tests einfuegen, welche die errechneten Mittelpunkte der Rechtecke
		// right, middle und somewhere mit den tatsaechlichen Mittelpunkten vergleicht.
		// Die dazugehoerige Methode der Klasse MyPrettyRectangle sollten sie selbst implementieren.
		// Fuer einen korrekten Vergleich der MyPoint-Objekte sollten sie die Methode equals entsprechend ueberrschreiben
		// (siehe dazu auch Hinweise in Kapitel 7).
		//
		// [ihr Code]
		//Tatsächliche Mittelpunkte
		MyPoint leftCenter = new MyPoint(1.5, 2.0);
		MyPoint rightCenter = new MyPoint(2.5, 2.0);
		MyPoint middleCenter = new MyPoint(2.5, 2.5);
		MyPoint somewhereCenter = new MyPoint(5.5, 2.5);

		//Vergleich der Mittelpunkte
		assertTrue(leftCenter.equals(left.getCenter()));
		assertTrue(rightCenter.equals(right.getCenter()));
		assertTrue(middleCenter.equals(middle.getCenter()));
		assertTrue(somewhereCenter.equals(somewhere.getCenter()));

		//Negative Tests
		assertFalse(leftCenter.equals(right.getCenter()));
		assertFalse(leftCenter.equals(middle.getCenter()));
		assertFalse(leftCenter.equals(somewhere.getCenter()));



    }

	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche die Flaeche eines Rechtecks berechnet
	 * (Ergebnis: Wert in Quadratzentimeter, cm2)
	 *
	 */

	@Test
	public void testGetArea(){
		// Hier sollten sie weitere Tests einfuegen, welche die errechneten Flaechen der Rechtecke
		// mit den tatsaechlichen Werten vergleicht.
		// Die Methode zur Berechnung der Flaeche sollten sie selbst definieren und implementieren.
		// Bitte beruecksichtigen sie auch das erlaubte Delta zwischen expected und actual values.
		// Weitere Infos: http://stackoverflow.com/questions/7554281/junit-assertions-make-the-assertion-between-floats
        //
        // [ihr Code]
		//Tatsächliche Flächen
		double leftArea = 6.0;
		double rightArea = 12.0;
		double middleArea = 1.0;
		double somewhereArea = 3.0;

		//Vergleich der Flächen
		assertEquals(leftArea, left.getArea(), 0.0);
		assertEquals(rightArea, right.getArea(), 0.0);
		assertEquals(middleArea, middle.getArea(), 0.0);
		assertEquals(somewhereArea, somewhere.getArea(), 0.0);

	}



	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche den Umfang eines Rechtecks berechnet
	 * (Ergebnis: Wert in Zentimeter, cm)
	 *
	 */
	@Test
	public void testGetPerimeter(){

		// Hier sollten sie weitere Tests einfuegen, welche die errechneten Umfaenge der beiden Rechtecke
		// mit den tatsaechlichen Werten vergleicht.
		// Die Methode sollten sie zudem selbst definieren und implementieren.
		// Bitte beruecksichtigen sie auch das erlaubte Delta zwischen expected und actual values.
		// Weitere Infos: http://stackoverflow.com/questions/7554281/junit-assertions-make-the-assertion-between-floats
		//
        // [ihr Code]
		//Tatsächliche Umfänge
		double leftPerimeter = 10.0;
		double rightPerimeter = 14.0;
		double middlePerimeter = 4.0;
		double somewherePerimeter = 8.0;

		//Vergleich der Umfänge
		assertEquals(leftPerimeter, left.getPerimeter(), 0.0);
		assertEquals(rightPerimeter, right.getPerimeter(), 0.0);
		assertEquals(middlePerimeter, middle.getPerimeter(), 0.0);
		assertEquals(somewherePerimeter, somewhere.getPerimeter(), 0.0);


	}

	/*
	 * Methode zum Testen der Objekt-Identitaet zwischen den MyPrettyRectangle-Objekten
	 *
	 */
	@Test
	public void testSameIdentity() {
		// Hier sollten sie fuenf Tests einfuegen, welche die Objekt-Identitaet des linken Rechtecks ('left')
		// mit den anderen Rechtecken (inklusive dem neuen Rechteck 'other') ueberprueft. Bitte nur assertSame oder assertNotSame
		// verwenden!
		//

		MyPrettyRectangle other = left;
		// [ihr Code]
		//Vergleich der Objekt-Identität
		assertSame(left, other);
		assertSame(left, left);
		assertNotSame(left, right);
		assertNotSame(left, middle);
		assertNotSame(left, somewhere);


		// Bitte drei Assertions hinzufuegen, um die Gleichheit von Rechteck-Objekten zu ueberpruefen.
        // Bitte nur die Assertion assertTrue verwenden:
        //
        // [ihr Code]
		//Vergleich der Gleichheit


		assertTrue(left.equals(left));
		assertTrue(left.equals(other));
		assertFalse(left.equals(right));



		// Bitte drei weitere Assertions hinzufuegen, welce die Objekt-Identitaet des Rechtecks 'left' mit allen anderen
		// Rechtecken ueberprueft (inklusive other). Bitte hier nur die Assertions assertTrue und assertFalse verwenden.
        //
        // [ihr Code]
		//Vergleich der Objekt-Identität
		assertTrue(left == left);
		assertTrue(left == other);
		assertFalse(left == right);

	}

	/*
	 * Methode zum Testen einer statischen Methode einer weiteren Klasse BoundingBoxFactory, die auf Basis eines Arrays von
	 * Rechtecken eine Bounding Box berechnet und zurueckliefert.
	 *
	 * Definition Bounding Box: Eine Bounding Box (deutsch: minimal umgebendes Rechteck, MUR) bezeichnet das
	 * kleinstmoegliche achsenparallele Rechteck, das eine vorgegebene Menge von Rechtecken umschliesst.
	 *
	 */
	@Test
	public void testGetBoundingBox( ) {

		MyPrettyRectangle[] rect = { middle, right, somewhere };


		// Hier sollten sie einen Test einfuegen, der zunaechst mit der Klasse BoundingBoxFactory auf
		// Basis des o.g. Array die Bounding Box berechnet.
		// Testen sie die so erhaltene Bounding Box anhand eines SOLL / IST Vergleichs.
		// Die Methode der Klasse BoundingBoxFactory sollten sie selbst definieren und implementieren.
		//
		// [ihr Code]
		//Berechnung der Bounding Box
		MyPrettyRectangle[] test = new MyPrettyRectangle[10];
		MyPrettyRectangle boundingBox1 = BoundingBoxFactory.createBoundingBox(test);
		MyPrettyRectangle boundingBox = BoundingBoxFactory.createBoundingBox(rect);
		MyPrettyRectangle boundingBoxSoll = new MyPrettyRectangle(1.0, 0.0, 6.0, 4.0);
		System.out.println(boundingBox);
		assertTrue(boundingBoxSoll.getLeftBottom().equals(boundingBox.getLeftBottom()));
		assertTrue(boundingBoxSoll.getRightTop().equals(boundingBox.getRightTop()));



		// Testen sie zudem, ob ueberhaupt ein Objekt zurueckgegeben wird,
        // d.h. der Rueckgabe-Wert ungleich NULL ist
		//
		// [ihr Code]
		//Test auf NULL
		assertNotNull(boundingBox);

		// Test, ob die Übergabe eines leeren Arrays ein "Null-Rectangle" (Objekt mit vier mal die Koordinaten 0) zurueckliefert:
		//
		// [ihr Code]
        MyPrettyRectangle[] emptyRect = { };
        MyPrettyRectangle nBox = BoundingBoxFactory.createBoundingBox( emptyRect );
        MyPrettyRectangle zerroRect = new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0);
        assertTrue(zerroRect.getLeftBottom().equals(nBox.getLeftBottom()));
		assertTrue(zerroRect.getRightTop().equals(nBox.getRightTop()));


			
		// Test, ob die Übergabe eines NULL-Werts erfolgreich abgefangen wurde (Rueckgabe == NULL!)
		// 
		// [ihr Code]
		MyPrettyRectangle[] nullRect = null;
		MyPrettyRectangle nBox2 = BoundingBoxFactory.createBoundingBox( nullRect );
		assertNull(nBox2);

	}

}
