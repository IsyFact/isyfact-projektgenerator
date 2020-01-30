#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.auskunft;

/**
 * Interface der Komponente Auskunft.
 */
public interface Auskunft {

    public AuskunftErgebnis fuehreAuskunftDurch(AnfrageDaten anfrageDaten);
}
