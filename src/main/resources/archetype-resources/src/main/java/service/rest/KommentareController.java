#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.rest;


import ${package}.core.verwaltung.Verwaltung;
import ${package}.core.verwaltung.ausgabedaten.EintragDaten;
import ${package}.core.verwaltung.eingabedaten.NeuerEintrag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eintrag")
public class KommentareController {

    private final Verwaltung verwaltung;

    @Autowired
    public KommentareController(Verwaltung verwaltung) {
        this.verwaltung = verwaltung;
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void erstelleEintrag(@RequestBody NeuerEintrag neuerEintrag) {
        verwaltung.neuerEintrag(neuerEintrag);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<EintragDaten> leseEintraege() {
        return verwaltung.leseAlleEintraege();
    }
}
