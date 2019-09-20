import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-landingpage',
  templateUrl: './landingpage.component.html',
  styleUrls: ['./landingpage.component.scss'],
  providers: [
    LoginComponent
  ]
})
export class LandingpageComponent implements OnInit {
public username="";


  constructor(private route: ActivatedRoute,
    private router:Router) { 
      this.username=this.route.snapshot.params.id;
      console.log(this.username);
    }

  ngOnInit() {
  }

}
