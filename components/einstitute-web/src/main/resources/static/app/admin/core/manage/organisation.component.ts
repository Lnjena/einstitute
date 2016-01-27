import {Component} from "angular2/core";
import {Http, HTTP_PROVIDERS} from "angular2/http";
import {RouteConfig} from "angular2/router";
import {Organisation} from "../../../user/profile/entity.model";
import {ROUTER_DIRECTIVES, RouteParams} from "angular2/router";

@Component({
    selector: 'create-org',
    templateUrl: 'app/admin/core/manage/organisation.new.view.html'
})
export class CreateOrganisationComponent {
    private _org: Organisation = new Organisation();

    public save(): Boolean {
        //organisationService.save(this._org);
        return true;
    }
}

@Component({
    selector: 'list-org',
    templateUrl: 'app/admin/core/manage/organisation.list.view.html',
    directives: [ROUTER_DIRECTIVES]
})
export class ListOrganisationsComponent {
    private _orgsList: Array<Organisation>;

}

@Component({
    selector: 'view-org',
    templateUrl: 'app/admin/core/manage/organisation.details.view.html',
    providers: [Http, HTTP_PROVIDERS]
})
export class ViewOrganisationsComponent {
    private _org: Organisation;

    constructor(_params: RouteParams) {
       //this._org = organisationService.getOrganisation(_params.get("orgCode"));
    }
}

@Component({
    selector: 'org-menu',
    templateUrl: 'app/admin/core/manage/organisation.view.html',
    providers: [Http, HTTP_PROVIDERS],
    directives: [ROUTER_DIRECTIVES]
})
export class OrganisationMenuComponent {
    constructor() {

    }
}

@Component({
    selector: 'org-comp',
    templateUrl: 'app/admin/core/manage/organisation.view.html',
    providers: [Http, HTTP_PROVIDERS],
    directives: [ROUTER_DIRECTIVES]
})
@RouteConfig([
    {path: "/new", name: "NewOrganisation", component: CreateOrganisationComponent},
    {path: "/list", name: "ListOrganisations", component: ListOrganisationsComponent},
    {path: "/details/:id", name: "ViewOrganisations", component: ViewOrganisationsComponent}
])
export class OrganisationComponent {
    constructor() {

    }
}