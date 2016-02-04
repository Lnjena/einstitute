import {bootstrap} from 'angular2/platform/browser';
import {Http, Response, Headers, HTTP_PROVIDERS} from 'angular2/http';
import {Component, Input} from 'angular2/core';
import {BaseComponent} from 'app/common/base.component';
import {NgForm} from 'angular2/common';
import {RouteData} from 'angular2/router';
import {UserService} from 'app/user/user.service';
import {User} from "./profile/entity.model";

@Component({
	selector:'registration-comp',
	templateUrl: 'app/user/user.view.html',
	providers: [HTTP_PROVIDERS, UserService]
})

export class UserRegistrationComponent extends BaseComponent<User>{
	
	showPasswordFields:Boolean;
	userModel: User;
	userService:UserService;

	constructor(userService: UserService) {
		this.showPasswordFields = true;
		this.userModel = new User();
		
		this.userModel.entity.profile.contacts[0].type="EMAIL";
		this.userModel.entity.profile.contacts[1].type="MOBILE";
		this.userModel.entity.profile.contacts[2].type="PHONE";
		this.userService = userService;
	}

	constructor(data: RouteData, userService:UserService) {
		console.log('==================================== ',data.get('showPasswordFields'));
		this.showPasswordFields=data.get('showPasswordFields');
		//if(this.showPasswordFields)
		
		this.userModel = new User();
		this.userModel.entity.profile.contacts[0].type="EMAIL";
		this.userModel.entity.profile.contacts[1].type="MOBILE";
		this.userModel.entity.profile.contacts[2].type="PHONE";
		this.userService=userService;
		console.log('showPassword=',this.showPasswordFields);
		if(!this.showPasswordFields){
			obs = this.userService.getUser(sessionStorage.getItem('user.userId'));
			obs.subscribe(res => {
				this.userModel = res.json();
				console.log(res.json());
				console.log(sessionStorage.getItem('user.userId'));
				this.userModel.userId=sessionStorage.getItem('user.userId');
				console.log(this.userModel);
		    });
		}
		
	}
	
	onSubmit() {
        this.userService.createUser(this.userModel);
	}
}
