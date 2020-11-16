import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';

import {RouterModule} from '@angular/router';
import {PersonsComponent} from './persons.ts/persons.component';
import {AppRoutingModule} from '../app-routing.module';
import {MessagesComponent} from './messages/messages.component';

import { PersonItemsComponent } from './person-items/person-items.component';
import {PersonFormComponent} from './person-form/person-form.component';
import {PersonDetailComponent} from './person-detail/person-detail.component';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    PersonsComponent,
    MessagesComponent,
    PersonItemsComponent,
    PersonFormComponent,
    PersonDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
