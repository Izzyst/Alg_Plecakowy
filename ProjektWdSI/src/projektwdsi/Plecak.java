package projektwdsi;

import java.util.ArrayList;
import java.util.List;

public class Plecak {
    public static int rozmiarPlecaka;
    public int rozmiarZawartosci=0;
    public float wartosc=0;
    public List <Przedmiot> zawartosc = new ArrayList<Przedmiot>();;

    public Boolean addPrzedmiot(Przedmiot item)
        {
            if (rozmiarPlecaka>= rozmiarZawartosci+item.Rozmiar)
            {
                rozmiarZawartosci += item.Rozmiar;
                wartosc += item.Wartosc;
                zawartosc.add(item);
                return true;
            }
            return false;
        }
}


