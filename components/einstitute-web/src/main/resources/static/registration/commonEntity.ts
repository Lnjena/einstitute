import {bootstrap, Component, View} from "angular2/angular2";
import {FORM_DIRECTIVES, ControlGroup, FormBuilder, Validators} from "angular2/angular2";
import { Inject} from 'angular2/angular2'
import {Http} from "angular2/angular2";

@Component({
	selector:'common-entity-form'
})

@View({
    templateUrl: './commonEntityForm.html',
    directives: [FORM_DIRECTIVES]
})

export class CommonEntityRegistration{
	form:ControlGroup;
	Constructor(fb:FormBuilder){
		this.form = fb.group({
		      firstName: ["",null],
		      lastName: ["",null]
		    });
		  }
	

	onSubmit(event){
		console.log('1234')
		console.log(this.form.controls.firstName);
		/*var path = '/einstitute/entities/';
		console.log(this.http.get(path));*/
	}
}


bootstrap(CommonEntityRegistration);