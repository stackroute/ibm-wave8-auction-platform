import { ICategory } from '../models/Category';
export class IUser{
    userName:string;
    userPhoneNumber:number;
    userGender:string;
    userEmail:string;
    userPassword:string;
    userAadharNumber:number;
    category: Array<ICategory>;
}