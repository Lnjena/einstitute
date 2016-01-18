import {bootstrap} from 'angular2/platform/browser';
import {Http, Response, Headers, HTTP_PROVIDERS} from 'angular2/http';
import {Component} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Entity,EntityHeader,Address, ExtraPersonalDetails, Identity} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';
import {AddressFormComponent} from 'app/user/profile/address.component';
import {UserRegistrationComponent} from 'app/user/user.component';
import {ProfileService} from 'app/user/profile/profile.service';
import {ExtraDetailsComponent} from 'app/user/profile/extradetails.component';
import {IdentityComponent} from 'app/user/profile/identity.component';

@Component({
	selector:'profile-comp',
	templateUrl: 'app/user/profile/profile.view.html',
	providers: [HTTP_PROVIDERS, ProfileService],
	directives: [AddressFormComponent, UserRegistrationComponent, ExtraDetailsComponent, IdentityComponent]
})

export class ProfileComponent extends BaseComponent {
	
	address:Address;
	extraPersonalDetails:ExtraPersonalDetails;
	model:Entity;
	identityModel:Identity;
	profileService: ProfileService;
	showPasswordFields:Boolean;

	constructor(profileService: ProfileService) {
		this.model = new Entity();
		this.address= new Address();
		console.log("Profile View", this.address.allCountries);
		this.extraPersonalDetails = new ExtraPersonalDetails();
		this.profileService=profileService;
		this.showPasswordFields=false;
		this.identityModel= new Identity();
		/*obs = this.profileService.getEntity('in.del.del.north.dps5657.2015.cls1.S1005');
		console.log(obs);
		obs.subscribe(res => {
			this.model = res.json();
			console.log(this.model);
			this.entityHeader = this.model.entityHeader;
			this.address = this.entityHeader.contactDetails.addresses[0];
	    });*/
	}
	
	onSubmit() {
		this.model._id='in.del.del.north.dps5657.2015.cls1.S1001';
		this.model.entityType='STUDENT';
		this.model.organisation._id='in.del.del.north.dps5657';
		this.model.addresses[0]=this.address;
		console.log(this.model);
        this.profileService.saveEntity(this.model);
	}
}