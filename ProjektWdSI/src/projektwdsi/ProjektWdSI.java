package projektwdsi;

import java.util.ArrayList;
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
    
}
