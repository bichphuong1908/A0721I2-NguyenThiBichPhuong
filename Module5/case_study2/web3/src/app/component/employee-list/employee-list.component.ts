import {Component, OnChanges, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Employee} from '../../model/employee';
import {EmployeeService} from '../../service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    return this.employeeService.getAll().subscribe(employees => {
      this.employees = employees;
    });
  }
}
