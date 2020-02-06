import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductoService } from 'src/app/_servicio/producto.service';
import { Producto } from 'src/app/_modelo/Producto';

@Component({
  selector: 'app-registrar-producto',
  templateUrl: './registrar-producto.component.html',
  styleUrls: ['./registrar-producto.component.css']
})
export class RegistrarProductoComponent implements OnInit {

  //----------------------------------------------------------------------------------------
  //Variables
  //----------------------------------------------------------------------------------------
  id: number;
  nombres: string;
  apellidos: string;
  cedula: number;
  genero: string;
  edad: number;


  //----------------------------------------------------------------------------------------
  //Contructor
  //----------------------------------------------------------------------------------------
  constructor(private productoService: ProductoService, private route: ActivatedRoute,
               private router: Router) { }

  //----------------------------------------------------------------------------------------
  //Metodo inicializador
  //----------------------------------------------------------------------------------------
  ngOnInit() {

  }

  registrarProducto(){
    let product = new Producto;
    product.id = this.id;
    product.nombres = this.nombres;
    product.apellidos = this.apellidos;
    product.cedula = this.cedula;
    product.genero = this.genero;
    product.edad = this.edad;

    this.productoService.registrarProducto(product).subscribe(data => {  
      setTimeout(()=> {
        this.limpiarControles();
      }, 2000);
      //Para volver a listar todos los productos con el ya creado
      this.productoService.listarProductoss().subscribe(products => {
        //guardamos en la variable refresh los datos nuevo
        this.productoService.productoRefresh.next(products);
        this.router.navigate(['menu']);
        this.productoService.productoMensaje.next('SE REALIZO LA INSERCION');
      })
    });
  }

  limpiarControles(){
    this.nombres = "";
    this.apellidos = "";
    this.cedula = 0;
    this.genero = "";
    this.edad = 0;

  }

}
