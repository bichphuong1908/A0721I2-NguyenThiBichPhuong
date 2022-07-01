import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-template-form-student',
  templateUrl: './template-form-student.component.html',
  styleUrls: ['./template-form-student.component.css']
})
export class TemplateFormStudentComponent implements OnInit {

  student ={
    StudentAddress: "Đà Nẵng",
    StudentCode: "123457",
    StudentName: "phương"
  };

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(CreateStudentForm: NgForm) {
    console.log(CreateStudentForm.value) // .value là hiển thị rõ ràng hơn

  }
}
