import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../auth/auth.service";
import {UserModel} from "../../models/user-model";
import {IdentityDocType} from "../../enum/identityDocType";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import Swal from "sweetalert2";
import {Role} from "../../enum/Role";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  countries:any[];

  constructor(private router:Router,private authService:AuthService ) {
  authService.getCounties().subscribe(
      countries => {
        this.countries = countries.map(country => country.name.common);
      }
    )

  }

  formSignup = new FormGroup({
    firstName:new FormControl('',Validators.required),
    lastName:new FormControl('',Validators.required),
    email:new FormControl('',Validators.email),
    password:new FormControl('',Validators.required),
    accessionDate:new FormControl('',Validators.required),
    country:new FormControl('',Validators.required),
    identityDoc:new FormControl('',Validators.required),
    identityNumber:new FormControl('',Validators.required),
    role:new FormControl('',Validators.required)
  })


  signup(){
    const newUser:UserModel = {
      name:this.formSignup.value.firstName,
      familyName:this.formSignup.value.lastName,
      email:this.formSignup.value.email,
      password:this.formSignup.value.password,
      role:this.formSignup.value.role as Role,
      accessionDate: new Date(this.formSignup.value.accessionDate),
      nationality:this.formSignup.value.country,
      identityDocumentType: this.formSignup.value.identityDoc as IdentityDocType,
      identityNumber:this.formSignup.value.identityNumber
    }
    this.authService.register(newUser).subscribe(
      user =>{
        console.log(user);
        this.router.navigate(['/login'])
        Swal.fire({
          position: "top-end",
          icon: "success",
          title: "The User is add",
          showConfirmButton: false,
          background:"#07f104",
          iconColor:"black",
          toast:true,
          timer: 1500
        });
      },error => {
        Swal.fire({
          position: "top-end",
          icon: "error",
          title: "The User didn't added",
          showConfirmButton: false,
          background:"red",
          iconColor:"black",
          toast:true,
          timer: 1500
        });
        console.error(error);
      });



  }









}
