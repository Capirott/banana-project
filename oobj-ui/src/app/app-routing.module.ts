import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PageNotFoundComponent } from './core/page-not-found.component';
import { ClientsSearchComponent } from './clients/clients-search/clients-search.component';
import { ClientSaveComponent } from './clients/client-save/client-save.component';
import { TransactionsSearchComponent } from './transactions/transactions-search/transactions-search.component';
import { TransactionSaveComponent } from './transactions/transaction-save/transaction-save.component';


const routes: Routes = [
  { path: '', redirectTo: 'clients', pathMatch: 'full' },
  { path: 'clients', component: ClientsSearchComponent },
  { path: 'clients/new', component: ClientSaveComponent },
  { path: 'clients/:id', component: ClientSaveComponent },
  { path: 'transactions', component: TransactionsSearchComponent },
  { path: 'transactions/:id', component: TransactionSaveComponent },
  { path: 'page-not-found', component: PageNotFoundComponent },
  { path: '**', redirectTo: 'page-not-found' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
