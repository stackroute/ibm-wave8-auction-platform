import { Component, OnInit } from '@angular/core';
import { AuctionService } from '../auction.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  
  private username: string;
  userData: any = [];
  userRentItems : any[] = [];
  userSlides: any = [[]];

  constructor(private auctionService: AuctionService, private route: ActivatedRoute,
    private router: Router, private config: NgbCarouselConfig) {
    this.username = this.route.snapshot.params.id;
    console.log(this.username);
    this.auctionService.getUserInfo(this.username).subscribe(data => {
      console.log(data);
      this.userData = data;
      this.userRentItems = this.userData.rentItems;
      this.userSlides = this.chunk(this.userRentItems, 3);
    });
  }

  ngOnInit() {
  }

  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }
  check()
{
  this.router.navigate(['landing/'+this.username]);
}

}
