export enum ActivityType {
	ROUTINE = "ABC", SUBSCRIPTION = "XYZ", CERTIFICATION = "DEF", REPORT = "CDE"
}

export class Activity {

	constructor( 
	    private  _id: String,
	    private ownerId: String,
	    private description: String,
	    private activityType: ActivityType,
	    private assignedGroupIds: Array<String>,
	    private activityOutput: ActivityType,
		private referenceActivityId?: String,
		public schedule?: Schedule,
		private payable?: Boolean,
	    private paymentId?: String
    ) {
		this.activityOutput = ActivityType.CERTIFICATION;
		/*for (act in ActivityType) {
			console.log("Enum:: ", act);
		}*/
	}
}

export class ActivityTracker {
	constructor(
		private activityId: String,
		private groupId: String,
		private entityId: String,
		private activityType: String,
		private runDate: Date,
		private runTime: Date,
		private orderRefId
	) {}

	get activityId(): String {
		return this.activityId;
	}
}

export enum FrequencyType {
	EVERY_WEEK_DAY, EVERY_DAY, WEEKLY, MONTHLY, QUARTERLY, HALF_YEARLY, YEARLY
}

export class Schedule {
	constructor(){}

	constructor(
		private _id: String,
		public description: String,
		public startDate: Date,
		private _lastDueDate: Date,
		private _nextDueDate: Date,
		public frequency: Frequency,
		public endDate?: Date,
		public recurrences?: Number
	) {}

	get id(): String {
		return this._id;
	}

	get lastDueDate(): Date {
		return this._lastDueDate;
	}

	get nextDueDate(): Date {
		return this._nextDueDate;
	}
}

export class Frequency {
	constructor(
		private frequencyType?: FrequencyType,
		private onDays?: Array<Number>,
		private onMonths?: Array<Number>
	) {}
}
