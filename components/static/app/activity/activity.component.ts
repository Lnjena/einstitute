import {Component, provide, OnInit} from "angular2/core";
import {ROUTER_DIRECTIVES, ROUTER_PROVIDERS, RouteConfig, RouteDefinition, Router, RouteParams, Route, LocationStrategy, HashLocationStrategy} from "angular2/router";
import {Activity, ActivityTracker, ActivityType, Schedule} from './activity.model';
import {BaseComponent} from "../common/base.component";
import {ScheduleComponent} from "./schedule.component";

var ACTIVITIES: Array<Activity> = [
    new Activity("ACT23344", "LNJ12345", "Annual Registration", ActivityType.ROUTINE, ["G1", "G2"], ActivityType.ROUTINE, null, new Schedule()),
    new Activity("ACT23345", "LNJ12346", "Class Registration", ActivityType.ROUTINE, ["G1", "G2"], ActivityType.ROUTINE, null, new Schedule())
];

@Component({
    selector: "activity-new",
    templateUrl: "app/activity/activity.new.view.html",
    directives: [ROUTER_DIRECTIVES, ScheduleComponent]
})
export class CreateActivityComponent {
    //activity: Activity = new Activity(null, null, null, ActivityType.ROUTINE, [], ActivityType.ROUTINE, null, null);
    activity: Activity = ACTIVITIES.pop();

    constructor() {
        console.log(this.activity);
    }

    newActivity(): Boolean {
        console.log(this.activity.schedule);
        ACTIVITIES.push(this.activity);

        return true;
    }
}

@Component({
    selector: "activity-list",
    templateUrl: "app/activity/activity.list.view.html",
    directives: [ROUTER_DIRECTIVES, ScheduleComponent, CreateActivityComponent]
})
export class ListActivitiesComponent implements OnInit {
    activities: Array<Activity>;

    ngOnInit():any {
        this.activities = ACTIVITIES;
    }
}


@Component({
    selector: "activity-details",
    templateUrl: "app/activity/activity.details.view.html",
    directives: [ROUTER_DIRECTIVES, CreateActivityComponent]
})
export class ViewActivityDetailsComponent {
    activityId: String;
    constructor(_params: RouteParams) {
        this.activityId = _params.get("id");
    }
}

@Component({
    selector: 'activity-main',
    templateUrl: 'app/activity/activity.view.html',
    directives: [ROUTER_DIRECTIVES]
})
export class ActivityMainComponent {
    constructor() {

    }
}

@Component({
    selector: "activity-cmp",
    templateUrl: "app/activity/activity.view.html",
    directives: [ROUTER_DIRECTIVES]
})
@RouteConfig([
    { path: '/menu', name: 'ActivityMain', component: ActivityMainComponent },
    { path: '/new', name: 'CreateActivity', component: CreateActivityComponent },
    { path: '/list', name: 'ListActivities', component: ListActivitiesComponent },
    { path: '/details/:id', name: 'ViewActivityDetails', component: ViewActivityDetailsComponent }
])
export class ActivityComponent extends BaseComponent {
    constructor(_router: Router) {
    }
}
