import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InputMaskModule } from 'primeng/components/inputmask/inputmask';
import { DataTableModule } from 'primeng/components/datatable/datatable';
import { ButtonModule } from 'primeng/components/button/button';
import { InputTextModule } from 'primeng/components/inputtext/inputtext';
import { TooltipModule } from 'primeng/components/tooltip/tooltip';

import { SharedModule } from './../shared/shared.module';
import { ClientSaveComponent } from './client-save/client-save.component';
import { ClientsSearchComponent } from './clients-search/clients-search.component';
import { ClientsRoutingModule } from './clients-routing.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,

    InputTextModule,
    ButtonModule,
    DataTableModule,
    TooltipModule,
    InputMaskModule,

    SharedModule,
    ClientsRoutingModule
  ],
  declarations: [
    ClientSaveComponent,
    ClientsSearchComponent
  ],
  exports: []
})
export class ClientsModule { }
