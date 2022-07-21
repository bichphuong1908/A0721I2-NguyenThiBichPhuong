import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from './component/employee-list/employee-list.component';
import {EmployeeCreateComponent} from './component/employee-create/employee-create.component';
import {EmployeeEditComponent} from './component/employee-edit/employee-edit.component';
import {EmployeeDeleteComponent} from './component/employee-delete/employee-delete.component';


const routes: Routes = [
  {path: '', component: EmployeeListComponent},
  {path: 'create', component: EmployeeCreateComponent},
  {path: 'edit/:id', component: EmployeeEditComponent},
  {path: 'delete/:id', component: EmployeeDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
