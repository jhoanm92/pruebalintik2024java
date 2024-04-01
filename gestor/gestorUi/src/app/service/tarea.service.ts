import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarea } from '../model/tarea';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  constructor(
    public http: HttpClient
  ) { }

  obtenerTodos(): Observable<Tarea[]> {
    return this.http.get<Tarea[]>(`${environment.HOST}/tareas`);
  }

  obtenerPorId(id: number): Observable<Tarea> {
    return this.http.get<Tarea>(`${environment.HOST}/tareas/${id}`);
  }

  registrar(Tarea: Tarea): Observable<Tarea> {
    return this.http.post<Tarea>(`${environment.HOST}/tareas`, Tarea);
  }

  actualizar(Tarea: Tarea): Observable<Tarea> {
    return this.http.put<Tarea>(`${environment.HOST}/tareas`, Tarea);
  }

  eliminar(id: number): Observable<Tarea[]> {
    return this.http.delete<Tarea[]>(`${environment.HOST}/tareas/${id}`);
  }
}
