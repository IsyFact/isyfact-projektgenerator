#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.auskunft.httpinvoker.v1_0.impl;

import org.apache.log4j.Logger;

import ${package}.service.auskunft.httpinvoker.v1_0.AnfrageDatenTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AuskunftErgebnisTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AuskunftRemoteBean;
import ${package}.service.auskunft.httpinvoker.v1_0.AuskunftTechnicalToException;
import ${package}.common.exception.AuskunftException;
import ${package}.common.exception.AusnahmeIdUtil;

import de.bund.bva.pliscommon.serviceapi.common.exception.PlisExceptionMapper;
import de.bund.bva.pliscommon.serviceapi.service.httpinvoker.v1_0_0.AufrufKontextTo;
import de.bund.bva.pliscommon.util.exception.MessageSourceFehlertextProvider;

/**
 * Diese Klasse führt das Exception-Handling für den Auskunft-Service durch.
 */
public class AuskunftExceptionFassade implements AuskunftRemoteBean {

    /**
     * Der Logger dieser Klasse.
     */
    private static final Logger LOG = Logger.getLogger(AuskunftExceptionFassade.class);

    /**
     * Die Referenz auf den {@link AuskunftService}.
     */
    private AuskunftService auskunftService;

    /**
     * Der Setter fuer den {@link AuskunftService}. Dieser wird von Spring aufgerufen.
     * @param auskunftService der AuskunftService.
     */
    public void setAuskunftService(AuskunftService auskunftService) {
        this.auskunftService = auskunftService;
    }

    /**
     * {@inheritDoc}
     */
    public AuskunftErgebnisTo fuehreAuskunftDurch(AufrufKontextTo kontext, AnfrageDatenTo anfrageDaten)
            throws AuskunftTechnicalToException {

        try {
            return auskunftService.fuehreAuskunftDurch(kontext, anfrageDaten);
        } catch (AuskunftException e) {
            // Unbekannte Exceptions in Schnittstellen-Exceptions transformieren.
            AuskunftTechnicalToException ex = PlisExceptionMapper.createToException(
                    AusnahmeIdUtil.getAusnahmeId(e),
                    new MessageSourceFehlertextProvider(),
                    AuskunftTechnicalToException.class,
                    e.getMessage());

            LOG.error("Methode 'fuehreAuskunftDurch' fehlgeschlagen. Übergebener Fehler:" + ex.getMessage(), e);

            throw ex;

        }

    }

}
