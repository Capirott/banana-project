import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-transaction-search',
  templateUrl: './transaction-search.component.html',
  styleUrls: ['./transaction-search.component.css']
})
export class TransactionSearchComponent {
  transactions = [
    { amount: 2.5, client: { name: 'ciclano' }, transactionType: 'TRANSF', operationDate: new Date(2018, 11, 4)},
    { amount: 5.0, client: { name: 'fulano' }, transactionType: 'DEPOSIT', operationDate: new Date(Date.now()) },
    { amount: 2.5, client: { name: 'ciclano' }, transactionType: 'TRANSF', operationDate: new Date(Date.now()) },
    { amount: 5.0, client: { name: 'fulano' }, transactionType: 'DEPOSIT', operationDate: new Date(Date.now()) },
    { amount: 5.0, client: { name: 'fulano' }, transactionType: 'DEPOSIT', operationDate: new Date(Date.now()) },
    { amount: 5.0, client: { name: 'fulano' }, transactionType: 'DEPOSIT', operationDate: new Date(Date.now()) },
    { amount: -5.0, client: { name: 'fulano' }, transactionType: 'WITHDRAWAL', operationDate: new Date(Date.now()) },
  ];


}
