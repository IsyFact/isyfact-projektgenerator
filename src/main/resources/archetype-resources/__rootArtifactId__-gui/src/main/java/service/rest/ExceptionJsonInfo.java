#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.rest;

public class ExceptionJsonInfo {
    private String message;

    public ExceptionJsonInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
