import { Component, OnInit } from '@angular/core';
import { CalendarService } from '../../_shared/calendar/calendar.service';
import { Appointment} from '../../_shared/calendar/appointment';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss'],
})
export class CalendarComponent implements OnInit {

  appointments: Appointment[];

  constructor(private calendarService: CalendarService) {
   
  }
  ngOnInit(){
     this.calendarService.getOpenAppointments().subscribe(appointment => this.appointments = appointment, error => console.error(error));
  }
}
