#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.verwaltung;

import ${package}.core.verwaltung.ausgabedaten.EintragDaten;
import ${package}.core.verwaltung.eingabedaten.NeuerEintrag;

import java.util.List;

public interface Verwaltung {

    EintragDaten neuerEintrag(NeuerEintrag neuerEintrag);

    List<EintragDaten> leseAlleEintraege();
}
