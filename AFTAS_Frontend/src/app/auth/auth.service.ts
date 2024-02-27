import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable} from "rxjs";
import {ConfigService} from "../config/config.service";
import {LoginModel} from "../models/login-model";
import {UserModel} from "../models/user-model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl: string = 'http://localhost:8080/auth';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private http: HttpClient, private configService: ConfigService) {}

  //signin

  login(loginUser:LoginModel){
    return this.http.post<any>(`${this.baseUrl}/authenticate`,loginUser
    , this.httpOptions).
    pipe(catchError((error) => this.configService.handleError(error)));
  }

  //signup

  register(signup:UserModel){
    return this.http.post<any>(`${this.baseUrl}/register`,
      signup,this.httpOptions).
    pipe(catchError((error) => this.configService.handleError(error)));
  }


  getCounties(){
    return this.http.get<any>("https://restcountries.com/v3.1/all");
  }
  //credentiels getter

  getRole():string|null{
    return localStorage.getItem("role");
  }

  getEmail():string|null{
    return localStorage.getItem("email");
  }

  getId():string|null{
    return localStorage.getItem("id");
  }

  getToken():string|null{
    return localStorage.getItem("token");
  }

  //credentiels setter

  setRole(role:string):void{
    localStorage.setItem("role", role);
  }

  setEmail(email: string):void{
    localStorage.setItem("username", email);
  }

  setId(id:string):void{
    localStorage.setItem("id", id);
  }

  setToken(token:string):void{
    localStorage.setItem("token", token);
  }
}
