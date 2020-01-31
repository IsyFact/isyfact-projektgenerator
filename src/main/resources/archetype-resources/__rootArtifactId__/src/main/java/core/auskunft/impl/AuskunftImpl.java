#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.auskunft.impl;

import de.bund.common.exception.AuskunftException;
import de.bund.core.auskunft.AnfrageDaten;
import de.bund.core.auskunft.Auskunft;
import de.bund.core.auskunft.AuskunftErgebnis;

/**
 * Implementierung der Komponente Auskunft.
 */
public class AuskunftImpl implements Auskunft {

    /**
     * Klasse für einen Anwendungsfall. Einfache Komponenten können Anwendungsfälle auch direkt in der
     * Komponenten-Fassade implementieren.
     */
    private AwfRegisterEintragSuchen awfRegisterEintragSuchen;

    public AuskunftErgebnis fuehreAuskunftDurch(AnfrageDaten anfrageDaten) throws AuskunftException {
        return awfRegisterEintragSuchen.fuehreAuskunftDurch(anfrageDaten);
    }

    public void setAwfRegisterEintragSuchen(AwfRegisterEintragSuchen awfRegisterEintragSuchen) {
        this.awfRegisterEintragSuchen = awfRegisterEintragSuchen;
    }

}