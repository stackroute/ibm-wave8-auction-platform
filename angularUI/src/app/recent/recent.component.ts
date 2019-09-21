import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { AuctionService } from '../auction.service';

@Component({
  selector: 'app-recent',
  templateUrl: './recent.component.html',
  styleUrls: ['./recent.component.scss']
})
export class RecentComponent implements OnInit {


   
  // constructor(private recentService: AuctionService,private router:Router ) { }

  //   arrayOfRecentAdded:any=[];
  //   ngOnInit() {
  //     this.getRecentItemsList();
  //     this.getImgUrlList();
  //   }
  
  //   getRecentItemsList()
  //   {
  //     this.recentService.getRecentItems().subscribe(data=>{
  //       this.arrayOfRecentAdded=data
  //     });
  //   }

  //   getImgUrlList()
  //   {
  //     this.recentService.getImgUrl().subscribe(data=>{
  //       this.arrayOfRecentAdded=data
  //     });
  //   }

  //   recent(){
  //     this.router.navigate(['myprofile/']);
  //   }

  // @Input('data') public username: string;
  constructor(private auctionService:AuctionService,private route:ActivatedRoute,private router:Router) { }
    arrayOfProducts:any=[];
    slides: any = [[]];
    userData: any = [];
  userRentItems : any[] = [];
  userSlides: any = [[]];
  ngOnInit() {
   this.getRecentItems();
      }
  getRecentItems():void
  {
    this.auctionService.getRecentItems().subscribe(data=>{
     // console.log(data);
     this.userData = data;
     this.userRentItems = this.userData;
     this.userSlides = this.chunk(this.userRentItems, 3);
     console.log("&&&&&&&&&&&&&&&&&&&&"+this.userSlides)
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
  // getImgUrlList()
  //   {
  //     this.auctionService.getImgUrl().subscribe(data=>{
  //       this.userRentItems=data
  //     });
  //   }

 }
 

