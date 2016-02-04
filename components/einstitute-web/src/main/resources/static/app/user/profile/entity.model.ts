import {COUNTRIES} from 'app/user/profile/data';
import {Entity} from "app/user/profile/entity.model";

export enum Relation{FATHER, MOTHER, GUARDIAN};
export enum Type {PHONE, MOBILE, EMAIL, FAX, FACEBOOK, TWITTER};
export enum AddressType {HOME = "HOME", RESIDENTIAL = "RESIDENTIAL", BUSINESS = "BUSINESS", PERMANENT = "PERMANENT", RENTED = "RENTED", OFFICE = "OFFICE"};

export class Country{
}

export class Nationality{
}

export class Religion {
	constructor(
		private name: string,
		private code: string
	){}
}

export class Caste {
	constructor(
		private name: string,
		private code: string
	){}
}

export class User {
	public userId: string;
	public password: string;
	public confirmPassword: string;
	public entityId: string;
	public entity: Entity;
	public assignableEntities: Array<string>;
	public tempAuthCode: string;
	public authenticated: boolean = false;
	constructor(){
		this.entity=new Entity();
	}
}

export class Entity {
	public entityId: string;
	public orgCode: string;
	public profileId: string;
	public profile: EntityProfile;
	public entityType: string;
	public active: Boolean;
	public organisation: Organisation;
	public role: Role;
	constructor(){
		this.profile=new EntityProfile();
		this.organization=new Organisation();		
	}
}

export class EntityProfile {
	public profileId: string;
	public extraPersonalDetails: ExtraPersonalDetails;
	public guarantors:Guarantor[];
	public addresses:Address[];
	public contacts: Contact[];
	public academics: Academic[];
	public identities: Identity[];
	public firstName: string;
	public middleName: string = "";
	public lastName: string;
	public birthDate: Date;
	constructor(){
		this.extraPersonalDetails=new ExtraPersonalDetails();
		this.guarantors=[];
		this.addresses=[];
		this.academics=[];
		this.identities=[];
		this.contacts=[new Contact(),new Contact(),new Contact()]
	}
	get fullName(): string {
		this.firstName + ' ' + this.middleName + ' ' + this.lastName;
	}
}

export class EntityGroup {
	constructor(
		private _id: string,
		public groupName: string,
		public groupOwner: Entity,
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

export class Identity {
	public id: String;
	public idType: String;
	public personName: String;
	public issueAuthority: String;
	public issueDate: Date;
	public expiryDate: Date;
	public countryCode: String;
	constructor() {}
}

export class Address {
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
		this.type = AddressType.HOME;
		this.allCountries = COUNTRIES;
	}
}

export class Contact {
	public type: Type;
	public category: String;
	public details: String;
	public defaultContact: boolean;
	constructor() {}
}

export class ExtraPersonalDetails {
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
	public orgCode: string;
	public orgName: string;
	ownerId: string;
	public orgAddress: Address = new Address();
	activationDate: Date = new Date();
	renewalDate: Date;
	primaryContact: Contact;
	secondaryContacts;
	childrenOrgCodes:Array<String>;

	constructor() {}
}

export class Academic {
	public qualification: string;
	public institute: string;
	public grade: string;
	public yearOfCompletion: Date;
	constructor() {}
}

export class Role {
	roleId: string;
	description: string;
	active: Boolean;
	permissions: Array<Permission>;
	resources: ResourceGroup;
}

export class ResourceGroup {
	constructor(
		menuItems: MenuItem[]
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
		grantedPermission: string,
		allowedPermissions?: Array<string>
	) {}
}
