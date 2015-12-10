import {View, Injectable, Component, TemplateConfig, ChangeDetectionStrategy, bootstrap} from 'angular2/angular2';

@Component({
    selector: 'todo-app',
    changeDetection: ChangeDetectionStrategy.OnPush
})
@View({
    templateUrl: './main.html'
})
export class Todo {
    completed: Boolean;
    editing: Boolean;
    title: String;
    uid: String;
    setTitle(title: String) {
        this.title = title.trim();
    }
    constructor(title: String) {
        this.uid = 99999;
        this.completed = false;
        this.editing = false;
        this.title = title.trim();
    }
}

interface ITodo {
    addTodo(): boolean;
}

export class ToDoApp {
    todos: Array<Todo>;
    constructor() {
        this.todos = [];
        console.log(this.todos);
    }

    addTodo(event, todoVal) {
        console.log("method called");
        console.log(todoVal);
        event.preventDefault();
        this.todos.push(todoVal);
        console.log(this.todos);
    }
}

@Injectable()
export class TodoStore {

}


bootstrap(ToDoApp);