

function registrer(e) {
    e.preventDefault()


    let brukernavn = $("#brukernavn").val();
    let passord = $("#passord").val();

    $.post("/api/registrer", {
        brukernavn: brukernavn,
        passord: passord,
        admin: 0
    }, function(data) {
        console.log(data);
        if (data === "") {
            window.location.href = "/";
        } else {
            $("#feilmelding").text(data.message);
        }
    }).fail(function(data) {
        $("#feilmelding").text(data.responseJSON.message);
    });
}
