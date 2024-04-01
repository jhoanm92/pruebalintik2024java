import { Estado } from './estado';

export interface Tarea {
  id?: number;
  nombre?: string
  descripcion?: string
  estado?: Estado
}
