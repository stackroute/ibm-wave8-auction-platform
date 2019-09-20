import { Component, OnInit } from '@angular/core';
import { AuthenticationService} from '../service/authentication.service'
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  username:string;
  // password = ''
  loginform:FormGroup;
  invalidLogin = false
  constructor(private router: Router,
    private loginservice: AuthenticationService,private route:ActivatedRoute) { }
  ngOnInit() {
    

  }
  checkLogin(username, password) {
    console.log(username);
    (this.loginservice.authenticate(username, password).subscribe(
      data => {
        // this.router.navigate(['/landing/'], {queryParams: { username}})
        console.log(username);
        this.router.navigate(['landing/'+username]);
        //this.router.navigate([this.loginform.get('username').value+'/landing'])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
        alert("Either yor email or password is incorrect ");
      }
    )
    );
    
    
  }
}
