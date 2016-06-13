package projektwdsi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class ProjektWdSI {

  static List<Przedmiot> przedmioty = generuj();
  
    public static List<Przedmiot> generuj()
    {
            List<Przedmiot> przedmioty = new ArrayList<Przedmiot>();
            Random rnd = new Random();
            int l = rnd.nextInt(10000)+10;// dowolny przedzał
            for (int i = 0; i <l ; i++)
            {
               przedmioty.add(new Przedmiot(i,  rnd.nextInt( 100),(float)(rnd.nextInt(100000)+100) / 100 ));
                // dzielenie przez 100 floata -> powoduje przesunięie liczby o dwa miejsca po przecinku w prawo             
            }
            return przedmioty;
    }
    
    public static void wypisz_przedmioty()
    {
            przedmioty.stream().forEach((item) -> 
            {// stream() -> dzięki temu mozemy korzystać z biblioteki java 8, która zawiera funkcje jak foreach, map itd..
                System.out.println(item.ToString());
            });
            
            System.out.println(" ");
            System.out.println(
                    "ilosc przedmiotów: "+przedmioty.size()+
                    " łączna wartość: "+ (float)przedmioty.stream().mapToDouble(Przedmiot::getWartosc).sum()+// float -> obcina liczbe do dwóch miejsc po przecinku
                    " łączny rozmiar: " + przedmioty.stream().mapToDouble(Przedmiot::getRozmiar).sum());//mapTo -> mapowanie, wskazywanie, na czym będą wykonywane operacje
    }                                                                  // wskazuje klase, co biorę
    
    
     public static void zachlanie()// wybiera najpierw najdrozsze przedmioty do najtańszych wg fitness function poki sie mieszkcza w plecaku
    {// tablica musi być najpierw posortowana !!!!
            Plecak rozwiazanie = new Plecak();
            Collections.sort(przedmioty);//sortowanie tablicy przedmioty dla algorytmu zachlanny (od najdrozszego do najtanszego, )
            System.out.println("\rrowiazanie algorytmem zachlanym:\r");
            for (int i = 0; i < przedmioty.size(); i++)
            {
                if (rozwiazanie.addPrzedmiot(przedmioty.get(i)))// dodawanie przedmiotów do plecaka, jeżeli jest miejsce w plecaku
                {
                    System.out.println(przedmioty.get(i).ToString());
                }
                             
            }
            System.out.println(
                    "ilosc przedmiotów: "+rozwiazanie.zawartosc.size()+
                    " łączna wartość: "+ (float)rozwiazanie.zawartosc.stream().mapToDouble(Przedmiot::getWartosc).sum()+
                    " łączny rozmiar: " + rozwiazanie.zawartosc.stream().mapToInt(Przedmiot::getRozmiar).sum()+ 
                    " miejsce w plecaku " + Plecak.rozmiarPlecaka);
      }
    
    
    
        public static void main(String[] args)
        {
          Random rnd = new Random();
          Plecak.rozmiarPlecaka =  rnd.nextInt( 10000)+10;// wylosowana liczba okresla rozmiar plecaka
          //wypisz_przedmioty();
          zachlanie();
          System.exit(0);  
        }
        
}
