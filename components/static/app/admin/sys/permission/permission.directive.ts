import {Directive, ElementRef, Renderer, Input} from 'angular2/core';

@Directive({
	selector: '[permCtrl]'	
})
export class PermissionDirective {
	@Input("permCtrl") elementId: String;

	constructor(elem: ElementRef, renderer: Renderer) {
		//renderer.setElementStyle(elem, "backgroundColor", "yellow");
		//renderer.setElementAttribute(elem, "innerHTML", "Voila");
		renderer.setElementProperty(elem, "innerHTML", "Voila");	
		//console.log(renderer.getElementProperty(elem, "namespaceURI"));	
		//console.log(elem.baseURI);	
		//console.log(elem);
		//console.log(renderer);

		/*try{
			console.log("inside try");
			throw new Error("error occured");
		} catch(e) {
			console.log(e);
		}*/
	}
}