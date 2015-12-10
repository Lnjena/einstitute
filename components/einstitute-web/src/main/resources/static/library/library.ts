import {Component, View} from 'angular2/angular2'

@Component({
	selector: 'ei-library'
})
@View({
	template: '
			<h1>Library Page</h1>
		'
})
export class Library {
	constructor(libraryService : LibraryService) {
		
	}
}