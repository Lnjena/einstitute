import {Component, Input} from "angular2/core";
import {BaseComponent} from "app/common/base.component";
import {Entity} from "app/user/profile/entity.model";

@Component({
    selector: "profile-search",
    template: `

    `
})
export class ProfileSearchComponenet extends BaseComponent<Entity> {

    @Input() searchOutputTypeChoice: String;

    private searchBy: Array<String> = ["entityId", "entityDOB", "userId", "userEmailId"];
    private searchOutputType: Array<String> = ["entityId", "profile.min", "profile.full", "profile.gist"];

    constructor() {

    }

}
