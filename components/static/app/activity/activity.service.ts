

import {Http} from "angular2/http";
export class ActivityService {
    constructor(private _http: Http) {
        this._http.post("", "").map(res => res.json())
            .subscribe(
                data => this.saveJwt(data.id_token),
                err => this.logError(err),
                () => console.log('Authentication Complete')
            );
    }
}