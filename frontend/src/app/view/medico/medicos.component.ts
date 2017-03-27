import {Component, OnInit} from "@angular/core";
import {Medico} from "../../model/medico";
import {Router} from "@angular/router";
import {MedicoService} from "../../service/medico.service";

@Component({
  moduleId: module.id,
  selector: 'medicos',
  templateUrl: 'medicos.component.html'
})
export class MedicosComponent implements OnInit {

  medicos: Medico[];
  selectedMedico: Medico;

  constructor(private medicoService: MedicoService) {
  }

  ngOnInit(): void {
    this.getMedicos();
  }

  onSelect(medico: Medico): void {
    this.selectedMedico = medico;
  }

  getMedicos(): void {
    this.medicoService.getMedicos().then(medicos => this.medicos = medicos);
  }
}
