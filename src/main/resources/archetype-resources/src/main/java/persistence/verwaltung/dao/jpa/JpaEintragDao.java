#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.persistence.verwaltung.dao.jpa;

import ${package}.persistence.verwaltung.dao.EintragDao;
import ${package}.persistence.verwaltung.entity.Eintrag;
import de.bund.bva.pliscommon.persistence.dao.AbstractDao;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaEintragDao extends AbstractDao<Eintrag, Long> implements EintragDao {

    @Override
    public List<Eintrag> leseAlle() {
        TypedQuery<Eintrag> query = getEntityManager().createQuery("select e from Eintrag e order by e.datum", Eintrag.class);

        return query.getResultList();
    }
}
