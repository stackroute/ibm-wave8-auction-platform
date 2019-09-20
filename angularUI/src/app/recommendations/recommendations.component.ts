import { Component, OnInit, Input } from '@angular/core';
import { AuctionService } from '../auction.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.scss']
})
export class RecommendationsComponent implements OnInit {
  @Input('data') public username: string;
  private itemid:number;

  constructor(private auctionService:AuctionService,private route:ActivatedRoute,
    private router:Router) {
    //   this.itemid = this.route.snapshot.params.id;
    //   console.log("*****************************")
    //  console.log("id="+this.itemid);
  //this.router.navigate(['/bidding',{itemid:this.itemid}]);
  }
    
    arrayOfProducts:any=[];
    slides: any = [[]];
    userData: any = [];
  userRentItems : any[] = [];
  userSlides: any = [[]];

    
   
  ngOnInit() {
   this.getRecommendList();

      }
   
  getRecommendList():void
  {
    this.auctionService.getRecommendList(this.username).subscribe(data=>{
     // console.log(data);
     this.userData = data;
     this.userRentItems = this.userData;
     console.log(this.userRentItems)
     this.userSlides = this.chunk(this.userRentItems, 3);
     console.log(this.userSlides)
    });
    
  }
  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize)
     {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }
  addToWishList(value) {
    this.auctionService.addToWishList(value);
    this.router.navigateByUrl("favs");
  }
  // bidding(itemid)
  // {
  //   console.log(itemid);
  //  this.router.navigate(['/biddingpage'], { queryParams: { itemid: itemid } });
  //     }
}



