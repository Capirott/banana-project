import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TransactionsSearchComponent } from './transactions-search/transactions-search.component';
import { TransactionSaveComponent } from './transaction-save/transaction-save.component';
import { InputTextModule } from 'primeng/components/inputtext/inputtext';
import { ButtonModule } from 'primeng/components/button/button';
import { DataTableModule } from 'primeng/datatable';
import { TooltipModule } from 'primeng/components/tooltip/tooltip';
import { CalendarModule } from 'primeng/components/calendar/calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SelectButtonModule } from 'primeng/selectbutton';
import { ClientsRoutingModule } from '../clients/clients-routing.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,

    InputTextModule,
    ButtonModule,
    DataTableModule,
    TooltipModule,
    CalendarModule,
    BrowserAnimationsModule,
    SelectButtonModule,
    ClientsRoutingModule,
    FormsModule
  ],
  declarations: [
    TransactionsSearchComponent,
    TransactionSaveComponent],
  exports: [
    TransactionsSearchComponent,
    TransactionSaveComponent
  ]
})
export class TransactionsModule { }
