import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Appointment } from './appointment';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';

@Injectable()
export class CalendarService {

  private endpoint = 'http://localhost:8080/scb/api/appointments';

  constructor(private http: Http) {

  }

  public getOpenAppointments(): Observable<Appointment[]> {
    return this.http.get(this.endpoint + "/open")
      .map(response =>  response.json() as Appointment[]);
  }
}
