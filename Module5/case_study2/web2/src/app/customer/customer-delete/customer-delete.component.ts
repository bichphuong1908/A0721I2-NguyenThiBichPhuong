import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerType} from '../../model/customer-type';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

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
  id: number;

  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // tslint:disable-next-line:radix
      this.id = parseInt(paramMap.get('id'));
      this.delete(this.id);
    });
  }

  ngOnInit(): void {
  }

  delete(id: number) {
    return this.customerService.delete(id).subscribe(i => {
      console.log(i);
      alert('xóa thành công');
      this.router.navigateByUrl('/customer');
    });
  }
}
