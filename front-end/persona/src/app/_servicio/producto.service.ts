import { Injectable } from '@angular/core';
import { Producto } from '../_modelo/Producto';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

   //variables reactivaz para refrescar la tabla Producto cuando se haga algo como editar
   productoRefresh = new Subject<Producto[]>();
   productoMensaje = new Subject<string>();
   
 
   //End-Point de los servicios en java
   url1: string = 'http://localhost:8888/apiPersonas/todosLosPersonas';
   url2: string = 'http://localhost:8888/apiPersonas/registrarPersona';
   url3: string = 'http://localhost:8888/apiPersonas/borrarPersonaById';
   url4: string = 'http://localhost:8888/apiPersonas/actualizarPersona';
   url6: string = 'http://localhost:8888/apiPersonas/obtenerPersonaById';
 
   //----------------------------------------------------------------------------------------
   //Constructor
   //----------------------------------------------------------------------------------------
 
   //Inyecto deppendencia al constructor de tipo HTTP
   constructor(private http: HttpClient) { }
 
   //----------------------------------------------------------------------------------------
   //Metodos y funciones
   //----------------------------------------------------------------------------------------
 
   //Servicio encargado de listar todos los productos
   listarProductoss(){
     return this.http.get<Producto[]>(this.url1);
   }
 
   //Servicio para registrar un Producto
   registrarProducto(producto : Producto){
     return this.http.post(this.url2, producto);
   }
 
   //Servicio para vender un producto
   venderProducto(id: number){
     return this.http.delete(`${this.url3}/${id}`);
   }
 
   //Servicio para actualizar el producto
   actualizarProducto(producto: Producto){
     return this.http.put(this.url4, producto);
   }
 
   //Servicio  para otener un producto por id
   obtenerProductById(id: number){
     return this.http.get<Producto>(`${this.url6}/${id}`);
   }
}
