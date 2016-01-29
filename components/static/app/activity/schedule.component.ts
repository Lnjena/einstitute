import {Component, Output, EventEmitter} from 'angular2/core';
import {BaseComponent} from "app/common/base.component";
import {Schedule} from "./activity.model";
import {Input} from "angular2/core";

@Component({
    selector: "schedule-cmp",
    templateUrl: "app/activity/schedule.view.html"
})
export class ScheduleComponent extends BaseComponent {
    @Output() scheduled: EventEmitter<Schedule> = new EventEmitter<Schedule>();
    @Input() schedule: Schedule;

    constructor() {
        console.log("Schedule Initiated")
    }

    onSave() {
        this.scheduled.emit(this.schedule);
    }
}