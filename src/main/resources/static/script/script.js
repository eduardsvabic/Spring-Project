var carObject = {
  "Ford": {

  	"Mondeo": ["Sedan", "Estate" ],
    "Focus": ["Hatchback", "Sedan", "Estate"],
    "Kuga": ["SUV"]    
  },
  "Skoda": {

    "Fabia": ["Hatchback", "Sedan", "Estate"],
    "Octavia": ["Sedan", "Estate" ],
    "Yeti" : ["SUV"] 
  },
   "Volkswagen": {

    "Golf": ["Hatchback", "Sedan", "Estate"],
    "Passat": ["Sedan", "Estate" ],
    "Touareg" : ["SUV"] 
  }
}
window.onload = function() {
  var makeSel = document.getElementById("make");
  var modelSel = document.getElementById("model");
  var bodyTypeSel = document.getElementById("bodyType");
  for (var x in carObject) {
    makeSel.options[makeSel.options.length] = new Option(x, x);
  }
  makeSel.onchange = function() {
    //empty Chapters- and Topics- dropdowns
    bodyTypeSel.length = 1;
    modelSel.length = 1;
    //display correct vlues
    for (var y in carObject[this.value]) {
      modelSel.options[modelSel.options.length] = new Option(y, y);
    }
  }
  modelSel.onchange = function() {
    //empty Chapters dropdown
    bodyTypeSel.length = 1;
    //display correct values
    var z = carObject[makeSel.value][this.value];
    for (var i = 0; i < z.length; i++) {
      bodyTypeSel.options[bodyTypeSel.options.length] = new Option(z[i], z[i]);
    }
  }
}

function f(){
	var e = document.getElementById("langSelect");
	var lang;
	var url
	if(e.value == 0){
		lang = '?lang=en';
	}
	else
	if(e.value == 1){
		lang = '?lang=ro';
	}
	else
	if(e.value == 2){
		lang = '?lang=de';
	}
	url = location.protocol + '//' + location.host + location.pathname;
	url = url + lang;
	window.location.replace(url);
}
