import {Component, Input, OnInit} from '@angular/core';

import {Person} from '../../model/person';
import {PersonService} from '../../service/person.service';
import {PersonFormComponent} from '../person-form/person-form.component';
import {PersonsComponent} from '../persons.component';


@Component({
  selector: 'app-person-item',
  templateUrl: './person-item.component.html',
  styleUrls: ['./person-item.component.css']
})
export class PersonItemComponent implements OnInit {
  @Input()
  person: Person;

  @Input()
  parent: PersonsComponent;


  constructor(private personService: PersonService) {
  }

  ngOnInit(): void {

  }

  onDeletePerson(person: Person): void {
    this.personService.remove(person).subscribe();
    this.parent.persons = this.parent.persons.filter(p => p !== person);
  }

  onEditPerson(person: Person): void {

  }


}
