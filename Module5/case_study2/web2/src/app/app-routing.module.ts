import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomeCreateComponent} from './customer/custome-create/custome-create.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {CustomerDeleteComponent} from './customer/customer-delete/customer-delete.component';


const routes: Routes = [
  {path: 'customer', component: CustomerListComponent},
  {path: 'customer/create', component: CustomeCreateComponent},
  {path: 'customer/edit/:id', component: CustomerEditComponent},
  {path: 'customer/delete/:id', component: CustomerDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
