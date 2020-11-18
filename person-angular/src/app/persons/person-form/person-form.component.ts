import {Component, OnInit, Output} from '@angular/core';
import {Person} from '../../model/person';
import {PersonService} from '../../service/person.service';
import {EventEmitter} from '@angular/core';
import {PersonEventService} from '../../service/personEventService';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})


export class PersonFormComponent implements OnInit  {
  @Output()
  personCreated = new EventEmitter<Person>();
  @Output()
  personEdited = new EventEmitter<Person>();
  person: Person = {};

  isEdit: boolean;
  constructor(private personService: PersonService, private personEventService: PersonEventService ) {
    }
    // callback to handle incomig persons which should be edited
  private onPersonToEdit = personToEdit => {
      this.person = Object.assign({}, personToEdit);
      this.isEdit = true;
    }
  ngOnInit(): void {
    this.personEventService.subscribeEditPerson(this.onPersonToEdit);
  }

  onAdd(): void {
    this.personService.add(this.person)
      .subscribe(newPerson => {
        this.personCreated.emit(newPerson);
        this.person = {};
      });
  }
  onEdit(): void {
    this.personService.edit(this.person)
     .subscribe();
    this.isEdit = false;
    this.personEdited.emit(this.person);
    this.person = {};
  }

  onCancel(): void {
    this.isEdit = false;
    this.person = {};
  }
}
