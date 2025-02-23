import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";
import { AuthService } from "./auth.service";

Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {
    constructor(private authService: AuthService, private router: Router) { }

    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): boolean {
        const expectedRole = route.data['role'];
        const token = localStorage.getItem('token');

        if (!this.authService.isAuthenticated() || !this.authService.hasRole(expectedRole)) {
            this.router.navigate(['login']);
            return false;
        }

        return true;
    }
}