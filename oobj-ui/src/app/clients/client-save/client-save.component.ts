import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

import { ToastyService } from 'ng2-toasty';

import { ErrorHandlerService } from './../../core/error-handler.service';
import { ClientService } from './../client.service';
import { Client } from './../../core/model';

@Component({
  selector: 'app-client-save',
  templateUrl: './client-save.component.html',
  styleUrls: ['./client-save.component.css']
})
export class ClientSaveComponent implements OnInit {

  client = new Client();

  constructor(
    private clientService: ClientService,
    private toasty: ToastyService,
    private errorHandler: ErrorHandlerService,
    private route: ActivatedRoute,
    private router: Router,
    private title: Title
  ) { }

  ngOnInit() {
    const idClient = this.route.snapshot.params['id'];

    this.title.setTitle('Nova client');

    if (idClient) {
      this.carregarClient(idClient);
    }
  }

  get editando() {
    return Boolean(this.client.id)
  }

  carregarClient(id: number) {
    this.clientService.findById(id)
      .then(client => {
        this.client = client;
        this.updateTitle();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  save(form: FormControl) {
    if (this.editando) {
      this.updateClient(form);
    } else {
      this.addClient(form);
    }
  }

  addClient(form: FormControl) {
    this.clientService.create(this.client)
      .then(clientAdded => {
        this.toasty.success('Client created successfully!');
        this.router.navigate(['/clients', clientAdded.id]);
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  updateClient(form: FormControl) {
    this.clientService.update(this.client)
      .then(client => {
        this.client = client;

        this.toasty.success('Client alterada com sucesso!');
        this.updateTitle();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  resetForm(form: FormControl) {
    form.reset();

    setTimeout(function() {
      this.client = new Client();
    }.bind(this), 1);

    this.router.navigate(['/clients/new']);
  }

  updateTitle() {
    this.title.setTitle(`Editing client: ${this.client.name}`);
  }

}
