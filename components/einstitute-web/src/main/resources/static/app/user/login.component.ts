import {Component, Input} from 'angular2/core';
import {ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES, Router, RouteParams} from 'angular2/router';
import {BaseComponent} from 'app/common/base.component';
import {UserAuthenticationService} from 'app/user/user.service';
import {MenuComponent} from 'app/common/menu.component';
import {DashboardComponent} from 'app/common/dashboard.component';
import {User} from "app/user/user.model";


@Component({
	selector: 'login-comp',
	templateUrl: 'app/user/login.view.html',
	directives: [ROUTER_DIRECTIVES, DashboardComponent],
	providers: [UserAuthenticationService]
})
export class LoginComponent extends BaseComponent {

	@Input() user: User;

	constructor(private _authenticationService: UserAuthenticationService) {

	}
	
	authenticate(user: User): boolean {
		if(this._authenticationService.authenticate(user)) {
			user.authenticated = true;
			sessionStorage.setItem("user.authenticated", "true");
			sessionStorage.setItem("user.userId",user.userId);
			console.log("login successful");
			return true;
		}
	}
}