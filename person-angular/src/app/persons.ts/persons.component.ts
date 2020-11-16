import { Component, OnInit } from '@angular/core';
import {Person} from '../model/person';
import {PersonService} from '../service/person.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  persons: Person[];

  constructor(private personService: PersonService) {
  }


  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.getAll();
  }
  getAll(): void {
    this.personService.getAll()
      .subscribe(persons => this.persons = persons);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }
    this.personService.addPerson({name} as Person)
      .subscribe(person => {
        this.persons.push(person);
      });
  }
  delete(person: Person): void {
    this.persons = this.persons.filter(h => h !== person);
    this.personService.deletePerson(person).subscribe();
  }

}

