import {Component} from 'angular2/core';
import {ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';
import {LoginComponent} from './login.component';
import {MenuComponent} from './menu.component';
import {DashboardComponent} from './dashboard.component';
import {User} from './user.model';

@Component({
	selector: 'ei-app',
	templateUrl: 'app/app.view.html',
	directives: [ROUTER_DIRECTIVES, LoginComponent, MenuComponent],
	providers: [ROUTER_PROVIDERS]
})
@RouteConfig([
	{ path: "/home", name: "Main", component: LoginComponent },
	{ path: "/app", name: "Menu", component: MenuComponent },
	{ path: "/app/user/dashboard", name: "UserDashboard", component: DashboardComponent },
	{ path: "/app/activities/dashboard", name: "ActivitiesDashboard", component: DashboardComponent },
	{ path: "/app/wallet/dashboard", name: "WalletDashboard", component: DashboardComponent },
	{ path: "/app/library/dashboard", name: "LibraryDashboard", component: DashboardComponent },
	{ path: "/app/reports/dashboard", name: "ReportsDashboard", component: DashboardComponent }
])
export class App {
	user: User = { userId: "", password: "", authenticated: false };
}