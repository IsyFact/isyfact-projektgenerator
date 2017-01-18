#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.persistence.verwaltung.dao;

import ${package}.persistence.verwaltung.entity.Eintrag;
import de.bund.bva.pliscommon.persistence.dao.Dao;

import java.util.List;

public interface EintragDao extends Dao<Eintrag, Long> {

    List<Eintrag> leseAlle();
}
