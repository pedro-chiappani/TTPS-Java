import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GrupoComponent } from './pages/grupo/grupo.component';
import { GastoComponent } from './pages/gasto/gasto.component';
import { HomeComponent } from './pages/home/home.component';
import { CrearGrupoComponent } from './pages/crear_grupo/creargrupo.component';
import { GastoPorGrupoComponent} from './pages/gastos_por_grupo/gastosporgrupo.component';

// import { AgregarComponent } from './pages/agregar/agregar.component';
// import { BuscarComponent } from './pages/buscar/buscar.component';
// import { HeroeComponent } from './pages/heroe/heroe.component';
// import { HeroesHomeComponent } from './pages/heroes-home/heroes-home.component';
// import { ListadoComponent } from './pages/listado/listado.component';



const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: 'grupo',
        component: GrupoComponent
      },
      {
        path: 'creargrupo',
        component: CrearGrupoComponent
      },
      {
        path: 'gastosPorGrupo/:idGrupo',
        component: GastoPorGrupoComponent
      },
      // {
      //   path: 'editar/:id',
      //   component: AgregarComponent
      // },
      // {
      //   path: 'buscar',
      //   component: BuscarComponent
      // },
      // {
      //   path: ':id',
      //   component: HeroeComponent
      // },
      {
        path: '**',
        redirectTo: 'home'
      }
    ]
  }
];

@NgModule({  
  imports: [
    RouterModule.forChild( routes )
  ],
  exports: [
    RouterModule
  ]
})
export class GeneralRoutingModule { }


