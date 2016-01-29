import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Address, Nationality} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';
import {CountryComponent} from 'app/user/profile/country.component';
import {Entity} from "./entity.model";
import {AddressType} from "./entity.model";
import {SimpleDropdownComponent} from "../../common/html.component";

@Component({
	selector:'address-form',
	templateUrl: 'app/user/profile/address.view.html',
	directives: [SimpleDropdownComponent]
})
export class AddressFormComponent extends BaseComponent<Address>{
	@Input() addressModel: Address;

	constructor() {
		if(this.addressModel == null) {
			this.addressModel = new Address();
			this.addressModel.type = AddressType.BUSINESS;
		}
	}

	getModel(){
		return this.addressModel;
	}
}
