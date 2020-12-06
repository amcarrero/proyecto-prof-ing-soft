/**
 * 
 */
function post(){
	var email = document.getElementById("email");
	var url = document.getElementById("url");
	var postBody='{ "mail":"'+ email.value+'", "url": "'+url.value+'"}';
	var postUrl= "/petition";
	fetch(postUrl,{ 
		method: 'POST',body: postBody, headers:{
    'Content-Type': 'Application/Json'
  }
	});
}
