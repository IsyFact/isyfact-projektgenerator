#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.auskunft.httpinvoker.v1_0;

import de.bund.bva.pliscommon.exception.service.PlisTechnicalToException;

public class AuskunftTechnicalToException extends PlisTechnicalToException {
    protected AuskunftTechnicalToException(String message, String ausnahmeId, String uniqueId) {
        super(message, ausnahmeId, uniqueId);
    }
}