import { Component } from '@angular/core';
import {AuthService} from "../../auth/auth.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginModel} from "../../models/login-model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private authService:AuthService,private router:Router) {

  }

  formLogin = new FormGroup({
    email:new FormControl('',Validators.email),
    password:new FormControl('',Validators.required)
  })

  login(){
    const loginUser : LoginModel  = {
      email:this.formLogin.value.email,
      password:this.formLogin.value.password
    }
    this.authService.login(loginUser).subscribe(
    response => {

      this.authService.setId(response.user.num)
      this.authService.setEmail(response.user.email)
      this.authService.setRole(response.user.role)
      this.authService.setToken(response.access_token)
      if (this.authService.getToken()){
        this.router.navigate(['/competitions'])
      }


    }
    )
  }
}
