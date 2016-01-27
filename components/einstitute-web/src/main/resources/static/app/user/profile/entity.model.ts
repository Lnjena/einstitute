import {COUNTRIES} from 'app/user/profile/data';

export enum Relation{FATHER, MOTHER, GUARDIAN};
export enum Type {PHONE, MOBILE, EMAIL, FAX, FACEBOOK, TWITTER};
export enum AddressType {HOME, RESIDENTIAL, BUSINESS, PERMANENT, RENTED, OFFICE};
export enum Religion {HINDU, MUSLIM, CHRISTIAN, BDHISM, SIKH, JAIN, JEWS, PARSI};
export enum Caste {GENERAL, SC, ST, OBC};

export class Entity{
	public _id: string;
	public entityType: string; 
	public orgCode: string;
	public extraPersonalDetails: ExtraPersonalDetails;
	public guarantors:Guarantor[];
	public addresses:Address[];
	public contacts: Contact[];
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
	public id: string;
	public idType: string;
	public personName: string;
	public issueAuthority: string;
	public issueDate: Date;
	public expiryDate: Date;
	public countryCode: string;
	constructor() {}
}

export class Address{
	public type: AddressType;
	public line1: string;
	public line2: string;
	public line3: string;
	public city: string;
	public province: string;
	public countryCode: string;
	public postCode: string;
	public allCountries: Country[] = COUNTRIES;
	constructor() {
		this.allCountries = COUNTRIES;
	}
}

export class Contact{
	public type: Type;
	public category: string;
	public details: string;
	public defaultContact: boolean;
	constructor() {}
}

export class ExtraPersonalDetails{
	public birthPlace: String;
	public religion:Religion;
	public caste:Caste;
	public subCaste:string;
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
	constructor(){}
	constructor(
		public orgCode: string,
		public name: string,
		ownerId: string,
		orgAddress: Address,
		activationDate?: Date = new Date(),
		renewalDate?: Date,
		primaryContact?: Contact,
		secondaryContacts?,
		childrenOrgCodes?: Array<String>
	){}
}

export class Country{
}

export class Religion{
}

export class Caste{
}

export class Nationality{
}

