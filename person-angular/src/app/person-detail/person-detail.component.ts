import {Component, OnInit} from '@angular/core';
import {Person} from '../model/person';
import {ActivatedRoute} from '@angular/router';
import {PersonService} from '../service/person.service';
import {Location} from '@angular/common';



@Component({
  selector: 'app-person-detail',
  templateUrl: './person-detail.component.html',
  styleUrls: ['./person-detail.component.css']
})
export class PersonDetailComponent implements OnInit {
  person: Person;

  constructor(
    private route: ActivatedRoute,
    private personService: PersonService,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    this.getPerson();
  }

  getPerson(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.personService.getPerson(id)
      .subscribe(person => this.person = person);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.personService.editPerson(this.person)
      .subscribe(() => this.goBack());
  }
}
