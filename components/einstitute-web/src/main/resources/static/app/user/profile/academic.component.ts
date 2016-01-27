import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Academic} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';

@Component({
	selector:'academic-comp',
	templateUrl: 'app/user/profile/academic.view.html'
})

export class AcademicComponent extends BaseComponent<Academic>{
	@Input() academicHistory: Academic[];
	academicModel:Academic;

	constructor() {
		this.academicModel=new Academic();
	}
	
	getModel(){
		return this.academicModel;
	}
	
	addItem(){
		var nextIndex=0;
		if(this.academicHistory.length>0){
			nextIndex=this.academicHistory.length;
		}
		this.academicHistory[nextIndex]=this.academicModel;
		this.academicModel=new Academic();
	}
}
