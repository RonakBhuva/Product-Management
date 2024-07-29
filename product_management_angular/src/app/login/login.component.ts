import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) { }

  login() {
    this.authService.login({ username: this.username, password: this.password }).subscribe((response: any) => {
      localStorage.setItem('token', response.token);
      const role = this.authService.hasRole('ADMIN') ? 'admin-dashboard' : 'user-dashboard';
      this.router.navigate([role]);
    }, error => {
      alert('Invalid credentials');
    });
  }

}
