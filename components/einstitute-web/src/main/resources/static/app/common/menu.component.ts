import {bootstrap} from 'angular2/platform/browser';
import {Component} from 'angular2/core';
import {ROUTER_DIRECTIVES, Router} from 'angular2/router';
import {BaseComponent} from 'app/common/base.component';
import {DashboardComponent} from 'app/common/dashboard.component';
import {UserPermissionService} from 'app/user/user.service';
import {ResourceGroup} from "../user/profile/entity.model";
import {User} from "../user/profile/entity.model";

@Component({
	selector: 'menu-comp',
	templateUrl: 'app/common/menu.view.html',
	directives: [ROUTER_DIRECTIVES, DashboardComponent],
	providers: [UserPermissionService]
})
export class MenuComponent extends BaseComponent {
	resources: ResourceGroup;
	
	constructor(userPermissionService: UserPermissionService) {
		this.resources = <ResourceGroup>userPermissionService.getUserPermissions(new User());
	}
}
