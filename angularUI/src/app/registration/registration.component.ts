import { Component, OnInit } from '@angular/core';
import { IUser } from '../models/user';
import { RegistrationService } from '../service/registration.service';
import { FormGroup, FormBuilder, FormControl, Validators, FormGroupDirective, NgForm } from '@angular/forms';
import { ICategory } from '../models/Category';
import { ErrorStateMatcher } from '@angular/material';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid);
  }
}

function emailDomainValidator(control: FormControl) {
 let email = control.value;
 if (email && email.indexOf("@") != -1) {
   let [_, domain] = email.split("@");
   if (domain !== ".com") {
     return {
       emailDomain: {
         parsedDomain: domain
       }
     }
   }
 }
 return null;
}
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit{
  
  registerForm:FormGroup;
  register = new IUser();
  category:FormControl;
  categoryList:string[]=['Electronics','Car & Bike','Fashion','Antique','Artifacts','Jewellery'];
  constructor(private userService: RegistrationService,private formBuilder:FormBuilder) {
    this.category = new FormControl();
   }

  ngOnInit() {
    this.registerForm=new FormGroup({
      userName: new FormControl("", [Validators.required]),
      userEmail:new FormControl('', Validators.compose([
        Validators.required,
            Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
      ])),
      userPassword: new FormControl("",[Validators.required]),
      PhoneNumber: new FormControl("",
      Validators.compose(
        [
          Validators.required,
          Validators.minLength(10),
          Validators.maxLength(10),
          Validators.pattern('^[6-9][0-9]*')
        ]
      )),
      AadharNumber: new FormControl('',
      Validators.compose([
        Validators.required,
        Validators.minLength(12),
        Validators.maxLength(12),
        Validators.pattern('^[1-9][0-9]*')
      ]
      )),
      userGender: new FormControl("",[Validators.required]),
      category: new FormControl("",[Validators.required])
    });
  }
  registeredUser()
  {
    this.register.userName = this.registerForm.get('userName').value;
    this.register.userEmail = this.registerForm.get('userEmail').value;
    this.register.userPassword = this.registerForm.get('userPassword').value;
    this.register.userPhoneNumber = this.registerForm.get('PhoneNumber').value;
    this.register.userAadharNumber = this.registerForm.get('AadharNumber').value;
    this.register.userGender=this.registerForm.get('userGender').value;
    console.log(this.registerForm.get('category').value);
    console.log(this.register);
    let category = new Array<ICategory>();
    this.registerForm.get('category').value.forEach(element => {
      category.push(element)
    });
    this.register.category = category;
    console.log(this.register)
     this.userService.saveUser(this.register)
    .subscribe(
       response => console.log(response),
       error => console.log(error)
     ) 
  }
  matcher = new MyErrorStateMatcher();

}
