#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.persistence.verwaltung.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Eintrag {

    @Id
    @GeneratedValue
    private Long id;

    private String verfasser;

    @Lob
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
