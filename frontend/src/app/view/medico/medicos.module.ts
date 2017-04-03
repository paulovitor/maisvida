import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {MedicosRoutingModule} from "./medicos-routing.module";
import {MedicosComponent} from "./medicos.component";
import {MedicoEditComponent} from "./medico-edit.component";
import {MedicoViewComponent} from "./medico-view.component";
import {MedicoService} from "../../service/medico.service";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {HeaderComponent} from "../header/header.component";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MedicosRoutingModule
  ],
  declarations: [
    MedicosComponent,
    MedicoEditComponent,
    MedicoViewComponent,
    HeaderComponent
  ],
  providers: [MedicoService]
})
export class MedicosModule {
}
