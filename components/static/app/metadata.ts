import {Router} from "angular2/router";
import {LogoutComponent} from "./common/logout.component";
import {MenuComponent} from "./common/menu.component";
import {ProfileComponent} from "./user/profile/profile.component";
import {ActivityComponent} from "./activity/activity.component";
import {ActivityMainComponent} from "./activity/activity.component";
import {OrderComponent} from "./order/order.component";
import {OrganisationComponent} from "./admin/core/manage/organisation.component";
import {OrganisationMenuComponent} from "./admin/core/manage/organisation.component";
import {RouteDefinition} from "angular2/router";
import {CreateActivityComponent} from "./activity/activity.component";
import {ListActivitiesComponent} from "./activity/activity.component";
import {ViewActivityDetailsComponent} from "./activity/activity.component";
import {Route} from "angular2/router";
import {Permission} from "./common/menu.model";



class Metadata {
    public rootCategories: Array<string>;
    public rootComponents: Array<RouteDefinition>;
    public auxilaryComponents: {[key: string]: Array<RouteDefinition>;} = {};
    public componentPermissions: {[key: string]: Array<Permission>;} = {};

    constructor() {
        //RouteDefinition def = new RouteDefinition()
    }
}

export var METADATA: Metadata = new Metadata();

METADATA.rootCategories = ["USER", "ACTIVITY", "ADMIN", "LIBRARY", "ORDER"];

METADATA.rootComponents = [
    { path: '/logout', name: 'LogoutComponent', component: LogoutComponent },
    { path: '/menu', name: 'MenuComponent', component: MenuComponent },
    { path: "/app/user/profile", name: "Profile", component: ProfileComponent, data: {showPasswordFields: false}},
    { path: '/activities/...', name: 'ActivitiesRoot', component: ActivityComponent },
    { path: '/activities/menu', name: 'ActivitiesMenu', component: ActivityMainComponent },
    { path: '/orders/menu', name: 'OrdersMenu', component: OrderComponent },
    { path: '/organisations/...', name: 'OrganisationRoot', component: OrganisationComponent },
    { path: '/organisations/menu', name: 'OrganisationMenu', component: OrganisationMenuComponent }
];

METADATA.auxilaryComponents["ActivitiesRoot"] = [
    { path: '/menu', name: 'ActivityMain', component: ActivityMainComponent },
    { path: '/new', name: 'CreateActivity', component: CreateActivityComponent },
    { path: '/list', name: 'ListActivities', component: ListActivitiesComponent },
    { path: '/details/:id', name: 'ViewActivityDetails', component: ViewActivityDetailsComponent }
];

METADATA.componentPermissions['MenuComponent'] = [
    {elementId: "", allowedPermissions: ["", "", ""]},
    {elementId: "", allowedPermissions: ["", "", ""]},
    {elementId: "", allowedPermissions: ["", "", ""]}
];

