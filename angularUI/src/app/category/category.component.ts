import { Component, OnInit } from '@angular/core';

import { SearchItemService } from '../service/search-item.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ICategory } from '../models/Category';
@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  constructor(private categoryService: SearchItemService, private router: Router, private route: ActivatedRoute) { }
  private items: any;
  private sortedItems: any = [];
  private category: string;
  private demoValues: any;
  ngOnInit() {
    this.getItemByCategory();
  }
  getItemByCategory() {
    this.category = this.route.snapshot.params.id;
    console.log("bhawana" + this.category);
    let c = new ICategory();
    c.name = this.category;
    console.log("pranitha"+c)
    console.log("pranitha"+c.name)

    this.categoryService.searchItems(c)
      .subscribe(
        response => {
          console.log("pallavi" + response),
           this.demoValues = Object.values(response);
          this.sortedItems = [].concat(...this.demoValues),
            console.log('after assigning', this.sortedItems)

       },
      // response => console.log("pallavi"+response),
        //error => console.log(error)
      );


  }

}
