import { MatDialogRef } from '@angular/material/dialog';
import { Tarea } from './../../model/tarea';
import { TareaService } from './../../service/tarea.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-tarea-modal',
  templateUrl: './tarea-modal.component.html',
  styleUrls: ['./tarea-modal.component.css']
})
export class TareaModalComponent implements OnInit {

  form: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<TareaModalComponent>,
    private formBuilder: FormBuilder,
    private tareaService: TareaService
  ) { }

  ngOnInit(): void {
    this.formularioVacio();
  }

  formularioVacio() {
    this.form = this.formBuilder.group({
      id: [null],
      nombre: [null, [Validators.required]],
      descripcion: [null, [Validators.required]]
    });
  }

  crearTarea(){
    let tarea: Tarea = {
      nombre : this.nombre.value,
      descripcion : this.descripcion.value
    }
    this.tareaService.registrar(tarea).subscribe(data => {
      this.dialogRef.close(true);
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

}
