import {bootstrap} from 'angular2/platform/browser';
import {Http, Response, Headers, HTTP_PROVIDERS} from 'angular2/http';
import {Component} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Entity,EntityHeader,Address, ExtraPersonalDetails, Identity, Academic} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';
import {AddressFormComponent} from 'app/user/profile/address.component';
import {UserRegistrationComponent} from 'app/user/user.component';
import {ProfileService} from 'app/user/profile/profile.service';
import {ExtraDetailsComponent} from 'app/user/profile/extradetails.component';
import {IdentityComponent} from 'app/user/profile/identity.component';
import {AcademicComponent} from 'app/user/profile/academic.component';

@Component({
	selector:'profile-comp',
	templateUrl: 'app/user/profile/profile.view.html',
	providers: [HTTP_PROVIDERS, ProfileService],
	directives: [AddressFormComponent, UserRegistrationComponent, ExtraDetailsComponent, IdentityComponent, AcademicComponent]
})

export class ProfileComponent extends BaseComponent {
	
	address:Address;
	extraPersonalDetails:ExtraPersonalDetails;
	model:Entity;
	identityDocs:Identity[];
	profileService: ProfileService;
	showPasswordFields:Boolean;
	academicHistory:Academic[];

	constructor(profileService: ProfileService) {
		this.model = new Entity();
		this.address= new Address();
		this.extraPersonalDetails = new ExtraPersonalDetails();
		this.profileService=profileService;
		this.showPasswordFields=false;
		this.identityDocs=[];
		this.academicHistory=[];
		
		obs = this.profileService.getEntity(sessionStorage.getItem("user.userId"));
		//console.log(obs);
		if(obs!=null){
			obs.subscribe(res => {
				this.model = res.json();
				console.log(this.model);
				this.address = this.model.addresses[0];
				this.academics=this.model.academics;
				this.identities=this.model.identities;
				this.extraPersonalDetails=this.model.extraPersonalDetails;
		    });
		}
	}
	
	onSubmit() {
		this.model.userId=sessionStorage.getItem("user.userId");
		this.model.entityType='STUDENT';
		this.model.organisation._id='in.del.del.north.dps5657';
		this.model.addresses[0]=this.address;
		this.model.extraPersonalDetails=this.extraPersonalDetails;
		this.model.identities=this.identityDocs;
		this.model.academics=this.academicHistory;
		//console.log(this.model);
        this.profileService.saveEntity(this.model);
	}
}