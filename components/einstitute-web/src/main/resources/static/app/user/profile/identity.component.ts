import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Identity} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';

@Component({
	selector:'identity-form',
	templateUrl: 'app/user/profile/identity.view.html'
})

export class IdentityComponent extends BaseComponent<Identity>{
	@Input() identityModel: Identity;

	constructor() {	}
	
	getModel(){
		return this.identityModel;
	}
}
