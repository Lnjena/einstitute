import {Component} from 'angular2/core';
import {ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES, LocationStrategy, HashLocationStrategy} from 'angular2/router';
import {BaseComponent} from 'app/common/base.component';
import {MenuComponent} from 'app/common/menu.component';
import {DashboardComponent} from 'app/common/dashboard.component';
import {User} from 'app/user/user.model';
import {LoginComponent} from 'app/user/login.component';
import {WalletComponent} from 'app/user/wallet/wallet.component';
import {LockerComponent} from 'app/user/locker/locker.component';
import {AdminComponent} from 'app/admin/admin.component';
import {UserRegistrationComponent} from 'app/user/user.component';
import {ProfileComponent} from 'app/user/profile/profile.component';
import {ActivityComponent, ListActivitiesComponent, ActivityMainComponent} from "./activity/activity.component";
import {Router} from "angular2/router";
import {OrderComponent} from "./order/order.component";
import {OrganisationComponent} from "./admin/core/manage/organisation.component";
import {OrganisationMenuComponent} from "./admin/core/manage/organisation.component";
import {LogoutComponent} from "./common/logout.component";
import {HomeComponent} from "./common/home.component";
import {METADATA} from "./metadata";

@Component({
	selector: 'ei-app',
	templateUrl: 'app/app.view.html',
    directives: [ROUTER_DIRECTIVES, LoginComponent, MenuComponent, ActivityComponent, UserRegistrationComponent]
})
@RouteConfig([
    { path: '/', name: 'AppComponent', component: App},
    { path: '/logout', name: 'LogoutComponent', component: LogoutComponent},
    { path: '/menu', name: 'MenuComponent', component: MenuComponent },
    { path: "/app/user/profile", name: "Profile", component: ProfileComponent, data: {showPasswordFields: false}},
    { path: '/activities/...', name: 'ActivitiesRoot', component: ActivityComponent },
    { path: '/activities/menu', name: 'ActivitiesMenu', component: ActivityMainComponent },
    { path: '/orders/menu', name: 'OrdersMenu', component: OrderComponent },
    { path: '/organisations/...', name: 'OrganisationRoot', component: OrganisationComponent },
    { path: '/organisations/menu', name: 'OrganisationMenu', component: OrganisationMenuComponent }
])
export class App extends BaseComponent {
    user: User = new User();
	constructor() {
        if(sessionStorage.getItem("user.authenticated") == "true") {
            this.user.authenticated = true;
        }
        else {
            this.user.authenticated = false;
        }
        
        this.viewMeta();
	}

    private viewMeta():void {
        console.log("Root", METADATA.rootComponents);
        console.log("Root", METADATA.auxilaryComponents);
    }
}


