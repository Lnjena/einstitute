import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {ExtraPersonalDetails} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';
import {Address} from "app/user/profile/entity.model";

@Component({
	selector:'extradetails-form',
	templateUrl: 'app/user/profile/extradetails.view.html'
})

export class ExtraDetailsComponent extends BaseComponent<Address>{
	@Input() extraDetailsModel;

	constructor() {

	}
	
	getModel(){
		return this.extraDetailsModel;
	}
}
