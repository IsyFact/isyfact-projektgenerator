#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.persistence.verwaltung.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

@Converter(autoApply = true)
public class ZonedDateTimeAttributeConverter implements AttributeConverter<ZonedDateTime, Date> {

    private static final Calendar cal = Calendar.getInstance();

    @Override
    public Date convertToDatabaseColumn(ZonedDateTime zdt) {
        if (zdt != null) {
            cal.set(zdt.getYear(),
             zdt.getMonthValue() - 1,
                    zdt.getDayOfMonth(),
                    zdt.getHour(),
                    zdt.getMinute(),
                    zdt.getSecond());
            return cal.getTime();
        } else {
            return null;
        }
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Date sqlDate) {
        if (sqlDate != null) {
            cal.setTime(sqlDate);
            return ZonedDateTime.of(cal.get(Calendar.YEAR),
                                    cal.get(Calendar.MONTH) + 1,
                                    cal.get(Calendar.DAY_OF_MONTH),
                                    cal.get(Calendar.HOUR_OF_DAY),
                                    cal.get(Calendar.MINUTE),
                                    cal.get(Calendar.SECOND),
                                    0, // nanosecond
                                    ZoneId.of("Z"));
        } else {
            return null;
        }
    }
}
