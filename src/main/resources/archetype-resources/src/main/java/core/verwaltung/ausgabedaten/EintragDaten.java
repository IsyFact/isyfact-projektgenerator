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
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EintragDaten {
    private String verfasser;
    private String text;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date datum;

    public EintragDaten(String verfasser, String text, Date datum) {
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
