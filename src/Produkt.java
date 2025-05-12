public class Produkt private int id;
private String nazwa;
private String kategoria;
private double cena;
private int iloscWMagazynie;

public Produkt() {}

public Produkt(int id, String nazwa, String kategoria, double cena, int iloscWMagazynie) {
    this.id = id;
    this.nazwa = nazwa;
    this.kategoria = kategoria;
    this.cena = cena;
    this.iloscWMagazynie = iloscWMagazynie;
}

public int getId() { return id; }
public void setId(int value) { id = value; }

public String getNazwa() { return nazwa; }
public void setNazwa(String value) { nazwa = value; }

public String getKategoria() { return kategoria; }
public void setKategoria(String value) { kategoria = value; }

public double getCena() { return cena; }
public void setCena(double value) { cena = value; }

public int getIloscWMagazynie() { return iloscWMagazynie; }
public void setIloscWMagazynie(int value) { iloscWMagazynie = value; }

public void wyswietlInformacje() {
    System.out.println("ID: " + id + ", Nazwa: " + nazwa + ", Kategoria: " + kategoria + ", Cena: " + cena + ", Ilosc: " + iloscWMagazynie);
}
}{
}
