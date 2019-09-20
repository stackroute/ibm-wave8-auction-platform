import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuctionService } from '../auction.service';
// import { Observable } from 'rxjs';
import { LoginComponent } from '../login/login.component';
// import { User } from '../service/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {


  productList:any = [];
  @Input('data') public username: string;

  constructor(private searchService: AuctionService, private route: ActivatedRoute,
    private router:Router,private loginObj:LoginComponent) { 
      this.username=this.route.snapshot.params.id;
      console.log(this.username);
    }

   
    // user = this.loginObj.username;
    
    // user;

    // receiveuser($event)
    // {
    //   this.user = $event;
    // }
    
   
  ngOnInit() {
  }

  // clickSearch(value):any {
  //   // value=value.equalIgnoreCase();
  //   this.router.navigate(['/search/',value]);
   
  // }
  uploadRentItems()
  {
    this.router.navigate(['rentItems/'+this.username]);

  }
  profile()
  {
    this.router.navigate(['myprofile/'+this.username]);

  }
  search(value) {
    console.log(value);
      this.router.navigate(['search/'+value]);
  }
  helpDesk(){
    this.router.navigate(['helpdesk/'+this.username]);
  }
  searchCategory (category)
  {
  console.log(category);
   this.router.navigate(['category/'+category]);
 }

}
