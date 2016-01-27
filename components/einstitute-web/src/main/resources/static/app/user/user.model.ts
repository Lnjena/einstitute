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
	confirmPassword: String;
	firstName: String;
	midlleName: String;
	lastName: String;
	birthDate: Date;
	email: String;
	mobile: String;
	role: String;
	tempAuthCode: String;
	authenticated: boolean = false;
	
	public getFullName(){
		this.firstName+' '+this.lastName;
	}
}
