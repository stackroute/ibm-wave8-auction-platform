import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../service/authentication.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CategoryComponent } from '../category/category.component';
import { ICategory } from '../models/Category';

@Component({
  selector: 'app-beforelogin',
  templateUrl: './beforelogin.component.html',
  styleUrls: ['./beforelogin.component.scss']
})
export class BeforeloginComponent implements OnInit {

  isLoggedIn$: Observable<boolean>;
  loggedIn: boolean;

  constructor(private authenticateService: AuthenticationService, private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit() {
    this.isLoggedIn$ = this.authenticateService.logged;
    this.isLoggedIn$.subscribe(data => {
      this.loggedIn = data;
      console.log(this.loggedIn)
    });
  }
  search(value) {
    console.log(value);
      this.router.navigate(['search/'+value]);
  }
  searchCategory (category)
 {
 console.log(category);
  this.router.navigate(['category/', category]);
}
}
