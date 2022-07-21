import { Component, OnInit } from '@angular/core';
import {Employee} from '../../model/employee';
import {EmployeeType} from '../../model/employee-type';
import {EmployeeService} from '../../service/employee.service';
import {EmployeeTypeService} from '../../service/employee-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {
  employee: Employee = new class implements Employee {
    salary: number;
    employeeType: EmployeeType;
    id: number;
    name: string;
    dateOfBirth: Date;
    idCard: string;
    email: string;
    phoneNumber: number;
  };
  id: number;

  constructor(private employeeService: EmployeeService,
              private employeeTypeService: EmployeeTypeService, private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // tslint:disable-next-line:radix
      this.id = parseInt(paramMap.get('id'));
      this.delete(this.id);
    });
  }

  ngOnInit(): void {
  }

  private delete(id: number) {
    return this.employeeService.delete(id).subscribe(i => {
      console.log(i);
      alert('xóa thành công');
      this.router.navigateByUrl('');
    });
  }
}
