import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Identity} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';

@Component({
	selector:'identity-form',
	templateUrl: 'app/user/profile/identity.view.html'
})

export class IdentityComponent extends BaseComponent<Identity>{
	@Input() identityDocs: Identity[];
	identityModel:Identity;

	constructor() {
		this.identityModel=new Identity();
	}
	
	getModel(){
		return this.identityModel;
	}
	
	addItem(){
		var nextIndex=0;
		if(this.identityDocs.length>0){
			nextIndex=this.identityDocs.length;
		}
		this.identityDocs[nextIndex]=this.identityModel;
		this.identityModel=new Identity();
	}
}
