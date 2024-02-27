import {CompetitionModel} from "../competition/competition-model";
import {UserModel} from "../user-model";

export interface RankModel{
  competition:CompetitionModel,
  member:UserModel,
  score?:number,
  rank?:number
}
