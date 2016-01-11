import {bootstrap} from 'angular2/platform/browser';
import {Component, Input} from 'angular2/core';
import {BaseComponent} from './main.component';
import {NgForm} from 'angular2/common';
import {Address} from './entity.model';


@Component({
	selector:'address-form',
	templateUrl: 'app/address.view.html'
})

export class AddressFormComponent extends BaseComponent<Address>{
	@Input() addressModel;
	constructor() {
		this.addressModel = new Address();
	}
	
	getModel(){
		return this.addressModel;
	}
}
