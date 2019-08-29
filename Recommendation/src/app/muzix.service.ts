import { Injectable } from '@angular/core';
import { HttpClient, HttpParams,HttpHeaders } from '@angular/common/http';
import { Lastfm } from './modals/Lastfm';
import { Observable } from 'rxjs';
import { ITracks } from './modals/ITracks';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class MuzixService {
  [x: string]: any;

  constructor(private httpclient: HttpClient) { }

  public results: Lastfm;
  public playlist:ITracks[];
 url;
url1;
  getLastFmTracks(searchString: string): Observable<Lastfm> {
    let params = new HttpParams();
    params = params.append('track', searchString);
    var url = "http://ws.audioscrobbler.com/2.0/?method=track.search&track" +searchString+ "&api_key=32e5e8719e5f77dc5996a922f7707373&format=json";
    return this.httpclient.get<Lastfm>(url, { params: params });
    // return this.results;
  }
  getTrack(): Observable<ITracks[]> {
    var url4 = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=Believe&api_key=88c89d5e25fe0ea4fa7f60062a96f49b&format=json";
    return this.httpclient.get<ITracks[]>(url4);
  }
  getAllTracks():Observable<ITracks[]>
  {

  var url2="http://localhost:8010/api/v1/track";
    return this.httpclient.get<ITracks[]>(url2);

  }
 
  addTracksToWishList(value) :Observable<ITracks>
  {
    var url2="http://localhost:8010/api/v1/track";
    return this.httpclient.post<ITracks>(url2,value);
  }
 deleteTrack(id) 
 {
   this.url= "http://localhost:8010/api/v1/track"+"/"+id;
   return this.httpclient.delete(this.url);
 }
 updateTrack(value):Observable<ITracks>
 {  var url2="http://localhost:8010/api/v1/track";
   return this.httpclient.put<ITracks>(url2,value);
 }

 getRecommendList()
 { 
   var url='http://172.23.238.180:8081/api/v1/userrcm'
  return this.httpclient.get(url);
 }
}




