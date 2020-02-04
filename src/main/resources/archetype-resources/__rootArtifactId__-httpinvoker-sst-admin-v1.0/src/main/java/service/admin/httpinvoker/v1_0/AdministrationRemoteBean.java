#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.admin.httpinvoker.v1_0;


/**
 * Service-Interface für die Admin-Komponente.
 */
public interface AdministrationRemoteBean {

    /**
     * Die Ping-Methode erlaubt Nachbarsystemen, die Erreichbarkeit dieses Systems zu prüfen. Die Methode ist
     * trivial und wird daher nicht bis in den Anwendungskern durchgereicht.
     * 
     * @param nachricht
     *            Die Nachricht
     * @return Die Nachricht
     */
    public String ping(String nachricht);

}
