export class Resource {
	user: User;
	menuItems: MenuItem[];
	permissions: Permission[]
}

resources: Resource = {
	user: {
			userId: "I1001", 
			role="STUDENT"
		},
	menuItems: [
		{ components: ["DashBoard", "Profile", "Locker", "Favorites"], category: "User" },	
		{ components: ["DashBoard", "ManageActivities", "Calendar", "Favorites"], category: "Activities" },
		{ components: ["DashBoard", "MakePayment", "Statements"], category: "Wallet" },
		{ components: ["DashBoard", "ManageLibrary", "Favorites"], category: "Library" },
		{ components: ["DashBoard", "ActivityReports", "Favorites"], category: "Resources" }
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