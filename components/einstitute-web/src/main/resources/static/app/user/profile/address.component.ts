import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Address, Nationality} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';
import {CountryComponent} from 'app/user/profile/country.component';

@Component({
	selector:'address-form',
	templateUrl: 'app/user/profile/address.view.html',
	directives:[CountryComponent]
})

export class AddressFormComponent extends BaseComponent<Address>{
	@Input addressInput: Address;
	addressModel: Address;
	constructor() {
		this.addressModel = new Address();
		console.log('countries========================',this.addressInput);
	}
	
	getModel(){
		return this.addressInput;
	}
}
