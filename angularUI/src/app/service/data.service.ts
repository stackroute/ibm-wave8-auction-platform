import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import {Item} from '../item';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  constructor(private httpClient : HttpClient) { }
  url="http://172.23.238.230:8080";

  getItem(value):Observable<Item>
  {
    return this.httpClient.get<Item>(this.url+"/item/"+value);
  }
  value: string;
  updateItem(itemCurrentBid,noOfDaysNeeded, userName, emailid, phNo,value):Observable<Item>
  {
    // console.log(this.url,"/updateItem/1/"+itemCurrentBid+"/"+noOfDaysNeeded);
    return this.httpClient.put<Item>(this.url+"/updateItem/"+value+"/"+itemCurrentBid+"/"+noOfDaysNeeded+"/"+ userName+"/"+ emailid+"/"+ phNo, this.value);
  }
}
