#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.verwaltung.eingabedaten;

public class NeuerEintrag {
    private String verfasser;
    private String text;

    public NeuerEintrag() {
    }

    public NeuerEintrag(String verfasser, String text) {
        this.verfasser = verfasser;
        this.text = text;
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
}
