import {Http, Response, Headers, HTTP_PROVIDERS} from 'angular2/http';
import {Injectable} from 'angular2/core';
import {User} from 'app/user/user.model';
import {Resource} from 'app/common/menu.model';
import	'rxjs/Rx';





/*
	menuItems: [
			{ components: ["UserDashboard", "Locker"], category: "User" },
			{ components: ["ActivitiesDashboard"], category: "Activities" },
			{ components: ["WalletDashboard"], category: "Wallet" },
			{ components: ["LibraryDashboard"], category: "Library" },
			{ components: ["ReportsDashboard"], category: "Reports" },
			{ components: ["AdminDashboard"], category: "Admin" }
		]
*/

/*
	
*/

export class UserAuthenticationService {
	public authenticate(user: User): boolean {
		if(user.userId == "lnj@tcs.com" || user.userId == "arvindk@tcs.com") {
			return true;
		}
		return false;
	}
}

export class UserPermissionService {

	resources: Resource = {
		user: {
			userId: "I1001"
		},
		menuItems: [
            { components: ["Profile"], category: "User" },
			{ components: ["ActivitiesMenu"], category: "Activities" },
			{ components: ["OrdersMenu"], category: "Orders" },
			{ components: ["OrganisationMenu"], category: "Admin" }
		],
		permissions: [
			{
				component: "LoanedArticles",
				elements: [
					{ elementId: "", permission: "" },
					{ elementId: "", permission: "" },
					{ elementId: "", permission: "" }
				]
			},
			{
				component: "SearchLibrary",
				elements: [
					{ elementId: "", permission: "" },
					{ elementId: "", permission: "" },
					{ elementId: "", permission: "" }
				]
			}
		]
	}

	public getUserPermissions(user: User): Resource {
		return this.resources;
	}
}


@Injectable()
export class UserService{
	
	http:Http;

	constructor(http:Http) {
		this.http=http;
	}

	createUser(userForm:User){
		console.log(JSON.stringify(userForm));
		var headers = new Headers();
	    headers.append('Content-Type', 'application/json');
	    this.http.post('/einstitute/users', JSON.stringify(userForm),{headers:headers})
	    .map(res => res.json()).subscribe(
	    	      () => console.log('Registration Complete'));
		console.log('Success');
	    
	}
	
	getUser(userId:string){
		return this.http.get('/einstitute/users/'+userId);
	}

}

