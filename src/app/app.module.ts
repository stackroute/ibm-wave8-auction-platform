import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { CardComponent } from './card/card.component';
import { HomeComponent } from './home/home.component';
import { HelpdeskComponent } from './helpdesk/helpdesk.component';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { RecommendationsComponent } from './recommendations/recommendations.component';
import { HttpClientModule } from '@angular/common/http';
import {FlexLayoutModule} from '@angular/flex-layout';
import { WishlistComponent } from './wishlist/wishlist.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { CarouselComponent } from './carousel/carousel.component';
import { MatCarouselModule } from '@ngmodule/material-carousel';
import { StatsComponent } from './stats/stats.component';
import { TrendingComponent } from './trending/trending.component';
import { ENdComponent } from './end/end.component';
import { RecentComponent } from './recent/recent.component';
import { ToprentcategoriesComponent } from './toprentcategories/toprentcategories.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
    CardComponent,
    HomeComponent,
    HelpdeskComponent,
    LandingpageComponent,
    RecommendationsComponent,
    WishlistComponent,
    CarouselComponent,
    StatsComponent,
    TrendingComponent,
    ENdComponent,
    RecentComponent,
    ToprentcategoriesComponent,
   
 
   
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FlexLayoutModule,
    NgbModule,
    MDBBootstrapModule.forRoot(),
    MatCarouselModule,
   
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
