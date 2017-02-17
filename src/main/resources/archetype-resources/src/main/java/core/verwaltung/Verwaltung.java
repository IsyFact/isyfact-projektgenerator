#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.verwaltung;

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

import ${package}.core.verwaltung.ausgabedaten.EintragDaten;
import ${package}.core.verwaltung.eingabedaten.NeuerEintrag;

import java.util.List;

/**
 * Interface der AWK-Komponente zur Verwaltung (Erstellen und Lesen) von Einträgen.
 */
public interface Verwaltung {


    /**
     * Erstellt einen neuen Eintrag.
     *
     * @param neuerEintrag Schnittstellenobjekt mit den Daten des neuen Eintrags.
     * @return Schnittstellenobjekt mit den Daten des neuen Eintrags zur Darstellung.
     */
    EintragDaten neuerEintrag(NeuerEintrag neuerEintrag);


    /**
     * Liest alle vorhandenen Einträge.
     *
     * @return Eine Liste mit Schnittstellenobjekten zur Darstellung der Einträge.
     */
    List<EintragDaten> leseAlleEintraege();
}
