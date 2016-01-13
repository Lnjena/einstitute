import {bootstrap} from 'angular2/platform/browser';
import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Address, Nationality} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';

@Component({
	selector:'address-form',
	templateUrl: 'app/user/profile/address.view.html'
})

export class AddressFormComponent extends BaseComponent<Address>{
	@Input() addressModel;
	nationality: Nationality;
	constructor() {
		this.addressModel = new Address();
		this.nationality= new Nationality();
		for(n in this.nationality){
			console.log(n);
		}
	}
	
	getModel(){
		return this.addressModel;
	}
}
