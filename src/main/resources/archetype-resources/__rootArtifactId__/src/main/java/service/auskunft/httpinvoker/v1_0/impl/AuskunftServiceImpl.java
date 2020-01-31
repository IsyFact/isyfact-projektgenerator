#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.auskunft.httpinvoker.v1_0.impl;

import org.dozer.Mapper;

import de.bund.bva.pliscommon.serviceapi.service.httpinvoker.v1_0_0.AufrufKontextTo;
import ${package}.common.exception.AuskunftException;
import ${package}.core.auskunft.AnfrageDaten;
import ${package}.core.auskunft.AuskunftErgebnis;
import ${package}.core.auskunft.Auskunft;
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
     * {@inheritDoc}
     */
    public AuskunftErgebnisTo fuehreAuskunftDurch(AufrufKontextTo kontext, AnfrageDatenTo anfrageDatenTo)
            throws AuskunftException {

        AnfrageDaten anfrageDaten = (AnfrageDaten) dozer.map(anfrageDatenTo, AnfrageDaten.class);
        AuskunftErgebnis ergebnis = auskunft.fuehreAuskunftDurch(anfrageDaten);
        AuskunftErgebnisTo ergebnisTo = dozer.map(ergebnis, AuskunftErgebnisTo.class);
        return ergebnisTo;
    }

}
