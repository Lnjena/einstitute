
import {Component} from "angular2/core";
import {SearchComponent} from "../../../common/search.component";
import {Input} from "angular2/core";
import {EntityGroup} from "../../../user/profile/entity.model";

@Component({
    selector: 'group-new',
    templateUrl: 'app/admin/core/manage/group.new.view.html'
})
export class CreateGroupComponent {
    _group: EntityGroup;

}

@Component({})
export class ListGroupsComponent {

}

@Component({})
export class ViewGroupComponent {

}

@Component({})
export class SearchGroupsComponent implements SearchComponent {

}

@Component({})
export class GroupsMenuComponent implements SearchComponent {

}

@Component({
    selector: 'group-mgmt-comp',
    templateUrl: 'app/admin/core/manage/group.view.html'
})
export class GroupManagementComponent {
    constructor(){
        //JSON.str
    }

}