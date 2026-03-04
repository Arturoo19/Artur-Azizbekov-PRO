import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Buscar } from './components/buscar/buscar';
import { Listar } from './components/listar/listar';
import { Agregar } from './components/agregar/agregar';
import { Detail } from './components/detail/detail';
import { FormsModule } from '@angular/forms';
import { Carta } from './components/carta/carta';
import { ImagenPizzaPipe } from './pipes/imagen-pizza-pipe';

@NgModule({
  declarations: [
    App,
    Buscar,
    Listar,
    Agregar,
    Detail,
    Carta,
    ImagenPizzaPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
  ],
  bootstrap: [App]
})
export class AppModule { }
