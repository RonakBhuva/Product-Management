import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/products';

  constructor(private http: HttpClient) { }

  getAllProducts() {
    return this.http.get(this.baseUrl);
  }

  addProduct(product: any) {
    return this.http.post(this.baseUrl, product);
  }

  getProductById(id: number) {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  updateProduct(id: number, product: any) {
    return this.http.put(`${this.baseUrl}/${id}`, product);
  }

  deleteProduct(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

}
