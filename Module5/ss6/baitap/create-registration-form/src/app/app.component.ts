import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'create-registration-form';

   contactForm = new FormGroup({
    email: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required, Validators.minLength(6)]),
    confirmPassword: new FormControl("", [Validators.required, Validators.minLength(6)]),
    country: new FormControl(),
    age: new FormControl("", [Validators.required, Validators.minLength(18)]),
    gender: new FormControl("",[Validators.required]),
    phone: new FormControl("",[Validators.required])
  });

  countryList = [
    {id: 1, name: 'Đà Nẵng'},
    {id: 2, name: 'Quảng Nam'},
    {id: 3, name: 'Bình Định'}
  ];



  onSubmit() {
    console.log(this.contactForm.value);
  }
}
