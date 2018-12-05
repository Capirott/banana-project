import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { TransactionSaveComponent } from './transaction-save/transaction-save.component';
import { TransactionsSearchComponent } from './transactions-search/transactions-search.component';

const routes: Routes = [
  {
    path: 'transaction',
    component: TransactionsSearchComponent,
  },
  {
    path: 'transaction/new',
    component: TransactionSaveComponent,
  },
  {
    path: 'transaction/:id',
    component: TransactionSaveComponent,
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class TransactionsRoutingModule { }
