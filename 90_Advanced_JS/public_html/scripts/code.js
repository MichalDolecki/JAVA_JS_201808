function student(nazw, imie, miasto, srednia) {
    this.imie = imie;
    this.nazwisko = nazw;
    this.miasto = miasto;
    this.srednia = srednia;
}

student.prototype.toString = function () {
    return this.nazwisko + " " + this.imie + " " + this.srednia;
};

var studenci = [];

studenci.push(new student("Kowalski", "Jan", "Warszawa", 4.34));
studenci.push(new student("Nowakowska", "Sylwia", "Babice", 3.87));
studenci.push(new student("Piskorski", "Piotr", "Kobyłka", 3.08));
studenci.push(new student("Abramski", "Paweł", "Dubienka", 4.57));
studenci.push(new student("Wójcik", "Stanisław", "Dubienka", 3.57));
studenci.push(new student("Biernacki", "Budziwoj", "Dubienka", 4.17));
studenci.push(new student("Aina", "Gwidon", "Babice", 4.57));
studenci.push(new student("Erki", "Jonatan", "Warszawa", 4.33));

function ArrayToString(html) {
    studenci.forEach(function (item, index) {
        html += (index + 1) + ". ";
        if (item.toString) {
            html += item.toString();
        } else {
            html += item;
        }
        html += "<br>";
    });
    html = html.slice(0, -4);
    return html;
}

// Wyświetlić listę studentów w pierwszym akapicie.
function printOrgTab() {
    document.getElementById("zad1").innerHTML = ArrayToString("STUDENCI<br><br>");
}
window.addEventListener("load", printOrgTab);

// Dwa przyciski i wyświetlenie w zad 2 listy studentów posortowanej wg średniej 
// rosnąco i malejąco. Sposób sortowania zależy od wciśniętego przycisku.
window.addEventListener("load", function () {
    document.getElementById("sortAscBtn").addEventListener("click", function () {
        studenci.sort(compareAsc);
        document.getElementById("zad2").innerHTML = ArrayToString("STUDENCI W KLEJNOŚCI OD NAJSŁABSZYCH<br><br>");
    });
    document.getElementById("sortDescBtn").addEventListener("click", function () {
        studenci.sort(compareDesc);
        document.getElementById("zad2").innerHTML = ArrayToString("STUDENCI W KLEJNOŚCI OD NAJLEPSZYCH<br><br>");
    });
});
function compareAsc(student1, student2) {
    return student1.srednia - student2.srednia;
}
function compareDesc(student1, student2) {
    return -compareAsc(student1, student2);
}

// Dodać pole input do wprowadzenia nazwy miasta i przefiltrować listę studentów
window.addEventListener("load", function () {
    document.getElementById("city").addEventListener("keyup", function () {
        var wybrani = studenci.filter(function (item) {
            return item.miasto.toLowerCase().indexOf(document.getElementById("city").value.toLowerCase()) !== -1;
        });
        var html = "WYBRANI STUDENCI<br><br>";
        wybrani.forEach(function (item, index) {
            html += (index + 1) + ". ";
            if (item.toString) {
                html += item.toString();
            } else {
                html += item;
            }
            html += " " + item.miasto + "<br>";
        });
        html = html.slice(0, -4);
        document.getElementById("zad3").innerHTML = html;
    });
});