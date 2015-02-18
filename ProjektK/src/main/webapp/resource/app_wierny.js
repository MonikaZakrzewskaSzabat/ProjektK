(function(){
	var app = angular.module('wierny', []);
	app.controller('UserController', function(){
		this.user=osoba;
	});
	app.controller('PriestController', function(){
		this.priest=ks;
	});
	app.controller('PanelController', function(){
		this.tab=1;
		
		this.selectTab = function(setTab){
		this.tab = setTab;
		};
		this.isSelected = function(checkTab){
		return this.tab === checkTab;
		};
	});
	app.controller("RateController", function(){
		this.rate ={};
		
		this.addRate = function(ksi) {
		ksi.rates.push(this.rate);
		this.rate = {};
	};
	});
	
	var osoba={ 
			name: 'Imie', 
			lastname: 'Nazwisko', 
			email: 'email',
			image: './pics/user.png',
			pofres: 'miejscowosc'
			};
			
	var ks= [
			{ 
				name: 'Imie', 
				lastname: 'Nazwisko', 
				city: 'Parafia',
				age: 30,
				active: true,  
				image: './pics/ojmat.jpg',
				rates: [
						{
							score: 4,
							body: "OK!",
							author: "joe@thomas.com"
						},
						{
							score: 1,
							body: "Nie lubie",
							author: "tim@hater.com"
						}
					]			
			},
			{ 
				name: 'Imie2', 
				lastname: 'Nazwisko', 
				city: 'Parafia',
				age: 40,
				active: true,  
				image: './pics/user.png',
				rates: [
						{
							score: 5,
							body: "Super!",
							author: "joe@thomas.com"
						},
						{
							score: 1,
							body: "Nie!",
							author: "tim@hater.com"
						}
					]			
			}
			];
			}
)();

