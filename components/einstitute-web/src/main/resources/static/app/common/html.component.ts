import {BaseComponent} from 'app/common/base.component';
import {Component} from "angular2/core";

@Component({
    selector: 'ing-dropdown',    
    template: `
        <select> 
            <option *ngFor="#country in data" [value]="country[]"></option>
        </select>
    `,
    inputs: []
})
export class SimpleDropdownComponent extends BaseComponent {
    data:String[];

    constructor() {
        this.data["IND"] = "INDIA";
        this.data["GBR"] = "UK";
    }
}