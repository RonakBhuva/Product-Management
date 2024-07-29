import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutes } from "./app.routes";

import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';
import { AdminDashboardComponent } from "./admin-dashboard/admin-dashboard.component";
import { AppComponent } from "./app.component";
import { JwtInterceptor } from "./jwt.interceptor";
import { LoginComponent } from "./login/login.component";
import { ProductFormComponent } from "./product-form/product-form.component";
import { ProductListComponent } from "./product-list/product-list.component";
import { UserDashboardComponent } from "./user-dashboard/user-dashboard.component";
import { RouterOutlet } from "@angular/router";

@NgModule({
    declarations: [
        AppComponent,
        LoginComponent,
        ProductListComponent,
        ProductFormComponent,
        UserDashboardComponent,
        AdminDashboardComponent
    ],
    imports: [
        BrowserModule,
        AppRoutes,
        HttpClientModule,
        FormsModule,
        RouterOutlet
    ],
    // providers: [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
