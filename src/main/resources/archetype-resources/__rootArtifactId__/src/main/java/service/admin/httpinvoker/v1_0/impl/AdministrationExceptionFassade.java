#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.admin.httpinvoker.v1_0.impl;

import org.apache.log4j.Logger;

import ${package}.service.admin.httpinvoker.v1_0.AdministrationRemoteBean;

/**
 * Diese Klasse f&uuml;hrt das Exception-Handling f&uuml;r den Administrations-Service durch.
 * 
 * @author Capgemini sd&amp;m AG, Andy Scherzinger
 * @version ${symbol_dollar}Id: AdministrationExceptionFassade.java 85801 2010-04-05 16:45:07Z sdm_fsenn ${symbol_dollar}
 */
public class AdministrationExceptionFassade implements AdministrationRemoteBean {
    /** Der Logger dieser Klasse. */
    private static final Logger LOG = Logger.getLogger(AdministrationExceptionFassade.class);
    
    /**
     * {@inheritDoc}
     */
    public String ping(String nachricht) {
        return nachricht;
    }
}
