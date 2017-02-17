#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.persistence.verwaltung.entity;

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
