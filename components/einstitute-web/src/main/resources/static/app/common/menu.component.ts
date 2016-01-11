import {bootstrap} from 'angular2/platform/browser';
import {Component} from 'angular2/core';
import {ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES, Router} from 'angular2/router';
import {BaseComponent} from 'app/common/base.component';
import {DashboardComponent} from 'app/common/dashboard.component';
import {UserPermissionService} from 'app/user/user.service';
import {Resource} from 'app/common/menu.model';

@Component({
	selector: 'menu-comp',
	templateUrl: 'app/common/menu.view.html',
	directives: [ROUTER_DIRECTIVES, DashboardComponent],
	providers: [ROUTER_PROVIDERS, UserPermissionService]
})
export class MenuComponent extends BaseComponent {
	_router: Router;
	resources: Resource;
	
	constructor(_router: Router, userPermissionService: UserPermissionService) {
		this._router = _router;
		this.resources = userPermissionService.getUserPermissions({});
	}
}

//bootstrap(MenuComponent);