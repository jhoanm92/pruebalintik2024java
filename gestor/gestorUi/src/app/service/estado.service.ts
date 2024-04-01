import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estado } from '../model/estado';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  constructor(
    public http: HttpClient
  ) { }

  obtenerTodos(): Observable<Estado[]> {
    return this.http.get<Estado[]>(`${environment.HOST}/estados`);
  }
}
