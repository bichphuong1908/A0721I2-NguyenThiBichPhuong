import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
const URL_API = 'http://localhost:3000/products';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // nameSearch = '';
  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(URL_API);
  }
  save(product: Product): Observable<any> {
    return this.httpClient.post(URL_API, product);
  }
  findById(id: number): Observable<Product> {
    // @ts-ignore
    return this.httpClient.get(URL_API + '/' + id);
  }
  update(id: number , product: Product): Observable<Product> {
    // @ts-ignore
    return this.httpClient.put(URL_API + '/' + id, product);
  }
  delete(id: number) {
    return this.httpClient.delete(URL_API + '/' + id);
  }
}
