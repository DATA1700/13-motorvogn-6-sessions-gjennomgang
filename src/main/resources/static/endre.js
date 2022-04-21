$(() => {
    // console.log(id);
    getOneRegistration();

    $("#change").on("click",() => {

        const registration = {
            id: id,
            ssn: $("#ssn").val(),
            name: $("#name").val(),
            address: $("#address").val(),
            characteristics: $("#characteristics").val(),
            brand: $("#chosenBrand").val(),
            type: $("#chosenType").val()
        }

        $.post("/api/changeOneRegistration", registration, () => {
            window.location.href = "/";
        });
    })

});

const id = window.location.search.substring(1);

const getOneRegistration = () => {
    $.get("/api/getOneRegistration?id=" + id, registration => {
        console.log(registration);
        $("#ssn").val(registration.ssn);
        $("#name").val(registration.name);
        $("#address").val(registration.address);
        $("#characteristics").val(registration.characteristics);
        $.ajaxSetup({async: false});
        $("#chosenBrand").val(registration.brand).change();
        $.ajaxSetup({async: true});
        $("#chosenType").val(registration.type);
    });
};