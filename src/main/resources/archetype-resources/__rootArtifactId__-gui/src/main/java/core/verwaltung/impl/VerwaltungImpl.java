#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.verwaltung.impl;

import ${package}.core.verwaltung.Verwaltung;
import ${package}.core.verwaltung.ausgabedaten.EintragDaten;
import ${package}.core.verwaltung.eingabedaten.NeuerEintrag;
import ${package}.persistence.verwaltung.dao.EintragDao;
import ${package}.persistence.verwaltung.entity.Eintrag;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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
