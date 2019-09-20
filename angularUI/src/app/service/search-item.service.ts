import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {IProduct} from '../models/product';
import {HttpClient } from '@angular/common/http';
const apiUrl='http://172.23.238.225:8090/api/v1';
@Injectable({
  providedIn: 'root'
})
export class SearchItemService {

  constructor(private http:HttpClient) { }
  searchItems(category):Observable<IProduct>
{
console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+category);
return this.http.post<IProduct>(apiUrl+'/getItemByCategory/', category);
}
}
