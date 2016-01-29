import {Component} from "angular2/core";
import {Router} from "angular2/router";

@Component({
    template: '',
})
export class LogoutComponent {
    constructor(_router: Router) {
        console.log("Logout Called");
        sessionStorage.setItem("user.authenticated", "false");
        _router.navigateByUrl("/#");
    }
}