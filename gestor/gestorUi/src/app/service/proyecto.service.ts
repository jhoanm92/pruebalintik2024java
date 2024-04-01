import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Proyecto } from '../model/proyecto';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {

  constructor(
    public http: HttpClient
  ) { }

  obtenerTodos(): Observable<Proyecto[]> {
    return this.http.get<Proyecto[]>(`${environment.HOST}/proyectos`);
  }

  obtenerPorId(id: number): Observable<Proyecto> {
    return this.http.get<Proyecto>(`${environment.HOST}/proyectos/${id}`);
  }

  registrar(proyecto: Proyecto): Observable<Proyecto> {
    return this.http.post<Proyecto>(`${environment.HOST}/proyectos`, proyecto);
  }

  actualizar(proyecto: Proyecto): Observable<Proyecto> {
    return this.http.put<Proyecto>(`${environment.HOST}/proyectos`, proyecto);
  }

  eliminar(id: number): Observable<Proyecto[]> {
    return this.http.delete<Proyecto[]>(`${environment.HOST}/proyectos/${id}`);
  }
}
