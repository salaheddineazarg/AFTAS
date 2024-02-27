import {CompetitionModel} from "../competition/competition-model";
import {UserModel} from "../user-model";
import {FishModel} from "../fish/fish-model";

export interface HuntingModel{
  id:number,
  numberOfFish:number,
  competition:CompetitionModel,
  fish:FishModel
  member:UserModel
}
