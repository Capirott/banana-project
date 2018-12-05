import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-transaction-save',
  templateUrl: './transaction-save.component.html',
  styleUrls: ['./transaction-save.component.css']
})
export class TransactionSaveComponent implements OnInit {

  transactionTypes = [
    { label: 'Deposit', value: 'DEPOSIT' },
    { label: 'Transfer', value: 'TRANSFER' },
    { label: 'Withdrawal', value: 'WITHDRAWAL' }
  ];

  constructor() { }

  ngOnInit() {
  }

}
