function ladeEintraege() {
    $.ajax({
        type: "GET",
        url: "eintrag",
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
    var verfasserText = document.createTextNode(verfasser + ' am ' + $.format.toBrowserTimeZone(datum, "dd.MM.yyyy") + ' um ' + $.format.toBrowserTimeZone(datum, "HH:mm:ss"));

    var textElement = document.createElement("eintrag");
    var verfasserElement = document.createElement("verfasser");

    textElement.appendChild(eintragText);
    verfasserElement.appendChild(verfasserText);

    var li = document.createElement("li");

    li.appendChild(textElement);
    li.appendChild(verfasserElement);

    $('#eintraege').prepend(li);
}

function neuenEintragErstellen() {
    var verfasser = $('#verfasser_input').val();
    var text = $('#text_input').val();
    var jsonData= {"verfasser":verfasser, "text":text};

    $.ajax({
        type: "POST",
        url: "eintrag",
        data: JSON.stringify(jsonData),
        contentType: "application/json; charset=utf-8",
        success: function (data, status, jqXHR) {
            $('#verfasser_input').val('');
            $('#text_input').val('');
            ladeEintraege();
        },
        error: function (response, status, error) {
            var error = JSON.parse(response.responseText);
            alert(error.message);
        }
    });
}
