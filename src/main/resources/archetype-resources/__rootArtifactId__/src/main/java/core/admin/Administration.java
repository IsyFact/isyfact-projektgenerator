#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.admin;

/**
 * Beispiel-Inteface für die Komponente Administration.
 */
public interface Administration {
    
    /**
     * Diese Methode prüft die Funktionsfähigkeit des Registers. Sie wird
     * automatisch in regelmäßigen Abständen vom Watchdog aufgerufen.
     * 
     * Die Methode führt ein eigenes Exception-Handling durch. Alle Throwables
     * werden gefangen und geloggt, um zu verhindern, dass diese den
     * eigentlichen Timer-Thread erreichen.
     * 
     * Diese Methode darf nicht im Service-Interface angeboten werden.
     * 
     * @return <code>true</code> falls die Prüfung erfolgreich war, ansonsten
     *         <code>false</code>.
     */    
    public boolean pruefeSystem();
}
