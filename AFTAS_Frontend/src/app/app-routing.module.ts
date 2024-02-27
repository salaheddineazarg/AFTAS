import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CompetitionComponent} from "./components/competition-components/competition/competition.component";
import {
  CompetitionDetailsComponent
} from "./components/competition-components/competition-details/competition-details.component";
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";

import {DashboardComponent} from "./pages/dashboard/dashboard.component";
import {AuthGuard} from "./auth/auth.guard";

const routes: Routes = [
  {path:'',component:DashboardComponent,
    children:[
      {path:'competitions',component:CompetitionComponent},
      {path:'competition/:code',component:CompetitionDetailsComponent},
    ]
   ,data:{
    role:["Member","Manager","Jury"]
    },
    canActivate:[AuthGuard]
  }
  ,

  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
