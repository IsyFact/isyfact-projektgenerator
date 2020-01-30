#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.auskunft.httpinvoker.v1_0.impl;

import de.bund.bva.pliscommon.serviceapi.service.httpinvoker.v1_0_0.AufrufKontextTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AnfrageDatenTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AuskunftErgebnisTo;

/**
 * Interface der Service Auskunft.
 */
public interface AuskunftService {

    /**
    * {@inheritDoc}
    */
    public AuskunftErgebnisTo fuehreAuskunftDurch(AufrufKontextTo kontext, AnfrageDatenTo anfrageDaten);

}
