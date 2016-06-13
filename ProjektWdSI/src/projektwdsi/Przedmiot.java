
package projektwdsi;

public class Przedmiot implements Comparable<Przedmiot> {// Comparable  - interfejs zawierajacy fun fitness
     public int Id;
        public int Rozmiar; 
        public float Wartosc;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getRozmiar() {
        return Rozmiar;
    }

    public void setRozmiar(int Rozmiar) {
        this.Rozmiar = Rozmiar;
    }

    public float getWartosc() {
        return Wartosc;
    }

    public void setWartosc(float Wartosc) {
        this.Wartosc = Wartosc;
    }

    Przedmiot(int i, int nextInt, float f) {
            Id=i;
            Rozmiar = nextInt;
            Wartosc = f;
    
    }
        public String ToString()
        {
            return "indyfikator: " + this.Id + " rozmiar: " + this.Rozmiar + " wartosc: " + this.Wartosc;
        }
        // fitness function, porownuje ktory drozszy przedmiot, mniejsza waga lepsza
     @Override
        public int compareTo(Przedmiot o)
        {
            if (this.Wartosc > o.Wartosc)
                return -1;
            if (this.Wartosc==o.Wartosc)
            {
                if (this.Rozmiar<o.Rozmiar)
                {
                    return -1;
                }
                else
                {
                    if (this.Rozmiar == o.Rozmiar)
                    {
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }                      
                }
            }
            return 1;
        }


}

