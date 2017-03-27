import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {LoginService} from "./service/login.service";
import {MedicoService} from "./service/medico.service";
import {MedicosComponent} from "./view/medico/medicos.component";
import {AppRoutingModule} from "./app-routing.module";
import {LoginComponent} from "./view/login/login.component";
import {MedicoEditComponent} from "./view/medico/medico-edit.component";
import {MedicoViewComponent} from "./view/medico/medico-view.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MedicosComponent,
    MedicoEditComponent,
    MedicoViewComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [LoginService, MedicoService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
