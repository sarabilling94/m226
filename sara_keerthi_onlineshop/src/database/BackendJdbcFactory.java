package database;

import models.User;
import models.User_InMemoryImpl;

/**
 * Singeton Class for Jdbc Factory
 * Returns objects of the Classes ....Jdbc_Impl
 */
public class BackendJdbcFactory extends BackendFactory {
    private static final BackendFactory factory=new BackendJdbcFactory();
    public static BackendFactory getFactory() {
        return factory;
    }

    public User createUser(int IDuser, String userName, String password, String firstName, String lastName, String address, String email){
        return new User_JdbcImpl(IDuser, userName, password, firstName, lastName, address, email);
    }

    //ex from tourenplaner
    /*
    public Station createStation(Timestamp ankunftszeit, Timestamp abfahrtszeit, Ort ort, Fahrer fahrer, int haltnummer, Fahrt fahrt) throws SQLException {
        return new StationJdbc_impl(ankunftszeit, abfahrtszeit, ort, fahrer, haltnummer, fahrt);
    }

    public Person createPerson(String vorname, String nachname, String telefonnummer) {
        throw new RuntimeException(Configuration.hibernation + " not implemented yet");
    }

    public Ort createOrt(String plz, String ortsbezeichnung) throws SQLException {
        return new OrtJdbc_Impl(plz, ortsbezeichnung);
    }

    public Mitarbeiter createMitarbeiter(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum) throws SQLException {
        return new MitarbeiterJdbc_Impl(vorname, nachname, telefonnummer, anstellungsdatum);
    }

    public Kunde createKunde(String vorname, String nachname, String telefonnummer) throws SQLException {
        return new KundeJdbc_Impl(vorname, nachname, telefonnummer);
    }


    public Fahrzeug createFahrzeug(String kennzeichen, int sitzplaetze) throws SQLException {
        return new FahrzeugJdbc_Impl(kennzeichen, sitzplaetze);

    }

    public Disponent createDisponent(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum, int region_id) throws SQLException {
        return new DisponentJdbc_Impl(vorname, nachname, telefonnummer, anstellungsdatum, region_id);
    }

    public Fahrer createFahrer(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum) throws SQLException {
        return new FahrerJdbc_Impl(vorname, nachname, telefonnummer, anstellungsdatum);
    }

    public Fahrt createFahrt(Fahrzeug fahrzeug, Disponent disponent) throws SQLException {
        return new FahrtJdbc_Impl(fahrzeug, disponent);
    }

    public ArrayList<? extends Fahrt> getFahrten() throws SQLException {
        return FahrtJdbc_Impl.getFahrten();
    }
     */


}
