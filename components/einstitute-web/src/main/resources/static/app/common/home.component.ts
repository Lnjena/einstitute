
import {Component} from "angular2/core";
import {User} from "../user/user.model";

@Component({
    templateUrl: 'app/app.view.html'
})
export class HomeComponent {
    user: User = new User();
    constructor() {
        console.log("Inside Home");
        if(sessionStorage.getItem("user.authenticated") == "true") {
            console.log("Found Value")
            this.user.authenticated = true;
        }
        else {
            console.log("User Not Value")
            this.user.authenticated = false;
        }
    }
}