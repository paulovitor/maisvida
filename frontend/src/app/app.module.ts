import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {LoginService} from "./service/login.service";
import {AppRoutingModule} from "./app-routing.module";
import {LoginComponent} from "./view/login/login.component";
import {HeaderComponent} from "./view/header/header.component";
import {MedicosModule} from "./view/medico/medicos.module";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MedicosModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
