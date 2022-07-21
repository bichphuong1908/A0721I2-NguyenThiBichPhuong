import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customers} from '../model/customers';
const URL_API = 'http://localhost:3000/customers';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {


  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Customers[]> {
    return this.httpClient.get<Customers[]>(URL_API);
  }

  saveCustomer(customers: Customers): Observable<any> {
    // console.log(customer);
    return this.httpClient.post(URL_API, customers);
  }

  deleteCustomer(id: number) {
    return this.httpClient.delete(URL_API + '/' + id);
  }

}
