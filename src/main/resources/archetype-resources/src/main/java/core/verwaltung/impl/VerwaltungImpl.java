#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.verwaltung.impl;

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

import ${package}.core.verwaltung.Verwaltung;
import ${package}.core.verwaltung.ausgabedaten.EintragDaten;
import ${package}.core.verwaltung.eingabedaten.NeuerEintrag;
import ${package}.persistence.verwaltung.dao.EintragDao;
import ${package}.persistence.verwaltung.entity.Eintrag;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class VerwaltungImpl implements Verwaltung {

    private final EintragDao eintragDao;

    public VerwaltungImpl(EintragDao eintragDao) {
        this.eintragDao = eintragDao;
    }

    @Override
    public EintragDaten neuerEintrag(NeuerEintrag neuerEintrag) {
        Eintrag eintrag = new Eintrag();
        eintrag.setText(neuerEintrag.getText());
        eintrag.setVerfasser(neuerEintrag.getVerfasser());
        eintrag.setDatum(ZonedDateTime.now(ZoneId.of("Z")));

        eintragDao.speichere(eintrag);

        return mappeEintrag(eintrag);
    }

    @Override
    public List<EintragDaten> leseAlleEintraege() {
        return eintragDao.leseAlle().stream().map(this::mappeEintrag).collect(Collectors.toList());
    }

    private EintragDaten mappeEintrag(Eintrag eintrag) {
        return new EintragDaten(eintrag.getVerfasser(), eintrag.getText(), eintrag.getDatum());
    }
}
