import {Http, Response, Headers, HTTP_PROVIDERS} from 'angular2/http';
import {Injectable} from 'angular2/core';
import {Entity} from 'app/entity.model';

@Injectable()
export class RegistrationService {
	http: Http;
	constructor(http: Http) {
	    this.http = http;
	}
	
	getEntity(entityId:string){
		return this.http.get('/einstitute/entities/'+entityId);
	}
	
	saveEntity(entityForm:Entity){
		console.log(JSON.stringify(entityForm));
		var headers = new Headers();
        headers.append('Content-Type', 'application/json');
		this.http.post('/einstitute/entities', JSON.stringify(entityForm),{headers:headers});
	}
}

