import { Routes, RouterModule }  from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { LoginComponent } from './login.component';

const ROUTES: Routes = [{
    
    path: 'login',
    component: LoginComponent}
    
];
export const LOGIN_ROUTE: ModuleWithProviders = RouterModule.forChild(ROUTES);