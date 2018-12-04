export class Address {
  zipcode: string;
  street: string;
  city: string;
  state: string;
}

export class Client {
  id: number;
  name: string;
  address = new Address();
  phoneNumber: string;
  cpf: string;
}

export class Agency {
  id: number;
  address = new Address();
  name: string;
}

export class Account {
  id: number;
  address = new Address();
  name: string;
  agency = new Agency();
  client = new Client();
  accountType = 'CURRENT';
}

export class Transaction {
  id: number;
  transactionType = 'DEPOSIT';
  descricao: string;
  operationDate: Date;
  amount: number;
  account: Account;
  sourceAccount: Account;
  accountDestination: Account;
}
