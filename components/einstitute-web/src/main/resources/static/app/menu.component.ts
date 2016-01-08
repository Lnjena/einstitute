import {Component} from 'angular2/core';
import {ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES, Router} from 'angular2/router';
import {BaseComponent} from './main.component';
import {DashboardComponent} from './dashboard.component';
//import {UserPermissionService} from './user.service';

@Component({
	selector: 'menu-comp',
	templateUrl: 'app/menu.view.html',
	directives: [ROUTER_DIRECTIVES, DashboardComponent],
	providers: [ROUTER_PROVIDERS]
})
/*@RouteConfig([
	{ path: "/user/dashboard", name: "UserDashboard", component: DashboardComponent },
	{ path: "/activities/dashboard", name: "ActivitiesDashboard", component: DashboardComponent },
	{ path: "/wallet/dashboard", name: "WalletDashboard", component: DashboardComponent },
	{ path: "/library/dashboard", name: "LibraryDashboard", component: DashboardComponent },
	{ path: "/reports/dashboard", name: "ReportsDashboard", component: DashboardComponent }
])*/
export class MenuComponent extends BaseComponent {
	_router: Router;
	resources: Resource = {
		user: {
				userId: "I1001"				
			},
		menuItems: [
			{ components: ["UserDashboard"], category: "User" },	
			{ components: ["ActivitiesDashboard"], category: "Activities" },
			{ components: ["WalletDashboard"], category: "Wallet" },
			{ components: ["LibraryDashboard"], category: "Library" },
			{ components: ["ReportsDashboard"], category: "Reports" }
		],
		permissions: [
			{
				component: "LoanedArticles", 
				elements: [
					{ elementId: "", permission: "" },
					{ elementId: "", permission: "" }
					{ elementId: "", permission: "" }
				]
			},
			{
				component: "SearchLibrary",
				elements: [
					{ elementId: "", permission: "" },
					{ elementId: "", permission: "" }
					{ elementId: "", permission: "" }
				]
			}
		]
	}
	
	constructor(_router: Router) {
		this._router = _router;
	}
}