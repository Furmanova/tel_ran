import { Component, OnInit } from '@angular/core';
import {Person} from '../model/person';
import {PersonService} from '../service/person.service';


@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  persons: Person[] = [];

  constructor(private personService: PersonService) {
  }

  async ngOnInit(): Promise<void> {
    this.persons = await this.getPersons();
  }

  async getPersons(): Promise<Person[]> {
    return await this.personService.getAll().toPromise();
  }

  onPersonCreated(newPerson: Person): void {
    this.persons.push(newPerson);
  }
  onPersonEdited(person: Person): void{
    const idx = this.persons.findIndex(o => o.id === person.id );
    this.persons[idx] = person;
  }
  onPersonDeleted(person: Person): void {
    this.persons = this.persons.filter(p => p.id !== person.id);
  }
}

