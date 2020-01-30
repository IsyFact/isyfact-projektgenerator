#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.exception;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jmx.JmxException;
import org.springframework.transaction.TransactionException;


/**
 * Klasse zum Mapping von Exceptions f&uumlo;r Schnittstellen. Die Klasse analysiert &uuml;bergebene Ausnahmen
 * und liefert die passende AusnahmeID zur Erstellung einer entsprechenden Exception zur&uuml;ck.
 */
public class AusnahmeIdUtil {
    /** Der Logger. */
    private static final Logger LOG = Logger.getLogger(AusnahmeIdUtil.class);

    /**
     * Liefert eine passende AusnahmeID zu einer &uuml;bergebenen Ausnahme.
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
        /*
        else if (throwable instanceof CdRegisterBusinessException) {
            LOG.warn("Es wurde eine CdRegisterBusinessException analysiert. "
                    + "Eigentlich sollte diese Verarbeitung über catch-Blöcke geschehen.");
            // Fehler-Code auslesen
            return ((CdRegisterException) throwable).getAusnahmeId();
        } else if (throwable instanceof CdRegisterTechnicalException) {
            LOG.warn("Es wurde eine CdRegisterTechnicalException analysiert. "
                    + "Eigentlich sollte diese Verarbeitung über catch-Blöcke geschehen.");
            // Fehler-Code auslesen
            return ((CdRegisterException) throwable).getAusnahmeId();
        } else if (throwable instanceof CdRegisterTechnicalRuntimeException) {
            // Fehler-Code auslesen
            return ((CdRegisterTechnicalRuntimeException) throwable).getAusnahmeId();
        }
        */
        // Kein Mapping Möglich: generische Fehlermeldung
        LOG.debug("Die Exception der Klasse " + throwable.getClass()
                + "wurde keiner Kategorie zugeordnet: Ausgabe einer generischen Fehlermeldung.");
        return "XXXXX";
    }
}
