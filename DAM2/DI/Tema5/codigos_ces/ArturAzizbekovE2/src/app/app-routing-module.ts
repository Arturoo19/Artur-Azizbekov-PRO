import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Detalles } from './components/detalles/detalles';

const routes: Routes = [
  {path:"detalle",component:Detalles},
  {path:"**",pathMatch:'full',redirectTo:"libros"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
