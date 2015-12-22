import {bootstrap, Component} from 'angular2/angular2';

//import {Library} from 'library';

export class Todo {
    title: string;
    constructor() {
        this.title = "def";
    }
}

@Component({
    selector: 'my-app',
    templateUrl: './open.html'
    //directives: [Library]
})
class AppComponent {
    todos: Array<Todo>;

    constructor() {
        console.log("initi control");
        this.todos = [new Todo()];
    }

    login(event, username, password) {
        //event.preventDefaults();
        console.log(username.value);
        console.log(password.value);
        var todo = new Todo();
        todo.title = username.value;

        this.todos.push(todo);

        console.log(this.todos);
    }
}


bootstrap(AppComponent);