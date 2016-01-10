import {bootstrap} from 'angular2/platform/browser';
import {Http, Response, Headers, HTTP_PROVIDERS} from 'angular2/http';
import {Component} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Entity,EntityHeader,Address} from 'app/entity.model';
import {BaseComponent} from 'app/main.component';
import {PersonalFormComponent} from 'app/personal.component';
import {AddressFormComponent} from 'app/address.component';
import {RegistrationService} from './registration.service';

@Component({
	selector:'entity-form',
	templateUrl: 'app/registration/user.registration.view.html',
	providers: [HTTP_PROVIDERS, RegistrationService],
	directives: [PersonalFormComponent, AddressFormComponent ]
})

export class UserRegistrationComponent extends BaseComponent {
	
	entityHeader:EntityHeader;
	address:Address;
	
	model:Entity;
	registrationService: RegistrationService;

	constructor(registrationService: RegistrationService) {
		console.log('loading registation');
		this.model = new Entity();
		this.entityHeader=new EntityHeader();
		this.address= new Address();
		this.registrationService=registrationService;
		/*obs = this.registrationService.getEntity('in.del.del.north.dps5657.2015.cls1.S1005');
		console.log(obs);
		obs.subscribe(res => {
			this.model = res.json();
			console.log(this.model);
			this.entityHeader = this.model.entityHeader;
			this.address = this.entityHeader.contactDetails.addresses[0];
	    });*/
	}
	
	onSubmit() {
		this.model._id='in.del.del.north.dps5657.2015.cls1.S1006';
		this.model.entityType='STUDENT';
		this.model.organisation._id='in.del.del.north.dps5657';
		this.model.entityHeader=this.entityHeader;
		this.model.entityHeader.contactDetails.addresses[0]=this.address
		console.log(this.model);
        this.registrationService.saveEntity(this.model);
	}
}