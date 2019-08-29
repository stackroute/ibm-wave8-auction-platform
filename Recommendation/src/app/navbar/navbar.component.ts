import { Component, OnInit } from '@angular/core';
import { MuzixService } from '../muzix.service';
import {ITracks} from '../modals/ITracks';
import { Router } from '@angular/router';
import { Lastfm } from '../modals/Lastfm';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private muzixService : MuzixService, private router : Router) { }

  ngOnInit() {
  }

  public TrackList : ITracks[];
public playlist : Lastfm;
 /* getPlayList(){
    this.muzixService.getTrack().subscribe((data) =>{
       this.TrackList = data
       this.router.navigateByUrl('/playList');
    })
  }
 */
  getAllTracks()
  {
   this.muzixService.getAllTracks()
   .subscribe(value => {
   this.TrackList=value;
   this.router.navigateByUrl('/wish');
   });
  }

}