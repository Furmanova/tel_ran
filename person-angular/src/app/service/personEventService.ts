import {EventEmitter, Injectable} from '@angular/core';
import {Person} from '../model/person';
import {Subscription} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PersonEventService {
  private editPerson: EventEmitter<Person> = new EventEmitter<Person>();

  constructor() {
  }

  addPersonToEdit(person: Person): void {
    this.editPerson.emit(person);
  }

  subscribeEditPerson(callback): Subscription {
    return this.editPerson.subscribe(callback);
  }
}
