#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.rest;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Factory zum Erzeugen eines ObjectMappers, der
 *  - die Java 8 Erweiterungen von Jackson lädt
 *  - Datums- und Zeitangaben nicht als Timestamp serialisiert
 *
 */
public class CustomObjectMapperFactory {

    /**
     * Erzeugt eine konfigurierte Instanz eines ObjectMappers.
     *
     * @return die ObjectMapper-Instanz.
     */
    public static ObjectMapper getInstance() {

        ObjectMapper mapper = new ObjectMapper();

        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    }
}
