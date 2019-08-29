import { Component, OnInit } from '@angular/core';
import { ITracks } from '../modals/ITracks';
import { MuzixService } from '../muzix.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-fav-track',
  templateUrl: './fav-track.component.html',
  styleUrls: ['./fav-track.component.css']
})
export class FavTrackComponent implements OnInit {
  public fTracks:ITracks[];
  public fTrack:ITracks;

  constructor(private muzixService : MuzixService,private router: ActivatedRoute) { }

  ngOnInit() {

    this.muzixService.getAllTracks().subscribe((some) => this.fTracks = some);
  }
  deleteTrack(value)
  {
   this.muzixService.deleteTrack(value)
   .subscribe(data => this.muzixService.deleteTrack(value))
   alert("deleted");
  }

  updateTrack(value)
  {
   this.muzixService.updateTrack(value)
   .subscribe(data => this.muzixService.updateTrack(value))
  }

}
