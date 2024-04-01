import { Estado } from './../../model/estado';
import { EstadoService } from './../../service/estado.service';
import { Tarea } from './../../model/tarea';
import { TareaService } from './../../service/tarea.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';
import { MatDialog } from '@angular/material/dialog';
import { TareaModalComponent } from '../tarea-modal/tarea-modal.component';

@Component({
  selector: 'app-tareas',
  templateUrl: './tareas.component.html',
  styleUrls: ['./tareas.component.css']
})
export class TareasComponent implements OnInit {

  displayedColumns: string[] = [
    'nombre',
    'descripcion',
    'estado',
    "acciones"
  ];

  idProyecto: number;
  proyecto: Proyecto = {};
  tareasIndividuales: Tarea[] = [];
  tareasAguardar?: Tarea[] = [];
  estados: Estado[] = []
  form: FormGroup;
  formEstado: FormGroup;

  dataSource: MatTableDataSource<Tarea> =  new MatTableDataSource<Tarea>(this.tareasAguardar);

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    public proyectoService: ProyectoService,
    public tareaService: TareaService,
    public estadoService: EstadoService,
    private formBuilder: FormBuilder,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.obtenerProyecto();
    this.obtenerTareas();
    this.obtenerEstados();
    this.formularioEstado();
  }

  obtenerTareas() {
    this.tareaService.obtenerTodos().subscribe(data => {
      this.tareasIndividuales = data;
    });
  }

  obtenerEstados() {
    this.estadoService.obtenerTodos().subscribe(data => {
      this.estados = data;

    });
  }

  crearTarea(){
    let dialogRef = this.dialog.open(TareaModalComponent);

    dialogRef.afterClosed().subscribe(res =>{
      if(res){
        this.obtenerTareas();
      }
    });
  }

  obtenerProyecto(){
    this.formularioVacio();

    this.activatedRoute.paramMap.subscribe(params => {
      this.idProyecto =  Number(params.get('id'));

      if (this.idProyecto === 0) return

      this.proyectoService.obtenerPorId(this.idProyecto).subscribe(data => {
      this.proyecto = data;
      this.iniciarFormulario();
      this.iniciarTablaTareas();
      });
    });
  }

  iniciarFormulario(){
    this.formularioVacio();

    if (this.idProyecto === 0) return;

    this.editarFormulario();
  }

  formularioVacio() {
    this.form = this.formBuilder.group({
      id: [null],
      nombre: [null, [Validators.required]],
      descripcion: [null, [Validators.required]],
      tareas: [null, [Validators.required]]
    });
  }

  editarFormulario() {
      this.id.setValue(this.proyecto.id);
      this.nombre.setValue(this.proyecto.nombre);
      this.descripcion.setValue(this.proyecto.descripcion);
      // this.tareas.setValue(this.proyecto.tarea);
  }

  iniciarTablaTareas(){
    this.tareasAguardar = this.proyecto.tarea;
    this.dataSource = new MatTableDataSource(this.tareasAguardar)
  }

  formularioEstado(){
    this.formEstado = new FormGroup({
      estodoForm: new FormControl(null),
    });
  }

  agregarTarea(){
    if (this.tareas.value === null) return;
    this.tareasAguardar?.push(this.tareas.value);

    if  (this.idProyecto == 0) {
      this.proyectoService.registrar(this.obtenerFormulario()).subscribe(data => {
        this.router.navigate(['/tareas', data.id]);
      });
    } else {
    this.proyectoService.actualizar(this.obtenerFormulario()).subscribe(data => { });
    }
    this.tareas.setValue(null);
    this.dataSource = new MatTableDataSource(this.tareasAguardar);
  }

  obtenerFormulario(): Proyecto{
    let obj: Proyecto = {

    }

    obj.id = this.idProyecto;
    obj.nombre = this.nombre.value;
    obj.descripcion = this.descripcion.value;
    obj.tarea = this.tareasAguardar;

    return obj;
  }

  eliminarTarea(i: number){

    this.tareasAguardar = this.tareasAguardar?.filter((value, index) => {
      return index !== i;
    });
    this.proyecto.tarea = this.tareasAguardar;
    this.proyectoService.actualizar(this.proyecto).subscribe(data => {
      this.tareas.setValue(null);
    });
    this.dataSource = new MatTableDataSource(this.tareasAguardar);
  }

  cambioEstado(tarea: Tarea){
    console.log(tarea);

    this.tareaService.actualizar(tarea).subscribe(data => {
      this.obtenerProyecto();
    });
  }

  // ------------------------------ get form ------------------------------
  get id() {
    return this.form.get("id")!;
  }

  get nombre() {
    return this.form.get("nombre")!;
  }

  get descripcion() {
    return this.form.get("descripcion")!;
  }

  get tareas() {
    return this.form.get("tareas")!;
  }

}
