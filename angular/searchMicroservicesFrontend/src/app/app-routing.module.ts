import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'/app-home'},
  {path:'app-home',component:HomeComponent},
  { path: 'search/:value', component: SearchComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponent=[SearchComponent];
