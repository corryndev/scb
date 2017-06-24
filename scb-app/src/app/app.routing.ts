import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

export const ROUTES: Routes = [
  
  { path: '', redirectTo: 'site', pathMatch: 'full'},
  { path: 'login', redirectTo: 'login'}
];

export const APP_ROUTES: ModuleWithProviders = RouterModule.forRoot(ROUTES);