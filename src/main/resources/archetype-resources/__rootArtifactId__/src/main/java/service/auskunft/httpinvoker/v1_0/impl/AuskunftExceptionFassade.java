#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.auskunft.httpinvoker.v1_0.impl;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;

import ${package}.service.auskunft.httpinvoker.v1_0.AnfrageDatenTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AuskunftErgebnisTo;
import ${package}.service.auskunft.httpinvoker.v1_0.AuskunftRemoteBean;
import de.bund.bva.pliscommon.serviceapi.service.httpinvoker.v1_0_0.AufrufKontextTo;
import ${package}.common.exception.AusnahmeIdUtil;
import de.bund.bva.pliscommon.util.exception.MessageSourceFehlertextProvider;

/**
 * 
 * @author sd&amp;m AG, Max Mustermann
 * @version ${symbol_dollar}Id: AuskunftExceptionFassade.java 107737 2011-07-21 09:52:17Z sdm_fsenn ${symbol_dollar}
 *
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
    public AuskunftErgebnisTo fuehreAuskunftDurch(AufrufKontextTo kontext, AnfrageDatenTo anfrageDaten) {
    
    	try {
    		return auskunftService.fuehreAuskunftDurch(kontext, anfrageDaten);
    		// TODO: Die Transformation der Exceptions muss ggf. angepasst werden.
    	} catch (Throwable t) {
    		// Unbekannte Exceptions in Schnittstellen-Exceptions transformieren.

    		/* 
    		AuskunftTechnikToException ex = PlisExceptionMapper.createToException(AusnahmeIdUtil.getAusnahmeId(t), new MessageSourceFehlertextProvider(), AuskunftTechnikToException.class, t.getMessage());
    		LOG.error("Methode 'fuehreAuskunftDurch' fehlgeschlagen. Übergebener Fehler:" + ex.getMessage(), t);
    		throw ex;
    	    */
    	    
    		throw null; // TODO remove
    	}
    	
    }

}
