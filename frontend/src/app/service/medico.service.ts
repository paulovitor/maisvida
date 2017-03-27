import {Injectable} from "@angular/core";
import {Http} from "@angular/http";

import "rxjs/add/operator/toPromise";

import {Medico} from "../model/medico";

@Injectable()
export class MedicoService {

  private medicosUrl = 'api/medicos';

  constructor(private http: Http) {
  }

  getMedicos(): Promise<Medico[]> {
    return this.http.get(this.medicosUrl)
      .toPromise()
      .then(response => response.json() as Medico[])
      .catch(this.handleError);
  }

  getMedico(id: number): Promise<Medico> {
    const url = `${this.medicosUrl}/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Medico)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
