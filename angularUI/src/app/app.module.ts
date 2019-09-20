import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
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
import { SearchComponent } from './search/search.component';
import { ForgotComponent } from './forgot/forgot.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BeforeloginComponent } from './beforelogin/beforelogin.component';
import { RentItemsComponent } from './rent-items/rent-items.component';
import { UploadFormComponent } from './uploads/upload-form/upload-form.component';
import { AngularFireModule } from 'angularfire2';
import { AngularFireStorageModule } from 'angularfire2/storage';
import { UploadService } from './uploads/shared/upload.service';
import { BiddingpageComponent } from './biddingpage/biddingpage.component';
import { CarouselComponent } from './carousel/carousel.component';
import { ENdComponent } from './end/end.component';
import { RecentComponent } from './recent/recent.component';
import { StatsComponent } from './stats/stats.component';
import { ToprentcategoriesComponent } from './toprentcategories/toprentcategories.component';
import { TrendingComponent } from './trending/trending.component';
import { HeaderComponent } from './header/header.component';
import { ProfileComponent } from './profile/profile.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { CategoryComponent } from './category/category.component';
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
    SearchComponent,
    ForgotComponent,
    BeforeloginComponent,
    RentItemsComponent,
    UploadFormComponent,
    BiddingpageComponent,
    CarouselComponent,
    ENdComponent,
    RecentComponent,
    StatsComponent,
    ToprentcategoriesComponent,
    TrendingComponent,
    ProfileComponent,
    CategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FlexLayoutModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    ReactiveFormsModule,
    AngularFireModule.initializeApp({
      apiKey: "AIzaSyCSwwrR--y0ZlvbJmpKzX8mLAXn3xUhmX4",
      authDomain: "auctionplatform1-666cc.firebaseapp.com",
      storageBucket: "auctionplatform1-666cc.appspot.com",
      projectId: "auctionplatform1-666cc",
    }),
    AngularFireStorageModule,
    NgbModule
  ],
  exports:[],
  providers: [UploadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
