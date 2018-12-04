import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-client-search',
  templateUrl: './client-search.component.html',
  styleUrls: ['./client-search.component.css']
})
export class ClientSearchComponent {

  transactions = [
    { amount: 2.5, client: { name: 'ciclano' }, transactionType: 'TRANSF', operationDate: '06/30/2018'},
    { amount: 5.0, client: { name: 'fulano' }, transactionType: 'DEPOSIT', operationDate: '06/24/2018'},
    { amount: 2.5, client: { name: 'ciclano' }, transactionType: 'TRANSF', operationDate: '06/30/2018'},
    { amount: 5.0, client: { name: 'fulano' }, transactionType: 'DEPOSIT', operationDate: '06/24/2018'},
    { amount: 5.0, client: { name: 'fulano' }, transactionType: 'DEPOSIT', operationDate: '06/24/2018'},
    { amount: 5.0, client: { name: 'fulano' }, transactionType: 'DEPOSIT', operationDate: '06/24/2018'},
    { amount: -5.0, client: { name: 'fulano' }, transactionType: 'WITHDRAWAL', operationDate: '06/24/2018'},
  ];

}
