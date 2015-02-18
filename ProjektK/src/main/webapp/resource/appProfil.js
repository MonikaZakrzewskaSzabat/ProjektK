(function(){
	var app = angular.module('store',[]);
		//ustawienie danych profilu
	app.controller('StoreController', function(){
		this.person = gem;
		});
		

		
		
		//sprawdzanie wybranego tab
	app.controller('PanelController', function(){
		this.tab = 1;
		
		this.selectTab = function(setTab){
			this.tab = setTab;
			};
		this.isSelected = function (checkTab){
				return this.tab === checkTab;
			};
		});
		
		//sprawdzanie statusu
	app.controller('StatusController', function(){
		this.status = ' Niedostępny';
			
		this.selectStatus = function(setStatus){
				
			this.status = setStatus;
				};
		this.isActive = function (activeStatus){
			return this.status === activeStatus;
				};
			
		
		this.isSelected = function (checkStatus){
			if(checkStatus){
				newStatus = checkStatus;
				}
			else{
				newStatus = 'Niedostępny';
			}
				return this.status = newStatus;
			};
		});
		
		/**************************************************************************************************/

		//dane do profilu księdza
		var gem = {
			firstName: ' Imię',
			lastName: ' Nazwisko',
			age: ' Wiek',
			place: ' Parafia',
			city: ' Miejscowość',
			image: './pics/user.png',
		}
		

	
		})();