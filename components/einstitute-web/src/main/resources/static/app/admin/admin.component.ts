import {Component} from 'angular2/core';
import {BaseComponent} from 'app/common/base.component';
import {PermissionDirective} from 'app/admin/sys/permission/permission.directive';
import {RESTClient} from 'angular2-rest';

@Component({
	selector: 'admin-app',
	templateUrl: 'app/admin/admin.view.html',
	directives: [PermissionDirective]
})
export class AdminComponent extends BaseComponent {
	onClick(val: String) {
		console.log(val);
	}	
}