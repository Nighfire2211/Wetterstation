

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The type Wetterstation.
 */
public class Wetterstation
{
  /*
        private Variablen 
   */
    private int temperatur;
    /**
     * The Temperatur.
     */
    ArrayList<Integer> Temperatur = new ArrayList<Integer>();
    private static int tag=0;

    /**
     * Instantiates a new Wetterstation.
     */
    public Wetterstation()
    {

    }

    /**
     * Gets temperatur.
     *
     * @return the temperatur
     */
    public int getTemperatur() {
        return temperatur;
    }

    /**
     * Sets temperatur.
     *
     * @param temperatur the temperatur
     */
    public void setTemperatur(int temperatur) {
        this.temperatur = temperatur;
    }

    /**
     * Add.
     *
     * @param t the t
     */
    public void add(int t)
    {
        setTemperatur(t);
        Temperatur.add(t);
        tag++;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size()
    {
        return Temperatur.size();
    }

    /**
     * Sum int.
     *
     * @return the int
     */
    public  int sum() {
        int sum = 0;
        for (int i: Temperatur) {
            sum += i;
        }
        return sum;
    }

    /**
     * Durchschnitt.
     */
    public void durchschnitt()
    {
        int durchschnitt = sum()/size();
        System.out.println("Tage: "+tag);
        System.out.println("Durschnittstemperatur von allen Tagen zusammen:" + durchschnitt);
    }

    /**
     * Max.
     */
    public void max()
    {
        System.out.println( "Maximale Temperatur: " + Collections.max(Temperatur));

    }

    /**
     * Min.
     */
    public void min()
    {
        System.out.println( "Maximale Temperatur: " + Collections.min(Temperatur));

    }

    /**
     * Liste.
     */
    public void liste()
    {
        Iterator<Integer>iter = Temperatur.iterator();

        System.out.println("Liste von Temperaturen: ");
        while(iter.hasNext())
        {
            System.out.println(tag+" :"+" "+iter.next()+" ");
        }
    }

    /**
     * Wetter int.
     *
     * @return the int
     */
    public int Wetter()
    {
        Wetterstation wetter = new Wetterstation();
        int wahl = 0;
        int weiter =0;
        Scanner sc = new Scanner(System.in);
        do
        {   System.out.println("Wetterstation");
            System.out.println("**********************************");
            System.out.println("Diese Wetterstation gibt die Temperaturen sowie den Durchschnitt, Maximale und das Minimale der Temperaturen aus");
            System.out.println("**********************************");
            System.out.println("");
            do {
                System.out.println("1.Temperatur hinzufügen");
                System.out.println("2.Durchschnitt berechnen");
                System.out.println("3.Maximale und Minimale Temperatur anzeigen");
                System.out.println("4. Liste zeigen");

                wahl = sc.nextInt();
                if (wahl == 1 || wahl == 2 || wahl == 3 || wahl ==4)
                {
                    break;
                }
                else
                {
                    System.out.println("Ungültige Eingabe");
                }
            }while(wahl != 1 || wahl !=2 || wahl!=3);

          switch(wahl)
          {
              case 1:
              {
                  int temp;
                  System.out.println("Geben Sie eine Temperatur ein: ");
                  temp =sc.nextInt();
                  wetter.add(temp);

              }
              break;

              case 2:
              {
                  try {
                      wetter.durchschnitt();
                  }catch (java.lang.ArithmeticException e)
                  {
                      System.out.println("Keine Temperaturen in der Liste");
                      break;
                  }
              }
              break;

              case 3:
              {
                  wetter.max();
                  wetter.min();
              }
              break;

              case 4:
              {
                  if(wetter.size()==0)
                  {
                      System.out.println("Keine Temperaturen angegeben");
                  }
                  else {
                      wetter.liste();
                  }

              }
              break;
          }
        System.out.println("Möchten Sie weiter machen? 1-> Ja; Irgend eine Nummer -> Nein");
                weiter=sc.nextInt();
                if(weiter !=1 )
                {
                    System.out.println("Bye");
                    break;

                }
        }while(weiter==1);

        return wahl;
    }
}
