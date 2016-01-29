export enum TransactionType {DEBIT, CREDIT};
export enum Status {CLEARING, PROCESSING, FAILED, SUCCESS};
export enum Medium {WALLET_TRANSFER, CREDIT_CARD, ONLINE_BANKING, MANUAL_TRANSFER};

export class Wallet {
	entityId: String;
	availableAmount: Number;
	transactionHistory: Transaction[];

	doTransaction(transaction: Transaction) {
		if(transaction.type == TransactionType.CREDIT) {
			console.log("Added");
		}
	}
}

export class Transaction {
	refCode: String;	
	amount: Number;
	type: TransactionType;
	startDate: Date;
	endDate: Date;
	status: Status;
	medium: Medium;
}