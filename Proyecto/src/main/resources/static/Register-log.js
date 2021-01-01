/**
 * http://usejsdoc.org/
 */
function sendEmail(){
	var email = document.getElementById("email");
	var psw = document.getElementById("psw");
	console.log(email);
	var postBody='{ "email":"'+ email.value+'", "pwd": "'+psw.value+'"}';
	var postUrl="http://localhost:8080//formulario-url";
	fetch(postUrl,{ 
		method: 'POST',body: postBody, headers:{
			'Content-Type': 'Application/Json'
		}
	}).catch(error=> console.error("error :",error))
	.then(response => console.log('Success :', response)); 

	location.href='formulario-url';



}