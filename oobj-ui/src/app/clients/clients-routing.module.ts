import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { ClientSaveComponent } from './client-save/client-save.component';
import { ClientsSearchComponent } from './clients-search/clients-search.component';

const routes: Routes = [
  {
    path: 'client',
    component: ClientsSearchComponent,
  },
  {
    path: 'client/new',
    component: ClientSaveComponent,
  },
  {
    path: 'client/:id',
    component: ClientSaveComponent,
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class ClientsRoutingModule { }
