import {Injectable} from "@angular/core";
import {Subject} from "rxjs";
import {UserModel} from "../../models/user-model";


@Injectable({
  providedIn: 'root'
})

export class MemberRxService{

  private memberSubject :Subject<UserModel[]> = new Subject<UserModel[]>();
  private memberOneSubject:Subject<UserModel>= new Subject<UserModel>()
  members$=this.memberSubject.asObservable();
  member$=this.memberOneSubject.asObservable()



  getMemmbers(members:UserModel[]){
    this.memberSubject.next(members);
  }

  setOneMember(member:UserModel){
    this.memberOneSubject.next(member);
  }
}
