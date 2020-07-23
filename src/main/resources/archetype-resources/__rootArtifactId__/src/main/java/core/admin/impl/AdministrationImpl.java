#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.admin.impl;

import ${package}.core.admin.Administration;

import org.springframework.beans.factory.annotation.Required;

import org.apache.log4j.Logger;
import de.bund.bva.pliscommon.konfiguration.common.ReloadableKonfiguration;
import de.bund.bva.pliscommon.ueberwachung.common.jmx.StatusMonitorMBean;

/**
 * Diese Klasse implementiert die Administrations-Komponente des Registers.
 *
 */
public class AdministrationImpl implements Administration {
    /** Referenz auf die MBean des Watchdogs. */
    private StatusMonitorMBean watchdogMBean;

    /** Referenz auf die Register-Konfiguration. */
    private ReloadableKonfiguration konfiguration;

    /** Der Logger. */
    private static final Logger LOG = Logger.getLogger(AdministrationImpl.class);

    /**
     * {@inheritDoc}
     */
    public boolean pruefeSystem() {
        boolean erfolgreich = false;
        try {
            // Schritt 1: Prüfen der Datenbankverbindung
            // Schritt 2..n: Aufrufen der Ping-Methoden aller Nachbarsysteme
            erfolgreich = true;
        } catch (Throwable t) {
            LOG.error("Beim Selbsttest des Systems wurde ein Fehler festgestellt.", t);
        } finally {
            watchdogMBean.registrierePruefung(erfolgreich);
        }
        return erfolgreich;
    }

    /**
     * Setter für die Watchdog-MBean. Wird durch Spring aufgerufen.
     * @param watchdogMBean
     *            Referenz auf die Watchdog-MBean
     */
    @Required
    public void setWatchdogMBean(StatusMonitorMBean watchdogMBean) {
        this.watchdogMBean = watchdogMBean;
    }

    /**
     * Setter für die Konfiguration des Registers. Wird durch Spring aufgerufen.
     * @param konfiguration
     *            Referenz auf die Register-Konfiguration
     */
    @Required
    public void setKonfiguration(ReloadableKonfiguration konfiguration) {
        this.konfiguration = konfiguration;
    }
}
