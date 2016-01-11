/*
	user: {
		userId: "",
		password: "",
		locker: {},
		wallet: {},
		profile: {Entity},
		roles: [],
		preferences: {
			defaultLang:
			defaultOrg: {defaultRole:}
		}
	}

	permission: {
		
	}
*/
export class User {
	userId: String;
	password: String;
	role: String;
	authenticated: Boolean = false;
}
