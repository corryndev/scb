import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { User } from './user';

@Injectable()
export class UserService {

  private endpoint = 'http://localhost:8080/scb/api/auth';
  private user_key = 'user';
  private user_token_key = 'user_authToken';

  /**
   * Constructor
   */
  constructor(private http: Http) { 

  }

  /**
   * authenticate the given user
   * 
   * @param name the name
   * @param password the password
   */
  public authenticate(name: string, password: string) {
    return this.http.get(this.endpoint, new RequestOptions({ headers: new Headers({ 'name': name, 'password': password }) })).subscribe(
      (response) => {
        let user: User = response.json();
        sessionStorage.setItem(this.user_key, JSON.stringify(user));
        sessionStorage.setItem(this.user_token_key, response.headers.get('Authorization'));
      },
      error => console.log(error)
    );
  }

  /**
   * get the logged in user
   * 
   * @return the user
   */
  public get(): User {
    let account = sessionStorage.getItem(this.user_key);
    if (account == null) {
      return null;
    }
    return JSON.parse(account);
  }
}
