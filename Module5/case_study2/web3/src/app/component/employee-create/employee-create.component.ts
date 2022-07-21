import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeType} from '../../model/employee-type';
import {EmployeeService} from '../../service/employee.service';
import {EmployeeTypeService} from '../../service/employee-type.service';
import {Router} from '@angular/router';
import {Employee} from '../../model/employee';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  createForm: FormGroup;
  employeeTypes: EmployeeType[] = [];

  employee: Employee;

  constructor(private employeeService: EmployeeService,
              private employeeTypeService: EmployeeTypeService, private router: Router) {
    this.createForm = new FormGroup({
      // id: new FormControl('', Validators.required),
      name: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
      dateOfBirth: new FormControl('', Validators.required),
      idCard: new FormControl('', [Validators.required, Validators.min(3)]),
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('[0-9]{9,10}')]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]),
      salary: new FormControl('', [Validators.required]),
      employeeType: new FormControl('', Validators.required)
    });
  }

  ngOnInit(): void {
    this.employee = this.createForm.value;
    this.getAllEmployeeType();
  }

  getAllEmployeeType() {
    this.employeeTypeService.getAll().subscribe(employeeTypes => {
      this.employeeTypes = employeeTypes;
    });
  }

  onSubmit() {
    console.log(this.createForm.value);
    this.employee = this.createForm.value;
    this.save();
  }

  private save() {
    this.employeeService.save(this.employee).subscribe(() => {
        // this.createForm.reset();
        alert('Tạo thành công');
      },
      () => {},
      () => {
        this.router.navigateByUrl('');
      }
    );
  }
}
