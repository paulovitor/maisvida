import {Component, OnInit} from "@angular/core";
import {Medico} from "../../model/medico";
import {MedicoService} from "../../service/medico.service";
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'medicos',
  templateUrl: 'medicos.component.html'
})
export class MedicosComponent implements OnInit {

  medicos: Medico[];
  selectedMedico: Medico;

  constructor(private router: Router, private medicoService: MedicoService) {
  }

  ngOnInit(): void {
    this.getMedicos();
  }

  onSelect(medico: Medico): void {
    this.selectedMedico = medico;
  }

  onEdit(medico: Medico): void {
    this.router.navigate(['/medicos/edit', medico.id]);
  }

  onView(medico: Medico): void {
    this.router.navigate(['/medicos', medico.id]);
  }

  getMedicos(): void {
    this.medicoService.getMedicos().then(medicos => this.medicos = medicos);
  }
}
