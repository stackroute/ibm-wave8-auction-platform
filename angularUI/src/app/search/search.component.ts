import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { Location } from '@angular/common';
import { AuctionService } from '../auction.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  productList:any;  
  constructor(private searchService: AuctionService, private route: ActivatedRoute, private location: Location,
    private router:Router ) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => 
      {
        let searchString = params.get('value');
        this.searchService.getSearch(searchString).subscribe((data)=> {
          console.log(searchString);
          this.productList = data;
          console.log(this.productList);
          // for (let entry of this.productList)
          // {
          //   console.log(entry);
          //   console.log(".................11.");
          //   for (let item of entry.rentItems){
          //     const result= item.filter(u=> u.itemName==searchString);
          //     console.log(result);
          //     console.log("..................");
          //   }
          }
        
        );
      }

    );
    // bookLand()
    // {
    //   this.router.navigate('/bidding');
    // }

  }
}
