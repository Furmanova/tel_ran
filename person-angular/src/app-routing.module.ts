import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PersonsComponent} from './app/persons.ts/persons.component';
import {PersonDetailComponent} from './app/person-detail/person-detail.component';

const routes: Routes = [
  {path: 'persons', component: PersonsComponent},
  {path: '', redirectTo: '/persons', pathMatch: 'full'},
  { path: 'detail/:id', component: PersonDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
