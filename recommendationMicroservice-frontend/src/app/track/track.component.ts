import { Component, OnInit } from '@angular/core';
import {ITracks} from '../modals/ITracks';
import {MuzixService} from '../muzix.service';
import { ActivatedRoute, ParamMap } from '@angular/router';


@Component({
  selector: 'app-track',
  templateUrl: './track.component.html',
  styleUrls: ['./track.component.css']
})
export class TrackComponent implements OnInit {

  public tracks : ITracks[];
  public track : ITracks;


  constructor(private muzixService : MuzixService, private route : ActivatedRoute ) { 
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) =>
    {
      let searchString = params.get('searchString');
      this.muzixService.getLastFmTracks(searchString).subscribe((data) =>this.tracks = data.results.trackmatches.track);
     });
  }
  addTracksToWishList(value)
  {
   this.muzixService.addTracksToWishList(value)
   .subscribe(data => this.muzixService.addTracksToWishList(value))
   alert("Added");
  }
}
