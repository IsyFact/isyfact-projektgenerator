/*-
 * #%L
 * IsyFact-Projektgenerator
 * %%
 * Copyright (C) 2017 Bundesverwaltungsamt (BVA), msg systems ag
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
function ladeEintraege() {
    jQuery.ajax({
        type: "GET",
        url: "/eintrag",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, status, jqXHR) {
            $('#eintraege').empty();

            for (var i in data) {
                eintragAnzeigen(data[i].verfasser, data[i].text, data[i].datum);
            }
        },
        error: function (jqXHR, status) {
            alert(status);
        }
    });
}

function eintragAnzeigen(verfasser, text, datum) {
    var eintragText = document.createTextNode(text);
    var verfasserText = document.createTextNode(verfasser + ' - ' + datum);

    var textElement = document.createElement("eintrag");
    var verfasserElement = document.createElement("verfasser");

    textElement.appendChild(eintragText);
    verfasserElement.appendChild(verfasserText);

    var li = document.createElement("li");

    li.appendChild(textElement);
    li.appendChild(verfasserElement);

    jQuery('#eintraege').prepend(li);
}

function neuenEintragErstellen() {
    var verfasser = $('#verfasser_input').val();
    var text = $('#text_input').val();
    var jsonData= {"verfasser":verfasser, "text":text};

    jQuery.ajax({
        type: "POST",
        url: "/eintrag",
        data: JSON.stringify(jsonData),
        contentType: "application/json; charset=utf-8",
        success: function (data, status, jqXHR) {
            $('#verfasser_input').val('');
            $('#text_input').val('');
            ladeEintraege();
        },
        error: function (jqXHR, status) {
            alert(status);
        }
    });
}
