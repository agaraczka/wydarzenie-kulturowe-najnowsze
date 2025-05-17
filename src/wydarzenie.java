public class wydarzenie
// Klasa Wydarzenie
import java.util.*;

class Wydarzenie {
    private String nazwa;
    private String data;
    private String miejsce;
    private int maxLiczbaMiejsc = 100;
    private int dostepneMiejsca = 0;
    private double cena;

    // Konstruktory
    public Wydarzenie(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public Wydarzenie(String nazwa, double cena, String data) {
        this(nazwa, cena);
        this.data = data;
    }

    public Wydarzenie(String nazwa, double cena, String data, String miejsce) {
        this(nazwa, cena, data);
        this.miejsce = miejsce;
    }

    // Gettery i settery
    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getMiejsce() { return miejsce; }
    public void setMiejsce(String miejsce) { this.miejsce = miejsce; }

    public int getMaxLiczbaMiejsc() { return maxLiczbaMiejsc; }
    public void setMaxLiczbaMiejsc(int maxLiczbaMiejsc) { this.maxLiczbaMiejsc = maxLiczbaMiejsc; }

    public int getDostepneMiejsca() { return dostepneMiejsca; }
    public void setDostepneMiejsca(int dostepneMiejsca) { this.dostepneMiejsca = dostepneMiejsca; }

    public double getCena() { return cena; }
    public void setCena(double cena) { this.cena = cena; }

    public void zarezerwujMiejsce() {
        if (dostepneMiejsca < maxLiczbaMiejsc) {
            dostepneMiejsca++;
        }
    }

    @Override
    public String toString() {
        return "Wydarzenie: " + nazwa + ", data: " + data + ", miejsce: " + miejsce +
                ", cena: " + cena + " zł, miejsca: " + dostepneMiejsca + "/" + maxLiczbaMiejsc;
    }
}

// Klasa Klient
class Klient {
    private String imie;
    private String nazwisko;
    private String email;
    private ArrayList<Wydarzenie> listaRezerwacji = new ArrayList<>();

    // Konstruktory
    public Klient(String imie, String nazwisko, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public Klient(String imie, String nazwisko) {
        this(imie, nazwisko, "brak@domena.com");
    }

    // Gettery i settery
    public String getImię() { return imie; }
    public void setImię(String imie) { this.imie = imie; }

    public String getNazwisko() { return nazwisko; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void dodajRezerwację(Wydarzenie wydarzenie) {
        listaRezerwacji.add(wydarzenie);
    }

    public void anulujRezerwację(Wydarzenie wydarzenie) {
        listaRezerwacji.remove(wydarzenie);
    }

    public void wyświetlRezerwacje() {
        for (Wydarzenie w : listaRezerwacji) {
            System.out.println(w);
        }
    }
}

// Klasa SystemRezerwacji
class SystemRezerwacji {
    private ArrayList<Wydarzenie> listaWydarzeń = new ArrayList<>();
    private ArrayList<Klient> listaKlientów = new ArrayList<>();

    public void dodajWydarzenie(Wydarzenie wydarzenie) {
        listaWydarzeń.add(wydarzenie);
    }

    public void dodajWydarzenie(String nazwa, double cena) {
        listaWydarzeń.add(new Wydarzenie(nazwa, cena));
    }

    public void dodajKlienta(Klient klient) {
        listaKlientów.add(klient);
    }

    public void dodajKlienta(String imie, String nazwisko) {
        listaKlientów.add(new Klient(imie, nazwisko));
    }

    public void dokonajRezerwacji(Klient klient, Wydarzenie wydarzenie) {
        wydarzenie.zarezerwujMiejsce();
        klient.dodajRezerwację(wydarzenie);
    }

    public Wydarzenie znajdźWydarzenie(String nazwa) {
        for (Wydarzenie w : listaWydarzeń) {
            if (w.getNazwa().equalsIgnoreCase(nazwa)) {
                return w;
            }
        }
        return null;
    }

    public Klient znajdźKlienta(String nazwisko) {
        for (Klient k : listaKlientów) {
            if (k.getNazwisko().equalsIgnoreCase(nazwisko)) {
                return k;
            }
        }
        return null;
    }

    public void zmieńCenęWydarzenia(String nazwa, double nowaCena) {
        Wydarzenie wydarzenie = znajdźWydarzenie(nazwa);
        if (wydarzenie != null) {
            wydarzenie.setCena(nowaCena);
        }
    }
}{
}
