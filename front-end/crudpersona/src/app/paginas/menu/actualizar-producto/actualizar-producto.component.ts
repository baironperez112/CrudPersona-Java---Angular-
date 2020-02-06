import { Component, OnInit } from '@angular/core';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { ProductoService } from 'src/app/_servicio/producto.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Producto } from 'src/app/_modelo/Producto';

@Component({
  selector: 'app-actualizar-producto',
  templateUrl: './actualizar-producto.component.html',
  styleUrls: ['./actualizar-producto.component.css']
})
export class ActualizarProductoComponent implements OnInit {

  //--------------------------------------------------------------------------------------------
  //Variables
  //--------------------------------------------------------------------------------------------
  
  //variable del parametro que entra por url
  id: number;
  //variable del formulario producto
  form: FormGroup;
  //Variable tipo producto en la cual se pretende llenar el objeto con los datos traidos
  producto: Producto;

  //--------------------------------------------------------------------------------------------
  //Constructor
  //--------------------------------------------------------------------------------------------
  constructor(private productoService: ProductoService, private route: ActivatedRoute, 
              private router: Router) 
              {
                this.form = new FormGroup({
                  'id' : new FormControl(0),
                  'nombres' : new FormControl(''),
                  'apellidos' : new FormControl(''),
                  'cedula' : new FormControl(''),
                  'genero' : new FormControl(''),
                  'edad' : new FormControl('')
                });
              }

  //--------------------------------------------------------------------------------------------
  //Metodo de inicializacion
  //--------------------------------------------------------------------------------------------
  
  ngOnInit() {

    //Obtener la variable que llega del routerLink para actualizar
    this.route.params.subscribe((params: Params) => { 
      this.id = params['id']; 

      //Arranca el llenado de los campos
    this.iniciarFormulario();

    //Creamos objeto que se enviara al servicio
    this.producto = new Producto();
    });
  }

  //Metodo para obtener los productos segun el id del registro a atualizar
  iniciarFormulario(){
    this.productoService.obtenerProductById(this.id).subscribe(data => {
      console.log(data);
      this.form = new FormGroup({
        'id' : new FormControl(data.id),
        'nombres' : new FormControl(data.nombres),
        'apellidos' : new FormControl(data.apellidos),
        'cedula' : new FormControl(data.cedula),
        'genero' : new FormControl(data.genero),
        'edad' : new FormControl(data.edad)
      });
    });
  }

  //Metodo encargado de actualizar el registro de productos
  actualizar(){

    this.producto.id = this.form.value['id'];
    this.producto.nombres = this.form.value['nombres'];
    this.producto.apellidos = this.form.value['apellidos'];
    this.producto.cedula = this.form.value['cedula'];
    this.producto.genero = this.form.value['genero'];
    this.producto.edad = this.form.value['edad'];


    //Mandamos la data al servicio actualizar
    this.productoService.actualizarProducto(this.producto).subscribe(data => {
      this.productoService.listarProductoss().subscribe(products => {
        //guardamos en la variable refresh la nueva data
        this.productoService.productoRefresh.next(products);
        //para enviar mensaje de actualizacion
        this.productoService.productoMensaje.next('Se hizo la Actualizacion'); 
        this.router.navigate(['menu']);
      });
    });
  }

}
