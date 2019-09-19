import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-helpdesk',
  templateUrl: './helpdesk.component.html',
  styleUrls: ['./helpdesk.component.scss']
})
export class HelpdeskComponent implements OnInit {
  private username: string;

  // email = new FormControl('', [Validators.required, Validators.email]);

  // getErrorMessage() {
  //   return this.email.hasError('required') ? 'You must enter a value' :
  //       this.email.hasError('email') ? 'Not a valid email' :
  //           '';
  // }
  constructor(private route:ActivatedRoute,private router:Router) {
    this.username = this.route.snapshot.params.id;
    console.log(this.username);
   }

  ngOnInit() {
  }
  notification()
  {
    alert("We will get back to you soon. Thank You");
  }
check()
{
  this.router.navigate(['landing/'+this.username]);
}
}
