function WriteCookie() {
	var cookievalue = escape(document.loginform.email.value) + ';';
	document.cookie = 'email=' + cookievalue;
}

function hideLogin(){
	var allcookies = document.cookie;
	cookiearray = allcookies.split(';');
	// Now take key value pair out of this array
	for(var i=0; i<cookiearray.length; i++){
		name = cookiearray[i].split('=')[0];
		value = cookiearray[i].split('=')[1];
	}
	if ((value !== "") && (name == "email") )
		document.getElementById("Login").style.visibility = "hidden";
}

window.onload = hideLogin();

function ReadCookie(){
	document.cookie = 'email' + '=; expires=Thu, 01-Jan-70 00:00:01 GMT;';
}

function hideLogout(){
	var allcookies = document.cookie;
	cookiearray = allcookies.split(';');
	// Now take key value pair out of this array
	for(var i=0; i<cookiearray.length; i++){
		name = cookiearray[i].split('=')[0];
		value = cookiearray[i].split('=')[1];
	}
	if (name !== "email")
		document.getElementById("Logout").style.visibility = "hidden";
}

window.onload = hideLogout();