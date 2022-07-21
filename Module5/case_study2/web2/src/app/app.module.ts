import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomeCreateComponent } from './customer/custome-create/custome-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { CustomerDeleteComponent } from './customer/customer-delete/customer-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CustomeCreateComponent,
    CustomerEditComponent,
    CustomerDeleteComponent
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
