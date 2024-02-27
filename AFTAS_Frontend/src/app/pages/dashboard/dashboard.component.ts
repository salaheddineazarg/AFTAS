import {Component, HostListener} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {AuthService} from "../../auth/auth.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  modal=false;
  role=this.authService.getRole() ? this.authService.getRole() : "";
  display!:boolean;
  buttonDisplay=false;



  constructor(private router:Router,private authService:AuthService) {

  }


  ngOnInit() {

  }




  showModal(){
    this.modal =! this.modal;
  }


  logout(){

    localStorage.clear();
    this.router.navigate(['/login'])
  }


  @HostListener('window:scroll', ['$event'])
  onScroll(event: Event): boolean {
    const element = event.target as HTMLElement;
    const scrollTop = element.scrollTop;
    const visibleHeight = element.clientHeight;
    const scrollHeight = element.scrollHeight;
    const bottomOfScroll = scrollTop + visibleHeight >= scrollHeight - 100;
    if (bottomOfScroll) {

      return this.display = true;
    }else {
      return this.display = false;
    }

  }
}
