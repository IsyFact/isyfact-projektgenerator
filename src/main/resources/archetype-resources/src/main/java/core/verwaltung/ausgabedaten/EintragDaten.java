#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.verwaltung.ausgabedaten;

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

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.time.ZonedDateTime;

/**
 *  Schnittstellenobjekt zum Darstellen eines Eintrags.
 */
public class EintragDaten {
    private String verfasser;
    private String text;

    private ZonedDateTime datum;

    /**
     * Erzeugt ein neues Schnittstellenobjekt zum Darstellen eines Eintrags.
     *
     * @param verfasser Der Verfasser des Eintrags
     * @param text Der Text des Eintrags
     * @param datum Datum und Uhrzeit des Eintrags.
     */
    public EintragDaten(String verfasser, String text, ZonedDateTime datum) {
        this.verfasser = verfasser;
        this.text = text;
        this.datum = datum;
    }

    public String getVerfasser() {
        return verfasser;
    }

    public void setVerfasser(String verfasser) {
        this.verfasser = verfasser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZonedDateTime getDatum() {
        return datum;
    }

    public void setDatum(ZonedDateTime datum) {
        this.datum = datum;
    }
}
