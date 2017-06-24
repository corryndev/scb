import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import { LOGIN_ROUTE} from './login.routing';

@NgModule({
  imports: [
    CommonModule,
    LOGIN_ROUTE
  ],
  declarations: [LoginComponent]
})
export class LoginModule { }
