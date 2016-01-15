import {Component, Input} from 'angular2/core';
import {NgForm} from 'angular2/common';
import {Country, Address} from 'app/user/profile/entity.model';
import {BaseComponent} from 'app/common/base.component';

@Component({
	selector:'country-comp',
	template: `<select class="form-control">
			<option value="">Select Country</option>
			<option *ngFor="#item of countriesInput" [value]="item.alpha3_code">{{item.name}}</option>
		</select>`
})

export class CountryComponent extends BaseComponent<Country>{
	@Input countriesInput: Country[];

	constructor(){
		this.countriesInput = new Address().allCountries;
		console.log(this.countries);
	}
}
