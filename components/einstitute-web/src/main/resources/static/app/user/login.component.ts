import {Component, Input} from 'angular2/core';
import {ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES, Router} from 'angular2/router';
import {BaseComponent} from 'app/common/base.component';
import {UserAuthenticationService} from 'app/user/user.service';
import {MenuComponent} from 'app/common/menu.component';
import {DashboardComponent} from 'app/common/dashboard.component';


@Component({
	selector: 'login-comp',
	templateUrl: 'app/user/login.view.html',
	providers: [UserAuthenticationService, ROUTER_PROVIDERS],
	directives: [ROUTER_DIRECTIVES, DashboardComponent]
})
export class LoginComponent extends BaseComponent {
	
	authenticationService: UserAuthenticationService;
	_router: Router;
	@Input() user; //: User = { userId: "", password: "", authenticated: false };
	
	constructor(authenticationService: UserAuthenticationService, _router: Router) {
		this.authenticationService = authenticationService;
		this._router = _router;
	}
	
	authenticate(user: User): boolean {
		if(this.authenticationService.authenticate(user)) {
			this.user.authenticated = true;
			
			console.log("login successful");
		}
	}
}