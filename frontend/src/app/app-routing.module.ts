import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MedicosComponent} from "./view/medico/medicos.component";
import {LoginComponent} from "./view/login/login.component";
import {MedicoEditComponent} from "./view/medico/medico-edit.component";
import {MedicoViewComponent} from "./view/medico/medico-view.component";

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'medicos', component: MedicosComponent},
  {path: 'medicos/add', component: MedicoEditComponent},
  {path: 'medicos/edit/:id', component: MedicoEditComponent},
  {path: 'medicos/:id', component: MedicoViewComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
