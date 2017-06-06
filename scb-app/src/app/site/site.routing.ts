import { Routes, RouterModule }  from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { SiteComponent} from './site.component';

import { HomeComponent} from './home/home.component';
import { CalendarComponent} from './calendar/calendar.component';

const ROUTES: Routes = [{
    
    path: 'site',
    component: SiteComponent,
    children: [
        { path: '', redirectTo: 'home', pathMatch: 'full' },
        { path: 'home', component: HomeComponent },
        { path: 'calendar', component: CalendarComponent },
    ]}
    
];
export const SITE_ROUTES: ModuleWithProviders = RouterModule.forChild(ROUTES);