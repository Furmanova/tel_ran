import { Component, OnInit } from '@angular/core';
import {Person} from '../model/person';
import {PersonService} from '../service/person.service';

@Component({
  selector: 'app-person-form.ts',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})

export class PersonFormComponent implements OnInit {
  ngOnInit(): void {
  }
}
