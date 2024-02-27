import {IdentityDocType} from "../enum/identityDocType";
import {Role} from "../enum/Role";


export interface UserModel {

  num?:number,
  name:string,
  familyName:string,
  email:string
  password:string,
  role:Role
  accessionDate:Date,
  nationality:string,
  identityDocumentType:IdentityDocType,
  identityNumber:string
  access_token?:string

}
