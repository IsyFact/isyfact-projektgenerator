#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.verwaltung.ausgabedaten;

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
