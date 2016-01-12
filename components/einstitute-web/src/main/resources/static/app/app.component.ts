import {Component} from 'angular2/core';
import {ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES, LocationStrategy, HashLocationStrategy} from 'angular2/router';
import {BaseComponent} from 'app/common/base.component';
import {MenuComponent} from 'app/common/menu.component';
import {DashboardComponent} from 'app/common/dashboard.component';
import {User} from 'app/user/user.model';
import {LoginComponent} from 'app/user/login.component';
import {WalletComponent} from 'app/user/wallet/wallet.component';
import {LockerComponent} from 'app/user/locker/locker.component';
import {AdminComponent} from 'app/admin/admin.component';
import {UserRegistrationComponent} from 'app/user/user.component';


@Component({
	selector: 'ei-app',
	templateUrl: 'app/app.view.html',
	directives: [ROUTER_DIRECTIVES, LoginComponent, MenuComponent]
})
@RouteConfig([
	{ path: "/login", name: "Home", component: LoginComponent },
	{ path: "/app", name: "Menu", component: MenuComponent },
	{ path: "/app/admin", name: "AdminDashboard", component: AdminComponent },
	{ path: "/app/user/dashboard", name: "UserDashboard", component: DashboardComponent },
	{ path: "/app/user/locker", name: "Locker", component: LockerComponent },
	{ path: "/app/user/registration", name: "UserRegistration", component: UserRegistrationComponent, data: {showPasswordFields:true} },
	{ path: "/app/activities/dashboard", name: "ActivitiesDashboard", component: DashboardComponent },
	{ path: "/app/wallet/dashboard", name: "WalletDashboard", component: WalletComponent },
	{ path: "/app/library/dashboard", name: "LibraryDashboard", component: DashboardComponent },
	{ path: "/app/reports/dashboard", name: "ReportsDashboard", component: DashboardComponent }
])
export class App extends BaseComponent {
	user: User;

	constructor() {
		this.user = new User();
		if(sessionStorage.getItem("user.authenticated")) {
			this.user.authenticated = true;
		}
	}
}