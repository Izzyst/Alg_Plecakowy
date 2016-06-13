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
            int l = rnd.nextInt(10000)+10;// 
            for (int i = 0; i <l ; i++)
            {
               przedmioty.add(new Przedmiot(i,  rnd.nextInt( 100),(float)(rnd.nextInt(100000)+100) / 100 ));
// dzielenie przez 100 -> zabezpieczenie przed wyjściem poza zakres              
            }
            return przedmioty;
        }
    
    public static void wypisz_przedmioty()
        {
            przedmioty.stream().forEach((item) -> {
                System.out.println(item.ToString());
        });
            
            System.out.println(" ");
            System.out.println(
                    "ilosc przedmiotów: "+przedmioty.size()+
                    " łączna wartość: "+ (float)przedmioty.stream().mapToDouble(Przedmiot::getWartosc).sum()+
                    " łączny rozmiar: " + przedmioty.stream().mapToDouble(Przedmiot::getRozmiar).sum());
        }
    public static void zachlanie()// wybiera najpierw najdrozsze przedmioty do najtańszych wg fitness function poki sie mieszkcza w plecaku
        {// tablica musi być najpierw posortowana !!!!
            Plecak rozwiazanie = new Plecak();
            System.out.println("\rrowiazanie algorytmem zachlanym:\r");
            for (int i = 0; i < przedmioty.size(); i++)
            {
                if (rozwiazanie.addPrzedmiot(przedmioty.get(i)))
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
        {System.out.println("loool");
            //wypisz_przedmioty();
            Random rnd = new Random();// ograniczenie gorne dla plecaka, losujemy jego romzmiar
            Plecak.rozmiarPlecaka =  rnd.nextInt( 10000)+10;// okresla rozmiar plecaka
            Collections.sort(przedmioty);//sortowanie tablicy przedmioty dla algorytmu zachlanny (od najdrozszego do najtanszego, )
           //wypisz_przedmioty();
            zachlanie();
          System.exit(0);  
        }
        
}
