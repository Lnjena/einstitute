import {Component, Template, bootstrap} from 'angular2/angular2';

// Annotation section
@Component({
	selector: 'my-app'
})

@Template({
	inline: '<h1>Hello {{ name }}</h1>'
})
// Component controller
class MyAppComponent {
	constructor() {
		this.name = 'World!';
	}
}
bootstrap(MyAppComponent);

/*(function(){
	var appComp = ng.Component({
		selector:'my-app',
		template:'<h1>My First Angular 2 App</h1>'
	}).Class({
		constructor:function(){}
	});
		

	document.addEventListener('DOMContentLoaded', function() {ng.bootstrap(appComp)});
})();*/


