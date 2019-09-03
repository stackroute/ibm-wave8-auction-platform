import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrackComponent } from './track/track.component';
import { HomeComponent } from './home/home.component';
import {FavTrackComponent} from './fav-track/fav-track.component';
import { from } from 'rxjs';
import {RecommendComponent} from './recommend/recommend.component';
const routes: Routes = [

  {
    path : '',
    component:HomeComponent
  },
  {
    path : 'track',
    component:TrackComponent
  },
  {
    path : 'track/:searchString',
    component:TrackComponent
  },
  {
    path:'wish',
    component: FavTrackComponent

  },
  {
    path:'recommend',
    component: RecommendComponent

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
