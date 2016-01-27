import {COUNTRIES} from 'app/user/profile/data';

export enum Relation{FATHER, MOTHER, GUARDIAN};
export enum Type {PHONE, MOBILE, EMAIL, FAX, FACEBOOK, TWITTER};
export enum AddressType {HOME, RESIDENTIAL, BUSINESS, PERMANENT, RENTED, OFFICE};
export enum Religion {HINDU, MUSLIM, CHRISTIAN, BDHISM, SIKH, JAIN, JEWS, PARSI};
export enum Caste {GENERAL, SC, ST, OBC};

export class Entity{
	public userId: String;
	public entityType: String; 
	public orgCode: String;
	public extraPersonalDetails: ExtraPersonalDetails;
	public guarantors:Guarantor[];
	public addresses:Address[];
	public contacts: Contact[];
	public academics: Academic[];
	public identities:Identity[];
	public organisation:Organisation; 
	constructor(){
		this.extraPersonalDetails = new ExtraPersonalDetails();
		this.organisation=new Organisation();
	}
}

export class EntityGroup {
	constructor(
		private _id: string,
		public groupName: string,
		public groupOwner: string,
		private _groupMembers: Array<string>,
		private validDate: Date,
		private creationDate?: Date
	) {}

	public addToGroup(entityId: string): Boolean {
		this._groupMembers.push(entityId);

		return true;
	}

	public removeFromGroup(): Boolean {
		return true;
	}
}

export class Identity{
	public id: String;
	public idType: String;
	public personName: String;
	public issueAuthority: String;
	public issueDate: Date;
	public expiryDate: Date;
	public countryCode: String;
	constructor() {}
}

export class Address{
	public type: AddressType;
	public line1: String;
	public line2: String;
	public line3: String;
	public city: String;
	public province: String;
	public countryCode: String;
	public postCode: String;
	public allCountries: Country[];
	constructor() {
		this.allCountries = COUNTRIES;
	}
}

export class Contact{
	public type: Type;
	public category: String;
	public details: String;
	public defaultContact: boolean;
	constructor() {}
}

export class ExtraPersonalDetails{
	public birthPlace: String;
	public religion:Religion;
	public caste:Caste;
	public subCaste:String;
	public nationality:String;
	constructor() {}
}

export class Guarantor{
	public refEntity:Entity;
	public relation:Relation;
	public primary:boolean;
	constructor() {
		this.refEntity=new Entity();
	}
}

export class Organisation {
	constructor() {
	}

	constructor(public orgCode:string,
				public name:string,
				ownerId:string,
				orgAddress:Address,
				activationDate?:Date = new Date(),
				renewalDate?:Date,
				primaryContact?:Contact,
				secondaryContacts?,
				childrenOrgCodes?:Array<String>) {
	}
}

export class Academic{
	public qualification:String;
	public institute: String;
	public grade: String;
	public year: Number;
	constructor() {
	}
}

export class Country{
}

export class Religion{
}

export class Caste{
}

export class Nationality{
}