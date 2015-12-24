export class Resources {
	user: User;
	menuItems: MenuItem[];
	permissions: Permission[]
}

resources: Resources = {
	user: {userId: "I1001", role="STUDENT"},
	menuItems: [
		{ components: ["ViewProfile"], category: "Main" },	
		{ components: ["ActivitiesList", "ActivitiesHistory"], category: "Activities" },
		{ components: ["SearchLibrary", "LoanedArticles"], category: "Library" }
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