import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TemplateModule } from './_template/template.module';

import { SITE_ROUTES} from './site.routing';
import { SiteComponent } from './site.component';

import { HomeComponent } from './home/home.component';
import { CalendarComponent } from './calendar/calendar.component';

@NgModule({
  imports: [
    CommonModule,
    TemplateModule,
    SITE_ROUTES
  ],
  declarations: [SiteComponent, HomeComponent, CalendarComponent]
})
export class SiteModule { }
