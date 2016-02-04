import {Http, Response, Headers, HTTP_PROVIDERS} from 'angular2/http';
import {Injectable} from 'angular2/core';
import	'rxjs/Rx';
import {User} from "./profile/entity.model";
import {ResourceGroup} from "./profile/entity.model";





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

	resources: ResourceGroup = {
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

	public getUserPermissions(user: User): ResourceGroup {
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
		this.http.post('/einstitute/entityProfiles', JSON.stringify(userForm.entity.profile,this.replacer),{headers:headers})
	    .map(res => res.json()).subscribe(
	    	      () => console.log('Profile save'));
		
		console.log("after save ================== ",userForm.entity.profile.profileId);
		this.http.post('/einstitute/entities', JSON.stringify(userForm.entity),{headers:headers})
	    .map(res => res.json()).subscribe(
	    	      () => console.log('Entity save'));
		
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
	
	replacer(key:string, value:string){
		if(key=='allCountries'){
			return undefined
		}
		return value;
	}

}

