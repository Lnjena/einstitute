import {bootstrap} from 'angular2/platform/browser';
import {Component, Input} from 'angular2/core';
import {BaseComponent} from 'app/common/base.component';
import {NgForm} from 'angular2/common';
import {User} from 'app/user/user.model';

@Component({
	selector:'registration-comp',
	templateUrl: 'app/user/user.view.html'
})

export class UserRegistrationComponent extends BaseComponent<User>{
	
	@Input showPasswordFields:Boolean;
	userModel: User;
	constructor() {
		this.userModel = new User();
		
	}
	
}
