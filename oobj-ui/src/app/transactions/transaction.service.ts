import { URLSearchParams, Response, RequestOptions, Headers, Http } from '@angular/http';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';

import { environment } from './../../environments/environment';
import { Transaction } from './../core/model';

export class TransactionFilter {
  accountOwnerName: string;
  page = 0;
  itensPerPage = 5;
}

@Injectable()
export class TransactionService {

  transactionsUrl: string;

  constructor(private http: Http) {
    this.transactionsUrl = `${environment.apiUrl}/transactions`;
  }

  find(filter: TransactionFilter): Promise<any> {
    const params = new URLSearchParams();

    params.set('page', filter.page.toString());
    params.set('size', filter.itensPerPage.toString());

    if (filter.accountOwnerName) {
      params.set('accountOwnerName', filter.accountOwnerName);
    }

    return this.http.get(`${this.transactionsUrl}`, { search: params })
      .toPromise()
      .then(response => {
        const responseJson = response.json();
        const transactions = responseJson.content;

        const result = {
          transactions,
          total: responseJson.totalElements
        };

        return result;
      });
  }

  delete(id: number): Promise<void> {
    return this.http.delete(`${this.transactionsUrl}/${id}`)
      .toPromise()
      .then(() => null);
  }

  create(transaction: Transaction): Promise<Transaction> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post(this.transactionsUrl, JSON.stringify(transaction), { headers })
      .toPromise()
      .then(response => response.json());
  }

  update(transaction: Transaction): Promise<Transaction> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put(`${this.transactionsUrl}/${transaction.id}`,
      JSON.stringify(transaction), {headers})
      .toPromise()
      .then(response => response.json() as Transaction);
  }

  findById(id: number): Promise<Transaction> {
    return this.http.get(`${this.transactionsUrl}/${id}`)
      .toPromise()
      .then(response => response.json() as Transaction);
  }

}
