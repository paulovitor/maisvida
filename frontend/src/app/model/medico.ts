import {Especialidade} from "./especialidade";
import {Status} from "./status";
import {Endereco} from "./endereco";

export class Medico {
  id: number;
  primeiroNome: string;
  ultimoNome: string;
  especialidade: Especialidade;
  email: string;
  ativo: boolean;
  status: Status;
  endereco: Endereco;
}
