#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.auskunft;

import ${package}.common.exception.AuskunftException;

/**
 * Interface der Komponente Auskunft.
 */
public interface Auskunft {

    /**
     * Führt basierend auf den Aunfragedaten eine Auskunft durch.
     * Bei einem Fehler wird eine AuskunftException geworfen.
     *
     * @param anfrageDaten Daten auf denen die Auskunft durchgeführt wird.
     * @return Das Ergebnis der Auskunft. <code>null</code> wenn unerfolgreich.
     * @throws AuskunftException Wird geworfen, wenn eine Fehler bei der durchführung eintritt.
     */
    public AuskunftErgebnis fuehreAuskunftDurch(AnfrageDaten anfrageDaten) throws AuskunftException;
}
