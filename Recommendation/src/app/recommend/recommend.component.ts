import { Component, OnInit } from '@angular/core';
import {MuzixService} from '../muzix.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-recommend',
  templateUrl: './recommend.component.html',
  styleUrls: ['./recommend.component.css']
})
export class RecommendComponent implements OnInit {

  constructor(private muzixService:MuzixService,private route:ActivatedRoute,
    private router:Router) { }
    arrayOfProducts:any=[];

  ngOnInit() {
    this.getRecommendList();
  }
  getRecommendList():void
  {
    this.muzixService.getRecommendList().subscribe(data=>{
      console.log(data);
      this.arrayOfProducts=data;
    })
  }

}
