import { Injectable } from '@angular/core';
import { HttpClient, HttpParams,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuctionService {
  url;
  url1="http://172.23.238.230:8080";
  constructor(private httpclient: HttpClient) { }

  addToWishList(value) : any {
    this.httpclient.post("http://172.23.238.180:8081/api/v1/savewishlist",value).subscribe();
    console.log(value);
   }
   getWishList() : any {
  return  this.httpclient.get("http://172.23.238.180:8081/api/v1/myproducts");
    // console.log(value);
   }
 delete(product) :any
 {
  return this.httpclient.post("http://172.23.238.180:8081/api/v1/removefav",product).subscribe();
  //console.log(product);
 }

 getSearch(val:String)
 {
   this.url = "http://172.23.238.180:8070/api/v1/item/"+val ;
   return this.httpclient.get(this.url);
 }

 getRecommendList(val)
 { 
   var url='http://172.23.238.180:8084/api/v1/userrcm/';
  return this.httpclient.get(url+val);
 }
 getUserInfo(value)
{
  var url='http://172.23.238.225:8090/api/v1/getUserInfo/'
 return this.httpclient.get(url+value);
}
// getRecentItems(val){
//   var url='http://172.23.238.261:8080/newlyAdded/'
//   return this.httpclient.get(url+val);
// }
// getTrendingItems(val){
//   var url='http://172.23.238.261:8080/trending/'
//   return this.httpclient.get(url+val);
// }
getTrendingItems():Observable<any>
{
  return this.httpclient.get<any>(this.url1+"/trending");
}

getRecentItems():Observable<any>
{
  return this.httpclient.get<any>(this.url1+"/newlyAdded");
}
// getImgUrl():Observable<any>
// {
//   return this.httpclient.get<any>("http://172.23.238.225:8080/api/v1/getAllUsers");
// }
}
