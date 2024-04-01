import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProyectoComponent } from './modules/proyecto/proyecto.component';
import { TareasComponent } from './modules/tareas/tareas.component';

const routes: Routes = [
  {path: "proyectos", component: ProyectoComponent},
  {path: "tareas", component: TareasComponent},
  {path: "tareas/:id", component: TareasComponent},
  {path: "", pathMatch: "full", redirectTo: "proyectos"},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
