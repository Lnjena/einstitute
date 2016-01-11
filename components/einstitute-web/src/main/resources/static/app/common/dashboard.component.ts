import {Component, Input} from 'angular2/core';
import {DashboardItem} from 'app/common/dashboard.model';

@Component({
	selector: 'dashboard-comp',
	templateUrl: 'app/common/dashboard.view.html'
})
export class DashboardComponent {
	//@Input() dashboardItems;	
	dashboardItems: DashboardItem[] = [
			{title: "A", content: "B", footer: "C" }, 
			{ title: "<h2>D</h2>", content: "<h2>E</h2>", footer: "F" }, 
			{ title: "H", content: "G", footer: "I" }
		];
}