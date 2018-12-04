import { Component, OnInit, ViewChild } from '@angular/core';

import { LazyLoadEvent, ConfirmationService } from 'primeng/components/common/api';
import { ToastyService } from 'ng2-toasty';

import { ErrorHandlerService } from './../../core/error-handler.service';
import { ClientFilter, ClientService } from './../client.service';

@Component({
  selector: 'app-clients-search',
  templateUrl: './clients-search.component.html',
  styleUrls: ['./clients-search.component.css']
})
export class ClientsSearchComponent {

  totalRecords = 0;
  filter = new ClientFilter();
  clients = [];
  @ViewChild('tabela') grid;

  constructor(
    private clientService: ClientService,
    private errorHandler: ErrorHandlerService,
    private confirmation: ConfirmationService,
    private toasty: ToastyService
  ) { }

  find(page = 0) {
    this.filter.page = page;

    this.clientService.find(this.filter)
      .then(result => {
        this.totalRecords = result.total;
        this.clients = result.clients;
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  onPageChange(event: LazyLoadEvent) {
    const page = event.first / event.rows;
    this.find(page);
  }

  confirmDelete(client: any) {
    this.confirmation.confirm({
      message: 'Are you sure you want to remove this item?',
      accept: () => {
        this.delete(client);
      }
    });
  }

  delete(client: any) {
    this.clientService.delete(client.id)
      .then(() => {
        if (this.grid.first === 0) {
          this.find();
        } else {
          this.grid.first = 0;
        }

        this.toasty.success('Client updated successfully!');
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

}
