import {Component} from "angular2/core";
import {Order, OrderItem, Item, ItemType, ItemProfile} from "./order.model";
import {OnDestroy} from "angular2/core";

var CART_KEY: String = "CART";
var ITEM: Item = new Item(
    ItemType.FOR_SALE,
    "123456",
    "1234",
    new ItemProfile("1234", "Cool Item", 12, 20, <Date>"20122014"),
    2000
);

@Component({
    selector: 'order-comp',
    templateUrl: 'app/order/order.view.html'
})
export class OrderComponent implements OnDestroy {

    VIEW_ID: String = "order";
    private _order: Order;
    orderItem: OrderItem = new OrderItem(ITEM);

    ngOnDestroy():any {
        //TODO orderService.saveOrder(this._order);
        console.log("Comp Destroyed");
        this.persistOrderToSessionStore();

        return undefined;
    }

    constructor() {
        console.log("Comp Initi");

        this._order = new Order("");
    }

    addToOrder(itemToAdd: OrderItem): Boolean {
        this._order.addItem(itemToAdd);
        return true;
    }

    removeFromOrder(item: String): Boolean {
        this._order.removeItem(item);
        this.persistOrderToSessionStore();
        return true;
    }

    completeOrder(): Boolean {
        //TODO orderService.completeOrder(this._order);
        this._order = new Order("");
        return true;
    }

    private persistOrderToSessionStore() {
        sessionStorage.setItem(CART_KEY, JSON.stringify(this._order));
    }
}