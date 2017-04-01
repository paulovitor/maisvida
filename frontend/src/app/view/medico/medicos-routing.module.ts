import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {MedicosComponent} from "./medicos.component";
import {MedicoEditComponent} from "./medico-edit.component";
import {MedicoViewComponent} from "./medico-view.component";

const medicosRoutes: Routes = [
  {path: 'medicos', component: MedicosComponent},
  {path: 'medicos/add', component: MedicoEditComponent},
  {path: 'medicos/edit/:id', component: MedicoEditComponent},
  {path: 'medicos/:id', component: MedicoViewComponent}
];

@NgModule({
  imports: [RouterModule.forChild(medicosRoutes)],
  exports: [RouterModule]
})
export class MedicosRoutingModule {
}
