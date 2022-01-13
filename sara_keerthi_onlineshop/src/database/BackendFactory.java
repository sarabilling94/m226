package database;

import models.User;

/**
 * Backend Factory Class which defines all Factory Methods.
 */
public abstract class BackendFactory {
    /**
     * This method is calling the right Factory class's getFactory method and returns the right Factory
     * according to the Configuration.hibernation field
     * @return BackendFactory
     */
    public static BackendFactory getFactory(){
        if (Configuration.hibernation == Configuration.hibernationType.inMemory)
            return BackendInMemoryFactory.getFactory();
        if (Configuration.hibernation == Configuration.hibernationType.jdbc)
            return BackendJdbcFactory.getFactory();
        throw new RuntimeException(Configuration.hibernation + " not implemented yet");
    }

    /*
     * Definition of Factory Methods to create and get Objects of the specific <Class>.
     * Call any of these Methods instead of directly calling new <Class>(...)
     */

    public abstract User createUser(int IDuser, String userName, String password, String firstName, String lastName, String address, String email);

    //ex from tourenplaner
    /*public abstract Fahrt createFahrt(Fahrzeug fahrzeug, Disponent disponent) throws SQLException;
    public abstract Disponent createDisponent(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum, int region_id) throws SQLException ;
    public abstract Fahrer createFahrer(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum) throws SQLException ;
    public abstract Fahrzeug createFahrzeug(String kennzeichen, int sitzplaetze) throws SQLException ;
    public abstract Kunde createKunde(String vorname, String nachname, String telefonnummer) throws SQLException ;
    public abstract Mitarbeiter createMitarbeiter(String vorname, String nachname, String telefonnummer, Timestamp anstellungsdatum) throws SQLException ;
    public abstract Ort createOrt(String plz, String ortsbezeichnung) throws  SQLException ;
    public abstract Person createPerson(String vorname, String nachname, String telefonnummer);
    public abstract Station createStation(Timestamp ankunftszeit, Timestamp abfahrtszeit, Ort ort, Fahrer fahrer, int haltnummer, Fahrt fahrt) throws SQLException;
    public abstract ArrayList<? extends Fahrt> getFahrten() throws SQLException ;
     */
}
