import {Component, HostListener, OnInit} from '@angular/core';
import {CompetitionRxService} from "./services/competition-service/competitionRx.service";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {filter, switchMap} from "rxjs";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'AFTAS';




    constructor(private router:Router) {

    }


  ngOnInit() {

  }








}
