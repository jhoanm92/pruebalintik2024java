import { Tarea } from "./tarea";

export interface Proyecto {
  id?: number;
  nombre?: string
  descripcion?: string
  tarea?: Tarea[]
}
