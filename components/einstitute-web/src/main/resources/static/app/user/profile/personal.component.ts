import {bootstrap} from 'angular2/platform/browser';
import {Component, Input} from 'angular2/core';
import {BaseComponent} from 'app/common/base.component';
import {NgForm} from 'angular2/common';
import {EntityHeader} from 'app/user/profile/entity.model';

@Component({
	selector:'personal-form',
	templateUrl: 'app/user/profile/personal.view.html'
})

export class PersonalFormComponent extends BaseComponent<EntityHeader>{
	@Input() personalModel;
	constructor() {
		//this.personalModel = new EntityHeader();
	}
	
	getModel(){
		return this.personalModel;
	}
}
