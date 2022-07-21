import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, Observer} from 'rxjs';
import {Customer} from '../model/customer';
const API_URL = 'http://localhost:3000';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(API_URL + '/customers');
  }
  save(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(API_URL + '/customers', customer);
  }

  findById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(`${API_URL}/customers/${id}`);
  }

  edit(id: number, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(`${API_URL}/customers/${id}`, customer);
  }

  delete(id: number): Observable<Customer>{
    return this.httpClient.delete<Customer>(`${API_URL}/customers/${id}`);
  }
}
