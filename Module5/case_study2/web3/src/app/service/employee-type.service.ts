import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {EmployeeType} from '../model/employee-type';
const API_URL = 'http://localhost:3000/';

@Injectable({
  providedIn: 'root'
})
export class EmployeeTypeService {

  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<EmployeeType[]> {
    return this.httpClient.get<EmployeeType[]>(API_URL + 'employeeType');
  }
}
