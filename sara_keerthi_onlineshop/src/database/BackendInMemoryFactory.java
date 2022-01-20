package database;

import models.User;
import models.User_InMemoryImpl;

/**
 * Singeton Class for InMemory Factory
 * Returns objects of the Classes ....InMemory_Impl
 */
public class BackendInMemoryFactory extends BackendFactory {
    private static final BackendFactory factory=new BackendInMemoryFactory();
    public static BackendFactory getFactory() {
        return factory;
    }

    public User createUser(int IDuser, String userName, String password, String firstName, String lastName, String address, String email){
        return new User_InMemoryImpl(IDuser, userName, password, firstName, lastName, address, email);
    }

    //ex from tourenplaner
    /*
    public Station createStation(Timestamp ankunftszeit, Timestamp abfahrtszeit, Ort ort, Fahrer fahrer, int haltnummer, Fahrt fahrt) {
        return new StationInMemory_impl(ankunftszeit, abfahrtszeit, ort, fahrer, haltnummer, fahrt);
    }

    public Person createPerson(String vorname, String nachname, String telefonnummer) {
        return new PersonInMemory_Impl(vorname, nachname, telefonnummer);
    }

    public Ort createOrt(String plz, String ortsbezeichnung) throws SQLException {
        return new OrtInMemory_Impl(plz, ortsbezeichnung);
    }

    public Mitarbeiter createMitarbeiter(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum) {
        return new MitarbeiterInMemory_Impl(vorname, nachname, telefonnummer, anstellungsdatum);
    }

    public Kunde createKunde(String vorname, String nachname, String telefonnummer) {
        return new KundeInMemory_Impl(vorname, nachname, telefonnummer);
    }


    public Fahrzeug createFahrzeug(String kennzeichen, int sitzplaetze) {
        return new FahrzeugInMemory_Impl(kennzeichen, sitzplaetze);

    }

    public Disponent createDisponent(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum, int region_id) {
        return new DisponentInMemory_Impl(vorname, nachname, telefonnummer, anstellungsdatum, region_id);
    }

    public Fahrer createFahrer(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum) {
        return new FahrerInMemory_Impl(vorname, nachname, telefonnummer, anstellungsdatum);
    }

    public Fahrt createFahrt(Fahrzeug fahrzeug, Disponent disponent)  {
        return new FahrtInMemory_Impl(fahrzeug, disponent);
    }

    public ArrayList<? extends Fahrt> getFahrten()  {
        return FahrtInMemory_Impl.getFahrten();
    }
     */
}
