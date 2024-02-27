import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompetitionComponent } from './components/competition-components/competition/competition.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { CompetitionFormComponent } from './components/competition-components/competition-form/competition-form.component';
import { CompetitionDetailsComponent } from './components/competition-components/competition-details/competition-details.component';
import { MemberComponent } from './components/member-components/member/member.component';
import { RankComponent } from './components/rank-components/rank/rank.component';
import {DatePipe, NgOptimizedImage} from "@angular/common";
import { HuntingFormComponent } from './components/hunting-components/hunting-form/hunting-form.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import {AuthInterceptor} from "./auth.interceptor";
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ManagerAreaComponent } from './pages/manager-area/manager-area.component';


@NgModule({
  declarations: [
    AppComponent,
    CompetitionComponent,
    CompetitionFormComponent,
    CompetitionDetailsComponent,
    MemberComponent,
    RankComponent,
    HuntingFormComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    ManagerAreaComponent,


  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        NgOptimizedImage,
    ],
  providers: [DatePipe, {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
