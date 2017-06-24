import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from './user/user.service';
import { CalendarService } from './calendar/calendar.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers: [UserService, CalendarService]
})
export class SharedModule { }
