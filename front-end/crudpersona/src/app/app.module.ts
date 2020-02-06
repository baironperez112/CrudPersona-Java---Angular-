import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './paginas/menu/menu.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RegistrarProductoComponent } from './paginas/registrar-producto/registrar-producto.component';

//Angular Material
import {MatCardModule, MatTableModule, MatButtonModule, MatSnackBarModule, MatPaginatorIntl, 
        MAT_DATE_LOCALE, MatPaginatorModule, MatInputModule, MatSortModule,MatIconModule, 
        MatMenuModule, MatSelectModule, MatDialogModule } from '@angular/material';
import { MatPaginatorImpl } from './material/mat-paginator';
import {MatFormFieldModule} from '@angular/material/form-field';
import { ActualizarProductoComponent } from './paginas/menu/actualizar-producto/actualizar-producto.component';
@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RegistrarProductoComponent,
    ActualizarProductoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    //Material
    MatCardModule,
    MatTableModule,
    MatButtonModule,
    MatSnackBarModule,
    MatPaginatorModule,
    MatInputModule,
    MatSortModule,
    HttpClientModule,
    MatIconModule,MatMenuModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDialogModule
    
  ],

  exports: [
    //Material
    MatCardModule,
    MatTableModule,
    MatButtonModule,
    MatSnackBarModule,
    MatPaginatorModule,
    MatInputModule,
    MatSortModule,
    MatIconModule,MatMenuModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDialogModule
  ],


  providers: [

    { provide: MatPaginatorIntl, useClass: MatPaginatorImpl },
    { provide: MAT_DATE_LOCALE, useValue: 'es-Es' }     //pa la fecha arriba hay 3 atributos
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
