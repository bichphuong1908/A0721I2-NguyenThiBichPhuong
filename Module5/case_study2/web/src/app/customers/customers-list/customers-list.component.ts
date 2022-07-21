import { Component, OnInit } from '@angular/core';
import {Customers} from '../../model/customers';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {

  customers: Customers[];
  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(
      (data) => {
        this.customers = data;
      }
    );
  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(
      () => {},
      () => {},
      () => {
        this.ngOnInit();
        // this.ngOnChanges();
        // Cách 2 trong trường hợp dùng modal bị fade backgroud ko nhấn gì được
      }
    );
  }

}
