import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from '../models/product';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const apiUrl = 'http://172.23.238.225:8080/api/v1';

@Injectable({
  providedIn: 'root'
})
export class RentItemsService {
  httpOptions = {
    headers: new HttpHeaders(
      {
        'Content-Type': 'application/json'
      }
    )
  }

  constructor(private http:HttpClient) { }

  uploadRentItems(rentItems, username): Observable<IProduct> {
   
    console.log(username);
   
    return this.http.post<IProduct>(apiUrl+'/rentItems/'+username,rentItems); 
  }
}
