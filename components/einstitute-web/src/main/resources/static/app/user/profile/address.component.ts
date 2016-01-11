import {bootstrap} from 'angular2/platform/browser';
import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Address} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';

@Component({
	selector:'address-form',
	templateUrl: 'app/user/profile/address.view.html'
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
