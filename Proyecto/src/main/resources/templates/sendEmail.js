/**
 * 
 */
function post(){
	var email = document.getElementById("email");
	var url = document.getElementById("url");
	var postBody='{ "email":'+ email+', url: '+url+'}';
	var obj = JSON.parse(postBody);
	var postUrl= "";
	fetch(postUrl,{ 
		method: 'POST',body: postBody, headers:{
    'Content-Type': 'application/json'
  }
	});
}
