export enum Relation{FATHER, MOTHER, GUARDIAN};
export enum Type {PHONE, MOBILE, EMAIL, FAX, FACEBOOK, TWITTER};
export enum AddressType {HOME, RESIDENTIAL, BUSINESS, PERMANENT, RENTED, OFFICE};
export enum Religion {HINDU, MUSLIM, CHRISTIAN, BDHISM, SIKH, JAIN, JEWS, PARSI};
export enum Caste {GENERAL, SC, ST, OBC};
export enum Nationality {INDIAN}; 


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

export class Identity{
	public id: string;
	public idType: string;
	public personName: string;
	public issueAuthority: string;
	public issueDate: date;
	public expiryDate: date;
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
	constructor() {}
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
	public nationality:Nationality;
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
	public _id:string;
	public name:string;
	constructor() {}
}
