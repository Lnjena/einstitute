import {Component} from "angular2/core";
import {Http, HTTP_PROVIDERS} from "angular2/http";
import {RouteConfig} from "angular2/router";
import {Organisation} from "../../../user/profile/entity.model";
import {ROUTER_DIRECTIVES, RouteParams} from "angular2/router";
import {AddressFormComponent} from "../../../user/profile/address.component";
import {AddressType} from "../../../user/profile/entity.model";
import {Input} from "angular2/core";

@Component({
    selector: 'create-org',
    templateUrl: 'app/admin/core/manage/organisation.new.view.html',
    directives: [AddressFormComponent]
})
export class CreateOrganisationComponent {
    @Input() readOnly: Boolean;
    private _org: Organisation = new Organisation();

    constructor() {
        this._org.orgAddress.type = AddressType.BUSINESS;
    }

    public save(): Boolean {
        //organisationService.save(this._org);
        console.log(this._org.orgAddress.city);
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