import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';
import {Customer} from '../../model/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CustomerType} from '../../model/customer-type';

@Component({
  selector: 'app-custome-create',
  templateUrl: './custome-create.component.html',
  styleUrls: ['./custome-create.component.css']
})
export class CustomeCreateComponent implements OnInit {

  customerTypes: CustomerType[] = [];

  customer: Customer;
  createForm: FormGroup;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService, private router: Router) {
    this.createForm = new FormGroup({
      // id: new FormControl('', Validators.required),
      name: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
      dateOfBirth: new FormControl('', Validators.required),
      gender: new FormControl('', Validators.required),
      idCard: new FormControl('', [Validators.required, Validators.min(0)]),
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('[0-9]{9,10}')]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]),
      address: new FormControl('', [Validators.required, Validators.minLength(5)]),
      customerType: new FormControl('', Validators.required)

    });
  }

  ngOnInit(): void {
    this.customer = this.createForm.value;
    this.getAllCustomerType();
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(customerTypes => {
      this.customerTypes = customerTypes;
    });
  }

  onSubmit() {
    console.log(this.createForm.value);
    this.customer = this.createForm.value;
    this.save();
  }

 save() {
    this.customerService.save(this.customer).subscribe(() => {
      // this.createForm.reset();
      alert('Tạo thành công');
    },
      //   // error => {
      // // console.log(error);
      // this.router.navigateByUrl('/customer');
      () => {},
        () => {
          this.router.navigateByUrl('/customer');
        }
    );
  }
}
