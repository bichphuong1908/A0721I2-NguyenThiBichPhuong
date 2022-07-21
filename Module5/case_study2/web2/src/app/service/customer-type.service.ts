import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerType} from '../model/customer-type';
const API_URL = 'http://localhost:3000';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  name: string;

  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(API_URL + '/customerTypes');
  }
}
