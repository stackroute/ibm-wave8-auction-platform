import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {IProduct} from '../models/product';
import {HttpClient } from '@angular/common/http';
const apiUrl='http://172.23.238.225:8090/api/v1';
@Injectable({
  providedIn: 'root'
})
export class SearchItemService {
  hey:any;
  constructor(private http:HttpClient) { }
  searchItems(category):Observable<IProduct>
{
console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+category);
this.hey= this.http.post<IProduct>(apiUrl+'/getItemByCategory/', category);
console.log("please work"+this.hey);
return this.hey;
}
}
