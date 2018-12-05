import { Title } from '@angular/platform-browser';
import { Component, OnInit, ViewChild } from '@angular/core';

import { LazyLoadEvent, ConfirmationService } from 'primeng/components/common/api';
import { ToastyService } from 'ng2-toasty';

import { ErrorHandlerService } from './../../core/error-handler.service';
import { TransactionService, TransactionFilter } from './../transaction.service';

@Component({
  selector: 'app-transactions-search',
  templateUrl: './transactions-search.component.html',
  styleUrls: ['./transactions-search.component.css']
})
export class TransactionsSearchComponent implements OnInit {

  totalRegistros = 0;
  filtro = new TransactionFilter();
  transactions = [];
  @ViewChild('tabela') grid;

  constructor(
    private transactionService: TransactionService,
    private errorHandler: ErrorHandlerService,
    private toasty: ToastyService,
    private confirmation: ConfirmationService,
    private title: Title
  ) { }

  ngOnInit() {
    this.title.setTitle('Transactions Search');
  }

  find(page = 0) {
    this.filtro.page = page;

    this.transactionService.find(this.filtro)
      .then(resultado => {
        this.totalRegistros = resultado.total;
        this.transactions = resultado.transactions;
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  onPageChange(event: LazyLoadEvent) {
    const page = event.first / event.rows;
    this.find(page);
  }

  confirmarExclusao(transaction: any) {
    this.confirmation.confirm({
      message: 'Are you sure you want to delete?',
      accept: () => {
        this.excluir(transaction);
      }
    });
  }

  excluir(transaction: any) {
    this.transactionService.delete(transaction.id)
      .then(() => {
        if (this.grid.first === 0) {
          this.find();
        } else {
          this.grid.first = 0;
        }

        this.toasty.success('Transaction saved successfuly!');
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

}
