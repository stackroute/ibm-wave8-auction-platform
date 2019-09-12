import { Component, OnInit } from '@angular/core';
import { AuctionService } from '../auction.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.scss']
})
export class RecommendationsComponent implements OnInit {

  constructor(private auctionService:AuctionService,private route:ActivatedRoute,
    private router:Router) { }
    arrayOfProducts:any=[];
    slides: any = [[]];

    chunk(arr, chunkSize) {
      let R = [];
      for (let i = 0, len = arr.length; i <= len; i = i + chunkSize) {
        R.push(arr.slice(i, i + chunkSize));
      }
      return R;
    }
   
  ngOnInit() {
    //this.click();
   this.getRecommendList();
 
    //this.slides = this.chunk(this.arrayOfProducts,3);
  

  }
  getRecommendList():void
  {
    this.auctionService.getRecommendList().subscribe(data=>{
      console.log(data);
      this.arrayOfProducts=data;
    });
    
  }

  addToWishList(value) {
    this.auctionService.addToWishList(value);
    this.router.navigateByUrl("favs");
  }
  

  click()
  {
    this.slides = this.chunk(this.arrayOfProducts,3);
  }
}



