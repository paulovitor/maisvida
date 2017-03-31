import {Especialidade} from "./especialidade";
import {Status} from "./status";

export class Medico {
  id: number;
  primeiroNome: string;
  ultimoNome: string;
  especialidade: Especialidade;
  email: string;
  ativo: boolean;
  status: Status;
  estado: string;
  cidade: string;
}
