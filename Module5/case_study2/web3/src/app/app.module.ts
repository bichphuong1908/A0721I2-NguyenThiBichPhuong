import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import {HttpClientModule} from '@angular/common/http';
import { EmployeeCreateComponent } from './component/employee-create/employee-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { EmployeeEditComponent } from './component/employee-edit/employee-edit.component';
import { EmployeeDeleteComponent } from './component/employee-delete/employee-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    EmployeeDeleteComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
