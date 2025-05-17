// Klasa Wydarzenie
import java.util.*;

public class Wydarzenie {
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
        } else {
            System.out.println("Brak dostepnych miejsc na to wydarzenie.");
        }
    }

    @Override
    public String toString() {
        return "Wydarzenie: " + nazwa + ", data: " + data + ", miejsce: " + miejsce +
                ", cena: " + cena + " PLN, miejsca: " + dostepneMiejsca + "/" + maxLiczbaMiejsc;
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
    public String getImie() { return imie; }
    public void setImie(String imie) { this.imie = imie; }

    public String getNazwisko() { return nazwisko; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void dodajRezerwacje(Wydarzenie wydarzenie) {
        listaRezerwacji.add(wydarzenie);
    }

    public void anulujRezerwacje(Wydarzenie wydarzenie) {
        listaRezerwacji.remove(wydarzenie);
    }
