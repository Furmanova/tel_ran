import { Component } from '@angular/core';
import {Person} from './model/person';
import {PersonService} from './service/person.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [PersonService]
})
export class AppComponent {
  constructor(public personService: PersonService) {
  }

  title = 'My Persons';

}
