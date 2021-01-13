/**
 * http://usejsdoc.org/
 */
function sendEmail(){
	var email = document.getElementById("email");
	var psw = document.getElementById("psw");
	console.log(email);
	var postBody='{ "email":"'+ email.value+'", "pwd": "'+psw.value+'"}';
	var postUrl="http://localhost:8080/user";
	fetch(postUrl,{ 
		method: 'POST',body: postBody, headers:{
			'Content-Type': 'Application/Json'
		}
	})
	.then(response => response.json()) 
	.then(json => console.log(json))
	.catch(err => console.log(err));

	location.href='formulario-url';



}