window.addEventListener("load", function() {
  document.getElementById("cookie").innerHTML = document.cookie;
  var cookieStrings = document.cookie.split(";");
  var cookies = {};
  for (var i = 0; i < cookieStrings.length; i++) {
    var rawCookie = cookieStrings[i].trim().split("=");
    cookies[rawCookie[0]] = rawCookie[1];
    console.log(rawCookie[0] + " --> " + rawCookie[1]);
  }
  nameElement = document.getElementById("name");
  valElement = document.getElementById("value");
});

var nameElement;
var valElement;
function setCookie() {
  document.cookie = nameElement.value + "=" + valElement.value;
  nameElement.value = "";
  valElement.value = "";
}
function deleteCookie(name){
  document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:01 GMT;";
}
function reload(){
    location.reload();
}
function clearCookie() {
  deleteCookie(nameElement.value);
}
function clearAllCookies() {
  var cookieStrings = document.cookie.split(";");
  for (var i = 0; i < cookieStrings.length; i++) {
    deleteCookie(cookieStrings[i].trim().split("=")[0]);
  }
}

// DRY