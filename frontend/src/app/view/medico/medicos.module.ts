import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {MedicosRoutingModule} from "./medicos-routing.module";
import {MedicosComponent} from "./medicos.component";
import {MedicoEditComponent} from "./medico-edit.component";
import {MedicoViewComponent} from "./medico-view.component";
import {MedicoService} from "../../service/medico.service";

@NgModule({
  imports: [
    FormsModule,
    MedicosRoutingModule
  ],
  declarations: [
    MedicosComponent,
    MedicoEditComponent,
    MedicoViewComponent
  ],
  providers: [MedicoService]
})
export class MedicosModule {
}
