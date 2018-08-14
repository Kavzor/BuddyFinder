/**
 * Example usage of csrf verification
 */

var token = document.head.querySelector("meta[name='_csrf']").getAttribute("content");
var header = document.head.querySelector("meta[name='_csrf_header']").getAttribute("content");

get("http://localhost:8080/BuddyFinder/services/hello").headers([new Header(header, token)])
.response({
	success: function(data) {
		console.log(document.cookie)
		console.log(data);
	},
	failure: function() {
		console.log("invalid credentials");
	}
});
xhttp.setRequestHeader(header, token);


/*form("login").data({
	username: "test",
	password: "test",
})
.response({
	success: function(data) {
		console.log(document.cookie)
		console.log(data);
	},
	failure: function() {
		console.log("invalid credentials");
	}
});*/