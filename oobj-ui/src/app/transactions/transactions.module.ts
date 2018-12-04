import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TransactionSearchComponent } from './transaction-search/transaction-search.component';
import { TransactionSaveComponent } from './transaction-save/transaction-save.component';
import { InputTextModule } from 'primeng/components/inputtext/inputtext';
import { ButtonModule } from 'primeng/components/button/button';
import { DataTableModule } from 'primeng/datatable';
import { TooltipModule } from 'primeng/components/tooltip/tooltip';
import { CalendarModule } from 'primeng/components/calendar/calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SelectButtonModule } from 'primeng/selectbutton';

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
  ],
  declarations: [
    TransactionSearchComponent,
    TransactionSaveComponent],
  exports: [
    TransactionSearchComponent,
    TransactionSaveComponent
  ]
})
export class TransactionsModule { }
