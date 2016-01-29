/*
	locker: {
		ownerId: "userId",
		lockerItems: [
			{itemName: "Degree Cert", itemRepository: "S3", itemReference: "http://se.aws.com/abc/def"},
			{},
			{}
		]
	}
*/


export class Locker {
	ownerId: String;
	createdDate: Date;
	lockerItems: LockerItem[];
}

export class LockerItem {
	itemName: String;
	itemRepository: String;
	itemReference: String;
	createdDate: Date;
	expiryDate: Date;
	owner: String;
	sharedBy: String;
	sharedWith: String[];
	lastAccessDate: Date;	
	lastAccessBy: String;
}