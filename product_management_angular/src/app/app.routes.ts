import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductListComponent } from './product-list/product-list.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'user-dashboard', component: UserDashboardComponent, canActivate: [AuthGuard], data: { role: 'USER' } },
    { path: 'admin-dashboard', component: AdminDashboardComponent, canActivate: [AuthGuard], data: { role: 'ADMIN' } },
    { path: 'products', component: ProductListComponent, canActivate: [AuthGuard], data: { role: 'USER' } },
    { path: 'add-product', component: ProductFormComponent, canActivate: [AuthGuard], data: { role: 'ADMIN' } },
    { path: 'edit-product/:id', component: ProductFormComponent, canActivate: [AuthGuard], data: { role: 'ADMIN' } },
    { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutes { }