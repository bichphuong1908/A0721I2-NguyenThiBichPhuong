import { Component, OnInit } from '@angular/core';

import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from "../../service/benh-an.service";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  formEdit: FormGroup;
  id: number;
  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) => {
      this.id = +param.get('id');
      this.productService.findById(this.id).subscribe(
        (product) => {
          this.formEdit = new FormGroup({
            id: new FormControl(product.id, [Validators.required]),
            ma_sv: new FormControl(product.ma_sv, [Validators.required]),
            name: new FormControl(product.name, [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
            ten_nhom: new FormControl(product.ten_nhom, [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
            title: new FormControl(product.title, [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
            giao_vien: new FormControl(product.giao_vien, [Validators.required]),
            email: new FormControl(product.email, [Validators.required, Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]),
            phoneNumber: new FormControl(product.phoneNumber, [Validators.required, Validators.pattern('[0-9]{10,12}')]),
          });
        }
      );
    });
  }
  editForm(id: number) {
    this.productService.update(id, this.formEdit.value).subscribe(
      () => {
        alert('Chỉnh sửa thông tin thành công');
      },
    () => {},
    () => {
      this.router.navigateByUrl('products/list');
    }
    );
  }

  back() {
    this.router.navigateByUrl('products/list');
  }
}
