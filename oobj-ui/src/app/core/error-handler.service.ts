import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { Response } from '@angular/http';

import { ToastyService } from 'ng2-toasty';

@Injectable()
export class ErrorHandlerService {

  constructor(
    private toasty: ToastyService,
    private router: Router
  ) { }

  handle(errorResponse: any) {
    let msg: string;

    if (typeof errorResponse === 'string') {
      msg = errorResponse;

    } else if (errorResponse instanceof Response
      && errorResponse.status >= 400 && errorResponse.status <= 499) {
      let errors;
      msg = 'Ocurred an error while trying to process your request. Try again.';

      if (errorResponse.status === 403) {
        msg = 'You don\'t have permission to execute this action';
      }

      try {
        errors = errorResponse.json();

        msg = errors[0].message;
      } catch (e) { }

      console.error('Error', errorResponse);

    } else {
      msg = 'Ocurred an error while trying to process remote service. Try again.';
      console.error('Error', errorResponse);
    }

    this.toasty.error(msg);
  }

}
