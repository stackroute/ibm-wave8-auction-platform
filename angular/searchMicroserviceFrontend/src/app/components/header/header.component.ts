import { Component, OnInit } from '@angular/core';
import { SearchServiceService } from 'src/app/search-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  productList:any = []; 
  constructor(private searchService: SearchServiceService, private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit() {
  }
  clickSearch(value) {
    
    value = value.toLowerCase();
    console.log(value);
   

    this.router.navigateByUrl("/search/"+value);

  }
}
