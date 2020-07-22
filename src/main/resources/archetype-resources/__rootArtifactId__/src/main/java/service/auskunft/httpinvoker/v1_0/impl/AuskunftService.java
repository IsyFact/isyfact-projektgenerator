#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.auskunft.httpinvoker.v1_0.impl;

import de.bund.bva.pliscommon.serviceapi.service.httpinvoker.v1_0_0.AufrufKontextTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AnfrageDatenTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AuskunftErgebnisTo;
import ${package}.common.exception.AuskunftException;

/**
 * Interface der Service Auskunft.
 */
public interface AuskunftService {

    /**
    * Diese Operation führt eine Auskunft durch.
    */
    public AuskunftErgebnisTo fuehreAuskunftDurch(AufrufKontextTo kontext, AnfrageDatenTo anfrageDaten) throws AuskunftException;

}
