import {BaseComponent} from 'app/common/base.component';
import {Component} from "angular2/core";
import {Input} from "angular2/core";
import {NgFor} from "angular2/common";
import {OnInit} from "angular2/core";
import {tick} from "angular2/testing";
import {OnDestroy} from "angular2/core";

@Component({
    selector: 'sys-dropdown',
    template: `
        <div>
            <select class="form-control">
                <option value="#">{{_defPrompt}}</option>
                <option *ngFor="#datum of _data" value="datum[_keyPath]">
                    {{datum[_displayValue]}}
                </option>
            </select>
        </div>
    `,
    directives: [NgFor]
})
export class SimpleDropdownComponent extends BaseComponent {
    @Input() _data: any[];
    @Input() _keyPath: string;
    @Input() _displayValue: string;
    @Input() _defPrompt: string;
}