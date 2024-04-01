import { MatTableDataSource } from '@angular/material/table';
import { ProyectoService } from './../../service/proyecto.service';
import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/model/proyecto';

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css']
})
export class ProyectoComponent implements OnInit {

  displayedColumns: string[] = [
    'nombre',
    'descripcion',
    'tarea',
    'acciones'
  ];

  proyectos: Proyecto[] = [];

  dataSource: MatTableDataSource<Proyecto> =  new MatTableDataSource<Proyecto>(this.proyectos);

  constructor(
    public proyectoService: ProyectoService
  ) { }

  ngOnInit(): void {
    this.obtenerProyectos();

  }

  obtenerProyectos() {
    this.proyectoService.obtenerTodos().subscribe(data => {
      this.proyectos = data;
      this.dataSource = new MatTableDataSource(this.proyectos)
    });
  }



  eliminar(id: number){
    this.proyectoService.eliminar(id).subscribe(data => {
      this.obtenerProyectos();
    });
  }

}
