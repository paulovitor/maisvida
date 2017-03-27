import {Component, OnInit} from "@angular/core";
import {Medico} from "../../model/medico";
import {MedicoService} from "../../service/medico.service";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'medico-edit',
  templateUrl: 'medico-edit.component.html'
})
export class MedicoEditComponent implements OnInit {

  medico: Medico;

  constructor(private medicoService: MedicoService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.forEach((params: Params) => {
      let id = +params['id'];
      if (!isNaN(id)) {
        this.medicoService.getMedico(id)
          .then(medico => this.medico = medico);
      }
    });
  }
}
