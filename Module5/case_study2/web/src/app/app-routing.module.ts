import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomersListComponent} from './customers/customers-list/customers-list.component';
import {CustomersCreateComponent} from './customers/customers-create/customers-create.component';


const routes: Routes = [
  {path: 'customers', component: CustomersListComponent},
  {path: 'customers', component: CustomersCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
