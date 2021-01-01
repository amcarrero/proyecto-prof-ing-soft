/**
 * 
 */

function sendUrl()
{
	var url = document.getElementById("url");
	var postBody='{ "mail":"'+ "" +'", "url": "'+url.value+'"}';
	var postUrl= "http://localhost:8080/petition";
	fetch(postUrl,{ 
	method: 'POST',body: postBody, headers:{
		'Content-Type': 'Application/Json'
	}
	})
	.then(response => response.json()) 
	.then(json => console.log(json))
	.catch(err => console.log(err));

}