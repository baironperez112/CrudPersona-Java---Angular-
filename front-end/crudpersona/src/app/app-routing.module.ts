import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './paginas/menu/menu.component';
import { RegistrarProductoComponent } from './paginas/registrar-producto/registrar-producto.component';
import { ActualizarProductoComponent } from './paginas/menu/actualizar-producto/actualizar-producto.component';

const routes: Routes = [
  { path: 'menu', component: MenuComponent, children: [
     {path: 'actualizarProducto/:id', component: ActualizarProductoComponent}
  ]},
  
  { path: 'registrarProducto', component: RegistrarProductoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }