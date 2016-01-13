import {User} from 'app/user/user.model';
import {Resource} from 'app/common/menu.model';

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
		if(user.userId == "lnj") {
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
			{ components: ["UserDashboard", "UserRegistration", "Locker","Profile"], category: "User" },
			{ components: ["ActivitiesDashboard"], category: "Activities" },
			{ components: ["WalletDashboard"], category: "Wallet" },
			{ components: ["LibraryDashboard"], category: "Library" },
			{ components: ["ReportsDashboard"], category: "Reports" },
			{ components: ["AdminDashboard"], category: "Admin" }
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