#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.auskunft.impl;

import ${package}.core.auskunft.AnfrageDaten;
import ${package}.core.auskunft.Auskunft;
import ${package}.core.auskunft.AuskunftErgebnis;

/**
 * Implementierung der Komponente Auskunft.
 */
public class AuskunftImpl implements Auskunft {
    
    /**
     * Klasse für einen Anwendungsfall. Einfache Komponenten können Anwendungsfälle auch direkt in der
     * Komponenten-Fassade implementieren.
     */
    private AwfRegisterEintragSuchen awfRegisterEintragSuchen;

    public AuskunftErgebnis fuehreAuskunftDurch(AnfrageDaten anfrageDaten) {
        return awfRegisterEintragSuchen.fuehreAuskunftDurch(anfrageDaten);
    }
    
    public void setAwfRegisterEintragSuchen(AwfRegisterEintragSuchen awfRegisterEintragSuchen) {
        this.awfRegisterEintragSuchen = awfRegisterEintragSuchen;
    }

}
