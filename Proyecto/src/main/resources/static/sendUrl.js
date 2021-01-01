/**
 * 
 */
//var email = document.getElementById("email");

function sendUrl()
{var url = document.getElementById("url");
var postBody=/*'{ "mail":"'+ email.value+'", */'{"url": "'+url.value+'"}';
var postUrl= "http:/localhost:8080/petition";
fetch(postUrl,{ 
	method: 'POST',body: postBody, headers:{
		'Content-Type': 'Application/Json'
	}
});

}