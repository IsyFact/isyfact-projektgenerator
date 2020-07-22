#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.exception;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jmx.JmxException;
import org.springframework.transaction.TransactionException;


/**
 * Klasse zum Mapping von Exceptions für Schnittstellen. Die Klasse analysiert übergebene Ausnahmen
 * und liefert die passende AusnahmeID zur Erstellung einer entsprechenden Exception zurück.
 */
public class AusnahmeIdUtil {
    /** Der Logger. */
    private static final Logger LOG = Logger.getLogger(AusnahmeIdUtil.class);

    /**
     * Liefert eine passende AusnahmeID zu einer übergebenen Ausnahme.
     * @param throwable
     *            Throwable, welches analysiert werden soll
     * @return String Ausnahme-ID
     */
    public static String getAusnahmeId(Throwable throwable) {
        if (throwable instanceof DataAccessException) {
            // generische Datenbank-Fehlermeldung
            return "XXXXX";
        } else if (throwable instanceof TransactionException) {
            // generische Datenbank-Fehlermeldung
            return "XXXXX";
        } else if (throwable instanceof JmxException) {
            // generische JMX-Fehlermeldung
            return "XXXXX";
        }

        // Kein Mapping Möglich: generische Fehlermeldung
        LOG.debug("Die Exception der Klasse " + throwable.getClass()
                + "wurde keiner Kategorie zugeordnet: Ausgabe einer generischen Fehlermeldung.");
        return "XXXXX";
    }
}
