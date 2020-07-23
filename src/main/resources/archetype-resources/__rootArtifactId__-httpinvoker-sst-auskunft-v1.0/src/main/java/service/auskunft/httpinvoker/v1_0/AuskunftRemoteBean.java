#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.auskunft.httpinvoker.v1_0;

import de.bund.bva.pliscommon.serviceapi.service.httpinvoker.v1_0_0.AufrufKontextTo;

/**
 * Service-Interface der Komponente Auskunft.
 */
public interface AuskunftRemoteBean {

    /**
      * Diese Operation führt eine Auskunft durch.
      */
    public AuskunftErgebnisTo fuehreAuskunftDurch(AufrufKontextTo kontext, AnfrageDatenTo anfrageDaten) throws AuskunftTechnicalToException;

}
