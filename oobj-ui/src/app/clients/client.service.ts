import { URLSearchParams, Response, RequestOptions, Headers, Http } from '@angular/http';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';

import { environment } from './../../environments/environment';
import { Client } from './../core/model';

export class ClientFilter {
  name: string;
  page = 0;
  itensPerPage = 5;
}

@Injectable()
export class ClientService {

  clientsUrl: string;

  constructor(private http: Http) {
    this.clientsUrl = `${environment.apiUrl}/clients`;
  }

  find(filter: ClientFilter): Promise<any> {
    const params = new URLSearchParams();

    params.set('page', filter.page.toString());
    params.set('size', filter.itensPerPage.toString());

    if (filter.name) {
      params.set('name', filter.name);
    }

    return this.http.get(`${this.clientsUrl}`, { search: params })
      .toPromise()
      .then(response => {
        const responseJson = response.json();
        const clients = responseJson.content;

        const result = {
          clients,
          total: responseJson.totalElements
        };

        return result;
      })
  }

  delete(id: number): Promise<void> {
    return this.http.delete(`${this.clientsUrl}/${id}`)
      .toPromise()
      .then(() => null);
  }

  create(client: Client): Promise<Client> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post(this.clientsUrl, JSON.stringify(client), { headers })
      .toPromise()
      .then(response => response.json());
  }

  update(client: Client): Promise<Client> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put(`${this.clientsUrl}/${client.id}`,
      JSON.stringify(client), {headers})
      .toPromise()
      .then(response => response.json() as Client);
  }

  findById(id: number): Promise<Client> {
    return this.http.get(`${this.clientsUrl}/${id}`)
      .toPromise()
      .then(response => response.json() as Client);
  }

}
