import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { GeneralRoutingModule } from './general-routing.module';

import { HomeComponent } from './pages/home/home.component';
import { GastoComponent } from './pages/gasto/gasto.component';
import { GrupoComponent } from './pages/grupo/grupo.component';

import { MaterialModule } from '../material/material.module';
import { CrearGrupoComponent } from './pages/crear_grupo/creargrupo.component';
import { DetalleGrupoComponent } from './pages/detalle_grupo/detallegrupo.component';


// import { HeroesRoutingModule } from './heroes-routing.module';

// import { BuscarComponent } from './pages/buscar/buscar.component';
// import { HeroeComponent } from './pages/heroe/heroe.component';
// import { HeroesHomeComponent } from './pages/heroes-home/heroes-home.component';
// import { AgregarComponent } from './pages/agregar/agregar.component';
// import { ListadoComponent } from './pages/listado/listado.component';

// import { FlexLayoutModule } from '@angular/flex-layout';
// import { HeroeTarjetaComponent } from './components/heroe-tarjeta/heroe-tarjeta.component';
// import { ImagenPipe } from './pipes/imagen.pipe';


@NgModule({
  declarations: [
    HomeComponent,
    GastoComponent,
    GrupoComponent,
    CrearGrupoComponent,
    DetalleGrupoComponent,
    // AgregarComponent,
    // ListadoComponent,
    // HeroeTarjetaComponent,
    // ImagenPipe
  ],
  imports: [
    CommonModule,
    GeneralRoutingModule,
    MaterialModule,
    FormsModule,
    MatSelectModule
    // FlexLayoutModule,
  ]
})
export class GeneralModule { }
