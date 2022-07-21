import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../model/employee';
const API_URL = 'http://localhost:3000';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(API_URL + '/employee');
  }

  save(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(API_URL + '/employee', employee);
  }

  findById(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${API_URL}/employee/${id}`);
  }

  edit(id: number, employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(`${API_URL}/employee/${id}`, employee);
  }

  delete(id: number) {
    return this.httpClient.delete(`${API_URL}/employee/${id}`);
  }
}
