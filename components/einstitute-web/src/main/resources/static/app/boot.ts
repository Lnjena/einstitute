import {bootstrap} from 'angular2/platform/browser';
import {ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES, LocationStrategy, HashLocationStrategy} from 'angular2/router';
import {App} from 'app/app.component';
import {provide} from "angular2/core";

bootstrap(App, [ROUTER_PROVIDERS, provide(LocationStrategy, {useClass: HashLocationStrategy})]);