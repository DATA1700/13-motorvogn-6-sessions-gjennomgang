
function login(e) {
    e.preventDefault();

    let brukernavn = $("#brukernavn").val();
    let passord = $("#passord").val();

    $.post("/api/login", {
        brukernavn: brukernavn,
        passord: passord
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
