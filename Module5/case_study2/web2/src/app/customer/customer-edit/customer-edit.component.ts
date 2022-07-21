import { Component, OnInit } from '@angular/core';
import {CustomerType} from '../../model/customer-type';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerTypeService} from '../../service/customer-type.service';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customer: Customer = new class implements Customer {
    address: string;
    customerType: CustomerType;
    dateOfBirth: Date;
    email: string;
    gender: string;
    id: number;
    idCard: string;
    name: string;
    phoneNumber: string;
  };

  editForm: FormGroup;

  customerTypes: CustomerType[] = [];
  id: number;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // tslint:disable-next-line:radix
      this.id = parseInt(paramMap.get('id'));
      this.getCustomer(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllCustomerType();
  }

  onSubmit() {
    this.editCustomer(this.id);
  }

  private getCustomer(id: number) {
    this.customerService.findById(id).subscribe(customer => {
      this.editForm = new FormGroup({
        id: new FormControl(customer.id),
        name: new FormControl(customer.name),
        email: new FormControl(customer.email),
        dateOfBirth: new FormControl(customer.dateOfBirth),
        gender: new FormControl(customer.gender),
        idCard: new FormControl(customer.idCard),
        phoneNumber: new FormControl(customer.phoneNumber),
        address: new FormControl(customer.address),
        customerType: new FormControl(customer.customerType)
      });
    });
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(customerTypes => {
      this.customerTypes = customerTypes;
    });
  }

  compareFn(customerType1: CustomerType, customerType2: CustomerType) {
    return customerType1 && customerType2 ? customerType1.id === customerType2.id : customerType1 === customerType2;
  }

  editCustomer(id: number) {
    const customer = this.editForm.value;
    this.customerService.edit(id, customer).subscribe(() => {
      alert('Update success!');
      this.router.navigateByUrl('/customer');
    });
  }
}



