#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.verwaltung.ausgabedaten;

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
