import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hulckstorepro';

  //-------------------------------------------------------------------------------
  //Constructor
  //-------------------------------------------------------------------------------
  constructor(private route: ActivatedRoute, private router: Router){}

  //-------------------------------------------------------------------------------
  //Metodo Inicializador
  //-------------------------------------------------------------------------------
  ngOnInit(){
    this.irMenu();
  }

  //-------------------------------------------------------------------------------
  //CMetodos y Funciones
  //-------------------------------------------------------------------------------

  irMenu(){
    this.router.navigate(['menu']);
  }
}
