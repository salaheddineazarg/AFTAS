import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {AuthService} from "./auth.service";

export const AuthGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router=inject(Router)
  const {role} = route.data;
  console.log(role);
  if(role.includes(authService.getRole())){
    return true;
  }else {
    router.navigate(['/login'])
    return false;
  }


};
