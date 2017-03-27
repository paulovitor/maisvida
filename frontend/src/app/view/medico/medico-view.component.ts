import {Component, OnInit} from "@angular/core";
import {Medico} from "../../model/medico";
import {MedicoService} from "../../service/medico.service";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'medico-view',
  templateUrl: 'medico-view.component.html'
})
export class MedicoViewComponent implements OnInit {

  medico: Medico;

  constructor(private medicoService: MedicoService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.forEach((params: Params) => {
      let id = +params['id'];
      this.medicoService.getMedico(id)
        .then(medico => this.medico = medico);
    });
  }
}
