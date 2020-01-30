#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.auskunft.httpinvoker.v1_0.impl;

import org.dozer.Mapper;

import de.bund.bva.pliscommon.serviceapi.service.httpinvoker.v1_0_0.AufrufKontextTo;
import de.bund.bva.pliscommon.sicherheit.Sicherheit;
import ${package}.core.auskunft.AnfrageDaten;
import ${package}.core.auskunft.AuskunftErgebnis;
import ${package}.core.auskunft.Auskunft;
import ${package}.core.auskunft.AuskunftErgebnis;
import ${package}.core.auskunft.AnfrageDaten;
import ${package}.service.auskunft.httpinvoker.v1_0.AuskunftErgebnisTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AnfrageDatenTo;

/**
 * Beispielimplementierung des Service Auskunft.
 */
public class AuskunftServiceImpl implements AuskunftService {

    /**
     * Der Dozer-Mapper zum Mappen zwischen ADB und Business-Objekten.
     */
    private Mapper dozer;

    /**
     * Die Referenz auf die Komponente Auskunft.
     */
    private Auskunft auskunft;

    /**
     * Die Referenz auf die Komponente Sicherheit.
     */
    private Sicherheit sicherheit;

    /**
     * Der Setter fuer die Komponente Auskunft. Dieser wird von Spring aufgerufen.
     * 
     * @param auskunft
     *            die Referenz auf die Komponente Auskunft.
     */
    public void setAuskunft(Auskunft auskunft) {
        this.auskunft = auskunft;
    }

    /**
     * Der Setter fuer die Dozer-Mapper-Bean. Dieser wird von Spring aufgerufen.
     * 
     * @param dozer
     *            die Referenz auf die Dozer-Mapper-Bean.
     */
    public void setDozer(Mapper dozer) {
        this.dozer = dozer;
    }

    /**
     * Der Setter fuer die Komponente Sicherheit. Dieser wird von Spring aufgerufen.
     * 
     * @param sicherheit
     *            die Referenz auf die Komponente Sicherheit.
     */
    public void setSicherheit(Sicherheit sicherheit) {
        this.sicherheit = sicherheit;
    }

    /**
     * Prueft die Berechtigung für den Aufrufer.
     * 
     * @param kontext
     *            der Kontext mit Informationen Über den Aufrufer.
     * @throws BerechtigungFehltException
     *             falls der Benutzer nicht das benoetigte Recht hat.
     */
    private void pruefeBerechtigungUndSetzeKennung(AufrufKontextTo kontext) {
        /*
         * Benutzerkennung kennung = new Benutzerkennung(); kennung.setAnmeldename(kontext.getNutzerName());
         * kennung.setBhknz(kontext.getOrganisationseinheit()); Berechtigungsmanager manager =
         * sicherheit.getBerechtigungsManager(kennung); if (!manager.hatRecht(RechteSchluessel.RECHT_XYZ)) {
         * throw new BerechtigungFehltException(FehlerSchluessel.MSG_BERECHTIGUNG_RECHT_FEHLT,
         * RechteSchluessel.RECHT_XYZ); }
         */
    }

    /**
     * {@inheritDoc}
     */
    public AuskunftErgebnisTo fuehreAuskunftDurch(AufrufKontextTo kontext, AnfrageDatenTo anfrageDatenTo) {

        // Schritt 1: Mappen der Transport-Objekte auf interne Beans.

        // Schritt 2: Berechtigungspruefung durchfuehren.
        pruefeBerechtigungUndSetzeKennung(kontext);

        // Schritt 3: Aufruf an AWK weitergeben.
        AnfrageDaten anfrageDaten = (AnfrageDaten) dozer.map(anfrageDatenTo, AnfrageDaten.class);
        AuskunftErgebnis ergebnis = auskunft.fuehreAuskunftDurch(anfrageDaten);

        // Schritt 4: Ergebnisstrukturen befuellen.
        AuskunftErgebnisTo ergebnisTo = (AuskunftErgebnisTo) dozer.map(ergebnis, AuskunftErgebnisTo.class);

        // Schritt 5: Ergebnisdaten zurueckgeben.
        return ergebnisTo;
    }

}
