import {Component} from 'angular2/core';
import {AddressFormComponent} from './app/address.component';

@Component({
	  selector: 'app',
	  template: '<address-form></address-form>',
	  directives: [AddressFormComponent]
})

export class AppComponent { }