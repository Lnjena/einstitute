import {bootstrap} from 'angular2/platform/browser';
import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {ExtraPersonalDetails} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';

@Component({
	selector:'extradetails-form',
	templateUrl: 'app/user/profile/extradetails.view.html'
})

export class ExtraDetailsComponent extends BaseComponent<Address>{
	@Input() extraDetailsModel;
	constructor() {
		this.extraDetailsModel = new ExtraPersonalDetails();
	}
	
	getModel(){
		return this.extraDetailsModel;
	}
}
