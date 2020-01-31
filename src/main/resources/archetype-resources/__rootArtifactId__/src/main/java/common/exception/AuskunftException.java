#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.common.exception;

import de.bund.bva.pliscommon.exception.PlisTechnicalException;

/**
 * Beispiel-Exception die bei einer Anfrage geworfen werden kann
 */
public class AuskunftException extends PlisTechnicalException {

    public AuskunftException() {
        super("", (s1, s2) -> "DUMMY EXCEPTION");
    }

}
