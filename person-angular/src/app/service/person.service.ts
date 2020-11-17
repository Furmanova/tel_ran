import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {Person} from '../model/person';

import {HttpClient, HttpHeaders} from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private httpClient: HttpClient) {
  }

  private readonly PERSONS_URI = '/api/persons';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getAll(): Observable<Person[]> {
    return this.httpClient.get<Person[]>(this.PERSONS_URI);
  }

  add(person: Person): Observable<Person> {
    return this.httpClient.post<Person>(this.PERSONS_URI, person);
  }

  //
  // edit(person: Person): Observable<void> {
  //
  // }
  //
  remove(person: Person): Observable<Person> {
    const url = `${this.PERSONS_URI}/${person.id}`;
    return this.httpClient.delete<Person>(url, this.httpOptions);
  }

  //
  // get(id: number): Observable<Person> {
  //
  // }
  }
