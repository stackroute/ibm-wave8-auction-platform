import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { Location } from '@angular/common';
import { SearchServiceService } from 'src/app/search-service.service';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  productList:any;  
  constructor(private searchService: SearchServiceService, private route: ActivatedRoute, private location: Location,
    private router:Router ) { }

  ngOnInit() {

//     const myVar = this.route.snapshot.paramMap.get('value');
  

//     console.log("Search in scomp " + myVar);
//    this.searchService.getSearch(myVar).subscribe(data => {
//    console.log("This too works..");
//     this.cropList=data;
//     console.log("Id is " + this.cropList[0].farms[0].location);
    
   
// });

    this.route.paramMap.subscribe((params: ParamMap) => 
      {
        let searchString = params.get('value');
        this.searchService.getSearch(searchString).subscribe((data)=> {
          this.productList = data;
          console.log(this.productList[0]);
        }

        );
      }

    );

  }


}
