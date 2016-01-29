
export enum ItemType { FOR_RENT, FOR_SALE }

export class ItemProfile {
   constructor(
        barCode: String,
        public description: String,
        quantityAvailable: Number,
        quantityTotal: Number,
        availableDate: Date
   ) {}
}

export class Item {
    constructor(
        itemType: ItemType,
        itemCode: String,
        itemBarCode: String,
        public itemProfile: ItemProfile,
        basePrice: Number,
        discountRules?: Array<any>,
        pricingRules?: Array<any>
    ) {}
}

export class ItemTracker {
    constructor(
        itemCode: String,
        issueDate: Date,
        issuedTo: String,
        issuedBy: String,
        returnDate: Date,
        actualReturnDate: Date
    ) {}
}

export enum OrderStatus {ORDERED, DELIVERED}

export class OrderItem {
    constructor(
        public item: Item,
        public quantity?: Number,
        private discountRules?: Array<any>) {
        if(this.quantity == 0 || this.quantity == null) {
            this.quantity = 1;
        }
    }
}

export class Order {
    constructor(private _orderId: String ) {
        this._orderItems = [];
    }

    constructor(
        private _orderId: String,
        private _orderItems: Array<OrderItem>,
        private grossAmount: Number,
        private netAmount: Number
    ) {}

    public addItem(item: OrderItem): Boolean {
        this._orderItems.push(item);
        return true;
    }

    removeItem(itemCode: String): Boolean {
        return true;
    }

    get orderItems(): Array<OrderItem> {
        return this._orderItems;
    }
}

export class OrderTracker {
    constructor(
        private _orderId: String,
        private _orderDate: Date,
        private _paymentRefId: String,
        private _orderedBy: String,
        public orderStatus: OrderStatus
    ) {}
}