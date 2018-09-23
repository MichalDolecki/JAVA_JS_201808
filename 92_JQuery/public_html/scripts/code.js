window.addEventListener("load", function(){
    document.getElementById("myImg").addEventListener("click", function (){
        $('#myImg').animate({width: nextWidth}, 1000);
        $('#imgDiv').animate({width: nextWidth}, 1000);
        nextWidth = nextWidth === 400 ? 200 : 400;
    });
});

var nextWidth = 400;

$.getJSON("ulubione.json", function (data) {
    var text = "";
    $.each(data, function (key) {
        text += '<h3>' + key + '</h3>';
        text += '<div><ul>';
        data[key].forEach(function (item) {
            text += '<li>' + item + '</li>';
        });
        text += '</ul></div>';
    });
    $("#accordion").append(text);
    $(function () {
        $("#accordion").accordion();
    });
});
