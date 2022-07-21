import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeType} from '../../model/employee-type';
import {EmployeeService} from '../../service/employee.service';
import {EmployeeTypeService} from '../../service/employee-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Employee} from '../../model/employee';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
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

  editForm: FormGroup;
  employeeTypes: EmployeeType[] = [];
 id: number;


  constructor(private employeeService: EmployeeService,
              private employeeTypeService: EmployeeTypeService, private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // tslint:disable-next-line:radix
      this.id = parseInt(paramMap.get('id'));
      this.getEmployee(this.id);
    });
  }

  private getEmployee(id: number) {
    // chú ý chỗ data là lấy dữ liệu
    this.employeeService.findById(id).subscribe(data => {
    this.editForm = new FormGroup({
      id: new FormControl(data.id, ),
      name: new FormControl(data.name, [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
      dateOfBirth: new FormControl(data.dateOfBirth, Validators.required ),
      idCard: new FormControl(data.idCard, [Validators.required, Validators.min(3)]),
      phoneNumber: new FormControl(data.phoneNumber, [Validators.required, Validators.pattern('[0-9]{9,10}')]),
      email: new FormControl(data.email, [Validators.required, Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]),
      salary: new FormControl(data.salary, Validators.required),
      employeeType: new FormControl(data.employeeType, Validators.required)
    });
    });
  }

  getAllEmployeeType() {
    this.employeeTypeService.getAll().subscribe(employeeTypes => {
      this.employeeTypes = employeeTypes;
    });
  }

  compareFn(employeeType1: EmployeeType, employeeType2: EmployeeType) {
    return employeeType1 && employeeType2 ? employeeType1.id === employeeType2.id : employeeType1 === employeeType2;
  }

  ngOnInit(): void {
    this.getAllEmployeeType();
  }

  onSubmit() {
    this.editEmployee(this.id);
    console.log(this.editForm.value);
  }

  editEmployee(id: number) {
    const employee = this.editForm.value;
    this.employeeService.edit(id, employee).subscribe(() => {
      alert('Update success!');
      this.router.navigateByUrl('');
    });
  }

}
