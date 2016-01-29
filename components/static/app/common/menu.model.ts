/*export class Resource {
	constructor(
		user: User,
		menuItems: MenuItem[],
		permissions: Permission[]
	) {}
}

export class MenuItem {
	constructor(
		components: Array<String>,
		category: String
	) {}
}

export class Permission {
	constructor(
		elementId: string,
		allowedPermissions: Array<string>,
		grantedPermission: string
	) {}
}*/

import {ResourceGroup} from "../user/profile/entity.model";

resources: ResourceGroup = {
	menuItems: [
		{ components: ["DashBoard", "Profile", "Locker", "Favorites"], category: "User" },	
		{ components: ["DashBoard", "ManageActivities", "Calendar", "Favorites"], category: "Activities" },
		{ components: ["DashBoard", "MakePayment", "Statements"], category: "Wallet" },
		{ components: ["DashBoard", "ManageLibrary", "Favorites"], category: "Library" },
		{ components: ["DashBoard", "ActivityReports", "Favorites"], category: "Resources" }
	]
}