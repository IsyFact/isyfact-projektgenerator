#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.persistence.verwaltung.dao;

/*-
 * #%L
 * IsyFact-Projektgenerator
 * %%
 * Copyright (C) 2017 Bundesverwaltungsamt (BVA), msg systems ag
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 * #L%
 */

import ${package}.persistence.verwaltung.entity.Eintrag;
import de.bund.bva.pliscommon.persistence.dao.Dao;

import java.util.List;

/**
 * DAO-Interface für die Persistierung von Einträgen.
 */
public interface EintragDao extends Dao<Eintrag, Long> {

    /**
     * Liest alle vorhandenen Einträge.
     *
     * @return Eine Liste mit allen Einträgen.
     */
    List<Eintrag> leseAlle();
}
