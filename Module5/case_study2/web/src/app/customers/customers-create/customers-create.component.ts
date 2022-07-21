import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {Customers} from '../../model/customers';

@Component({
  selector: 'app-customers-create',
  templateUrl: './customers-create.component.html',
  styleUrls: ['./customers-create.component.css']
})
export class CustomersCreateComponent implements OnInit {
  customer: Customers;
  createCustomerForm: FormGroup;
  id: number;

  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.createCustomerForm = new FormGroup({
      name: new FormControl(),
      dateOfBirthday: new FormControl(),
      gender: new FormControl(),
      nationalId: new FormControl(),
      phone: new FormControl(),
      email: new FormControl(),
      customerType: new FormControl(),
      address: new FormControl(),
      serviceId: new FormControl(),
    });
  }

  // getAllService() {
  //   this.service.getAll().subscribe(
  //     (data) => {
  //       this.dichvuList = data;
  //     }
  //   );
  // }

  createCustomer() {
    this.customerService.saveCustomer(this.createCustomerForm.value).subscribe(
      (data) => {
        alert('Create Customer Success');
        // console.log(data);
      },
      () => {},
      () => {
        this.router.navigateByUrl('/customer/list');
      }
    );
  }
}
