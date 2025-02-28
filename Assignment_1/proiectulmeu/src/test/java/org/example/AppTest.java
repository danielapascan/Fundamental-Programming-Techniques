package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import operatii.Functii;
import model.Polinom;

public class AppTest extends TestCase
{

    public void initializare(Functii f, Polinom p1, Polinom p2)
    {
        String s1= new String("2x^3+1x^2-4x-2");
        String s2= new String("1x+2");
        p1.facePolinom2(s1);
        p2.facePolinom2(s2);
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testAppAdunare()
    {
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        Functii f= new Functii();
        initializare(f,p1,p2);
        Polinom result= new Polinom();
        result=f.adunaPolinoame(p1,p2);
        assertEquals("-3.0x +1.0x^2 +2.0x^3 ",f.afisarePolinom(result));
    }

    public void testAppScadere()
    {
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        Functii f= new Functii();
        initializare(f,p1,p2);
        Polinom result= new Polinom();
        result=f.scadePolinoame(p1,p2);
        assertEquals("-4.0 -5.0x +1.0x^2 +2.0x^3 ",f.afisarePolinom(result));
    }

    public void testAppInmultire()
    {
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        Functii f= new Functii();
        initializare(f,p1,p2);
        Polinom result= new Polinom();
        result=f.inmultestePolinoame(p1,p2);
        assertEquals("-4.0 -10.0x -2.0x^2 +5.0x^3 +2.0x^4 ",f.afisarePolinom(result));
    }

    public void testAppImpartire()
    {
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        Functii f= new Functii();
        initializare(f,p1,p2);
        //String result= new String();
        //result=f.impartirePolinom(p1,p2);
        assertEquals("cat: +2.0 -3.0x +2.0x^2  rest: -6.0 ",f.impartirePolinom(p1,p2));
    }

    public void testAppDerivare()
    {
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        Functii f= new Functii();
        initializare(f,p1,p2);
        Polinom result1= new Polinom();
        result1=f.derivarePolinom(p1);
        assertEquals("-4.0 +2.0x +6.0x^2 ",f.afisarePolinom(result1));
    }

    public void testAppIntegrare()
    {
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        Functii f= new Functii();
        initializare(f,p1,p2);
        Polinom result1= new Polinom();
        result1=f.derivarePolinom(p1);
        assertEquals("-4.0 +2.0x +6.0x^2 ",f.afisarePolinom(result1));
    }

    public void testAppIntegrareGresit() {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Functii f = new Functii();
        initializare(f, p1, p2);
        Polinom result1 = new Polinom();
        result1 = f.derivarePolinom(p1);
        assertEquals("-4.0 +2.0g +6.0x^2 ", f.afisarePolinom(result1));
    }

    public void testAppImpartireGresit()
    {
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        Functii f= new Functii();
        initializare(f,p1,p2);
        assertEquals("cat: +2.0 -3.0x +2.0x^2 ",f.impartirePolinom(p1,p2));
    }
}
