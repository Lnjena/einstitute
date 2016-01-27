import {bootstrap} from 'angular2/platform/browser';
import {Http, Response, Headers, HTTP_PROVIDERS} from 'angular2/http';
import {Component, Input} from 'angular2/core';
import {BaseComponent} from 'app/common/base.component';
import {NgForm} from 'angular2/common';
import {User} from 'app/user/user.model';
import {RouteData} from 'angular2/router';
import {UserService} from 'app/user/user.service';

@Component({
	selector:'registration-comp',
	templateUrl: 'app/user/user.view.html',
	providers: [HTTP_PROVIDERS, UserService]
})

export class UserRegistrationComponent extends BaseComponent<User>{
	
	showPasswordFields:Boolean;
	userModel: User;
	userService:UserService;
	constructor(data: RouteData, userService:UserService) {
		this.showPasswordFields=data.get('showPasswordFields');
		
		this.userModel = new User();
		this.userService=userService;
		if(!this.showPasswordFields){
			obs = this.userService.getUser(sessionStorage.getItem('user.userId'));
			obs.subscribe(res => {
				this.userModel = res.json();
				this.userModel.userId=sessionStorage.getItem('user.userId');
				console.log(this.userModel);
		    });
		}
		
	}
	
	onSubmit() {
        this.userService.createUser(this.userModel);
	}
}
