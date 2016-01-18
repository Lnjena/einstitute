import {COUNTRIES} from 'app/user/profile/data';

export enum Relation{FATHER, MOTHER, GUARDIAN};
export enum Type {PHONE, MOBILE, EMAIL, FAX, FACEBOOK, TWITTER};
export enum AddressType {HOME, RESIDENTIAL, BUSINESS, PERMANENT, RENTED, OFFICE};
export enum Religion {HINDU, MUSLIM, CHRISTIAN, BDHISM, SIKH, JAIN, JEWS, PARSI};
export enum Caste {GENERAL, SC, ST, OBC};

export class Entity{
	public _id: String;
	public entityType: String; 
	public orgCode: String;
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

export class Identity{
	public id: String;
	public idType: String;
	public docId: String
	public personName: String;
	public issueAuthority: String;
	public issueDate: date;
	public expiryDate: date;
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

export class Organisation{
	public _id:String;
	public name:String;
	constructor() {}
}

export class Country{
}

export class Religion{
}

export class Caste{
}

export class Nationality{
}
