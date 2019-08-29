import { Component, OnInit } from '@angular/core';
import { MuzixService } from '../muzix.service';
import { Lastfm } from '../modals/Lastfm';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private muzixService : MuzixService, private router : Router) { }

  ngOnInit() {

  }

  // public results : Result;

  getLastFmTracks(searchString){

    this.muzixService.getLastFmTracks(searchString)
    .subscribe((data) => {
      this.muzixService.results = data;
      this.router.navigate(["/track",searchString])
     // console.log("in search",this.muzixService.results)

    });

  }


}