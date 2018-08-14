/**
 * Currently under development and not used
 */

function Header(name, value) {
	this.name = name;
	this.value = value;
}

function Http(url, method) {
  this.url = url;
  this.xhttp = new XMLHttpRequest();
  this.method = method;
  this.params = '';
}

Http.prototype.data = function(data) {
	let arr = Object.keys(data);
	for(let index = 0; index < arr.length; index++) {
		let key = arr[index];
		this.params += key + "=" + data[key];
		
		if(index !== arr.length - 1) {
			this.params += "&";
		}
	}
	
	return this;
}

Http.prototype.headers = function(headers) {
	this.headers = headers;
	return this;
}

Http.prototype.response = function(response) {
	this.success = response.success;
	this.failure = response.failure;
	this.fetch();
}

Http.prototype.fetch = function() {
  this.xhttp.onreadystatechange = () => {
	  if(this.xhttp.readyState == 4) {
		  if(this.xhttp.status == 200) {
			this.success(this.xhttp);  
		  }
		  else if(this.xhttp.status == 403) {
			this.failure();
		  }
	  }
  };
  
  if(this.method === 'GET') {
	  this.url += "?" + this.params;
  }
  
  this.xhttp.open(this.method, this.url, true);
  if(this.headers !== undefined) {
	  this.headers.forEach(header => {
		  this.xhttp.setRequestHeader(header.name, header.value);
	  });
  }
  this.xhttp.setRequestHeader('timeout', 1000);
  console.log(this.params);
  if(this.method !== 'GET') {
	  this.xhttp.send(this.params);
  }
  else {
	  this.xhttp.send();  
  }
}

function get(url) {
    return new Http(url, "GET");
}

function post(url) {
	return new Http(url, "POST");
}