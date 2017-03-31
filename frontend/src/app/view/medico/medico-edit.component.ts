import {Component, OnInit} from "@angular/core";
import {Medico} from "../../model/medico";
import {MedicoService} from "../../service/medico.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {Especialidade} from "../../model/especialidade";

@Component({
  moduleId: module.id,
  selector: 'medico-edit',
  templateUrl: 'medico-edit.component.html'
})
export class MedicoEditComponent implements OnInit {

  medico: Medico = new Medico();
  especialidades: string[];

  constructor(private medicoService: MedicoService,
              private route: ActivatedRoute, private location: Location) {
  }

  ngOnInit(): void {
    var options = Object.keys(Especialidade);
    this.especialidades = options.slice(options.length / 2);

    this.medico.estado = 'DF';
    this.medico.cidade = 'Brasilia';
    this.route.params.forEach((params: Params) => {
      let id = +params['id'];
      if (!isNaN(id)) {
        this.medicoService.getMedico(id)
          .then(medico => this.medico = medico);
      }
    });
  }

  parseValue(value : string) {
    this.medico.especialidade = Especialidade[value];
  }

  onSubmit() {
    if (isNaN(this.medico.id))
      this.medicoService.create(this.medico).then(() => this.cancel());
    else
      this.medicoService.update(this.medico).then(() => this.cancel());
  }

  cancel(): void {
    this.location.back();
  }
}
