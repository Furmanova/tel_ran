import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

import {Person} from '../../model/person';
import {PersonService} from '../../service/person.service';
import {PersonFormComponent} from '../person-form/person-form.component';
import {PersonsComponent} from '../persons.component';
import {PersonEventService} from '../../service/personEventService';


@Component({
  selector: 'app-person-item',
  templateUrl: './person-item.component.html',
  styleUrls: ['./person-item.component.css']
})
export class PersonItemComponent implements OnInit {
  @Output()
  personDeleted = new EventEmitter<Person>();
  @Input()
  person: Person;

  constructor(private personService: PersonService,
              private personEventService: PersonEventService) {
  }

  ngOnInit(): void {

  }

  onDeletePerson(): void {
    this.personService.remove(this.person).subscribe(removePerson => {
        this.personDeleted.emit(removePerson);
        this.person = {};
      }
    );
  }

  onEditPerson(): void {
    this.personEventService.addPersonToEdit(this.person);
  }
}
