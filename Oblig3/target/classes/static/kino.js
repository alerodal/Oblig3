$(function (){
    setKinoBilletter();
});


let billettArray = [];

function kjopBillett() {
    let film = document.getElementById("film").value;
    let antall = document.getElementById("antall").value;
    let fornavn = document.getElementById("fornavn").value;
    let etternavn = document.getElementById("etternavn").value;
    let telefonnr = document.getElementById("telefonnr").value;
    let epost = document.getElementById("epost").value;

    let isValid = true;

    const tlfNrRegex = /^\d{3}[\s-]?\d{2}[\s-]?\d{3}$/;
    const epostRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (film == "velg") {
        document.getElementById("filmError").innerHTML = "Må velge en film";
        isValid = false;
    } else if(film == ""){
        document.getElementById("filmError").innerHTML = "Må velge en film";
        isValid=false;
    } else{
        document.getElementById("filmError").innerHTML="";
    }

    if (antall == "") {
        document.getElementById("antallError").innerHTML = "Må velge antall";
        isValid = false;
    } else if (Number(antall) >= 1) {
        document.getElementById("antallError").innerHTML = "";
    } else {
        document.getElementById("antallError").innerHTML = "Antall må være gyldig"
    }

    if (fornavn == "") {
        document.getElementById("fornavnError").innerHTML = "Må skrive inn fornavn"
        isValid = false;
    } else {
        document.getElementById("fornavnError").innerHTML = "";
    }

    if (etternavn == "") {
        document.getElementById("etternavnError").innerHTML = "Må skrive inn etternavn";
        isValid = false;
    } else {
        document.getElementById("etternavnError").innerHTML = "";
    }

    if (telefonnr == "") {
        document.getElementById("telefonError").innerHTML = "Skriv inn telefonnr";
        isValid = false;
    } else if (!tlfNrRegex.test(telefonnr)) {
        document.getElementById("telefonError").innerHTML = "Skriv inn gyldig telefonnr";
        isValid = false;
    } else {
        document.getElementById("telefonError").innerHTML = "";
    }


    if (epost === "") {
        document.getElementById("epostError").innerHTML = "Må skrive noe inn i epost";
        isValid = false;
    } else if (!epostRegex.test(epost)) {
        document.getElementById("epostError").innerHTML = "Skriv inn gyldig epost";
        isValid = false;
    } else {
        document.getElementById("epostError").innerHTML = "";
    }

    if (!isValid) {
        return;
    }


    const billett = {
        film : film,
        antall : antall,
        fornavn : fornavn,
        etternavn : etternavn,
        telefonnr : telefonnr,
        epost : epost
    };

    $.post("/lagreBilletter", billett, function (){
        setKinoBilletter();
    });


    $("#film").val("");
    $("#antall").val("");
    $("#fornavn").val("");
    $("#etternavn").val("");
    $("#telefonnr").val("");
    $("#epost").val("");

}

function setKinoBilletter() {
    $.get("/hentBilletter", function (billett) {
        formaterBillett(billett)
    });

    function formaterBillett(billett){
        let ut = "<table class='table table-striped'>"+"<tr><th>Film</th><th>Antall</th><th>Fornavn</th><th>Etternavn</th><th>Telefonnr</th><th>Epost</th></tr>";
        for (const personInfo of billett) {
            ut += "<tr>";
            ut += "<td>" + personInfo.film + "</td><td>" + personInfo.antall + "</td><td>" + personInfo.fornavn + "</td><td>" + personInfo.etternavn + "</td><td>" + personInfo.telefonnr + "</td><td>" +
                personInfo.epost + "</td>";
            ut += "</tr>";
        }
        document.getElementById("ut").innerHTML = ut;
    }
}

function slettBillett(){
    $.get("/slett", function (){
        setKinoBilletter();
    });
}
