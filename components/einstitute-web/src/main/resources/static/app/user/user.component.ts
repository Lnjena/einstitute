import {bootstrap} from 'angular2/platform/browser';
import {Component, Input} from 'angular2/core';
import {BaseComponent} from 'app/common/base.component';
import {NgForm} from 'angular2/common';
import {User} from 'app/user/user.model';
import {RouteData} from 'angular2/router';

@Component({
	selector:'registration-comp',
	templateUrl: 'app/user/user.view.html'
})

export class UserRegistrationComponent extends BaseComponent<User>{
	
	showPasswordFields:Boolean;
	userModel: User;
	constructor(data: RouteData) {
		this.showPasswordFields=data.get('showPasswordFields');
		this.userModel = new User();
	}
}
